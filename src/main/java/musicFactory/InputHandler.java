package musicFactory;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class InputHandler
{
    private static boolean moveUp = false;
    private static boolean moveDown = false;
    private static boolean moveLeft = false;
    private static boolean moveRight = false;


    public static void handlePress(KeyEvent keyEvent)
    {
        if(keyEvent.getCode() == Settings.getMoveUpKey())
        {
            moveUp = true;
        }
        if(keyEvent.getCode() == Settings.getMoveDownKey())
        {
            moveDown = true;
        }
        if(keyEvent.getCode() == Settings.getMoveLeftKey())
        {
            moveLeft = true;
        }
        if(keyEvent.getCode() == Settings.getMoveRightKey())
        {
            moveRight = true;
        }
    }
    public static void handleRelease(KeyEvent keyEvent)
    {
        if(keyEvent.getCode() == Settings.getMoveUpKey())
        {
            moveUp = false;
        }
        if(keyEvent.getCode() == Settings.getMoveDownKey())
        {
            moveDown = false;
        }
        if(keyEvent.getCode() == Settings.getMoveLeftKey())
        {
            moveLeft = false;
        }
        if(keyEvent.getCode() == Settings.getMoveRightKey())
        {
            moveRight = false;
        }
    }

    public static boolean isMoveUp()
    {
        return moveUp;
    }

    public static boolean isMoveDown()
    {
        return moveDown;
    }

    public static boolean isMoveLeft()
    {
        return moveLeft;
    }

    public static boolean isMoveRight()
    {
        return moveRight;
    }

    public static boolean isMove()
    {
        return moveUp || moveDown || moveLeft || moveRight;
    }
}
