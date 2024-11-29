import acm.program.*;
import acm.graphics.*;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;



public class battleGraphics extends GraphicsProgram {
	
	PlayerTrainer playerTrainer;
	Trainer enemy ;
	
    private int screenWidth  = 720;
    private int screenHeight = 560;
    
    private GImage background;
    
    private GImage battleScreen ;
    private GImage fighticon;
    private GImage bagicon;
    private GImage Monstericon;
    private GImage runicon;
    
    private GImage bscreen;
    private GImage exit;
    private GImage move1;
    private GImage move2;
    private GImage move3;
    private GImage move4;
    
    private GImage trainterMon;
    private GImage playerMon;
    
    public void setplayer(PlayerTrainer playerTrainer,Trainer enemy  ) {
       this.playerTrainer = playerTrainer;
       this.enemy = enemy;
    }
    

    public void init() {
        setSize(screenWidth, screenHeight);  
        addKeyListeners();                   
        requestFocus();                      
    }
    
    
    public void clearIconsB() {
        if (fighticon != null) {
            remove(fighticon);
            fighticon = null; 
        }
        if (bagicon != null) {
            remove(bagicon);
            bagicon = null;  
        }
        if (Monstericon != null) {
            remove(Monstericon);
            Monstericon = null;  
        }
        if (runicon != null) {
            remove(runicon);
            runicon = null;  
        }
        if (battleScreen != null) {
            remove(battleScreen);
            battleScreen = null;  
        }
    }
    
    
    public void setupMainB() {
        
        
        battleScreen = new GImage("battle.png");  
        battleScreen.setSize(720, 180);
        battleScreen.setLocation(0, 380);
        
        bagicon = new GImage("bagicon.png"); 
        bagicon.setSize(210, 90);
        bagicon.setLocation(520, 400);
        
        fighticon = new GImage("fighticon.png"); 
        fighticon.setSize(210, 90);
        fighticon.setLocation(340, 390);
        
        Monstericon = new GImage("Monstericon.png"); 
        Monstericon.setSize(210, 90);
        Monstericon.setLocation(335, 470);
        
        runicon = new GImage("runicon.png"); 
        runicon.setSize(210, 90);
        runicon.setLocation(510, 470);
        
        
        add(battleScreen);
        add(fighticon);
        add(bagicon);
        add(Monstericon);
        add(runicon);
    }
    
    public void clearIconsF() {
       
    	if (bscreen != null) {
            remove(bscreen);
            bscreen = null; 
        }
        if (exit != null) {
            remove(exit);
            exit = null;  
        }
        if (move1 != null) {
            remove(move1);
            move1 = null;  
        }
        if (move2 != null) {
            remove(move2);
            move2 = null;  
        }
        if (move3 != null) {
            remove(move3);
            move3 = null; 
        }
        
        if (move4 != null) {
            remove(move4);
            move4 = null; 
        }
    }
    
    public void setupMainF() {
    	clearIconsB();
    	
    	bscreen = new GImage("Battle_Moves.png"); 
    	bscreen.setSize(720,180);
    	bscreen.setLocation(0,380);
    	
    	exit = new GImage("exit.png"); 
    	exit.setSize(165,165);
    	exit.setLocation(545,390);
    	
    	move1 = new GImage("move.png"); 
    	move1.setSize(265,90);
    	move1.setLocation(5,385);
    	
    	move2 = new GImage("move.png"); 
    	move2.setSize(265,90);
    	move2.setLocation(5,467);
    	
    	move3 = new GImage("move.png"); 
    	move3.setSize(265,90);
    	move3.setLocation(273,467);
    	
    	move4 = new GImage("move.png"); 
    	move4.setSize(265,90);
    	move4.setLocation(273,385);
    	
        add(bscreen);
        add(exit); 
        add(move1);
        add(move2);
        add(move3);
        add(move4);
       
    }
    
   
  
    public void run() {
    	background = new GImage("grassbackground.png"); 
    	background.setSize(720,390);
    	add(background);
    	
    	background = new GImage("grassbackground.png"); 
    	background.setSize(720,390);
    	add(background);
    	
    	background = new GImage("grassbackground.png"); 
    	background.setSize(720,390);
    	add(background);
    		
    	setupMainB();
    	
    	if (playerTrainer != null && enemy != null) {
            trainterMon = enemy.getTeam().getFirst().getImage();
            playerMon = playerTrainer.getTeam().get(0).getImage();
            
            add(trainterMon);
            add(playerMon);
        }
        
        addMouseListeners();
    	
    	
    	
        addMouseListeners();    
        
    }
    

  
    public void mousePressed(MouseEvent e) {
    	int x = e.getX();
        int y = e.getY();
        
        if (runicon != null && runicon.contains(x, y)) {
            clearIconsB(); 
            
            
            if (background != null) {
            	remove(background);
            	background = null;
            }
            if(trainterMon != null) {
            	remove(trainterMon);
            	trainterMon = null;
            }
            if(playerMon != null) {
            	remove(playerMon);
            	playerMon = null;
            }
           

        }
        
        if (fighticon != null && fighticon.contains(x, y)) {
            setupMainF();  
        }
        
        if (exit != null && exit.contains(x, y)) {
            clearIconsF(); 
            setupMainB(); 
        }
        
        if (bagicon != null && bagicon.contains(x, y)) {
            // Handle Bag icon click (not implemented here)
        }
        if (Monstericon != null && Monstericon.contains(x, y)) {
            // Handle Monster icon click (not implemented here)
        }
   
        System.out.println("Mouse clicked at: (" + x + ", " + y + ")");
    }
    
  
    

    // Main method to launch the program
    public static void main(String[] args) {
    	PlayerTrainer playerTrainer = new PlayerTrainer();
	    Monster playerMonster = new Monster(SpeciesType.SPIDER,5);
	    playerMonster.addmove(Move.TACKLE);
	    playerMonster.addmove(Move.EMBER);
	    
	    // Add the monster to the player's team
	    playerTrainer.addMon(playerMonster);	
	    
	    
	    Trainer opponentTrainer = new Trainer();
	    Monster opponentMonster = new Monster(SpeciesType.FLAMECLAW,5);
	    opponentMonster.addmove(Move.FLAMETHROWER);
	    opponentMonster.addmove(Move.EMBER);
	    opponentTrainer.addMon(opponentMonster);
	    
	    
    	  battleGraphics s = new battleGraphics();
    	  s.setplayer(playerTrainer,opponentTrainer);
    	  s.start();
    }

}