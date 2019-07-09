package OtherGameComponents.Armor;


public class ArmorFactory {


    public Armor makeArmor(int levelNumber) {

        switch (Integer.valueOf(levelNumber)) {
            case 1:
                return new Level1Armor();
            case 2:
                return new Level2Armor();
            case 3:
                return new Level3Armor();
            case 4:
                return new Level4Armor();
            case 5:
                return new Level5Armor();
            default:
                return null;
        }
    }

}
