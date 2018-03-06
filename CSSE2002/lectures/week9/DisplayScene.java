package week9;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class DisplayScene extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, Color.YELLOW);
        stage.setScene(scene);

        stage.setX(150);
        stage.setY(100);
        stage.setWidth(500);
        stage.setHeight(450);
        stage.setTitle("Display");
        stage.show();
    }
}
