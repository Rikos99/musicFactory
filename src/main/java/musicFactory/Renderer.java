package musicFactory;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Renderer extends AnimationTimer
{
    private final Canvas canvas;
    private final GraphicsContext gc;
    private long lastFrame = 0;

    public Renderer(Canvas canvas)
    {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
    }
    // Draws objects
    @Override
    public void handle(long now)
    {
        double delta = lastFrame == 0 ? 0 : (now - lastFrame) / 1_000_000_000D;
        lastFrame = now;
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        Player.getPlayer().draw(gc);
    }
}
