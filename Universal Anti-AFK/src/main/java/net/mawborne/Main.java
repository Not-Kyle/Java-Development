package net.mawborne;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String UI_TITLE = "mawborne Universal Anti-AFK";

    private static volatile boolean running = false;
    private static Thread workerThread;

    public static void main(String[] args) {
        UI ui = new UI(UI_TITLE);

        ui.setToggleListener(isEnabled -> {
            running = isEnabled;
            if (running) {
                LOGGER.info("Anti-Afk is Enabled! Interval: {} min(s)", ui.getSliderValue());
                startBot(ui);
            } else {
                LOGGER.info("Anti-Afk is Disabled!");
                if (workerThread != null) workerThread.interrupt();
            }
        });
    }

    private static void startBot(UI ui) {
        if (workerThread != null && workerThread.isAlive()) {
            workerThread.interrupt();
        }

        workerThread = new Thread(() -> {
            try {
                Robot robot = new Robot();
                Random random = new Random();

                while (running && !Thread.currentThread().isInterrupted()) {
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    Thread.sleep(500);
                    robot.keyRelease(KeyEvent.VK_SHIFT);

                    int currentInterval = ui.getSliderValue();
                    long baseWaitTime = (long) currentInterval * 60 * 1000;
                    long randomizeJitter = (random.nextInt(21) - 10) * 1000;

                    Thread.sleep(Math.max(1000, baseWaitTime + randomizeJitter));
                }

            } catch (AWTException e) {
                LOGGER.error("Robot failed to initialize: {}", e.getMessage());

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOGGER.info("Anti-AFK bot stopped.");
            }
        });

        workerThread.setDaemon(true);
        workerThread.start();
    }
}