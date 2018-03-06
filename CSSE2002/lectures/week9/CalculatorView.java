package week9;

import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

/** The view for the Calculator. */
public class CalculatorView {

    private CalculatorModel model; // Calculator model
    private GridPane gridPane; // root node for the view
    private final int columns = 3; // number of columns in grid
    private final int rows = 5; // number of rows in grid
    private TextField display; // display for the result
    private Button[] numbers; // number buttons on calculator
    private Button plus; // the plus button
    private Button clear; // clear button
    // the font type for all the text on the buttons and textField
    private Font font = Font.font("SanSerif", FontWeight.BOLD, 25);

    /**
     * Creates a new calculator view with the given model.
     * 
     * @param model
     *            the calculator model
     */
    public CalculatorView(CalculatorModel model) {
        this.model = model;
        gridPane = new GridPane();
        addDisplay();
        addButtons();
        setGridConstraints();
    }

    /**
     * Add the caculator's display to the view. The display takes up the top row
     * (three columns, one row) of the grid.
     */
    private void addDisplay() {
        display = new TextField("" + model.getResult());
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setFocusTraversable(false);
        display.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        display.setMinSize(Double.MIN_VALUE, Double.MIN_VALUE);
        display.setFont(font);
        display.setPrefSize(150, 50);

        gridPane.add(display, 0, 0, columns, 1);
    }

    /**
     * Adds the buttons to the view.
     */
    private void addButtons() {
        addNumberedButtons();
        addPlusButton();
        addClearButton();
    }

    /**
     * Adds the numbered buttons to the view.
     */
    private void addNumberedButtons() {
        numbers = new Button[10];
        for (int i = 0; i < numbers.length; i++) {
            int row = i / columns + 1;
            int column = i % columns;
            numbers[i] = new Button("" + i);
            setButtonAppearance(numbers[i]);
            gridPane.add(numbers[i], column, row);
        }
    }

    /**
     * Set the appearance of the buttons in the grid.
     * 
     * @param button
     *            the button to configure
     */
    private void setButtonAppearance(Button button) {
        button.setFont(font);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setMinSize(Double.MIN_VALUE, Double.MIN_VALUE);
        // doesn't start with focus or stay focused
        button.setFocusTraversable(false);
    }

    /**
     * Add the plus button.
     */
    private void addPlusButton() {
        plus = new Button("+");
        setButtonAppearance(plus);
        plus.setTextFill(Color.RED);
        gridPane.add(plus, 10 % columns, 10 / columns + 1);
    }

    /**
     * Add the clear button.
     */
    private void addClearButton() {
        clear = new Button("C");
        setButtonAppearance(clear);
        clear.setTextFill(Color.BLUE);
        gridPane.add(clear, 11 % columns, 11 / columns + 1);
    }

    /**
     * Set the constraints of the gridPane.
     */
    private void setGridConstraints() {
        // columns to always extend when window is resized
        ColumnConstraints columnConstraint = new ColumnConstraints();
        columnConstraint.setHgrow(Priority.ALWAYS);
        columnConstraint.setPrefWidth(50);
        for (int i = 0; i < columns; i++) {
            gridPane.getColumnConstraints().add(columnConstraint);
        }

        // row to always extend when window is resized
        RowConstraints rowConstraint = new RowConstraints();
        rowConstraint.setVgrow(Priority.ALWAYS);
        rowConstraint.setPrefHeight(50);
        for (int i = 0; i < rows; i++) {
            gridPane.getRowConstraints().add(rowConstraint);
        }
    }

    /**
     * Get the root node of the scene graph.
     * 
     * @return returns the root node in the scene graph for the view
     */
    public GridPane getRootNode() {
        return gridPane;
    }

    /**
     * Clear the display.
     */
    public void clear() {
        display.setText("" + model.getResult());
    }

    /**
     * Get the text in the display.
     * 
     * @return return the text inside the display
     */
    public String getText() {
        return display.getText();
    }

    /**
     * Set the display text to the given text.
     * 
     * @param string
     *            text to be set
     */
    public void setText(String string) {
        display.setText(string);
    }

    /**
     * Add handler to a numbered button.
     * 
     * @param handler
     *            the handler to be added
     * @param number
     *            the number of the button to add the handler to
     */
    public void addNumberHandler(EventHandler<ActionEvent> handler,
            int number) {
        numbers[number].setOnAction(handler);
    }

    /**
     * Add handler to the plus operation.
     * 
     * @param handler
     *            the handler to be added
     */
    public void addPlusHandler(EventHandler<ActionEvent> handler) {
        plus.setOnAction(handler);
    }

    /**
     * Add handler to the clear button.
     * 
     * @param handler
     *            the handler to be added
     */
    public void addClearHandler(EventHandler<ActionEvent> handler) {
        clear.setOnAction(handler);
    }
}
