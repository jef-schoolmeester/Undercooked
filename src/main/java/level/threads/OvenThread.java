package level.threads;

import level.tools.Oven;

public class OvenThread extends Thread {

    private Oven oven;
    private double timer;
    private boolean isRunning;

    public OvenThread(Oven oven) {
        super();
        this.oven = oven;
        this.timer = 0;
        this.isRunning = false;
    }

    public void run() {
        while (true) {
            try {
                sleep(100);
                if (isRunning) {
                    System.out.println(timer);
                    this.timer += 100;
                    System.out.println("timer");
                    if (timer%5000 == 0) {
                        oven.burn();
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
        this.isRunning = !this.isRunning;
    }
}
