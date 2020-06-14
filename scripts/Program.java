/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripts;

import com.github.joonasvali.naturalmouse.api.MouseMotion;
import com.github.joonasvali.naturalmouse.api.MouseMotionFactory;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import rs3bot.FXMLDocumentController;

/**
 *
 * @author Crimson
 */
public class Program {

    private Robot robot;
    private Runtime runtime;
    private MouseMove mouse;
    private Random r;
    private FXMLDocumentController controller;
    private KeyManager km;

    public Program(FXMLDocumentController controller) throws AWTException {
        this.robot = new Robot();
        this.mouse = new MouseMove();
        this.r = new Random();
        this.controller = controller;
        this.km = new KeyManager(robot);
    }

    public void caveNightShadeFarm() throws InterruptedException, IOException {
        GoToBank();
        km.type(KeyEvent.VK_CONTROL, KeyEvent.VK_5);
        robot.delay(r.nextInt(300) + 2000);
        km.type(KeyEvent.VK_CONTROL, KeyEvent.VK_T);
        robot.delay(r.nextInt(2000) + 20000);
        mouse.moveNoDev(1755, 391);//click on map
        Autoclick.leftClick(robot);
        robot.delay(r.nextInt(300) + 9000);
        mouse.moveNoDev(1023, 679);//click on cave
        Autoclick.leftClick(robot);
        robot.delay(r.nextInt(30) + 2500);
        while (!isInventoryFull()) {
            ArrayList nightshade = new ArrayList();
            nightshade = getNightShadeColours();
            bigClickOn(nightshade);//clicks on bank again
            robot.delay(r.nextInt(200) + 3000);
        }
        caveNightShadeFarm();
    }

    public void natureRunecraftingBot() throws InterruptedException, IOException {
        /**
         * GoToBank() Press 1 Press 7 Press O Press P Click in front 956, 494
         * Press 1 Press [
         *
         *
         */

        int cycles = 0;
        summon();//Summon graakh
        while (cycles < 26) {
            GoToBank();
            km.type(KeyEvent.VK_1);//loads inventory
            robot.delay(r.nextInt(200) + 2500);
            km.type(KeyEvent.VK_7);//fills pouches
            robot.delay(r.nextInt(100) + 1000);
            km.type(KeyEvent.VK_O);
            robot.delay(r.nextInt(100) + 1000);
            km.type(KeyEvent.VK_P);
            robot.delay(r.nextInt(100) + 1000);
            ArrayList bankcolour = new ArrayList();
            bankcolour = getPriffBankBoxColours();
            ClickOn(bankcolour);//clicks on bank again
            robot.delay(r.nextInt(200) + 2500);
            km.type(KeyEvent.VK_1);//fills empty slots with essences
            robot.delay(r.nextInt(100) + 2000);
            km.type(KeyEvent.VK_OPEN_BRACKET);//interacts with familiar
            robot.delay(r.nextInt(100) + 2000);
            km.type(KeyEvent.VK_2);//selects teleport option
            robot.delay(r.nextInt(300) + 7500);//waits for teleport to finish
            mouse.moveNoDev(1910, 247);//walking to altar
            robot.delay(r.nextInt(30) + 80);
            Autoclick.leftClick(robot);
            robot.delay(r.nextInt(200) + 9000);
            mouse.moveNoDev(1910, 244);
            Autoclick.leftClick(robot);
            robot.delay(r.nextInt(200) + 9500);
            mouse.moveNoDev(1911, 257);
            Autoclick.leftClick(robot);
            robot.delay(r.nextInt(200) + 13000);
            mouse.moveNoDev(1845, 245);
            Autoclick.leftClick(robot);
            robot.delay(r.nextInt(200) + 6000);
            ArrayList natureAltar = new ArrayList();
            natureAltar = getNatureAltarColours();
            ClickOn(natureAltar);
            robot.delay(r.nextInt(200) + 5000);
            mouse.move(968, 206);
            robot.delay(r.nextInt(200) + 1000);
            Autoclick.leftClick(robot);
            robot.delay(r.nextInt(300) + 5000);
            cycles++;
            System.out.println("Number of cycles = " + cycles);
        }
        natureRunecraftingBot();

    }

