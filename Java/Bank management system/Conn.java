package atm_sim;
import java.sql.*;

//Register driver
//Create connection
//Create statement
//Execute query
//Close connection

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///ATM","root",new Password().getPassword());
            s=c.createStatement();
        }catch(Exception e){}
        
    }
    public static void main(String[] args) {
        
    }
}
