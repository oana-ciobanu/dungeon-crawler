package GameEngine;

import OtherGameComponents.Enemy.Enemy;
import OtherGameComponents.Enemy.EnemyFactory;
import OtherGameComponents.Player;

public class BattleField {

    IBattlefield battleFieldListener;

    Player player = new Player();
    EnemyFactory ef = new EnemyFactory();
    Enemy currentEnemy = ef.makeEnemy(1);


    public Player getPlayer() {
        return player;
    }

    public Enemy getCurrentEnemy() {
        return currentEnemy;
    }


    public void setBattleFieldListener(IBattlefield battleFieldListener) {
        this.battleFieldListener = battleFieldListener;
    }


    public void keepGoing() {
        currentEnemy = ef.makeEnemy(player.getDungeonLevel());
    }

    public void fight() {
        player.attackAndLoot(currentEnemy);
        if (currentEnemy.isAlive()) {
            currentEnemy.attack(player);
            if (!player.isAlive()) {
                if (battleFieldListener != null) {
                    battleFieldListener.GameOver();
                }
            } else {
                battleFieldListener.HitAgain();
            }
        } else {
            player.incrementEnemies();
            player.incrementLevelIfNeeded();
            battleFieldListener.EnemyKilled();
        }
    }

    public void useSpell() {

        int damage = player.useSpell(currentEnemy);
        if (currentEnemy.isAlive()) {
            currentEnemy.attack(player);
            if (player.isAlive()) {
                battleFieldListener.UseSpellFinished(damage);
            } else {
                battleFieldListener.GameOver();
            }
        } else {
            player.setPoints(player.getPoints()+1);
            player.incrementLevelIfNeeded();
            battleFieldListener.EnemyKilled();
        }
    }

    public void escapeOrNot(boolean didThePlayerEscaped) {

        if (didThePlayerEscaped) {
            battleFieldListener.RunAwayAndEscaped();
        } else {
            currentEnemy.attack(player);
            if (player.isAlive()) {
                battleFieldListener.TriedToEscapeAndGotCaught();


            } else {
                battleFieldListener.GameOver();
            }
        }
    }

    public boolean checkPoints() {
        if (player.getPoints() % 5 == 0 && player.getPoints() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
