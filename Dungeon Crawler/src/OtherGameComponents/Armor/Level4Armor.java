package OtherGameComponents.Armor;

public class Level4Armor extends Armor {


    public Level4Armor() {
        setName(randomizeName(armorNames));
        setDamageReduction(randomizeDamageReduction(31, 40));
    }


    private String[] armorNames = { "Bodysuit", "Tunic", "Chests"};


}




