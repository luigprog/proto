package app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import util.Universal;

public class VariableCreator extends javax.swing.JFrame {

    private App parent;
    private JPanel panelCurrent;

    public VariableCreator(App parent) {
        this.parent = parent;

        initComponents();
        init2();

        panelCurrent = panelInt;
        showPanel(panelBoolean);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        labelMensagem = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cboxTipo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        panelBase = new javax.swing.JPanel();
        panelBoolean = new javax.swing.JPanel();
        cboxValue_boolean = new javax.swing.JComboBox();
        panelString = new javax.swing.JPanel();
        textValue_string = new javax.swing.JTextField();
        panelInt = new javax.swing.JPanel();
        textValue_int = new javax.swing.JTextField();
        buttonAdicionar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criação de Variável");
        setBackground(new java.awt.Color(32, 30, 30));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelMensagem.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        labelMensagem.setForeground(new java.awt.Color(255, 0, 0));
        labelMensagem.setText("xxxxxxx");
        getContentPane().add(labelMensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 69, -1));

        cboxTipo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cboxTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "boolean", "int", "String" }));
        cboxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxTipoActionPerformed(evt);
            }
        });
        getContentPane().add(cboxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 140, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        textNome.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        getContentPane().add(textNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 140, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Valor Inicial:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        panelBase.setBackground(new java.awt.Color(32, 30, 30));
        panelBase.setLayout(new java.awt.CardLayout());

        panelBoolean.setBackground(new java.awt.Color(32, 30, 30));

        cboxValue_boolean.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cboxValue_boolean.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "true", "false" }));

        javax.swing.GroupLayout panelBooleanLayout = new javax.swing.GroupLayout(panelBoolean);
        panelBoolean.setLayout(panelBooleanLayout);
        panelBooleanLayout.setHorizontalGroup(
            panelBooleanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cboxValue_boolean, 0, 140, Short.MAX_VALUE)
        );
        panelBooleanLayout.setVerticalGroup(
            panelBooleanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBooleanLayout.createSequentialGroup()
                .addComponent(cboxValue_boolean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        panelBase.add(panelBoolean, "card3");

        panelString.setBackground(new java.awt.Color(32, 30, 30));

        textValue_string.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        javax.swing.GroupLayout panelStringLayout = new javax.swing.GroupLayout(panelString);
        panelString.setLayout(panelStringLayout);
        panelStringLayout.setHorizontalGroup(
            panelStringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textValue_string, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        panelStringLayout.setVerticalGroup(
            panelStringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStringLayout.createSequentialGroup()
                .addComponent(textValue_string, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        panelBase.add(panelString, "card4");

        panelInt.setBackground(new java.awt.Color(32, 30, 30));

        textValue_int.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        javax.swing.GroupLayout panelIntLayout = new javax.swing.GroupLayout(panelInt);
        panelInt.setLayout(panelIntLayout);
        panelIntLayout.setHorizontalGroup(
            panelIntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textValue_int, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        panelIntLayout.setVerticalGroup(
            panelIntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIntLayout.createSequentialGroup()
                .addComponent(textValue_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        panelBase.add(panelInt, "card2");

        getContentPane().add(panelBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 140, 40));

        buttonAdicionar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        buttonAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/addIcon.png"))); // NOI18N
        buttonAdicionar.setText("Adicionar");
        buttonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        buttonCancelar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        buttonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/cancelIcon.png"))); // NOI18N
        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/bg_Solid.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxTipoActionPerformed
        if (cboxTipo.getSelectedItem().toString().equals("int")) {
            showPanel(panelInt);
        } else if (cboxTipo.getSelectedItem().toString().equals("boolean")) {
            showPanel(panelBoolean);
        } else if (cboxTipo.getSelectedItem().toString().equals("String")) {
            showPanel(panelString);
        }
    }//GEN-LAST:event_cboxTipoActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarActionPerformed
        boolean canAdd = true;

        if (textNome.getText().equals("")) {
            canAdd = false;
        }
        if (cboxTipo.getSelectedItem().toString().equals("int")) {
            if (textValue_int.getText().equals("")) {
                canAdd = false;
            }
        }  
        if (cboxTipo.getSelectedItem().toString().equals("String")) {
            if (textValue_string.getText().equals("")) {
                canAdd = false;
            }
        }



        if (canAdd) {
            String nome = textNome.getText();
            String tipo = cboxTipo.getSelectedItem().toString();
            String valor = "";
            if (tipo.equals("int")) {
                valor = textValue_int.getText();
            } else if (tipo.equals("boolean")) {
                valor = cboxValue_boolean.getSelectedItem().toString();
            } else if (tipo.equals("String")) {
                valor = textValue_string.getText();
            }

            parent.addVariavel(new VariavelTableNode(tipo, nome, valor));

            this.dispose();
        } else {
            labelMensagem.setText("*Preencha todos os campos.");
        }
    }//GEN-LAST:event_buttonAdicionarActionPerformed

    private void init2() {
        setLocationRelativeTo(null);

        this.textValue_int.setDocument(new IntegerDocument());
        
        labelMensagem.setText("");
    }

    //================================================================================================ Controle de painéis
    /*
     * O tratamento dos panéis se dá por três controles.
     * Primeiro receber o painel a mostrar, sumir com o atual, e dizer que o novo atual é o a ser mostrado.
     * Além disso, configurar o painel a ser mostrado antes de mostrar. 
     * configEachPanel funciona parecido com um controller.
     */
    private void showPanel(JPanel x) {
        this.panelCurrent.setVisible(false);
        configEachPanel(x); // intermediário, configura o painel á ser mostrado
        this.panelCurrent = x;
        x.setVisible(true); // torna visível o painel recebido como argumento
    }

    private void configEachPanel(JPanel x) {
        //if (x == panelMenuPrincipal) {
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JComboBox cboxTipo;
    private javax.swing.JComboBox cboxValue_boolean;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelMensagem;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelBoolean;
    private javax.swing.JPanel panelInt;
    private javax.swing.JPanel panelString;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textValue_int;
    private javax.swing.JTextField textValue_string;
    // End of variables declaration//GEN-END:variables
}
