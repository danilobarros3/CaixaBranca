import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * User é a classe dos usuários existentes
 */
public class User {
    /**
     * Variável para armazenar o nome do usuário
     */
    public String nome = "";
    /**
     * Variável para armazenar o resultado da verificação
     */
    public boolean result = false;

    /**
     * Método para verificar um usuário no banco de dados.
     *
     * @param login O nome de usuário a ser verificado.
     * @param senha A senha do usuário a ser verificada.
     * @return Verdadeiro se o usuário for encontrado no banco de dados, falso caso contrário.
     */

    /**
     * Estabelece conexão com o banco de dados
     * 
     * @return o objeto de conexão do banco de dados.
     * @throws Exception mensagem de falha na conexão
     */
    
    public Connection conectarBD(){
        Connection conn = null;

        try {
            Class.forName("com.mysql.Driver.Manager").newInstance(); // Conexão entre Java e o Banco.

            String url = "jdbc:mysql://127.0.0.1/test?user=root&password=Fe210802DBA."; 
            conn = DriverManager.getConnection(url); // Estabelece a conexão com o serviço de dados.
        }catch(Exception e){
          // Realizar testes caso de erro
        }
        return conn; // Retorno do objeto de conexão
    }

    
    public boolean verificarUsuario(String login,String senha) {
        String sql = "";
        Connection conn = conectarBD(); // Instanciamento do Connection a partir da chamada de função conectarBD()

        //INSTRUÇÃO SQL para selecionar o nome do usuário com base no login e senha
        sql += "select nome from usuarios ";
        sql += "where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";

        try {
            Statement st = conn.createStatement(); // Criação do objeto para envio da instrução SQL
            ResultSet rs = st.executeQuery(sql); // Envio da instrução SQL 

            // Caso haja objetos dentro do retorno
            if(rs.next()){
                result = true; 
                nome = rs.getString("nome"); // Atribuição da propriedade nome a variavel nome
            }
        }catch (Exception e) {
          // Realizar testes caso de erro
        }

        return result;
    }
} // fi
