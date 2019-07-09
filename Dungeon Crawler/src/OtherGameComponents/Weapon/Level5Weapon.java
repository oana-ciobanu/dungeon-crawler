package OtherGameComponents.Weapon;

public class Level5Weapon extends Weapon {


    public Level5Weapon() {
        setName(randomizeName(weaponNames));
        setDamage(randomizeDamage(41, 50));
    }


    private String[] weaponNames = {"Tekkan", "Lance", "Glaive", "Bow", "Arbalest"};

}




