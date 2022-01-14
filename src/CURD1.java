import java.sql.*;
import java.util.Scanner;

// with the help of the prepared statement.....
public class CURD1{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
        PreparedStatement ps=con.prepareStatement("insert into labpractical.name values(?,?,?,?)");

        Scanner readme=new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter the name");
            String a=readme.nextLine();
            System.out.println("Enter the rollno");
            int b=readme.nextInt();
            System.out.println("Ente the marks");
            int c=readme.nextInt();
            System.out.println("Enter the father name");
            String d=readme.next();
            ps.setString(1,a);// here we are set the value
            ps.setInt(2,b);
            ps.setInt(3,c);
            ps.setString(4,d);
            ps.executeUpdate();
            System.out.println("do you want add new recard");
            String s=readme.next();
            if(s.equals("no"))
            {
                break;
            }
            ps.close();
            con.close();
        }
        ResultSet rs=ps.executeQuery("select *from labpractical.name");
        while(rs.next())
        {
            System.out.println(rs.getString(1));
            System.out.println(rs.getInt(2));
            System.out.println(rs.getInt(3));
            System.out.println(rs.getString(4));
        }

    }

}
