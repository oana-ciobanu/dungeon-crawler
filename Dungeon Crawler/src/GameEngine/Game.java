package GameEngine;

import GUI.GUI;
import Highscores.HighScoreManager;
import OtherGameComponents.Armor.Level1Armor;
import OtherGameComponents.Enemy.Enemy;
import OtherGameComponents.Enemy.Level1Enemy;
import OtherGameComponents.Player;
import OtherGameComponents.Weapon.Level1Weapon;
import Scenes.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Duration;
import java.time.Instant;

public class Game implements IBattlefield {

    choiceHandler cHandler = new choiceHandler();
    GUI gui = new GUI();
    BattleField battleField = new BattleField();
    Scene currentScene;
    HighScoreManager hm = new HighScoreManager();
    Instant start;

    public Game() {

        gui.createGUI(cHandler);
        battleField.setBattleFieldListener(this);
        presentMainMenuScene();
    }


    public static void main(String[] args) {
        new Game();
    }

    public void showPlayerStats() {
        Player player = battleField.getPlayer();
        currentScene.displayTitle(player.toString());
    }

// METODE DE SETAT SCENE

    void presentMainMenuScene() {
        currentScene = new MainMenu(gui);
        currentScene.show();
        start = Instant.now();
        System.out.println("start time: " + start);
    }


    void presentLoadedScene() {
        loadGame("saveGame.dat");
        gui.titleTextArea.setVisible(true);
        showPlayerStats();
    }


    void presentNewGameScene() {
        currentScene = new NewGame(gui);
        currentScene.show();
    }


    void presentDungeonEntryScene() {
        currentScene = new DungeonEntry(gui);
        String insertedName = gui.userInput.getText();
        Player player = battleField.getPlayer();

        if (insertedName != null && !insertedName.isEmpty()) {
            player.setName(insertedName);
            if (insertedName.equals("CHEATER")) {
                player.getCurrentWeapon().setDamage(100);
                player.getCurrentArmor().setDamageReduction(100);
            }
        }
        currentScene.show();
    }


    void presentEncounterScene() {
        currentScene = new Encounter(gui);
        currentScene.show();
        showPlayerStats();

        Enemy currentEnemy = battleField.getCurrentEnemy();
        String enemyDescription = "You encounter " + currentEnemy.toString();
        currentScene.displayDescription(enemyDescription);
    }


    void presentHitScene() {
        currentScene = new Hit(gui);
        currentScene.show();
        showPlayerStats();

        Enemy currentEnemy = battleField.getCurrentEnemy();
        String enemyDescription = currentEnemy.toString();
        currentScene.displayDescription(enemyDescription);
    }


    void presentUseHealthPotionsScene() {
        Player player = battleField.getPlayer();
        String hpPotion = player.useHpPotion();
        currentScene.displayDescription(hpPotion);
        currentScene.displayTitle(player.toString());
    }


    void presentGameOverScene() {
        Player player = battleField.getPlayer();
        currentScene = new BattleResultDeath(gui);
        currentScene.show();

        Instant finish = Instant.now();
        System.out.println("finish time: " + finish);
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("time elapsed game over: " + timeElapsed);
        player.setHighScore(1000000 / (int) timeElapsed * player.getPoints());
        String gameOver = "You just died " + player.getName() + "!\n"
                + "Your score is: " + player.getHighScore();

        currentScene.displayDescription(gameOver);
        hm.addScore(player.getName(), player.getHighScore());

        resetStats();
    }


    void presentHighScoreScene() {
        currentScene = new HighScore(gui);
        currentScene.show();
        String scores = hm.getHighscoreString();
        currentScene.displayDescription(scores);
    }

    void presentBattleResultKillScene() {
        Player player = battleField.getPlayer();
        currentScene = new BattleResultKill(gui);
        currentScene.show();

        String levelPass = "Congratulations " + player.getName() + "!\n" +
                "You have reached level " + player.getDungeonLevel() + ".";

        if (battleField.checkPoints()) {
            currentScene.displayDescription(levelPass);
        }
        currentScene.displayTitle(player.toString());
    }

    void presentEscapeMonsterScene() {

        currentScene = new EscapeMonster(gui);
        currentScene.show();
        showPlayerStats();
    }

    void presentNotEscapeScene() {
        currentScene = new NotEscape(gui);
        currentScene.show();
    }

