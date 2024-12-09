import acm.program.*;
import acm.graphics.*;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;


public class battleGraphics  {
    
	private Map map;
	private double screenSizeX;
	private double screenSizeY;
	
    Trainer player;
    Trainer opponent;
    Monster playerMonster;
    Monster opponentMonster;
    Monster wildMonster;
    
    private GImage playerMonsterSprite;
    private GImage opponentMonsterSprite;
    
    private GImage background;
    private GImage battleScreen;
    
    private GImage fighticon;
    //private GImage Monstericon;
    //private GImage bagicon;
    private GImage runicon;
    
    private GImage bscreen;
    private GImage exit;
    
    private GImage move1;
    private GImage move2;
    private GImage move3;
    private GImage move4;
    
    private GLabel move1Description;
    private GLabel move2Description;
    private GLabel move3Description;
    private GLabel move4Description;
    
    String  Pheath = "";
	String  Whealth = "";
	String Ohealth =  "";
	GLabel OpponetHealth;
	GLabel Playerhealth;
	GLabel WildMonsterHealth;
    private static final String labelFont = "Arial-Bold-22";
    
    private boolean isPlayerTurn;
    
    private final Timer timer = new Timer();
    
    public battleGraphics(Map map, Trainer player, Trainer opponent) {
    	
    	
    	this.map = map;
    	this.screenSizeX = map.getWidth();
    	this.screenSizeY = map.getHeight();
    	
    	this.player = player;
    	this.opponent = opponent;
    	this.playerMonster = player.getTeam().get(0);
    	this.opponentMonster = opponent.getTeam().get(0);
    	
    	this.playerMonsterSprite = player.getTeam().get(0).getBackSprite();
    	this.opponentMonsterSprite = opponent.getTeam().get(0).getFrontSprite();
    	/*
    	Pheath = Integer.toString(playerMonster.getCurHealth());
    	Ohealth =  Integer.toString(opponentMonster.getCurHealth());
    	OpponetHealth = new GLabel( "Health: " + Ohealth); 
    	Playerhealth = new GLabel( "Health: " + Pheath);
    	*/
    }
    
    public battleGraphics(Map map, Trainer player, Monster wildMonster) {
    	
    	System.out.println(wildMonster.getMoves().size());
    	
    	this.map = map;
    	this.screenSizeX = map.getWidth();
    	this.screenSizeY = map.getHeight();
    	
    	this.player = player;
    	this.wildMonster = wildMonster;
    	
    	this.playerMonster = player.getTeam().get(0);
    	System.out.println(playerMonster.getMoves().size());
    	
    
    	
    	this.playerMonsterSprite = player.getTeam().get(0).getBackSprite();
    	this.opponentMonsterSprite = wildMonster.getFrontSprite();
    	
    	/*
    	 Pheath = Integer.toString(playerMonster.getCurHealth());
    	 Whealth =  Integer.toString(wildMonster.getCurHealth());
    	 WildMonsterHealth = new GLabel( "Health: " + Whealth); 
    	 Playerhealth = new GLabel( "Health: " + Pheath);
    	 */
    	 
    }
    
    public void init() {
    	this.background = new GImage("grassBackground.png");
    	this.battleScreen = new GImage("battle.png");
    	
    	this.fighticon = new GImage("fighticon.png");
    	//this.Monstericon = new GImage("Monstericon.png");
    	//this.bagicon = new GImage("bagicon.png");
    	this.runicon = new GImage("runicon.png");
    	
    	this.bscreen = new GImage("Battle_Moves.png");
    	this.exit = new GImage("exit.png");
    	
    	this.move1 = new GImage("move.png");
    	this.move2 = new GImage("move.png");
    	this.move3 = new GImage("move.png");
    	this.move4 = new GImage("move.png");
    	
    	this.move1Description = new GLabel(player.getTeam().get(0).getMoves().get(0).name);
    	this.move2Description = new GLabel(player.getTeam().get(0).getMoves().get(1).name);
    	this.move3Description = new GLabel(player.getTeam().get(0).getMoves().get(2).name);
    	this.move4Description = new GLabel(player.getTeam().get(0).getMoves().get(3).name);
    	
       // addKeyListeners();                   
        //requestFocus();                      
    }
    
   

    
    public void clearIconsB() {
    	map.remove(battleScreen);
    	
    	 map.remove(fighticon);
    	
        //map.remove(bagicon);
        //map.remove(Monstericon);
        map.remove(runicon);
        map.remove(battleScreen);
    }

    public void setupMainB() {
        battleScreen = new GImage("battle.png");  
        battleScreen.setSize(880, 200); 
        battleScreen.setLocation(0, 520); 
        
        /*bagicon = new GImage("bagicon.png"); 
        bagicon.setSize(250, 100);
        bagicon.setLocation(635, 540);*/
        
        fighticon = new GImage("fighticon.png"); 
        fighticon.setSize(260, 180);
        fighticon.setLocation(415, 530); // Adjust location for new screen size
        
        /*Monstericon = new GImage("Monstericon.png"); 
        Monstericon.setSize(250, 100);
        Monstericon.setLocation(415, 620); // Adjust location for new screen size*/
        
        runicon = new GImage("runicon.png"); 
        runicon.setSize(255, 185);
        //runicon.setLocation(630, 620); // Adjust location for new screen size
        runicon.setLocation(623, 535);
        
        map.add(battleScreen);
        map.add(fighticon);
        //map.add(bagicon);
        //map.add(Monstericon);
        map.add(runicon);
    }
    

    public void clearIconsF() {
        	map.remove(bscreen);
        	map.remove(exit);
        	map.remove(move1);
        	map.remove(move2);
        	map.remove(move3);  
        	map.remove(move4);
        	map.remove(move1Description);
        	map.remove(move2Description);
        	map.remove(move3Description);
        	map.remove(move4Description);
    }

