package musicFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Objects;

public class Main extends Application
{
    public static void main(String[] args) { launch(args); }

    private static MainMenuController mainMenuController;
    private static GameController gameController;
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        try
        {
            FXMLLoader mainMenuLoader = new FXMLLoader(getClass().getResource("/musicFactory/mainMenu.fxml"));
            Parent mainMenuRoot = mainMenuLoader.load();
            Scene mainMenuScene = new Scene(mainMenuRoot, Settings.getScreenWidth(), Settings.getScreenHeight());
            mainMenuScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());
            mainMenuController = mainMenuLoader.getController();

            FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("/musicFactory/game.fxml"));
            Parent gameRoot = gameLoader.load();
            Scene gameScene = new Scene(gameRoot, Settings.getScreenWidth(), Settings.getScreenHeight());
            gameScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());
            gameController = gameLoader.getController();

            primaryStage.setScene(mainMenuScene);
            primaryStage.resizableProperty().set(false);
            primaryStage.setTitle("Music Factory - The Game");
            primaryStage.show();

            Main.primaryStage = primaryStage;

            MainMenuController.setPrimaryStage(primaryStage);
            MainMenuController.setMainMenuScene(mainMenuScene);
            MainMenuController.setGameScene(gameScene);

            gameScene.setOnKeyPressed(InputHandler::handlePress);
            gameScene.setOnKeyReleased(InputHandler::handleRelease);

            primaryStage.setOnCloseRequest(this::exitProgram);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void stop() throws Exception
    {
        gameController.stop();
        super.stop();
    }

    private void exitProgram(WindowEvent evt) { System.exit(0); }

    public static void changeScene(Scene scene)
    {
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static GameController getGameController()
    {
        return gameController;
    }
}
