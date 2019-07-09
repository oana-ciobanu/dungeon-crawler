package OtherGameComponents.Weapon;

public class Level2Weapon extends Weapon {


    public Level2Weapon() {
        setName(randomizeName(weaponNames));
        setDamage(randomizeDamage(11, 20));
    }


    private String[] weaponNames = {"Sword", "Polearm", "Bolos"};


}




