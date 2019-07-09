package OtherGameComponents.Armor;

public class Level5Armor extends Armor {


    public Level5Armor() {
        setName(randomizeName(armorNames));
        setDamageReduction(randomizeDamageReduction(41, 50));
    }


    private String[] armorNames = {"Platemail", "Half-plate", "Field plate", "Full plate"};


}




