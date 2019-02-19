
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ivan Jaramillo
 */
public class ConsultasProducto extends Conexion{
    
    public boolean registrar(Producto product){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql ="insert into producto (codigo,nombre,precio,cantidad) values(?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, product.getCodigo());
            ps.setString(2, product.getNombre());
            ps.setDouble(3, product.getPrecio());
            ps.setInt(4, product.getCantidad());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);

            }
        }
    }
    
    public boolean modificar(Producto product){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql ="update producto set codigo=?,nombre=?,precio=?,cantidad=? where id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, product.getCodigo());
            ps.setString(2, product.getNombre());
            ps.setDouble(3, product.getPrecio());
            ps.setInt(4, product.getCantidad());
            ps.setInt(5, product.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);

            }
        }
    }
    
    public boolean eliminar(Producto product){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql ="delete from producto where id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, product.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);

            }
        }
    }
    
    public boolean buscar(Producto product){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql ="select * from producto where codigo=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, product.getCodigo());
            rs = ps.executeQuery();
            
            if(rs.next()){
                product.setId(Integer.parseInt(rs.getString("id")));
                product.setCodigo(rs.getString("codigo"));
                product.setNombre(rs.getString("nombre"));
                product.setPrecio(Double.parseDouble(rs.getString("precio")));
                product.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);

            }
        }
    }
}
