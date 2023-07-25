import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 6;
        int barcosEnPie1=0;
        int barcosEnPie2=0;

        Casillas matrizJug1[][] = new Casillas[n][n];
        Casillas matrizJug2[][] = new Casillas[n][n];

        Casillas matrizJug1Ocult[][] = new Casillas[n][n];
        Casillas matrizJug2Ocult[][] = new Casillas[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizJug1[i][j] = new Casillas(false, false);
                matrizJug2[i][j] = new Casillas(false, false);
                matrizJug1Ocult[i][j] = new Casillas(false, false);
                matrizJug2Ocult[i][j] = new Casillas(false, false);
            }
        }

        int direccion=0;
        int menuJugador=0;

        do {
            System.out.println("¿Qué jugador desea elegir?");
            System.out.println("1. Jugador 1");
            System.out.println("2.Jugador 2");
            System.out.println("3. Empezar juego");
            menuJugador=sc.nextInt();
            switch (menuJugador){
                case 1:
                    barcosEnPie1=funcionCrearBarcoJugadores(menuJugador, matrizJug1, n, direccion, barcosEnPie1);
                    break;
                case 2:
                    barcosEnPie2=funcionCrearBarcoJugadores(menuJugador, matrizJug2, n, direccion, barcosEnPie2);
                    break;
                case 3:
                    if (barcosEnPie1==0){
                        System.out.println("Necesitas ingresar algunos barcos para el jugador 1");
                    }else if (barcosEnPie2==0){
                        System.out.println("Necesitas ingresar algunos barcos para el jugador 2");
                    }
                    break;
                default:
                    System.out.println("Ingreso Incorrecto, intentelo de nuevo");

            }
        }while(!(menuJugador ==3) || !(barcosEnPie1>0) || !(barcosEnPie2>0));



        System.out.println("Empieza el juego");
        int maximoIntentos=14;
        int jugador=0;
        int fila=0;
        int columna=0;

        for (int i=0; i<maximoIntentos;i++){
            boolean estados=false;

            do {
                if (i % 2 == 0) {
                    jugador = 1;
                } else {
                    jugador = 2;
                }
                System.out.println("Turno de Jugador " + jugador);
                if (jugador == 1) {
                    funcionMostrarTablero(n, matrizJug2Ocult);
                } else {
                    funcionMostrarTablero(n, matrizJug1Ocult);
                }


                System.out.println("Dónde quiere tirar el misil");
                System.out.println("Fila?");
                fila=sc.nextInt()-1;
                System.out.println("Columna?");
                columna=sc.nextInt()-1;

                if(fila>=0 && fila<=n && columna>=0 && columna<=n){
                    if (jugador==1){
                        if (matrizJug2[fila][columna].isTocado()==false){
                            if (matrizJug2[fila][columna].isOcupadoBarco()==true){
                                System.out.println("Barco impactado");
                                barcosEnPie2--;
                                matrizJug2[fila][columna].setTocado(true);
                                matrizJug2Ocult[fila][columna].setTocado(true);
                                matrizJug2Ocult[fila][columna].setOcupadoBarco(true);
                                funcionMostrarTablero(n, matrizJug2Ocult);

                            }else if (matrizJug2[fila][columna].isTocado()==false){
                                System.out.println("No hay ningún barco, le diste al agua");
                                estados=true;
                                matrizJug2Ocult[fila][columna].setTocado(true);
                                matrizJug2[fila][columna].setTocado(true);
                                funcionMostrarTablero(n, matrizJug2Ocult);
                            }
                        }else{
                            System.out.println("Ya has impactado en este lugar, intenta de nuevo");
                        }
                    }else if (matrizJug1[fila][columna].isTocado()==false){
                        if (matrizJug1[fila][columna].isOcupadoBarco()==true){
                            System.out.println("Barco impactado");
                            barcosEnPie1--;
                            matrizJug1[fila][columna].setTocado(true);
                            matrizJug1Ocult[fila][columna].setTocado(true);
                            matrizJug1Ocult[fila][columna].setOcupadoBarco(true);
                            funcionMostrarTablero(n, matrizJug1Ocult);

                        }else if (matrizJug1[fila][columna].isTocado()==false){
                            System.out.println("No hay ningún barco, le diste al agua");
                            estados=true;
                            matrizJug1Ocult[fila][columna].setTocado(true);
                            matrizJug1[fila][columna].setTocado(true);
                            funcionMostrarTablero(n, matrizJug1Ocult);
                    }else{
                        System.out.println("Ya has impactado en este lugar, intenta de nuevo");
                    }

                    }
                }else{
                    System.out.println("Tiro fuera de los límites del mapa, intente de nuevo");
                }

                if (i==12){
                    System.out.println("Se le ha acabado los intentos al jugador 1");
                }else if (i==13){
                    System.out.println("Se le ha acabado los intentos al jugador 2");
                }

                if (barcosEnPie1==0){
                    estados=true;
                    System.out.println("El jugador 2 ha ganado");
                }else if (barcosEnPie2==0){
                    estados=true;
                    System.out.println("El jugador 1 ha ganado");
                }



            }while (estados==false);
            if (barcosEnPie1==0 || barcosEnPie2==0){
                break;
            }
        }









    }

    public static int funcionCrearBarcoJugadores(int menuJugadorf, Casillas matrizf1[][],int nf1,int direccionf1, int barcosEnPief1){
        int sumaBarcos=0;

        do {
            Scanner scf1 = new Scanner(System.in);
            System.out.println("Jugador "+ menuJugadorf);
            System.out.println("0. Salir");
            System.out.println("1. Vertical");
            System.out.println("2. Horizontal");
            System.out.println("Escoja una direccion");
            direccionf1 = scf1.nextInt();

            sumaBarcos=sumaBarcos+funcionTablero(direccionf1, matrizf1, nf1, barcosEnPief1);


            funcionMostrarTablero(nf1,matrizf1);

        }while (direccionf1 !=0);

        return sumaBarcos;

    }

    public static void funcionMostrarTablero(int nf2,Casillas matrizf2[][]){
        for (int i=0; i<nf2 ;i++){
            for ( int j=0; j<nf2;j++){
                if (matrizf2[i][j].isTocado()==true){
                    if(matrizf2[i][j].isOcupadoBarco()==true){
                        System.out.print(" - ");
                    }else{
                        System.out.print(" 2 ");
                    }
                }else if (matrizf2[i][j].isOcupadoBarco()==true) {
                    System.out.print(" * ");
                }else{
                    System.out.print(" 0 ");
                }
            }
            System.out.println("");
        }
    }
    public static int funcionTablero(int direccionf,Casillas matrizf[][], int nf, int barcosEnPief){
        Scanner scf = new Scanner(System.in);
        int sumaBarcos = barcosEnPief;

        switch (direccionf) {
            case 0:
                break;

            case 1:
                int verticall;
                int inicial;
                int fin;
                int help;
                boolean espaciosSinOcupar;

                do {
                    espaciosSinOcupar = true;
                    System.out.println("Ingrese la poscion vertical");
                    verticall = scf.nextInt()-1;

                    System.out.println("Ingrese la posicion inicial");
                    inicial = scf.nextInt()-1;
                    fin=inicial;

                    System.out.println("Ingrese la posicion final");
                    help = scf.nextInt()-1;

                    if (help>inicial){
                        fin=help;
                    }else{
                        inicial=help;
                    }

                    if (verticall<=nf && inicial>=0 && fin<=6){
                        for (int i = inicial; i <= fin; i++) {
                            if (matrizf[i][verticall].isOcupadoBarco() == true) {
                                espaciosSinOcupar = false;
                            }
                        }
                    } else {
                        System.out.println("La coordenada está fuera de los límites");
                        espaciosSinOcupar = false;
                    }

                    if (espaciosSinOcupar==false){

                        System.out.println("Ingreso Incorrecto, Intentelo de nuevo");
                    }

                }while (espaciosSinOcupar==false);


                for (int i = inicial; i <= fin; i++) {

                    matrizf[i][verticall].setOcupadoBarco(true);
                    sumaBarcos++;
                }
                System.out.println("Posicion guardada!!");



                break;
            case 2:
                int horizontal;

                do {
                    espaciosSinOcupar=true;
                    System.out.println("Ingrese la poscion horizontal");
                    horizontal = scf.nextInt()-1;

                    System.out.println("Ingrese la posicion inicial");
                    inicial = scf.nextInt()-1;
                    fin=inicial;

                    System.out.println("Ingrese la posicion final");
                    help = scf.nextInt()-1;

                    if (help>inicial){
                        fin=help;
                    }else{
                        inicial=help;
                    }

                    if (horizontal<=nf && inicial>=0 && fin<=6){
                        for (int i = inicial; i <= fin; i++) {
                            if (matrizf[horizontal][i].isOcupadoBarco()==true){
                                espaciosSinOcupar=false;
                            }
                        }
                    } else {
                        System.out.println("La coordenada está fuera de los límites");
                        espaciosSinOcupar = false;
                    }

                    if (espaciosSinOcupar==false) {
                        System.out.println("Ingreso incorrecto, intentelo de nuevo");
                    }
                }while (espaciosSinOcupar==false);

                for (int i = inicial; i <= fin; i++) {

                    matrizf[horizontal][i].setOcupadoBarco(true);
                    sumaBarcos++;
                }
                System.out.println("Posicion guardada!!");
                break;
            default:
                System.out.println("Ingreso inválido, intentelo de nuevo");
                break;
        }
        return sumaBarcos;
    }

}