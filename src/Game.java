import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.*;
import acm.program.GraphicsProgram;



public class Game extends GraphicsProgram implements ActionListener, KeyListener {
	
	
	private Maps curMapName = Maps.MAP1;
	private Map curMap;
	
	public void init() {
		curMap = new Map(this, curMapName);
	}
	
	public void transition(Maps newMap, int startPos) {
		
	}
	
	
	public void run() {
		
	}
}
