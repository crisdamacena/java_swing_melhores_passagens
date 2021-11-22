//Valores globais usados na conexão com o banco de dados
//DriverManager.getConnection(String url, String user, String password)
//https://docs.oracle.com/javase/8/docs/api/java/sql/DriverManager.html

package melhorespassagens.telas;

import java.sql.DriverManager;

public class BancoDeDados {
    final static String URL = "jdbc:sqlite:src/banco/db_melhores_passagens.db";
   
}
