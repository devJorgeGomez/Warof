package Ejercicio4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Contacto> listaContactos = new ArrayList<>();

        int opcion = 0;

        do {

            System.out.println("LISTA DE TAREAS");

            System.out.println("Escoge una opcion");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Actualizar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Mostrar contactos");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Agregar Contacto\n");
                    agregarContacto(listaContactos, sc);
                    break;

                case 2:
                    buscarContacto(listaContactos, sc);
                    break;

                case 3:
                    actualizarContacto(listaContactos, sc);
                    break;

                case 4:
                    eliminarContacto(listaContactos, sc);
                    break;

                case 5:
                    mostarContactos(listaContactos, sc);
                    break;

                case 0:
                    System.out.println("Salir de programa");
                    break;

                default:
                    System.out.println("Opcion no existe");
            }

        } while (opcion != 0);

    }

    public static void eliminarContacto(ArrayList<Contacto> listaContactos, Scanner sc) {

        System.out.println("Nombre del contacto a elimnar: ");
        String nom = sc.next();

        System.out.println("Teléfono del contacto a eliminar");
        int tel = sc.nextInt();

        Iterator<Contacto> iterador = listaContactos.iterator();
        while (iterador.hasNext()) {
            Contacto contacto = iterador.next();
            if (contacto.getNombre().equals(nom)) {
                iterador.remove();
                System.out.println("Contacto eliminado correctamente.");
            }
        }

    }


    public static void mostarContactos(ArrayList<Contacto> listaContactos, Scanner sc) {

        System.out.println("Mostrar todos los contactos");

        if (listaContactos.isEmpty()) {
            System.out.println("No hay contactos registrados");
            return;
        }

        System.out.println("Lista de Contactos");

        for (Contacto contacto: listaContactos) {
            System.out.println("Nombre: " + contacto.getNombre() + " Telefono: " + contacto.getTelefono());
        }

    }

    public static void actualizarContacto(ArrayList<Contacto> listaContactos, Scanner sc) {

        boolean encontrado = true;

        System.out.println("Ingrese el nombre del contacto");
        String nom = sc.next();

        for (Contacto contacto: listaContactos) {

            if (contacto.getNombre().equals(nom)) {
                System.out.println("Ingrese el nuevo nombre del contacto");
                nom = sc.next();
                contacto.setNombre(nom);
                System.out.println("Ingrese el nuevo teléfono del contacto");
                int tel = sc.nextInt();
                contacto.setTelefono(tel);
            }

        }

        if (encontrado) {
            System.out.println("No se encontro el contacto");
        }

    }

    public static void buscarContacto(ArrayList<Contacto> listaContactos, Scanner sc) {

        System.out.println("Buscar contacto\n");

        boolean encontrado = true;

        System.out.println("Ingrese el nombre del contacto");
        String nom = sc.next();

        for (Contacto contacto: listaContactos) {

            if (contacto.getNombre().equals(nom)) {
                System.out.println("Nombre del Contacto: " + contacto.getNombre() + " Teléfono del Contacto: " + contacto.getTelefono());
                encontrado = false;
            }

        }

        if (encontrado) {
            System.out.println("No se encontro el contacto");
        }

    }

    public static void agregarContacto(ArrayList<Contacto> listaContactos, Scanner sc) {

        System.out.println("Nombre del contacto: ");
        String nom = sc.next();

        System.out.println("Teléfono del contacto");
        int tel = sc.nextInt();

        listaContactos.add(new Contacto(nom, tel));
//        listaContactos.remove(new Contacto(nom , tel));

    }

}