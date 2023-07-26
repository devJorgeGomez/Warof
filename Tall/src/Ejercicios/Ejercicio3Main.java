package Ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3Main {

    public static void main(String[] args) {
        ArrayList<Tarea> gestortareas = new ArrayList<>();
        boolean controler=false;
        boolean controler2=false;

    do {
        System.out.println("MENÚ");

        System.out.println("1. Agregar una tarea a la lista");
        System.out.println("2. Marcar una tarea como completada");
        System.out.println("3. Mostrar todas las tareas pendientes");
        System.out.println("4. Mostrar todas las tareas completadas");
        System.out.println("5. Salir del programa");
        Scanner sc = new Scanner(System.in);
        int seleccion = sc.nextInt();
        String nombreTareaPro;
        switch (seleccion) {
            case 1:
                System.out.println("Escriba el nombre de la tarea");
                Tarea tarea1 = new Tarea(false, sc.next());
                gestortareas.add(tarea1);
                System.out.println("Tarea añadida");
                break;
            case 2:
                controler2=false;
                System.out.println("Cuál es el nombre de la tarea desea marcar como completa: ");
                for (Tarea tarea: gestortareas){
                    System.out.println("Nombre: "+ tarea.getNombre());

                }
                nombreTareaPro=sc.next();
                for(Tarea tarea: gestortareas){
                    if (tarea.getNombre().equals(nombreTareaPro)){
                        tarea.setCompletado(true);
                        controler2=true;
                        System.out.println("Tarea "+ tarea.getNombre()+ " se ha marcado como completada");
                    }

                }
                if(!controler2==true){
                    System.out.println("No se han conseguido coincidencias");
                }

                break;
            case 3:
                System.out.println("Tareas pendiente: ");
                boolean tareasIncompletas=false;
                for (Tarea tarea : gestortareas) {
                    tareasIncompletas = false;
                    if (tarea.getCompletado() == false) {
                        System.out.println("No se ha completado la tarea llamada: " + tarea.getNombre());
                        tareasIncompletas = true;
                    }
                }
                if (tareasIncompletas == false) {
                    System.out.println("No hay ninguna tarea pendiente");
                }

                break;
            case 4:
                controler=false;
                System.out.println("Tareas completas: ");
                boolean tareasCompletas=false;
                for (Tarea tarea : gestortareas) {
                    tareasCompletas = false;
                    if (tarea.getCompletado() == true) {
                        System.out.println("Se ha completado la tarea llamada: " + tarea.getNombre());
                        tareasCompletas = true;
                    }
                }
                if (tareasCompletas == false) {
                    System.out.println("No hay ninguna tarea completada");
                }
                break;
            case 5:
                System.out.println("Gracias por elegirnos!!!");
                controler=true;
                break;
        }
        System.out.println("");
    }while (controler==false);





    }
}