    public void mudRunecraftingBot() throws InterruptedException, IOException {
        int cycles = 0;
        extendLegendPet();
        while (cycles < 24) {
            AutoAlignCamera2();
            robot.keyPress(KeyEvent.VK_UP);
            robot.delay(r.nextInt(100) + 1000);
            robot.keyRelease(KeyEvent.VK_UP);
            robot.delay(r.nextInt(100) + 200);
            mouse.move(980, 618);
            Autoclick.leftClick(robot);
            robot.delay(r.nextInt(100) + 1500);
            km.type(KeyEvent.VK_1);//loads inventory
            robot.delay(r.nextInt(100) + 1500);
            km.type(KeyEvent.VK_7);//fills pouches
            robot.delay(r.nextInt(10) + 30);
            km.type(KeyEvent.VK_O);
            robot.delay(r.nextInt(10) + 30);
            km.type(KeyEvent.VK_P);
            robot.delay(r.nextInt(10) + 30);
            mouse.move(980, 618);
            Autoclick.leftClick(robot);
            robot.delay(r.nextInt(100) + 1500);
            km.type(KeyEvent.VK_1);//loads inventory again
            robot.delay(r.nextInt(100) + 900);
            km.type(KeyEvent.VK_6);
            robot.delay(r.nextInt(10) + 30);
            mouse.move(980, 618);
            Autoclick.leftClick(robot);
            robot.delay(r.nextInt(100) + 1500);
            km.type(KeyEvent.VK_1);//loads inventory again
            robot.delay(r.nextInt(100) + 1500);
            mouse.moveNoDev(1911, 380);
            Autoclick.leftClick(robot);
            robot.delay(r.nextInt(100) + 18000);
            mouse.moveNoDev(955, 966);
            Autoclick.leftClick(robot);
            robot.delay(r.nextInt(100) + 4000);
            mouse.moveNoDev(1653, 216);
            Autoclick.leftClick(robot);
            robot.delay(r.nextInt(100) + 4500);
            mouse.moveNoDev(300, 1055);//Magic imbue
            Autoclick.leftClick(robot);
            mouse.moveNoDev(1695, 814);//Move to water rune
            Autoclick.leftClick(robot);//Click on water rune
            mouse.moveNoDev(964, 378);
            Autoclick.leftClick(robot);//click on altar
            robot.delay(r.nextInt(100) + 2500);
            mouse.moveNoDev(1630, 306);
            Autoclick.leftClick(robot);
            robot.delay(r.nextInt(100) + 4500);
            mouse.moveNoDev(959, 767);
            Autoclick.leftClick(robot);//click on exit portal
            robot.delay(r.nextInt(100) + 4000);
            mouse.moveNoDev(1406, 151);
            Autoclick.leftClick(robot);//click on bank sign
            robot.delay(r.nextInt(100) + 16400);
            System.out.println("Number of cycles completed = " + cycles);
            cycles++;
        }
        mudRunecraftingBot();
    }

    public void mudRunecraftingBotSawmillTele() throws InterruptedException, IOException {
        int cycles = 0;
        extendLegendPet();
        while (cycles < 24) {
            GoToBank();
            //Fills pouches in bank screen
            mouse.move(1352, 165);
            Autoclick.rightClick(robot);
            mouse.move(1351, 220);
            Autoclick.leftClick(robot);
            mouse.move(1415, 165);
            Autoclick.rightClick(robot);
            mouse.move(1415, 220);
            Autoclick.leftClick(robot);
            mouse.move(1476, 165);
            Autoclick.rightClick(robot);
            mouse.move(1476, 220);
            Autoclick.leftClick(robot);
            mouse.move(1538, 165);
            Autoclick.rightClick(robot);
            mouse.move(1538, 220);
            Autoclick.leftClick(robot);
            mouse.move(1353, 212);
            Autoclick.rightClick(robot);
            mouse.move(1353, 270);
            Autoclick.leftClick(robot);
            km.type(KeyEvent.VK_1);
            robot.delay(r.nextInt(100) + 1200);
            mouse.move(1879, 642);//Read lumber tele scroll
            Autoclick.leftClick(robot);
            robot.delay(r.nextInt(100) + 6000);
            mouse.moveNoDev(1783, 337);//Click on entrance in minimap
            Autoclick.leftClick(robot);
            robot.delay(r.nextInt(100) + 5500);
            ArrayList earthaltar = new ArrayList();
            earthaltar = getEarthAltarColours();
            bigClickOn(earthaltar);//clicks on entrance
            robot.delay(r.nextInt(100) + 3800);
            mouse.moveNoDev(1794, 216);//click on altar in minimap
            Autoclick.leftClick(robot);
            robot.delay(r.nextInt(100) + 3000);
            km.type(KeyEvent.VK_4);
            mouse.moveNoDev(1695, 814);//Move to rune
            Autoclick.leftClick(robot);//Click on rune
            mouse.moveNoDev(964, 378);
            Autoclick.leftClick(robot);//click on altar
            robot.delay(r.nextInt(100) + 500);
            System.out.println("Number of cycles completed = " + cycles);
            cycles++;
        }
        mudRunecraftingBot();
    }

