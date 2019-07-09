package Scenes;

import GUI.Choice;
import GUI.GUI;

public class DungeonEntry extends Scene {

    public DungeonEntry(GUI gui) {
        super(gui);
    }

    @Override
    public String title() {
        return "";
    }

    @Override
    public String description() {
        return "You have a dungeon in front of you. The dungeon has 5 different levels. To pass a level you will have to defeat 5 monsters. Each monster has a chance to drop" +
                " a weapon, armor or a HP potion. Are you ready?";
    }

    @Override
    public Choice[] options() {
        Choice[] choices = new Choice[1];
        choices[0]= Choice.I_AM_READY;
        return choices;
    }


    @Override
    public SceneType getSceneType() {
        return SceneType.DUNGEON_ENTRY;
    }
}
