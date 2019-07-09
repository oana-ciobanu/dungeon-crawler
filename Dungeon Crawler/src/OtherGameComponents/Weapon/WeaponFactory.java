package OtherGameComponents.Weapon;


public class WeaponFactory {


    public Weapon makeWeapon(int levelNumber) {

        switch (Integer.valueOf(levelNumber)) {
            case 1:
                return new Level1Weapon();
            case 2:
                return new Level2Weapon();
            case 3:
                return new Level3Weapon();
            case 4:
                return new Level4Weapon();
            case 5:
                return new Level5Weapon();
            default:
                return null;
        }
    }

}
