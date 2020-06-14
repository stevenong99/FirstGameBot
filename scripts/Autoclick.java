/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripts;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Random;

/**
 *
 * @author Crimson
 */
public class Autoclick {

    static Random r = new Random();

    public static void leftClick(Robot robot) throws InterruptedException {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("M1 down");
        robot.delay(50 + r.nextInt(30));
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("M1 up");
    }
    
    public static void rightClick(Robot robot) throws InterruptedException {
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        System.out.println("M2 down");
        robot.delay(60 + r.nextInt(30));
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        System.out.println("M2 up");
    }

    public static void doubleleftClick(Robot robot) throws InterruptedException {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("M1 down");
        robot.delay(40 + r.nextInt(30));
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("M1 up");
        robot.delay(10 + r.nextInt(30));
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("M1 down");
        robot.delay(50 + r.nextInt(30));
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("M1 up");
    }
}
