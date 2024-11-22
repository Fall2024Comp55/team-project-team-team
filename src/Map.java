import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.*;
import acm.program.GraphicsProgram;



public class Map extends GraphicsProgram implements ActionListener, KeyListener {
	public static final int SCREEN_TILES_WIDTH = 5;
	public static final int SCREEN_TILES_HEIGHT = 5;
	public static final int MAX_STEPS = 20;
	public static final int TILE_RESOLUTION = 16;
	public static final int SCALE_FACTOR = 5;
	
	private int tileSize     = TILE_RESOLUTION * SCALE_FACTOR;
	private int screenWidth  = tileSize * SCREEN_TILES_WIDTH;
	private int screenHeight = tileSize * SCREEN_TILES_HEIGHT;
	
	
	public Timer timer = new Timer(1000, this);
	private GImage userPlayer = new GImage("media/placeholderCharacter.png");
	
	private PlayerTrainer userP = new PlayerTrainer();
	
	private Maps map;
	private Game game;
	private GPoint nextPos = new GPoint(0,0);
	private ArrayList<GImage> tiles = new ArrayList<GImage>();
	private ArrayList<ArrayList<Space>> spaces = new ArrayList<ArrayList<Space>>();
	private GImage nextTile;
	
	private boolean movable = true;
	private int playerXOffset = 0;
	private int playerYOffset = 0;
	private int playerX;
	private int playerY;
	
	/* unused variables
	private int numTimes;
	private int labelX =0, labelY = 0;
	private GImage grassBackground = new GImage("media/grassBackground.jpg");
	private GLabel myLabel;
	*/
	
	Map(Game game, Maps map) {
		this.game = game;
		this.map = map;
		init();
	}
	
	public void remove() {
		for(GImage x : tiles) {
			remove(x);
		}
		remove(userPlayer);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
	public void init() {
		setSize(tileSize * SCREEN_TILES_WIDTH, tileSize * SCREEN_TILES_HEIGHT);
		
		int col = 0;
		int row = 0;
		for(Space[] x : map.spaceMap) {
			System.out.println("adding line");
			spaces.add(new ArrayList<Space>());
			for(Space y : x) {
				nextTile = new GImage(y.tile);
				nextTile.scale(tileSize / nextTile.getWidth());
				nextTile.setLocation(nextPos.getX() - (nextTile.getWidth() - tileSize), nextPos.getY() - (nextTile.getHeight() - tileSize));
				add(nextTile);
				spaces.get(row).add(y);
				tiles.add(nextTile);
				nextPos.translate(tileSize, 0);
				col++;
			}
			nextPos.translate(-16 * col * SCALE_FACTOR, 16 * SCALE_FACTOR);
			col = 0;
			row++;
		}
		
		add(userPlayer);
		
		userPlayer.scale(SCALE_FACTOR);
		userPlayer.setLocation(tileSize * map.startX, tileSize * map.startY);
		
		moveBackground(-1 * tileSize * (map.startX - (int)(SCREEN_TILES_WIDTH/2)), -1 * tileSize * (map.startY - SCREEN_TILES_HEIGHT + 1));
		movePlayer(-1 * tileSize * (map.startX - (int)(SCREEN_TILES_WIDTH/2)), -1 * tileSize * (map.startY - SCREEN_TILES_HEIGHT + 1));
		
		playerXOffset = (screenWidth/2 - (int)userPlayer.getX())/tileSize;
		playerYOffset = (screenHeight/2 - (int)userPlayer.getY())/tileSize - 1;
		playerX = map.startX;
		playerY = map.startY;
		
		System.out.println(playerXOffset);
		System.out.println(playerYOffset);
		
		
		addKeyListeners();
		requestFocus();
		
		
		/*
		add(grassBackground);
		grassBackground.scale(2);
		add(userPlayer);
		grassBackground.setLocation(labelX, labelY);
		userPlayer.setLocation(labelX, labelY);
		userPlayer.scale(0.2);
		userPlayer.setLocation(450, 200);
		*/
	}
	
	public void moveBackground(int x, int y) {
		for(GImage z : tiles) {
			z.move(x, y);
		}
	}
	
	public void movePlayer(int x, int y) {
		userPlayer.move(x, y);
	}
	
	public void move(Direction direction) {
		switch(direction) {
		case UP:
			if(spaces.get(playerY-1).get(playerX).walkable) {
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
			System.out.println(playerY);
			break;
		case DOWN:
			if(spaces.get(playerY+1).get(playerX).walkable) {
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
			System.out.println(playerY);
			break;
		case LEFT:
			if(spaces.get(playerY).get(playerX-1).walkable) {
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
			System.out.println(playerX);
			break;
		case RIGHT:
			if(spaces.get(playerY).get(playerX+1).walkable) {
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
			System.out.println(playerX);
			break;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(movable) {
			movable = false;
			int keyCode = e.getKeyCode();
			
			switch(keyCode) {
			case KeyEvent.VK_W://up
				move(Direction.UP);
				userP.setDirection(Direction.UP);
				System.out.println(userP.getDirection());
				break;
			case KeyEvent.VK_S://down
				move(Direction.DOWN);
				userP.setDirection(Direction.DOWN);
				System.out.println(userP.getDirection());
				break;
			case KeyEvent.VK_A://left
				move(Direction.LEFT);
				userP.setDirection(Direction.LEFT);
				System.out.println(userP.getDirection());
				break;
			case KeyEvent.VK_D://right
				move(Direction.RIGHT);
				userP.setDirection(Direction.RIGHT);
				System.out.println(userP.getDirection());
				break;
			}
			movable = true;
		}
	}
	
	public void run() {
		
		
		timer.start();
	}
	
	
	public static void main(String[] args) {
		new Map(game, map).start();
	}
	
}


