import java.awt.Color;
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


public class Map extends GraphicsProgram implements KeyListener, MouseListener {
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
	
	private GImage userPlayer = new GImage("walkingDown2.png");
	
	private GImage titleScreen = new GImage("media/monsterBattleTitleScreen3.png");
	private GImage playButton = new GImage("media/playButton.png");
	private GImage bagButton = new GImage("media/bagicon.png");
	private GImage bagUI = new GImage("bagUIList.png");
	private GImage bagUILeft = new GImage("bagUILeftSide.png");
	private GRect closeBagButton = new GRect(20,20);
	private GLabel closeBagLabel = new GLabel("X");
	private int bagOpenCallCount = 0;
	private Timer hoverTimer;
	private boolean hoverUp = true; // Determines the hover direction (up or down)
	private int hoverOffset = 0; // Current vertical offset for the hover animation
	private final int HOVER_STEP = 1; // Amount to move per frame
	private final int HOVER_LIMIT = 10; // Maximum offset for the hover
	
	private PlayerTrainer userP = new PlayerTrainer();
	
	private Bag playerBag; 
	private int selectedIndex = -1; // Tracks the index of the currently selected item
	private ArrayList<Item> displayedItems; // Items currently displayed in the current tab
	private String[] tabs = {"Heal", "Ball", "Badge"}; // Tabs in the bag
	private int currentTabIndex = 0; // Tracks the current tab index
	private GLabel[] itemLabels; // Array of labels for displayed items
	private boolean bagIsOpen = false;
	
	
	
	 // Display the title screen with a play button
    private void showTitleScreen() {
        add(titleScreen);
        titleScreen.setSize(getWidth(), getHeight());
        preloadSounds();
        playBackgroundMusic(titleMusic);
        // Create a transparent play button
       // playButton = new GRect(getWidth() / 2 - 50, getHeight() / 2 + 100, 100, 50);
        //playButton.setFilled(true);
        playButton.setColor(null); // Transparent button
        playButton.setLocation(400,450);
        add(playButton);
        
        // Start hover animation for the play button
        startHoverAnimation();
    }
    
 private void showBagMenu() {
	// System.out.println("openBag() called");
	    //Thread.dumpStack(); // Prints the call stack to see where the call is coming from
	   
    	//System.out.println("bag opening");
    	playerBag = userP.getBag();
    	bagIsOpen = true;
    	  // Display header
        //GLabel header = new GLabel("Bag: " + tabs[currentTabIndex], 100, 100);
       // GRect selected = new GRect(10, 10);
       // selected.setColor(Color.GREEN);
        //add(header);
        add(bagUI);
        add(bagUILeft);
        bagUI.setLocation(100, 100);
        //bagUI.setColor(Color.cyan);
        bagUILeft.setLocation(10, 100);
        add(closeBagButton);
        closeBagButton.setLocation(225,250);
        closeBagButton.setColor(Color.RED);
        closeBagButton.setFilled(true);
        closeBagButton.setFillColor(Color.RED);
        add(closeBagLabel);
        closeBagLabel.setLocation(230,265);
        System.out.println("added close button");
        
        
        displayedItems = playerBag.getItems();
        itemLabels = new GLabel[displayedItems.size()];
        int yOffset = 100;
        int i = 0;
        for(Item item: displayedItems) {
        	GLabel itemLabel = new GLabel(item.getName() + " x" + item.getAmount(), 125, yOffset+20);
        	itemLabel.setColor(Color.BLACK); // Default text color
        	add(itemLabel);
        	itemLabels[i] = itemLabel; // Store the label for updating later
        	i++;
        	yOffset += 30;
        	 
        }
        
        if (!displayedItems.isEmpty()) {
            selectedIndex = 0;
            highlightItem(selectedIndex);
        }
        
        System.out.println("added close button2");
    	
    }
 // Highlight the selected item
    private void highlightItem(int index) {
        for (int i = 0; i < itemLabels.length; i++) {
            itemLabels[i].setColor(Color.BLACK); // Reset all labels
        }
        if (index >= 0 && index < itemLabels.length) {
            itemLabels[index].setColor(Color.GREEN); // Highlight selected item
        }
    }
    
