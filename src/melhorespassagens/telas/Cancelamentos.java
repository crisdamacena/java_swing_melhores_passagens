package melhorespassagens.telas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import static melhorespassagens.telas.BancoDeDados.*;

public class Cancelamentos extends javax.swing.JFrame {
    //Variável que indica o próximo ID (PK) disponível no banco de dados
    int proximoID = 0;
    //Variável que recebe o ID selecionado na tabela
    String key = null;
    //Variáveis de conexão com o banco de dados
    Connection conn = null;
    ResultSet rsPassageiros = null, rsDadosReserva = null, rsReservas = null, rsMostrar=null, rsContar=null;
    Statement stPassageiros = null, stDadosReserva = null, stReservas = null, stMostrar=null, stContar=null;
    public Cancelamentos() {
        initComponents();
        bloquearEdicao();
        mostrarCancelamentos();
        listaIdPassagem.addItem("----");
        obterReservas();
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
        listaIdPassagem = new javax.swing.JComboBox<>();
        cpf = new javax.swing.JLabel();
        campoCPF = new javax.swing.JTextField();
        nome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        codigo = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        data = new javax.swing.JLabel();
        dataCancelamento = new com.toedter.calendar.JDateChooser();
        botoesMenu = new javax.swing.JPanel();
        botaoSalvar = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        botaoResetar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        cancelamentos = new javax.swing.JPanel();
        listaCancelamentos = new javax.swing.JLabel();
        tabela = new javax.swing.JScrollPane();
        tabelaCancelamentos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Melhores Passagens | Gerenciar Cancelamentos");
        setBackground(new java.awt.Color(255, 102, 0));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/favicon.png")).getImage());
        setResizable(false);

        telaInicial.setBackground(new java.awt.Color(255, 255, 255));
        telaInicial.setPreferredSize(new java.awt.Dimension(1366, 768));

        areaMenu.setBackground(new java.awt.Color(255, 255, 255));

        logoLaranja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLaranja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_orange_small.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Gerenciar Cancelamentos");

        camposVoos.setBackground(new java.awt.Color(255, 255, 255));

        id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        id.setText("ID Passagem:");

        listaIdPassagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaIdPassagemActionPerformed(evt);
            }
        });

        cpf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cpf.setText("CPF:");

        campoCPF.setEditable(false);
        campoCPF.setToolTipText("");

        nome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nome.setText("Nome do Passageiro:");

        campoNome.setEditable(false);
        campoNome.setToolTipText("");

        codigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        codigo.setText("Código do Vôo:");

        campoCodigo.setEditable(false);
        campoCodigo.setToolTipText("");

        data.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        data.setText("Data:");

        botoesMenu.setBackground(new java.awt.Color(255, 255, 255));

        botaoSalvar.setBackground(new java.awt.Color(255, 102, 0));
        botaoSalvar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        botaoSalvar.setForeground(new java.awt.Color(255, 255, 255));
        botaoSalvar.setText("Cancelar Reserva");
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

        botaoLimpar.setBackground(new java.awt.Color(255, 102, 0));
        botaoLimpar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        botaoLimpar.setForeground(new java.awt.Color(255, 255, 255));
        botaoLimpar.setText("Limpar Lista");
        botaoLimpar.setBorder(null);
        botaoLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoLimparMouseClicked(evt);
            }
        });
        botaoLimpar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoLimparKeyPressed(evt);
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
                .addGap(30, 30, 30)
                .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botaoResetar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        botoesMenuLayout.setVerticalGroup(
            botoesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botoesMenuLayout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addGroup(botoesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoResetar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        cancelamentos.setBackground(new java.awt.Color(255, 255, 255));

        listaCancelamentos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        listaCancelamentos.setText("Lista Cancelamentos");

        tabelaCancelamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaCancelamentos.setRowHeight(25);
        tabelaCancelamentos.setSelectionBackground(new java.awt.Color(255, 102, 51));
        tabela.setViewportView(tabelaCancelamentos);

        javax.swing.GroupLayout cancelamentosLayout = new javax.swing.GroupLayout(cancelamentos);
        cancelamentos.setLayout(cancelamentosLayout);
        cancelamentosLayout.setHorizontalGroup(
            cancelamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cancelamentosLayout.createSequentialGroup()
                .addContainerGap(189, Short.MAX_VALUE)
                .addGroup(cancelamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cancelamentosLayout.createSequentialGroup()
                        .addComponent(tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cancelamentosLayout.createSequentialGroup()
                        .addComponent(listaCancelamentos)
                        .addGap(589, 589, 589))))
        );
        cancelamentosLayout.setVerticalGroup(
            cancelamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cancelamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listaCancelamentos)
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
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id)
                    .addComponent(listaIdPassagem, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigo)
                    .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(data)
                    .addComponent(dataCancelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nome)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cpf)
                    .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(cancelamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        camposVoosLayout.setVerticalGroup(
            camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(camposVoosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createSequentialGroup()
                            .addComponent(data)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dataCancelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(camposVoosLayout.createSequentialGroup()
                            .addComponent(id)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(listaIdPassagem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createSequentialGroup()
                            .addComponent(codigo)
                            .addGap(46, 46, 46))
                        .addGroup(camposVoosLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createSequentialGroup()
                            .addComponent(nome)
                            .addGap(46, 46, 46))
                        .addGroup(camposVoosLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createSequentialGroup()
                            .addComponent(cpf)
                            .addGap(46, 46, 46))
                        .addGroup(camposVoosLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(botoesMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

     
    //Exibe página de Menu e fecha página Cancelamentos
    private void voltarMenu(){
        new Menu().setVisible(true);
        this.dispose();
    }
    
    //Determina campos que não podem ser editados
    public void bloquearEdicao(){
       campoCodigo.setEditable(false);
    }
    
    //Formata data (Exemplo: 2021-12-28)
    private String padronizarData(Date valorData){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dataVooFormatada = simpleDateFormat.format(valorData);
        
        return dataVooFormatada;
    }
    
    //Limpa dados dos campos do formulario
    private void limparCamposCancelamento(){
        listaIdPassagem.setSelectedItem("----");
        campoCodigo.setText("");
        campoCPF.setText("");
        campoNome.setText("");
    }
    
    //Pesquisa e exibe lista de IDs de reservas nos campos do formulário
    private void obterReservas(){
        try{
            conn = DriverManager.getConnection(URL);
            stReservas = conn.createStatement();
            String query = "SELECT * FROM tb_reservas_passagens";
            rsReservas = stReservas.executeQuery(query);
            while(rsReservas.next()){
                String id = rsReservas.getInt("ID_PASSAGEM")+"";
                listaIdPassagem.addItem(id);
            }
            conn.close();
        }catch (Exception e){
            
        } 
    }
    
    //Pesquisa e exibe dados do passageiro baseado na consulta pelo ID realizada em obterPassageiro()
    private void obterDadosReserva(){
        if ((listaIdPassagem.getSelectedItem().toString()).equals("----")){
             campoCodigo.setText("");
        }
        else{
            try{
                String query = "SELECT * FROM tb_reservas_passagens WHERE ID_PASSAGEM="+"'"+listaIdPassagem.getSelectedItem().toString()+"'";
                conn = DriverManager.getConnection(URL);
                stDadosReserva = conn.createStatement();
                rsDadosReserva = stDadosReserva.executeQuery(query);
                if(rsDadosReserva.next()){
                    campoNome.setText(rsDadosReserva.getString("NOME_PASSAGEIRO"));
                    campoCPF.setText(rsDadosReserva.getString("CPF_PASSAGEIRO"));
                    campoCodigo.setText(rsDadosReserva.getString("COD_VOO"));
                }
                conn.close();
            }catch (Exception e){

            }
        }
    }
    
    //Conta quantas reservas já foram cadastrados
    private void contarCancelamentos(){
        try{
            stContar = conn.createStatement();
            rsContar = stContar.executeQuery("SELECT MAX(ID_CANCELAMENTO) FROM tb_cancelamentos");       
            rsContar.next();
            proximoID = rsContar.getInt(1) + 1;
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    //Exibe passageiros na tabela
    private void mostrarCancelamentos(){
        try{
            conn = DriverManager.getConnection(URL);
            stMostrar = conn.createStatement();
            String query = "SELECT * FROM tb_cancelamentos ORDER BY COD_VOO ASC";
            rsMostrar = stMostrar.executeQuery(query);
            tabelaCancelamentos.setModel(DbUtils.resultSetToTableModel(rsMostrar));
            conn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    //Salva dados do cancelamento no banco de dados
    private void salvarDB(){
        if(campoCodigo.getText().isEmpty() || dataCancelamento.getDate() == null || (listaIdPassagem.getSelectedItem().toString()).equals("----")){
            JOptionPane.showMessageDialog(null,"Campos obrigatórios vazios","Atenção!", JOptionPane.WARNING_MESSAGE);
        }else{
            
        int delReserva = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar esta reserva?", "Atenção!",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if(delReserva == JOptionPane.YES_OPTION){ 
            try{
                conn = DriverManager.getConnection(URL);
                contarCancelamentos();
                String novaData = padronizarData(dataCancelamento.getDate());
                String query = "INSERT INTO tb_cancelamentos(ID_CANCELAMENTO,ID_PASSAGEM,COD_VOO,DATA_CANCELAMENTO) VALUES(?,?,?,?)";
                PreparedStatement add = conn.prepareStatement(query);
                add.setInt(1,proximoID);
                add.setString(2, listaIdPassagem.getSelectedItem().toString());
                add.setString(3, campoCodigo.getText());
                add.setString(4, novaData);
                
                int row = add.executeUpdate();
                if(deletarDB()){
                    JOptionPane.showMessageDialog(this, "Reserva cancelada!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);  
                    conn.close();
                }
                mostrarCancelamentos();

            }catch(Exception e){

            }
        }else{
            
        }
        }
    }
    
    //Deleta reserva cancelada do banco de dados
    private boolean deletarDB(){
            try{
                String query = "DELETE FROM tb_reservas_passagens WHERE ID_PASSAGEM="+"'"+listaIdPassagem.getSelectedItem().toString()+"'";
                Statement del = conn.createStatement();
                del.executeUpdate(query); 
                limparCamposCancelamento();
                return true;
            }catch (Exception e){
                JOptionPane.showMessageDialog(this, e);         
            }

        return false;
    }
    
    //Limpa lista de reservas canceladas do banco de dados
    private boolean limparDB(){
        int delLista = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja limpar a lista PERMANENTEMENTE?", "Atenção!",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

        if(delLista == JOptionPane.YES_OPTION){ 
            try{
                conn = DriverManager.getConnection(URL);
                String query = "DELETE FROM tb_cancelamentos";
                Statement del = conn.createStatement();
                del.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Lista limpa!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                conn.close();
                mostrarCancelamentos();
                return true;
            }catch (Exception e){
                JOptionPane.showMessageDialog(this, e);         
            }
        }
        else{ 
        }
        return false;
    }
    
    
    private void botaoVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoVoltarMouseClicked
        voltarMenu();
    }//GEN-LAST:event_botaoVoltarMouseClicked

    private void botaoVoltarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoVoltarKeyPressed
        voltarMenu();
    }//GEN-LAST:event_botaoVoltarKeyPressed

    private void botaoResetarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoResetarMouseClicked
        limparCamposCancelamento();
    }//GEN-LAST:event_botaoResetarMouseClicked

    private void botaoResetarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoResetarKeyPressed
        limparCamposCancelamento();
    }//GEN-LAST:event_botaoResetarKeyPressed

    private void listaIdPassagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaIdPassagemActionPerformed
        obterDadosReserva();
    }//GEN-LAST:event_listaIdPassagemActionPerformed

    private void botaoSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoSalvarKeyPressed
        salvarDB();
    }//GEN-LAST:event_botaoSalvarKeyPressed

    private void botaoSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSalvarMouseClicked
        salvarDB();
    }//GEN-LAST:event_botaoSalvarMouseClicked

    private void botaoLimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoLimparMouseClicked
        limparDB();
    }//GEN-LAST:event_botaoLimparMouseClicked

    private void botaoLimparKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoLimparKeyPressed
        limparDB();
    }//GEN-LAST:event_botaoLimparKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaMenu;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoResetar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JPanel botoesMenu;
    private javax.swing.JTextField campoCPF;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoNome;
    private javax.swing.JPanel camposVoos;
    private javax.swing.JPanel cancelamentos;
    private javax.swing.JLabel codigo;
    private javax.swing.JLabel cpf;
    private javax.swing.JLabel data;
    private com.toedter.calendar.JDateChooser dataCancelamento;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel listaCancelamentos;
    private javax.swing.JComboBox<String> listaIdPassagem;
    private javax.swing.JLabel logoLaranja;
    private javax.swing.JLabel nome;
    private javax.swing.JScrollPane tabela;
    private javax.swing.JTable tabelaCancelamentos;
    private javax.swing.JPanel telaInicial;
    // End of variables declaration//GEN-END:variables
}
