package Scenes;


import GUI.Choice;
import GUI.GUI;

public class NewGame extends Scene {

    public NewGame(GUI gui) {
        super(gui);
    }

    @Override
    public String title() {
        return "";
    }

    @Override
    public String description() {
        return "                    What is your name, my hero? ";
    }

    @Override
    public void displayDefaultInput(){
        gui.userInput.setVisible(true);
    }

    @Override
    public Choice[] options() {
        Choice[] choices = new Choice[1];
        choices[0] = Choice.OPEN_EYES;

        return choices;
    }

    @Override
    public SceneType getSceneType() {
        return SceneType.NEW_GAME;
    }
}
