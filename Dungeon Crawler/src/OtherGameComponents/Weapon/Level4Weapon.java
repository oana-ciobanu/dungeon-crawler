package OtherGameComponents.Weapon;

public class Level4Weapon extends Weapon {


    public Level4Weapon() {
        setName(randomizeName(weaponNames));
        setDamage(randomizeDamage(31, 40));
    }


    private String[] weaponNames = {"Hammer", "Spear", "Mace", "Whip"};


}




