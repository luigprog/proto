package app;

import java.awt.image.BufferedImage;

public class MessagePopup extends javax.swing.JFrame {

    public static int ERRO_CODIGO = 0;
    public static int CHEAT = 1;
    
    private int type;
    private String title;
    private String message;
    
    public MessagePopup(String title, String message, int type) {
        this.title = title;
        this.message = message;
        this.type = type;
        
        initComponents();
        this.setLocationRelativeTo(null);
        
        if(this.type == ERRO_CODIGO){
        
            setTitle("Erro no código");
            
        } else if (this.type == CHEAT){
            
            setTitle("CHEAT");
        }
        
        this.labelTitulo.setText(title);
        this.labelMensagem.setText(message);
        
        BufferedImage image = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);  
        setIconImage(image); 
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        labelMensagem = new javax.swing.JTextArea();
        buttonOk = new javax.swing.JButton();
        label_icone = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Titulo");
        setAlwaysOnTop(true);
        setFocusTraversalPolicyProvider(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(32, 30, 30));

        labelTitulo.setBackground(new java.awt.Color(32, 30, 30));
        labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setText("Título");
        labelTitulo.setOpaque(true);

        labelMensagem.setEditable(false);
        labelMensagem.setColumns(20);
        labelMensagem.setLineWrap(true);
        labelMensagem.setRows(5);
        labelMensagem.setWrapStyleWord(true);
        jScrollPane1.setViewportView(labelMensagem);

        buttonOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonOk_Popup.png"))); // NOI18N
        buttonOk.setContentAreaFilled(false);
        buttonOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonOkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonOkMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonOkMousePressed(evt);
            }
        });
        buttonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOkActionPerformed(evt);
            }
        });

        label_icone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/1380971077_error.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_icone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_icone)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOkActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonOkActionPerformed

    private void buttonOkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonOkMouseEntered
         buttonOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonOkHover_Popup.png"))); // NOI18N
    }//GEN-LAST:event_buttonOkMouseEntered

    private void buttonOkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonOkMouseExited
         buttonOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonOk_Popup.png"))); // NOI18N
    }//GEN-LAST:event_buttonOkMouseExited

    private void buttonOkMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonOkMousePressed
         buttonOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonOkPressed_Popup.png"))); // NOI18N
    }//GEN-LAST:event_buttonOkMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonOk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea labelMensagem;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel label_icone;
    // End of variables declaration//GEN-END:variables
}
