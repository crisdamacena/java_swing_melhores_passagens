package melhorespassagens.telas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import static melhorespassagens.telas.BancoDeDados.*;

public class Voos extends javax.swing.JFrame {
    //Variável que indica o próximo ID (PK) disponível no banco de dados
    int proximoID = 0;
    //Variável que recebe o ID selecionado na tabela
    String key = null;
    //Variáveis de conexão com o banco de dados
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rsMostrar = null, rsAeroportos=null;
    Statement stMostrar = null, stAeroportos=null;
    
    public Voos() {
        initComponents();
        mostrarVoos();
        listaOrigem.addItem("----");
        listaDestino.addItem("----");
        obterAeroportos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaInicial = new javax.swing.JPanel();
        areaMenu = new javax.swing.JPanel();
        logoLaranja = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        camposVoos = new javax.swing.JPanel();
        codigo = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        origem = new javax.swing.JLabel();
        listaOrigem = new javax.swing.JComboBox<>();
        destino = new javax.swing.JLabel();
        listaDestino = new javax.swing.JComboBox<>();
        data = new javax.swing.JLabel();
        dataVoo = new com.toedter.calendar.JDateChooser();
        numAssentos = new javax.swing.JLabel();
        campoNumAssentos = new javax.swing.JTextField();
        botoesMenu = new javax.swing.JPanel();
        botaoSalvar = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoDeletar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        voos = new javax.swing.JPanel();
        listaVoos = new javax.swing.JLabel();
        tabela = new javax.swing.JScrollPane();
        tabelaVoos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Melhores Passagens | Gerenciar Vôos");
        setBackground(new java.awt.Color(255, 102, 0));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/favicon.png")).getImage());
        setResizable(false);

        telaInicial.setBackground(new java.awt.Color(255, 255, 255));
        telaInicial.setPreferredSize(new java.awt.Dimension(1366, 768));

        areaMenu.setBackground(new java.awt.Color(255, 255, 255));

        logoLaranja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLaranja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_orange_small.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Gerenciar Vôos");

        camposVoos.setBackground(new java.awt.Color(255, 255, 255));

        codigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        codigo.setText("Código do Vôo:");

        campoCodigo.setEditable(false);

        origem.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        origem.setText("Origem:");

        destino.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        destino.setText("Destino:");

        data.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        data.setText("Data:");

        numAssentos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        numAssentos.setText("Nº Assentos:");

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

        botaoEditar.setBackground(new java.awt.Color(255, 102, 0));
        botaoEditar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        botaoEditar.setForeground(new java.awt.Color(255, 255, 255));
        botaoEditar.setText("Editar");
        botaoEditar.setBorder(null);
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
        botaoDeletar.setBorder(null);
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

        voos.setBackground(new java.awt.Color(255, 255, 255));

        listaVoos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        listaVoos.setText("Lista Vôos");

        tabelaVoos.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaVoos.setRowHeight(25);
        tabelaVoos.setSelectionBackground(new java.awt.Color(255, 102, 51));
        tabelaVoos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVoosMouseClicked(evt);
            }
        });
        tabela.setViewportView(tabelaVoos);

        javax.swing.GroupLayout voosLayout = new javax.swing.GroupLayout(voos);
        voos.setLayout(voosLayout);
        voosLayout.setHorizontalGroup(
            voosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(voosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(voosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, voosLayout.createSequentialGroup()
                        .addComponent(listaVoos)
                        .addGap(632, 632, 632))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, voosLayout.createSequentialGroup()
                        .addComponent(tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(187, 187, 187))))
        );
        voosLayout.setVerticalGroup(
            voosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(voosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listaVoos)
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
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoCodigo))
                .addGap(20, 20, 20)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listaOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(origem))
                .addGap(20, 20, 20)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destino))
                .addGap(20, 20, 20)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataVoo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data))
                .addGap(20, 20, 20)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numAssentos)
                    .addComponent(campoNumAssentos, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(voos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        camposVoosLayout.setVerticalGroup(
            camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(camposVoosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(camposVoosLayout.createSequentialGroup()
                        .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(codigo)
                                .addComponent(origem))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(destino)
                                .addComponent(numAssentos)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNumAssentos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, camposVoosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(listaOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(listaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(camposVoosLayout.createSequentialGroup()
                        .addComponent(data)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataVoo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botoesMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(voos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    
    //Obtem lista de areoportos do banco de dados
    private void obterAeroportos(){
        listaOrigem.getSelectedItem();
        listaDestino.getSelectedItem();
        
        try{
            conn = DriverManager.getConnection(URL);
            stAeroportos = conn.createStatement();
            String query = "SELECT * FROM tb_aeroportos";
            rsAeroportos = stAeroportos.executeQuery(query);
            while(rsAeroportos.next()){
                String aero = rsAeroportos.getString("ID_AEROPORTO")+ " - " +rsAeroportos.getString("CIDADE_AEROPORTO")+" - "+rsAeroportos.getString("UF_AEROPORTO");
                listaOrigem.addItem(aero);
                listaDestino.addItem(aero);
            }
            conn.close();
        }catch (Exception e){
            
        } 
    }
    
    
    
    //Gera código de voo aleatorio
    private String gerarNovoCodigo(String aeroOrigem, String aeroDestino) 
    { 
  
        String conjuntoNumeros;
        StringBuilder codigo;
        
        conjuntoNumeros ="0123456789";

        codigo = new StringBuilder(10); 
        
        codigo.append(aeroOrigem);
        codigo.append(aeroDestino); 

        for (int i = 7; i < 10; i++) { 

            // generate numeric
            int myindex = (int)(conjuntoNumeros.length()*Math.random()); 

            // add the characters
            codigo.append(conjuntoNumeros.charAt(myindex)); 
        } 
        return codigo.toString(); 
    }
    

    
    //Exibe página de Menu e fecha página Vôos
    private void voltarMenu(){
        new Menu().setVisible(true);
        this.dispose();
    }
    
    //Exibe vôos na tabela ordenados pelo vôo mais próximo para o meis futuro
    private void mostrarVoos(){
        try{
            conn = DriverManager.getConnection(URL);
            stMostrar = conn.createStatement();
            String query = "SELECT * FROM tb_voos ORDER BY DATA_VOO ASC";
            rsMostrar = stMostrar.executeQuery(query);
            tabelaVoos.setModel(DbUtils.resultSetToTableModel(rsMostrar));
            conn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    //Limpa dados dos campos do formulario
    private void limparCamposPassageiro(){
        campoCodigo.setText("");
        listaOrigem.setSelectedItem("----");
        listaDestino.setSelectedItem("----");
        campoNumAssentos.setText("");
    }
    
    //Formata data (Exemplo: 2021-12-28)
    private String padronizarData(Date valorData){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dataVooFormatada = simpleDateFormat.format(valorData);
        return dataVooFormatada;
    }
        
    //Seleciona um único vôo na tabela
    private void selecionarVoo(){
        try{
        DefaultTableModel model = (DefaultTableModel)tabelaVoos.getModel();
        int index = tabelaVoos.getSelectedRow();
        
        key = model.getValueAt(index, 0).toString();
        campoCodigo.setText(key);
        listaOrigem.setSelectedItem(model.getValueAt(index, 1).toString());
        listaDestino.setSelectedItem(model.getValueAt(index, 2).toString());
        Date dataTable = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(index, 3).toString());
        dataVoo.setDate(dataTable);
        campoNumAssentos.setText(model.getValueAt(index, 4).toString());
        }catch(Exception e){
            
        }
        
    }
    
    //Salva dados de novo vôo no banco de dados
    private void salvarDB(){
        if(dataVoo.getDate() == null || campoNumAssentos.getText().isEmpty() || (listaOrigem.getSelectedItem().toString()).equals("----") || (listaDestino.getSelectedItem().toString()).equals("----")){
            JOptionPane.showMessageDialog(null,"Campos obrigatórios vazios","Atenção!", JOptionPane.WARNING_MESSAGE);
        }else{
            try{               
                conn = DriverManager.getConnection(URL);
                String codigoVoo = gerarNovoCodigo((listaOrigem.getSelectedItem().toString()).substring(0,3),(listaDestino.getSelectedItem().toString()).substring(0,3));
                String novaData = padronizarData(dataVoo.getDate());
                
                String query = "INSERT INTO tb_voos(COD_VOO,ORIGEM_VOO,DESTINO_VOO,DATA_VOO,NUM_ASSENTOS_VOO) VALUES(?,?,?,?,?)";
                PreparedStatement add = conn.prepareStatement(query);
                add.setString(1, codigoVoo);
                add.setString(2, listaOrigem.getSelectedItem().toString());
                add.setString(3, listaDestino.getSelectedItem().toString());
                add.setString(4, novaData);
                add.setInt(5, Integer.valueOf(campoNumAssentos.getText()));
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Vôo adicionado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                limparCamposPassageiro();
                conn.close();
                mostrarVoos();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }
    
    //Edita dados de vôo existente no banco de dados
    private void editarDB(){
        if(key == null){
            JOptionPane.showMessageDialog(null, "Escolha um vôo da lista de vôos", "Atenção!",JOptionPane.WARNING_MESSAGE);
        }else{
            try{              
                conn = DriverManager.getConnection(URL);
                String query = "UPDATE tb_voos SET ORIGEM_VOO=?,DESTINO_VOO=?,DATA_VOO=?,NUM_ASSENTOS_VOO=? WHERE COD_VOO="+"'"+key+"'";
                PreparedStatement add = conn.prepareStatement(query);
                add.setString(1, listaOrigem.getSelectedItem().toString());
                add.setString(2, listaDestino.getSelectedItem().toString());
                add.setString(3, dataVoo.getDate().toString());
                add.setInt(4, Integer.valueOf(campoNumAssentos.getText()));
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Passageiro editado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);  
                limparCamposPassageiro();
                conn.close();
                mostrarVoos();
            }catch(Exception e){

            }
        }
    }
    
    //Deleta dados de vôo existente no banco de dados
    private void deletarDB(){
        if (key == null){
            JOptionPane.showMessageDialog(null, "Escolha um vôo da lista de vôos", "Atenção",JOptionPane.WARNING_MESSAGE);
        }else{
            
            int delVoo = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar este vôo?", "Atenção!",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if(delVoo == JOptionPane.YES_OPTION){  
                try{
                    conn = DriverManager.getConnection(URL);
                    String query = "DELETE FROM tb_voos WHERE COD_VOO="+"'"+key+"'";
                    Statement del = conn.createStatement();
                    del.executeUpdate(query);
                    JOptionPane.showMessageDialog(this, "Vôo deletado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                    limparCamposPassageiro();
                    key = null;
                    conn.close();
                    mostrarVoos();
                }catch (Exception e){
                    JOptionPane.showMessageDialog(this, e);
                }
            }else{
                limparCamposPassageiro();
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

    private void botaoEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoEditarMouseClicked
        editarDB();
    }//GEN-LAST:event_botaoEditarMouseClicked

    private void botaoEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEditarKeyPressed
        editarDB();
    }//GEN-LAST:event_botaoEditarKeyPressed

    private void botaoDeletarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoDeletarMouseClicked
        deletarDB();
    }//GEN-LAST:event_botaoDeletarMouseClicked

    private void botaoDeletarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoDeletarKeyPressed
        deletarDB();
    }//GEN-LAST:event_botaoDeletarKeyPressed

    private void botaoVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoVoltarMouseClicked
        voltarMenu();
    }//GEN-LAST:event_botaoVoltarMouseClicked

    private void botaoVoltarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoVoltarKeyPressed
        voltarMenu();
    }//GEN-LAST:event_botaoVoltarKeyPressed

    private void tabelaVoosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVoosMouseClicked
        try {
            selecionarVoo();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_tabelaVoosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaMenu;
    private javax.swing.JButton botaoDeletar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JPanel botoesMenu;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoNumAssentos;
    private javax.swing.JPanel camposVoos;
    private javax.swing.JLabel codigo;
    private javax.swing.JLabel data;
    private com.toedter.calendar.JDateChooser dataVoo;
    private javax.swing.JLabel destino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> listaDestino;
    private javax.swing.JComboBox<String> listaOrigem;
    private javax.swing.JLabel listaVoos;
    private javax.swing.JLabel logoLaranja;
    private javax.swing.JLabel numAssentos;
    private javax.swing.JLabel origem;
    private javax.swing.JScrollPane tabela;
    private javax.swing.JTable tabelaVoos;
    private javax.swing.JPanel telaInicial;
    private javax.swing.JPanel voos;
    // End of variables declaration//GEN-END:variables
}
