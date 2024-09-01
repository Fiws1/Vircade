package bean;

import dao.ModeloDAO;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.Modelo;

@ManagedBean
@ApplicationScoped
public class ModeloBean {
    private final ModeloDAO modelDAO = new ModeloDAO();
    private Modelo modelo = new Modelo();
    private List<Modelo> lstModelo;   
    
    public void listar(){
        lstModelo = modelDAO.listar();
    }   
    
    public void agregar(){
        modelDAO.agregar(modelo);
        limpiar();
    }
    
    public void buscar(Modelo m){
        modelo = modelDAO.buscar(m);
    }
    
    public void limpiar(){
        modelo = new Modelo();
    }
    
    public void actualizar() {
        modelDAO.actualizar(modelo);
        limpiar();
    }
    
    public void eliminar(Modelo m){
        modelDAO.eliminar(m);
    }
    
    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo Modelo) {
        this.modelo = Modelo;
    }

    public List<Modelo> getLstModelo() {
        return lstModelo;
    }

    public void setLstAsesor(List<Modelo> lstModelo) {
        this.lstModelo = lstModelo;
    }
}
