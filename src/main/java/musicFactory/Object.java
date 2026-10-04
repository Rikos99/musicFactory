package musicFactory;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

abstract class Object
{
    private Image sprite;

    protected Object(Image sprite)
    {
        this.sprite = sprite;
    }
    abstract void draw(GraphicsContext gc);

    public Image getSprite() { return sprite; }
}
