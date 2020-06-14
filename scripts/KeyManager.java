/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 *
 * @author Crimson
 */
public class KeyManager {
    Robot r;
    Random ran;

    public KeyManager(Robot r) {
        this.r = r;
        this.ran = new Random();
    }
    
    public void type(int e){
        r.keyPress(e);
        r.delay(ran.nextInt(20) + 50);
        r.keyRelease(e);
    }
    
    public void type(int first, int second){
        r.keyPress(first);
        r.delay(ran.nextInt(20) + 50);
        r.keyPress(second);
        r.delay(ran.nextInt(20) + 40);
        r.keyRelease(second);
        r.delay(ran.nextInt(20) + 50);
        r.keyRelease(first);
    }
}
