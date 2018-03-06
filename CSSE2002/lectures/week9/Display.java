package week9;

import javafx.application.Application;
import javafx.stage.Stage;

public class Display extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setX(150);
        stage.setY(100);
        stage.setWidth(500);
        stage.setHeight(450);
        stage.setTitle("Display");
        stage.show();
    }
}