    void presentWinGameScene() {
        Player player = battleField.getPlayer();
        currentScene = new WinGame(gui);
        currentScene.show();

        Instant finish = Instant.now();
        System.out.println("finish time: " + finish);
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("time elapsed win game: " + timeElapsed);
        player.setHighScore(1000000 / (int) timeElapsed * player.getPoints());

        String levelPass = "                    Congratulations " + player.getName() + "!\n" +
                "                    You escaped the dungeon. \n" +
                "                    Your score is: " + player.getHighScore();

        currentScene.displayDescription(levelPass);
        hm.addScore(player.getName(), player.getHighScore());
        resetStats();
    }


    void resetStats() {
        Player player = battleField.getPlayer();
        battleField.currentEnemy = new Level1Enemy();
        player.setPoints(0);
        player.setHealthPots(3);
        player.setHp(100);
        player.setCurrentArmor(new Level1Armor());
        player.setCurrentWeapon(new Level1Weapon());
        player.setMonstersDefeated(0);
        player.setDungeonLevel(1);
        player.setHighScore(0);
    }


// METODE INTERFATA iBATTLEFIELD

    @Override
    public void GameOver() {
        presentGameOverScene();
    }


    @Override
    public void EnemyKilled() {
        Player player = battleField.getPlayer();
        if (player.getDungeonLevel() == 6) {
            presentWinGameScene();
        } else {
            presentBattleResultKillScene();
        }
    }


    @Override
    public void UseSpellFinished(int damage) {
        showPlayerStats();

        Enemy enemy = battleField.getCurrentEnemy();
        String useSpellDescription;
        if (damage == 0) {
            useSpellDescription = "You used a spell but missed the target! \n" +
                    "The " + enemy.getName() + " attacked you for " + enemy.getCurrentWeapon().getDamage() + " damage.\n\n" +
                    "The " + enemy.getName() + " HP is " + enemy.getHp();
        } else {
            useSpellDescription = "You used a spell and hit the " + enemy.getName() + " for " + damage + " damage.\n" +
                    "The " + enemy.getName() + " attacked you for " + enemy.getCurrentWeapon().getDamage() + " damage.\n\n" +
                    "The " + enemy.getName() + " hp is " + enemy.getHp();
        }

        currentScene.displayDescription(useSpellDescription);
    }


    @Override
    public void RunAwayFinishedOrNot() {
        Player player = battleField.getPlayer();
        boolean didThePlayerEscaped = player.runAway();
        battleField.escapeOrNot(didThePlayerEscaped);
    }


    @Override
    public void RunAwayAndEscaped() {
        presentEscapeMonsterScene();
    }


    @Override
    public void TriedToEscapeAndGotCaught() {
        Enemy enemy = battleField.getCurrentEnemy();
        presentNotEscapeScene();

        String triedToRunAwayButGotCaught = "You tried to run away, but the " + enemy.getName() + " caught you!\n" +
                "The monster attacked you for " + enemy.getCurrentWeapon().getDamage() + " damage.\n\n ";
        showPlayerStats();
        currentScene.displayDescription(triedToRunAwayButGotCaught);
    }

    @Override
    public void HitAgain() {
        presentHitScene();
        Player player = battleField.getPlayer();
        currentScene.displayTitle(player.toString());

        Enemy currentEnemy = battleField.getCurrentEnemy();
        String enemyDescription = "You hit the " + currentEnemy.getName() + " for " + player.getCurrentWeapon().getDamage() + " damage.\n" + currentEnemy.enemyStats();
        currentScene.displayDescription(enemyDescription);
    }


// HANDLER

    public class choiceHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("actionPerformed");
            String yourChoice = event.getActionCommand();

// GAME LOGIC SWITCH

