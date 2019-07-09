package OtherGameComponents.Armor;

public class Level1Armor extends Armor {


    public Level1Armor() {
        setName(randomizeName(armorNames));
        setDamageReduction(randomizeDamageReduction(1, 10));
    }

    private String[] armorNames = {"Belts", "Boots", "Brasers"};


}




