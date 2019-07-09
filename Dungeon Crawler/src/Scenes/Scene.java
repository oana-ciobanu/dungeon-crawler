package Scenes;


import GUI.Choice;
import GUI.GUI;

public abstract class Scene {

    public Scene(GUI gui) {
        this.gui = gui;
    }

    GUI gui;

    public abstract String title(); // Top area

    public abstract String description(); //Mid Area

    public abstract Choice[] options(); //Buttons


    public abstract SceneType getSceneType();


    public void displayDefaultTitle() {
        gui.titleTextArea.setText(title());
    }

    public void displayDefaultDescription() {
        gui.mainTextArea.setText(description());
    }

    public void displayDefaultInput() {
        gui.userInput.setVisible(false);
    }

    public void displayOptions() {
        Choice[] choices = options();
        //clear  buttons if needed;
        gui.choice1.setVisible(false);
        gui.choice2.setVisible(false);
        gui.choice3.setVisible(false);
        gui.choice4.setVisible(false);
        for (int i = 0; i < choices.length; i++) {
            switch (i) {
                case 0:
                    gui.choice1.setText(choices[i].toString());
                    gui.choice1.setVisible(true);
                    break;
                case 1:
                    gui.choice2.setText(choices[i].toString());
                    gui.choice2.setVisible(true);
                    break;
                case 2:
                    gui.choice3.setText(choices[i].toString());
                    gui.choice3.setVisible(true);
                    break;
                case 3:
                    gui.choice4.setText(choices[i].toString());
                    gui.choice4.setVisible(true);
                    break;
            }
        }

    }

    public void displayTitle(String title) {
        if (title == null) {
            displayDefaultTitle();
        } else {
            gui.titleTextArea.setText(title);
        }
    }

    public void displayDescription(String description) {
        if (description == null) {
            displayDefaultDescription();
        } else {
            gui.mainTextArea.setText(description);
        }
    }

    public void show() {
        displayDefaultTitle();
        displayDefaultDescription();
        displayDefaultInput();
        displayOptions();
    }


}

