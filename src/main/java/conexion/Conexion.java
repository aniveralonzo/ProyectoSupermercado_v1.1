/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
/**
 *
 * @author user hp
 */
public class Conexion {
    private static BasicDataSource dataSource=null;

    private static DataSource getDataSource(){
         if(dataSource==null){
            dataSource=new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUsername("root");
            dataSource.setPassword("Sadmywaleska2020");
            dataSource.setUrl("jdbc:mysql://localhost:3306/crud");
            dataSource.setInitialSize(20);
            dataSource.setMaxIdle(15);
            dataSource.setMaxTotal(20);
            dataSource.setMaxWaitMillis(5000);
        
        }
        return dataSource;
    
    }
    
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();    
    }
    
    
}
