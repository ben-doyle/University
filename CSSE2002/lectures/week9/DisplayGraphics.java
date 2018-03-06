package week9;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.StackPane;

public class DisplayGraphics extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // root node
        Group root = new Group();

        // red rectangle
        Rectangle rectangle = new Rectangle(50, 50, 200, 100);
        rectangle.setFill(Color.RED);

        // inner pane
        StackPane innerPane = new StackPane();
        // blue rectangle inside innerPane
        Rectangle blueRectangle = new Rectangle(200, 200);
        blueRectangle.setFill(Color.BLUE);
        // yellow circle on blue rectangle inside innerPane
        Circle circle = new Circle(80, Color.YELLOW);

        innerPane.getChildren().addAll(blueRectangle, circle);
        innerPane.setLayoutX(70);
        innerPane.setLayoutY(200);

        // image
        Image image = new Image("week9/image.gif", 150, 150, false, true);
        ImageView imageView = new ImageView(image);
        imageView.setX(300);
        imageView.setY(100);

        // add all children to the root node
        root.getChildren().addAll(rectangle, innerPane, imageView);

        // set the scene
        Scene scene = new Scene(root, Color.GREY);
        stage.setScene(scene);

        // set up the stage
        stage.setX(150);
        stage.setY(100);
        stage.setWidth(500);
        stage.setHeight(450);
        stage.setTitle("Display");
        stage.show();
    }

}
