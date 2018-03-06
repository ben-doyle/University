package prac2;

/**
 * A lamp with a current state and four possible
 * settings to move between (OFF, LOW, MED, HIGH).
 *
 * @author Benjamin Doyle
 */
public class ThreeWayLamp {

    public enum State {
        OFF, LOW, MED, HIGH
    }

    /**
     * Create a ThreeWaylamp with the lamp set to off
     */
    private State state;

    public ThreeWayLamp() {
        state = State.OFF;
    }

    /**
     * Set the current state of the lamp
     * @param state the new state of the lamp
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * returns the current state of the ThreeWayLamp, either
     * OFF, LOW, MED, HIGH
     * @return state
     */
    public State getState() {
        return this.state;
    }

//    /**
//     * Increments the CurrentState of ThreeWayLamp
//     * to the next setting. For instance, LOW >> MED, MED >> HIGH, HIGH >> OFF
//     * OFF >> LOW;
//     */
//    public void switchSetting() {
//        if (state.equals(State.OFF)) {
//            setState(State.LOW);
//        }
//        else if (state.equals(State.LOW)){
//            setState(State.MED);
//        }
//        else if (state.equals(State.MED)){
//            setState(State.HIGH);
//        }
//        else if (state.equals(State.HIGH)){
//            setState(State.OFF);
//        }
//    }

    /**
     * Increments the CurrentState of ThreeWayLamp
     * to the next setting. For instance, LOW >> MED, MED >> HIGH, HIGH >> OFF
     * OFF >> LOW
     */
    public void switchSetting() {
        switch (state) {
            case OFF:
                setState(State.LOW);
                break;
            case LOW:
                setState(State.MED);
                break;
            case MED:
                setState(State.HIGH);
                break;
            case HIGH:
                setState(State.OFF);
                break;
        }
    }

}
