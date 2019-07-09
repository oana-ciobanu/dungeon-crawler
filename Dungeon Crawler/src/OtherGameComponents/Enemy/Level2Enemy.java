package OtherGameComponents.Enemy;

public class Level2Enemy extends Enemy{

    public Level2Enemy() {
        super();
        setName(randomizeName(levelTwoEnemies));
        setHp(randomizeHP(11,15));
        setCurrentWeapon(randomizeWeapon(2));

    }


    private String[] levelTwoEnemies = {"Chupacabra", "Banshee", "Death Bishop", "Dungeon Yeti", "Werewolf", "Cyclops", "Succubus"};
}
