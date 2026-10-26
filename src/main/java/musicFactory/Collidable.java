package musicFactory;

import javafx.geometry.Rectangle2D;

public interface Collidable
{
    Rectangle2D getBoundingBox();
    boolean intersect(Rectangle2D another);
    void hitBy(Collidable another);
}
