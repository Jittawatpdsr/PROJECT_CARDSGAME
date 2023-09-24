/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectcs318;

import javax.swing.ImageIcon;

public class Card {
    
    // Data Member
    private int cardNumber ;
    private String cardType ;
    private ImageIcon cardImage ;
    
    // Constructor
    public Card(int sentNumber) {
        setCardNumber(sentNumber) ;
        setCardType(sentNumber) ;
        setCardIcon(sentNumber) ;
    }
    
    // Get Card Number
    public int getCardNumber() {
        return this.cardNumber ;
    }
    // Get Card Type
    public String getCardType() {
        return this.cardType ;
    }
    // Get Card Image
    public ImageIcon getCardImage() {
        return this.cardImage ;
    }
    
    // Set Card Number
    private void setCardNumber(int sentNumber) {
        this.cardNumber = sentNumber ;
    }
    // Set Card Type
    private void setCardType(int sentNumber) {
        if (sentNumber<2) {
            this.cardType = "TYPE01" ;
        } else if (sentNumber<4) {
            this.cardType = "TYPE02" ;
        } else if (sentNumber<6) {
            this.cardType = "TYPE03" ;
        } else if (sentNumber<8) {
            this.cardType = "TYPE04" ;
        } else if (sentNumber<10) {
            this.cardType = "TYPE05" ;
        } else if (sentNumber<12) {
            this.cardType = "TYPE06" ;
        } else if (sentNumber<14) {
            this.cardType = "TYPE07" ;
        } else if (sentNumber<16) {
            this.cardType = "TYPE08" ;
        } else if (sentNumber<18) {
            this.cardType = "TYPE09" ;
        } else if (sentNumber<20) {
            this.cardType = "TYPE10" ;
        } else if (sentNumber<22) {
            this.cardType = "TYPE11" ;
        } else if (sentNumber<24) {
            this.cardType = "TYPE12" ;
        } else if (sentNumber<26) {
            this.cardType = "TYPE13" ;
        } else if (sentNumber<28) {
            this.cardType = "TYPE14" ;
        } else if (sentNumber<30) {
            this.cardType = "TYPE15" ;
        } else if (sentNumber<32) {
            this.cardType = "TYPE16" ;
        } else if (sentNumber<34) {
            this.cardType = "TYPE17" ;
        } else if (sentNumber<36) {
            this.cardType = "TYPE18" ;
        } else if (sentNumber<38) {
            this.cardType = "TYPE19" ;
        } else if (sentNumber<40) {
            this.cardType = "TYPE20" ;
        } else if (sentNumber<42) {
            this.cardType = "TYPE21" ;
        }
    }
    // Set Card Image
    private void setCardIcon(int sentNumber) {
        if (sentNumber<2) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_01.png") ;
        } else if (sentNumber<4) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_02.png") ;
        } else if (sentNumber<6) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_03.png") ;
        } else if (sentNumber<8) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_04.png") ;
        } else if (sentNumber<10) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_05.png") ;
        } else if (sentNumber<12) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_06.png") ;
        } else if (sentNumber<14) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_07.png") ;
        } else if (sentNumber<16) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_08.png") ;
        } else if (sentNumber<18) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_09.png") ;
        } else if (sentNumber<20) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_10.png") ;
        } else if (sentNumber<22) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_11.png") ;
        } else if (sentNumber<24) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_12.png") ;
        } else if (sentNumber<26) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_13.png") ;
        } else if (sentNumber<28) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_14.png") ;
        } else if (sentNumber<30) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_15.png") ;
        } else if (sentNumber<32) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_16.png") ;
        } else if (sentNumber<34) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_17.png") ;
        } else if (sentNumber<36) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_18.png") ;
        } else if (sentNumber<38) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_19.png") ;
        } else if (sentNumber<40) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_20.png") ;
        } else if (sentNumber<42) {
            this.cardImage = new ImageIcon("..//ProjectCS318//image//image_21.png") ;
        } 
    }
}
