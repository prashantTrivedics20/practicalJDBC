// with the help of the statement  object (JDBC)
import java.sql.*;
public class CRUD {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
        Statement st=con.createStatement();
       int i= st.executeUpdate("insert into mata.st values('prashant',49,97)");
       int i1=st.executeUpdate("insert into mata.st values('surendra',50,68)");// inserting
        // by this way
       System.out.println(i);
        //st.executeUpdate("delete from mata.st where rollno=49 ");// delete query in Statement object
        st.executeUpdate("update mata.st set marks=100 where name='surendra'");// update query..
        //st.executeUpdate("create table mata.student(rno int ,name varchar(20))");// create a table
       // st.executeUpdate("delete from mata.st where rollno=100 ");

       ResultSet rs=st.executeQuery("select*from mata.st");// fetching this way...

       while(rs.next())
        {
            System.out.println(rs.getString(1));
            System.out.println(rs.getInt(2));
            System.out.println(rs.getInt(3));

        }
       //to create a table we use


    }
}
