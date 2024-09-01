
package bean;

import dao.CitaDAO;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.Cita;

@ManagedBean
@ApplicationScoped
public class CitaBean {
    private final CitaDAO citaDAO = new CitaDAO();
    private Cita cita = new Cita();
    private List<Cita> lstCita;   
    
    public void listar(){
        lstCita = citaDAO.listar();
    }   
    
    public void agregar(){
        citaDAO.agregar(cita);
        limpiar();
    }
    
    public void buscar(Cita c){
        cita = citaDAO.buscar(c);
    }
    
    public void limpiar(){
        cita = new Cita();
    }
    
    public void actualizar() throws SQLException{
        citaDAO.actualizar(cita);
        limpiar();
    }
    
    public void eliminar(Cita c){
        citaDAO.eliminar(c);
    }
    
    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita Cita) {
        this.cita = Cita;
    }

    public List<Cita> getLstCita() {
        return lstCita;
    }

    public void setLstCita(List<Cita> lstCita) {
        this.lstCita = lstCita;
    }
}
