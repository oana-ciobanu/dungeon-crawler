package Scenes;

import GUI.Choice;
import GUI.GUI;

import java.awt.*;

public class HighScore extends Scene{

    public HighScore(GUI gui) {
        super(gui);
    }


    @Override
    public String title() {
        return "Hall of Fame:";
    }

    @Override
    public String description() {
        return null;
    }


    @Override
    public Choice[] options() {
        Choice[] choices = new Choice[1];
        choices[0] = Choice.GO_BACK;
        return choices;
    }
    @Override
    public SceneType getSceneType() {
        return SceneType.HIGH_SCORE;
    }
}

