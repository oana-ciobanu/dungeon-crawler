package OtherGameComponents.Enemy;


public class EnemyFactory {


    public Enemy makeEnemy(int levelNumber) {

        switch (Integer.valueOf(levelNumber)) {
            case 1:
                return new Level1Enemy();
            case 2:
                return new Level2Enemy();
            case 3:
                return new Level3Enemy();
            case 4:
                return new Level4Enemy();
            case 5:
                return new Level5Enemy();
            default:
                return null;
        }
    }

}
