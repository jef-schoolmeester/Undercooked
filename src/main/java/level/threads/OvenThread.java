package level.threads;

import level.tools.Oven;

/**
 * OvenThread is the class that manages the Oven class, extends Thread class.
 * This class has a Oven, two booleans and one timer
 * @see Thread
 * @see Oven
 *
 * @author Jef
 * @since 1.0
 * @version 1.0
 */
public class OvenThread extends Thread {

    private Oven oven;
    private double timer;
    private boolean isCooking;
    private boolean isRunning;

    /**
     * Class constructor
     * @param oven The oven to be managed
     * @since 1.0
     */
    public OvenThread(Oven oven) {
        super();
        this.oven = oven;
        this.timer = 0;
        this.isCooking = false;
        this.isRunning = true;
    }

    /**
     * If isCooking parameter is true and the thread isRunning, calls cook from oven every 5 seconds
     */
    public void run() {
        while (isRunning) {
            try {
                sleep(100);
                if (isCooking) {
                    this.timer += 0.1;
                    this.timer = Math.round(this.timer * 10.0)/10.0;
                    if (timer%5 == 0) {
                        oven.cook();
                    }
                } else {
                    this.timer = 0;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * Changes isCooking parameter to true or false
     * @since 1.0
     */
    public void toggle() {
        this.isCooking = !this.isCooking;
    }

    /**
     * stops the thread
     * @since 1.0
     */
    public void stopRunning() {
        this.isRunning = false;
    }
}
