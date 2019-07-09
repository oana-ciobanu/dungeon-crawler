package OtherGameComponents.Armor;

public class Level3Armor extends Armor {


    public Level3Armor() {
        setName(randomizeName(armorNames));
        setDamageReduction(randomizeDamageReduction(21, 30));
    }


    private String[] armorNames = { "Platemail", "Arming coat", "Jerkin", "Cloaks"};


}




