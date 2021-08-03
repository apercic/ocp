import java.sql.*;

public class Jdbc {

    public static void main(String[] args) throws SQLException {
        //need to run it with driver in classpath
        //java -cp "<path_to_derby>/derby.jar" TestConnect.java

        String url = "jdbc:derby:zoo"; //protocol:subprotocol:subname
        try (Connection conn = DriverManager.getConnection(url); //use DataSource always IRL, DriverManager is in exam
             PreparedStatement ps = conn.prepareStatement("SELECT name FROM animal"); //SQL is mandatory!!
             //CallableStatement - stored procedures
             String sql = "{? = call read_e_names(?)}"; //?= is optional
             try (CallableStatement cs = conn.prepareCall(sql)) {
                cs.setString(1, "Z"); / cs.setString("prefix", "Z"); //equivalent
                cs.registerOutParameter(1, Types.INTEGER);
                 
                ResultSet rs = cs.executeQuery()) //or execute() if your not returning a ResultSet
                    
                //INOUT param
                cs.setInt(1, 8);
                cs.registerOutParameter(1, Types.INTEGER);

             //if you mix this up - SQLException is thrown
             //OR int result = ps.executeUpdate(); //for DELETE, INSERT, UPDATE
             //be careful - executeUpdate/executeQuery/execute dont take params(runtime error because extends Statement)
             ResultSet rs = ps.executeQuery()) //for SELECT
            
            // execute() can run on query OR update - if return true-there is a result set
            boolean isResultSet = ps.execute();
            if (isResultSet) try (ResultSet rs = ps.getResultSet()) {}
            else int result = ps.getUpdateCount();
            
            // sql params - START COUNT AT 1!
            //all must be initialized!
            String sql = "INSERT INTO names VALUES(?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, key);              
                ps.setObject(2, type); //avtoboxing
                ps.executeUpdate();
            }

        {
            //calling rs.next() is mandatory
            while (rs.next()) System.out.println(rs.getString(1));
        }
    }
}
