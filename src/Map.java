import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.*;
import acm.program.GraphicsProgram;
// e


public class Map extends GraphicsProgram implements ActionListener, KeyListener{
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int MAX_STEPS = 20;
	public static final double SCALE_FACTOR = 5.00;
	private int numTimes ;
	public Timer timer = new Timer(1000, this);
	private GLabel myLabel;
	private GImage userPlayer = new GImage("media/user2BackProfile.png");
	private GImage grassBackground = new GImage("media/grassBackground.jpg");
	private int labelX =0, labelY = 0;
	private PlayerTrainer userP = new PlayerTrainer();
	
	private Maps map = Maps.MAP1;
	private GPoint nextPos = new GPoint(0,0);
	private ArrayList<GImage> tiles = new ArrayList<GImage>();
	private GImage nextTile;
	
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		int count = 0;
		for(Space[] x : map.spaceMap) {
			System.out.println("adding line");
			for(Space y : x) {
				nextTile = new GImage(y.tile);
				nextTile.scale(SCALE_FACTOR);
				nextTile.setLocation(nextPos);
				add(nextTile);
				tiles.add(nextTile);
				nextPos.translate(16 * SCALE_FACTOR, 0);
				count++;
			}
			nextPos.translate(-16 * count * SCALE_FACTOR, 16 * SCALE_FACTOR);
			count = 0;
		}
		
		/*
		add(grassBackground);
		grassBackground.scale(2);
		add(userPlayer);
		grassBackground.setLocation(labelX, labelY);
		userPlayer.setLocation(labelX, labelY);
		userPlayer.scale(0.2);
		addKeyListeners();
		requestFocus();
		userPlayer.setLocation(450, 200);
		*/
	}
	
	public void move(Direction direction) {
		switch(direction) {
		case UP:
			for(int i = 0; i < 16; i++) {
				
			}
		case DOWN:
			
		case LEFT:
			
		case RIGHT:
			
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		switch(keyCode) {
		case KeyEvent.VK_W://up
			move(Direction.UP);
			userP.setDirection(Direction.UP);
			System.out.println(userP.getDirection());
			System.out.println("Moving Up");
			break;
		case KeyEvent.VK_S://down
			userP.setDirection(Direction.DOWN);
			System.out.println(userP.getDirection());
			System.out.println("Moving Down");
			break;
		case KeyEvent.VK_A://left
			userP.setDirection(Direction.LEFT);
			System.out.println(userP.getDirection());
			System.out.println("Moving Left");
			break;
		case KeyEvent.VK_D://right
			userP.setDirection(Direction.RIGHT);
			System.out.println(userP.getDirection());
			System.out.println("Moving Right");
			break;
		}
		grassBackground.setLocation(labelX, labelY);
		
	}
	
	public void run() {
		
		
		timer.start();
	}
	
	public static void main(String[] args) {
		new Map().start();
	}
}


