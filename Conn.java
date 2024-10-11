package projector.management.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///projectormanagementsystem","root","ayushi12345");
            s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }   
    }   
}
