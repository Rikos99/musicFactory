package musicFactory;


import javafx.scene.input.KeyCode;

public class Settings
{
    public static final int DEBUG = 1;

    private static int screenWidth = 1280;
    private static int screenHeight = 720;

    private static KeyCode moveUpKey = KeyCode.W;
    private static KeyCode moveDownKey = KeyCode.S;
    private static KeyCode moveLeftKey  = KeyCode.A;
    private static KeyCode moveRightKey  = KeyCode.D;

    public static int getScreenWidth() { return screenWidth; }
    public static void setScreenWidth(int screenWidth) { Settings.screenWidth = screenWidth; }
    public static int getScreenHeight() { return screenHeight; }
    public static void setScreenHeight(int screenHeight) { Settings.screenHeight = screenHeight; }
    public static KeyCode getMoveUpKey() { return moveUpKey; }
    public static void setMoveUpKey(KeyCode moveUpKey) { Settings.moveUpKey = moveUpKey; }
    public static KeyCode getMoveDownKey() { return moveDownKey; }
    public static void setMoveDownKey(KeyCode moveDownKey) { Settings.moveDownKey = moveDownKey; }
    public static KeyCode getMoveLeftKey() { return moveLeftKey; }
    public static void setMoveLeftKey(KeyCode moveLeftKey) { Settings.moveLeftKey = moveLeftKey; }
    public static KeyCode getMoveRightKey() { return moveRightKey; }
    public static void setMoveRightKey(KeyCode moveRightKey) { Settings.moveRightKey = moveRightKey; }
}
