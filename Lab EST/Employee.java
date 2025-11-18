import java.util.*;
import java.sql.*;

public class Employee{
    public static void main(String [] args){
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String user = "root";
        String password = "@M@Nr@m0";

        try(Connection conn = DriverManager.getConnection(url, user, password)){
            // Statement stmt = conn.createStatement();

            // ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

            // while(rs.next()){
            //     System.out.println("Name:"+rs.getString("name")+" EmpId:"+rs.getInt("empid"));
                
            // }

            PreparedStatement pstmt = conn.prepareStatement("Insert into employee(name, empid) values(?,?)") ;
            
            // stmt.close();
            conn.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}