
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Marca;

public class MarcaDAO extends DAO {
    private PreparedStatement ps;
    private ResultSet rs;
    
    public List<Marca> listar(){
        List<Marca> listaMarca = null;
        
        try {
            ps = conectar().prepareStatement("SELECT * FROM Marca");
            rs = ps.executeQuery();
            
            listaMarca = new ArrayList();
            
            while(rs.next()){
                Marca m = new Marca();
                m.setId_marca(rs.getInt("Id_marca"));
                m.setMarca(rs.getString("Marca"));
                
                listaMarca.add(m);
            }
        } catch (SQLException e) {
        }
        
        return listaMarca;
    }
    public void agregar(Marca marca){
        if(marca != null){
            try {
                String sql = "INSERT INTO Marca (Marca) VALUES(?)";
                ps = conectar().prepareStatement(sql);
                ps.setString(1, marca.getMarca());
                
                ps.executeUpdate();
            } catch (SQLException e) {
            }
        }
    }
    
    public Marca buscar(Marca marca){
        Marca m = null;
        
        try {
            String sql = "SELECT * FROM Marca WHERE Id_marca = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, marca.getId_marca());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                m = new Marca();
                m.setId_marca(rs.getInt("Id_marca"));
                m.setMarca(rs.getString("Marca"));
            }
            
        } catch (SQLException e) {
        }
        
        return m;
    }
    
    public Marca buscar(int Id_marca){
        Marca m = null;
        
        try {
            String sql = "SELECT * FROM Marca WHERE Id_marca = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, Id_marca);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                m = new Marca();
                m.setId_marca(rs.getInt("Id_marca"));
                m.setMarca(rs.getString("Marca"));
            }
            
        } catch (SQLException e) {
        }
        
        return m;
    }
    
    public void actualizar(Marca marca){
        try {
            String sql = "UPDATE Marca SET Marca = ? WHERE Id_marca = ?";
            ps = conectar().prepareStatement(sql);
            ps.setString(1, marca.getMarca());
            ps.setInt(2, marca.getId_marca());
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void eliminar(Marca marca){
        try {
            ps = conectar().prepareStatement("DELETE FROM Marca WHERE Id_marca = ?");
            ps.setInt(1, marca.getId_marca());
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
}