import java.util.ArrayList;
import java.util.List;

public class BattleSimulator {
//done
    public static void main(String[] args) {
        // Create moves (using Move enum constants)
        List<Move> moves1 = new ArrayList<>();
        moves1.add(Move.TACKLE);
        moves1.add(Move.EMBER);

        List<Move> moves2 = new ArrayList<>();
        moves2.add(Move.BODYSLAM);
        moves2.add(Move.THUNDERBOLT);

        // Create monsters with moves, now including the 'level' argument
        Monster monster1 = new Monster("Monster A", 100, 30, 20, 5, moves1);
        Monster monster2 = new Monster("Monster B", 100, 35, 25, 6, moves2);

        // Start the battle
        battle(monster1, monster2);
    }

    public static void battle(Monster monster1, Monster monster2) {
        int round = 1;

        while (!monster1.isFainted() && !monster2.isFainted()) {
            System.out.println("Round " + round + ":");

            // Monster 1 attacks Monster 2
            attack(monster1, monster2);
            if (monster2.isFainted()) {
                System.out.println(monster2.getName() + " fainted! " + monster1.getName() + " wins!");
                break;
            }

            // Monster 2 attacks Monster 1
            attack(monster2, monster1);
            if (monster1.isFainted()) {
                System.out.println(monster1.getName() + " fainted! " + monster2.getName() + " wins!");
                break;
            }

            round++;
        }
    }

    public static void attack(Monster attacker, Monster defender) {
        // Select a move (just the first move for simplicity)
        Move selectedMove = attacker.getMoves().get(0);
        System.out.println(attacker.getName() + " uses " + selectedMove.name + "!");

        // Calculate damage
        int damage = selectedMove.calculateDamage(attacker, defender);
        defender.takeDamage(damage);

        // Display result
        System.out.println(defender.getName() + " takes " + damage + " damage! (HP: " + defender.getHealth() + ")");
    }
}
