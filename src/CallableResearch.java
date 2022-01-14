import java.sql.*;

public class CallableResearch {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
        CallableStatement cs=con.prepareCall("{call s1()}");

        ResultSet rs=cs.executeQuery("select*from storedprocedure.check");
        cs.execute();

        while(rs.next())
        {
            System.out.println(rs.getString("name"));
            System.out.println(rs.getInt("rollno"));
            System.out.println(rs.getInt("marks"));
        }
    }
}
