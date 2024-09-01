
package modelo;

import java.sql.Blob;

public class Vehiculo {
    private int Id_Vehiculo,Precio,Modelo_vehiculo,Marca_vehiculo,Combustible_vehiculo,Tipo_vehiculo,concesionario;
    private String Vehiculo, Linea, cilindraje, Color;
    private Blob Imagen;
    private Modelo Modelo;
    private Marca Marca;
    private Combustible Combustible;
    private Tipo_Vehiculo ID_Tipo_Vehiculo;
    private Concesionario ID_Concesionario;

    public int getId_Vehiculo() {
        return Id_Vehiculo;
    }

    public void setId_Vehiculo(int Id_Vehiculo) {
        this.Id_Vehiculo = Id_Vehiculo;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public int getModelo_vehiculo() {
        return Modelo_vehiculo;
    }

    public void setModelo_vehiculo(int Modelo_vehiculo) {
        this.Modelo_vehiculo = Modelo_vehiculo;
    }

    public int getMarca_vehiculo() {
        return Marca_vehiculo;
    }

    public void setMarca_vehiculo(int Marca_vehiculo) {
        this.Marca_vehiculo = Marca_vehiculo;
    }

    public int getCombustible_vehiculo() {
        return Combustible_vehiculo;
    }

    public void setCombustible_vehiculo(int Combustible_vehiculo) {
        this.Combustible_vehiculo = Combustible_vehiculo;
    }

    public int getTipo_vehiculo() {
        return Tipo_vehiculo;
    }

    public void setTipo_vehiculo(int Tipo_vehiculo) {
        this.Tipo_vehiculo = Tipo_vehiculo;
    }

    public int getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(int concesionario) {
        this.concesionario = concesionario;
    }

    public String getVehiculo() {
        return Vehiculo;
    }

    public void setVehiculo(String Vehiculo) {
        this.Vehiculo = Vehiculo;
    }

    public String getLinea() {
        return Linea;
    }

    public void setLinea(String Linea) {
        this.Linea = Linea;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public Blob getImagen() {
        return Imagen;
    }

    public void setImagen(Blob Imagen) {
        this.Imagen = Imagen;
    }

    public Modelo getModelo() {
        return Modelo;
    }

    public void setModelo(Modelo Modelo) {
        this.Modelo = Modelo;
    }

    public Marca getMarca() {
        return Marca;
    }

    public void setMarca(Marca Marca) {
        this.Marca = Marca;
    }

    public Combustible getCombustible() {
        return Combustible;
    }

    public void setCombustible(Combustible Combustible) {
        this.Combustible = Combustible;
    }

    public Tipo_Vehiculo getID_Tipo_Vehiculo() {
        return ID_Tipo_Vehiculo;
    }

    public void setID_Tipo_Vehiculo(Tipo_Vehiculo ID_Tipo_Vehiculo) {
        this.ID_Tipo_Vehiculo = ID_Tipo_Vehiculo;
    }

    public Concesionario getID_Concesionario() {
        return ID_Concesionario;
    }

    public void setID_Concesionario(Concesionario ID_Concesionario) {
        this.ID_Concesionario = ID_Concesionario;
    }
    
}
