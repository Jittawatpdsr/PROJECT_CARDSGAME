/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.projectcs318;

import java.io.IOException;

/**
 *
 * @author Punya
 */

public class ProjectCS318 {
    public static void main(String[] args) throws IOException {
        // Global Var
        GlobalVar status = new GlobalVar() ;
        // Main Menu
        MainMenu ui = new MainMenu(status) ;
        ui.setVisible(true) ;
        
    }
}
