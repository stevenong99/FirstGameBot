/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripts;

import java.awt.AWTException;
import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs3bot.FXMLDocumentController;

/**
 *
 * @author Crimson
 */
public class RunescapeBot {

    private static boolean isRunning;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     * @throws java.awt.AWTException
     */
    public RunescapeBot(FXMLDocumentController controller) throws AWTException, InterruptedException, IOException {
        controller.display("RS3Bot running.");
        
        isRunning = false; //Refers to RuneScape.exe
        /** <- Continuously checks if RuneScape.exe is running every second ->
         */
        final ScheduledExecutorService executorServiceMain = Executors.newSingleThreadScheduledExecutor();
        executorServiceMain.scheduleAtFixedRate(RunescapeBot::RS3RunningCheck, 0, 1, TimeUnit.SECONDS);

        /**
         * <- Let's the above code run once first, else it will always return false ->
         */
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(RunescapeBot.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (isRunning) {
            Program prog = new Program(controller);
            System.out.println("Starting program in 5 seconds");
            controller.display("Starting program in 5 seconds");
            Thread.sleep(5000);
            prog.mudRunecraftingBotSawmillTele();
        }
    }

    public static void RS3RunningCheck() {
        ProgramCheck PC;
        try {
            PC = new ProgramCheck();
            isRunning = PC.ProgCheck();
            if (isRunning == false) {
                System.out.println("RS3 stopped. Program terminating.");
                System.exit(0);
            } else {
                //System.out.println("RS3 running.");
            }
        } catch (IOException ex) {
            Logger.getLogger(RunescapeBot.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
