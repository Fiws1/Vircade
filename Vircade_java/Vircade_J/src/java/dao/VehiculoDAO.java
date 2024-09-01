
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Vehiculo;

public class VehiculoDAO extends DAO{
    private PreparedStatement ps;
    private ResultSet rs;
    private final ModeloDAO ModeloDAO = new ModeloDAO();
    private final MarcaDAO MarcaDAO = new MarcaDAO();
    private final CombustibleDAO CombustibleDAO = new CombustibleDAO();
    private final Tipo_VehiculoDAO Tipo_VehiculoDAO = new Tipo_VehiculoDAO();
    private final ConcesionarioDAO ConcesionarioDAO = new ConcesionarioDAO();
    
    public List<Vehiculo> listar(){
        List<Vehiculo> listaVehiculo = null;
        
        try {
            ps = conectar().prepareStatement("SELECT * FROM Vehiculo");
            rs = ps.executeQuery();
            
            listaVehiculo = new ArrayList();
            
            while(rs.next()){
                Vehiculo v = new Vehiculo();
                v.setId_Vehiculo(rs.getInt("Id_Vehiculo"));
                v.setVehiculo(rs.getString("Vehiculo"));
                v.setLinea(rs.getString("Linea"));
                v.setCilindraje(rs.getString("cilindraje"));
                v.setColor(rs.getString("Color"));
                v.setPrecio(rs.getInt("Precio"));
                v.setImagen(rs.getBlob("Imagen"));
                v.setModelo_vehiculo(rs.getInt("Modelo_vehiculo"));
                v.setMarca_vehiculo(rs.getInt("Marca_vehiculo"));
                v.setCombustible_vehiculo(rs.getInt("Combustible_vehiculo"));
                v.setTipo_vehiculo(rs.getInt("Tipo_vehiculo"));
                v.setModelo(ModeloDAO.buscar(rs.getInt("ModeloDAO")));
                v.setMarca(MarcaDAO.buscar(rs.getInt("MarcaDAO")));
                v.setCombustible(CombustibleDAO.buscar(rs.getInt("CombustibleDAO")));
                v.setID_Tipo_Vehiculo(Tipo_VehiculoDAO.buscar(rs.getInt("ID_Tipo_VehiculoDAO")));
                v.setID_Concesionario(ConcesionarioDAO.buscar(rs.getInt("ID_Concesionario")));
                
                listaVehiculo.add(v);
            }
        } catch (SQLException e) {
        }
        
        return listaVehiculo;
    }
    public void agregar(Vehiculo vehi){
        if(vehi != null){
            try {
                String sql = "INSERT INTO Vehiculo (Vehiculo, Linea, cilindraje, Color, Precio, Imagen, Modelo_vehiculo, Marca_vehiculo, Combustible_vehiculo, Tipo_vehiculo, concesionario) "
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?)";
                ps = conectar().prepareStatement(sql);
                ps.setString(1, vehi.getVehiculo());
                ps.setString(2, vehi.getLinea());
                ps.setString(3, vehi.getCilindraje());
                ps.setString(4, vehi.getColor());
                ps.setInt(5, vehi.getPrecio());
                ps.setBlob(6, vehi.getImagen());
                ps.setInt(7, vehi.getModelo_vehiculo());
                ps.setInt(8, vehi.getMarca_vehiculo());
                ps.setInt(9, vehi.getCombustible_vehiculo());
                ps.setInt(10, vehi.getTipo_vehiculo());
                ps.setInt(11, vehi.getConcesionario());
                
                ps.executeUpdate();
            } catch (SQLException e) {
            }
        }
    }
    
    public Vehiculo buscar(Vehiculo vehi){
        Vehiculo v = null;
        
        try {
            String sql = "SELECT * FROM Vehiculo WHERE Id_Vehiculo = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, vehi.getId_Vehiculo());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                v = new Vehiculo();
                v.setId_Vehiculo(rs.getInt("Id_Vehiculo"));
                v.setVehiculo(rs.getString("Vehiculo"));
                v.setLinea(rs.getString("Linea"));
                v.setCilindraje(rs.getString("cilindraje"));
                v.setColor(rs.getString("Color"));
                v.setPrecio(rs.getInt("Precio"));
                v.setImagen(rs.getBlob("Imagen"));
                v.setModelo_vehiculo(rs.getInt("Modelo_vehiculo"));
                v.setMarca_vehiculo(rs.getInt("Marca_vehiculo"));
                v.setCombustible_vehiculo(rs.getInt("Combustible_vehiculo"));
                v.setTipo_vehiculo(rs.getInt("Tipo_vehiculo"));
                v.setModelo(ModeloDAO.buscar(rs.getInt("ModeloDAO")));
                v.setMarca(MarcaDAO.buscar(rs.getInt("MarcaDAO")));
                v.setCombustible(CombustibleDAO.buscar(rs.getInt("CombustibleDAO")));
                v.setID_Tipo_Vehiculo(Tipo_VehiculoDAO.buscar(rs.getInt("ID_Tipo_VehiculoDAO")));
                v.setID_Concesionario(ConcesionarioDAO.buscar(rs.getInt("ID_Concesionario")));
            
            }
            
        } catch (SQLException e) {
        }
        
        return v;
    }
    
    public Vehiculo buscar(int Id_Vehiculo){
        Vehiculo v = null;
        
        try {
            String sql = "SELECT * FROM Vehiculo WHERE Id_Vehiculo = ?";
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, Id_Vehiculo);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                v = new Vehiculo();
                v.setId_Vehiculo(rs.getInt("Id_Vehiculo"));
                v.setVehiculo(rs.getString("Vehiculo"));
                v.setLinea(rs.getString("Linea"));
                v.setCilindraje(rs.getString("cilindraje"));
                v.setColor(rs.getString("Color"));
                v.setPrecio(rs.getInt("Precio"));
                v.setImagen(rs.getBlob("Imagen"));
                v.setModelo_vehiculo(rs.getInt("Modelo_vehiculo"));
                v.setMarca_vehiculo(rs.getInt("Marca_vehiculo"));
                v.setCombustible_vehiculo(rs.getInt("Combustible_vehiculo"));
                v.setTipo_vehiculo(rs.getInt("Tipo_vehiculo"));
                v.setModelo(ModeloDAO.buscar(rs.getInt("ModeloDAO")));
                v.setMarca(MarcaDAO.buscar(rs.getInt("MarcaDAO")));
                v.setCombustible(CombustibleDAO.buscar(rs.getInt("CombustibleDAO")));
                v.setID_Tipo_Vehiculo(Tipo_VehiculoDAO.buscar(rs.getInt("ID_Tipo_VehiculoDAO")));
                v.setID_Concesionario(ConcesionarioDAO.buscar(rs.getInt("ID_Concesionario")));
            }
            
        } catch (SQLException e) {
        }
        
        return v;
    }
    
    public void actualizar(Vehiculo vehi){
        try {
            String sql = "UPDATE Vehiculo SET Vehiculo = ?, Linea = ?, cilindraje = ?, Color = ?, Precio = ?, Imagen = ?, Modelo_vehiculo = ?, Marca_vehiculo = ?, Combustible_vehiculo = ?, Tipo_vehiculo = ?, concesionario = ?"
                    + "WHERE Id_Vehiculo = ?";
            ps = conectar().prepareStatement(sql);
            ps.setString(1, vehi.getVehiculo());
            ps.setString(2, vehi.getLinea());
            ps.setString(3, vehi.getCilindraje());
            ps.setString(4, vehi.getColor());
            ps.setInt(5, vehi.getPrecio());
            ps.setBlob(6, vehi.getImagen());
            ps.setInt(7, vehi.getModelo_vehiculo());
            ps.setInt(8, vehi.getMarca_vehiculo());
            ps.setInt(9, vehi.getCombustible_vehiculo());
            ps.setInt(10, vehi.getTipo_vehiculo());
            ps.setInt(11, vehi.getConcesionario());
            ps.setInt(12, vehi.getId_Vehiculo());
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void eliminar(Vehiculo vehi){
        try {
            ps = conectar().prepareStatement("DELETE FROM Vehiculo WHERE Id_Vehiculo = ?");
            ps.setInt(1, vehi.getId_Vehiculo());
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
}