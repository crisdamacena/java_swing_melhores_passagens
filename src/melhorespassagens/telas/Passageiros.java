package melhorespassagens.telas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import static melhorespassagens.telas.BancoDeDados.*;
import Jm.JMascara;

public class Passageiros extends javax.swing.JFrame {
    //Variável que indica o próximo ID (PK) disponível no banco de dados
    int proximoID = 0;
    //Variável que recebe o ID selecionado na tabela
    int key = 0;
    //Variáveis de conexão com o banco de dados
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rsMostrar = null, rsContar = null, rsNaturalidade=null, rsDDD=null;
    Statement stMostrar = null, stContar = null, stNaturalidade=null, stDDD=null;

    public Passageiros() {
        initComponents();
        mostrarPassageiros();
        listaNacionalidade.addItem("----");
        obterEstados();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaInicial = new javax.swing.JPanel();
        areaMenu = new javax.swing.JPanel();
        logoLaranja = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        camposVoos = new javax.swing.JPanel();
        nomePassageiro = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        naturalidade = new javax.swing.JLabel();
        listaNacionalidade = new javax.swing.JComboBox<>();
        faixa = new javax.swing.JLabel();
        listaFaixa = new javax.swing.JComboBox<>();
        numCPF = new javax.swing.JLabel();
        campoCPF = new javax.swing.JTextField();
        telefone = new javax.swing.JLabel();
        campoTelefone = new javax.swing.JTextField();
        botoesMenu = new javax.swing.JPanel();
        botaoSalvar = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoDeletar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        passageiros = new javax.swing.JPanel();
        listaPassageiros = new javax.swing.JLabel();
        tabela = new javax.swing.JScrollPane();
        tabelaPassageiros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Melhores Passagens | Gerenciar Passageiros");
        setBackground(new java.awt.Color(255, 102, 51));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/favicon.png")).getImage());
        setResizable(false);

        telaInicial.setBackground(new java.awt.Color(255, 255, 255));
        telaInicial.setPreferredSize(new java.awt.Dimension(1366, 768));

        areaMenu.setBackground(new java.awt.Color(255, 255, 255));

        logoLaranja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLaranja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_orange_small.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Gerenciar Passageiros");

        camposVoos.setBackground(new java.awt.Color(255, 255, 255));

        nomePassageiro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nomePassageiro.setText("Nome do Passageiro:");

        campoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNomeKeyTyped(evt);
            }
        });

        naturalidade.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        naturalidade.setText("Naturalidade:");

        listaNacionalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaNacionalidadeActionPerformed(evt);
            }
        });

        faixa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        faixa.setText("Faixa Etária:");

        listaFaixa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "Adulto", "Criança" }));

        numCPF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        numCPF.setText("CPF:");

        campoCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoCPFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCPFKeyTyped(evt);
            }
        });

        telefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        telefone.setText("Telefone:");

        campoTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTelefoneKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoTelefoneKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTelefoneKeyTyped(evt);
            }
        });

        botoesMenu.setBackground(new java.awt.Color(255, 255, 255));

        botaoSalvar.setBackground(new java.awt.Color(255, 102, 0));
        botaoSalvar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        botaoSalvar.setForeground(new java.awt.Color(255, 255, 255));
        botaoSalvar.setText("Salvar");
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

        botaoEditar.setBackground(new java.awt.Color(255, 102, 0));
        botaoEditar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        botaoEditar.setForeground(new java.awt.Color(255, 255, 255));
        botaoEditar.setText("Editar");
        botaoEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoEditarMouseClicked(evt);
            }
        });
        botaoEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoEditarKeyPressed(evt);
            }
        });

        botaoDeletar.setBackground(new java.awt.Color(255, 102, 0));
        botaoDeletar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        botaoDeletar.setForeground(new java.awt.Color(255, 255, 255));
        botaoDeletar.setText("Deletar");
        botaoDeletar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoDeletarMouseClicked(evt);
            }
        });
        botaoDeletar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoDeletarKeyPressed(evt);
            }
        });

        botaoVoltar.setBackground(new java.awt.Color(255, 102, 0));
        botaoVoltar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        botaoVoltar.setForeground(new java.awt.Color(255, 255, 255));
        botaoVoltar.setText("Voltar");
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
                .addGap(30, 30, 30)
                .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botaoDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        botoesMenuLayout.setVerticalGroup(
            botoesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botoesMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(botoesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(botoesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        passageiros.setBackground(new java.awt.Color(255, 255, 255));

        listaPassageiros.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        listaPassageiros.setText("Lista Passageiros");

        tabelaPassageiros.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaPassageiros.setFocusable(false);
        tabelaPassageiros.setRowHeight(25);
        tabelaPassageiros.setSelectionBackground(new java.awt.Color(255, 102, 51));
        tabelaPassageiros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaPassageiros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaPassageiros.setShowGrid(true);
        tabelaPassageiros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPassageirosMouseClicked(evt);
            }
        });
        tabela.setViewportView(tabelaPassageiros);

        javax.swing.GroupLayout passageirosLayout = new javax.swing.GroupLayout(passageiros);
        passageiros.setLayout(passageirosLayout);
        passageirosLayout.setHorizontalGroup(
            passageirosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passageirosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(passageirosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passageirosLayout.createSequentialGroup()
                        .addComponent(listaPassageiros)
                        .addGap(605, 605, 605))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passageirosLayout.createSequentialGroup()
                        .addComponent(tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186))))
        );
        passageirosLayout.setVerticalGroup(
            passageirosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passageirosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listaPassageiros)
                .addGap(18, 18, 18)
                .addComponent(tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout camposVoosLayout = new javax.swing.GroupLayout(camposVoos);
        camposVoos.setLayout(camposVoosLayout);
        camposVoosLayout.setHorizontalGroup(
            camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botoesMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(camposVoosLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomePassageiro))
                .addGap(35, 35, 35)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listaNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(naturalidade))
                .addGap(35, 35, 35)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listaFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(faixa))
                .addGap(35, 35, 35)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numCPF)
                    .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telefone)
                    .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(passageiros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        camposVoosLayout.setVerticalGroup(
            camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(camposVoosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(naturalidade, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nomePassageiro, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(faixa)
                        .addComponent(numCPF)
                        .addComponent(telefone)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(listaNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(listaFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(botoesMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passageiros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addComponent(camposVoos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
  
    //Exibe página de Menu e fecha página Passageiros
    private void voltarMenu(){
        new Menu().setVisible(true);
        this.dispose();
    }
    
    //Obtem lista de estados do banco de dados
    private void obterEstados(){
        listaNacionalidade.getSelectedItem();    
        try{
            conn = DriverManager.getConnection(URL);
            stNaturalidade = conn.createStatement();
            String query = "SELECT * FROM tb_ddd ORDER BY NATURALIDADE_PASSAGEIRO ASC";
            rsNaturalidade = stNaturalidade.executeQuery(query);
            while(rsNaturalidade.next()){
                String estado = rsNaturalidade.getString("NATURALIDADE_PASSAGEIRO")+"";
                listaNacionalidade.addItem(estado);
            }
            conn.close();
        }catch (Exception e){
            
        }
        
    }
    
    private void obterDDDEstado(){      
        if ((listaNacionalidade.getSelectedItem().toString()).equals("----")){
        }
        else{
            try{
                String query = "SELECT * FROM tb_ddd WHERE NATURALIDADE_PASSAGEIRO="+"'"+listaNacionalidade.getSelectedItem().toString()+"'";
                conn = DriverManager.getConnection(URL);
                stDDD = conn.createStatement();
                rsDDD = stDDD.executeQuery(query);
                if(rsDDD.next()){
                    campoTelefone.setText(rsDDD.getString("DDD"));
                }
                conn.close();
            }catch (Exception e){

            }
        }
    }
        
    //Exibe passageiros na tabela
    private void mostrarPassageiros(){
        try{
            conn = DriverManager.getConnection(URL);
            stMostrar = conn.createStatement();
            String query = "SELECT * FROM tb_passageiros";
            rsMostrar = stMostrar.executeQuery(query);
            tabelaPassageiros.setModel(DbUtils.resultSetToTableModel(rsMostrar));
            conn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    //Limpa dados dos campos do formulario
    private void limparCamposPassageiro(){
        campoNome.setText("");
        campoCPF.setText("");
        campoTelefone.setText("");
        listaNacionalidade.setSelectedItem("----");
        listaFaixa.setSelectedItem("----");
    }
    
    //Conta quantos passageiros já foram cadastrados
    private void contarPassageiros(){
        try{
            stContar = conn.createStatement();
            rsContar = stContar.executeQuery("SELECT MAX(ID_PASSAGEIRO) FROM tb_passageiros");
            rsContar.next();
            proximoID = rsContar.getInt(1) + 1;
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    //Seleciona um único passageiro na tabela
    private void selecionarPassageiro(){
        DefaultTableModel model = (DefaultTableModel)tabelaPassageiros.getModel();
        int index = tabelaPassageiros.getSelectedRow();
        key = Integer.valueOf(model.getValueAt(index, 0).toString());
        campoNome.setText(model.getValueAt(index, 1).toString());
        listaNacionalidade.setSelectedItem(model.getValueAt(index, 2).toString());
        listaFaixa.setSelectedItem(model.getValueAt(index, 3).toString());
        campoCPF.setText(model.getValueAt(index, 4).toString());
        campoTelefone.setText(model.getValueAt(index, 5).toString());
    }
    
    //Salva dados do novo passageiro no banco de dados
    private void salvarDB(){
        if(campoNome.getText().isEmpty() || campoCPF.getText().isEmpty() || campoTelefone.getText().isEmpty() || (listaNacionalidade.getSelectedItem().toString()).equals("----") || (listaFaixa.getSelectedItem().toString()).equals("----")){
            JOptionPane.showMessageDialog(null,"Campos obrigatórios vazios","Atenção!", JOptionPane.WARNING_MESSAGE);
        }else{
            try{        
                conn = DriverManager.getConnection(URL);
                contarPassageiros(); 
                String Query = "INSERT INTO tb_passageiros(ID_PASSAGEIRO,NOME_PASSAGEIRO,NATURALIDADE_PASSAGEIRO,FAIXA_PASSAGEIRO,CPF_PASSAGEIRO,TELEFONE_PASSAGEIRO) VALUES(?,?,?,?,?,?)";
                PreparedStatement add = conn.prepareStatement(Query);
                add.setInt(1,proximoID);
                add.setString(2, campoNome.getText());
                add.setString(3, listaNacionalidade.getSelectedItem().toString());
                add.setString(4, listaFaixa.getSelectedItem().toString());
                add.setString(5, campoCPF.getText());
                add.setString(6, campoTelefone.getText());
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Passageiro adicionado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                limparCamposPassageiro();
                conn.close();
                mostrarPassageiros();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }
    
    //Edita dados de passageiro existente no banco de dados
    private void editarDB(){
        if(key == 0){
            JOptionPane.showMessageDialog(null, "Escolha uma pessoa da lista de passageiros", "Atenção!",JOptionPane.WARNING_MESSAGE);
        }else{
            try{              
                conn = DriverManager.getConnection(URL);
                String query = "UPDATE tb_passageiros SET NOME_PASSAGEIRO=?,NATURALIDADE_PASSAGEIRO=?,FAIXA_PASSAGEIRO=?,CPF_PASSAGEIRO=?,TELEFONE_PASSAGEIRO=? WHERE ID_PASSAGEIRO="+key;
                PreparedStatement add = conn.prepareStatement(query);
                add.setString(1, campoNome.getText());
                add.setString(2, listaNacionalidade.getSelectedItem().toString());
                add.setString(3, listaFaixa.getSelectedItem().toString());
                add.setString(4, campoCPF.getText());
                add.setString(5, campoTelefone.getText());
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Passageiro editado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);  
                limparCamposPassageiro();
                conn.close();
                mostrarPassageiros();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }
    
    //Deleta dados de passageiro existente no banco de dados
    private void deletarDB(){
        if (key == 0){
            JOptionPane.showMessageDialog(null, "Escolha uma pessoa da lista de passageiros", "Atenção!",JOptionPane.WARNING_MESSAGE);
        }else{
            int delPassageiro = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar este passageiro?", "Atenção!",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if(delPassageiro == JOptionPane.YES_OPTION){ 
                try{
                    conn = DriverManager.getConnection(URL);
                    String query = "DELETE FROM tb_passageiros WHERE ID_PASSAGEIRO="+key;
                    Statement del = conn.createStatement();
                    del.executeUpdate(query);
                    JOptionPane.showMessageDialog(this, "Passageiro deletado!", "Sucesso!", JOptionPane.WARNING_MESSAGE);
                    limparCamposPassageiro();
                    key = 0;
                    conn.close();
                    mostrarPassageiros();
                }catch (Exception e){
                JOptionPane.showMessageDialog(this, e);
                }
            }else{
                
            }
        }
    }
    
    //Eventos dos botões    
    private void botaoSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSalvarMouseClicked
        salvarDB();
    }//GEN-LAST:event_botaoSalvarMouseClicked

    private void botaoDeletarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoDeletarMouseClicked
        deletarDB();
    }//GEN-LAST:event_botaoDeletarMouseClicked
    
    private void tabelaPassageirosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPassageirosMouseClicked
        selecionarPassageiro();
    }//GEN-LAST:event_tabelaPassageirosMouseClicked

    private void botaoVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoVoltarMouseClicked
        voltarMenu();
    }//GEN-LAST:event_botaoVoltarMouseClicked

    private void botaoSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoSalvarKeyPressed
        salvarDB();
    }//GEN-LAST:event_botaoSalvarKeyPressed

    private void botaoDeletarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoDeletarKeyPressed
        deletarDB();
    }//GEN-LAST:event_botaoDeletarKeyPressed

    private void botaoVoltarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoVoltarKeyPressed
        voltarMenu();
    }//GEN-LAST:event_botaoVoltarKeyPressed

    private void botaoEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoEditarMouseClicked
        editarDB();
    }//GEN-LAST:event_botaoEditarMouseClicked

    private void botaoEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEditarKeyPressed
        editarDB();
    }//GEN-LAST:event_botaoEditarKeyPressed

    private void campoTelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTelefoneKeyReleased
        campoTelefone.setText(JMascara.GetJmascaraFone(campoTelefone.getText()));
    }//GEN-LAST:event_campoTelefoneKeyReleased

    private void campoCPFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCPFKeyReleased
        campoCPF.setText(JMascara.GetJmascaraCpfCnpj(campoCPF.getText()));
    }//GEN-LAST:event_campoCPFKeyReleased

    private void campoTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTelefoneKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
        else{
            
        }
    }//GEN-LAST:event_campoTelefoneKeyTyped

    private void campoCPFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCPFKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
        else{
            
        }
    }//GEN-LAST:event_campoCPFKeyTyped

    private void campoNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNomeKeyTyped
        char c = evt.getKeyChar();
        
        if (Character.isDigit(c)){
            evt.consume();
        }
        else{
            
        }
    }//GEN-LAST:event_campoNomeKeyTyped

    private void listaNacionalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaNacionalidadeActionPerformed
        obterDDDEstado();
    }//GEN-LAST:event_listaNacionalidadeActionPerformed

    private void campoTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTelefoneKeyPressed
        
    }//GEN-LAST:event_campoTelefoneKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaMenu;
    private javax.swing.JButton botaoDeletar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JPanel botoesMenu;
    private javax.swing.JTextField campoCPF;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoTelefone;
    private javax.swing.JPanel camposVoos;
    private javax.swing.JLabel faixa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> listaFaixa;
    private javax.swing.JComboBox<String> listaNacionalidade;
    private javax.swing.JLabel listaPassageiros;
    private javax.swing.JLabel logoLaranja;
    private javax.swing.JLabel naturalidade;
    private javax.swing.JLabel nomePassageiro;
    private javax.swing.JLabel numCPF;
    private javax.swing.JPanel passageiros;
    private javax.swing.JScrollPane tabela;
    private javax.swing.JTable tabelaPassageiros;
    private javax.swing.JPanel telaInicial;
    private javax.swing.JLabel telefone;
    // End of variables declaration//GEN-END:variables
}
