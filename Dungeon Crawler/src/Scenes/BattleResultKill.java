package Scenes;

import GUI.Choice;
import GUI.GUI;


public class BattleResultKill extends Scene {

    public BattleResultKill(GUI gui) {
        super(gui);
    }

    @Override
    public String title() {
        return "";
    }

    @Override
    public String description() {
        return "You defeated the enemy!";
    }

    @Override
    public Choice[] options() {
        Choice[] choices = new Choice[2];
        choices[0]= Choice.KEEP_GOING;
        choices[1]= Choice.SAVE;
        return choices;
    }


    @Override
    public SceneType getSceneType() {
        return SceneType.BATTLE_RESULT_KILL;
    }
}
