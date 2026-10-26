package musicFactory;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.*;

public class World implements DrawableSimulable
{
    private static World instance;

    private Image backgroundTile;
    private Point2D backgroundOffset;
    private final List<DrawableSimulable> worldObjects = new ArrayList<>();
    private Player player;

    public final static Random random = new Random();

    private World()
    {
        backgroundTile = new Image(Objects.requireNonNull(getClass().getResourceAsStream("sprites/tileBG.png")));
        backgroundOffset = new Point2D
        (
        64 - (((Settings.getScreenWidth() / 2F) - (Object.spriteSize / 2F)) % 64),
        64 - (((Settings.getScreenHeight() / 2F) - (Object.spriteSize / 2F)) % 64)
        );
        player = new Player();
        worldObjects.add(player);

        for (int i = 0; i < 5; i++)
        {
            Point2D randomPos;
            boolean exists;
            do
            {
                randomPos = new Point2D(random.nextInt(-5, 5), random.nextInt(-5, 5));
                exists = false;
                for (DrawableSimulable worldObject : worldObjects)
                {
                    if(((Object) worldObject).getWorldPosition().equals(randomPos))
                    {
                        exists = true;
                    }
                }
            }
            while (exists);

            worldObjects.add(new Instrument(Instrument.InstrumentType.guitar, randomPos));
        }
    }

    public static World getWorld()
    {
        if(instance == null)
        {
            instance = new World();
        }
        return instance;
    }


    @Override
    public void draw(GraphicsContext gc)
    {
        Point2D playerPos = World.getWorld().getPlayer().getWorldPosition();
        Point2D playerOffset = new Point2D(playerPos.getX() - (int) playerPos.getX(), playerPos.getY() - (int) playerPos.getY());
        // System.out.println("Pos: " + playerPos.getX() + ":" + playerPos.getY() + " | Off : " + playerOffset.getX() + ":" + playerOffset.getY());

        for (int x = (int) (0 - backgroundOffset.getX()); x < Settings.getScreenWidth(); x += 64)
        {
            for (int y = (int) (0 - backgroundOffset.getY()); y < Settings.getScreenWidth(); y += 64)
            {
                gc.drawImage(backgroundTile, x - playerOffset.getX() * Object.spriteSize, y - playerOffset.getY() * Object.spriteSize);
            }
        }
        for (DrawableSimulable worldObject : worldObjects)
        {
            worldObject.draw(gc);
        }
    }

    @Override
    public void simulate(double deltaTime)
    {
        for (DrawableSimulable object : worldObjects)
        {
            object.simulate(deltaTime);
        }

        for (DrawableSimulable o1 : worldObjects)
        {
            if(o1 instanceof Collidable c1)
            {
                for (DrawableSimulable o2 : worldObjects)
                {
                    if(!o1.equals(o2) && o2 instanceof Collidable c2)
                    {
                        if(c1.intersect(c2.getBoundingBox()))
                        {
                            c1.hitBy(c2);
                            c2.hitBy(c1);
                            // System.out.println(c1.getClass().getSimpleName() + " collided with " + c2.getClass().getSimpleName());
                        }
                    }
                }
            }
        }

        Main.getGameController().updateLabel(player.getWorldPosition());
    }

    public List<DrawableSimulable> getWorldObjects() { return worldObjects; }

    public Player getPlayer() { return player; }
}
