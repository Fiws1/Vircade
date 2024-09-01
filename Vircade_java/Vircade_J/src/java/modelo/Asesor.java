
package modelo;

public class Asesor {
    private int Id_Asesor, Telefono_asesor, Concesionario_Asig;
    private String p_nom_asesor, s_nom_asesor, p_ape_asesor, s_ape_asesor, Correo_asesor;
    private Concesionario Concesionario;

    public Concesionario getConcesionario() {
        return Concesionario;
    }

    public void setConcesionario(Concesionario Concesionario) {
        this.Concesionario = Concesionario;
    }
    
    public int getId_Asesor() {
        return Id_Asesor;
    }

    public void setId_Asesor(int Id_Asesor) {
        this.Id_Asesor = Id_Asesor;
    }

    public int getTelefono_asesor() {
        return Telefono_asesor;
    }

    public void setTelefono_asesor(int Telefono_asesor) {
        this.Telefono_asesor = Telefono_asesor;
    }

    public int getConcesionario_Asig() {
        return Concesionario_Asig;
    }

    public void setConcesionario_Asig(int Concesionario_Asig) {
        this.Concesionario_Asig = Concesionario_Asig;
    }

    public String getP_nom_asesor() {
        return p_nom_asesor;
    }

    public void setP_nom_asesor(String p_nom_asesor) {
        this.p_nom_asesor = p_nom_asesor;
    }

    public String getS_nom_asesor() {
        return s_nom_asesor;
    }

    public void setS_nom_asesor(String s_nom_asesor) {
        this.s_nom_asesor = s_nom_asesor;
    }

    public String getP_ape_asesor() {
        return p_ape_asesor;
    }

    public void setP_ape_asesor(String p_ape_asesor) {
        this.p_ape_asesor = p_ape_asesor;
    }

    public String getS_ape_asesor() {
        return s_ape_asesor;
    }

    public void setS_ape_asesor(String s_ape_asesor) {
        this.s_ape_asesor = s_ape_asesor;
    }

    public String getCorreo_asesor() {
        return Correo_asesor;
    }

    public void setCorreo_asesor(String Correo_asesor) {
        this.Correo_asesor = Correo_asesor;
    }

    public void setID_Disponibilidad(Concesionario buscar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