    public void setupMainF() {
        clearIconsB();
        
        
        bscreen.setSize(880, 200); 
        bscreen.setLocation(0, 520); 
        
        exit = new GImage("exit.png"); 
        exit.setSize(200, 180);
        exit.setLocation(670, 530); 
        
        move1 = new GImage("move.png"); 
        move1.setSize(327, 98);
        move1.setLocation(5, 530); 
        
        move2 = new GImage("move.png"); 
        move2.setSize(327, 98);
        move2.setLocation(330, 530); 
        
        move3 = new GImage("move.png");
        move3.setSize(327, 98);
        move3.setLocation(5, 620);
        
        move4 = new GImage("move.png"); 
        move4.setSize(327, 98);
        move4.setLocation(330, 620);
        
        move1Description.setFont(labelFont);
        move1Description.setLocation(125, 585);
        
        move2Description.setFont(labelFont);
        move2Description.setLocation(460, 585);
        
        move3Description.setFont(labelFont);
        move3Description.setLocation(115, 675);
        
        move4Description.setFont(labelFont);
        move4Description.setLocation(410, 675);
        
        map.add(bscreen);
        map.add(exit); 
        map.add(move1);
        map.add(move2);
        map.add(move3);
        map.add(move4);
        map.add(move1Description);
        map.add(move2Description);
        map.add(move3Description);
        map.add(move4Description);
    }

    public void run() {
    	background.setSize(screenSizeX ,  screenSizeY - 200);
        map.add(background);
        
        setupMainB();
        
        playerMonsterSprite.setSize(50, 50);
        playerMonsterSprite.setLocation(200, 460); 
        map.add(playerMonsterSprite);
        
        opponentMonsterSprite.setSize(50, 50);
        opponentMonsterSprite.setLocation(630, 280);
        map.add(opponentMonsterSprite);
       
        
        if ( opponentMonster == null) {
        	 
        	
        	  Pheath = Integer.toString(playerMonster.getCurHealth());
        	  Whealth =  Integer.toString(wildMonster.getCurHealth());
        	        
        	  		WildMonsterHealth = new GLabel( "Health: " + Whealth); 
        	  		WildMonsterHealth.setFont("Arial-Bold-24");  
        	  		WildMonsterHealth.setColor(Color.BLACK); 
        	  		WildMonsterHealth.setLocation(600, 240);  
        	        map.add(WildMonsterHealth);
        	       
        	        Playerhealth = new GLabel( "Health: " + Pheath);
        	        Playerhealth.setFont("Arial-Bold-24");  
        	        Playerhealth.setColor(Color.BLACK); 
        	        Playerhealth.setLocation(180, 420);
        	        map.add(Playerhealth);
        }else {
        	
       	 	
       	 	
        	 Pheath = Integer.toString(playerMonster.getCurHealth());
        	 Ohealth =  Integer.toString(opponentMonster.getCurHealth());
        	        
        	        OpponetHealth = new GLabel( "Health: " + Ohealth); 
        	        OpponetHealth.setFont("Arial-Bold-24");  
        	        OpponetHealth.setColor(Color.BLACK); 
        	        OpponetHealth.setLocation(600, 240);  
        	        map.add(OpponetHealth);
        	       
        	        Playerhealth = new GLabel(Pheath);
        	        Playerhealth.setFont("Arial-Bold-24");  
        	        Playerhealth.setColor(Color.BLACK); 
        	        Playerhealth.setLocation(180, 420);
        	        map.add(Playerhealth);
        }
       
        
       // addMouseListeners();
    }
  
    
    
    public void updateHealthbar() {
    	
    	 if ( opponentMonster == null) {
         	map.remove(WildMonsterHealth);
         	map.remove(Playerhealth);
         	System.out.println("removed");
         	
         	
         	  Pheath = Integer.toString(playerMonster.getCurHealth());
         	  Whealth =  Integer.toString(wildMonster.getCurHealth());
         	        
         	        WildMonsterHealth = new GLabel( "Health: " + Whealth); 
         	        WildMonsterHealth.setFont("Arial-Bold-24");  
         	        WildMonsterHealth.setColor(Color.BLACK); 
         	        WildMonsterHealth.setLocation(600, 240);  
         	        map.add(WildMonsterHealth);
         	       
         	         Playerhealth = new GLabel( "Health: " + Pheath);
         	        Playerhealth.setFont("Arial-Bold-24");  
         	        Playerhealth.setColor(Color.BLACK); 
         	        Playerhealth.setLocation(180, 420);
         	        map.add(Playerhealth);
         	        
         	      
         }else {
         	map.remove(OpponetHealth);
         	map.remove(Playerhealth);
         	
         	
         	 Pheath = Integer.toString(playerMonster.getCurHealth());
         	 Ohealth =  Integer.toString(opponentMonster.getCurHealth());
         	        
         	        OpponetHealth = new GLabel( "Health: " + Ohealth); 
         	        OpponetHealth.setFont("Arial-Bold-24");  
         	        OpponetHealth.setColor(Color.BLACK); 
         	        OpponetHealth.setLocation(600, 240);  
         	        map.add(OpponetHealth);
         	       
         	        Playerhealth = new GLabel(Pheath);
         	        Playerhealth.setFont("Arial-Bold-24");  
         	        Playerhealth.setColor(Color.BLACK); 
         	        Playerhealth.setLocation(180, 420);
         	        map.add(Playerhealth);
         	        
         }	
    	
    }
    
    
    public void mousePressed(MouseEvent e) {
    	
    	int x = e.getX();
        int y = e.getY();
        
       

        if (playerMonster.getCurHealth() == 0 ) {
        	HealMonsterScreen();
        	return;
        	
        }
        
        
        
        
        
        if ( map.getElementAt(x, y) == fighticon ) {
        	
            setupMainF(); 
            return;
        } 
        
        
     
          if((map.getElementAt(x, y) == move1 || map.getElementAt(x, y) == move1Description)  &&  playerMonster.getMoves().size() > 0  && playerMonster.getCurHealth() != 0) {
        	if (opponentMonster == null  ) {
        		 Move move = playerMonster.getMoves().get(0);
                 int damage = move.calculateDamage(playerMonster, wildMonster);   
                 System.out.println(move.getName());
                 moveAnimation(move.getName());
                 playerMonster.updateHP(-damage);
                 
                 Move move2 = wildMonster.selectRandomMove();
                 System.out.println(move2.getName());
                 int damage2 = move2.calculateDamage(wildMonster, playerMonster);

                
                 timer.schedule(new TimerTask() {
                     @Override
                     public void run() {
                    	 wildMonster.updateHP(-damage2);
                         moveAnimationTrainer(move2.getName());
                        
                     }
                 }, 2000); 
                 
                 
                 updateHealthbar();
                 
                 clearIconsF(); 
                 setupMainB(); 
        		
        	}else {
        		Move move = playerMonster.getMoves().get(0);
            	int damage = move.calculateDamage(playerMonster, opponentMonster);
            	moveAnimation(playerMonster.getMoves().get(0).getName());
            	playerMonster.updateHP(-damage);
            	   
            	Move move2 = opponentMonster.selectRandomMove();
                int damage2 = move2.calculateDamage(opponentMonster, playerMonster);
                
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                    	 opponentMonster.updateHP(-damage2);
                         moveAnimationTrainer(move2.getName());
                    }
                }, 2000); 
                
