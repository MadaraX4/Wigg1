package Model.DAO;

import Connection.Connection_factory;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class produto_DAO {

    private Connection con = null;

    public Connection produto_DAO() {
        return Connection_factory.getConnetion();

    }

    public boolean save(Produto produto) {
        String sql = "INSERT INTO cliente (nome,preco,quantidade,destribuidor,data_validade) Values (?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            con = produto_DAO();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setString(4, produto.getDestribuidor());
            stmt.setString(5, produto.getData_validade());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
            return false;
        } finally {
            Connection_factory.closeConnection(con, stmt);

        }

    }

    public Double[] vender(int id, int tabela) throws SQLException {

        Double arr[] = {0.0, 0.0};
        if (tabela == 0) {
            String sql = "SELECT * FROM produto WHERE cod_produto=?";
            PreparedStatement stmt = produto_DAO().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                arr[0] = rs.getDouble("preco");
                arr[1] = rs.getDouble("quantidade");
            }
            System.out.println(arr[0]);
            return arr;

        }  else {

            String sql = "SELECT * FROM agendamento WHERE cod_agendamento=?";
            return arr;
        }

    }

}
