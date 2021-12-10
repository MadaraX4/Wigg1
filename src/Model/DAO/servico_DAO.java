
package Model.DAO;

import Connection.Connection_factory;
import Model.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;


public class servico_DAO {
    
    
    private Connection con = null;

    public Connection servico_DAO() {
        return Connection_factory.getConnetion();

    }

    public boolean save(Servico servico) {
        String sql = "INSERT INTO cliente (nome,tipo) Values (?,?)";

        PreparedStatement stmt = null;

        try {
            con = servico_DAO();
            stmt = con.prepareStatement(sql);
            stmt.setString(1,servico.getNome() );
            stmt.setString(2, servico.getTipo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
            return false;
        } finally {
            Connection_factory.closeConnection(con, stmt);

        }

    }
    
     public void consulta(JTextField horario, JTextField data_agendamento, JTextField cliente, JTextField servico, String cod_produto) {
        String sql = "Select horario,data_agendamento,cliente,servico from agendamento where cod_agendamento like ?";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, cod_produto);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String tnome = rs.getString("nome");
                horario.setText(tnome.toString());

                String tdata_agendamento = rs.getString("data_agendamento");
                data_agendamento.setText(tdata_agendamento.toString());

                Integer tcliente = rs.getInt("cliente");
                cliente.setText(tcliente.toString());
                
                Integer tservico = rs.getInt("servico");
                cliente.setText(tservico.toString());

            }
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
}
