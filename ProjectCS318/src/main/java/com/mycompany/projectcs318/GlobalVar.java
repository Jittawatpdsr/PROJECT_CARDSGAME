/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectcs318;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GlobalVar {
    // Data Member
    private final Path file_easy = Path.of("..//ProjectCS318//easyscore.txt");
    private final Path file_medium = Path.of("..//ProjectCS318//mediumscore.txt");
    private final Path file_hard = Path.of("..//ProjectCS318//hardscore.txt");  
    private int easyModeTime ; // East Mode
    private int mediumModeTime ; // Medium Mode
    private int hardModeTime ; // Hard Mode

    // Constructor
    public GlobalVar() throws IOException {
        // Easy Score
        String file_value_easy = Files.readString(file_easy);
        Integer easyScore = Integer.valueOf(file_value_easy);
        this.easyModeTime = easyScore ;
        // Medium Score
        String file_value_medium = Files.readString(file_medium);
        Integer mediumScore = Integer.valueOf(file_value_medium);
        this.mediumModeTime = mediumScore ;
        // Hard Score
        String file_value_hard = Files.readString(file_hard);
        Integer hardScore = Integer.valueOf(file_value_hard);
        this.hardModeTime = hardScore ;
    }
    
    // Write File
    public void writeFile(int sentNewEasy,int sentNewMedium,int sentNewHard) throws IOException {
        // Write Easy File
        Files.writeString(file_easy, String.valueOf(sentNewEasy) );
        // Write Medium File
        Files.writeString(file_medium, String.valueOf(sentNewMedium) );
        // Write Hard File
        Files.writeString(file_hard, String.valueOf(sentNewHard) );
    }
    // Get Score
    public int getEasyScore() {
        return this.easyModeTime ;
    }
    public int getMediumScore() {
        return this.mediumModeTime ;
    }
    public int getHardScore() {
        return this.hardModeTime ;
    }
    
    // Set Score
    public void setEasyScore(int sentNewScore) {
        this.easyModeTime = sentNewScore ;
    }
    public void setMediumScore(int sentNewScore) {
        this.mediumModeTime = sentNewScore ;
    }
    public void setHardScore(int sentNewScore) {
        this.hardModeTime = sentNewScore ;
    }
}
