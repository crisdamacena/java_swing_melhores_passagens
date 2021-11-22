package melhorespassagens.telas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import static melhorespassagens.telas.BancoDeDados.*;
import java.text.*;

public class Reservas extends javax.swing.JFrame {

    //Variável que indica o próximo ID (PK) disponível no banco de dados
    int proximoID = 0;
    //Variável que recebe o ID selecionado na tabela
    //String key = null;
    //Variáveis de conexão com o banco de dados
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rsPassageiros = null, rsDadosPassageiros = null, rsVoos = null, rsMostrar=null, rsContar=null;
    Statement stPassageiros = null, stDadosPassageiros = null, stVoos = null, stMostrar=null, stContar=null;
    
    public Reservas() {
        initComponents();
        mostrarReservas();
        bloquearEdicao();
        obterPassageiro();
        obterVoos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaInicial = new javax.swing.JPanel();
        areaMenu = new javax.swing.JPanel();
        logoLaranja = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        camposVoos = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        listaIdPassageiro = new javax.swing.JComboBox<>();
        nomePassageiro = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        codigo = new javax.swing.JLabel();
        listaCodigo = new javax.swing.JComboBox<>();
        faixa = new javax.swing.JLabel();
        campoFaixa = new javax.swing.JTextField();
        numCPF = new javax.swing.JLabel();
        campoCPF = new javax.swing.JTextField();
        valor = new javax.swing.JLabel();
        campoValor = new javax.swing.JTextField();
        naturalidade = new javax.swing.JLabel();
        campoNaturalidade = new javax.swing.JTextField();
        botoesMenu = new javax.swing.JPanel();
        botaoSalvar = new javax.swing.JButton();
        botaoResetar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        reservas = new javax.swing.JPanel();
        listaReservas = new javax.swing.JLabel();
        tabela = new javax.swing.JScrollPane();
        tabelaReservasPassagens = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Melhores Passagens | Gerenciar Reservas de Passagens");
        setBackground(new java.awt.Color(153, 0, 153));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/favicon.png")).getImage());
        setResizable(false);

        telaInicial.setBackground(new java.awt.Color(255, 255, 255));
        telaInicial.setPreferredSize(new java.awt.Dimension(1366, 768));

        areaMenu.setBackground(new java.awt.Color(255, 255, 255));

        logoLaranja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLaranja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_orange_small.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Gerenciar Reservas de Passagens");

        camposVoos.setBackground(new java.awt.Color(255, 255, 255));

        id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        id.setText("ID Passageiro:");

        listaIdPassageiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaIdPassageiroActionPerformed(evt);
            }
        });

        nomePassageiro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nomePassageiro.setText("Nome do Passageiro:");

        codigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        codigo.setText("Código do Vôo:");

        faixa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        faixa.setText("Faixa Etária:");

        campoFaixa.setToolTipText("");

        numCPF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        numCPF.setText("CPF:");

        valor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        valor.setText("Valor da Passagem:");

        naturalidade.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        naturalidade.setText("Naturalidade:");

        botoesMenu.setBackground(new java.awt.Color(255, 255, 255));

        botaoSalvar.setBackground(new java.awt.Color(255, 102, 0));
        botaoSalvar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        botaoSalvar.setForeground(new java.awt.Color(255, 255, 255));
        botaoSalvar.setText("Salvar");
        botaoSalvar.setBorder(null);
        botaoSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoSalvarMouseClicked(evt);
            }
        });
        botaoSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoSalvarKeyPressed(evt);
            }
        });

        botaoResetar.setBackground(new java.awt.Color(255, 102, 0));
        botaoResetar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        botaoResetar.setForeground(new java.awt.Color(255, 255, 255));
        botaoResetar.setText("Resetar");
        botaoResetar.setBorder(null);
        botaoResetar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoResetarMouseClicked(evt);
            }
        });
        botaoResetar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoResetarKeyPressed(evt);
            }
        });

        botaoVoltar.setBackground(new java.awt.Color(255, 102, 0));
        botaoVoltar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        botaoVoltar.setForeground(new java.awt.Color(255, 255, 255));
        botaoVoltar.setText("Voltar");
        botaoVoltar.setBorder(null);
        botaoVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoVoltarMouseClicked(evt);
            }
        });
        botaoVoltar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoVoltarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout botoesMenuLayout = new javax.swing.GroupLayout(botoesMenu);
        botoesMenu.setLayout(botoesMenuLayout);
        botoesMenuLayout.setHorizontalGroup(
            botoesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoesMenuLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156)
                .addComponent(botaoResetar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );
        botoesMenuLayout.setVerticalGroup(
            botoesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botoesMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(botoesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(botoesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoResetar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        reservas.setBackground(new java.awt.Color(255, 255, 255));

        listaReservas.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        listaReservas.setText("Lista Reservas");

        tabelaReservasPassagens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaReservasPassagens.setRowHeight(25);
        tabelaReservasPassagens.setSelectionBackground(new java.awt.Color(255, 102, 51));
        tabela.setViewportView(tabelaReservasPassagens);

        javax.swing.GroupLayout reservasLayout = new javax.swing.GroupLayout(reservas);
        reservas.setLayout(reservasLayout);
        reservasLayout.setHorizontalGroup(
            reservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(reservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservasLayout.createSequentialGroup()
                        .addComponent(tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservasLayout.createSequentialGroup()
                        .addComponent(listaReservas)
                        .addGap(616, 616, 616))))
        );
        reservasLayout.setVerticalGroup(
            reservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listaReservas)
                .addGap(18, 18, 18)
                .addComponent(tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout camposVoosLayout = new javax.swing.GroupLayout(camposVoos);
        camposVoos.setLayout(camposVoosLayout);
        camposVoosLayout.setHorizontalGroup(
            camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botoesMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(camposVoosLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaIdPassageiro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomePassageiro))
                .addGap(22, 22, 22)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigo)
                    .addComponent(listaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(faixa)
                    .addComponent(campoFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numCPF))
                .addGap(23, 23, 23)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(valor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoValor))
                .addGap(23, 23, 23)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(naturalidade)
                    .addComponent(campoNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(reservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        camposVoosLayout.setVerticalGroup(
            camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(camposVoosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createSequentialGroup()
                                .addComponent(nomePassageiro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createSequentialGroup()
                                .addComponent(id)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listaIdPassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createSequentialGroup()
                                .addComponent(naturalidade)
                                .addGap(46, 46, 46)))
                        .addGroup(camposVoosLayout.createSequentialGroup()
                            .addComponent(valor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(camposVoosLayout.createSequentialGroup()
                            .addComponent(numCPF)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(campoFaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createSequentialGroup()
                        .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigo)
                            .addComponent(faixa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(botoesMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout areaMenuLayout = new javax.swing.GroupLayout(areaMenu);
        areaMenu.setLayout(areaMenuLayout);
        areaMenuLayout.setHorizontalGroup(
            areaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(camposVoos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(areaMenuLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(logoLaranja)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        areaMenuLayout.setVerticalGroup(
            areaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(areaMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(areaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(logoLaranja)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addComponent(camposVoos, javax.swing.GroupLayout.PREFERRED_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout telaInicialLayout = new javax.swing.GroupLayout(telaInicial);
        telaInicial.setLayout(telaInicialLayout);
        telaInicialLayout.setHorizontalGroup(
            telaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        telaInicialLayout.setVerticalGroup(
            telaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(telaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(telaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Determina campos que não podem ser editados
    public void bloquearEdicao(){
        campoNome.setEditable(false);
        campoFaixa.setEditable(false);
        campoCPF.setEditable(false);
        campoNaturalidade.setEditable(false);
    }
    
    //Exibe página de Menu e fecha página Reservas
    private void voltarMenu(){
        new Menu().setVisible(true);
        this.dispose();
    }
    
    //Pesquisa e exibe lista de IDs de passageiros nos campos do formulário
    private void obterPassageiro(){
        try{
            conn = DriverManager.getConnection(URL);
            stPassageiros = conn.createStatement();
            String query = "SELECT * FROM tb_passageiros";
            rsPassageiros = stPassageiros.executeQuery(query);
            listaIdPassageiro.addItem("----");
            while(rsPassageiros.next()){
                String IDpassageiro = String.valueOf(rsPassageiros.getInt("ID_PASSAGEIRO"));
                listaIdPassageiro.addItem(IDpassageiro);
            }
            conn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
       
    }
    
    //Pesquisa e exibe dados do passageiro baseado na consulta pelo ID realizada em obterPassageiro()
    private void obterDadosPassageiro(){
        try{
            String query = "SELECT * FROM tb_passageiros WHERE ID_PASSAGEIRO="+"'"+listaIdPassageiro.getSelectedItem().toString()+"'";
            conn = DriverManager.getConnection(URL);
            stDadosPassageiros = conn.createStatement();
            rsDadosPassageiros = stDadosPassageiros.executeQuery(query);
            if(rsDadosPassageiros.next()){
                campoNome.setText(rsDadosPassageiros.getString("NOME_PASSAGEIRO"));
                campoFaixa.setText(rsDadosPassageiros.getString("FAIXA_PASSAGEIRO"));
                campoCPF.setText(rsDadosPassageiros.getString("CPF_PASSAGEIRO"));
                campoNaturalidade.setText(rsDadosPassageiros.getString("NATURALIDADE_PASSAGEIRO"));
            }
            conn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    //Pesquisa e exibe lista de IDs de voos nos campos do formulário
    private void obterVoos(){
        try{
            conn = DriverManager.getConnection(URL);
            stVoos = conn.createStatement();
            String query = "SELECT * FROM tb_voos";
            rsVoos = stVoos.executeQuery(query);
            listaCodigo.addItem("----");
            while(rsVoos.next()){
                String cod = rsVoos.getString("COD_VOO");
                listaCodigo.addItem(cod);
            }
            conn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        } 
    }
    
    //Limpa dados dos campos do formulario
    private void limparCamposReserva(){
        listaCodigo.setSelectedItem("----");
        listaIdPassageiro.setSelectedItem("----");
        campoFaixa.setText("");
        campoNome.setText("");
        campoCPF.setText("");
        campoNaturalidade.setText("");
        campoValor.setText("");
    }
    
    //Exibe passageiros na tabela
    private void mostrarReservas(){
        try{
            conn = DriverManager.getConnection(URL);
            stMostrar = conn.createStatement();
            String query = "SELECT * FROM tb_reservas_passagens";
            rsMostrar = stMostrar.executeQuery(query);
            tabelaReservasPassagens.setModel(DbUtils.resultSetToTableModel(rsMostrar));
            conn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    //Conta quantas reservas já foram cadastrados
    private void contarReservas(){
        try{
            stContar = conn.createStatement();
            rsContar = stContar.executeQuery("SELECT MAX(ID_PASSAGEM) FROM tb_reservas_passagens");
            rsContar.next();
            proximoID = rsContar.getInt(1) + 1;
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    //Salva dados da nova reserva no banco de dados
    private void salvarDB(){
        if(campoNome.getText().isEmpty() || campoCPF.getText().isEmpty() || campoFaixa.getText().isEmpty() || campoNaturalidade.getText().isEmpty() || campoValor.getText().isEmpty() || (listaCodigo.getSelectedItem().toString()).equals("----") || (listaIdPassageiro.getSelectedItem().toString()).equals("----")){
            JOptionPane.showMessageDialog(null,"Campos obrigatórios vazios","Atenção!", JOptionPane.WARNING_MESSAGE);
        }else{
            try{
                conn = DriverManager.getConnection(URL);
                contarReservas();
                double vpassagem = Integer.valueOf(campoValor.getText());
                if (campoFaixa.getText().equals("Criança")){
                    vpassagem = vpassagem - (vpassagem*0.2);
                }  
                String Query = "INSERT INTO tb_reservas_passagens(ID_PASSAGEM,NOME_PASSAGEIRO,COD_VOO,FAIXA_PASSAGEIRO,CPF_PASSAGEIRO,VALOR_PASSAGEM,NATURALIDADE_PASSAGEIRO) VALUES(?,?,?,?,?,?,?)";
                PreparedStatement add = conn.prepareStatement(Query);
                add.setInt(1,proximoID);
                add.setString(2, campoNome.getText());
                add.setString(3, listaCodigo.getSelectedItem().toString());
                add.setString(4, campoFaixa.getText());
                add.setString(5, campoCPF.getText());
                add.setDouble(6,vpassagem);
                add.setString(7, campoNaturalidade.getText());
                int row = add.executeUpdate();
                conn.close();
                JOptionPane.showMessageDialog(this, "Reserva adicionada!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                limparCamposReserva();
                mostrarReservas();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }
    
    //Eventos dos botões  
    private void botaoSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSalvarMouseClicked
        salvarDB();
    }//GEN-LAST:event_botaoSalvarMouseClicked

    private void botaoSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoSalvarKeyPressed
        salvarDB();
    }//GEN-LAST:event_botaoSalvarKeyPressed

    private void botaoResetarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoResetarMouseClicked
        limparCamposReserva();
    }//GEN-LAST:event_botaoResetarMouseClicked

    private void botaoResetarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoResetarKeyPressed
        limparCamposReserva();
    }//GEN-LAST:event_botaoResetarKeyPressed

    private void botaoVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoVoltarMouseClicked
        voltarMenu();
    }//GEN-LAST:event_botaoVoltarMouseClicked

    private void botaoVoltarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoVoltarKeyPressed
        voltarMenu();
    }//GEN-LAST:event_botaoVoltarKeyPressed

    private void listaIdPassageiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaIdPassageiroActionPerformed
        obterDadosPassageiro();
    }//GEN-LAST:event_listaIdPassageiroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaMenu;
    private javax.swing.JButton botaoResetar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JPanel botoesMenu;
    private javax.swing.JTextField campoCPF;
    private javax.swing.JTextField campoFaixa;
    private javax.swing.JTextField campoNaturalidade;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoValor;
    private javax.swing.JPanel camposVoos;
    private javax.swing.JLabel codigo;
    private javax.swing.JLabel faixa;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> listaCodigo;
    private javax.swing.JComboBox<String> listaIdPassageiro;
    private javax.swing.JLabel listaReservas;
    private javax.swing.JLabel logoLaranja;
    private javax.swing.JLabel naturalidade;
    private javax.swing.JLabel nomePassageiro;
    private javax.swing.JLabel numCPF;
    private javax.swing.JPanel reservas;
    private javax.swing.JScrollPane tabela;
    private javax.swing.JTable tabelaReservasPassagens;
    private javax.swing.JPanel telaInicial;
    private javax.swing.JLabel valor;
    // End of variables declaration//GEN-END:variables
}
