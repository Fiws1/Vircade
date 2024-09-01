
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Concesionario;

public class ConcesionarioDAO extends DAO{
    private PreparedStatement ps;
    private ResultSet rs;
    private final DisponibilidadDAO dispoDAO = new DisponibilidadDAO();
    
    public List<Concesionario> listar(){
        List<Concesionario> listaConce = null;
        
        try {
            ps = conectar().prepareStatement("SELECT * FROM Concesionario");
            rs = ps.executeQuery();
            
            listaConce = new ArrayList();
            
            while(rs.next()){
                Concesionario c = new Concesionario();
                c.setId_Concesionario(rs.getInt("Id_Concesionario"));
                c.setConcesionario(rs.getString("Concesionario"));
                c.setDireccion(rs.getString("Direccion"));
                c.setDisponibilidad(rs.getInt("Disponibilidad"));
                c.setID_Disponibilidad(dispoDAO.buscar(rs.getInt("Id_dispo")));
                
                listaConce.add(c);
            }
        } catch (SQLException e) {
        }
        
        return listaConce;
    }
    public void agregar(Concesionario conce){
        if(conce != null){
            try {
                String sql = "INSERT INTO Concesionario (Concesionario, Direccion, Disponibilidad) VALUES(?, ?, ?)";
                ps = conectar().prepareStatement(sql);
                ps.setString(1, conce.getConcesionario());
                ps.setString(2, conce.getDireccion());
                ps.setInt(3, conce.getDisponibilidad());
                
                ps.executeUpdate();
            } catch (SQLException e) {
            }
        }
    }
    
    public Concesionario buscar(Concesionario conce){
        Concesionario c = null;
        
        try {
            String sql = "SELECT * FROM Concesionario WHERE Id_Concesionario = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, conce.getId_Concesionario());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                c = new Concesionario();
                c.setId_Concesionario(rs.getInt("Id_Concesionario"));
                c.setConcesionario(rs.getString("Concesionario"));
                c.setDireccion(rs.getString("Direccion"));
                c.setDisponibilidad(rs.getInt("Disponibilidad"));
                
                c.setID_Disponibilidad(dispoDAO.buscar(rs.getInt("Id_dispo")));
            }
            
        } catch (SQLException e) {
        }
        
        return c;
    }
    
    public Concesionario buscar(int Id_Concesionario){
        Concesionario c = null;
        
        try {
            String sql = "SELECT * FROM Concesionario WHERE Id_Concesionario = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, Id_Concesionario);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                c = new Concesionario();
                c.setId_Concesionario(rs.getInt("Id_Concesionario"));
                c.setConcesionario(rs.getString("Concesionario"));
                c.setDireccion(rs.getString("Direccion"));
                c.setDisponibilidad(rs.getInt("Disponibilidad"));
                c.setID_Disponibilidad(dispoDAO.buscar(rs.getInt("Id_dispo")));
            }
            
        } catch (SQLException e) {
        }
        
        return c;
    }
    
    public void actualizar(Concesionario conce){
        try {
            String sql = "UPDATE Concesionario SET Concesionario = ?, Direccion = ?, Disponibilidad = ? WHERE Id_Concesionario = ?";
            ps = conectar().prepareStatement(sql);
            ps.setString(1, conce.getConcesionario());
            ps.setString(2, conce.getDireccion());
            ps.setInt(3, conce.getDisponibilidad());
            ps.setInt(4, conce.getId_Concesionario());
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void eliminar(Concesionario conce){
        try {
            ps = conectar().prepareStatement("DELETE FROM Concesionario WHERE Id_Concesionario = ?");
            ps.setInt(1, conce.getId_Concesionario());
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
}