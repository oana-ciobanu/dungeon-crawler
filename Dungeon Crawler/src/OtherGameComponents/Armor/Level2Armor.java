package OtherGameComponents.Armor;

public class Level2Armor extends Armor {


    public Level2Armor() {
        setName(randomizeName(armorNames));
        setDamageReduction(randomizeDamageReduction(11, 20));
    }


    private String[] armorNames = {"Gloves", "Helmets", "Leggings", "Pauldrons", "Shields"};


}




