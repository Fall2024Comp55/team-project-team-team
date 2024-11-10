import java.util.HashMap;
import java.util.Map;

public class TypeEffectiveness {
    private static final Map<String, Map<String, Double>> effectivenessMap = new HashMap<>();

    static {
        
        Map<String, Double> fireEffectiveness = new HashMap<>();
        fireEffectiveness.put("Fire", 1.0);
        fireEffectiveness.put("Water", 0.5);
        fireEffectiveness.put("Grass", 2.0);
        fireEffectiveness.put("Ice", 2.0);
        fireEffectiveness.put("Bug", 2.0);
        fireEffectiveness.put("Rock", 0.5);
        fireEffectiveness.put("Dragon", 1.0);
        fireEffectiveness.put("Fairy", 1.0);
        effectivenessMap.put("Fire", fireEffectiveness);

      
        Map<String, Double> waterEffectiveness = new HashMap<>();
        waterEffectiveness.put("Water", 1.0);
        waterEffectiveness.put("Fire", 2.0);
        waterEffectiveness.put("Grass", 0.5);
        waterEffectiveness.put("Electric", 0.5);
        waterEffectiveness.put("Dragon", 1.0);
        effectivenessMap.put("Water", waterEffectiveness);

     
        Map<String, Double> grassEffectiveness = new HashMap<>();
        grassEffectiveness.put("Grass", 1.0);
        grassEffectiveness.put("Fire", 0.5);
        grassEffectiveness.put("Water", 2.0);
        grassEffectiveness.put("Flying", 0.5);
        grassEffectiveness.put("Bug", 0.5);
        grassEffectiveness.put("Rock", 2.0);
        effectivenessMap.put("Grass", grassEffectiveness);

      
        Map<String, Double> electricEffectiveness = new HashMap<>();
        electricEffectiveness.put("Electric", 1.0);
        electricEffectiveness.put("Water", 2.0);
        electricEffectiveness.put("Flying", 2.0);
        electricEffectiveness.put("Ground", 0.0); 
        effectivenessMap.put("Electric", electricEffectiveness);

     
        Map<String, Double> groundEffectiveness = new HashMap<>();
        groundEffectiveness.put("Ground", 1.0);
        groundEffectiveness.put("Electric", 2.0);
        groundEffectiveness.put("Water", 0.5);
        groundEffectiveness.put("Ice", 2.0);
        groundEffectiveness.put("Grass", 0.5);
        groundEffectiveness.put("Flying", 0.0); 
        effectivenessMap.put("Ground", groundEffectiveness);

     
        Map<String, Double> iceEffectiveness = new HashMap<>();
        iceEffectiveness.put("Ice", 1.0);
        iceEffectiveness.put("Fire", 0.5);
        iceEffectiveness.put("Water", 0.5);
        iceEffectiveness.put("Grass", 2.0);
        iceEffectiveness.put("Flying", 2.0);
        iceEffectiveness.put("Dragon", 2.0);
        iceEffectiveness.put("Steel", 0.5);
        effectivenessMap.put("Ice", iceEffectiveness);

       
        Map<String, Double> fightingEffectiveness = new HashMap<>();
        fightingEffectiveness.put("Fighting", 1.0);
        fightingEffectiveness.put("Normal", 2.0);
        fightingEffectiveness.put("Ice", 2.0);
        fightingEffectiveness.put("Poison", 0.5);
        fightingEffectiveness.put("Flying", 0.5);
        fightingEffectiveness.put("Psychic", 0.5);
        fightingEffectiveness.put("Bug", 0.5);
        fightingEffectiveness.put("Rock", 2.0);
        fightingEffectiveness.put("Ghost", 0.0); 
        fightingEffectiveness.put("Fairy", 0.5);
        effectivenessMap.put("Fighting", fightingEffectiveness);

        
        Map<String, Double> poisonEffectiveness = new HashMap<>();
        poisonEffectiveness.put("Poison", 1.0);
        poisonEffectiveness.put("Grass", 2.0);
        poisonEffectiveness.put("Fairy", 2.0);
        poisonEffectiveness.put("Ground", 0.5);
        poisonEffectiveness.put("Psychic", 0.5);
        effectivenessMap.put("Poison", poisonEffectiveness);

      
        Map<String, Double> psychicEffectiveness = new HashMap<>();
        psychicEffectiveness.put("Psychic", 1.0);
        psychicEffectiveness.put("Fighting", 2.0);
        psychicEffectiveness.put("Poison", 2.0);
        psychicEffectiveness.put("Bug", 0.5);
        psychicEffectiveness.put("Ghost", 0.5);
        psychicEffectiveness.put("Dark", 0.0); 
        effectivenessMap.put("Psychic", psychicEffectiveness);

      
        Map<String, Double> bugEffectiveness = new HashMap<>();
        bugEffectiveness.put("Bug", 1.0);
        bugEffectiveness.put("Fire", 0.5);
        bugEffectiveness.put("Fighting", 2.0);
        bugEffectiveness.put("Flying", 0.5);
        bugEffectiveness.put("Ghost", 2.0);
        bugEffectiveness.put("Psychic", 2.0);
        bugEffectiveness.put("Fairy", 0.5);
        effectivenessMap.put("Bug", bugEffectiveness);

     
        Map<String, Double> rockEffectiveness = new HashMap<>();
        rockEffectiveness.put("Rock", 1.0);
        rockEffectiveness.put("Fire", 2.0);
        rockEffectiveness.put("Water", 0.5);
        rockEffectiveness.put("Grass", 0.5);
        rockEffectiveness.put("Fighting", 0.5);
        rockEffectiveness.put("Bug", 2.0);
        rockEffectiveness.put("Flying", 2.0);
        effectivenessMap.put("Rock", rockEffectiveness);

        
        Map<String, Double> ghostEffectiveness = new HashMap<>();
        ghostEffectiveness.put("Ghost", 2.0);
        ghostEffectiveness.put("Normal", 0.0); 
        ghostEffectiveness.put("Psychic", 2.0);
        ghostEffectiveness.put("Dark", 0.5);
        effectivenessMap.put("Ghost", ghostEffectiveness);

        
        Map<String, Double> dragonEffectiveness = new HashMap<>();
        dragonEffectiveness.put("Dragon", 2.0);
        dragonEffectiveness.put("Fairy", 0.0); 
        dragonEffectiveness.put("Steel", 0.5);
        effectivenessMap.put("Dragon", dragonEffectiveness);

        
        Map<String, Double> darkEffectiveness = new HashMap<>();
        darkEffectiveness.put("Dark", 1.0);
        darkEffectiveness.put("Psychic", 2.0);
        darkEffectiveness.put("Ghost", 2.0);
        darkEffectiveness.put("Fighting", 0.5);
        darkEffectiveness.put("Fairy", 0.5);
        effectivenessMap.put("Dark", darkEffectiveness);

       
        Map<String, Double> fairyEffectiveness = new HashMap<>();
        fairyEffectiveness.put("Fairy", 1.0);
        fairyEffectiveness.put("Fire", 0.5);
        fairyEffectiveness.put("Fighting", 2.0);
        fairyEffectiveness.put("Dragon", 2.0);
        fairyEffectiveness.put("Dark", 2.0);
        effectivenessMap.put("Fairy", fairyEffectiveness);
    }

    // Get the effectiveness multiplier for a given attack type vs. defense type
    public static double getEffectiveness(String attackType, String defenseType) {
        Map<String, Double> attackEffectiveness = effectivenessMap.get(attackType);
        if (attackEffectiveness != null && attackEffectiveness.containsKey(defenseType)) {
            return attackEffectiveness.get(defenseType);
        }
        return 1.0;  // Default effectiveness is 1.0 (no effect)
    }
}
