import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    public void inserir(Produto produto){
        String sql;
        sql = "insert into produtos (nome, descricao, quantidade, preco) value" +
                "(?, ?, ?, ?)";
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPreco());

            stmt.executeUpdate();
            System.out.println("Produto Cadastrado com sucesso!!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                produtos.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return produtos;
    }
    public void atualizar(Produto produto) {
        String sql = "UPDATE produtos SET nome = ?, descricao = ?, quantidade = ?, preco = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getId());
            stmt.executeUpdate();

            System.out.println("Produto atualizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void excluir(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Produto excluído com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
