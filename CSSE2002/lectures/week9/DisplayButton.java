package week9;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DisplayButton extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // root node is BorderPane
        BorderPane root = new BorderPane();
        Button button = new Button("Button");

        button.setOnAction(new MyButtonEventHandler());

        /* 
         * The commented code below, which creates the EventHandler as an
         * anonymous inner class, has the same effect as the previous line.
         */

        /*
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Button Pressed");
            }
        });
        */

        // put the button in the center of the BorderPane
        root.setCenter(button);
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setTitle("Button");
        stage.show();
    }

    private class MyButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            System.out.println("Button Pressed");
        }
    }
}
