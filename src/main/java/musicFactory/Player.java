package musicFactory;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Player extends Object implements Collidable
{
    private double speed;


    public Player()
    {
        super
        (
            new Image(Objects.requireNonNull(Player.class.getResourceAsStream("sprites/player.png"))),
            new Point2D
            (
                Settings.getScreenWidth() / 2F - spriteSize / 2F,
                Settings.getScreenHeight() / 2F - spriteSize / 2F
            ),
            new Point2D(0, 0),
            Direction.down
        );
        speed = 1.5 / 100d;
    }

    @Override
    public void drawInternal(GraphicsContext gc)
    {
        gc.drawImage(getSprite(), screenPosition.getX(), screenPosition.getY());
    }

    @Override
    public void simulate(double deltaTime)
    {
        // Input processing
        if(InputHandler.isMoveUp() && InputHandler.isMoveRight())
        {
            direction = Direction.up_right;
        }
        else if(InputHandler.isMoveUp() && InputHandler.isMoveLeft())
        {
            direction = Direction.up_left;
        }
        else if(InputHandler.isMoveDown() && InputHandler.isMoveRight())
        {
            direction = Direction.down_right;
        }
        else if(InputHandler.isMoveDown() && InputHandler.isMoveLeft())
        {
            direction = Direction.down_left;
        }
        else if(InputHandler.isMoveUp())
        {
            direction = Direction.up;
        }
        else if(InputHandler.isMoveDown())
        {
            direction = Direction.down;
        }
        else if(InputHandler.isMoveRight())
        {
            direction = Direction.right;
        }
        else if(InputHandler.isMoveLeft())
        {
            direction = Direction.left;
        }

        if(InputHandler.isMove()) { move(); }
    }

    private static final double diagonalScale = Math.sin(45);

    @Nullable
    private Point2D getNewPos() {
        Point2D newPos = null;

        switch(direction)
        {
            case up ->          { newPos = new Point2D(0, -speed); }
            case down ->        { newPos = new Point2D(0, speed);  }
            case left ->        { newPos = new Point2D(-speed, 0); }
            case right ->       { newPos = new Point2D(speed, 0);  }
            case up_right ->    { newPos = new Point2D( speed * diagonalScale, -speed * diagonalScale); }
            case up_left ->     { newPos = new Point2D(-speed * diagonalScale, -speed * diagonalScale); }
            case down_right ->  { newPos = new Point2D( speed * diagonalScale,  speed * diagonalScale); }
            case down_left ->   { newPos = new Point2D(-speed * diagonalScale,  speed * diagonalScale); }
        }
        return newPos;
    }

    public void move()
    {
        worldPosition = worldPosition.add(getNewPos());
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setDirection(Direction direction) { this.direction = direction; }

    @Override
    public boolean intersect(Rectangle2D another)
    {
        return getBoundingBox().contains(another);
    }

    @Override
    public void hitBy(Collidable another)
    {
        worldPosition = worldPosition.subtract(Objects.requireNonNull(getNewPos()).multiply(2));
        /*
        Point2D newPos = null;
        Point2D anotherPos = ((Object) another).getWorldPosition();
        switch(direction)
        {
            case up ->          {newPos = new Point2D(worldPosition.getX(), anotherPos.getY() + 1.01); }
            case down ->        {newPos = new Point2D(worldPosition.getX(), anotherPos.getY() - 0.01); }
            case left ->        {newPos = new Point2D(anotherPos.getX() + 1.01, worldPosition.getY()); }
            case right ->       {newPos = new Point2D(anotherPos.getX() - 0.01, worldPosition.getY()); }

            case up_right ->    {newPos = worldPosition; }
            case up_left ->     {newPos = worldPosition; }
            case down_right ->  {newPos = worldPosition; }
            case down_left ->   {newPos = worldPosition; }

        }
        worldPosition = newPos;
         */
    }
}