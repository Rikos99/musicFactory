package musicFactory;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.geometry.Point2D;


public class GameController extends Controller
{
    private static Renderer renderer;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Canvas gameCanvas;

    @FXML
    private Label gameDebugInfo;

    @FXML
    void initialize()
    {
        assert gameCanvas != null : "fx:id=\"gameCanvas\" was not injected: check your FXML file 'game.fxml'.";
        assert gameDebugInfo != null : "fx:id=\"gameDebugInfo\" was not injected: check your FXML file 'game.fxml'.";

        renderer = new Renderer(gameCanvas);
    }

    public void stop()
    {
        renderer.stop();
    }

    public static Renderer getRenderer()
    {
        return renderer;
    }

    public void updateLabel(Point2D worldPosition)
    {
        gameDebugInfo.setText(worldPosition.toString());
    }
}
