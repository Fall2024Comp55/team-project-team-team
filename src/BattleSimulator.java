import java.util.Random;
import java.util.List;

public class BattleSimulator {
    private PlayerTrainer player;
    private Trainer opponent;
    private Monster playerMonster;
    private Monster opponentMonster;
    private boolean isPlayerTurn;

    // Constructor to initialize the battle with two trainers
    public  BattleSimulator(PlayerTrainer player, Trainer opponent) {
        this.player = player;
        this.opponent = opponent;
        this.playerMonster = player.getTeam().get(0);  // Player's first monster
        this.opponentMonster = opponent.getTeam().get(0);  // Opponent's first monster
        this.isPlayerTurn = true;
    }
    
    
    // Start the battle
    public void startBattle() {
        System.out.println("A battle has begun between " + playerMonster.getName() + " and " + opponentMonster.getName() + "!");
        while (!playerMonster.isFainted() && !opponentMonster.isFainted()) {
        	
            takeTurn();
            
        }
        
        if (playerMonster.isFainted()) {
            System.out.println(playerMonster.getName() + " has fainted! " + opponentMonster.getName() + " wins!");
        } else {
            System.out.println(opponentMonster.getName() + " has fainted! " + playerMonster.getName() + " wins!");
        }
    }

    // Take a turn: Either player or opponent will make a move
    private void takeTurn() {
        if (isPlayerTurn) {
            playerTurn();
        } else {
            opponentTurn();
        }
        isPlayerTurn = !isPlayerTurn; // Switch turns
    }

    // Handle the player's turn
    private void playerTurn() {
        System.out.println(playerMonster.getName() + "'s turn!");
   
        Move move = selectRandomMove(playerMonster);
        //move.animate(); // Display the move animation
        int damage = move.calculateDamage(playerMonster, opponentMonster);
        System.out.println(playerMonster.getName() + " used " + move.name + "!");
        opponentMonster.updateHP(-damage);
        System.out.println(opponentMonster.getName() + " took " + damage + " damage!");
    }

    // Handle the opponent's turn
    private void opponentTurn() {
        System.out.println(opponentMonster.getName() + "'s turn!");
        
        Move move = selectRandomMove(opponentMonster);
      
        int damage = move.calculateDamage(opponentMonster, playerMonster);
        System.out.println(opponentMonster.getName() + " used " + move.name + "!");
        playerMonster.updateHP(-damage);
        System.out.println(playerMonster.getName() + " took " + damage + " damage!");
    }

    // Randomly selects a move from the available moves for a Monster
    private Move selectRandomMove(Monster monster) {
        List<Move> moves = monster.getMoves();
        Random rand = new Random();
        return moves.get(rand.nextInt(moves.size())); // Random move selection
    }





}




