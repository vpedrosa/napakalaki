/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.CultistPlayer;
import NapakalakiGame.Napakalaki;
import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author valentin
 */
public class PlayerView extends javax.swing.JPanel {

    private Player playerModel;
    private Napakalaki napakalakiModel;
    
    public void setPlayer(Player p)
    {
        this.playerModel = p;
        
        nameLabel.setText(playerModel.getName());
        levelLabel.setText(Integer.toString(playerModel.getLevels()));
        combatLevelLabel.setText(Integer.toString(playerModel.getCombatLevel()));
        enemyLabel.setText("Enemigo: "+playerModel.getEnemy());
        
        pendingBadConsequenceLabel.setPendingBadConsequenceView(playerModel.getPendingBadConsequence());
        
        if (playerModel.canISteal()) {
            canIStealLabel.setText("Puedes robarle a " + playerModel.getEnemy());
        } else {
            canIStealLabel.setText("No puedes robar nada");
        }
        
        if (playerModel instanceof CultistPlayer) {
           isCultistLabel.setText("Jugador cultist"); 
        } else {
           isCultistLabel.setText("Jugador normal");
        }
        
        totalCultistLabel.setText(String.valueOf(CultistPlayer.getTotalCultistPlayers()));
        
        this.fillTreasurePanel(visibleTreasuresPanel,playerModel.getVisibleTreasures());
        this.fillTreasurePanel(hiddenTreasuresPanel,playerModel.getHiddenTreasures());
        
        discardBtn.setEnabled(true);
        discardAllBtn.setEnabled(true);
        makeVisibleBtn.setEnabled(true);
        
        if (playerModel.getHiddenTreasures().isEmpty())
        {
            makeVisibleBtn.setEnabled(false);
            if (playerModel.getVisibleTreasures().isEmpty()) {
                discardBtn.setEnabled(false);
                discardAllBtn.setEnabled(false);
            }
        }
        
        repaint();
        revalidate();
    }
    
