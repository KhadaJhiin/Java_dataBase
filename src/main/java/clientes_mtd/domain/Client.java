package clientes_mtd.domain;

import java.util.Objects;

public class Client {

    //---------------------------------->
    //-- Attributes

    private int idcliente;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String direccion;
    private String telefono;
    private int puntosPC;

    //---------------------------------->
    //-- Constructors

    public Client(){}

    public Client(int idcliente){
        this.idcliente = idcliente;
    }


    public Client(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Client(String nombre, String apellido, String ciudad, String direccion, String telefono, int puntosPC){
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.puntosPC = puntosPC;
    }

    public Client(int idcliente, String nombre, String apellido, String ciudad, String direccion, String telefono, int puntosPC) {
        this(nombre,apellido,ciudad,direccion,telefono,puntosPC);
        this.idcliente = idcliente;
    }

    //---------------------------------->
    //-- Getters and Setters

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getPuntosPC() {
        return puntosPC;
    }

    public void setPuntosPC(int puntosPC) {
        this.puntosPC = puntosPC;
    }


    //---------------------------------->
    //Method to String

    @Override
    public String toString() {
        return "Client{" +
                "idcliente=" + idcliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", puntosPC=" + puntosPC +
                '}';
    }


    //---------------------------------->
    //Method equals and hash code

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return idcliente == client.idcliente && puntosPC == client.puntosPC && Objects.equals(nombre, client.nombre) && Objects.equals(apellido, client.apellido) && Objects.equals(ciudad, client.ciudad) && Objects.equals(direccion, client.direccion) && Objects.equals(telefono, client.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcliente, nombre, apellido, ciudad, direccion, telefono, puntosPC);
    }
}
