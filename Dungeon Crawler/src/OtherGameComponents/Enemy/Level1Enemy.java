package OtherGameComponents.Enemy;

public class Level1Enemy extends Enemy {

    public Level1Enemy() {

        setName(randomizeName(levelOneEnemies));
        setHp(randomizeHP(5, 10));
        setCurrentWeapon(randomizeWeapon(1));



    }


    private String[] levelOneEnemies = {"Slimy Bat", "Deadly Serpent", "Weird Rat", "Dungeon Critter", "Giant Spider", "Stone Golem"};
}