                updateHealthbar();
                clearIconsF(); 
                setupMainB(); 
        	}
        	 
        }
        
       
        if((map.getElementAt(x, y) == move2 || map.getElementAt(x, y) == move2Description)  &&  playerMonster.getMoves().size() > 1   && playerMonster.getCurHealth() != 0) {
        	if (opponentMonster == null  ) {
        		Move move = playerMonster.getMoves().get(1);
            	int damage = move.calculateDamage(playerMonster, wildMonster);
            	System.out.println(move.getName());
            	moveAnimation(playerMonster.getMoves().get(1).getName());
            	playerMonster.updateHP(-damage);
            	
            	Move move2 = wildMonster.selectRandomMove();
            	 System.out.println(move2.getName());
                int damage2 = move2.calculateDamage(wildMonster, playerMonster);
               
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                    	 wildMonster.updateHP(-damage2);
                    	moveAnimationTrainer(move2.getName());
                
                    }
                }, 2000);
                
                updateHealthbar();
                clearIconsF(); 
                setupMainB(); 
                
        	}else {
        		clearIconsF(); 
                setupMainB(); 
        		Move move = playerMonster.getMoves().get(1);
            	int damage = move.calculateDamage(playerMonster, opponentMonster);
            	System.out.println(move.getName());
            	moveAnimation(playerMonster.getMoves().get(1).getName());
            	playerMonster.updateHP(-damage);
            	
            	Move move2 = opponentMonster.selectRandomMove();
            	System.out.println(move2.getName());
                int damage2 = move2.calculateDamage(opponentMonster, playerMonster);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                    	 opponentMonster.updateHP(-damage2);
                         moveAnimationTrainer(move2.getName());
                    }
                }, 2000); 
                updateHealthbar();
                clearIconsF(); 
                setupMainB(); 
                
        	}
        	
            
        }
        
       
        if((map.getElementAt(x, y) == move3 || map.getElementAt(x, y) == move3Description)  &&  playerMonster.getMoves().size() > 2   && playerMonster.getCurHealth() != 0) {
        	if (opponentMonster == null  ) {
        		Move move = playerMonster.getMoves().get(2);
            	int damage = move.calculateDamage(playerMonster, wildMonster);
            	System.out.println(move.getName());
            	moveAnimation(playerMonster.getMoves().get(2).getName());
            	playerMonster.updateHP(-damage);
            	
            	
            	Move move2 = wildMonster.selectRandomMove();
            	System.out.println(move2.getName());
                int damage2 = move2.calculateDamage(wildMonster, playerMonster);
               	timer.schedule(new TimerTask() {
                     @Override
                     public void run() {
                    	 wildMonster.updateHP(-damage2);
                         moveAnimationTrainer(move2.getName());
                         
                     }
                 }, 2000);
                updateHealthbar();
                clearIconsF(); 
            	setupMainB(); 

        	}else {
        		Move move = playerMonster.getMoves().get(2);
            	int damage = move.calculateDamage(playerMonster, opponentMonster);
            	moveAnimation(playerMonster.getMoves().get(2).getName());
            	playerMonster.updateHP(-damage);
            	
            	
            	Move move2 = opponentMonster.selectRandomMove();
                int damage2 = move2.calculateDamage(opponentMonster, playerMonster);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                    	 opponentMonster.updateHP(-damage2);
                         moveAnimationTrainer(move2.getName());
                    }
                }, 2000); 
                updateHealthbar();
                clearIconsF(); 
                setupMainB(); 
        	}
        	
        	
        } 
        if((map.getElementAt(x, y) == move4 || map.getElementAt(x, y) == move4Description) &&  playerMonster.getMoves().size() > 3   && playerMonster.getCurHealth() != 0 ) {
        	if (opponentMonster == null  ) {
        		Move move = playerMonster.getMoves().get(3);
            	int damage = move.calculateDamage(playerMonster, wildMonster);
            	System.out.println(move.getName());
            	moveAnimation(playerMonster.getMoves().get(3).getName());
            	playerMonster.updateHP(-damage);
            	
            	Move move2 = wildMonster.selectRandomMove();
            	System.out.println(move2.getName());
                int damage2 = move2.calculateDamage(wildMonster, playerMonster);
                timer.schedule(new TimerTask() {
                     @Override
                     public void run() {
                    	 wildMonster.updateHP(-damage2);
                         moveAnimationTrainer(move2.getName());
                         
                     }
                 }, 2000);  
                updateHealthbar();
                clearIconsF(); 
            	setupMainB(); 
                 
        	}else {
        		Move move = playerMonster.getMoves().get(3);
            	int damage = move.calculateDamage(playerMonster, opponentMonster);
            	moveAnimation(playerMonster.getMoves().get(3).getName());
            	playerMonster.updateHP(-damage);
            	
            	Move move2 = opponentMonster.selectRandomMove();
                int damage2 = move2.calculateDamage(opponentMonster, playerMonster);
                
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                    	 opponentMonster.updateHP(-damage2);
                         moveAnimationTrainer(move2.getName());
                    }
                }, 2000); 
                updateHealthbar();
                clearIconsF(); 
                setupMainB();  
        	}
        	

        }
     
        
        
        
        if ( map.getElementAt(x, y) == runicon ) {
        	if ( opponentMonster == null) {
            	map.remove(WildMonsterHealth);
            	map.remove(Playerhealth);      
            }else {
            	map.remove(OpponetHealth);
            	map.remove(Playerhealth); 	        
            }

            clearIconsB(); 
            clearIconsF();
            
            map.remove(background);
            map.remove(opponentMonsterSprite);
            map.remove(playerMonsterSprite); 	
            map.endBattle();
        }
        
        
        
        if (map.getElementAt(x, y) == exit ) {
            clearIconsF(); 
            setupMainB(); 
        }
       
        
        
       /* if (bagicon != null && bagicon.contains(x, y)) {
            // Handle Bag icon click (not implemented here)
        }
        if (Monstericon != null && Monstericon.contains(x, y)) {
            // Handle Monster icon click (not implemented here)
        }*/
   
        	
        winScreen();
        
        System.out.println("Mouse clicked at: (" + x + ", " + y + ")");
    }

    
    public void winScreen() {
        // Create a label for displaying the win message (ACM GLabel)
        final GLabel winMessage = new GLabel("");  // Start with an empty label
        winMessage.setFont("Arial-Bold-24");  // Set font style (ACM uses a specific font string format)
        winMessage.setColor(Color.BLACK);  // Set the text color
        winMessage.setLocation(200, 360);  // Position the label at (200, 200)

        // Add the winMessage to the map (assuming map is a GCanvas or similar container)
        map.add(winMessage);

        // Timer to check after 7 seconds for the winner
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Check who has won and set the win message
                if (playerMonster != null && playerMonster.isFainted()) {
                	playerMonster.setFaint(true);
                	if ( opponentMonster == null) {
                    	map.remove(WildMonsterHealth);
                    	map.remove(Playerhealth);      
                    }else {
                    	map.remove(OpponetHealth);
                    	map.remove(Playerhealth); 	        
                    }

                    clearIconsB(); 
                    clearIconsF();
                    map.remove(background);
                    map.remove(opponentMonsterSprite);
                    map.remove(playerMonsterSprite); 
                    map.endBattle();
                    winMessage.setLabel("Opponent Wins! Health your monster");  // Update the win message

                } else if (opponentMonster != null && opponentMonster.isFainted()) {
                	playerMonster.setFaint(true);
                	if ( opponentMonster == null) {
                    	map.remove(WildMonsterHealth);
                    	map.remove(Playerhealth);      
                    }else {
                    	map.remove(OpponetHealth);
                    	map.remove(Playerhealth); 	        
                    }

                    clearIconsB(); 
                    clearIconsF();
                    map.remove(background);
                    map.remove(opponentMonsterSprite);
                    map.remove(playerMonsterSprite); 
                    map.endBattle();
                    winMessage.setLabel("Player Wins! Opponent Monster fainted. ");  // Update the win message

                } else if (wildMonster != null && wildMonster.isFainted()) {
                	playerMonster.setFaint(true);
                	if ( opponentMonster == null) {
                    	map.remove(WildMonsterHealth);
                    	map.remove(Playerhealth);      
                    }else {
                    	map.remove(OpponetHealth);
                    	map.remove(Playerhealth); 	        
                    }

                    clearIconsB(); 
                    clearIconsF();
                    map.remove(background);
                    map.remove(opponentMonsterSprite);
                    map.remove(playerMonsterSprite); 
                    map.endBattle();
                    winMessage.setLabel("Player Wins! Wild Monster fainted. ");  // Update the win message
                }

                // Schedule a task to remove the winMessage after 3 seconds (3000ms)
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        map.remove(winMessage); // Remove the win message
                    }
                }, 2000); // Delay for 3 seconds before removing the winMessage
            }
        }, 7000); // Initial delay before checking for the winner
    }
    
    
    public void HealMonsterScreen() {
        // Create a label for displaying the win message (ACM GLabel)
        final GLabel winMessage = new GLabel("");  // Start with an empty label
        winMessage.setFont("Arial-Bold-24");  // Set font style (ACM uses a specific font string format)
        winMessage.setColor(Color.BLACK);  // Set the text color
        winMessage.setLocation(200, 360);  // Position the label at (200, 200)

        // Add the winMessage to the map (assuming map is a GCanvas or similar container)
        map.add(winMessage);

        // Timer to check after 7 seconds for the winner
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Check who has won and set the win message
                if (playerMonster != null && playerMonster.isFainted()) {
                	playerMonster.setFaint(true);
                	if ( opponentMonster == null) {
                    	map.remove(WildMonsterHealth);
                    	map.remove(Playerhealth);      
                    }else {
                    	map.remove(OpponetHealth);
                    	map.remove(Playerhealth); 	        
                    }

                    clearIconsB(); 
                    clearIconsF();
                    map.remove(background);
                    map.remove(opponentMonsterSprite);
                    map.remove(playerMonsterSprite); 
                    map.endBattle();
                    winMessage.setLabel("Can't fight with fainted Monster heal Monster ");  // Update the win message

                } 

                // Schedule a task to remove the winMessage after 3 seconds (3000ms)
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        map.remove(winMessage); // Remove the win message
                    }
                }, 2000); // Delay for 3 seconds before removing the winMessage
            }
        }, 3000); // Initial delay before checking for the winner
    }
    


