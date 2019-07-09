package OtherGameComponents.Enemy;

public class Level3Enemy extends Enemy{

    public Level3Enemy() {
        super();
        setName(randomizeName(levelThreeEnemies));
        setHp(randomizeHP(16,20));
        setCurrentWeapon(randomizeWeapon(3));

    }


    private String[] levelThreeEnemies = {"Basilisk", "Dungeon Mummy", "Headless Horseman", "Manticore", "Gremlin King", "Dark Spirit", "Lich King"};
}
