package OtherGameComponents.Weapon;

public class Level1Weapon extends Weapon {


    public Level1Weapon() {
        setName(randomizeName(weaponNames));
        setDamage(randomizeDamage(2, 10));
    }


    private String[] weaponNames = {"Spoon", "Stick", "Chain", "Knife", "Sword"};


}