public void moveAnimation(String moveName) {
   
    if (moveName.equals("Tackle")) {
        animateTackle();
    } else if (moveName.equals("Ember")) {
        animateEmber();
    } else if (moveName.equals("Flamethrower")) {
       animateFlamethrower();
    } else if (moveName.equals("Fire Blast")) {
       animateFireBlast();
    } else if (moveName.equals("Water Gun")) {
        animateWaterGun();
    } else if (moveName.equals("Surf")) {
        animateSurf();
    } else if (moveName.equals("Thunderbolt")) {
        animateThunderbolt();
    } else if (moveName.equals("Earthquake")) {
       animateEarthquake();
    } 
   
}


private void animateTackle() {
    // Create the tackle effect image
    GImage tackleEffect = playerMonster.getBackSprite();  
    //tackleEffect.setSize(100, 100);  
    tackleEffect.setLocation(200, 460);  
    map.add(tackleEffect);

    
    final int targetX = 630;
    final int targetY = 280;

   
    final int moveDistance = 10;

    // Calculate the total number of frames needed to move horizontally and vertically
    // We divide the distance by the move distance, rounded up, so it covers the full distance
    final int totalFramesX = (int) Math.ceil((double) Math.abs(targetX - tackleEffect.getX()) / moveDistance);
    final int totalFramesY = (int) Math.ceil((double) Math.abs(targetY - tackleEffect.getY()) / moveDistance);

    // We want to take the maximum of both X and Y frame counts so the image finishes in sync
    final int totalFrames = Math.max(totalFramesX, totalFramesY);

    // Create a timer to animate the image's movement
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        private int framesMoved = 0;

        @Override
        public void run() {
            if (framesMoved < totalFrames) {
               
                int moveX = (int) ((targetX - tackleEffect.getX()) / (totalFrames - framesMoved));
                int moveY = (int) ((targetY - tackleEffect.getY()) / (totalFrames - framesMoved));

               
                tackleEffect.move(moveX, moveY);

                framesMoved++;
            } else {
                
                cancel();
                playerMonsterSprite.setLocation(200, 460);
            }
        }
    }, 0, 20); 
    
}

