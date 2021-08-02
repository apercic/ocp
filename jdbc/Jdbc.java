import java.sql.*;

public class Jdbc {

    public static void main(String[] args) throws SQLException {
        //need to run it with driver in classpath
        //java -cp "<path_to_derby>/derby.jar" TestConnect.java

        String url = "jdbc:derby:zoo"; //protocol:subprotocol:subname
        try (Connection conn = DriverManager.getConnection(url); //use DataSource always IRL, DriverManager is in exam
             PreparedStatement ps = conn.prepareStatement("SELECT name FROM animal"); //SQL is mandatory!!
             //CallableStatement

             //or executeUpdate() //for DELETE, INSERT, UPDATE
             ResultSet rs = ps.executeQuery()) //for SELECT

        {

            while (rs.next()) System.out.println(rs.getString(1));
        }
    }
}



