package OtherGameComponents;

import OtherGameComponents.Weapon.Weapon;

import java.io.Serializable;

public abstract class Character implements Serializable {
    private String name;
    private int hp;
    private Weapon currentWeapon;


    public Character() {
    }

    public Character(String name, int hp, Weapon currentWeapon) {
        this.name = name;
        this.hp = hp;
        this.currentWeapon = currentWeapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }


    public void attack(Character character) {

        character.damageTaken(currentWeapon.getDamage());
    }

    public void damageTaken(int damage) {
        hp -= damage;
    }

    public boolean isAlive() {
        return hp > 0;
    }
}