    public void extendLegendPetDigSite() throws InterruptedException, IOException { //Only usable with bank chest at dig site
        AutoAlignCamera2();
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(r.nextInt(300) + 2000);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(r.nextInt(300) + 1000);
        mouse.move(980, 609);
        Autoclick.leftClick(robot);
        robot.delay(r.nextInt(200) + 2000);
        km.type(KeyEvent.VK_2);//loads inventory
        robot.delay(r.nextInt(200) + 2500);
        mouse.move(1407, 945);
        Autoclick.leftClick(robot);//Call familiar
        robot.delay(r.nextInt(20) + 1230);
        mouse.move(1695, 595);
        Autoclick.rightClick(robot);
        robot.delay(r.nextInt(20) + 30);
        mouse.move(1697, 645);
        Autoclick.leftClick(robot);
        robot.delay(r.nextInt(20) + 1230);
        ArrayList pet = new ArrayList();
        pet = getPetColour();
        ClickOn(pet);
        robot.delay(r.nextInt(300) + 2000);
        km.type(KeyEvent.VK_2);
        robot.delay(r.nextInt(20) + 300);
    }

    public void extendLegendPet() throws InterruptedException, IOException { //Only usable with bank chest at dig site
        GoToBank();
        km.type(KeyEvent.VK_2);//loads inventory
        robot.delay(r.nextInt(200) + 2500);
        mouse.move(1407, 945);
        Autoclick.leftClick(robot);//Call familiar
        robot.delay(r.nextInt(20) + 1230);
        mouse.move(1695, 595);
        Autoclick.rightClick(robot);
        robot.delay(r.nextInt(20) + 30);
        mouse.move(1697, 645);
        Autoclick.leftClick(robot);
        robot.delay(r.nextInt(20) + 1230);
        ArrayList pet = new ArrayList();
        pet = getPetColour();
        ClickOn(pet);
        robot.delay(r.nextInt(300) + 2000);
        km.type(KeyEvent.VK_2);
        robot.delay(r.nextInt(20) + 300);
        mouse.move(964, 543);
        Autoclick.leftClick(robot);
    }

    public void summon() throws InterruptedException, IOException {
        //Recharge summoning points
        AutoAlignCamera();
        mouse.move(563, 1001);
        Autoclick.leftClick(robot);
        robot.delay(r.nextInt(10) + 2200);
        robot.keyPress(KeyEvent.VK_3);
        robot.delay(r.nextInt(50) + 20);
        robot.keyRelease(KeyEvent.VK_3);
        robot.delay(r.nextInt(300) + 10000);
        AutoAlignCamera();
        robot.delay(r.nextInt(20) + 2500);
        mouse.move(1707, 314);
        Autoclick.leftClick(robot);
        robot.delay(r.nextInt(20) + 10500);
        ArrayList obelisk = new ArrayList();
        obelisk = getObeliskColour();
        ClickOn(obelisk);
        robot.delay(r.nextInt(20) + 2100);
        mouse.moveNoDev(1264, 346);
        Autoclick.leftClick(robot);
        robot.delay(r.nextInt(20) + 2100);

        //Getting pouch out from bank and clicking on it
        GoToBank();
        km.type(KeyEvent.VK_2);
        robot.delay(r.nextInt(200) + 2500);
        mouse.move(1697, 596);
        Autoclick.leftClick(robot); //Left clicks on pouch
        robot.delay(r.nextInt(20) + 2000);

        //Checks if summoning interface has a name
        int x = 1465, y = 618, width = 95, height = 95;
        BufferedImage fullimg = screenCapture();
        BufferedImage subimg = fullimg.getSubimage(x, y, width, height);
        ArrayList summon = getSummonColours();
        int[] arr = findColourCoor(subimg, summon, 0, x, y, width, height);
        if (arr[0] == 0) {
            System.out.println("Summoning failed. Retry.");
            summon();
        }
    }

