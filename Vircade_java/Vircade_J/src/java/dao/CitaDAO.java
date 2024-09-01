
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cita;

public class CitaDAO extends DAO{
    private PreparedStatement ps;
    private ResultSet rs;
    private final ConcesionarioDAO conceDAO = new ConcesionarioDAO();
    private final UsuarioDAO usuDAO = new UsuarioDAO();
    
    public List<Cita> listar(){
        List<Cita> listaCita = null;
        
        try {
            ps = conectar().prepareStatement("SELECT * FROM Cita");
            rs = ps.executeQuery();
            
            listaCita = new ArrayList();
            
            while(rs.next()){
                Cita c = new Cita();
                c.setID(rs.getInt("ID"));
                c.setFecha(rs.getDate("Fecha"));
                c.setHora(rs.getTime("Hora"));
                c.setTipo_cita(rs.getString("Tipo_cita"));
                c.setCliente_relacionado(usuDAO.buscar(rs.getInt("Cliente_relacionado")));
                c.setConcesionario_Asig(conceDAO.buscar(rs.getInt("Concesionario_Asig")));
                
                listaCita.add(c);
            }
        } catch (SQLException e) {
        }
        
        return listaCita;
    }
    public void agregar(Cita cita){
        if(cita != null){
            try {
                String sql = "INSERT INTO Cita (Fecha, Hora, Tipo_cita, Cliente_relacionado, Concesionario_Asig) VALUES(?, ?, ?, ?, ?)";
                ps = conectar().prepareStatement(sql);
                ps.setDate(1, cita.getFecha());
                ps.setTime(2, cita.getHora());
                ps.setString(3, cita.getTipo_cita());
                ps.setString(3, cita.getCliente_relacionado());
                ps.setInt(3, cita.getConcesionario_Asig());
                
                ps.executeUpdate();
            } catch (SQLException e) {
            }
        }
    }
    
    public Cita buscar(Cita cita){
        Cita c = null;
        
        try {
            String sql = "SELECT * FROM Cita WHERE ID = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, cita.getID());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                c = new Cita();
                c.setID(rs.getInt("ID"));
                c.setFecha(rs.getDate("Fecha"));
                c.setHora(rs.getTime("Hora"));
                c.setTipo_cita(rs.getString("Tipo_cita"));
                c.setCliente_relacionado(usuDAO.buscar(rs.getString("Cliente_relacionado")));
                c.setConcesionario_Asig(conceDAO.buscar(rs.getInt("Concesionario_Asig")));
            } 
        } catch (SQLException e) {
        }
        
        return c;
    }
    
    public Cita buscar(int ID){
        Cita c = null;
        
        try {
            String sql = "SELECT * FROM Cita WHERE ID = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, ID);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                c = new Cita();
                c.setID(rs.getInt("ID"));
                c.setFecha(rs.getDate("Fecha"));
                c.setHora(rs.getTime("Hora"));
                c.setTipo_cita(rs.getString("Tipo_cita"));
                c.setCliente_relacionado(usuDAO.buscar(rs.getString("Cliente_relacionado"));
                c.setConcesionario_Asig(conceDAO.buscar(rs.getInt("Concesionario_Asig"));
            }
            
        } catch (SQLException e) {
        }
        
        return c;
    }
    
    public void actualizar(Cita cita){
        try {
            String sql = "UPDATE Cita SET Fecha = ?, Hora = ?, Tipo_cita = ?, Cliente_relacionado = ?, Concesionario_Asig = ? WHERE ID = ?";
            ps = conectar().prepareStatement(sql);
            ps.setDate(1, cita.getFecha());
            ps.setTime(2, cita.getHora());
            ps.setString(3, cita.getTipo_cita());
            ps.setString(4, cita.getCliente_relacionado());
            ps.setInt(5, cita.getConcesionario_Asig());
            ps.setInt(6, cita.getID());
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void eliminar(Cita cita){
        try {
            ps = conectar().prepareStatement("DELETE FROM Cita WHERE ID = ?");
            ps.setInt(1, cita.getID());
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
}