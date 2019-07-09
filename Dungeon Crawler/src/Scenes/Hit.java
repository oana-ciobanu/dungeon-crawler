package Scenes;

import GUI.Choice;
import GUI.GUI;

public class Hit extends Scene {


    public Hit(GUI gui) {
        super(gui);
    }

    @Override
    public String title() {
        return "";
    }
    @Override
    public String description() {
        return "";
    }


    @Override
    public Choice[] options() {
        Choice[] choices = new Choice[4];
        choices[0] = Choice.HIT;
        choices[1] = Choice.USE_SPELL;
        choices[2] = Choice.USE_POTION;
        choices[3] = Choice.RUN;

        return choices;
    }

    @Override
    public SceneType getSceneType() {
        return SceneType.HIT;
    }
}


