package Model.DAO;

import Connection.Connection_factory;
import Model.Agendamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Agendamento_DAO {

    private Connection con = null;

    public Connection agendamento_DAO() {
        return Connection_factory.getConnetion();

    }

    public boolean save(Agendamento agendamento) {

        String sql = "INSERT INTO agendamento(horario,data_agendamento,cliente,servico) VALUES (?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            con = agendamento_DAO();
            stmt = con.prepareStatement(sql);

            stmt.setString(1, agendamento.getHorario());
            stmt.setString(2, agendamento.getData_agendamento());
            stmt.setString(3, agendamento.getCliente());
            stmt.setString(4, agendamento.getServico());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error:" + e);
            return false;
        } finally {
            Connection_factory.closeConnection(con, stmt);
        }
    }

    public Agendamento buscar(int cod_agendamento) throws SQLException {
        String sql = "SELECT * FROM agendamento WHERE cod_agendamento=?";
        PreparedStatement stmt = agendamento_DAO().prepareStatement(sql);
        stmt.setInt(1, cod_agendamento);
        ResultSet rs = stmt.executeQuery();
        Agendamento a = new Agendamento();
        while (rs.next()) {
            a.setCliente(rs.getString("cliente"));
            a.setData_agendamento(rs.getString("data_agendamento"));
            a.setHorario(rs.getString("horario"));
            a.setServico(rs.getString("servico"));
        }
        return a;
    }

    public void deletar(int cod_agendamento) throws SQLException {
        String sql = "DELETE FROM agendamento WHERE cod_agendamento=?";

        PreparedStatement stmt = agendamento_DAO().prepareStatement(sql);
        stmt.setInt(1, cod_agendamento);
        stmt.executeUpdate();

    }
}
