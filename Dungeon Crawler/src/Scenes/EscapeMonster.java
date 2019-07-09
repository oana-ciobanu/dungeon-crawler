package Scenes;

import GUI.Choice;
import GUI.GUI;

public class EscapeMonster extends Scene{

    public EscapeMonster(GUI gui) {
        super(gui);
    }

    @Override
    public String title() {
        return "";
    }

    @Override
    public String description() {
        return "You managed to escape the monster!";
    }


    @Override
    public Choice[] options() {
        Choice[] choices = new Choice[1];
        choices[0] = Choice.KEEP_GOING;
        return choices;
    }

    @Override
    public SceneType getSceneType() {
        return SceneType.ESCAPE_MONSTER;
    }
}