 // Handle key press events
  
    
    
	
    private void startHoverAnimation() {
    	hoverTimer = new Timer(100, e -> {
            if (hoverUp) {
                hoverOffset += HOVER_STEP;
                if (hoverOffset >= HOVER_LIMIT) {
                    hoverUp = false; // Reverse direction
                }
            } else {
                hoverOffset -= HOVER_STEP;
                if (hoverOffset <= 0) {
                    hoverUp = true; // Reverse direction
                }
            }

            // Apply the offset to the button's position
            playButton.setLocation(400, 450 + hoverOffset);
        });
        hoverTimer.start();
		
	}
    
 // Stop the hover animation when transitioning to the game
    private void stopHoverAnimation() {
        if (hoverTimer != null) {
            hoverTimer.stop();
        }
    }


	// Start the game when the play button is clicked
    private void startGame() {
        currentPage = "Map"; // Update the state
        remove(titleScreen);
        remove(playButton);

        stopHoverAnimation(); // Stop hover animation

        
        // Initialize the game elements
        createMap();
        addPlayer();
        adjustMap();
        //addMouseListeners();
        add(bagButton);
        
        
      //currentPage = "Map";
		
        playSpecificSound();
      		
      	
    }
   
   
	
	private void closeBag() {
		  // Remove all UI components related to the bag menu
        remove(bagUI);
        remove(bagUILeft);
        remove(closeBagButton);
        remove(closeBagLabel);
        
        for(GLabel itemL: itemLabels) {
        	remove(itemL);
        	
        	
        	
        	System.out.println("removed: " + itemL);
        	
        }
        selectedIndex = -1;
        System.out.println(itemLabels.length);
        bagIsOpen = false;
	}




	//backgroundMusic
	private Clip battleMusic;
	private Clip lobbyMusic;
	private Clip titleMusic;
	
	//sfx
	private Clip dirtPathSound;
	private Clip normalGrassSound;
	private Clip mouseClickSound;
	
