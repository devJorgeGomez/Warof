package Ejercicio4;

public class Contacto {

    private String nombre;
    private int telefono;

    public Contacto(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }


    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setTelefono(int telefono){
        this.telefono=telefono;
    }

}