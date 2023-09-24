/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectcs318;

import java.awt.Color;
import javax.swing.BorderFactory;

/**
 *
 * @author Punya
 */
public class HardMode extends javax.swing.JFrame {
    // Data Member
    GlobalVar status ;
    Card[] deck = new Card[40] ; // Create Deck
    Card first_button_number = null ;
    Card second_button_number = null ;
    int gameCount = 0 ;
    // timer
    private boolean timestatus = true ;
    private int timecount = 0 ;

    // Constructor
    public HardMode() {
        // Set Component
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Matching Game Card");
        // Code
        for (int i=0 ; i < deck.length ; i++) {
            deck[i] = new Card(i) ;
        }
        // Shuffle
        shuffle() ;
        // Check Deck
        // checkDeck() ;
    }
    // OverLoad
    public HardMode(GlobalVar sentPlayer) {
        // Set Component
        this() ;
        status = sentPlayer ;
        // Progress Bar
        easyProgressbar.setValue(100) ;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (timestatus) {
                        timecount+=1 ;
                        // System.out.println(timecount);
                        Thread.sleep(1 * 1000);
                        easyProgressbar.setValue(100-(timecount));
                        if (timecount==100) {
                            System.out.println("End") ;
                            // Go to Game Over
                            timestatus = false ;
                            GameoverUI gameover = new GameoverUI(status) ;
                            gameover.setVisible(true) ;
                            dispose() ;
                        }
                    }
                }  catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }) ;
        t.start();
    }

    // Shuffle Card
    private void shuffle() {
        for (int i=0 ; i < deck.length ; i++) {
            int index = (int)(Math.random() * deck.length) ;
            Card temp = deck[i] ;
            deck[i] = deck[index] ;
            deck[index] = temp ;
        }
    }
    // Check Deck
    private void checkDeck() {
        for (Card deck1 : deck) {
            System.out.println(deck1.getCardNumber() + " " + deck1.getCardType() );
        }
    }
    // When Click
    private void clickProcess(Card sentCardNumber) {
        if (first_button_number == null) {
            // Set First Button
            first_button_number = sentCardNumber ;
        } else if ( (first_button_number.equals(sentCardNumber))&&(second_button_number == null)) {
            System.out.println("Click Same Card as First one") ;
        } else if (second_button_number == null) {
            // Set Second Button
            second_button_number = sentCardNumber ;
            // Check First BTN and Second BTN is the same type
            if (first_button_number.getCardType().equals(second_button_number.getCardType())) {
                // Match
                setCorrectButton(first_button_number) ;
                setCorrectButton(second_button_number) ;
                // Clear
                first_button_number = null ;
                second_button_number = null ;
                gameCount+=1 ;
                // Go to Game Result
                if (gameCount == 20) {
                    timestatus = false ;
                    ResultUI gameresult = new ResultUI(status,timecount,"Hard") ;
                    gameresult.setVisible(true) ;
                    dispose() ;
                }
            } else {
                // Not Match
                setInconrrectButton(first_button_number) ;
                setInconrrectButton(second_button_number) ;       
            }
            
        } else if ((first_button_number != null)&&(second_button_number != null)) {
            if (first_button_number == sentCardNumber) {
                // Clear
                setDefaultButton(first_button_number) ;
                setDefaultButton(second_button_number) ;
                setDefaultIcon(second_button_number) ;
                second_button_number = null ;
            } else if (second_button_number == sentCardNumber) {
                // Clear
                setDefaultButton(first_button_number) ;
                setDefaultButton(second_button_number) ;
                setDefaultIcon(first_button_number) ;
                first_button_number = second_button_number ;
                second_button_number = null ;
            } else {
                setDefaultButton(first_button_number) ;
                setDefaultButton(second_button_number) ;
                setDefaultIcon(first_button_number) ;
                setDefaultIcon(second_button_number) ;
                // Clear
                first_button_number = null ;
                second_button_number = null ;
                // Set First Button
                first_button_number = sentCardNumber ;
            }
        }
    }
    // Match Correct
    private void setCorrectButton(Card sentNumber) {
        if (sentNumber == deck[0]) {
            btn_easy1.setEnabled(false) ;
            btn_easy1.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[1]) {
            btn_easy2.setEnabled(false) ;
            btn_easy2.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[2]) {
            btn_easy3.setEnabled(false) ;
            btn_easy3.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[3]) {
            btn_easy4.setEnabled(false) ;
            btn_easy4.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[4]) {
            btn_easy5.setEnabled(false) ;
            btn_easy5.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[5]) {
            btn_easy6.setEnabled(false) ;
            btn_easy6.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[6]) {
            btn_easy7.setEnabled(false) ;
            btn_easy7.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[7]) {
            btn_easy8.setEnabled(false) ;
            btn_easy8.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[8]) {
            btn_easy9.setEnabled(false) ;
            btn_easy9.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[9]) {
            btn_easy10.setEnabled(false) ;
            btn_easy10.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[10]) {
            btn_easy11.setEnabled(false) ;
            btn_easy11.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }
        else if (sentNumber == deck[11]) {
            btn_easy12.setEnabled(false) ;
            btn_easy12.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }
        else if (sentNumber == deck[12]) {
            btn_easy13.setEnabled(false) ;
            btn_easy13.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[13]) {
            btn_easy14.setEnabled(false) ;
            btn_easy14.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[14]) {
            btn_easy15.setEnabled(false) ;
            btn_easy15.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[15]) {
            btn_easy16.setEnabled(false) ;
            btn_easy16.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[16]) {
            btn_easy17.setEnabled(false) ;
            btn_easy17.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[17]) {
            btn_easy18.setEnabled(false) ;
            btn_easy18.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[18]) {
            btn_easy19.setEnabled(false) ;
            btn_easy19.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[19]) {
            btn_easy20.setEnabled(false) ;
            btn_easy20.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[20]) {
            btn_easy21.setEnabled(false) ;
            btn_easy21.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[21]) {
            btn_easy22.setEnabled(false) ;
            btn_easy22.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[22]) {
            btn_easy23.setEnabled(false) ;
            btn_easy23.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[23]) {
            btn_easy24.setEnabled(false) ;
            btn_easy24.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[24]) {
            btn_easy25.setEnabled(false) ;
            btn_easy25.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[25]) {
            btn_easy26.setEnabled(false) ;
            btn_easy26.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[26]) {
            btn_easy27.setEnabled(false) ;
            btn_easy27.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[27]) {
            btn_easy28.setEnabled(false) ;
            btn_easy28.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[28]) {
            btn_easy29.setEnabled(false) ;
            btn_easy29.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[29]) {
            btn_easy30.setEnabled(false) ;
            btn_easy30.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[30]) {
            btn_easy31.setEnabled(false) ;
            btn_easy31.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[31]) {
            btn_easy32.setEnabled(false) ;
            btn_easy32.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[32]) {
            btn_easy33.setEnabled(false) ;
            btn_easy33.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[33]) {
            btn_easy34.setEnabled(false) ;
            btn_easy34.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[34]) {
            btn_easy35.setEnabled(false) ;
            btn_easy35.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[35]) {
            btn_easy36.setEnabled(false) ;
            btn_easy36.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[36]) {
            btn_easy37.setEnabled(false) ;
            btn_easy37.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[37]) {
            btn_easy38.setEnabled(false) ;
            btn_easy38.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[38]) {
            btn_easy39.setEnabled(false) ;
            btn_easy39.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }else if (sentNumber == deck[39]) {
            btn_easy40.setEnabled(false) ;
            btn_easy40.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }             
    }
    // Match Incorrect
    private void setInconrrectButton(Card sentNumber) {
        if (sentNumber == deck[0]) {
            btn_easy1.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[1]) {
            btn_easy2.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[2]) {
            btn_easy3.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[3]) {
            btn_easy4.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[4]) {
            btn_easy5.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[5]) {
            btn_easy6.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[6]) {
            btn_easy7.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[7]) {
            btn_easy8.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[8]) {
            btn_easy9.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[9]) {
            btn_easy10.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[10]) {
            btn_easy11.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[11]) {
            btn_easy12.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[12]) {
            btn_easy13.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[13]) {
            btn_easy14.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[14]) {
            btn_easy15.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[15]) {
            btn_easy16.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[16]) {
            btn_easy17.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[17]) {
            btn_easy18.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[18]) {
            btn_easy19.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[19]) {
            btn_easy20.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[20]) {
            btn_easy21.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[21]) {
            btn_easy22.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[22]) {
            btn_easy23.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[23]) {
            btn_easy24.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[24]) {
            btn_easy25.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[25]) {
            btn_easy26.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[26]) {
            btn_easy27.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[27]) {
            btn_easy28.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[28]) {
            btn_easy29.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[29]) {
            btn_easy30.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[30]) {
            btn_easy31.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[31]) {
            btn_easy32.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[32]) {
            btn_easy33.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[33]) {
            btn_easy34.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[34]) {
            btn_easy35.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[35]) {
            btn_easy36.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[36]) {
            btn_easy37.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[37]) {
            btn_easy38.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[38]) {
            btn_easy39.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else if (sentNumber == deck[39]) {
            btn_easy40.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
    }
    // Set Default Border
    private void setDefaultButton(Card sentNumber) {
        if (sentNumber == deck[0]) {
            btn_easy1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[1]) {
            btn_easy2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[2]) {
            btn_easy3.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[3]) {
            btn_easy4.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[4]) {
            btn_easy5.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[5]) {
            btn_easy6.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[6]) {
            btn_easy7.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[7]) {
            btn_easy8.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[8]) {
            btn_easy9.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[9]) {
            btn_easy10.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[10]) {
            btn_easy11.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[11]) {
            btn_easy12.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[12]) {
            btn_easy13.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[13]) {
            btn_easy14.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[14]) {
            btn_easy15.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[15]) {
            btn_easy16.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[16]) {
            btn_easy17.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[17]) {
            btn_easy18.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[18]) {
            btn_easy19.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[19]) {
            btn_easy20.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[20]) {
            btn_easy21.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[21]) {
            btn_easy22.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[22]) {
            btn_easy23.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[23]) {
            btn_easy24.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[24]) {
            btn_easy25.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[25]) {
            btn_easy26.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[26]) {
            btn_easy27.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[27]) {
            btn_easy28.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[28]) {
            btn_easy29.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[29]) {
            btn_easy30.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[30]) {
            btn_easy31.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[31]) {
            btn_easy32.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[32]) {
            btn_easy33.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[33]) {
            btn_easy34.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[34]) {
            btn_easy35.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[35]) {
            btn_easy36.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[36]) {
            btn_easy37.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[37]) {
            btn_easy38.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[38]) {
            btn_easy39.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }else if (sentNumber == deck[39]) {
            btn_easy40.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }
    }
    // Set Default Icon
    private void setDefaultIcon(Card sentNumber) {
        if (sentNumber == deck[0]) {
            btn_easy1.setIcon(null) ;
        }else if (sentNumber == deck[1]) {
            btn_easy2.setIcon(null) ;
        }else if (sentNumber == deck[2]) {
            btn_easy3.setIcon(null) ;
        }else if (sentNumber == deck[3]) {
            btn_easy4.setIcon(null) ;
        }else if (sentNumber == deck[4]) {
            btn_easy5.setIcon(null) ;
        }else if (sentNumber == deck[5]) {
            btn_easy6.setIcon(null) ;
        }else if (sentNumber == deck[6]) {
            btn_easy7.setIcon(null) ;
        }else if (sentNumber == deck[7]) {
            btn_easy8.setIcon(null) ;
        }else if (sentNumber == deck[8]) {
            btn_easy9.setIcon(null) ;
        }else if (sentNumber == deck[9]) {
            btn_easy10.setIcon(null) ;
        }else if (sentNumber == deck[10]) {
            btn_easy11.setIcon(null) ;
        }else if (sentNumber == deck[11]) {
            btn_easy12.setIcon(null) ;
        }else if (sentNumber == deck[12]) {
            btn_easy13.setIcon(null) ;
        }else if (sentNumber == deck[13]) {
            btn_easy14.setIcon(null) ;
        }else if (sentNumber == deck[14]) {
            btn_easy15.setIcon(null) ;
        }else if (sentNumber == deck[15]) {
            btn_easy16.setIcon(null) ;
        }else if (sentNumber == deck[16]) {
            btn_easy17.setIcon(null) ;
        }else if (sentNumber == deck[17]) {
            btn_easy18.setIcon(null) ;
        }else if (sentNumber == deck[18]) {
            btn_easy19.setIcon(null) ;
        }else if (sentNumber == deck[19]) {
            btn_easy20.setIcon(null) ;
        }else if (sentNumber == deck[20]) {
            btn_easy21.setIcon(null) ;
        }else if (sentNumber == deck[21]) {
            btn_easy22.setIcon(null) ;
        }else if (sentNumber == deck[22]) {
            btn_easy23.setIcon(null) ;
        }else if (sentNumber == deck[23]) {
            btn_easy24.setIcon(null) ;
        }else if (sentNumber == deck[24]) {
            btn_easy25.setIcon(null) ;
        }else if (sentNumber == deck[25]) {
            btn_easy26.setIcon(null) ;
        }else if (sentNumber == deck[26]) {
            btn_easy27.setIcon(null) ;
        }else if (sentNumber == deck[27]) {
            btn_easy28.setIcon(null) ;
        }else if (sentNumber == deck[28]) {
            btn_easy29.setIcon(null) ;
        }else if (sentNumber == deck[29]) {
            btn_easy30.setIcon(null) ;
        }else if (sentNumber == deck[30]) {
            btn_easy31.setIcon(null) ;
        }else if (sentNumber == deck[31]) {
            btn_easy32.setIcon(null) ;
        }else if (sentNumber == deck[32]) {
            btn_easy33.setIcon(null) ;
        }else if (sentNumber == deck[33]) {
            btn_easy34.setIcon(null) ;
        }else if (sentNumber == deck[34]) {
            btn_easy35.setIcon(null) ;
        }else if (sentNumber == deck[35]) {
            btn_easy36.setIcon(null) ;
        }else if (sentNumber == deck[36]) {
            btn_easy37.setIcon(null) ;
        }else if (sentNumber == deck[37]) {
            btn_easy38.setIcon(null) ;
        }else if (sentNumber == deck[38]) {
            btn_easy39.setIcon(null) ;
        }else if (sentNumber == deck[39]) {
            btn_easy40.setIcon(null) ;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        easyProgressbar = new javax.swing.JProgressBar();
        btn_surrender = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_easy1 = new javax.swing.JButton();
        btn_easy2 = new javax.swing.JButton();
        btn_easy9 = new javax.swing.JButton();
        btn_easy10 = new javax.swing.JButton();
        btn_easy3 = new javax.swing.JButton();
        btn_easy4 = new javax.swing.JButton();
        btn_easy11 = new javax.swing.JButton();
        btn_easy17 = new javax.swing.JButton();
        btn_easy18 = new javax.swing.JButton();
        btn_easy19 = new javax.swing.JButton();
        btn_easy25 = new javax.swing.JButton();
        btn_easy26 = new javax.swing.JButton();
        btn_easy27 = new javax.swing.JButton();
        btn_easy28 = new javax.swing.JButton();
        btn_easy29 = new javax.swing.JButton();
        btn_easy30 = new javax.swing.JButton();
        btn_easy31 = new javax.swing.JButton();
        btn_easy20 = new javax.swing.JButton();
        btn_easy21 = new javax.swing.JButton();
        btn_easy22 = new javax.swing.JButton();
        btn_easy23 = new javax.swing.JButton();
        btn_easy12 = new javax.swing.JButton();
        btn_easy13 = new javax.swing.JButton();
        btn_easy5 = new javax.swing.JButton();
        btn_easy6 = new javax.swing.JButton();
        btn_easy14 = new javax.swing.JButton();
        btn_easy15 = new javax.swing.JButton();
        btn_easy8 = new javax.swing.JButton();
        btn_easy7 = new javax.swing.JButton();
        btn_easy16 = new javax.swing.JButton();
        btn_easy24 = new javax.swing.JButton();
        btn_easy32 = new javax.swing.JButton();
        btn_easy33 = new javax.swing.JButton();
        btn_easy34 = new javax.swing.JButton();
        btn_easy35 = new javax.swing.JButton();
        btn_easy36 = new javax.swing.JButton();
        btn_easy37 = new javax.swing.JButton();
        btn_easy38 = new javax.swing.JButton();
        btn_easy39 = new javax.swing.JButton();
        btn_easy40 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(181, 212, 238));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 550));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 550));

        easyProgressbar.setBackground(new java.awt.Color(255, 255, 255));

        btn_surrender.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btn_surrender.setText("Surrender");
        btn_surrender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_surrenderActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(181, 212, 238));

        btn_easy1.setText("1");
        btn_easy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy1ActionPerformed(evt);
            }
        });

        btn_easy2.setText("2");
        btn_easy2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy2ActionPerformed(evt);
            }
        });

        btn_easy9.setText("9");
        btn_easy9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy9ActionPerformed(evt);
            }
        });

        btn_easy10.setText("10");
        btn_easy10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy10ActionPerformed(evt);
            }
        });

        btn_easy3.setText("3");
        btn_easy3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy3ActionPerformed(evt);
            }
        });

        btn_easy4.setText("4");
        btn_easy4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy4ActionPerformed(evt);
            }
        });

        btn_easy11.setText("11");
        btn_easy11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy11ActionPerformed(evt);
            }
        });

        btn_easy17.setText("17");
        btn_easy17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy17ActionPerformed(evt);
            }
        });

        btn_easy18.setText("18");
        btn_easy18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy18ActionPerformed(evt);
            }
        });

        btn_easy19.setText("19");
        btn_easy19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy19ActionPerformed(evt);
            }
        });

        btn_easy25.setText("25");
        btn_easy25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy25ActionPerformed(evt);
            }
        });

        btn_easy26.setText("26");
        btn_easy26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy26ActionPerformed(evt);
            }
        });

        btn_easy27.setText("27");
        btn_easy27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy27ActionPerformed(evt);
            }
        });

        btn_easy28.setText("28");
        btn_easy28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy28ActionPerformed(evt);
            }
        });

        btn_easy29.setText("29");
        btn_easy29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy29ActionPerformed(evt);
            }
        });

        btn_easy30.setText("30");
        btn_easy30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy30ActionPerformed(evt);
            }
        });

        btn_easy31.setText("31");
        btn_easy31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy31ActionPerformed(evt);
            }
        });

        btn_easy20.setText("20");
        btn_easy20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy20ActionPerformed(evt);
            }
        });

        btn_easy21.setText("21");
        btn_easy21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy21ActionPerformed(evt);
            }
        });

        btn_easy22.setText("22");
        btn_easy22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy22ActionPerformed(evt);
            }
        });

        btn_easy23.setText("23");
        btn_easy23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy23ActionPerformed(evt);
            }
        });

        btn_easy12.setText("12");
        btn_easy12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy12ActionPerformed(evt);
            }
        });

        btn_easy13.setText("13");
        btn_easy13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy13ActionPerformed(evt);
            }
        });

        btn_easy5.setText("5");
        btn_easy5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy5ActionPerformed(evt);
            }
        });

        btn_easy6.setText("6");
        btn_easy6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy6ActionPerformed(evt);
            }
        });

        btn_easy14.setText("14");
        btn_easy14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy14ActionPerformed(evt);
            }
        });

        btn_easy15.setText("15");
        btn_easy15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy15ActionPerformed(evt);
            }
        });

        btn_easy8.setText("8");
        btn_easy8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy8ActionPerformed(evt);
            }
        });

        btn_easy7.setText("7");
        btn_easy7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy7ActionPerformed(evt);
            }
        });

        btn_easy16.setText("16");
        btn_easy16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy16ActionPerformed(evt);
            }
        });

        btn_easy24.setText("24");
        btn_easy24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy24ActionPerformed(evt);
            }
        });

        btn_easy32.setText("32");
        btn_easy32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy32ActionPerformed(evt);
            }
        });

        btn_easy33.setText("33");
        btn_easy33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy33ActionPerformed(evt);
            }
        });

        btn_easy34.setText("34");
        btn_easy34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy34ActionPerformed(evt);
            }
        });

        btn_easy35.setText("35");
        btn_easy35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy35ActionPerformed(evt);
            }
        });

        btn_easy36.setText("36");
        btn_easy36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy36ActionPerformed(evt);
            }
        });

        btn_easy37.setText("37");
        btn_easy37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy37ActionPerformed(evt);
            }
        });

        btn_easy38.setText("38");
        btn_easy38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy38ActionPerformed(evt);
            }
        });

        btn_easy39.setText("39");
        btn_easy39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy39ActionPerformed(evt);
            }
        });

        btn_easy40.setText("40");
        btn_easy40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy40ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_easy9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_easy17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy21, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy23, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy24, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_easy25, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy26, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy27, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy28, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy29, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy30, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy31, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_easy32, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_easy1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_easy8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_easy33, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy34, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy35, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy36, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy37, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy38, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy39, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy40, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_easy1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_easy9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_easy17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy21, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy23, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy24, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_easy25, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy26, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy27, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy28, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy29, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy30, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy31, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy32, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_easy33, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy34, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy35, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy36, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy37, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy38, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy39, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy40, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(easyProgressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_surrender, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(easyProgressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_surrender, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_surrenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_surrenderActionPerformed
        // Go to Game Over
        timestatus = false ;
        GameoverUI gameover = new GameoverUI(status) ;
        gameover.setVisible(true) ;
        dispose() ;
    }//GEN-LAST:event_btn_surrenderActionPerformed

    private void btn_easy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy1ActionPerformed
        // When Click Set Image
        btn_easy1.setIcon(deck[0].getCardImage()) ;
        // Click process
        clickProcess(deck[0]) ;
    }//GEN-LAST:event_btn_easy1ActionPerformed

    private void btn_easy2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy2ActionPerformed
        // When Click Set Image
        btn_easy2.setIcon(deck[1].getCardImage()) ;
        // Click process
        clickProcess(deck[1]) ;
    }//GEN-LAST:event_btn_easy2ActionPerformed

    private void btn_easy3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy3ActionPerformed
        // When Click Set Image
        btn_easy3.setIcon(deck[2].getCardImage()) ;
        // Click process
        clickProcess(deck[2]) ;
    }//GEN-LAST:event_btn_easy3ActionPerformed

    private void btn_easy4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy4ActionPerformed
        // When Click Set Image
        btn_easy4.setIcon(deck[3].getCardImage()) ;
        // Click process
        clickProcess(deck[3]) ;
    }//GEN-LAST:event_btn_easy4ActionPerformed

    private void btn_easy5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy5ActionPerformed
        // When Click Set Image
        btn_easy5.setIcon(deck[4].getCardImage()) ;
        // Click process
        clickProcess(deck[4]) ;
    }//GEN-LAST:event_btn_easy5ActionPerformed

    private void btn_easy6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy6ActionPerformed
        // When Click Set Image
        btn_easy6.setIcon(deck[5].getCardImage()) ;
        // Click process
        clickProcess(deck[5]) ;
    }//GEN-LAST:event_btn_easy6ActionPerformed

    private void btn_easy7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy7ActionPerformed
        // When Click Set Image
        btn_easy7.setIcon(deck[6].getCardImage()) ;
        // Click process
        clickProcess(deck[6]) ;
    }//GEN-LAST:event_btn_easy7ActionPerformed

    private void btn_easy8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy8ActionPerformed
        // When Click Set Image
        btn_easy8.setIcon(deck[7].getCardImage()) ;
        // Click process
        clickProcess(deck[7]) ;
    }//GEN-LAST:event_btn_easy8ActionPerformed

    private void btn_easy9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy9ActionPerformed
        // When Click Set Image
        btn_easy9.setIcon(deck[8].getCardImage()) ;
        // Click process
        clickProcess(deck[8]) ;
    }//GEN-LAST:event_btn_easy9ActionPerformed

    private void btn_easy10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy10ActionPerformed
        // When Click Set Image
        btn_easy10.setIcon(deck[9].getCardImage()) ;
        // Click process
        clickProcess(deck[9]) ;
    }//GEN-LAST:event_btn_easy10ActionPerformed

    private void btn_easy11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy11ActionPerformed
        // When Click Set Image
        btn_easy11.setIcon(deck[10].getCardImage()) ;
        // Click process
        clickProcess(deck[10]) ;
    }//GEN-LAST:event_btn_easy11ActionPerformed

    private void btn_easy12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy12ActionPerformed
        // When Click Set Image
        btn_easy12.setIcon(deck[11].getCardImage()) ;
        // Click process
        clickProcess(deck[11]) ;
    }//GEN-LAST:event_btn_easy12ActionPerformed

    private void btn_easy13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy13ActionPerformed
        // When Click Set Image
        btn_easy13.setIcon(deck[12].getCardImage()) ;
        // Click process
        clickProcess(deck[12]) ;
    }//GEN-LAST:event_btn_easy13ActionPerformed

    private void btn_easy14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy14ActionPerformed
        // When Click Set Image
        btn_easy14.setIcon(deck[13].getCardImage()) ;
        // Click process
        clickProcess(deck[13]) ;
    }//GEN-LAST:event_btn_easy14ActionPerformed

    private void btn_easy15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy15ActionPerformed
        // When Click Set Image
        btn_easy15.setIcon(deck[14].getCardImage()) ;
        // Click process
        clickProcess(deck[14]) ;
    }//GEN-LAST:event_btn_easy15ActionPerformed

    private void btn_easy16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy16ActionPerformed
        // When Click Set Image
        btn_easy16.setIcon(deck[15].getCardImage()) ;
        // Click process
        clickProcess(deck[15]) ;
    }//GEN-LAST:event_btn_easy16ActionPerformed

    private void btn_easy17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy17ActionPerformed
        // When Click Set Image
        btn_easy17.setIcon(deck[16].getCardImage()) ;
        // Click process
        clickProcess(deck[16]) ;
    }//GEN-LAST:event_btn_easy17ActionPerformed

    private void btn_easy18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy18ActionPerformed
        // When Click Set Image
        btn_easy18.setIcon(deck[17].getCardImage()) ;
        // Click process
        clickProcess(deck[17]) ;
    }//GEN-LAST:event_btn_easy18ActionPerformed

    private void btn_easy19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy19ActionPerformed
        // When Click Set Image
        btn_easy19.setIcon(deck[18].getCardImage()) ;
        // Click process
        clickProcess(deck[18]) ;
    }//GEN-LAST:event_btn_easy19ActionPerformed

    private void btn_easy20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy20ActionPerformed
        // When Click Set Image
        btn_easy20.setIcon(deck[19].getCardImage()) ;
        // Click process
        clickProcess(deck[19]) ;
    }//GEN-LAST:event_btn_easy20ActionPerformed

    private void btn_easy21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy21ActionPerformed
        // When Click Set Image
        btn_easy21.setIcon(deck[20].getCardImage()) ;
        // Click process
        clickProcess(deck[20]) ;
    }//GEN-LAST:event_btn_easy21ActionPerformed

    private void btn_easy22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy22ActionPerformed
        // When Click Set Image
        btn_easy22.setIcon(deck[21].getCardImage()) ;
        // Click process
        clickProcess(deck[21]) ;
    }//GEN-LAST:event_btn_easy22ActionPerformed

    private void btn_easy23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy23ActionPerformed
        // When Click Set Image
        btn_easy23.setIcon(deck[22].getCardImage()) ;
        // Click process
        clickProcess(deck[22]) ;
    }//GEN-LAST:event_btn_easy23ActionPerformed

    private void btn_easy24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy24ActionPerformed
        // When Click Set Image
        btn_easy24.setIcon(deck[23].getCardImage()) ;
        // Click process
        clickProcess(deck[23]) ;
    }//GEN-LAST:event_btn_easy24ActionPerformed

    private void btn_easy25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy25ActionPerformed
        // When Click Set Image
        btn_easy25.setIcon(deck[24].getCardImage()) ;
        // Click process
        clickProcess(deck[24]) ;
    }//GEN-LAST:event_btn_easy25ActionPerformed

    private void btn_easy26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy26ActionPerformed
        // When Click Set Image
        btn_easy26.setIcon(deck[25].getCardImage()) ;
        // Click process
        clickProcess(deck[25]) ;
    }//GEN-LAST:event_btn_easy26ActionPerformed

    private void btn_easy27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy27ActionPerformed
        // When Click Set Image
        btn_easy27.setIcon(deck[26].getCardImage()) ;
        // Click process
        clickProcess(deck[26]) ;
    }//GEN-LAST:event_btn_easy27ActionPerformed

    private void btn_easy28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy28ActionPerformed
        // When Click Set Image
        btn_easy28.setIcon(deck[27].getCardImage()) ;
        // Click process
        clickProcess(deck[27]) ;
    }//GEN-LAST:event_btn_easy28ActionPerformed

    private void btn_easy29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy29ActionPerformed
        // When Click Set Image
        btn_easy29.setIcon(deck[28].getCardImage()) ;
        // Click process
        clickProcess(deck[28]) ;
    }//GEN-LAST:event_btn_easy29ActionPerformed

    private void btn_easy30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy30ActionPerformed
        // When Click Set Image
        btn_easy30.setIcon(deck[29].getCardImage()) ;
        // Click process
        clickProcess(deck[29]) ;
    }//GEN-LAST:event_btn_easy30ActionPerformed

    private void btn_easy31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy31ActionPerformed
        // When Click Set Image
        btn_easy31.setIcon(deck[30].getCardImage()) ;
        // Click process
        clickProcess(deck[30]) ;
    }//GEN-LAST:event_btn_easy31ActionPerformed

    private void btn_easy32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy32ActionPerformed
        // When Click Set Image
        btn_easy32.setIcon(deck[31].getCardImage()) ;
        // Click process
        clickProcess(deck[31]) ;
    }//GEN-LAST:event_btn_easy32ActionPerformed

    private void btn_easy33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy33ActionPerformed
        // When Click Set Image
        btn_easy33.setIcon(deck[32].getCardImage()) ;
        // Click process
        clickProcess(deck[32]) ;
    }//GEN-LAST:event_btn_easy33ActionPerformed

    private void btn_easy34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy34ActionPerformed
        // When Click Set Image
        btn_easy34.setIcon(deck[33].getCardImage()) ;
        // Click process
        clickProcess(deck[33]) ;
    }//GEN-LAST:event_btn_easy34ActionPerformed

    private void btn_easy35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy35ActionPerformed
        // When Click Set Image
        btn_easy35.setIcon(deck[34].getCardImage()) ;
        // Click process
        clickProcess(deck[34]) ;
    }//GEN-LAST:event_btn_easy35ActionPerformed

    private void btn_easy36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy36ActionPerformed
        // When Click Set Image
        btn_easy36.setIcon(deck[35].getCardImage()) ;
        // Click process
        clickProcess(deck[35]) ;
    }//GEN-LAST:event_btn_easy36ActionPerformed

    private void btn_easy37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy37ActionPerformed
        // When Click Set Image
        btn_easy37.setIcon(deck[36].getCardImage()) ;
        // Click process
        clickProcess(deck[36]) ;
    }//GEN-LAST:event_btn_easy37ActionPerformed

    private void btn_easy38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy38ActionPerformed
        // When Click Set Image
        btn_easy38.setIcon(deck[37].getCardImage()) ;
        // Click process
        clickProcess(deck[37]) ;
    }//GEN-LAST:event_btn_easy38ActionPerformed

    private void btn_easy39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy39ActionPerformed
        // When Click Set Image
        btn_easy39.setIcon(deck[38].getCardImage()) ;
        // Click process
        clickProcess(deck[38]) ;
    }//GEN-LAST:event_btn_easy39ActionPerformed

    private void btn_easy40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_easy40ActionPerformed
        // When Click Set Image
        btn_easy40.setIcon(deck[39].getCardImage()) ;
        // Click process
        clickProcess(deck[39]) ;
    }//GEN-LAST:event_btn_easy40ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HardMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HardMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HardMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HardMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HardMode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_easy1;
    private javax.swing.JButton btn_easy10;
    private javax.swing.JButton btn_easy11;
    private javax.swing.JButton btn_easy12;
    private javax.swing.JButton btn_easy13;
    private javax.swing.JButton btn_easy14;
    private javax.swing.JButton btn_easy15;
    private javax.swing.JButton btn_easy16;
    private javax.swing.JButton btn_easy17;
    private javax.swing.JButton btn_easy18;
    private javax.swing.JButton btn_easy19;
    private javax.swing.JButton btn_easy2;
    private javax.swing.JButton btn_easy20;
    private javax.swing.JButton btn_easy21;
    private javax.swing.JButton btn_easy22;
    private javax.swing.JButton btn_easy23;
    private javax.swing.JButton btn_easy24;
    private javax.swing.JButton btn_easy25;
    private javax.swing.JButton btn_easy26;
    private javax.swing.JButton btn_easy27;
    private javax.swing.JButton btn_easy28;
    private javax.swing.JButton btn_easy29;
    private javax.swing.JButton btn_easy3;
    private javax.swing.JButton btn_easy30;
    private javax.swing.JButton btn_easy31;
    private javax.swing.JButton btn_easy32;
    private javax.swing.JButton btn_easy33;
    private javax.swing.JButton btn_easy34;
    private javax.swing.JButton btn_easy35;
    private javax.swing.JButton btn_easy36;
    private javax.swing.JButton btn_easy37;
    private javax.swing.JButton btn_easy38;
    private javax.swing.JButton btn_easy39;
    private javax.swing.JButton btn_easy4;
    private javax.swing.JButton btn_easy40;
    private javax.swing.JButton btn_easy5;
    private javax.swing.JButton btn_easy6;
    private javax.swing.JButton btn_easy7;
    private javax.swing.JButton btn_easy8;
    private javax.swing.JButton btn_easy9;
    private javax.swing.JButton btn_surrender;
    private javax.swing.JProgressBar easyProgressbar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
