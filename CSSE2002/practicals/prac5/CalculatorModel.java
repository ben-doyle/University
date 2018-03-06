package week10;

/** The model for the Calculator. */
public class CalculatorModel {

    // the result of the calculation
    private int result;

    /**
     * Creates a new calculator model with a result of 0.
     */
    public CalculatorModel() {
        result = 0;
    }

    /**
     * Get the result of the calculator.
     * 
     * @return the result of the calculator
     */
    public int getResult() {
        return result;
    }

    /**
     * Adds number to the calculator's result.
     * 
     * @param number
     *            the number to add
     */
    public void add(int number) {
        result += number;
    }

    /**
     * Set the result of the calculator back to zero.
     */
    public void clear() {
        result = 0;
    }
}
