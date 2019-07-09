package GUI;

public enum Choice {
    PLAY ("Play"),
    LOAD ("Load game"),
    HIGHSCORE("Highscore"),

    OPEN_EYES("OK"),
    I_AM_READY("I am ready!"),

    FIGHT("Fight!"),
    USE_SPELL("Use Spell!"),
    USE_POTION("Use Potion!"),
    RUN("Run away"),
    HIT("Hit again!"),

    KEEP_GOING("Keep going"),
    GO_BACK("Go back"),
    SAVE("Save"),
    TRY_AGAIN("Try again");




    private String label;

    Choice(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
