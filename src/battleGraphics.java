import acm.program.*;
import acm.graphics.*;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;



public class battleGraphics extends GraphicsProgram {
    private int screenWidth  = 720;
    private int screenHeight = 560;
    
    
    private GImage battleScreen ;
    private GImage fighticon;
    private GImage bagicon;
    

    public void init() {
        setSize(screenWidth, screenHeight);  
        addKeyListeners();                   
        requestFocus();                      
    }

  
    public void run() {
       
    	battleScreen = new GImage("battle.png");  
    	battleScreen.setSize(720,180);
    	battleScreen.setLocation(0,380);
        add(battleScreen);
        
        fighticon = new GIm
       
        // Enable mouse interaction
        addMouseListeners();                  // This will allow mouse click events
    }

    // Handle mouse click events (when user clicks on the screen)
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("Mouse clicked at: (" + x + ", " + y + ")");
    }

    // Main method to launch the program
    public static void main(String[] args) {
    	 new battleGraphics().start();  
    }

}