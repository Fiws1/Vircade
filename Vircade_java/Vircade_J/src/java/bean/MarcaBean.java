package bean;

import dao.MarcaDAO;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.Marca;

@ManagedBean
@ApplicationScoped
public class MarcaBean {
    private final MarcaDAO marcaDAO = new MarcaDAO();
    private Marca marca = new Marca();
    private List<Marca> lstMarca;   
    
    public void listar(){
        lstMarca = marcaDAO.listar();
    }   
    
    public void agregar(){
        marcaDAO.agregar(marca);
        limpiar();
    }
    
    public void buscar(Marca m){
        marca = marcaDAO.buscar(m);
    }
    
    public void limpiar(){
        marca = new Marca();
    }
    
    public void actualizar(){
        marcaDAO.actualizar(marca);
        limpiar();
    }
    
    public void eliminar(Marca m){
        marcaDAO.eliminar(m);
    }
    
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca Marca) {
        this.marca = Marca;
    }

    public List<Marca> getLstMarca() {
        return lstMarca;
    }

    public void setLstMarca(List<Marca> lstMarca) {
        this.lstMarca = lstMarca;
    }
}