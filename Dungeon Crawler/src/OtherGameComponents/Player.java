package OtherGameComponents;


import OtherGameComponents.Armor.Armor;
import OtherGameComponents.Armor.ArmorFactory;
import OtherGameComponents.Armor.Level1Armor;
import OtherGameComponents.Weapon.Level1Weapon;
import OtherGameComponents.Weapon.Weapon;
import OtherGameComponents.Weapon.WeaponFactory;

import java.io.Serializable;


public class Player extends Character implements Serializable {


    private Armor currentArmor;
    private int healthPots;
    private int monstersDefeated;
    private int dungeonLevel;
    private int points;
    private int highScore;


    public Player() {
        super("John Doe", 100, new Level1Weapon());
        healthPots = 3;
        monstersDefeated = 0;
        dungeonLevel = 1;
        currentArmor = new Level1Armor();
        points = 0;
        highScore = 0;

    }

    public Armor getCurrentArmor() {
        return currentArmor;
    }

    public void setCurrentArmor(Armor currentArmor) {
        this.currentArmor = currentArmor;
    }

    public int getHealthPots() {
        return healthPots;
    }

    public void setHealthPots(int healthPots) {
        this.healthPots = healthPots;
    }

    public int getMonstersDefeated() {
        return monstersDefeated;
    }

    public void setMonstersDefeated(int monstersDefeated) {
        this.monstersDefeated = monstersDefeated;
    }

    public int getDungeonLevel() {
        return dungeonLevel;
    }

    public void setDungeonLevel(int dungeonLevel) {
        this.dungeonLevel = dungeonLevel;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }


    public int useSpell(Character character) {
        int randomChance = (int) (Math.floor(Math.random() * 100));
        if (randomChance > 50) {
            int damage = getCurrentWeapon().getDamage() * 2;
            character.damageTaken(damage);
            if (!character.isAlive()) {
                getLoot();
                incrementEnemies();
            }
            return damage;
        }
        return 0;
    }

    public String useHpPotion() {
        if (healthPots < 1) {
            return "You don't have any HP potions left!";

        } else if (getHp() <= 70) {
            setHp(getHp() + 30);
            if (getHp() > 100) {
                setHp(100);
            }
            healthPots--;
            return "You used a health potion and restored 30 hit points!";

        } else if (getHp() > 70 && getHp() < 100) {
            int currentHp = getHp();
            setHp(getHp() + 30);
            if (getHp() > 100) {
                setHp(100);
            }
            healthPots--;
            return "You used a health potion and restored " + (100 - currentHp) + " hit points!";
        } else {
            return "You already have maximum life.\n Don't be a chicken. Face your enemy!";
        }
    }


    public boolean runAway() {
        int randomChance = (int) (Math.floor(Math.random() * 100));
        if (randomChance > 50) {
            return true;
        } else {
            return false;
        }
    }

    public void incrementEnemies() {
        monstersDefeated++;
    }

    public void resetEnemies() {
        monstersDefeated = 0;
    }

    public void incrementLevelIfNeeded() {
        if (monstersDefeated == 5) {
            resetEnemies();
            dungeonLevel++;
        }
    }

    public void attackAndLoot(Character character) {
        attack(character);
        if (!character.isAlive()) {
            points++;
            getLoot();
        }
    }

    @Override
    public void damageTaken(int damage) {
        int calculus = damage - getCurrentArmor().getDamageReduction();
        if (calculus > 0) {
            setHp(getHp() - calculus);
        }
    }

    public void getLoot() {
        int randomChance = (int) (Math.floor(Math.random() * 100));
        if (randomChance > 50) {
            int randomItem = (int) (Math.floor(Math.random() * 3));
            switch (randomItem) {
                case 0:
                    WeaponFactory wf = new WeaponFactory();
                    Weapon weapon = wf.makeWeapon(dungeonLevel);

                    if (weapon.getDamage() > getCurrentWeapon().getDamage()) {
                        setCurrentWeapon(weapon);
                    }
                    break;
                case 1:
                    ArmorFactory af = new ArmorFactory();
                    Armor armor = af.makeArmor(dungeonLevel);
                    if (armor.getDamageReduction() > getCurrentArmor().getDamageReduction()) {
                        setCurrentArmor(armor);
                    }
                    break;
                case 2:
                    healthPots++;
                    break;
            }

        }

    }

    @Override
    public String toString() {
        int hp = getHp();
        String weaponName = getCurrentWeapon().getName();
        String armorName = getCurrentArmor().getName();
        int weaponDamage = getCurrentWeapon().getDamage();
        int armorDamageReduction = getCurrentArmor().getDamageReduction();
        int healthPots = getHealthPots();
        int level = getDungeonLevel();
        return "HP: " + hp + "\t\t\t Weapon: " + weaponName + " (" + weaponDamage + ")\n" +
                "Health Pots: " + healthPots + "\t\t\t Level: " + level + "\n" +
                "Armor: " + armorName + " (" + armorDamageReduction + ")\t\t Enemies killed: " + points;
    }
}
