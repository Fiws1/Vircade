
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Combustible;

public class CombustibleDAO extends DAO{
    private PreparedStatement ps;
    private ResultSet rs;
    
    public List<Combustible> listar(){
        List<Combustible> listaCombus = null;
        
        try {
            ps = conectar().prepareStatement("SELECT * FROM Combustible");
            rs = ps.executeQuery();
            
            listaCombus = new ArrayList();
            
            while(rs.next()){
                Combustible c = new Combustible();
                c.setId_combustible(rs.getInt("Id combustible"));
                c.setTipo_combustible(rs.getString("Tipo combustible"));
                
                listaCombus.add(c);
            }
        } catch (SQLException e) {
        }
        
        return listaCombus;
    }
    public void agregar(Combustible combus){
        if(combus != null){
            try {
                String sql = "INSERT INTO Combustible (Tipo_combustible) VALUES(?)";
                ps = conectar().prepareStatement(sql);
                ps.setString(1, combus.getTipo_combustible());
                
                ps.executeUpdate();
            } catch (SQLException e) {
            }
        }
    }
    
    public Combustible buscar(Combustible combus){
        Combustible c = null;
        
        try {
            String sql = "SELECT * FROM Combustible WHERE Id_combistible = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, combus.getId_combustible());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                c = new Combustible();
                c.setId_combustible(rs.getInt("Id_combustible"));
                c.setTipo_combustible(rs.getString("Tipo_combustible"));
            }
            
        } catch (SQLException e) {
        }
        
        return c;
    }
    
    public Combustible buscar(int Id_combustible){
        Combustible c = null;
        
        try {
            String sql = "SELECT * FROM Combustible WHERE Id_combustible = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, Id_combustible);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                c = new Combustible();
                c.setId_combustible(rs.getInt("Id_combustible"));
                c.setTipo_combustible(rs.getString("Tipo_combustible"));
            }
            
        } catch (SQLException e) {
        }
        
        return c;
    }
    
    public void actualizar(Combustible combus){
        try {
            String sql = "UPDATE Combustible SET Tipo_combustible = ? WHERE Id_combustible = ?";
            ps = conectar().prepareStatement(sql);
            ps.setString(1, combus.getTipo_combustible());
            ps.setInt(2, combus.getId_combustible());
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void eliminar(Combustible combus){
        try {
            ps = conectar().prepareStatement("DELETE FROM Combustible WHERE Id_combustible = ?");
            ps.setInt(1, combus.getId_combustible());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
}