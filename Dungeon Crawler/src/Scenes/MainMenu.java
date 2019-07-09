package Scenes;


import GUI.Choice;
import GUI.GUI;

public class MainMenu extends Scene {

    public MainMenu(GUI userInterface){
        super(userInterface);
    }

    @Override
    public String title() {

        return"                                        ";
    }


    @Override
    public String description() {
        return "This is Dungeon Crawler. Are you ready to play?";
    }


    @Override
    public Choice[] options() {
        Choice[] choices = new Choice[3];
        choices[0] = Choice.PLAY;
        choices[1] = Choice.LOAD;
        choices[2] = Choice.HIGHSCORE;

        return choices;
    }

    @Override
    public SceneType getSceneType() {
        return SceneType.MAIN_MENU;

    }
}