private void animateEmber() {
    
    GImage FireBlast = new GImage("fireball.png");  
   
    FireBlast.setSize(50, 50);
    FireBlast.setLocation(200, 460);  
    map.add(FireBlast);

    
    final int targetX = 630;
    final int targetY = 280;

   
    final int moveDistance = 10;

    // Calculate the total number of frames needed to move horizontally and vertically
    // We divide the distance by the move distance, rounded up, so it covers the full distance
    final int totalFramesX = (int) Math.ceil((double) Math.abs(targetX - FireBlast.getX()) / moveDistance);
    final int totalFramesY = (int) Math.ceil((double) Math.abs(targetY - FireBlast.getY()) / moveDistance);

    // We want to take the maximum of both X and Y frame counts so the image finishes in sync
    final int totalFrames = Math.max(totalFramesX, totalFramesY);

    // Create a timer to animate the image's movement
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        private int framesMoved = 0;

        @Override
        public void run() {
            if (framesMoved < totalFrames) {
               
                int moveX = (int) ((targetX - FireBlast.getX()) / (totalFrames - framesMoved));
                int moveY = (int) ((targetY - FireBlast.getY()) / (totalFrames - framesMoved));

               
                FireBlast.move(moveX, moveY);

                framesMoved++;
            } else {
                
                cancel();
                map.remove(FireBlast);
            }
        }
    }, 0, 20); 
    
}

private void animateSurf() {
    
    GImage FireBlast = new GImage("wave.png");  
   
    FireBlast.setSize(50, 50);
    FireBlast.setLocation(200, 460);  
    map.add(FireBlast);

    
    final int targetX = 630;
    final int targetY = 280;

   
    final int moveDistance = 10;

    // Calculate the total number of frames needed to move horizontally and vertically
    // We divide the distance by the move distance, rounded up, so it covers the full distance
    final int totalFramesX = (int) Math.ceil((double) Math.abs(targetX - FireBlast.getX()) / moveDistance);
    final int totalFramesY = (int) Math.ceil((double) Math.abs(targetY - FireBlast.getY()) / moveDistance);

    // We want to take the maximum of both X and Y frame counts so the image finishes in sync
    final int totalFrames = Math.max(totalFramesX, totalFramesY);

    // Create a timer to animate the image's movement
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        private int framesMoved = 0;

        @Override
        public void run() {
            if (framesMoved < totalFrames) {
               
                int moveX = (int) ((targetX - FireBlast.getX()) / (totalFrames - framesMoved));
                int moveY = (int) ((targetY - FireBlast.getY()) / (totalFrames - framesMoved));

               
                FireBlast.move(moveX, moveY);

                framesMoved++;
            } else {
                
                cancel();
                map.remove(FireBlast);
            }
        }
    }, 0, 20); 
    
}

private void animateThunderbolt() {
    
    GImage FireBlast = new GImage("lighting.png");  
   
    FireBlast.setSize(50, 50);
    FireBlast.setLocation(200, 460);  
    map.add(FireBlast);

    
    final int targetX = 630;
    final int targetY = 280;

   
    final int moveDistance = 10;

    // Calculate the total number of frames needed to move horizontally and vertically
    // We divide the distance by the move distance, rounded up, so it covers the full distance
    final int totalFramesX = (int) Math.ceil((double) Math.abs(targetX - FireBlast.getX()) / moveDistance);
    final int totalFramesY = (int) Math.ceil((double) Math.abs(targetY - FireBlast.getY()) / moveDistance);

    // We want to take the maximum of both X and Y frame counts so the image finishes in sync
    final int totalFrames = Math.max(totalFramesX, totalFramesY);

    // Create a timer to animate the image's movement
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        private int framesMoved = 0;

        @Override
        public void run() {
            if (framesMoved < totalFrames) {
               
                int moveX = (int) ((targetX - FireBlast.getX()) / (totalFrames - framesMoved));
                int moveY = (int) ((targetY - FireBlast.getY()) / (totalFrames - framesMoved));

               
                FireBlast.move(moveX, moveY);

                framesMoved++;
            } else {
                
                cancel();
                map.remove(FireBlast);
            }
        }
    }, 0, 20); 
    
}

