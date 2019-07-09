package OtherGameComponents.Armor;

import java.io.Serializable;
import java.util.Random;

public class Armor implements Serializable {

    private String name;
    private int damageReduction;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(int newDamageReduction) {
        damageReduction = newDamageReduction;
    }

    public static String randomizeName(String[] array) {
        int randomIndex = new Random().nextInt(array.length);
        return array[randomIndex];
    }

    public int randomizeDamageReduction(int rangeMin, int rangeMax) {
        Random r = new Random();
        return r.ints(rangeMin, (rangeMax + 1)).findFirst().getAsInt();
    }

}
