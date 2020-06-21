package conexion;
        
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection con;
    public Conexion(){
        try{
//            class.forName("com.mysql.jdbc.Driver");
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","Sadmywaleska2020");        
        }catch(Exception e){
            System.out.println("Error conexion a basse de datos"+e);
        }
    }
        
        public static Connection getConnection(){
            return con;
    }    
}