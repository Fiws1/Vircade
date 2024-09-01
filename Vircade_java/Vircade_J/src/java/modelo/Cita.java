
package modelo;

import java.sql.Date;
import java.sql.Time;

public class Cita {
    private int ID,Concesionario_Asig;
    private Date Fecha;
    private Time Hora;
    private String Tipo_cita,Cliente_relacionado;
    private Usuario Usuario;
    private Concesionario Concesionario;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getConcesionario_Asig() {
        return Concesionario_Asig;
    }

    public void setConcesionario_Asig(int Concesionario_Asig) {
        this.Concesionario_Asig = Concesionario_Asig;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Time getHora() {
        return Hora;
    }

    public void setHora(Time Hora) {
        this.Hora = Hora;
    }

    public String getTipo_cita() {
        return Tipo_cita;
    }

    public void setTipo_cita(String Tipo_cita) {
        this.Tipo_cita = Tipo_cita;
    }

    public String getCliente_relacionado() {
        return Cliente_relacionado;
    }

    public void setCliente_relacionado(String Cliente_relacionado) {
        this.Cliente_relacionado = Cliente_relacionado;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public Concesionario getConcesionario() {
        return Concesionario;
    }

    public void setConcesionario(Concesionario Concesionario) {
        this.Concesionario = Concesionario;
    }
}
