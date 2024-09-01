package bean;

import dao.AsesorDAO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.Asesor;

@ManagedBean
@ApplicationScoped
public class AsesorBean {
    private final AsesorDAO asesorDAO = new AsesorDAO();
    private Asesor asesor = new Asesor();
    private List<Asesor> lstAsesor;   
    
    public void listar(){
        lstAsesor = asesorDAO.listar();
    }   
    
    public void buscar(Asesor a){
        asesor = asesorDAO.buscar(a);
    }
    
    public void limpiar(){
        asesor = new Asesor();
    }
    
    public void actualizar() throws SQLException {
        asesorDAO.actualizar(asesor);
        limpiar();
    }
    
    public void eliminar(Asesor a){
        asesorDAO.eliminar(a);
    }
    
    public Asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesor Asesor) {
        this.asesor = Asesor;
    }

    public List<Asesor> getLstAsesor() {
        return lstAsesor;
    }

    public void setLstAsesor(List<Asesor> lstAsesor) {
        this.lstAsesor = lstAsesor;
    }
}
