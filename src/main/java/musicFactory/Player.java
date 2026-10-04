package musicFactory;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

public class Player extends Object
{
    private static Player instance;

    private double speed;
    private Direction direction;
    private Rectangle2D collisionBox;
    private Point2D position;

    private Player()
    {
        super(new Image(Objects.requireNonNull(Player.class.getResourceAsStream("sprites/player.png"))));
        speed = 5;
        direction = Direction.DOWN;
        position = new Point2D((double) Settings.getInstance().getScreenWidth() / 2 - getSprite().getWidth() / 2,
                               (double) Settings.getInstance().getScreenHeight() / 2 - getSprite().getHeight() / 2);
    }

    public static Player getPlayer()
    {
        if(instance == null)
        {
            instance = new Player();
        }
        return instance;
    }

    @Override
    void draw(GraphicsContext gc)
    {
        gc.drawImage(getSprite(), position.getX(), position.getY());
    }

    void move()
    {
        Point2D newPos = null;
        switch(direction)
        {
            case UP ->      { newPos = new Point2D(0, -speed); }
            case DOWN ->    { newPos = new Point2D(0, speed);  }
            case LEFT ->    { newPos = new Point2D(-speed, 0); }
            case RIGHT ->   { newPos = new Point2D(speed, 0);  }
        }
        position = position.add(newPos);
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setDirection(Direction direction) { this.direction = direction; }
}