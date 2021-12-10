package Model.DAO;

import Connection.Connection_factory;
import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cliente_DAO {

    private Connection con = null;

    public Connection cliente_DAO() {
        return Connection_factory.getConnetion();

    }

    public boolean save(Cliente cliente) {
        String sql = "INSERT INTO cliente (email,nome,telefone) Values (?,?,?)";

        PreparedStatement stmt = null;

        try {
            con = cliente_DAO();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getEmail());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getTelefone());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
            return false;
        } finally {
            Connection_factory.closeConnection(con, stmt);

        }

    }

    public List<Cliente> buscar() {

        String sql = "SELECT * FROM cliente";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setCod_cliente(rs.getInt("cod_cliente"));
                cliente.setEmail(rs.getString("email"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                clientes.add(cliente);

            }

        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
        } finally {
            Connection_factory.closeConnection(con, stmt, rs);
        }

        return clientes;

    }

    public boolean update(Cliente cliente) {
        String sql = "UPDATE cliente SET email,nome,telefone= ?,?,? WHERE cod_cliente = ? ";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getEmail());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getTelefone());
            stmt.setInt(4, cliente.getCod_cliente());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
            return false;
        } finally {
            Connection_factory.closeConnection(con, stmt);

        }

    }

    public boolean delete(Cliente cliente) {
        String sql = "DELETE FROM cliente WHERE cod_cliente = ? ";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, cliente.getCod_cliente());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
            return false;
        } finally {
            Connection_factory.closeConnection(con, stmt);

        }

    }

}
