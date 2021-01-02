package level.threads;

import level.tools.Oven;

public class OvenThread extends Thread {

    private Oven oven;
    private double timer;
    private boolean isCooking;
    private boolean isRunning;

    public OvenThread(Oven oven) {
        super();
        this.oven = oven;
        this.timer = 0;
        this.isCooking = false;
        this.isRunning = true;
    }

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

    public void toggle() {
        this.isCooking = !this.isCooking;
    }

    public void stopRunning() {
        this.isRunning = false;
    }
}
