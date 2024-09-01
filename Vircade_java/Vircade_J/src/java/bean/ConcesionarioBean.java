
package bean;

import dao.ConcesionarioDAO;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.Concesionario;

@ManagedBean
@ApplicationScoped
public class ConcesionarioBean {
    private final ConcesionarioDAO conceDAO = new ConcesionarioDAO();
    private Concesionario conce = new Concesionario();
    private List<Concesionario> lstConcesionario;   
    
    public void listar(){
        lstConcesionario = conceDAO.listar();
    }   
    
    public void agregar(){
        conceDAO.agregar(conce);
        limpiar();
    }
    
    public void buscar(Concesionario c){
        conce = conceDAO.buscar(c);
    }
    
    public void limpiar(){
        conce = new Concesionario();
    }
    
    public void actualizar() {
        conceDAO.actualizar(conce);
        limpiar();
    }
    
    public void eliminar(Concesionario c){
        conceDAO.eliminar(c);
    }
    
    public Concesionario getConcesionario() {
        return conce;
    }

    public void setConcesionario(Concesionario Concesionario) {
        this.conce = Concesionario;
    }

    public List<Concesionario> getLstConcesionario() {
        return lstConcesionario;
    }

    public void setLstConcesionario(List<Concesionario> lstConcesionario) {
        this.lstConcesionario = lstConcesionario;
    }
}

