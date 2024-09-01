

package bean;

import dao.CombustibleDAO;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.Combustible;

@ManagedBean
@ApplicationScoped
public class CombustibleBean {
    private final CombustibleDAO comDAO = new CombustibleDAO();
    private Combustible combus = new Combustible();
    private List<Combustible> lstCombustible;   
    
    public void listar(){
        lstCombustible = comDAO.listar();
    }   
    
    public void agregar(){
        comDAO.agregar(combus);
        limpiar();
    }
    
    public void buscar(Combustible c){
        combus = comDAO.buscar(c);
    }
    
    public void limpiar(){
        combus = new Combustible();
    }
    
    public void actualizar() {
        comDAO.actualizar(combus);
        limpiar();
    }
    
    public void eliminar(Combustible c){
        comDAO.eliminar(c);
    }
    
    public Combustible getCombustible() {
        return combus;
    }

    public void setCombustible(Combustible Combustible) {
        this.combus = Combustible;
    }

    public List<Combustible> getLstCombustible() {
        return lstCombustible;
    }

    public void setLstCombustible(List<Combustible> lstCombustible) {
        this.lstCombustible = lstCombustible;
    }
}
