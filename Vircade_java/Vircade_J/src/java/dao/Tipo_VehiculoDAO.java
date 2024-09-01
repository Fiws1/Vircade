package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Tipo_Vehiculo;

public class Tipo_VehiculoDAO extends DAO{
    private PreparedStatement ps;
    private ResultSet rs;
    
    public List<Tipo_Vehiculo> listar(){
        List<Tipo_Vehiculo> listaTipo_Vehiculo = null;
        
        try {
            ps = conectar().prepareStatement("SELECT * FROM Tipo_Vehiculo");
            rs = ps.executeQuery();
            
            listaTipo_Vehiculo = new ArrayList();
            
            while(rs.next()){
                Tipo_Vehiculo tv = new Tipo_Vehiculo();
                tv.setId_tipo_vehiculo(rs.getInt("Id_tipo_vehiculo"));
                tv.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
                
                listaTipo_Vehiculo.add(tv);
            }
        } catch (SQLException e) {
        }
        
        return listaTipo_Vehiculo;
    }
    public void agregar(Tipo_Vehiculo Tipo_v){
        if(Tipo_v != null){
            try {
                String sql = "INSERT INTO Tipo_Vehiculo (Tipo_Vehiculo) VALUES(?)";
                ps = conectar().prepareStatement(sql);
                ps.setString(1, Tipo_v.getTipo_vehiculo());
                
                ps.executeUpdate();
            } catch (SQLException e) {
            }
        }
    }
    
    public Tipo_Vehiculo buscar(Tipo_Vehiculo Tipo_v){
        Tipo_Vehiculo t = null;
        
        try {
            String sql = "SELECT * FROM Tipo_Vehiculo WHERE Id_tipo_vehiculo = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, Tipo_v.getId_tipo_vehiculo());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                t = new Tipo_Vehiculo();
                t.setId_tipo_vehiculo(rs.getInt("Id_tipo_vehiculo"));
                t.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
            }
            
        } catch (SQLException e) {
        }
        
        return t;
    }
    
    public Tipo_Vehiculo buscar(int Id_tipo_vehiculo){
        Tipo_Vehiculo m = null;
        
        try {
            String sql = "SELECT * FROM Tipo_Vehiculo WHERE Id_tipo_vehiculo = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, Id_tipo_vehiculo);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                m = new Tipo_Vehiculo();
                m.setId_tipo_vehiculo(rs.getInt("Id_tipo_vehiculo"));
                m.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
            }
            
        } catch (SQLException e) {
        }
        
        return m;
    }
    
    public void actualizar(Tipo_Vehiculo Tipo_v){
        try {
            String sql = "UPDATE Tipo_Vehiculo SET tipo_vehiculo = ? WHERE Id_tipo_vehiculo = ?";
            ps = conectar().prepareStatement(sql);
            ps.setString(1, Tipo_v.getTipo_vehiculo());
            ps.setInt(2, Tipo_v.getId_tipo_vehiculo());
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void eliminar(Tipo_Vehiculo Tipo_v){
        try {
            ps = conectar().prepareStatement("DELETE FROM Tipo_Vehiculo WHERE Id_tipo_vehiculo = ?");
            ps.setInt(1, Tipo_v.getId_tipo_vehiculo());
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
}