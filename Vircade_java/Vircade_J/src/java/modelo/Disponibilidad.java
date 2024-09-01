
package modelo;

public class Disponibilidad {
    private int Id_dispo;
    private String disponibilidad;
    

    // Constructor vacío
    public Disponibilidad() {
    }

    // Constructor con parámetros
    public Disponibilidad(int idDispo, String disponibilidad) {
        this.Id_dispo = idDispo;
        this.disponibilidad = disponibilidad;
    }

    // Getters y Setters
    public int getId_Dispo() {
        return Id_dispo;
    }

    public void setId_Dispo(int idDispo) {
        this.Id_dispo = idDispo;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Disponibilidad{" + 
               "idDispo=" + Id_dispo + 
               ", disponibilidad='" + disponibilidad + '\'' + 
               '}';
    }
}
