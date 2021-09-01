import java.sql.*;

public class JdbcInsert {
    static final String query="SELECT * FROM student";
    public static void main(String[] args) {

        String dbURL = "jdbc:mysql://127.0.0.1:3306/tracom";
        String username = "root";
        String password = "Student2";
        Connection conn;

        try {

            conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Database Connection Successfully Established!");
            }
            try {
                String sql = "INSERT INTO student (regno, name, email, gender) VALUES (?, ?, ?, ?)";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, "6");
                statement.setString(2, "Jane Muthoni");
                statement.setString(3, "muthonijane@yahoo.com");
               // statement.setString(4, "072291982");
                statement.setString(4, "Female");

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new user was inserted successfully!");
                }
                ResultSet rs = statement.executeQuery(query);
                while(rs.next()){
                    //Display values
                    System.out.println(rs.getInt(1)+" " +
                            " "+rs.getString(2)+"" +
                            "  "+rs.getString(3)+"" +
                            " "+rs.getString(4)+"" +
                            " "+rs.getString(5));
                }


            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }



        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
