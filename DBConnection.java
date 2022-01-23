package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
    public static Connection dbConn;
    
        public static Connection getConnection()
        {
            Connection conn = null;
            try {
                String user = "scott"; 
                String pw = "tiger";
                String url = "jdbc:oracle:thin:@localhost:1521:orcl";
                
                Class.forName("oracle.jdbc.driver.OracleDriver");        
                conn = DriverManager.getConnection(url, user, pw);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conn;     
        }
		
}