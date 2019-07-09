package OtherGameComponents.Weapon;

public class Level3Weapon extends Weapon {


    public Level3Weapon() {
        setName(randomizeName(weaponNames));
        setDamage(randomizeDamage(21, 30));
    }


    private String[] weaponNames = {"Axe", "Cutlass", "Khanda", "Katana"};


}




