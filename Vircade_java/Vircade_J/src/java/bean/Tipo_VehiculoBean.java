
package bean;

import dao.Tipo_VehiculoDAO;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.Tipo_Vehiculo;

@ManagedBean
@ApplicationScoped
public class Tipo_VehiculoBean {
    private final Tipo_VehiculoDAO tipo_vehiculoDAO = new Tipo_VehiculoDAO();
    private Tipo_Vehiculo tipo_vehiculo = new Tipo_Vehiculo();
    private List<Tipo_Vehiculo> lstTipo_Vehiculo;   
    
    public void listar(){
        lstTipo_Vehiculo = tipo_vehiculoDAO.listar();
    }   
    
    public void agregar(){
        tipo_vehiculoDAO.agregar(tipo_vehiculo);
        limpiar();
    }
    
    public void buscar(Tipo_Vehiculo t){
        tipo_vehiculo = tipo_vehiculoDAO.buscar(t);
    }
    
    public void limpiar(){
        tipo_vehiculo = new Tipo_Vehiculo();
    }
    
    public void actualizar() {
        tipo_vehiculoDAO.actualizar(tipo_vehiculo);
        limpiar();
    }
    
    public void eliminar(Tipo_Vehiculo t){
        tipo_vehiculoDAO.eliminar(t);
    }
    
    public Tipo_Vehiculo getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(Tipo_Vehiculo Tipo_vehiculo) {
        this.tipo_vehiculo = Tipo_vehiculo;
    }

    public List<Tipo_Vehiculo> getLstTipo_vehiculo() {
        return lstTipo_Vehiculo;
    }

    public void setLstTipo_vehiculo(List<Tipo_Vehiculo> lstTipo_vehiculo) {
        this.lstTipo_Vehiculo = lstTipo_vehiculo;
    }
}