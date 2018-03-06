package week9;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class DisplayCircle extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        AnchorPane root = new AnchorPane();
        Circle circle = new Circle(150, 150, 50, Color.RED);

        // eventHandlers can be added multiple ways:
        /*
         * EventHandler<MouseEvent> event = new EventHandler<MouseEvent>() {
         * 
         * @Override public void handle(MouseEvent e) {
         * circle.setCenterX(e.getX()); circle.setCenterY(e.getY()); } };
         * circle.addEventHandler(MouseEvent.MOUSE_CLICKED, event);
         */

        circle.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                circle.setCenterX(e.getX());
                circle.setCenterY(e.getY());
            }
        });

        circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (circle.getFill().equals(Color.AQUA)) {
                    circle.setFill(Color.YELLOW);
                } else {
                    circle.setFill(Color.AQUA);
                }
            }
        });

        root.getChildren().addAll(circle);
        stage.setScene(new Scene(root, 300, 300, Color.GRAY));
        stage.setTitle("CIRCLE");
        stage.show();
    }
}
