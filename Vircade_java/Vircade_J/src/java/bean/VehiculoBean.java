package bean;

import dao.VehiculoDAO;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.Vehiculo;

@ManagedBean
@ApplicationScoped
public class VehiculoBean {
    private final VehiculoDAO vehiDAO = new VehiculoDAO();
    private Vehiculo vehi = new Vehiculo();
    private List<Vehiculo> lstVehiculo;   
    
    public void listar(){
        lstVehiculo = vehiDAO.listar();
    }   
    
    public void agregar(){
        vehiDAO.agregar(vehi);
        limpiar();
    }
    
    public void buscar(Vehiculo v){
        vehi = vehiDAO.buscar(v);
    }
    
    public void limpiar(){
        vehi = new Vehiculo();
    }
    
    public void actualizar() {
        vehiDAO.actualizar(vehi);
        limpiar();
    }
    
    public void eliminar(Vehiculo v){
        vehiDAO.eliminar(v);
    }
    
    public Vehiculo getVehiculo() {
        return vehi;
    }

    public void setVehiculo(Vehiculo Vehiculo) {
        this.vehi = Vehiculo;
    }

    public List<Vehiculo> getLstVehiculo() {
        return lstVehiculo;
    }

    public void setLstAsesor(List<Vehiculo> lstVehiculo) {
        this.lstVehiculo = lstVehiculo;
    }
}