    private void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) 
    {
        aPanel.removeAll();
        
        for (Treasure t : aList) {
           TreasureView aTreasureView = new TreasureView();
           aTreasureView.setTreasure (t);
           aTreasureView.setVisible (true);
           aPanel.add (aTreasureView);
        }
        
        aPanel.repaint();
        aPanel.revalidate();
    }
    
    /*
    Setter for napakalakiModel
    */
    public void setNapakalakiModel(Napakalaki n)
    {
        napakalakiModel = n;
    }
    
    /*
    * Returns an ArrayList with the selected treasures
    */
    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel)
    {
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        
        for (Component c : aPanel.getComponents())
        {
           tv = (TreasureView) c;
           if (tv.isSelected())
              output.add (tv.getTreasure());
        }
        
        return output;
    }
    public void ChangeStealButton (boolean value)
    {
        if (value)
        {
            if (playerModel.canISteal())
                stealTreasureBtn.setEnabled(true);
        }
        else
            stealTreasureBtn.setEnabled(false);
    }
    
    public void ChangeMakeVisibleButton (boolean value)
    {
        if (value) {
            if (playerModel.getHiddenTreasures().size() > 0)
                makeVisibleBtn.setEnabled(true);
        }
        else
            makeVisibleBtn.setEnabled(false);
    }
    
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        levelLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        combatLevelLabel = new javax.swing.JLabel();
        visibleTreasuresPanel = new javax.swing.JPanel();
        hiddenTreasuresPanel = new javax.swing.JPanel();
        discardBtn = new javax.swing.JButton();
        stealTreasureBtn = new javax.swing.JButton();
        makeVisibleBtn = new javax.swing.JButton();
        discardAllBtn = new javax.swing.JButton();
        isCultistLabel = new javax.swing.JLabel();
        canIStealLabel = new javax.swing.JLabel();
        totalCultistLabel = new javax.swing.JLabel();
        enemyLabel = new javax.swing.JLabel();
        pendingBadConsequenceLabel = new GUI.PendingBadConsequenceView();

        nameLabel.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        nameLabel.setText("Nombre");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(116, 0, 6));
        jLabel2.setText("NIVEL");

        levelLabel.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        levelLabel.setForeground(new java.awt.Color(116, 0, 6));
        levelLabel.setText("0");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(213, 1, 1));
        jLabel3.setText("NIVEL DE COMBATE");

        combatLevelLabel.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        combatLevelLabel.setForeground(new java.awt.Color(213, 1, 1));
        combatLevelLabel.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(levelLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(combatLevelLabel)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(levelLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combatLevelLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        visibleTreasuresPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tesoros visibles", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        hiddenTreasuresPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tesoros ocultos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        discardBtn.setText("Descartar tesoro");
        discardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardBtnActionPerformed(evt);
            }
        });

        stealTreasureBtn.setText("Robar tesoro");
        stealTreasureBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stealTreasureBtnActionPerformed(evt);
            }
        });

        makeVisibleBtn.setText("Hacer visible");
        makeVisibleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleBtnActionPerformed(evt);
            }
        });

        discardAllBtn.setText("Descartar todos");
        discardAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardAllBtnActionPerformed(evt);
            }
        });

        isCultistLabel.setText("Es Cultist?");

        canIStealLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        canIStealLabel.setText("Puedo Robar?");

        totalCultistLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        totalCultistLabel.setForeground(new java.awt.Color(33, 222, 255));
        totalCultistLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalCultistLabel.setText("C.players tot");

        enemyLabel.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        enemyLabel.setForeground(new java.awt.Color(255, 0, 0));
        enemyLabel.setText("Enemigo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(nameLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(isCultistLabel)
                            .addComponent(totalCultistLabel)
                            .addComponent(enemyLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(discardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stealTreasureBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(discardAllBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(makeVisibleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(canIStealLabel))
                                    .addComponent(pendingBadConsequenceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hiddenTreasuresPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(visibleTreasuresPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(visibleTreasuresPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hiddenTreasuresPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(isCultistLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalCultistLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(enemyLabel)))
                        .addGap(26, 26, 26)
                        .addComponent(canIStealLabel)
                        .addGap(18, 18, 18)
                        .addComponent(pendingBadConsequenceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stealTreasureBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(makeVisibleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(discardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(discardAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void stealTreasureBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stealTreasureBtnActionPerformed
        Treasure stolen = playerModel.stealTreasure();
        
        MessageDialog msg = new MessageDialog(null, false);
        if (stolen == null)
        {
            msg.setMessageDialog("No hay tesoros que robar.", "Error");
        }
        else
        {
            setPlayer(napakalakiModel.getCurrentPlayer());
            stealTreasureBtn.setEnabled(false);
            msg.setMessageDialog("Has robado: " + stolen.getName(), "Tesoro robado");
            makeVisibleBtn.setEnabled(true);
        }
        
        msg.setVisible(true);
    }//GEN-LAST:event_stealTreasureBtnActionPerformed

    private void discardAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardAllBtnActionPerformed
        playerModel.discardAllTreasures();
        setPlayer(napakalakiModel.getCurrentPlayer());
        
        discardAllBtn.setEnabled(false);
        discardBtn.setEnabled(false);
        makeVisibleBtn.setEnabled(false);
    }//GEN-LAST:event_discardAllBtnActionPerformed

    private void makeVisibleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleBtnActionPerformed
        ArrayList selHidden = getSelectedTreasures(hiddenTreasuresPanel);
        napakalakiModel.makeTreasuresVisible(selHidden);
        setPlayer(napakalakiModel.getCurrentPlayer());
        
        if (playerModel.getHiddenTreasures().isEmpty())
            makeVisibleBtn.setEnabled(false);
        
    }//GEN-LAST:event_makeVisibleBtnActionPerformed

    private void discardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardBtnActionPerformed
        ArrayList selectedHidden = getSelectedTreasures(hiddenTreasuresPanel);
        ArrayList selectedVisible = getSelectedTreasures(visibleTreasuresPanel);
        
        for (Object aTreasure : selectedHidden)
            playerModel.discardHiddenTreasure((Treasure) aTreasure);
        for (Object aTreasure : selectedVisible)
            playerModel.discardVisibleTreasure((Treasure) aTreasure);
        
        setPlayer(napakalakiModel.getCurrentPlayer());
        
        if ((playerModel.getHiddenTreasures().isEmpty()) &&
                playerModel.getVisibleTreasures().isEmpty())
        {
            discardBtn.setEnabled(false);
            discardAllBtn.setEnabled(false);
        }
    }//GEN-LAST:event_discardBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel canIStealLabel;
    private javax.swing.JLabel combatLevelLabel;
    private javax.swing.JButton discardAllBtn;
    private javax.swing.JButton discardBtn;
    private javax.swing.JLabel enemyLabel;
    private javax.swing.JPanel hiddenTreasuresPanel;
    private javax.swing.JLabel isCultistLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JButton makeVisibleBtn;
    private javax.swing.JLabel nameLabel;
    private GUI.PendingBadConsequenceView pendingBadConsequenceLabel;
    private javax.swing.JButton stealTreasureBtn;
    private javax.swing.JLabel totalCultistLabel;
    private javax.swing.JPanel visibleTreasuresPanel;
    // End of variables declaration//GEN-END:variables
}
