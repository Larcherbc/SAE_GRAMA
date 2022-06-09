/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sae;

import java.awt.CardLayout;
import java.awt.Dimension;

/**
 *
 * @author Jules Rabec
 */
public class EcranPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form EcranPrincipale
     */
    public EcranPrincipal() {
        initComponents();
        graph.chargeGraph();
        this.add(graph);
        initComboBox();
        graph.setSelectedData(null);
        
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidePanel = new javax.swing.JPanel();
        cardPanel = new javax.swing.JPanel();
        panelAccueil = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabelGraph = new javax.swing.JLabel();
        panel0Distance = new javax.swing.JPanel();
        title0Distance = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jTextAreaInfo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaData = new javax.swing.JTextArea();
        panel1Distance = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        panel2Distance = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelMoreDistance = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cardButtonPanel = new javax.swing.JPanel();
        buttonAccueil = new javax.swing.JButton();
        button0Distance = new javax.swing.JButton();
        button1Distance = new javax.swing.JButton();
        button2Distance = new javax.swing.JButton();
        buttontall = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SAE GRAMA");
        setMinimumSize(new java.awt.Dimension(1200, 600));
        setPreferredSize(new java.awt.Dimension(1200, 600));
        setSize(new java.awt.Dimension(0, 0));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        sidePanel.setMinimumSize(new java.awt.Dimension(300, 100));
        sidePanel.setLayout(new java.awt.BorderLayout());

        cardPanel.setMinimumSize(new java.awt.Dimension(200, 100));
        cardPanel.setPreferredSize(new java.awt.Dimension(200, 265));
        cardPanel.setLayout(new java.awt.CardLayout());

        panelAccueil.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Noeuds :");
        jPanel5.add(jLabel2);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Rouge = Ville");
        jPanel5.add(jLabel6);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Bleu = Restaurent");
        jPanel5.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Vert = Loisir");
        jPanel5.add(jLabel8);
        jPanel5.add(jSeparator1);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Liens : ");
        jPanel5.add(jLabel9);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("Rose = Autoroute");
        jPanel5.add(jLabel11);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("Magenta = Nationale");
        jPanel5.add(jLabel12);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Noir = Departemental");
        jPanel5.add(jLabel10);
        jPanel5.add(jSeparator2);

        jButton1.setText("reload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);

        jLabelGraph.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelGraph.setText("erreur");
        jPanel5.add(jLabelGraph);

        panelAccueil.add(jPanel5);

        cardPanel.add(panelAccueil, "panelAccueil");

        panel0Distance.setLayout(new java.awt.BorderLayout());

        title0Distance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title0Distance.setText("0-Distance");
        title0Distance.setToolTipText("");
        title0Distance.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panel0Distance.add(title0Distance, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel1.setText("afficher sur le graphe :");
        jPanel2.add(jLabel1);

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Ville");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox1);

        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Restaurent");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox2);

        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Loisir");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox3);

        jCheckBox4.setSelected(true);
        jCheckBox4.setText("Autoroute");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox4);

        jCheckBox5.setSelected(true);
        jCheckBox5.setText("National");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox5);

        jCheckBox6.setSelected(true);
        jCheckBox6.setText("Départementale");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox6);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.PAGE_AXIS));

        jTextAreaInfo.setColumns(20);
        jTextAreaInfo.setRows(5);
        jTextAreaInfo.setText("info");
        jTextAreaInfo.setMaximumSize(new java.awt.Dimension(2147483647, 300));
        jTextAreaInfo.setPreferredSize(new java.awt.Dimension(224, 160));
        jPanel3.add(jTextAreaInfo);

        jTextAreaData.setColumns(20);
        jTextAreaData.setRows(5);
        jTextAreaData.setText("data\n");
        jScrollPane2.setViewportView(jTextAreaData);

        jPanel3.add(jScrollPane2);

        jPanel1.add(jPanel3);

        panel0Distance.add(jPanel1, java.awt.BorderLayout.CENTER);

        cardPanel.add(panel0Distance, "panel0Distance");

        panel1Distance.setLayout(new javax.swing.BoxLayout(panel1Distance, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("1-Distance");
        panel1Distance.add(jLabel3);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.setSelectedItem(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 215, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        panel1Distance.add(jPanel4);

        cardPanel.add(panel1Distance, "panel1Distance");

        jLabel4.setText("2-Distance");

        javax.swing.GroupLayout panel2DistanceLayout = new javax.swing.GroupLayout(panel2Distance);
        panel2Distance.setLayout(panel2DistanceLayout);
        panel2DistanceLayout.setHorizontalGroup(
            panel2DistanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2DistanceLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2DistanceLayout.setVerticalGroup(
            panel2DistanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2DistanceLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel4)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        cardPanel.add(panel2Distance, "panel2Distance");

        jLabel5.setText(">=2-Distance");

        javax.swing.GroupLayout panelMoreDistanceLayout = new javax.swing.GroupLayout(panelMoreDistance);
        panelMoreDistance.setLayout(panelMoreDistanceLayout);
        panelMoreDistanceLayout.setHorizontalGroup(
            panelMoreDistanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMoreDistanceLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMoreDistanceLayout.setVerticalGroup(
            panelMoreDistanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMoreDistanceLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel5)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        cardPanel.add(panelMoreDistance, "panelMoreDistance");

        sidePanel.add(cardPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(sidePanel, java.awt.BorderLayout.LINE_START);

        buttonAccueil.setText("accueil");
        buttonAccueil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAccueilActionPerformed(evt);
            }
        });
        cardButtonPanel.add(buttonAccueil);

        button0Distance.setText("0 distance");
        button0Distance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button0DistanceActionPerformed(evt);
            }
        });
        cardButtonPanel.add(button0Distance);

        button1Distance.setText("1 distance");
        button1Distance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1DistanceActionPerformed(evt);
            }
        });
        cardButtonPanel.add(button1Distance);

        button2Distance.setText("2 distance");
        button2Distance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2DistanceActionPerformed(evt);
            }
        });
        cardButtonPanel.add(button2Distance);

        buttontall.setText(">= 2 distance");
        buttontall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttontallActionPerformed(evt);
            }
        });
        cardButtonPanel.add(buttontall);

        getContentPane().add(cardButtonPanel, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        graph.chargeGraph();
        this.repaint();
    }//GEN-LAST:event_formComponentResized

    private void button0DistanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button0DistanceActionPerformed
        CardLayout layout = (CardLayout)cardPanel.getLayout();
        layout.show(cardPanel, "panel0Distance");
        graph.setSelectedData(null);
        this.repaint();
    }//GEN-LAST:event_button0DistanceActionPerformed

    private void button1DistanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1DistanceActionPerformed
        CardLayout layout = (CardLayout)cardPanel.getLayout();
        layout.show(cardPanel, "panel1Distance");
        initComboBox();
    }//GEN-LAST:event_button1DistanceActionPerformed

    private void button2DistanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2DistanceActionPerformed
        CardLayout layout = (CardLayout)cardPanel.getLayout();
        layout.show(cardPanel, "panel2Distance");
    }//GEN-LAST:event_button2DistanceActionPerformed

    private void buttontallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttontallActionPerformed
        CardLayout layout = (CardLayout)cardPanel.getLayout();
        layout.show(cardPanel, "panelMoreDistance");
    }//GEN-LAST:event_buttontallActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        graph.setSelectedData();
        this.repaint();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        graph.setSelectedData();
        this.repaint();
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        graph.setSelectedData();
        this.repaint();
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        graph.setSelectedData();
        this.repaint();
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        graph.setSelectedData();
        this.repaint();
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        graph.setSelectedData();
        this.repaint();
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(jComboBox1.getSelectedItem()!=null){
            graph.setSelectedData((String)jComboBox1.getSelectedItem());
        }
        this.repaint();
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void buttonAccueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAccueilActionPerformed
        CardLayout layout = (CardLayout)cardPanel.getLayout();
        layout.show(cardPanel, "panelAccueil");
        graph.setSelectedData(null);
        this.repaint();
    }//GEN-LAST:event_buttonAccueilActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EcranPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EcranPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EcranPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EcranPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EcranPrincipal().setVisible(true);
            }
        });
        
    }
    
    public void setJLabelGraph(String text){
        jLabelGraph.setText(text);
    }
    
    public int getSelectedData(){
        int selectedData =0;
        if(jCheckBox1.isSelected()){
            selectedData+=1;
        }
        if(jCheckBox2.isSelected()){
            selectedData+=2;
        }
        if(jCheckBox3.isSelected()){
            selectedData+=4;
        }
        if(jCheckBox4.isSelected()){
            selectedData+=8;
        }
        if(jCheckBox5.isSelected()){
            selectedData+=16;
        }
        if(jCheckBox6.isSelected()){
            selectedData+=32;
        }
        return selectedData;
    }
    
    public void setJTextAreaInfo(String text){
        jTextAreaInfo.setText(text);
    }
    public void setJTextAreaData(String text){
        jTextAreaData.setText(text);
    }
    
    private void initComboBox(){
        jComboBox1.removeAllItems();
        Noeuds noeuds = graph.getListeNoeudSelection();
        for(Noeud obj : noeuds){
            jComboBox1.addItem(obj.getNom());
        }
        for(Lien obj : graph.getListeLiensSelection()){
            jComboBox1.addItem("from : "+ obj.getNomA().getNom() + " to : "+obj.getNomD().getNom());
        }
    }
    
    Graph graph = new Graph(this);
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button0Distance;
    private javax.swing.JButton button1Distance;
    private javax.swing.JButton button2Distance;
    private javax.swing.JButton buttonAccueil;
    private javax.swing.JButton buttontall;
    private javax.swing.JPanel cardButtonPanel;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelGraph;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextAreaData;
    private javax.swing.JTextArea jTextAreaInfo;
    private javax.swing.JPanel panel0Distance;
    private javax.swing.JPanel panel1Distance;
    private javax.swing.JPanel panel2Distance;
    private javax.swing.JPanel panelAccueil;
    private javax.swing.JPanel panelMoreDistance;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JLabel title0Distance;
    // End of variables declaration//GEN-END:variables
}
