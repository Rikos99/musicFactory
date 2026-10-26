package musicFactory;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Object implements DrawableSimulable
{
    public static final int spriteSize = 64;
    protected Image sprite;
    protected Point2D screenPosition;
    protected Point2D worldPosition;
    protected Direction direction;

    protected Object(Image sprite, Point2D screenPosition, Point2D worldPosition,  Direction direction)
    {
        this(sprite, worldPosition, direction);
        this.screenPosition = screenPosition;
    }
    protected Object(Image sprite, Point2D worldPosition, Direction direction)
    {
        this.sprite = sprite;
        this.worldPosition = worldPosition;
        this.direction = direction;
    }

    @Override
    public final void draw(GraphicsContext gc)
    {
        gc.save();
        updateScreenPosition();
        drawInternal(gc);
        gc.restore();
    }


    private void updateScreenPosition()
    {
        if(!(this instanceof Player))
        {
            Player player = World.getWorld().getPlayer();
            screenPosition = player.getScreenPosition().add(worldPosition.subtract(player.getWorldPosition()).multiply(spriteSize));
        }
    }

    public Rectangle2D getBoundingBox()
    {
        return new Rectangle2D(screenPosition.getX(), screenPosition.getY(), sprite.getWidth(), sprite.getHeight());
    }

    protected abstract void drawInternal(GraphicsContext gc);

    public Image getSprite() { return sprite; }
    public Point2D getScreenPosition() { return screenPosition; }
    public Point2D getWorldPosition() { return worldPosition; }
}
