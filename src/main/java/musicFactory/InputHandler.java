package musicFactory;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

// TODO implement better way that gets more inputs at once
public class InputHandler implements EventHandler<KeyEvent>
{
    public InputHandler()
    {

    }

    @Override
    public void handle(KeyEvent keyEvent)
    {
        System.out.println(keyEvent.getText());
        /*
        switch(keyEvent.getCode())
        {
            case KeyCode.W ->
            {
                Player player = Player.getPlayer();
                player.setDirection(Direction.UP);
                player.move();
                // System.out.println("w");
            }
            case KeyCode.S ->
            {
                Player player = Player.getPlayer();
                player.setDirection(Direction.DOWN);
                player.move();
                // System.out.println("s");
            }
            case KeyCode.A ->
            {
                Player player = Player.getPlayer();
                player.setDirection(Direction.LEFT);
                player.move();
                // System.out.println("a");
            }
            case KeyCode.D ->
            {
                Player player = Player.getPlayer();
                player.setDirection(Direction.RIGHT);
                player.move();
                // System.out.println("d");
            }
        }

         */
    }
}
