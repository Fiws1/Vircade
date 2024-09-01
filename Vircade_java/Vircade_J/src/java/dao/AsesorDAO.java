
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Asesor;

public class AsesorDAO extends DAO{
    private PreparedStatement ps;
    private ResultSet rs;
    private final ConcesionarioDAO conceDAO = new ConcesionarioDAO();
    
    public List<Asesor> listar(){
        List<Asesor> listaAser = null;
        
        try {
            ps = conectar().prepareStatement("SELECT * FROM Asesor");
            rs = ps.executeQuery();
            
            listaAser = new ArrayList();
            
            while(rs.next()){
                Asesor a = new Asesor();
                a.setId_Asesor(rs.getInt("Id asesor"));
                a.setP_nom_asesor(rs.getString("Primer nombre asesor"));
                a.setS_nom_asesor(rs.getString("Segundo nombre asesor"));
                a.setP_ape_asesor(rs.getString("Primer apellido asesor"));
                a.setS_ape_asesor(rs.getString("Segundo apellido asesor"));
                a.setCorreo_asesor(rs.getString("Correo"));
                a.setTelefono_asesor(rs.getInt("telefono"));
                a.setConcesionario(conceDAO.buscar(rs.getInt("Concesionario_Asig")));
                
                listaAser.add(a);
            }
        } catch (SQLException e) {
        }
        
        return listaAser;
    }
    // Método para insertar una nueva disponibilidad
    public void agregar(Asesor a) {
        if (a != null){
            try {
                String sql = "INSERT INTO Asesor (p_nom_asesor, s_nom_asesor, p_ape_asesor, s_ape_asesor, Correo_asesor, Telefono_asesor, Concesionario_Asig) "
                        + "VALUES (?,?,?,?,?,?)";
                ps = conectar().prepareStatement(sql);
                rs = ps.executeQuery();
                ps.setString(1, a.getP_nom_asesor());
                ps.setString(2, a.getS_nom_asesor());
                ps.setString(3, a.getP_ape_asesor());
                ps.setString(4, a.getS_ape_asesor());
                ps.setString(5, a.getCorreo_asesor());
                ps.setInt(6, a.getTelefono_asesor());
                ps.setInt(7, a.getConcesionario_Asig());
                ps.executeUpdate();
            }catch (SQLException e) {
            
            }
        }
    }
    
    public Asesor buscar(Asesor prod){
        Asesor c = null;
        
        try {
            String sql = "SELECT * FROM Asesor WHERE Id_Asesor = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, prod.getId_Asesor());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                Asesor a = new Asesor();
                a.setId_Asesor(rs.getInt("Id asesor"));
                a.setP_nom_asesor(rs.getString("Primer nombre asesor"));
                a.setS_nom_asesor(rs.getString("Segundo nombre asesor"));
                a.setP_ape_asesor(rs.getString("Primer apellido asesor"));
                a.setS_ape_asesor(rs.getString("Segundo apellido asesor"));
                a.setCorreo_asesor(rs.getString("Correo"));
                a.setTelefono_asesor(rs.getInt("telefono"));
                a.setID_Disponibilidad(conceDAO.buscar(rs.getInt("Id_dispo")));
            }
            
        } catch (SQLException e) {
        }
        
        return c;
    }
    
    public Asesor buscar(int Id_Concesionario){
        Asesor a = null;
        
        try {
            String sql = "SELECT * FROM Asesor WHERE Id_Asesor = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, Id_Concesionario);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                a = new Asesor();
                a.setId_Asesor(rs.getInt("Id asesor"));
                a.setP_nom_asesor(rs.getString("Primer nombre asesor"));
                a.setS_nom_asesor(rs.getString("Segundo nombre asesor"));
                a.setP_ape_asesor(rs.getString("Primer apellido asesor"));
                a.setS_ape_asesor(rs.getString("Segundo apellido asesor"));
                a.setCorreo_asesor(rs.getString("Correo"));
                a.setTelefono_asesor(rs.getInt("telefono"));
                a.setConcesionario(conceDAO.buscar(rs.getInt("Concesionario id")));
                }
            
        } catch (SQLException e) {
        }
        
        return a;
    }

    // Método para actualizar una disponibilidad existente
    public void actualizar(Asesor a) throws SQLException {
        try {
            String sql = "UPDATE Asesor SET p_nom_asesor = ?, s_nom_asesor = ?, p_ape_asesor = ?, s_ape_asesor = ?, Correo_asesor = ?, Telefono_asesor = ?, Concesionario_Asig = ? WHERE Id_Asesor = ?";
            ps = conectar().prepareStatement(sql);
            ps.setString(1, a.getP_nom_asesor());
            ps.setString(2, a.getS_nom_asesor());
            ps.setString(3, a.getP_ape_asesor());
            ps.setString(4, a.getS_ape_asesor());
            ps.setString(5, a.getCorreo_asesor());
            ps.setInt(6, a.getTelefono_asesor());
            ps.setInt(7, a.getConcesionario_Asig());
            ps.setInt(8, a.getId_Asesor());
            ps.executeUpdate();
        }catch(SQLException e){
        }
    }

    // Método para obtener una lista de disponibilidades
    public void eliminar(Asesor a){
        try {
            ps = conectar().prepareStatement("DELETE FROM Asesor WHERE Id_Asesor = ?");
            ps.setInt(1, a.getId_Asesor());
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
}