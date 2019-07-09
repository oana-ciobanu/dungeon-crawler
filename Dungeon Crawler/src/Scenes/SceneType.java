package Scenes;

public enum SceneType {
    MAIN_MENU("MainMenu"),
    NEW_GAME("NewGame"),
    DUNGEON_ENTRY("DungeonEntry"),
    ENCOUNTER("Encounter"),
    HIT("Hit"),
    BATTLE_RESULT_KILL("BattleResultKill"),
    BATTLE_RESULT_DEATH("BattleResultDeath"),
    USE_HP_POTION("UseHpPotion"),
    ESCAPE_MONSTER("EscapeMonster"),
    NOT_ESCAPE("NotEscape"),
    HIGH_SCORE("HighScore"),
    WIN_GAME("WinGame");


    private String label;

    SceneType(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }


}