    public void SpiritualWarriorFarm() throws InterruptedException {
        System.out.println("Running Spiritual Warrior Script in 5 seconds.");

        System.out.println("5");
        Thread.sleep(1000);
        System.out.println("4");
        Thread.sleep(1000);
        System.out.println("3");
        Thread.sleep(1000);
        System.out.println("2");
        Thread.sleep(1000);
        System.out.println("1");
        Thread.sleep(1000);

        //Click on bank again
        /**
         * 1. Press C, delay 0.094 seconds, release C, every 5 seconds 2. Press
         * 0, delay 0.072 seconds, release 0, every 24 seconds 3. Press / delay
         * 0.073 seconds release /, delay 2.6 seconds , press shift, press
         * space, release space, release shift, every 10 seconds
         */
        Thread.sleep(500);
        try {
            ScheduledExecutorService executorService1 = Executors.newSingleThreadScheduledExecutor();
            executorService1.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    AutoAttack1();
                }
            }, 1, r.nextInt(1) + 4, TimeUnit.SECONDS); //repeat every 4-6 seconds
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in executor 1");
        }

        Thread.sleep(500);
        try {
            ScheduledExecutorService executorService2 = Executors.newSingleThreadScheduledExecutor();
            executorService2.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    AutoAttack2();
                }
            }, 1, r.nextInt(1) + 21, TimeUnit.SECONDS); //Repeats every 23-25 seconds
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in executor 2");
        }

        Thread.sleep(500);
        try {
            ScheduledExecutorService executorService3 = Executors.newSingleThreadScheduledExecutor();
            executorService3.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    AutoAttack3();
                }
            }, 1, r.nextInt(3) + 9, TimeUnit.SECONDS); //Repeats every 9-11 seconds
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in executor 3");
        }

        Thread.sleep(500);
        try {
            ScheduledExecutorService executorService3 = Executors.newSingleThreadScheduledExecutor();
            executorService3.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    try {
                        AutoNote();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }, 5, r.nextInt(30) + 90, TimeUnit.SECONDS); //Repeats every 90-120 seconds
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in executor 3");
        }

    }

    public void AutoAttack1() {//C
        robot.keyPress(KeyEvent.VK_C);
        System.out.println("Pressed C");
        robot.delay(r.nextInt(10) + 50);
        robot.keyRelease(KeyEvent.VK_C);
        System.out.println("Released C");
    }

    public void AutoAttack2() {//0
        robot.keyPress(KeyEvent.VK_0);
        System.out.println("Pressed 0");
        robot.delay(r.nextInt(10) + 50);
        robot.keyRelease(KeyEvent.VK_0);
        System.out.println("Released 0");
    }

    public void AutoAttack3() {///
        robot.keyPress(KeyEvent.VK_SLASH);
        System.out.println("Pressed /");
        robot.delay(r.nextInt(10) + 50);
        robot.keyRelease(KeyEvent.VK_SLASH);
        System.out.println("Released /");
        robot.delay(r.nextInt(300) + 2400);
        robot.keyPress(KeyEvent.VK_SHIFT);
        System.out.println("Pressed Shift");
        robot.delay(r.nextInt(10) + 50);
        robot.keyPress(KeyEvent.VK_SPACE);
        System.out.println("Pressed Space");
        robot.delay(r.nextInt(10) + 50);
        robot.keyRelease(KeyEvent.VK_SPACE);
        System.out.println("Released Space");
        robot.delay(r.nextInt(10) + 50);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        System.out.println("Released Shift");
    }

    public void AutoNote() throws InterruptedException {
        mouse.move(1762, 639);
        Autoclick.leftClick(robot);
        mouse.move(1821, 685);
        Autoclick.leftClick(robot);

        mouse.move(1756, 637);
        Autoclick.leftClick(robot);
        mouse.move(1878, 693);
        Autoclick.leftClick(robot);

        mouse.move(1759, 640);
        Autoclick.leftClick(robot);
        mouse.move(1696, 732);
        Autoclick.leftClick(robot);

        mouse.move(1760, 639);
        Autoclick.leftClick(robot);
        mouse.move(1760, 731);
        Autoclick.leftClick(robot);
    }

    public void AutoAlignCamera() throws InterruptedException {
        System.out.println("Aligning camera.");
        mouse.move(1688, 66);
        Autoclick.leftClick(robot);
    }

    public void AutoAlignCamera2() throws InterruptedException {
        System.out.println("Aligning camera.");
        mouse.move(1401, 67);
        Autoclick.leftClick(robot);
    }

    public boolean isInventoryFull() throws IOException {
        BufferedImage screenshot = screenCapture();
        int x = 1881, y = 872, width = 5, height = 5;
        BufferedImage lastinventoryslot = screenshot.getSubimage(x, y, width, height);
        ImageIO.write(lastinventoryslot, "jpg", new File("finalinv.jpg"));
        ArrayList ori_colour = new ArrayList();
        ori_colour = getFinalInventorySlotColour();
        int[] coor = findColourCoor(lastinventoryslot, ori_colour, 0, x, y, width, height);
        if (coor[0] == 0) {
            System.out.println("Inventory is full");
            return true;
        } else {
            System.out.println("Inventory not full");
            return false;
        }
    }

    public void AutoClick1Spot() {

    }

    public void RandomMovement() throws InterruptedException {
        mouse.move(r.nextInt(500) + 200, r.nextInt(500) + 200);
    }

    public void GoToBank() throws InterruptedException, IOException {
        controller.display("Going to bank");
        System.out.println("Going to bank");
        /* AutoAlignCamera()/
         * Move mouse to crystal teleport/
         * Left click on crystal teleport/
         * Press 8/
         * screenCapture()/
         * search for banker color
         * get coordinate of color
         * move mouse to coordinate
         * left click on banker
         */

        robot.delay(r.nextInt(10) + 200);
        km.type(KeyEvent.VK_5);
        robot.delay(r.nextInt(10) + 1200);
        km.type(KeyEvent.VK_8);
        robot.delay(r.nextInt(300) + 6000);
        AutoAlignCamera();
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(r.nextInt(300) + 200);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.delay(r.nextInt(300) + 200);
        ArrayList bankcolour = new ArrayList();
        bankcolour = getPriffBankBoxColours();
        bigClickOn(bankcolour);//clicks on bank
        robot.delay(r.nextInt(300) + 2200);
        //Checking if bank is open
        BufferedImage fullimg = screenCapture();
        BufferedImage subimg = fullimg.getSubimage(898, 72, 177, 27);
        ArrayList bankcolours = getBankInterfaceColours();
        int[] check = findColourCoor(subimg, bankcolours, 0, 898, 72, 177, 27);
        if (check[0] == 0) {
            System.out.println("Bank is not open yet. Retry.");
            GoToBank();
        } else {
            System.out.println("Bank is open.");
        }
    }

    public int[] findColourCoor(BufferedImage img, ArrayList arrofcolours, int count, int inix, int iniy, int iniwidth, int iniheight) throws FileNotFoundException {
        int[] coor = {0, 0};
        for (int y = 0; y < img.getHeight() - 1; y++) {
            if (coor[0] != 0) {
                break;
            }
            for (int x = 0; x < img.getWidth() - 1; x++) {
                Color c = new Color(img.getRGB(x, y));
                if (arrofcolours.contains(c)) {
                    System.out.println("First instance of color found in subimage at:\n");
                    System.out.printf("X = %d", x);
                    System.out.printf("Y = %d", y);
                    System.out.println("");
                    coor[0] = x;
                    coor[1] = y;
                    break;
                }
            }
        }

//        if (coor[0] == 0 && coor[1] == 0 && count < 10) {
//            System.out.println("Couldn't find colour in img. Retrying.");
//            int x = inix + count, y = iniy + count, width = iniwidth, height = iniheight;
//            BufferedImage fullimg = screenCapture();
//            BufferedImage imgnew = fullimg.getSubimage(x, y, width, height);
//            try {
//                ImageIO.write(imgnew, "jpg", new File("subimage.jpg"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            findColourCoor(imgnew, arrofcolours, count + 1, x, y, width, height);
//        }
        return coor;
    }

    // <---Colors--->
    public ArrayList getPriffBankBoxColours() throws IOException {
        ArrayList arr = new ArrayList();
        BufferedImage img = null;
        File f = new File("C:\\Users\\steve\\Documents\\NetBeansProjects\\RS3Bot\\bankerfull.jpg");
        img = ImageIO.read(f);
        BufferedImage subimg = img.getSubimage(895, 475, 8, 8);
        for (int y = 0; y < subimg.getHeight(); y++) {
            for (int x = 0; x < subimg.getWidth(); x++) {
                Color c = new Color(subimg.getRGB(x, y));
                arr.add(c);
            }
        }
        return arr;
    }

    public ArrayList getEarthAltarColours() throws IOException {
        ArrayList arr = new ArrayList();
        BufferedImage img = null;
        File f = new File("C:\\Users\\steve\\Documents\\NetBeansProjects\\RS3Bot\\earthaltar.jpg");
        img = ImageIO.read(f);
        BufferedImage subimg = img.getSubimage(941, 716, 28, 20);
        for (int y = 0; y < subimg.getHeight(); y++) {
            for (int x = 0; x < subimg.getWidth(); x++) {
                Color c = new Color(subimg.getRGB(x, y));
                arr.add(c);
            }
        }
        return arr;
    }

    public ArrayList getBankInterfaceColours() throws IOException {
        ArrayList arr = new ArrayList();
        BufferedImage img = null;
        File f = new File("C:\\Users\\steve\\Documents\\NetBeansProjects\\RS3Bot\\bankfull.jpg");
        img = ImageIO.read(f);
        BufferedImage subimg = img.getSubimage(898, 72, 8, 8);
        for (int y = 0; y < subimg.getHeight(); y++) {
            for (int x = 0; x < subimg.getWidth(); x++) {
                Color c = new Color(subimg.getRGB(x, y));
                arr.add(c);
            }
        }
        return arr;
    }

    private ArrayList getdigSiteChestColour() throws IOException {
        ArrayList arr = new ArrayList();
        BufferedImage img = null;
        File f = new File("C:\\Users\\steve\\Documents\\NetBeansProjects\\RS3Bot\\digsitechest.jpg");
        img = ImageIO.read(f);
        BufferedImage subimg = img.getSubimage(971, 621, 8, 8);
        for (int y = 0; y < subimg.getHeight(); y++) {
            for (int x = 0; x < subimg.getWidth(); x++) {
                Color c = new Color(subimg.getRGB(x, y));
                arr.add(c);
            }
        }
        return arr;
    }

    public ArrayList getPetColour() throws IOException {
        ArrayList arr = new ArrayList();
        BufferedImage img = null;
        File f = new File("C:\\Users\\steve\\Documents\\NetBeansProjects\\RS3Bot\\pet.jpg");
        img = ImageIO.read(f);
        BufferedImage subimg = img.getSubimage(1117, 474, 8, 8);
        for (int y = 0; y < subimg.getHeight(); y++) {
            for (int x = 0; x < subimg.getWidth(); x++) {
                Color c = new Color(subimg.getRGB(x, y));
                arr.add(c);
            }
        }
        return arr;
    }

    private ArrayList getNatureAltarColours() throws IOException {
        ArrayList arr = new ArrayList();
        BufferedImage img = null;
        File f = new File("C:\\Users\\steve\\Documents\\NetBeansProjects\\RS3Bot\\naturealtar.jpg");
        img = ImageIO.read(f);
        BufferedImage subimg = img.getSubimage(952, 383, 8, 8);
        for (int y = 0; y < subimg.getHeight(); y++) {
            for (int x = 0; x < subimg.getWidth(); x++) {
                Color c = new Color(subimg.getRGB(x, y));
                arr.add(c);
            }
        }

        return arr;
    }

    public ArrayList getFinalInventorySlotColour() throws IOException {
        ArrayList arr = new ArrayList();
        BufferedImage img = null;
        File f = new File("C:\\Users\\steve\\Documents\\NetBeansProjects\\RS3Bot\\inventory.jpg");
        img = ImageIO.read(f);
        BufferedImage subimg = img.getSubimage(1860, 851, 37, 35);
        for (int y = 0; y < subimg.getHeight(); y++) {
            for (int x = 0; x < subimg.getWidth(); x++) {
                Color c = new Color(subimg.getRGB(x, y));
                arr.add(c);
            }
        }

        return arr;
    }

    public ArrayList getObeliskColour() throws IOException {
        ArrayList arr = new ArrayList();
        BufferedImage img = null;
        File f = new File("C:\\Users\\steve\\Documents\\NetBeansProjects\\RS3Bot\\obelisk.jpg");
        img = ImageIO.read(f);
        BufferedImage subimg = img.getSubimage(998, 480, 8, 8);
        for (int y = 0; y < subimg.getHeight(); y++) {
            for (int x = 0; x < subimg.getWidth(); x++) {
                Color c = new Color(subimg.getRGB(x, y));
                arr.add(c);
            }
        }

        return arr;
    }

    public ArrayList getSummonColours() throws IOException {
        ArrayList arr = new ArrayList();
        BufferedImage img = null;
        File f = new File("C:\\Users\\steve\\Documents\\NetBeansProjects\\RS3Bot\\summon.jpg");
        img = ImageIO.read(f);
        BufferedImage subimg = img.getSubimage(1504, 659, 16, 16);
        for (int y = 0; y < subimg.getHeight(); y++) {
            for (int x = 0; x < subimg.getWidth(); x++) {
                Color c = new Color(subimg.getRGB(x, y));
                arr.add(c);
            }
        }
        return arr;
    }

    private ArrayList getNightShadeColours() throws IOException {
        ArrayList arr = new ArrayList();
        BufferedImage img = null;
        File f = new File("C:\\Users\\steve\\Documents\\NetBeansProjects\\RS3Bot\\nightshade.jpg");
        img = ImageIO.read(f);
        BufferedImage subimg = img.getSubimage(1071, 523, 8, 8);
        for (int y = 0; y < subimg.getHeight(); y++) {
            for (int x = 0; x < subimg.getWidth(); x++) {
                Color c = new Color(subimg.getRGB(x, y));
                arr.add(c);
            }
        }
        return arr;
    }

    private ArrayList getExitColour() throws IOException {
        ArrayList arr = new ArrayList();
        BufferedImage img = null;
        File f = new File("C:\\Users\\steve\\Documents\\NetBeansProjects\\RS3Bot\\exit.jpg");
        img = ImageIO.read(f);
        BufferedImage subimg = img.getSubimage(944, 635, 8, 8);
        for (int y = 0; y < subimg.getHeight(); y++) {
            for (int x = 0; x < subimg.getWidth(); x++) {
                Color c = new Color(subimg.getRGB(x, y));
                arr.add(c);
            }
        }
        return arr;
    }

    public void ClickOn(ArrayList objectcolor) throws FileNotFoundException, InterruptedException, IOException {
        BufferedImage screenshot = screenCapture();
        int x = 754, y = 305, width = 423, height = 399;
        BufferedImage surroundingplayer = screenshot.getSubimage(x, y, width, height);
        ImageIO.write(surroundingplayer, "jpg", new File("surroundings.jpg"));
        int[] coor = findColourCoor(surroundingplayer, objectcolor, 0, x, y, width, height);
        if (coor[0] == 0 && coor[1] == 0) {
            coor[0] = 964 - x;
            coor[1] = 543 - y;
        }
        mouse.move(coor[0] + x, coor[1] + y);
        robot.delay(r.nextInt(20) + 80);
        Autoclick.leftClick(robot);
    }

    public void bigClickOn(ArrayList objectcolor) throws FileNotFoundException, InterruptedException, IOException {
        BufferedImage screenshot = screenCapture();
        int x = 288, y = 16, width = 1365, height = 1001;
        BufferedImage surroundingplayer = screenshot.getSubimage(x, y, width, height);
        ImageIO.write(surroundingplayer, "jpg", new File("surroundings.jpg"));
        int[] coor = findColourCoor(surroundingplayer, objectcolor, 0, x, y, width, height);

        if (coor[0] == 0 && coor[1] == 0) {
            System.out.println("Object not found.");
            coor[0] = 964 - x;
            coor[1] = 543 - y;
        }
        mouse.move(coor[0] + x + 3, coor[1] + y + 1);//High error code
        robot.delay(r.nextInt(20) + 80);
        Autoclick.leftClick(robot);
    }
    

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {

        // Create a new ArrayList 
        ArrayList<T> newList = new ArrayList<T>();

        // Traverse through the first list 
        for (T element : list) {

            // If this element is not present in newList 
            // then add it 
            if (!newList.contains(element)) {

                newList.add(element);
            }
        }

        // return the new list 
        return newList;
    }

    public BufferedImage screenCapture() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(dimension);
        BufferedImage screen = robot.createScreenCapture(rectangle);
        try {
            ImageIO.write(screen, "jpg", new File("screenshot.jpg"));
        } catch (IOException e) {

            e.printStackTrace();
        }
        return screen;
    }

    public int getColour(BufferedImage img, int x, int y) {
        return img.getRGB(x, y);
    }

}
