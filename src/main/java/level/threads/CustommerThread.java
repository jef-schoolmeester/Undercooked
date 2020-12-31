package level.threads;

import level.Level;

import java.awt.*;

public class CustommerThread extends Thread {
    private Level level;

    public CustommerThread(Level level) {
        this.level = level;
    }
}
