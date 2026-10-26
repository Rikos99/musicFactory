package musicFactory;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class Controller
{
    protected static Stage primaryStage;
    protected static Scene mainMenuScene;
    protected static Scene gameScene;

    public static void setPrimaryStage(Stage primaryStage) {
        Controller.primaryStage = primaryStage;
    }

    public static void setMainMenuScene(Scene mainMenuScene) {
        Controller.mainMenuScene = mainMenuScene;
    }

    public static void setGameScene(Scene gameScene) {
        Controller.gameScene = gameScene;
    }

}
