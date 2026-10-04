package musicFactory;


public class Settings
{
    private static Settings instance;

    private int screenWidth;
    private int screenHeight;

    private int moveUp;
    private int moveDown;
    private int moveLeft;
    private int moveRight;

    private Settings()
    {
        this.screenWidth = 800;
        this.screenHeight = 600;


        // TODO lepší řešení input mapy
        /*
        moveUp =    KeyEvent.VK_W;
        moveDown =  KeyEvent.VK_S;
        moveLeft =  KeyEvent.VK_A;
        moveRight = KeyEvent.VK_D;
        */
    }

    public static Settings getInstance()
    {
        if(instance == null)
        {
            instance = new Settings();
        }

        return instance;
    }

    public int getScreenWidth() { return screenWidth; }

    public int getScreenHeight() { return screenHeight; }

    public int getMoveUp() { return moveUp; }

    public int getMoveDown() { return moveDown; }

    public int getMoveLeft() { return moveLeft; }

    public int getMoveRight() { return moveRight; }
}
