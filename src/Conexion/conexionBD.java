package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class conexionBD {
     String DRIVER = "com.mysql.jdbc.Driver";
     String USUARIO = "root";
     String PASSWORD = "";
     String URL = "jdbc:mysql://localhost/biblioteca";
     static Connection con;
     
     public Connection getConexion ()
     {
         con=null;
         try
         {
           Class.forName(DRIVER);
           con=(Connection) DriverManager.getConnection(URL,USUARIO,PASSWORD);
           //JOptionPane.showMessageDialog(null, "Conexión establecida");
         }
         catch (Exception e)
         {
            JOptionPane.showMessageDialog(null, "Conexión No Establecida" + e.getMessage());
         }
         return null;
     
     }
    public void desconectar()
    {
        con=null;
        if(con == null)
           JOptionPane.showMessageDialog(null,"conexión terminada"); 
    }
}



            
