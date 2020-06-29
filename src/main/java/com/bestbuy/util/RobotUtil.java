package com.bestbuy.util;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotUtil {

    protected Robot robot;

    protected static RobotUtil instance = null;
    private static int defaultGuiDelay = 1000;


    public RobotUtil() {
        try {
            robot = new Robot();
            robot.setAutoDelay(defaultGuiDelay);
            robot.setAutoWaitForIdle(true);

        } catch (AWTException awte) {
            throw new RuntimeException(awte);
        }
    }

    public static RobotUtil getInstance() {

        if (instance == null) {
            instance = new RobotUtil();
            instance.setAutoDelay(defaultGuiDelay);
            instance.setAutoWaitForIdle(true);

        }
        return instance;
    }

    public void setAutoDelay(int ms) {

        robot.setAutoDelay(ms);
    }

    public void setAutoWaitForIdle(boolean wait) {

        robot.setAutoWaitForIdle(wait);
    }






}