private void animateEarthquake() {
    
    GImage FireBlast = new GImage("rock.png");  
   
    FireBlast.setSize(50, 50);
    FireBlast.setLocation(200, 460);  
    map.add(FireBlast);

    
    final int targetX = 630;
    final int targetY = 280;

   
    final int moveDistance = 10;

    // Calculate the total number of frames needed to move horizontally and vertically
    // We divide the distance by the move distance, rounded up, so it covers the full distance
    final int totalFramesX = (int) Math.ceil((double) Math.abs(targetX - FireBlast.getX()) / moveDistance);
    final int totalFramesY = (int) Math.ceil((double) Math.abs(targetY - FireBlast.getY()) / moveDistance);

    // We want to take the maximum of both X and Y frame counts so the image finishes in sync
    final int totalFrames = Math.max(totalFramesX, totalFramesY);

    // Create a timer to animate the image's movement
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        private int framesMoved = 0;

        @Override
        public void run() {
            if (framesMoved < totalFrames) {
               
                int moveX = (int) ((targetX - FireBlast.getX()) / (totalFrames - framesMoved));
                int moveY = (int) ((targetY - FireBlast.getY()) / (totalFrames - framesMoved));

               
                FireBlast.move(moveX, moveY);

                framesMoved++;
            } else {
                
                cancel();
                map.remove(FireBlast);
            }
        }
    }, 0, 20); 
    
}




private void animateFireBlast() {
    
    GImage FireBlast = new GImage("FireAttack.png");  
   
    FireBlast.setSize(50, 50);
    FireBlast.setLocation(200, 460);  
    map.add(FireBlast);

    
    final int targetX = 630;
    final int targetY = 280;

   
    final int moveDistance = 10;

    // Calculate the total number of frames needed to move horizontally and vertically
    // We divide the distance by the move distance, rounded up, so it covers the full distance
    final int totalFramesX = (int) Math.ceil((double) Math.abs(targetX - FireBlast.getX()) / moveDistance);
    final int totalFramesY = (int) Math.ceil((double) Math.abs(targetY - FireBlast.getY()) / moveDistance);

    // We want to take the maximum of both X and Y frame counts so the image finishes in sync
    final int totalFrames = Math.max(totalFramesX, totalFramesY);

    // Create a timer to animate the image's movement
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        private int framesMoved = 0;

        @Override
        public void run() {
            if (framesMoved < totalFrames) {
               
                int moveX = (int) ((targetX - FireBlast.getX()) / (totalFrames - framesMoved));
                int moveY = (int) ((targetY - FireBlast.getY()) / (totalFrames - framesMoved));

               
                FireBlast.move(moveX, moveY);

                framesMoved++;
            } else {
                
                cancel();
                map.remove(FireBlast);
            }
        }
    }, 0, 20); 
    
}

private void animateFlamethrower() {
    
    int numFireBlasts = 25;

    final int targetX = 630;
    final int targetY = 280;

    final int moveDistance = 10;

    GImage[] fireBlasts = new GImage[numFireBlasts];

    for (int i = 0; i < numFireBlasts; i++) {
        GImage fireBlast = new GImage("FireAttack.png");  
        fireBlast.setSize(50, 50);  
        
        fireBlast.setLocation(200, 460);
        map.add(fireBlast);
        fireBlasts[i] = fireBlast;  
    }

   
    Timer launchTimer = new Timer();
    launchTimer.scheduleAtFixedRate(new TimerTask() {
        private int currentBlastIndex = 0;  

        @Override
        public void run() {
            if (currentBlastIndex < numFireBlasts) {
                
                GImage currentBlast = fireBlasts[currentBlastIndex];

               
                animateFireBlast(currentBlast, targetX, targetY, moveDistance);

                currentBlastIndex++;
            } else {
                cancel();  
            }
        }
    }, 0, 50);  
}

private void animateFireBlast(GImage fireBlast, final int targetX, final int targetY, final int moveDistance) {
    Timer moveTimer = new Timer();
    moveTimer.scheduleAtFixedRate(new TimerTask() {
        

        @Override
        public void run() {
           
            double deltaX = targetX - fireBlast.getX();
            double deltaY = targetY - fireBlast.getY();

           
            double totalDistance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

          
            if (totalDistance > moveDistance) {
               
                double moveRatioX = deltaX / totalDistance;
                double moveRatioY = deltaY / totalDistance;

                
                int moveX = (int) (moveRatioX * moveDistance);
                int moveY = (int) (moveRatioY * moveDistance);

              
                fireBlast.move(moveX, moveY);
            } else {
               
                fireBlast.setLocation(targetX, targetY);
                map.remove(fireBlast);  
                cancel();  
            }

          
        }
    }, 0, 20); 
}

private void animateWaterGun() {
    
    int numFireBlasts = 25;

    final int targetX = 630;
    final int targetY = 280;

    final int moveDistance = 10;

    GImage[] fireBlasts = new GImage[numFireBlasts];

    for (int i = 0; i < numFireBlasts; i++) {
        GImage fireBlast = new GImage("bubble.png");  
        fireBlast.setSize(50, 50);  
        
        fireBlast.setLocation(200, 460);
        map.add(fireBlast);
        fireBlasts[i] = fireBlast;  
    }

   
    Timer launchTimer = new Timer();
    launchTimer.scheduleAtFixedRate(new TimerTask() {
        private int currentBlastIndex = 0;  

        @Override
        public void run() {
            if (currentBlastIndex < numFireBlasts) {
                
                GImage currentBlast = fireBlasts[currentBlastIndex];

               
                animateFireBlast(currentBlast, targetX, targetY, moveDistance);

                currentBlastIndex++;
            } else {
                cancel();  
            }
        }
    }, 0, 20);  
}




