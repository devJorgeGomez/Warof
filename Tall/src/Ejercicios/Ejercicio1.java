package Ejercicios;

import java.util.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        List<String> listaCadenas = Arrays.asList("hola", "mundo", "java", "programacion", "hola");
        Map<String, Integer> frecuenciaPalabras= new HashMap<>();

        for(String palabra:listaCadenas){
            frecuenciaPalabras.put(palabra,frecuenciaPalabras.getOrDefault(palabra,0)+1);
        }
        int frecuencia=0;

        System.out.println("Frecuencia de palabras");
        for (String palabra: frecuenciaPalabras.keySet()){
            frecuencia =frecuenciaPalabras.get(palabra);

            System.out.println(palabra+ " : "+ frecuencia);
        }

    }
}
