package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connection_factory {

    private static final String DRIVER = "com.msql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/wigg";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnetion() {

        try {
            

            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }

    }

    public static void closeConnection(Connection con) {

        if (con != null) {

            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        if (stmt != null) {

            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
            }
        }

        closeConnection(con);
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        if (rs != null) {

            try {
                rs.close();

            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
            }
        }

        closeConnection(con, stmt);
    }
    //novo comit

}
