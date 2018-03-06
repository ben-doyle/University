package chapter2;

/**
 * Models a counter that counts balls and strikes in a baseball game.
 */
public class BaseballCounter {

    /** Number of strikes currently **/
    private int strikes;
    /** Number of balls currently **/
    private int balls;

    /** Create new BaseballCounter with strikes and balls set to 0 **/
    BaseballCounter() {
        strikes = 0;
        balls = 0;
    }

    //Queries

    /**
     * The number of strikes against player
     * @return strikes
     */
    public int getStrikes() {
        return strikes;
    }

    /**
     * The number of balls against player
     * @return balls
     */
    public int getBalls() {
        return balls;
    }

    //Commands

    /**
     * Resets the strikes and balls to 0;
     */
    public void reset() {
        strikes = 0;
        balls = 0;
    }

    /**
     * Increments strikes by 1.
     */
    public void incrementStrikes() {
        strikes++;
        if (strikes == 3) {
            this.reset();
        }
    }

    /**
     * Increments balls by 1.
     */
    public void incrementBalls() {
        balls++;
        if (balls == 4) {
            this.reset();
        }
    }

}
