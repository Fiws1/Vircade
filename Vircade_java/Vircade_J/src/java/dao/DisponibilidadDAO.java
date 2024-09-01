package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Disponibilidad;

public class DisponibilidadDAO extends DAO{
    private PreparedStatement ps;
    private ResultSet rs;

    // Método para obtener una lista de disponibilidades
    public List<Disponibilidad> listar() {
        List<Disponibilidad> listaDispo = null;
        
        try {
            String sql = "SELECT * FROM Disponibilidad";
            ps = conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            
            listaDispo = new ArrayList();
            
            while (rs.next()) {
                Disponibilidad d = new Disponibilidad();
                d.setId_Dispo(rs.getInt("Id_dispo"));
                d.setDisponibilidad(rs.getString("Disponibilidad"));
                
                listaDispo.add(d);
            }
        }catch (SQLException e) {
        }

        return listaDispo;
    }
    
    // Método para insertar una nueva disponibilidad
    public void agregar(Disponibilidad dispo) {
        if (dispo != null){
            try {
                String sql = "INSERT INTO Disponibilidad (Disponibilidad) "
                        + "VALUES (?)";
                ps = conectar().prepareStatement(sql);
                rs = ps.executeQuery();
                ps.setString(1, dispo.getDisponibilidad());
                ps.executeUpdate();
            }catch (SQLException e) {
            
            }
        }
    }
    public Disponibilidad buscar(Disponibilidad dispo){
        Disponibilidad d = null;
        
        try {
            String sql =  "SELECT * FROM Disponibilidad WHERE Id_dispo = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, dispo.getId_Dispo());
            rs = ps.executeQuery();
            
            if(rs.next()){
                d = new Disponibilidad();
                d.setId_Dispo(rs.getInt("Id_dispo"));
                d.setDisponibilidad(rs.getString("Disponibilidad"));
            }
        } catch (SQLException e) {
        }        
        return d;
    }
    
    public Disponibilidad buscar(int Id_dispo){
        Disponibilidad d = null;
        
        try {
            String sql =  "SELECT * FROM Disponibilidad WHERE Id_dispo = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, Id_dispo);
            rs = ps.executeQuery();
            
            if(rs.next()){
                d = new Disponibilidad();
                d.setId_Dispo(rs.getInt("Id_dispo"));
                d.setDisponibilidad(rs.getString("Disponibilidad"));
            }
        } catch (SQLException e) {
        }        
        return d;
    }

    // Método para actualizar una disponibilidad existente
    public void actualizar(Disponibilidad dispo) throws SQLException {
        try {
            String sql = "UPDATE Disponibilidad SET Disponibilidad = ? WHERE Id_dispo = ?";
            ps = conectar().prepareStatement(sql);
            ps.setString(1, dispo.getDisponibilidad());
            ps.setInt(2, dispo.getId_Dispo());
            ps.executeUpdate();
        }catch(SQLException e){
        }
    }
}