	//currentBackgroundMusic
	private Clip currMusic = titleMusic;
	
	
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
	private String currentPage = "TITLE";
	
	
	//movement images/logic
	private int animationFrame = 0; // Current animation frame
	private int animationDelay = 0; // To slow down the frame switch rate
	private final int ANIMATION_DELAY_THRESHOLD = 0; // Adjust for slower/faster animation
	private String[] walkingUpFrames = {"walkingUp1.png", "walkingUp2.png", "walkingUp3.png"};
	private String[] walkingDownFrames = {"walkingDown1.png", "walkingDown2.png", "walkingDown3.png"};
	private String[] walkingLeftFrames = {"walkingLeft1.png", "walkingLeft2.png", "walkingLeft3.png"};
	private String[] walkingRightFrames = {"walkingRight1.png", "walkingRight2.png", "walkingRight3.png"};
	
	
	
	
	
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
	//preload soundss
	public void preloadSounds() {
		titleMusic = createClip("media/monsterBall.wav");
		battleMusic = createClip("media/Pokemon Black & White 2 OST Trainer Battle Music.wav");
		lobbyMusic = createClip("media/Pokemon Black & White Music： Driftveil City Music.wav");
		dirtPathSound = createClip("media/walkOnDirt 1.wav");
		normalGrassSound = createClip("media/walkOnGrass1.wav");
		mouseClickSound = createClip("media/MouseClickSound2.wav");
		
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
		else if(currMusic == titleMusic) {
			stopSound(currMusic);
			setVolume(titleMusic, 0.5f);
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
	        setVolume(dirtPathSound, 1f);
	        dirtPathSound.start();
	        dirtPathSound.setFramePosition(0);
	            break;
	        case "grass":
	        	 setVolume(normalGrassSound, 1f);
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
	
	//animation logic
	private void animateWalking(String[] frames) {
	    if (frames == null || frames.length == 0) return;

	    // Slow down animation by only changing frames after a delay
	    if (animationDelay >= ANIMATION_DELAY_THRESHOLD) {
	        animationFrame = (animationFrame + 1) % frames.length;
	        userPlayer.setImage(frames[animationFrame]);
	        userPlayer.scale(tileSize / userPlayer.getWidth()*5);
	        animationDelay = 0; // Reset delay
	    } else {
	        animationDelay++;
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
		showTitleScreen();
		requestFocus();
		
		//currentPage = "Map";
		
		//createMap();
		//addPlayer();
		//adjustMap();
		//preloadSounds();
		//playSpecificSound();
	}
	
	
	  @Override
	    public void mouseClicked(MouseEvent e) {
	        if (currentPage.equals("TITLE")) {
	            GPoint click = new GPoint(e.getX(), e.getY());
	            if (playButton.contains(click)) {
	            	//mouseClickSound.setFramePosition(0);
	            	mouseClickSound.start();
	            	
	                startGame();
	            }
	        }else if (currentPage.equals("Map")) {
	            // Check if bag button was clicked
	        	GPoint click1 = new GPoint(e.getX(), e.getY());
	        	if (bagButton != null && bagButton.contains(click1)) {
	               // System.out.println("Opening bag...");
	                mouseClickSound.start();
	                showBagMenu();
	                System.out.println("checking");
	            }
	        	GPoint click2 = new GPoint(e.getX(), e.getY());
	        	if (closeBagLabel.contains(click2)) {
	        		//mouseClickSound.setFramePosition(0);
	        		mouseClickSound.start();
	        	
	            	closeBag();
	            	System.out.println("Closing bag..");
	          
	        	}
	        }
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
		
		add(bagButton);
	}
	
	public void addPlayer() {
		int startX = map.starts[spawn][0];
		int startY = map.starts[spawn][1];

		userPlayer.scale(tileSize / userPlayer.getWidth()*5);
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
		  String[] frames = null;
		switch(direction) {
		case UP:
			
			//userPlayer.setImage("walkingUp2.png");
			frames = walkingUpFrames;
			animateWalking(frames);
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
			//userPlayer.setImage("TrainerD.png");
			frames = walkingDownFrames;
			animateWalking(frames);
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
			//userPlayer.setImage("TrainerL.png");
			frames = walkingLeftFrames;
			animateWalking(frames);
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
			//userPlayer.setImage("TrainerR.png");
			frames = walkingRightFrames;
			animateWalking(frames);
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
		   // add(bagButton);
		    
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
		if (!bagIsOpen) return;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (selectedIndex > 0 && bagIsOpen) {
                    selectedIndex--;
                    highlightItem(selectedIndex);
                }
                break;

            case KeyEvent.VK_DOWN:
                if (selectedIndex < displayedItems.size() - 1 && bagIsOpen) {
                    selectedIndex++;
                    highlightItem(selectedIndex);
                }
                break;
            case KeyEvent.VK_ENTER:
                if (selectedIndex >= 0 && selectedIndex < displayedItems.size() && bagIsOpen) {
                    useSelectedItem();
                }
                break;
        }
	}
	 
	private void useSelectedItem() {
		 Item selectedItem = displayedItems.get(selectedIndex);
		    System.out.println("Using " + selectedItem.getName());

		    // Apply the item's effect
		    selectedItem.use(userP.getTeam().getFirst()); // Assuming `use()` is implemented in Item class

		    // Update bag contents
		   // playerBag.removeItem(selectedItem); // Assuming `removeItem()` is in Bag
		    refreshBagMenu(); // Refresh the menu
	}

	private void refreshBagMenu() {
		 	closeBag();
	        //remove(bagUI);
	        //remove(bagUILeft);
	    showBagMenu(); // Re-render the menu
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
	
	public void openTitleScreen() {
		
	}
	public static void main(String[] args) {
		new Map().start();
		
	}
	
}