public void moveAnimationTrainer(String moveName) {
	   
    if (moveName.equals("Tackle")) {
    	animateTackleTrainer();
    } else if (moveName.equals("Ember")) {
        animateEmberTrianer();
    } else if (moveName.equals("Flamethrower")) {
    	animateFlamethrowerTrainer();
    } else if (moveName.equals("Fire Blast")) {
    	animateFireBlastTrainer();
    } else if (moveName.equals("Water Gun")) {
    	animateWaterGunTrainer();
    } else if (moveName.equals("Surf")) {
       animateSurfTrainer();
    } else if (moveName.equals("Thunderbolt")) {
        animateThunderboltTrainer();
    } else if (moveName.equals("Earthquake")) {
       animateEarthquakeTrainer();
    } 
   
}


private void animateEmberTrianer() {
    
    GImage FireBlast = new GImage("fireball.png");  
   
    FireBlast.setSize(50, 50);
    FireBlast.setLocation(630, 280);  
    map.add(FireBlast);

    
    final int targetX = 200;
    final int targetY = 460;

   
    final int moveDistance = 10;

    // Calculate the total number of frames needed to move horizontally and vertically
    // We divide the distance by the move distance, rounded up, so it covers the full distance
    final int totalFramesX = (int) Math.ceil((double) Math.abs(targetX - FireBlast.getX()) / moveDistance);
    final int totalFramesY = (int) Math.ceil((double) Math.abs(targetY - FireBlast.getY()) / moveDistance);

    // We want to take the maximum of both X and Y frame counts so the image finishes in sync
    final int totalFrames = Math.max(totalFramesX, totalFramesY);

    // Create a timer to animate the image's movement
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        private int framesMoved = 0;

        @Override
        public void run() {
            if (framesMoved < totalFrames) {
               
                int moveX = (int) ((targetX - FireBlast.getX()) / (totalFrames - framesMoved));
                int moveY = (int) ((targetY - FireBlast.getY()) / (totalFrames - framesMoved));

               
                FireBlast.move(moveX, moveY);

                framesMoved++;
            } else {
                
                cancel();
                map.remove(FireBlast);
            }
        }
    }, 0, 20); 
    
}

private void animateSurfTrainer() {
    
    GImage FireBlast = new GImage("wave.png");  
   
    FireBlast.setSize(50, 50);
    FireBlast.setLocation(630, 280);  
    map.add(FireBlast);

    
    final int targetX = 200;
    final int targetY = 460;

   
    final int moveDistance = 10;

    // Calculate the total number of frames needed to move horizontally and vertically
    // We divide the distance by the move distance, rounded up, so it covers the full distance
    final int totalFramesX = (int) Math.ceil((double) Math.abs(targetX - FireBlast.getX()) / moveDistance);
    final int totalFramesY = (int) Math.ceil((double) Math.abs(targetY - FireBlast.getY()) / moveDistance);

    // We want to take the maximum of both X and Y frame counts so the image finishes in sync
    final int totalFrames = Math.max(totalFramesX, totalFramesY);

    // Create a timer to animate the image's movement
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        private int framesMoved = 0;

        @Override
        public void run() {
            if (framesMoved < totalFrames) {
               
                int moveX = (int) ((targetX - FireBlast.getX()) / (totalFrames - framesMoved));
                int moveY = (int) ((targetY - FireBlast.getY()) / (totalFrames - framesMoved));

               
                FireBlast.move(moveX, moveY);

                framesMoved++;
            } else {
                
                cancel();
                map.remove(FireBlast);
            }
        }
    }, 0, 20); 
    
}

private void animateThunderboltTrainer() {
    
    GImage FireBlast = new GImage("lighting.png");  
   
    FireBlast.setSize(50, 50);
    FireBlast.setLocation(630, 280);  
    map.add(FireBlast);

    
    final int targetX = 200;
    final int targetY = 460;

   
    final int moveDistance = 10;

    // Calculate the total number of frames needed to move horizontally and vertically
    // We divide the distance by the move distance, rounded up, so it covers the full distance
    final int totalFramesX = (int) Math.ceil((double) Math.abs(targetX - FireBlast.getX()) / moveDistance);
    final int totalFramesY = (int) Math.ceil((double) Math.abs(targetY - FireBlast.getY()) / moveDistance);

    // We want to take the maximum of both X and Y frame counts so the image finishes in sync
    final int totalFrames = Math.max(totalFramesX, totalFramesY);

    // Create a timer to animate the image's movement
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        private int framesMoved = 0;

        @Override
        public void run() {
            if (framesMoved < totalFrames) {
               
                int moveX = (int) ((targetX - FireBlast.getX()) / (totalFrames - framesMoved));
                int moveY = (int) ((targetY - FireBlast.getY()) / (totalFrames - framesMoved));

               
                FireBlast.move(moveX, moveY);

                framesMoved++;
            } else {
                
                cancel();
                map.remove(FireBlast);
            }
        }
    }, 0, 20); 
    
}

private void animateEarthquakeTrainer() {
    
    GImage FireBlast = new GImage("rock.png");  
   
    FireBlast.setSize(50, 50);
    FireBlast.setLocation(630, 280);  
    map.add(FireBlast);

    
    final int targetX = 200;
    final int targetY = 460;

   
    final int moveDistance = 10;

    // Calculate the total number of frames needed to move horizontally and vertically
    // We divide the distance by the move distance, rounded up, so it covers the full distance
    final int totalFramesX = (int) Math.ceil((double) Math.abs(targetX - FireBlast.getX()) / moveDistance);
    final int totalFramesY = (int) Math.ceil((double) Math.abs(targetY - FireBlast.getY()) / moveDistance);

    // We want to take the maximum of both X and Y frame counts so the image finishes in sync
    final int totalFrames = Math.max(totalFramesX, totalFramesY);

    // Create a timer to animate the image's movement
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        private int framesMoved = 0;

        @Override
        public void run() {
            if (framesMoved < totalFrames) {
               
                int moveX = (int) ((targetX - FireBlast.getX()) / (totalFrames - framesMoved));
                int moveY = (int) ((targetY - FireBlast.getY()) / (totalFrames - framesMoved));

               
                FireBlast.move(moveX, moveY);

                framesMoved++;
            } else {
                
                cancel();
                map.remove(FireBlast);
            }
        }
    }, 0, 20); 
    
}





