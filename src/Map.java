import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.event.MenuKeyEvent;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Map extends GraphicsProgram implements KeyListener {
	public static final int SCREEN_TILES_WIDTH = 11;
	public static final int SCREEN_TILES_HEIGHT = 9;
	public static final int MAX_STEPS = 20;
	public static final int TILE_RESOLUTION = 16;
	public static final int SCALE_FACTOR = 5;
	
	private int tileSize     = TILE_RESOLUTION * SCALE_FACTOR;
	private int screenWidth  = tileSize * SCREEN_TILES_WIDTH;
	private int screenHeight = tileSize * SCREEN_TILES_HEIGHT;
	
	public Timer timer = new Timer(1000, this);
	public Random rand = new Random();
	
	private GImage userPlayer = new GImage("TrainerD.png");
	private PlayerTrainer userP = new PlayerTrainer();
	
	//backgroundMusic
	private Clip battleMusic;
	private Clip lobbyMusic;
	
	//sfx
	private Clip dirtPathSound;
	private Clip normalGrassSound;
	private Clip mouseClickSound;
	
	//currentBackgroundMusic
	private Clip currMusic = lobbyMusic;
	
	
	//private Clip 
	
	private Maps map = Maps.HOMETOWN;
	private int spawn = 0;
	private GPoint nextPos = new GPoint(0,0);
	private ArrayList<GImage> tiles = new ArrayList<GImage>();
	private ArrayList<ArrayList<Space>> spaces = new ArrayList<ArrayList<Space>>();
	private GImage nextTile;
	private GImage enemyTile;
	
	private boolean movable = true;
	private int playerXOffset = 0;
	private int playerYOffset = 0;
	private int playerX;
	private int playerY;
	
	private battleGraphics battle;
	private String currentPage;
	
	/* unused variables
	private int numTimes;
	private int labelX =0, labelY = 0;
	private GImage grassBackground = new GImage("media/grassBackground.jpg");
	private GLabel myLabel;
	*/
	
	public void playSound(String filePath, Clip clip, boolean loop) {
        try {
        	if(clip != null && clip.isRunning()) {clip.stop();}
            // Load the audio file
            File soundFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            
            
            //get or reuse the clip
            if(clip == null) {
            	clip = AudioSystem.getClip();
            }
            
            
            //open audio stream and start playback
            clip.open(audioStream);
            clip.start();
            
            //if loop
            if(loop) {
            	clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
	
	public void setVolume(Clip clip, float volume) {
	    if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
	        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

	        // Convert volume percentage (0.0 to 1.0) to decibels
	        float min = gainControl.getMinimum(); // Lowest possible volume (e.g., -80.0 dB)
	        float max = gainControl.getMaximum(); // Highest possible volume (e.g., 6.0 dB)
	        float newVolume = min + (max - min) * volume; // Scale volume to dB range

	        // Set the volume
	        gainControl.setValue(newVolume);
	    } else {
	        System.out.println("Volume control not supported.");
	    }
	}
	
	//Stop a currently playing clip
	public void stopSound(Clip clip) {
		if(clip != null && clip.isRunning()) {
			clip.stop();
		}
	}
	
	
	
	private Clip createClip(String filepath) {
		try {
	        File soundFile = new File(filepath);
	        AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioStream);
	        return clip;
	    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	//preload sounds
	public void preloadSounds() {
		battleMusic = createClip("media/Pokemon Black & White 2 OST Trainer Battle Music.wav");
		lobbyMusic = createClip("media/Pokemon Black & White Music： Driftveil City Music.wav");
		dirtPathSound = createClip("media/walkOnDirt 1.wav");
		normalGrassSound = createClip("media/walkOnGrass1.wav");
		mouseClickSound = createClip("media/Mouse Click Sound Effect.wav");
		
	}
	
	
	public void playBackgroundMusic(Clip newMusic) {
	    // Stop the current music
		if(currMusic == lobbyMusic) {
			stopSound(currMusic);
		}
		else if(currMusic == battleMusic){
			stopSound(currMusic);
			
			currMusic.setFramePosition(-1000);
		}
	    

	    // Play the new music
	    currMusic = newMusic;
	    if (currMusic != null) {
	    	currMusic.loop(Clip.LOOP_CONTINUOUSLY);
	    }
	}
	
	
	public void playStepSound(String terrainType) {
	    switch (terrainType.toLowerCase()) {
	        case "dirt":
	        setVolume(dirtPathSound, 0.75f);
	        dirtPathSound.start();
	        dirtPathSound.setFramePosition(0);
	            break;
	        case "grass":
	        	 setVolume(normalGrassSound, 0.75f);
	            normalGrassSound.start();
	            normalGrassSound.setFramePosition(0);
	            break;
	        default:
	            System.out.println("Unknown terrain type: " + terrainType);
	    }
	}
	
	public void playSpecificSound() {
		switch (currentPage) {
        case "Map":
            playBackgroundMusic(lobbyMusic);
            setVolume(lobbyMusic, 0.5f);
            break;
        case "Battle":
        	System.out.println("playingBattleMusic");
        	stopSound(battleMusic);
            playBackgroundMusic(battleMusic);
            break;
        default:
            stopSound(currMusic); // Stop music if no valid page
            System.out.println("No music for page: " + currentPage);
    }
	}
	
	
	public void clearMap() {
		removeAll();
		tiles.clear();
		spaces.clear();
		nextPos.setLocation(0, 0);
	}
	
	public void init() {
		setSize(tileSize * SCREEN_TILES_WIDTH, tileSize * SCREEN_TILES_HEIGHT);
		addKeyListeners();
		addMouseListeners();
		requestFocus();
		
		currentPage = "Map";
		
		createMap();
		addPlayer();
		adjustMap();
		preloadSounds();
		playSpecificSound();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void createMap() {
		int col = 0;
		int row = 0;
		for(Space[] x : map.spaceMap) {
			System.out.println("adding line");
			spaces.add(new ArrayList<Space>());
			for(Space y : x) {
				spaces.get(row).add(y);
				nextTile = new GImage(y.tile.image);
				nextTile.scale(tileSize / nextTile.getWidth());
				nextTile.setLocation(nextPos.getX() - (nextTile.getWidth() - tileSize), nextPos.getY() - (nextTile.getHeight() - tileSize));
				add(nextTile);
				if(y.enemy != null) {
					switch(y.enemy.facing) {
					case UP:    enemyTile = new GImage("TrainerU.png"); break;
					case DOWN:  enemyTile = new GImage("TrainerD.png"); break;
					case LEFT:  enemyTile = new GImage("TrainerL.png"); break;
					case RIGHT: enemyTile = new GImage("TrainerR.png"); break;
					}
					enemyTile.scale(tileSize / enemyTile.getWidth());
					enemyTile.setLocation(nextPos.getX() - (enemyTile.getWidth() - tileSize), nextPos.getY() - (enemyTile.getHeight() - tileSize));
					add(enemyTile);
					tiles.add(enemyTile);
					spaces.get(row).get(col).walkable = false;
				}
				tiles.add(nextTile);
				nextPos.translate(tileSize, 0);
				col++;
			}
			nextPos.translate(-16 * col * SCALE_FACTOR, 16 * SCALE_FACTOR);
			col = 0;
			row++;
		}
		
	}
	
	public void addPlayer() {
		int startX = map.starts[spawn][0];
		int startY = map.starts[spawn][1];

		userPlayer.scale(tileSize / userPlayer.getWidth());
		userPlayer.setLocation(tileSize * startX, tileSize * startY);
		add(userPlayer);

		playerX = startX;
		playerY = startY;
		
		moveBackground(-1 * tileSize * (startX - (int)(SCREEN_TILES_WIDTH/2)), -1 * tileSize * (startY - (int)(SCREEN_TILES_HEIGHT/2)));
		movePlayer(-1 * tileSize * (startX - (int)(SCREEN_TILES_WIDTH/2)), -1 * tileSize * (startY - (int)(SCREEN_TILES_HEIGHT/2)));
		
		System.out.println(playerXOffset);
		System.out.println(playerYOffset);
		
		
	}
	
	public void adjustMap() {
		if(tiles.get(0).getX() > 0) {
			moveAll(-(int)tiles.get(0).getX(), 0);
		}
		if(tiles.get(0).getY() > 0) {
			moveAll(0, -(int)tiles.get(0).getY());
		}
		if(tiles.get(tiles.size()-1).getX() < screenWidth - tileSize) {
			moveAll((screenWidth - tileSize) - (int)tiles.get(tiles.size()-1).getX(), 0);
		}
		if(tiles.get(tiles.size()-1).getY() < screenHeight - tileSize) {
			moveAll(0, (screenHeight - tileSize) - (int)tiles.get(tiles.size()-1).getY());
		}
		
		playerXOffset = (int)(SCREEN_TILES_WIDTH / 2) - (int)(userPlayer.getX() / tileSize);
		playerYOffset = (int)(SCREEN_TILES_HEIGHT / 2) - (int)(userPlayer.getY() / tileSize);
		
		for(int x = 0; x < (SCREEN_TILES_HEIGHT/2 + playerYOffset); x++) {
			for(int y = 0; y < map.spaceMap[0].length; y++) {
				userPlayer.sendBackward();
			}
		}
	}
	
	public void reInit(MapName newMap, int spawn) {
		clearMap();
		switch(newMap) {
		case HOMETOWN: this.map = Maps.HOMETOWN; break;
		case ROUTE1: this.map = Maps.ROUTE1; break;
		case GYM: this.map = Maps.GYM; break;
		}
		this.spawn = spawn;
		createMap();
		addPlayer();
		adjustMap();
	}
	
	public void moveBackground(int x, int y) {
		for(GImage z : tiles) {
			z.move(x, y);
		}
	}
	
	public void movePlayer(int x, int y) {
		userPlayer.move(x, y);
	}
	
	public void moveAll(int x, int y) {
		moveBackground(x, y);
		movePlayer(x, y);
	}
	
	public void move(Direction direction) {
		switch(direction) {
		case UP:
			userPlayer.setImage("TrainerU.png");
			if(playerY > 0 && spaces.get(playerY-1).get(playerX).walkable) {
				if(playerYOffset < 0 || tiles.get(0).getY() >= 0) {
					for(int i = 0; i < TILE_RESOLUTION; i++) {
						movePlayer(0, -SCALE_FACTOR);
					}
					playerYOffset += 1;
				} else {
					for(int i = 0; i < TILE_RESOLUTION; i++) {
						moveBackground(0, SCALE_FACTOR);
					}
				}
				playerY--;
				for(int x = 0; x < map.spaceMap[0].length; x++) {
					userPlayer.sendBackward();
				}
			}
			break;
		case DOWN:
			userPlayer.setImage("TrainerD.png");
			if(playerY < spaces.size()-1 && spaces.get(playerY+1).get(playerX).walkable) {
				if(playerYOffset > 0 || tiles.get(tiles.size()-1).getY() <= screenHeight - tileSize) {
					for(int i = 0; i < TILE_RESOLUTION; i++) {
						movePlayer(0, SCALE_FACTOR);
					}
					playerYOffset -= 1;
				} else {
					for(int i = 0; i < TILE_RESOLUTION; i++) {
						moveBackground(0, -SCALE_FACTOR);
					}
				}
				playerY++;
				for(int x = 0; x < map.spaceMap[0].length; x++) {
					userPlayer.sendForward();
				}
			}
			break;
		case LEFT:
			userPlayer.setImage("TrainerL.png");
			if(playerX > 0 && spaces.get(playerY).get(playerX-1).walkable) {
				if(playerXOffset > 0 || tiles.get(0).getX() >= 0) {
					for(int i = 0; i < TILE_RESOLUTION; i++) {
						movePlayer(-SCALE_FACTOR, 0);
					}
					playerXOffset -= 1;
				} else {
					for(int i = 0; i < TILE_RESOLUTION; i++) {
						moveBackground(SCALE_FACTOR, 0);
					}
				}
				playerX--;
			}
			break;
		case RIGHT:
			userPlayer.setImage("TrainerR.png");
			if(playerX < spaces.get(0).size()-1 && spaces.get(playerY).get(playerX+1).walkable) {
				if(playerXOffset < 0 || tiles.get(tiles.size()-1).getX() <= screenWidth - tileSize) {
					for(int i = 0; i < TILE_RESOLUTION; i++) {
						movePlayer(SCALE_FACTOR, 0);
					}
					playerXOffset += 1;
				} else {
					for(int i = 0; i < TILE_RESOLUTION; i++) {
						moveBackground(-SCALE_FACTOR, 0);
					}
				}
				playerX++;
			}
			break;
		}
		Space newSpace = spaces.get(playerY).get(playerX);
		if(newSpace.sightline != null) {
			System.out.println(newSpace.sightline.name);
			setTrainerEncounter(newSpace.sightline);
		}
		if(newSpace.destination != null) {
			reInit(newSpace.destination, newSpace.spawn);
		}
		if(newSpace.tile == Tile.TALLGRASS) {
			setWildEncounter();
		}
		if(newSpace.tile == Tile.PATH) {
			playStepSound("dirt");
		}
		if(newSpace.tile == Tile.GRASS) {
			playStepSound("grass");
		}
	}
	
	public void setWildEncounter() {
		System.out.println("On Tall Grass!!!");
		// Define the threshold for an encounter (e.g., 20% chance)
		if (rand.nextInt(100) < 20) { // Adjust 20 to your desired encounter rate
		    // pick a random monster
			SpeciesType[] all = SpeciesType.values();
			int x = rand.nextInt(all.length);
			Monster wildMon = new Monster(all[x], userP.getTeam().get(0).getLevel());
			// Start the battle
			battle = new battleGraphics(this, userP, wildMon);
		    battle.init();
		    battle.run();
		    currentPage = "Battle";
		    playSpecificSound();
		    //battleMusic.stop();
		    //playSound("media/Pokemon Black & White 2 OST Trainer Battle Music.wav");
		}
	}
	
	public void setTrainerEncounter(Trainers opponent) {
		battle = new battleGraphics(this, userP, new Trainer(opponent));
		battle.init();
	    battle.run();
	    currentPage = "Battle";
	    playSpecificSound();
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
	    if (currentPage != null && currentPage.equals("Battle")) {
	        battle.mousePressed(e);  
	    }
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (currentPage == "Battle") {
			return;
		}
		
		if(movable) {
			movable = false;
			int keyCode = e.getKeyCode();
			
			switch(keyCode) {
			case KeyEvent.VK_W://up
				move(Direction.UP);
				userP.setDirection(Direction.UP);
				break;
			case KeyEvent.VK_S://down
				move(Direction.DOWN);
				userP.setDirection(Direction.DOWN);
				break;
			case KeyEvent.VK_A://left
				move(Direction.LEFT);
				userP.setDirection(Direction.LEFT);
				break;
			case KeyEvent.VK_D://right
				move(Direction.RIGHT);
				userP.setDirection(Direction.RIGHT);
				break;
			}
			movable = true;
		}
	}
	 
	public void endBattle() {
		 battle = null;
		currentPage = "Map";
		playSpecificSound();
		//battleMusic.stop();
		//playSound("media/Pokemon Black & White Music： Driftveil City Music.wav");
	}
	
	
	public void run() {
		
		
		timer.start();
		
	}
	
	
	public static void main(String[] args) {
		new Map().start();
		
	}
	
}
