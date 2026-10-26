package musicFactory;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class MainMenuController extends Controller
{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button mainMenuButtonPlay;

    @FXML
    private Button mainMenuButtonQuit;

    @FXML
    void mainMenuStartGame(ActionEvent event)
    {
        Main.changeScene(gameScene);
        GameController.getRenderer().start();
    }

    @FXML
    void mainMenuQuitGame(ActionEvent event)
    {
        System.exit(0);
    }

    @FXML
    void initialize()
    {
        assert mainMenuButtonPlay != null : "fx:id=\"buttonPlay\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert mainMenuButtonQuit != null : "fx:id=\"buttonQuit\" was not injected: check your FXML file 'mainMenu.fxml'.";

    }
}