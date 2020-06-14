/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.tools.ShellFunctions.input;

/**
 *
 * @author Crimson
 */
public class ProgramCheck {

    private String line;
    private String pidInfo = "";
    private boolean check = false;

    public ProgramCheck() throws IOException {
        
        Process p;
        p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

        while ((line = input.readLine()) != null) {
            pidInfo += line + "\n";
        }
        
        input.close();

        if (pidInfo.contains("RuneScape.exe")) {
            check = true;
        }
        else{
            check = false;
        }

    }

    public boolean ProgCheck() {
        return check;
    }
    
    

}
