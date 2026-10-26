package musicFactory;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Instrument extends Object implements Collidable
{
    public enum InstrumentType
    {
        guitar,
        bassguitar
    };

    public Instrument(InstrumentType instrumentType, Point2D worldPosition)
    {
        super(new Image(Instrument.class.getResourceAsStream("sprites/instruments/" + instrumentType.toString() + "Source.png")), worldPosition, Direction.neutral);
        // System.out.println("sprites/instruments/" + instrumentType.toString() + "Source.png");
    }

    @Override
    public boolean intersect(Rectangle2D another) { return getBoundingBox().intersects(another); }

    @Override
    public void hitBy(Collidable another)
    {

    }

    @Override
    protected void drawInternal(GraphicsContext gc)
    {
        gc.drawImage(getSprite(), screenPosition.getX(), screenPosition.getY());
    }

    @Override
    public void simulate(double deltaTime)
    {

    }
}
