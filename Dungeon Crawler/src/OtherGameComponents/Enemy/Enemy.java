package OtherGameComponents.Enemy;


import OtherGameComponents.Character;
import OtherGameComponents.Weapon.Weapon;
import OtherGameComponents.Weapon.WeaponFactory;

import java.io.Serializable;
import java.util.Random;

public class Enemy extends Character implements Serializable {


    public Enemy() {
    }


    public String randomizeName(String[] array) {
        int randomIndex = new Random().nextInt(array.length);
        return array[randomIndex];
    }

    public int randomizeHP(int rangeMin, int rangeMax) {
        Random r = new Random();
        return r.ints(rangeMin, (rangeMax + 1)).findFirst().getAsInt();
    }

    public Weapon randomizeWeapon(int level) {
        WeaponFactory wf = new WeaponFactory();
        Weapon weapon = wf.makeWeapon(level);
        return weapon;
    }


    @Override
    public String toString() {
        return  getName() + "!\n" +
                getName() + " HP = " + getHp() + "\n" +
                getName() + " Damage = " + getCurrentWeapon().getDamage();
    }

    public String enemyStats() {
        return  getName() + " HP = " + getHp() + "\n" +
                getName() + " Damage = " + getCurrentWeapon().getDamage();
    }
}
