package OtherGameComponents.Weapon;

import java.io.Serializable;
import java.util.Random;

public class Weapon implements Serializable {

    private String name;
    private int damage;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int newDamage) {
        damage = newDamage;
    }

    public String randomizeName(String[] array) {
        int randomIndex = new Random().nextInt(array.length);
        return array[randomIndex];
    }

    public int randomizeDamage(int rangeMin, int rangeMax) {
        Random r = new Random();
        return r.ints(rangeMin, (rangeMax + 1)).findFirst().getAsInt();
    }

}


