import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    public static Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/controleestoque";
        String usuario = "root";
        String senha = "";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com sucesso!!!");
            return conexao;
        } catch (SQLException e) {
            //System.out.println("Erro ao conectar com o Banco de dados" + e.getMessage());
            throw new RuntimeException("Erro na conexão com o banco de dados", e);
        }
    }
}
