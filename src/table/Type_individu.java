/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jeremy
 */
public class Type_individu {
    public static void main(String[] args) throws Exception{
     createTable();
    }
    //@SuppressWarnings("empty-statement")
    public static void createTable() throws Exception{
     try{
         Connection con = getConnection();
         PreparedStatement create = (PreparedStatement) con.prepareStatement("CREATE TABLE IF NOT EXISTS Type_individu(TIN_CODE TINYINT(4) primary key, TIN_LIBELLE varchar(30) NULL)");
         create.executeUpdate();
     } catch(Exception e){System.out.println(e);} 
     finally{System.out.println("Fonction complete");}
    }
    public static Connection getConnection() throws Exception{
    try{
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/ppe2";
        String username = "root";
        String password = "";
        Class.forName(driver);
        
        Connection conn = DriverManager.getConnection(url,username,password);
        System.out.println("Connected");
        return conn;
    } catch(Exception e){System.out.println(e);}
        return null;
    }
    
}