private void animateTackleTrainer() {
    // Create the tackle effect image
    GImage tackleEffect = opponentMonsterSprite;  
    
    //tackleEffect.setSize(100, 100);  
    tackleEffect.setLocation( 630, 280);  
    map.add(tackleEffect);

    
    final int targetX = 200;
    final int targetY = 460;

   
    final int moveDistance = 10;

    // Calculate the total number of frames needed to move horizontally and vertically
    // We divide the distance by the move distance, rounded up, so it covers the full distance
    final int totalFramesX = (int) Math.ceil((double) Math.abs(targetX - tackleEffect.getX()) / moveDistance);
    final int totalFramesY = (int) Math.ceil((double) Math.abs(targetY - tackleEffect.getY()) / moveDistance);

    // We want to take the maximum of both X and Y frame counts so the image finishes in sync
    final int totalFrames = Math.max(totalFramesX, totalFramesY);

    // Create a timer to animate the image's movement
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        private int framesMoved = 0;

        @Override
        public void run() {
            if (framesMoved < totalFrames) {
               
                int moveX = (int) ((targetX - tackleEffect.getX()) / (totalFrames - framesMoved));
                int moveY = (int) ((targetY - tackleEffect.getY()) / (totalFrames - framesMoved));

               
                tackleEffect.move(moveX, moveY);

                framesMoved++;
            } else {
                
                cancel();
                opponentMonsterSprite.setLocation(630, 280);
            }
        }
    }, 0, 20); 
    
}

private void animateFireBlastTrainer() {
    
    GImage FireBlast = new GImage("FireAttack.png");  
   
    FireBlast.setSize(50, 50);
    FireBlast.setLocation(630, 280);  
    map.add(FireBlast);

    
    final int targetX = 200;
    final int targetY = 460;

   
    final int moveDistance = 10;

    // Calculate the total number of frames needed to move horizontally and vertically
    // We divide the distance by the move distance, rounded up, so it covers the full distance
    final int totalFramesX = (int) Math.ceil((double) Math.abs(targetX - FireBlast.getX()) / moveDistance);
    final int totalFramesY = (int) Math.ceil((double) Math.abs(targetY - FireBlast.getY()) / moveDistance);

    // We want to take the maximum of both X and Y frame counts so the image finishes in sync
    final int totalFrames = Math.max(totalFramesX, totalFramesY);

    // Create a timer to animate the image's movement
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        private int framesMoved = 0;

        @Override
        public void run() {
            if (framesMoved < totalFrames) {
               
                int moveX = (int) ((targetX - FireBlast.getX()) / (totalFrames - framesMoved));
                int moveY = (int) ((targetY - FireBlast.getY()) / (totalFrames - framesMoved));

               
                FireBlast.move(moveX, moveY);

                framesMoved++;
            } else {
                
                cancel();
                map.remove(FireBlast);
            }
        }
    }, 0, 20); 
    
}


private void animateFlamethrowerTrainer() {
    
    int numFireBlasts = 25;

    final int targetX = 200;
    final int targetY = 460;

    final int moveDistance = 10;

    GImage[] fireBlasts = new GImage[numFireBlasts];

    for (int i = 0; i < numFireBlasts; i++) {
        GImage fireBlast = new GImage("FireAttack.png");  
        fireBlast.setSize(50, 50);  
        
        fireBlast.setLocation(630, 280);
        map.add(fireBlast);
        fireBlasts[i] = fireBlast;  
    }

   
    Timer launchTimer = new Timer();
    launchTimer.scheduleAtFixedRate(new TimerTask() {
        private int currentBlastIndex = 0;  

        @Override
        public void run() {
            if (currentBlastIndex < numFireBlasts) {
                
                GImage currentBlast = fireBlasts[currentBlastIndex];

               
                animateFireBlast(currentBlast, targetX, targetY, moveDistance);

                currentBlastIndex++;
            } else {
                cancel();  
            }
        }
    }, 0, 50);  
}


private void animateWaterGunTrainer() {
    
    int numFireBlasts = 25;

    final int targetX = 200;
    final int targetY = 460;

    final int moveDistance = 10;

    GImage[] fireBlasts = new GImage[numFireBlasts];

    for (int i = 0; i < numFireBlasts; i++) {
        GImage fireBlast = new GImage("bubble.png");  
        fireBlast.setSize(50, 50);  
        
        fireBlast.setLocation(630, 280);
        map.add(fireBlast);
        fireBlasts[i] = fireBlast;  
    }

   
    Timer launchTimer = new Timer();
    launchTimer.scheduleAtFixedRate(new TimerTask() {
        private int currentBlastIndex = 0;  

        @Override
        public void run() {
            if (currentBlastIndex < numFireBlasts) {
                
                GImage currentBlast = fireBlasts[currentBlastIndex];

               
                animateFireBlast(currentBlast, targetX, targetY, moveDistance);

                currentBlastIndex++;
            } else {
                cancel();  
            }
        }
    }, 0, 50);  
}







    // Main method to launch the program
	/*
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
	    opponentMonster.addmove(Move.EARTHQUAKE);
	    opponentMonster.addmove(Move.WATERGUN);
	    opponentTrainer.addMon(opponentMonster);
	    
	    
    	  battleGraphics s = new battleGraphics();
    	  s.setplayer(playerTrainer,opponentTrainer);
    	  s.start();
    }
	*/
}

