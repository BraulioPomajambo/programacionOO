
package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SQLusuarios extends conexionBD {
    public boolean registrar(usuarios usr)
    {
    PreparedStatement ps =null;
    Connection cont = getConexion();
    
    String sql =" INSERT INTO usuarios (id,usuario, password,nombre,apellido,rol_id) VALUES(?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(2, usr.getUsuario());
            ps.setString(3, usr.getPassword());
            ps.setString(4, usr.getNombre());
            ps.setString(5, usr.getApellido());
            ps.setInt(1, usr.getId());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean frmLogin1(usuarios usr) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection cont= getConexion();
        
        String sql = "SELECT id, usuario, password, nombre, apellido, rol_id, nombre FROM usuarios WHERE usuario=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();

            if(rs.next())
            {
                if(usr.getPassword().equals(rs.getString(3))) {

                    usr.setId(rs.getInt(1));
                    usr.setNombre(rs.getString(4));
                    usr.setRol_id(rs.getInt(6));
                    usr.setNombre_tipo(rs.getString(7));
                    return true;
                } else {
                    return false;
                }

            }
            return false;
        }catch (SQLException ex) {
                Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
}

