import java.util.Random;

public class Battle {
    private Monster playerMonster;
    private Monster opponentMonster;
    private Random random = new Random();

    public Battle(Monster player, Monster opponent) {
        this.playerMonster = player;
        this.opponentMonster = opponent;
    }

    public void startBattle() {
        while (!playerMonster.isFainted() && !opponentMonster.isFainted()) {
            playerTurn();
            if (opponentMonster.isFainted()) break;
            opponentTurn();
        }
        System.out.println(playerMonster.isFainted() ? "You lost!" : "You won!");
    }

    private void playerTurn() {
        Move move = playerMonster.getMoves().get(0);
        int damage = move.calculateDamage(playerMonster, opponentMonster);
        opponentMonster.takeDamage(damage);
        System.out.println(playerMonster.getName() + " used " + move.name() + " and dealt " + damage + " damage.");
    }

    private void opponentTurn() {
        Move move = opponentMonster.getMoves().get(0);
        int damage = move.calculateDamage(opponentMonster, playerMonster);
        playerMonster.takeDamage(damage);
        System.out.println(opponentMonster.getName() + " used " + move.name() + " and dealt " + damage + " damage.");
    }
    
}
