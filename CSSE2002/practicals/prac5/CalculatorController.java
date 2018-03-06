package week10;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/** The Controller for the calculator */
public class CalculatorController {

    private CalculatorModel model; // the model for calculator
    private CalculatorView view; // view for the calculator
    private boolean start; // start of a new number

    /**
     * Creates a new controller for the calculator.
     * 
     * @param model
     *            calculator model
     * @param view
     *            calculator view
     */
    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        start = true;

        view.addPlusHandler(new PlusActionHandler());
        view.addClearHandler(new ClearActionHandler());
        for (int i = 0; i < 10; i++) {
            view.addNumberHandler(new NumberActionHandler(), i);
        }
    }

    /**
     * EventHandler class for the numbered buttons
     */
    private class NumberActionHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            String number = ((Button) event.getSource()).getText();
            if (start || view.getText().equals("0")) {
                view.setText(number);
                start = false;
            } else {
                view.setText(view.getText() + number);
            }
        }
    }

    /**
     * EventHandler class for the plus operation.
     */
    private class PlusActionHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            model.add(Integer.parseInt(view.getText()));
            view.setText("" + model.getResult());
            start = true;
        }
    }

    /**
     * EventHandler class for the clear operation
     */
    private class ClearActionHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            model.clear();
            view.clear();
            start = true;
        }
    }
}
