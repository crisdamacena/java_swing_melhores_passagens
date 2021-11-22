package melhorespassagens.telas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static melhorespassagens.telas.BancoDeDados.*;

public class Login extends javax.swing.JFrame {
    
    public Login() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaInicial = new javax.swing.JPanel();
        areaLogin = new javax.swing.JPanel();
        logoBranca = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        senha = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        botaoLogin = new javax.swing.JButton();
        imgLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Melhores Passagens | Login");
        setBackground(new java.awt.Color(255, 102, 0));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/favicon.png")).getImage());
        setResizable(false);

        telaInicial.setBackground(new java.awt.Color(255, 255, 255));
        telaInicial.setPreferredSize(new java.awt.Dimension(1366, 768));

        areaLogin.setBackground(new java.awt.Color(255, 102, 0));

        logoBranca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoBranca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_white_small.png"))); // NOI18N

        usuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        usuario.setForeground(new java.awt.Color(255, 255, 255));
        usuario.setText("Usuário:");

        senha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        senha.setForeground(new java.awt.Color(255, 255, 255));
        senha.setText("Senha:");

        campoSenha.setToolTipText("");

        botaoLogin.setBackground(new java.awt.Color(255, 255, 255));
        botaoLogin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoLogin.setText("Login");
        botaoLogin.setBorder(null);
        botaoLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoLoginMouseClicked(evt);
            }
        });
        botaoLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoLoginKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout areaLoginLayout = new javax.swing.GroupLayout(areaLogin);
        areaLogin.setLayout(areaLoginLayout);
        areaLoginLayout.setHorizontalGroup(
            areaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(areaLoginLayout.createSequentialGroup()
                .addGroup(areaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(areaLoginLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(logoBranca))
                    .addGroup(areaLoginLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(areaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, areaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(senha)
                                .addComponent(campoSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                                .addComponent(botaoLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(usuario))))
                .addContainerGap(1229, Short.MAX_VALUE))
        );
        areaLoginLayout.setVerticalGroup(
            areaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(areaLoginLayout.createSequentialGroup()
                .addComponent(logoBranca)
                .addGap(104, 104, 104)
                .addComponent(usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(senha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(botaoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        imgLogin.setBackground(new java.awt.Color(255, 102, 0));
        imgLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        imgLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login_.png"))); // NOI18N

        javax.swing.GroupLayout telaInicialLayout = new javax.swing.GroupLayout(telaInicial);
        telaInicial.setLayout(telaInicialLayout);
        telaInicialLayout.setHorizontalGroup(
            telaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaInicialLayout.createSequentialGroup()
                .addComponent(imgLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        telaInicialLayout.setVerticalGroup(
            telaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaInicialLayout.createSequentialGroup()
                .addGroup(telaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(areaLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(telaInicialLayout.createSequentialGroup()
                        .addComponent(imgLogin)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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

    private void enviarDadosLogin(){
                  
        if(campoUsuario.getText().isBlank() || campoSenha.getPassword().equals(null)){
            JOptionPane.showMessageDialog(null,"Campos obrigatórios vazios","Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            new Menu().setVisible(true);
            this.dispose();            
        }
    }
       
    private void botaoLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoLoginMouseClicked
        enviarDadosLogin();
    }//GEN-LAST:event_botaoLoginMouseClicked

    private void botaoLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoLoginKeyPressed
       enviarDadosLogin();
    }//GEN-LAST:event_botaoLoginKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaLogin;
    private javax.swing.JButton botaoLogin;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel imgLogin;
    private javax.swing.JLabel logoBranca;
    private javax.swing.JLabel senha;
    private javax.swing.JPanel telaInicial;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
