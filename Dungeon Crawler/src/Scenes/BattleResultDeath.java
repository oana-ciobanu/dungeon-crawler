package Scenes;


import GUI.Choice;
import GUI.GUI;

public class BattleResultDeath extends Scene {


    public BattleResultDeath(GUI gui) {
        super(gui);
    }

    @Override
    public String title() {
        return "";
    }

    @Override
    public String description() {
        return "You have died!";
    }


    @Override
    public Choice[] options() {
        Choice[] choices = new Choice[1];
        choices[0]= Choice.TRY_AGAIN;
        return choices;
    }

    @Override
    public SceneType getSceneType() {
        return SceneType.BATTLE_RESULT_DEATH;
    }
}
