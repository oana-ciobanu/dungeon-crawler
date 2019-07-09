package Scenes;

import GUI.Choice;
import GUI.GUI;

import java.awt.*;

public class WinGame extends Scene {
    public WinGame(GUI gui) {
        super(gui);
    }

    @Override
    public String title() {
        return " ";
    }

    @Override
    public String description() {
        return "";
    }



    @Override
    public Choice[] options() {
        Choice[] choices = new Choice[2];
        choices[0] = Choice.TRY_AGAIN;
        choices[1] = Choice.HIGHSCORE;
        return choices;
    }

    @Override
    public SceneType getSceneType() {
        return SceneType.WIN_GAME;
    }
}
