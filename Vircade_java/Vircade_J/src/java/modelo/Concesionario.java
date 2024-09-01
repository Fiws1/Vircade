
package modelo;

public class Concesionario {
    private int Id_Concesionario, Disponibilidad;
    private String Concesionario,Direccion;
    private Disponibilidad ID_Disponibilidad;

    public int getDisponibilidad() {
        return Disponibilidad;
    }

    public void setDisponibilidad(int Disponibilidad) {
        this.Disponibilidad = Disponibilidad;
    }

    public Disponibilidad getID_Disponibilidad() {
        return ID_Disponibilidad;
    }

    public void setID_Disponibilidad(Disponibilidad ID_Disponibilidad) {
        this.ID_Disponibilidad = ID_Disponibilidad;
    }
    
    

    public int getId_Concesionario() {
        return Id_Concesionario;
    }

    public void setId_Concesionario(int Id_Concesionario) {
        this.Id_Concesionario = Id_Concesionario;
    }

    public String getConcesionario() {
        return Concesionario;
    }

    public void setConcesionario(String Concesionario) {
        this.Concesionario = Concesionario;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
     
}
