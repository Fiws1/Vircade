
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Modelo;

public class ModeloDAO extends DAO{
    private PreparedStatement ps;
    private ResultSet rs;
    
    public List<Modelo> listar(){
        List<Modelo> listaMode = null;
        
        try {
            ps = conectar().prepareStatement("SELECT * FROM Modelo");
            rs = ps.executeQuery();
            
            listaMode = new ArrayList();
            
            while(rs.next()){
                Modelo m = new Modelo();
                m.setId_modelo(rs.getInt("Id_modelo"));
                m.setModelo(rs.getInt("Modelo"));
                
                listaMode.add(m);
            }
        } catch (SQLException e) {
        }
        
        return listaMode;
    }
    public void agregar(Modelo mode){
        if(mode != null){
            try {
                String sql = "INSERT INTO Modelo (Modelo) VALUES(?)";
                ps = conectar().prepareStatement(sql);
                ps.setInt(1, mode.getModelo());
                
                ps.executeUpdate();
            } catch (SQLException e) {
            }
        }
    }
    
    public Modelo buscar(Modelo mode){
        Modelo m = null;
        
        try {
            String sql = "SELECT * FROM Modelo WHERE Id_modelo = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, mode.getId_modelo());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                m = new Modelo();
                m.setId_modelo(rs.getInt("Id_modelo"));
                m.setModelo(rs.getInt("Modelo"));
            }
            
        } catch (SQLException e) {
        }
        
        return m;
    }
    
    public Modelo buscar(int Id_modelo){
        Modelo m = null;
        
        try {
            String sql = "SELECT * FROM Modelo WHERE Id_modelo = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, Id_modelo);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                m = new Modelo();
                m.setId_modelo(rs.getInt("Id_modelo"));
                m.setModelo(rs.getInt("Modelo"));
            }
            
        } catch (SQLException e) {
        }
        
        return m;
    }
    
    public void actualizar(Modelo mode){
        try {
            String sql = "UPDATE Modelo SET Modelo = ? WHERE Id_modelo = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, mode.getModelo());
            ps.setInt(2, mode.getId_modelo());
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void eliminar(Modelo mode){
        try {
            ps = conectar().prepareStatement("DELETE FROM Modelo WHERE Id_modelo = ?");
            ps.setInt(1, mode.getId_modelo());
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
}