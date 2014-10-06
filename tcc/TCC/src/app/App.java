package app;

import app.editor.GroovyFilter;
import app.editor.StyleManager;
import bsh.EvalError;
import bsh.Interpreter;
import bsh.ParseException;
import bsh.TargetError;
import data.storage.PlayerStats;
import data.storage.level.FasesDados;
import gamer.InfoCenter;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;
import util.Universal;

public class App extends javax.swing.JFrame {

    //====================================================================================================== Variáveis
    //---------------------------------------------------------------DataStorage
    private PlayerStats playerStats = PlayerStats.getInstance();
    //----------------------------------------------------------------Utilidades
    private JPanel panelCurrent; // variável que armazena o atual painel que está sendo mostrado. Utilizado no controle de painéis.
    private Interpreter bsh = new Interpreter();
    private Timer timer;
    //------------------------------------------------ Variaveis Player Controle
    private ArrayList<VariavelTableNode> variaveis = new ArrayList<VariavelTableNode>();
    //================================================================================================================

    public App() {
        initComponents();
        initComponents2();
        loader();

        panelCurrent = panelMenuPrincipal;
        showPanel(panelMenuPrincipal);
        showPanel(panelSplash);

        timer = new Timer(Universal.splashScreenTime, new ActionListener() {
            public void actionPerformed(@SuppressWarnings("unused") java.awt.event.ActionEvent e) {
                timer.stop();
                showPanel(panelMenuPrincipal);
            }
        });

        timer.start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBase = new javax.swing.JPanel();
        panelMenuPrincipal = new javax.swing.JPanel();
        buttonJogar_MenuPrincipal = new javax.swing.JButton();
        buttonSair_MenuPrincipal = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        labelPoints_MenuPrincipal = new javax.swing.JLabel();
        labelLevel_MenuPrincipal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buttonHistoria_MenuPrincipal = new javax.swing.JButton();
        buttonCreditos_MenuPrincipal = new javax.swing.JButton();
        bg_MenuPrincipal = new javax.swing.JLabel();
        panelMenuFases = new javax.swing.JPanel();
        buttonVoltar_MenuFases = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        scrollPaneListaFases = new javax.swing.JScrollPane();
        panelListaFases = new javax.swing.JPanel();
        labelPoints_MenuFases = new javax.swing.JLabel();
        labelLevel_MenuFases = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bg_MenuFases = new javax.swing.JLabel();
        panelFase = new javax.swing.JPanel();
        scrollPaneCodeEditor = new javax.swing.JScrollPane();
        codeEditor = new javax.swing.JTextPane();
        codeEditor = new JTextPane();
        codeEditor.setFont( new Font("monospaced", Font.PLAIN, 12) );

        codeEditor.getDocument().addDocumentListener(new DocumentListener()
            {
                public void changedUpdate(DocumentEvent e)
                {
                }

                public void insertUpdate(DocumentEvent e)
                {
                    editorSetChanged(true);
                }

                public void removeUpdate(DocumentEvent e)
                {
                    editorSetChanged(true);
                }

            });

            FontMetrics fm = codeEditor.getFontMetrics( codeEditor.getFont() );
            int charWidth = fm.charWidth( 'w' );
            int tabWidth = charWidth * 4;

            TabStop[] tabs = new TabStop[10];

            for (int j = 0; j < tabs.length; j++)
            {
                int tab = j + 1;
                tabs[j] = new TabStop( tab * tabWidth );
            }

            TabSet tabSet = new TabSet(tabs);
            SimpleAttributeSet attributes = new SimpleAttributeSet();
            StyleConstants.setTabSet(attributes, tabSet);
            int length = codeEditor.getDocument().getLength();
            codeEditor.getStyledDocument().setParagraphAttributes(0, length, attributes, true);

            StyledDocument doc = codeEditor.getStyledDocument();

            StyleManager.getInstance().createStyles(doc);

            watchDocument = new GroovyFilter(doc);
            doc.addDocumentListener(watchDocument);
            buttonVoltar_Fase = new javax.swing.JButton();
            buttonMenuPrincipal_Fase = new javax.swing.JButton();
            buttonExecutar_Fase = new javax.swing.JButton();
            buttonAdicionarVariavel_Fase = new javax.swing.JButton();
            jScrollPane1 = new javax.swing.JScrollPane();
            tableVariaveis_Fase = new javax.swing.JTable();
            buttonExcluirVariavel_Fase = new javax.swing.JButton();
            buttonSalvar_Fase = new javax.swing.JButton();
            buttonAbrir_Fase = new javax.swing.JButton();
            jScrollPane2 = new javax.swing.JScrollPane();
            labelText_Fase = new javax.swing.JTextArea();
            jLabel7 = new javax.swing.JLabel();
            imagemGradeFase_Fase = new javax.swing.JLabel();
            panelSplash = new javax.swing.JPanel();
            jLabel6 = new javax.swing.JLabel();
            panelHistoria = new javax.swing.JPanel();
            buttonVoltar_Historia = new javax.swing.JButton();
            jLabel8 = new javax.swing.JLabel();
            jLabel9 = new javax.swing.JLabel();
            panelCreditos = new javax.swing.JPanel();
            buttonVoltar_Creditos = new javax.swing.JButton();
            jLabel11 = new javax.swing.JLabel();
            jLabel10 = new javax.swing.JLabel();
            jSeparator1 = new javax.swing.JSeparator();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("P R O T O - Beta");
            setResizable(false);

            panelBase.setLayout(new java.awt.CardLayout());

            panelMenuPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            panelMenuPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            buttonJogar_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonJogar_MenuPrincipal.png"))); // NOI18N
            buttonJogar_MenuPrincipal.setContentAreaFilled(false);
            buttonJogar_MenuPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttonJogar_MenuPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    buttonJogar_MenuPrincipalMouseReleased(evt);
                }
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    buttonJogar_MenuPrincipalMouseClicked(evt);
                }
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    buttonJogar_MenuPrincipalMouseEntered(evt);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    buttonJogar_MenuPrincipalMouseExited(evt);
                }
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    buttonJogar_MenuPrincipalMousePressed(evt);
                }
            });
            buttonJogar_MenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonJogar_MenuPrincipalActionPerformed(evt);
                }
            });
            panelMenuPrincipal.add(buttonJogar_MenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 240, 70));

            buttonSair_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonSair_MenuPrincipal.png"))); // NOI18N
            buttonSair_MenuPrincipal.setContentAreaFilled(false);
            buttonSair_MenuPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttonSair_MenuPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    buttonSair_MenuPrincipalMouseEntered(evt);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    buttonSair_MenuPrincipalMouseExited(evt);
                }
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    buttonSair_MenuPrincipalMousePressed(evt);
                }
            });
            buttonSair_MenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonSair_MenuPrincipalActionPerformed(evt);
                }
            });
            panelMenuPrincipal.add(buttonSair_MenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 240, 70));

            jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
            jLabel4.setForeground(new java.awt.Color(255, 255, 255));
            jLabel4.setText("PONTOS:");
            panelMenuPrincipal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 530, -1, -1));

            labelPoints_MenuPrincipal.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
            labelPoints_MenuPrincipal.setForeground(new java.awt.Color(255, 255, 255));
            labelPoints_MenuPrincipal.setText("xxx");
            panelMenuPrincipal.add(labelPoints_MenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 530, 90, -1));

            labelLevel_MenuPrincipal.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
            labelLevel_MenuPrincipal.setForeground(new java.awt.Color(255, 255, 255));
            labelLevel_MenuPrincipal.setText("xxx");
            panelMenuPrincipal.add(labelLevel_MenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 550, 110, -1));

            jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
            jLabel5.setForeground(new java.awt.Color(255, 255, 255));
            jLabel5.setText("NÍVEL:");
            panelMenuPrincipal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 550, -1, -1));

            buttonHistoria_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonHistoria_MenuPrincipal.png"))); // NOI18N
            buttonHistoria_MenuPrincipal.setContentAreaFilled(false);
            buttonHistoria_MenuPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttonHistoria_MenuPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    buttonHistoria_MenuPrincipalMouseEntered(evt);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    buttonHistoria_MenuPrincipalMouseExited(evt);
                }
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    buttonHistoria_MenuPrincipalMousePressed(evt);
                }
            });
            buttonHistoria_MenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonHistoria_MenuPrincipalActionPerformed(evt);
                }
            });
            panelMenuPrincipal.add(buttonHistoria_MenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 240, 70));

            buttonCreditos_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonCreditos_MenuPrincipal.png"))); // NOI18N
            buttonCreditos_MenuPrincipal.setContentAreaFilled(false);
            buttonCreditos_MenuPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttonCreditos_MenuPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    buttonCreditos_MenuPrincipalMouseEntered(evt);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    buttonCreditos_MenuPrincipalMouseExited(evt);
                }
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    buttonCreditos_MenuPrincipalMousePressed(evt);
                }
            });
            buttonCreditos_MenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonCreditos_MenuPrincipalActionPerformed(evt);
                }
            });
            panelMenuPrincipal.add(buttonCreditos_MenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 240, 70));

            bg_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/bg_MenuPrincipal.png"))); // NOI18N
            panelMenuPrincipal.add(bg_MenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 610));

            panelBase.add(panelMenuPrincipal, "card2");

            panelMenuFases.setBackground(new java.awt.Color(32, 30, 30));
            panelMenuFases.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            panelMenuFases.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            buttonVoltar_MenuFases.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonVoltarGrandeNormal.png"))); // NOI18N
            buttonVoltar_MenuFases.setContentAreaFilled(false);
            buttonVoltar_MenuFases.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttonVoltar_MenuFases.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    buttonVoltar_MenuFasesMouseEntered(evt);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    buttonVoltar_MenuFasesMouseExited(evt);
                }
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    buttonVoltar_MenuFasesMousePressed(evt);
                }
            });
            buttonVoltar_MenuFases.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonVoltar_MenuFasesActionPerformed(evt);
                }
            });
            panelMenuFases.add(buttonVoltar_MenuFases, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 90, 90));

            jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(255, 255, 255));
            jLabel2.setText("PONTOS:");
            panelMenuFases.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 500, -1, -1));

            jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(255, 255, 255));
            jLabel3.setText("NÍVEL:");
            panelMenuFases.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 530, -1, -1));

            panelListaFases.setBackground(new java.awt.Color(32, 30, 30));
            panelListaFases.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

            javax.swing.GroupLayout panelListaFasesLayout = new javax.swing.GroupLayout(panelListaFases);
            panelListaFases.setLayout(panelListaFasesLayout);
            panelListaFasesLayout.setHorizontalGroup(
                panelListaFasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 911, Short.MAX_VALUE)
            );
            panelListaFasesLayout.setVerticalGroup(
                panelListaFasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 484, Short.MAX_VALUE)
            );

            scrollPaneListaFases.setViewportView(panelListaFases);

            panelMenuFases.add(scrollPaneListaFases, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 820, 410));

            labelPoints_MenuFases.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
            labelPoints_MenuFases.setForeground(new java.awt.Color(255, 255, 255));
            labelPoints_MenuFases.setText("xxxx");
            panelMenuFases.add(labelPoints_MenuFases, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 500, 180, -1));

            labelLevel_MenuFases.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
            labelLevel_MenuFases.setForeground(new java.awt.Color(255, 255, 255));
            labelLevel_MenuFases.setText("xxxxx");
            panelMenuFases.add(labelLevel_MenuFases, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 530, 190, -1));

            jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(255, 255, 255));
            jLabel1.setText("SELECIONE UMA FASE:");
            panelMenuFases.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

            bg_MenuFases.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/bg_MenuFases.png"))); // NOI18N
            bg_MenuFases.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            panelMenuFases.add(bg_MenuFases, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 600));

            panelBase.add(panelMenuFases, "card3");

            panelFase.setBackground(new java.awt.Color(32, 30, 30));

            codeEditor.setText("// Seu código aqui");
            scrollPaneCodeEditor.setViewportView(codeEditor);

            buttonVoltar_Fase.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
            buttonVoltar_Fase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/1382782594_back.png"))); // NOI18N
            buttonVoltar_Fase.setText("Voltar");
            buttonVoltar_Fase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttonVoltar_Fase.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonVoltar_FaseActionPerformed(evt);
                }
            });

            buttonMenuPrincipal_Fase.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
            buttonMenuPrincipal_Fase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/1382782528_519941-001_Home.png"))); // NOI18N
            buttonMenuPrincipal_Fase.setText("Menu Principal");
            buttonMenuPrincipal_Fase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttonMenuPrincipal_Fase.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonMenuPrincipal_FaseActionPerformed(evt);
                }
            });

            buttonExecutar_Fase.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
            buttonExecutar_Fase.setForeground(new java.awt.Color(0, 153, 255));
            buttonExecutar_Fase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/1382782844_Play1Normal.png"))); // NOI18N
            buttonExecutar_Fase.setText("Play");
            buttonExecutar_Fase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttonExecutar_Fase.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonExecutar_FaseActionPerformed(evt);
                }
            });

            buttonAdicionarVariavel_Fase.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
            buttonAdicionarVariavel_Fase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/1382782506_add1-.png"))); // NOI18N
            buttonAdicionarVariavel_Fase.setText("Adicionar");
            buttonAdicionarVariavel_Fase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttonAdicionarVariavel_Fase.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonAdicionarVariavel_FaseActionPerformed(evt);
                }
            });

            tableVariaveis_Fase.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
            tableVariaveis_Fase.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Tipo", "Nome", "Valor inicial"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            jScrollPane1.setViewportView(tableVariaveis_Fase);
            tableVariaveis_Fase.getColumnModel().getColumn(0).setResizable(false);

            buttonExcluirVariavel_Fase.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
            buttonExcluirVariavel_Fase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/1382782513_DeleteRed.png"))); // NOI18N
            buttonExcluirVariavel_Fase.setText("Excluir");
            buttonExcluirVariavel_Fase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttonExcluirVariavel_Fase.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonExcluirVariavel_FaseActionPerformed(evt);
                }
            });

            buttonSalvar_Fase.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
            buttonSalvar_Fase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/1382782657_floppy_disk_save.png"))); // NOI18N
            buttonSalvar_Fase.setText("Salvar Código");
            buttonSalvar_Fase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttonSalvar_Fase.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonSalvar_FaseActionPerformed(evt);
                }
            });

            buttonAbrir_Fase.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
            buttonAbrir_Fase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/1382782789_open-file.png"))); // NOI18N
            buttonAbrir_Fase.setText("Abrir Código...");
            buttonAbrir_Fase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttonAbrir_Fase.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonAbrir_FaseActionPerformed(evt);
                }
            });

            labelText_Fase.setEditable(false);
            labelText_Fase.setBackground(new java.awt.Color(32, 30, 30));
            labelText_Fase.setColumns(20);
            labelText_Fase.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
            labelText_Fase.setForeground(new java.awt.Color(255, 255, 255));
            labelText_Fase.setLineWrap(true);
            labelText_Fase.setRows(5);
            labelText_Fase.setWrapStyleWord(true);
            labelText_Fase.setBorder(null);
            jScrollPane2.setViewportView(labelText_Fase);

            jLabel7.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
            jLabel7.setForeground(new java.awt.Color(0, 51, 102));
            jLabel7.setText("Variáveis:");

            imagemGradeFase_Fase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/storage/level/fase1.png"))); // NOI18N

            javax.swing.GroupLayout panelFaseLayout = new javax.swing.GroupLayout(panelFase);
            panelFase.setLayout(panelFaseLayout);
            panelFaseLayout.setHorizontalGroup(
                panelFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelFaseLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFaseLayout.createSequentialGroup()
                            .addGroup(panelFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelFaseLayout.createSequentialGroup()
                                    .addComponent(buttonExecutar_Fase, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(buttonAbrir_Fase)
                                    .addGap(18, 18, 18)
                                    .addComponent(buttonSalvar_Fase))
                                .addComponent(scrollPaneCodeEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panelFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(panelFaseLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFaseLayout.createSequentialGroup()
                                    .addComponent(buttonVoltar_Fase)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonMenuPrincipal_Fase))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFaseLayout.createSequentialGroup()
                                    .addComponent(buttonAdicionarVariavel_Fase)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonExcluirVariavel_Fase))))
                        .addGroup(panelFaseLayout.createSequentialGroup()
                            .addComponent(imagemGradeFase_Fase)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            panelFaseLayout.setVerticalGroup(
                panelFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFaseLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(imagemGradeFase_Fase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                    .addGroup(panelFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFaseLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonExcluirVariavel_Fase)
                                .addGap(81, 81, 81))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFaseLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(buttonAdicionarVariavel_Fase)
                                .addGap(82, 82, 82)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFaseLayout.createSequentialGroup()
                            .addGroup(panelFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(buttonVoltar_Fase)
                                    .addComponent(buttonMenuPrincipal_Fase))
                                .addGroup(panelFaseLayout.createSequentialGroup()
                                    .addComponent(scrollPaneCodeEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(panelFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelFaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(buttonAbrir_Fase)
                                            .addComponent(buttonSalvar_Fase))
                                        .addComponent(buttonExecutar_Fase, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(16, 16, 16))))
            );

            panelBase.add(panelFase, "card4");

            jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/splashScreen.png"))); // NOI18N

            javax.swing.GroupLayout panelSplashLayout = new javax.swing.GroupLayout(panelSplash);
            panelSplash.setLayout(panelSplashLayout);
            panelSplashLayout.setHorizontalGroup(
                panelSplashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            panelSplashLayout.setVerticalGroup(
                panelSplashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 610, Short.MAX_VALUE)
            );

            panelBase.add(panelSplash, "card5");

            panelHistoria.setBackground(new java.awt.Color(32, 30, 30));

            buttonVoltar_Historia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonVoltarGrandeNormal.png"))); // NOI18N
            buttonVoltar_Historia.setContentAreaFilled(false);
            buttonVoltar_Historia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttonVoltar_Historia.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    buttonVoltar_HistoriaMouseEntered(evt);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    buttonVoltar_HistoriaMouseExited(evt);
                }
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    buttonVoltar_HistoriaMousePressed(evt);
                }
            });
            buttonVoltar_Historia.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonVoltar_HistoriaActionPerformed(evt);
                }
            });

            jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
            jLabel8.setForeground(new java.awt.Color(255, 255, 255));
            jLabel8.setText("<HTML>Em uma era onde pesquisadores buscam tornar os robôs mais inteligentes, mais pensantes, protótipos cibernéticos são criados, estudados e testados. Estes homens “brincam” com o que talvez seja a coisa mais ambiciosa da robótica. Algoritmos altamente complicados, tentam fazer essas máquinas pensarem, e tomarem decisões próprias. Uma falha pode resultar em algo inesperado, incrível, e por outro lado até perigoso. Nisso surge Proto, vítima de uma dessas falhas. O robozinho foi projetado para adquirir conhecimento, baseado em premissas, simulando a inteligência e memória humana. Uma falha em seu código, acabou levando Proto a tentar aprender mais sobre sua própria “espécie”, os robôs. Ele precisa explorar alguns lugares em busca de seus objetivos, e como não foi projetado e nem treinado para isso, ele precisa da ajuda de algum humano, que lhe “ensine” a lidar com essas situações.</HTML>");

            jLabel9.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
            jLabel9.setForeground(new java.awt.Color(255, 255, 255));
            jLabel9.setText("HISTÓRIA");

            javax.swing.GroupLayout panelHistoriaLayout = new javax.swing.GroupLayout(panelHistoria);
            panelHistoria.setLayout(panelHistoriaLayout);
            panelHistoriaLayout.setHorizontalGroup(
                panelHistoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelHistoriaLayout.createSequentialGroup()
                    .addGroup(panelHistoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelHistoriaLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(buttonVoltar_Historia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelHistoriaLayout.createSequentialGroup()
                            .addGap(388, 388, 388)
                            .addComponent(jLabel9))
                        .addGroup(panelHistoriaLayout.createSequentialGroup()
                            .addGap(128, 128, 128)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(127, Short.MAX_VALUE))
            );
            panelHistoriaLayout.setVerticalGroup(
                panelHistoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHistoriaLayout.createSequentialGroup()
                    .addContainerGap(62, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)
                    .addComponent(buttonVoltar_Historia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27))
            );

            panelBase.add(panelHistoria, "card6");

            panelCreditos.setBackground(new java.awt.Color(32, 30, 30));

            buttonVoltar_Creditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonVoltarGrandeNormal.png"))); // NOI18N
            buttonVoltar_Creditos.setContentAreaFilled(false);
            buttonVoltar_Creditos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttonVoltar_Creditos.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    buttonVoltar_CreditosMouseEntered(evt);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    buttonVoltar_CreditosMouseExited(evt);
                }
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    buttonVoltar_CreditosMousePressed(evt);
                }
            });
            buttonVoltar_Creditos.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonVoltar_CreditosActionPerformed(evt);
                }
            });

            jLabel11.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
            jLabel11.setForeground(new java.awt.Color(102, 102, 102));
            jLabel11.setText("CRÉDITOS");

            jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/creditos.png"))); // NOI18N

            javax.swing.GroupLayout panelCreditosLayout = new javax.swing.GroupLayout(panelCreditos);
            panelCreditos.setLayout(panelCreditosLayout);
            panelCreditosLayout.setHorizontalGroup(
                panelCreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCreditosLayout.createSequentialGroup()
                    .addGroup(panelCreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelCreditosLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(buttonVoltar_Creditos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelCreditosLayout.createSequentialGroup()
                            .addGap(115, 115, 115)
                            .addComponent(jLabel10))
                        .addGroup(panelCreditosLayout.createSequentialGroup()
                            .addGap(394, 394, 394)
                            .addComponent(jLabel11))
                        .addGroup(panelCreditosLayout.createSequentialGroup()
                            .addGap(374, 374, 374)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(140, Short.MAX_VALUE))
            );
            panelCreditosLayout.setVerticalGroup(
                panelCreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCreditosLayout.createSequentialGroup()
                    .addContainerGap(47, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28)
                    .addComponent(jLabel10)
                    .addGap(36, 36, 36)
                    .addComponent(buttonVoltar_Creditos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27))
            );

            panelBase.add(panelCreditos, "card6");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            getAccessibleContext().setAccessibleName("P R O T O - Beta");

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void initComponents2() {
        this.setLocationRelativeTo(null);
        
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/app/images/jFrameIcon.png")).getImage());
    }
    //============================================================================================================ Load

    private void loader() {
        loadMenuFases();
    }

    private void loadMenuFases() {
        panelListaFases.removeAll();

        panelListaFases.setLayout(new WrapLayout(FlowLayout.LEFT));

        for (int i = 1; i <= Universal.quantidadeFases; i++) {
            if (playerStats.getProperty("fase" + i + "") == null) {
                panelListaFases.add(new ItemListaFases(i, false, "0", this));

            } else {
                panelListaFases.add(new ItemListaFases(i, true, playerStats.getProperty("fase" + i + ""), this));
            }

        }
    }

    private void refreshPlayerStatsMenuPrincipal() {
        this.labelPoints_MenuPrincipal.setText(playerStats.getProperty("total"));
        this.labelLevel_MenuPrincipal.setText(playerStats.getProperty("level"));
    }

    private void refreshPlayerStatsMenuFases() {
        this.labelPoints_MenuFases.setText(playerStats.getProperty("total"));
        this.labelLevel_MenuFases.setText(playerStats.getProperty("level"));
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
        if (x == panelMenuPrincipal) {
            refreshPlayerStatsMenuPrincipal();
        } else if (x == panelMenuFases) {
            loadMenuFases();
            refreshPlayerStatsMenuFases();
        } else if (x == panelFase) {
            imagemGradeFase_Fase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/storage/level/fase" + Universal.currentFaseId + ".png"))); // NOI18N
            labelText_Fase.setText("Informações: \n" + FasesDados.fase[Universal.currentFaseId].text);
        }
    }
    //================================================================================================== Editor de Código
    // Variaveis apenas usadas pelo editor
    private File codeEditorFile = null;
    private boolean codeEditorChanged = false;
    private GroovyFilter watchDocument;

    protected void editorSetChanged(boolean changed) {

        if (codeEditorFile != null) {
            if (changed == true) {
                this.codeEditorChanged = changed;
            }
        }
    }

    protected boolean editorHasChanged() {
        return codeEditorChanged;
    }

    //======================================================================================================== Variáveis do Jogador
    public void addVariavel(VariavelTableNode node) {
        variaveis.add(node);

        tableVariaveis_Fase_Update();
    }

    private void tableVariaveis_Fase_Update() {
        tableVariaveis_Fase.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
            "Tipo", "Nome", "Valor inicial"
        }) {
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        VariavelTableNode aux;
        for (int i = 0; i < variaveis.size(); i++) {
            aux = variaveis.get(i);
            String[] linha = {aux.tipo, aux.nome, aux.valor};

            ((DefaultTableModel) tableVariaveis_Fase.getModel()).addRow(linha);
        }


    }
    //======================================================================================================== Eventos
    private void buttonJogar_MenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJogar_MenuPrincipalActionPerformed
        showPanel(panelMenuFases);
    }//GEN-LAST:event_buttonJogar_MenuPrincipalActionPerformed

    private void buttonVoltar_MenuFasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltar_MenuFasesActionPerformed
        showPanel(panelMenuPrincipal);
    }//GEN-LAST:event_buttonVoltar_MenuFasesActionPerformed

    private void buttonVoltar_FaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltar_FaseActionPerformed
        showPanel(panelMenuFases);
    }//GEN-LAST:event_buttonVoltar_FaseActionPerformed

    private void buttonMenuPrincipal_FaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenuPrincipal_FaseActionPerformed
        showPanel(panelMenuPrincipal);
    }//GEN-LAST:event_buttonMenuPrincipal_FaseActionPerformed

    private void buttonExecutar_FaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExecutar_FaseActionPerformed
        Universal.currentCode = codeEditor.getText();
        //*****************
        /*
         * Implementação do easter egg de controlar o robô pelo teclado
         */
        if(Universal.currentCode.equals("cTriggerProtoDome")){
            Universal.egg_keyboardControl = !Universal.egg_keyboardControl;
            
            new MessagePopup("Cheat " + (Universal.egg_keyboardControl?"ativado!":"desativado!"),
                    "Controlar Proto pelo teclado.", MessagePopup.CHEAT).setVisible(true);
            
            return;
            
        }
        //*****************
        
        Universal.currentVariables = variaveis;
        // Compilar em busca de erros antes de chamar a tela real do jogo
        String mensagem = "";
        try {
            bsh.eval("import gamer.Proto;");
            bsh.eval("import gamer.Objetivo;");
            bsh.eval("import gamer.Esfera1;");
            bsh.eval("import gamer.Esfera2;");
            bsh.eval("import gamer.Esfera3;");
            bsh.eval("import gamer.EsferaAtual;");
            bsh.set("nada", InfoCenter.map_nada);
            bsh.set("solido", InfoCenter.map_solido);
            bsh.set("escada", InfoCenter.map_escada);
            bsh.set("objetivo", InfoCenter.map_objetivo);
            bsh.set("esfera", InfoCenter.map_esfera);
            bsh.set("solido_escada", InfoCenter.map_solidoEscada);

            VariavelTableNode aux;
            for (int i = 0; i < variaveis.size(); i++) {
                aux = variaveis.get(i);

                if (aux.tipo.equals("int")) {
                    bsh.set(aux.nome, Integer.parseInt(aux.valor));
                } else if (aux.tipo.equals("boolean")) {
                    if (aux.valor.equals("true")) {
                        bsh.set(aux.nome, true);
                    } else {
                        bsh.set(aux.nome, false);
                    }
                } else if (aux.tipo.equals("String")) {
                    bsh.set(aux.nome, aux.valor);
                }
            }

            bsh.eval(Universal.currentCode);

        } catch (TargetError e) {
            Throwable t = e.getTarget();
            mensagem += "Script threw exception: " + t;
        } catch (ParseException e) {
            mensagem += e.getMessage();
        } catch (EvalError e) {
            mensagem += e.getMessage();
        } catch (Exception e) {
            mensagem += e.getMessage();
        }

        //---------------------------------------------------------------
        if (mensagem.equals("")) {
            game.Main.main(null);
        } else {
            new MessagePopup("Seu código possui algum erro. Mensagem do compilador:", mensagem, MessagePopup.ERRO_CODIGO).setVisible(true);
        }
    }//GEN-LAST:event_buttonExecutar_FaseActionPerformed

    private void buttonAdicionarVariavel_FaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarVariavel_FaseActionPerformed
        new VariableCreator(this).setVisible(true);
    }//GEN-LAST:event_buttonAdicionarVariavel_FaseActionPerformed

    private void buttonExcluirVariavel_FaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirVariavel_FaseActionPerformed
        int linhaSelecionada = tableVariaveis_Fase.getSelectedRow();
        if (linhaSelecionada > -1) {
            variaveis.remove(linhaSelecionada);
            tableVariaveis_Fase_Update();
        }
    }//GEN-LAST:event_buttonExcluirVariavel_FaseActionPerformed

    private void buttonSair_MenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSair_MenuPrincipalActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonSair_MenuPrincipalActionPerformed

    private void buttonSalvar_FaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvar_FaseActionPerformed
        try {
            JFileChooser salvandoArquivo = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo de Texto", "txt");
            salvandoArquivo.addChoosableFileFilter(filter);
            salvandoArquivo.setAcceptAllFileFilterUsed(false);
            salvandoArquivo.setFileFilter(filter);
            salvandoArquivo.setMultiSelectionEnabled(false);

            int resultado = salvandoArquivo.showSaveDialog(this);
            if (resultado != JFileChooser.APPROVE_OPTION) {
                return;
            }

            File salvarArquivoEscolhido = salvandoArquivo.getSelectedFile();
            File concatenada = new File(salvarArquivoEscolhido.getPath() + ".txt");

            PrintWriter pw = new PrintWriter(new FileWriter(concatenada));
            pw.println(codeEditor.getText());
            pw.close();

        } catch (Exception e) {
        }
    }//GEN-LAST:event_buttonSalvar_FaseActionPerformed

    private void buttonAbrir_FaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAbrir_FaseActionPerformed
        JFileChooser loadEmp = new JFileChooser();//new dialog
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo de Texto", "txt");
        loadEmp.addChoosableFileFilter(filter);
        loadEmp.setAcceptAllFileFilterUsed(false);
        loadEmp.setFileFilter(filter);
        loadEmp.setMultiSelectionEnabled(false);
        //Abre o file chooser. Ele retorna JFileChooser.APPROVE_OPTION caso o usuário
        //pressione ok.
        if (loadEmp.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            return; //Se não pressionou ok, saímos do método.
        }

        try {
            FileReader fr = new FileReader(loadEmp.getSelectedFile());
            BufferedReader br = new BufferedReader(fr);
            String linha;
            StringBuffer sb = new StringBuffer();
            while ((linha = br.readLine()) != null) {
                sb.append(linha).append("\n");
            }
            fr.close();
            codeEditor.setText("");
            codeEditor.setText(sb.toString());

        } catch (Exception e) {
        }


    }//GEN-LAST:event_buttonAbrir_FaseActionPerformed

    private void buttonJogar_MenuPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonJogar_MenuPrincipalMouseEntered
        buttonJogar_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonJogarHover_MenuPrincipal.png")));
    }//GEN-LAST:event_buttonJogar_MenuPrincipalMouseEntered

    private void buttonJogar_MenuPrincipalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonJogar_MenuPrincipalMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonJogar_MenuPrincipalMouseReleased

    private void buttonJogar_MenuPrincipalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonJogar_MenuPrincipalMouseExited
        buttonJogar_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonJogar_MenuPrincipal.png")));
    }//GEN-LAST:event_buttonJogar_MenuPrincipalMouseExited

    private void buttonSair_MenuPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSair_MenuPrincipalMouseEntered
        buttonSair_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonSairHover_MenuPrincipal.png")));
    }//GEN-LAST:event_buttonSair_MenuPrincipalMouseEntered

    private void buttonSair_MenuPrincipalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSair_MenuPrincipalMouseExited
        buttonSair_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonSair_MenuPrincipal.png")));
    }//GEN-LAST:event_buttonSair_MenuPrincipalMouseExited

    private void buttonJogar_MenuPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonJogar_MenuPrincipalMouseClicked

    }//GEN-LAST:event_buttonJogar_MenuPrincipalMouseClicked

    private void buttonJogar_MenuPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonJogar_MenuPrincipalMousePressed
        buttonJogar_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonJogarPressed_MenuPrincipal.png")));
    }//GEN-LAST:event_buttonJogar_MenuPrincipalMousePressed

    private void buttonSair_MenuPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSair_MenuPrincipalMousePressed
        buttonSair_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonSairPressed_MenuPrincipal.png")));
    }//GEN-LAST:event_buttonSair_MenuPrincipalMousePressed

    private void buttonVoltar_MenuFasesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVoltar_MenuFasesMousePressed
    }//GEN-LAST:event_buttonVoltar_MenuFasesMousePressed

    private void buttonVoltar_MenuFasesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVoltar_MenuFasesMouseEntered
        buttonVoltar_MenuFases.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonVoltarGrandePressed.png")));
    }//GEN-LAST:event_buttonVoltar_MenuFasesMouseEntered

    private void buttonVoltar_MenuFasesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVoltar_MenuFasesMouseExited
        buttonVoltar_MenuFases.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonVoltarGrandeNormal.png")));
    }//GEN-LAST:event_buttonVoltar_MenuFasesMouseExited

    private void buttonHistoria_MenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHistoria_MenuPrincipalActionPerformed
        showPanel(panelHistoria);
    }//GEN-LAST:event_buttonHistoria_MenuPrincipalActionPerformed

    private void buttonHistoria_MenuPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonHistoria_MenuPrincipalMouseEntered
        buttonHistoria_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonHistoriaHover_MenuPrincipal.png")));
    }//GEN-LAST:event_buttonHistoria_MenuPrincipalMouseEntered

    private void buttonHistoria_MenuPrincipalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonHistoria_MenuPrincipalMouseExited
        buttonHistoria_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonHistoria_MenuPrincipal.png")));
    }//GEN-LAST:event_buttonHistoria_MenuPrincipalMouseExited

    private void buttonHistoria_MenuPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonHistoria_MenuPrincipalMousePressed
        buttonHistoria_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonHistoriaPressed_MenuPrincipal.png")));
    }//GEN-LAST:event_buttonHistoria_MenuPrincipalMousePressed

    private void buttonVoltar_HistoriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVoltar_HistoriaMouseEntered
        buttonVoltar_Historia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonVoltarGrandePressed.png")));
    }//GEN-LAST:event_buttonVoltar_HistoriaMouseEntered

    private void buttonVoltar_HistoriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVoltar_HistoriaMouseExited
        buttonVoltar_Historia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonVoltarGrandeNormal.png")));
    }//GEN-LAST:event_buttonVoltar_HistoriaMouseExited

    private void buttonVoltar_HistoriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVoltar_HistoriaMousePressed
        buttonVoltar_Historia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonVoltarGrandePressed.png")));
    }//GEN-LAST:event_buttonVoltar_HistoriaMousePressed

    private void buttonVoltar_HistoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltar_HistoriaActionPerformed
        showPanel(panelMenuPrincipal);
    }//GEN-LAST:event_buttonVoltar_HistoriaActionPerformed

    private void buttonCreditos_MenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreditos_MenuPrincipalActionPerformed
        showPanel(panelCreditos);
    }//GEN-LAST:event_buttonCreditos_MenuPrincipalActionPerformed

    private void buttonCreditos_MenuPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCreditos_MenuPrincipalMouseEntered
        buttonCreditos_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonCreditosHover_MenuPrincipal.png")));
    }//GEN-LAST:event_buttonCreditos_MenuPrincipalMouseEntered

    private void buttonCreditos_MenuPrincipalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCreditos_MenuPrincipalMouseExited
        buttonCreditos_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonCreditos_MenuPrincipal.png")));
    }//GEN-LAST:event_buttonCreditos_MenuPrincipalMouseExited

    private void buttonCreditos_MenuPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCreditos_MenuPrincipalMousePressed
        buttonCreditos_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonCreditosPressed_MenuPrincipal.png")));
    }//GEN-LAST:event_buttonCreditos_MenuPrincipalMousePressed

    private void buttonVoltar_CreditosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVoltar_CreditosMouseEntered
        buttonVoltar_Creditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonVoltarGrandePressed.png")));
    }//GEN-LAST:event_buttonVoltar_CreditosMouseEntered

    private void buttonVoltar_CreditosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVoltar_CreditosMouseExited
        buttonVoltar_Creditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonVoltarGrandeNormal.png")));
    }//GEN-LAST:event_buttonVoltar_CreditosMouseExited

    private void buttonVoltar_CreditosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVoltar_CreditosMousePressed
        buttonVoltar_Creditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/images/buttonVoltarGrandePressed.png")));
    }//GEN-LAST:event_buttonVoltar_CreditosMousePressed

    private void buttonVoltar_CreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltar_CreditosActionPerformed
         showPanel(panelMenuPrincipal);
    }//GEN-LAST:event_buttonVoltar_CreditosActionPerformed

    public void faseSelecionada(int id) {
        Universal.currentFaseId = id;
        showPanel(panelFase);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg_MenuFases;
    private javax.swing.JLabel bg_MenuPrincipal;
    private javax.swing.JButton buttonAbrir_Fase;
    private javax.swing.JButton buttonAdicionarVariavel_Fase;
    private javax.swing.JButton buttonCreditos_MenuPrincipal;
    private javax.swing.JButton buttonExcluirVariavel_Fase;
    private javax.swing.JButton buttonExecutar_Fase;
    private javax.swing.JButton buttonHistoria_MenuPrincipal;
    private javax.swing.JButton buttonJogar_MenuPrincipal;
    private javax.swing.JButton buttonMenuPrincipal_Fase;
    private javax.swing.JButton buttonSair_MenuPrincipal;
    private javax.swing.JButton buttonSalvar_Fase;
    private javax.swing.JButton buttonVoltar_Creditos;
    private javax.swing.JButton buttonVoltar_Fase;
    private javax.swing.JButton buttonVoltar_Historia;
    private javax.swing.JButton buttonVoltar_MenuFases;
    private javax.swing.JTextPane codeEditor;
    private javax.swing.JLabel imagemGradeFase_Fase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelLevel_MenuFases;
    private javax.swing.JLabel labelLevel_MenuPrincipal;
    private javax.swing.JLabel labelPoints_MenuFases;
    private javax.swing.JLabel labelPoints_MenuPrincipal;
    private javax.swing.JTextArea labelText_Fase;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelCreditos;
    private javax.swing.JPanel panelFase;
    private javax.swing.JPanel panelHistoria;
    private javax.swing.JPanel panelListaFases;
    private javax.swing.JPanel panelMenuFases;
    private javax.swing.JPanel panelMenuPrincipal;
    private javax.swing.JPanel panelSplash;
    private javax.swing.JScrollPane scrollPaneCodeEditor;
    private javax.swing.JScrollPane scrollPaneListaFases;
    private javax.swing.JTable tableVariaveis_Fase;
    // End of variables declaration//GEN-END:variables
}
