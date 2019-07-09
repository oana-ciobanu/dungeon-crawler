package OtherGameComponents.Enemy;

public class Level5Enemy extends Enemy{

    public Level5Enemy() {
        setName(randomizeName(levelFiveEnemies));
        setHp(randomizeHP(26,30));
        setCurrentWeapon(randomizeWeapon(5));

    }


    private String[] levelFiveEnemies = {"Ghoul", "Bloody Knight", "Titan Captain", "Pit Lord", "Troglodyte", "Cerberus", "Dungeon Windigo"};
}