            switch (yourChoice) {
                case "c1":
                    if (currentScene.getSceneType() == SceneType.MAIN_MENU) {
                        presentNewGameScene();

                    } else if (currentScene.getSceneType() == SceneType.NEW_GAME) {
                        presentDungeonEntryScene();

                    } else if (currentScene.getSceneType() == SceneType.DUNGEON_ENTRY) {
                        presentEncounterScene();

                    } else if (currentScene.getSceneType() == SceneType.ENCOUNTER) {
                        presentHitScene();
                        battleField.fight();

                    } else if (currentScene.getSceneType() == SceneType.HIT) {
                        presentHitScene();
                        battleField.fight();

                    } else if (currentScene.getSceneType() == SceneType.USE_HP_POTION) {
                        presentHitScene();
                        battleField.fight();

                    } else if (currentScene.getSceneType() == SceneType.BATTLE_RESULT_KILL) {
                        battleField.keepGoing();
                        presentEncounterScene();

                    } else if (currentScene.getSceneType() == SceneType.ESCAPE_MONSTER) {
                        battleField.keepGoing();
                        presentEncounterScene();

                    } else if (currentScene.getSceneType() == SceneType.NOT_ESCAPE) {
                        battleField.fight();

                    } else if (currentScene.getSceneType() == SceneType.BATTLE_RESULT_DEATH) {
                        presentMainMenuScene();

                    } else if (currentScene.getSceneType() == SceneType.WIN_GAME) {
                        presentMainMenuScene();

                    } else if (currentScene.getSceneType() == SceneType.HIGH_SCORE) {
                        presentMainMenuScene();
                    }
                    break;

                case "c2":
                    if (currentScene.getSceneType() == SceneType.ENCOUNTER) {
                        battleField.useSpell();


                    } else if (currentScene.getSceneType() == SceneType.HIT) {
                        battleField.useSpell();

                    } else if (currentScene.getSceneType() == SceneType.NOT_ESCAPE) {
                        battleField.useSpell();

                    } else if (currentScene.getSceneType() == SceneType.USE_HP_POTION) {
                        battleField.useSpell();

                    } else if (currentScene.getSceneType() == SceneType.MAIN_MENU) {
                        presentLoadedScene();

                    } else if (currentScene.getSceneType() == SceneType.BATTLE_RESULT_DEATH) {
                        presentHighScoreScene();

                    } else if (currentScene.getSceneType() == SceneType.WIN_GAME) {
                        presentHighScoreScene();

                    } else if (currentScene.getSceneType() == SceneType.BATTLE_RESULT_KILL) {
                        Player player = battleField.getPlayer();
                        Enemy currentEnemy = battleField.getCurrentEnemy();

                        saveGame(player, currentEnemy, currentScene.getSceneType());
                    }
                    break;

                case "c3":
                    if (currentScene.getSceneType() == SceneType.ENCOUNTER) {
                        presentUseHealthPotionsScene();

                    } else if (currentScene.getSceneType() == SceneType.HIT) {
                        presentUseHealthPotionsScene();

                    } else if (currentScene.getSceneType() == SceneType.USE_HP_POTION) {
                        presentUseHealthPotionsScene();

                    } else if (currentScene.getSceneType() == SceneType.NOT_ESCAPE) {
                        presentUseHealthPotionsScene();

                    } else if (currentScene.getSceneType() == SceneType.MAIN_MENU) {
                        presentHighScoreScene();
                    }
                    break;

                case "c4":
                    if (currentScene.getSceneType() == SceneType.ENCOUNTER) {
                        RunAwayFinishedOrNot();


                    } else if (currentScene.getSceneType() == SceneType.NOT_ESCAPE) {
                        RunAwayFinishedOrNot();

                    } else if (currentScene.getSceneType() == SceneType.HIT) {
                        RunAwayFinishedOrNot();

                    } else if (currentScene.getSceneType() == SceneType.USE_HP_POTION) {
                        RunAwayFinishedOrNot();

                    }
                    break;


            }

        }
    }
//// METODE SAVE GAME / LOAD GAME

    private void saveGame(Player player, Enemy enemy, SceneType currentSceneType) {
        String fileName = "saveGame.dat";

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(player);
            oos.writeObject(enemy);
            oos.writeObject(currentSceneType);

            System.out.println("Done writing");
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadGame(String s) {


        if (s.contains(".dat")) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(s));
                Player player2 = (Player) ois.readObject();
                Enemy enemy2 = (Enemy) ois.readObject();
                SceneType currentSceneType = (SceneType) ois.readObject();


                battleField.player.setPoints(player2.getPoints());
                battleField.player.setHealthPots(player2.getHealthPots());
                battleField.player.setHp(player2.getHp());
                battleField.player.setName(player2.getName());
                battleField.player.setCurrentArmor(player2.getCurrentArmor());
                battleField.player.setCurrentWeapon(player2.getCurrentWeapon());
                battleField.player.setMonstersDefeated(player2.getMonstersDefeated());
                battleField.player.setDungeonLevel(player2.getDungeonLevel());


                battleField.currentEnemy.setCurrentWeapon(enemy2.getCurrentWeapon());
                battleField.currentEnemy.setName(enemy2.getName());
                battleField.currentEnemy.setHp(enemy2.getHp());


                if (currentSceneType == SceneType.BATTLE_RESULT_KILL) ;
                presentBattleResultKillScene();

                ois.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

