package Ejercicios;

import java.util.*;

public class Ejercicioo2 {
    public static void main(String[] args) {

        List<String> listaPalabras= Arrays.asList("programacion", "java", "informatica", "desarrollo", "aplicaciones");

        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese una letra para contar en las palabras: ");
        char letra= sc.nextLine().charAt(0);
        sc.close();

        Map<Character, Integer> frecuenciaLetra= new HashMap<>();

        for (String palabra: listaPalabras){
            int frecuencia = contarLetraEnPalabra(palabra,letra);
            frecuenciaLetra.put(letra, frecuenciaLetra.getOrDefault(letra,0)+ frecuencia);
        }
        int totalFrecuencia=frecuenciaLetra.getOrDefault(letra,0);
        System.out.println("La letra '"+ letra+"' aparece un total de: "+totalFrecuencia+ " veces en las palabras.");
    }

    public static int contarLetraEnPalabra(String palabra, char letra) {
        int frecuencia =0;
        for (char c: palabra.toCharArray()){
            if (c==letra){
                frecuencia++;
            }
        }

        return frecuencia;

    }
}


