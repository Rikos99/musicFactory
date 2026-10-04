package musicFactory;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Objects;


public class Main extends Application
{
    public static void main(String[] args) { launch(args); }

    private Canvas canvas;
    private AnimationTimer timer;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        try
        {
            Group root = new Group();
            canvas = new Canvas(Settings.getInstance().getScreenWidth(), Settings.getInstance().getScreenHeight());
            root.getChildren().add(canvas);
            Scene scene = new Scene(root, Settings.getInstance().getScreenWidth(), Settings.getInstance().getScreenHeight());
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.resizableProperty().set(false);
            primaryStage.setTitle("Music Factory - The Game");
            primaryStage.show();

            // TODO init key listener
            InputHandler inputHandler = new InputHandler();
            scene.addEventHandler(KeyEvent.KEY_PRESSED, inputHandler);

            primaryStage.setOnCloseRequest(this::exitProgram);
            timer = new Renderer(canvas);
            timer.start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void stop() throws Exception
    {
        timer.stop();
        super.stop();
    }

    private void exitProgram(WindowEvent evt) {System.exit(0);}
}
