import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class JdbcDelete {
    static final String url = "jdbc:mysql://127.0.0.1:3306/tracom";
    static final String user = "root";
    static final String pass = "Student2";
    static final String query = "SELECT * FROM student";

    public static void main(String[] args) {
        // Open a connection (creating connection using driver class)
        try(Connection conn = DriverManager.getConnection(url, user, pass);
            //Create statement
            Statement stmt = conn.createStatement();
        ) {
            String sql = "DELETE FROM student " +
                    "WHERE regno = 6";
            //Executing SQL queries
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                //Display values
                System.out.println(rs.getInt(1)+" " +
                        " "+rs.getString(2)+"" +
                        "  "+rs.getString(3)+"" +
                       // " "+rs.getString(4)+"" +
                        " "+rs.getString(4));
            }
            //Closing connection
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
