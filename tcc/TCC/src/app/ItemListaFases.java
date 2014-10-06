package app;

import javax.swing.JFrame;

public class ItemListaFases extends javax.swing.JPanel {

    private int id;
    private boolean enabled;
    private String pontos;
    private App app;
    
    public ItemListaFases(int id, boolean enabled, String pontos, App app) {
        initComponents();
        
        this.id = id;
        this.enabled = enabled;
        this.pontos = pontos;
        this.app = app;
        // config
        this.labelId.setText(id + "");
        this.labelPontos.setText(pontos);
        if(this.enabled){
            buttonFase.setEnabled(true);
            buttonFase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/cadeadoAberto.png")));
        }
        else {
            buttonFase.setEnabled(false);
            buttonFase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/cadeadoFechado.png")));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonFase = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        labelPontos = new javax.swing.JLabel();
        labelId = new javax.swing.JLabel();

        setBackground(new java.awt.Color(32, 30, 30));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        buttonFase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/cadeadoAberto.png"))); // NOI18N
        buttonFase.setContentAreaFilled(false);
        buttonFase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonFase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFaseActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pontuação: ");

        labelPontos.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        labelPontos.setForeground(new java.awt.Color(255, 255, 0));
        labelPontos.setText("xxx");

        labelId.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        labelId.setForeground(new java.awt.Color(255, 255, 255));
        labelId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelId.setText("xx");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(labelId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(buttonFase, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(buttonFase, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelId, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelPontos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonFaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFaseActionPerformed
        app.faseSelecionada(id);
    }//GEN-LAST:event_buttonFaseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFase;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelPontos;
    // End of variables declaration//GEN-END:variables
}
