package Ejercicios;

public class Tarea {

    private boolean completado=false;
    private String nombre;

    public boolean getCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tarea(boolean completado, String nombre) {
        this.completado = completado;
        this.nombre = nombre;
    }
    public void marcarCompletado(){
        this.completado=true;
    }



}
