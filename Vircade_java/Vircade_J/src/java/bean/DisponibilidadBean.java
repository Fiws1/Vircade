
package bean;

import dao.DisponibilidadDAO;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.Disponibilidad;

@ManagedBean
@ApplicationScoped
public class DisponibilidadBean {
    private final DisponibilidadDAO disponibilidadDAO = new DisponibilidadDAO();
    private Disponibilidad disponibilidad = new Disponibilidad();
    private List<Disponibilidad> lstDisponibilidad;   
    
    public void listar(){
        lstDisponibilidad = disponibilidadDAO.listar();
    }   
    
    public void agregar(){
        disponibilidadDAO.agregar(disponibilidad);
        limpiar();
    }
    
    public void buscar(Disponibilidad d){
        disponibilidad = disponibilidadDAO.buscar(d);
    }
    
    public void limpiar(){
        disponibilidad = new Disponibilidad();
    }
    
    public void actualizar() throws SQLException {
        disponibilidadDAO.actualizar(disponibilidad);
        limpiar();
    }
    
    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad Disponibilidad) {
        this.disponibilidad = Disponibilidad;
    }

    public List<Disponibilidad> getLstDisponibilidad() {
        return lstDisponibilidad;
    }

    public void setLstDisponibilidad(List<Disponibilidad> lstDisponibilidad) {
        this.lstDisponibilidad = lstDisponibilidad;
    }
}