package OtherGameComponents.Enemy;

public class Level4Enemy extends Enemy{

    public Level4Enemy() {
        setName(randomizeName(levelFourEnemies));
        setHp(randomizeHP(21,25));
        setCurrentWeapon(randomizeWeapon(4));

    }


    private String[] levelFourEnemies = {"Chimera", "Deadly Harpy", "Blood Titan", "Dungeon Demon", "Poltergeist", "Black Widow", "Orc Leader"};
}
