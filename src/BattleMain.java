
public class BattleMain {
	public static void main(String[] args) {
		    // Create the player's trainer and monster
		    PlayerTrainer playerTrainer = new PlayerTrainer();
		    Monster playerMonster = new Monster(SpeciesType.SPIDER,5);
		    playerMonster.addmove(Move.TACKLE);
		    playerMonster.addmove(Move.EMBER);
		    
		    // Add the monster to the player's team
		    playerTrainer.addMon(playerMonster);

		    // Create the opponent's trainer and monster
		    Trainer opponentTrainer = new Trainer();
		    Monster opponentMonster = new Monster(SpeciesType.FLAMECLAW,5);
		    opponentMonster.addmove(Move.FLAMETHROWER);
		    opponentMonster.addmove(Move.EMBER);
		    opponentTrainer.addMon(opponentMonster);

		    // Start a battle between the player and opponent
		    BattleSimulator battle = new BattleSimulator(playerTrainer, opponentTrainer);
		    battle.startBattle(); // This will run the battle until one monster faints

		    // After the battle, the player might earn money or badges
		    playerTrainer.updateMoney(100);  // Player earns 100 money after the battle
		    playerTrainer.addNumBadges();   // Player earns a badge
		    System.out.println("Player's money: " + playerTrainer.getMoney());
		    System.out.println("Player's badges: " + playerTrainer.getNumBadges());
		}

}
