/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectcs318;

import java.awt.Color;
import javax.swing.BorderFactory;

public class EasyMode extends javax.swing.JFrame {
    // Data Member
    GlobalVar status ;
    Card[] deck = new Card[8] ; // Create Deck
    Card first_button_number = null ;
    Card second_button_number = null ;
    int gameCount = 0 ;
    // timer
    private boolean timestatus = true ;
    private int timecount = 0 ;

    // Constructor
    public EasyMode() {
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
    public EasyMode(GlobalVar sentPlayer) {
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
                        easyProgressbar.setValue(100-(timecount*4));
                        if (timecount==25) {
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
                if (gameCount == 4) {
                    timestatus = false ;
                    ResultUI gameresult = new ResultUI(status,timecount,"Easy") ;
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

        jPanel2 = new javax.swing.JPanel();
        btn_result = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        easyProgressbar = new javax.swing.JProgressBar();
        btn_surrender = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_easy1 = new javax.swing.JButton();
        btn_easy2 = new javax.swing.JButton();
        btn_easy3 = new javax.swing.JButton();
        btn_easy4 = new javax.swing.JButton();
        btn_easy5 = new javax.swing.JButton();
        btn_easy6 = new javax.swing.JButton();
        btn_easy7 = new javax.swing.JButton();
        btn_easy8 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        btn_result.setText("Result");
        btn_result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resultActionPerformed(evt);
            }
        });

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

        jPanel3.setBackground(new java.awt.Color(181, 212, 238));

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

        btn_easy7.setText("7");
        btn_easy7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy7ActionPerformed(evt);
            }
        });

        btn_easy8.setText("8");
        btn_easy8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_easy8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_easy1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_easy5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_easy8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_easy1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_easy5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_easy8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(easyProgressbar, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_surrender, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_surrender, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(easyProgressbar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(148, 148, 148)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btn_resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_resultActionPerformed

    private void btn_surrenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_surrenderActionPerformed
        // Go to Game Over
        timestatus = false ;
        GameoverUI gameover = new GameoverUI(status) ;
        gameover.setVisible(true) ;
        dispose() ;
    }//GEN-LAST:event_btn_surrenderActionPerformed

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
            java.util.logging.Logger.getLogger(EasyMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EasyMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EasyMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EasyMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EasyMode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_easy1;
    private javax.swing.JButton btn_easy2;
    private javax.swing.JButton btn_easy3;
    private javax.swing.JButton btn_easy4;
    private javax.swing.JButton btn_easy5;
    private javax.swing.JButton btn_easy6;
    private javax.swing.JButton btn_easy7;
    private javax.swing.JButton btn_easy8;
    private javax.swing.JButton btn_result;
    private javax.swing.JButton btn_surrender;
    private javax.swing.JProgressBar easyProgressbar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
