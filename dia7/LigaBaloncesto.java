package dia7;

import java.util.ArrayList;
import java.util.Scanner;

public class LigaBaloncesto {
    // Array donde se almacenan los partidos
    private static final ArrayList<Partidos> partidos = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    
    // Clase main para poder ejecutar el codigo
    public static void main(String[] args) {
        int opcion;
        // Bucle do-while que mostrara el menu hasta que el usuario ingrese una de las opciones
        do {
            System.out.println("1. Registrar partido de liga");
            System.out.println("2. Registrar partido de PlayOffs");
            System.out.println("3. Finalizar partido");
            System.out.println("4. Mostrar informacion de los partidos");
            System.out.println("5. Agregar puntos a un partido");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            // Llamamos a los metodos y las conectamos a las opciones disponibles
            switch (opcion) {
                case 1 -> registrarPartidoLiga();
                case 2 -> registrarPartidoPlayOffs();
                case 3 -> finalizarPartido();
                case 4 -> mostrarPartidos();
                case 5 -> agregarPuntos();
                case 6 -> System.out.println("Saliendo");
                default -> System.out.println("Opcion invalida");
            }
        // Cerramos el bucle si el usuario elige el numero "6" en este caso
        } while (opcion != 6);
    }

    // Clase para registrar los partidos de la liga que se hayan ingresado
    private static void registrarPartidoLiga() {
        System.out.print("Equipo local: ");
        String local = sc.nextLine();
        System.out.print("Equipo visitante: ");
        String visitante = sc.nextLine();
        System.out.print("Fecha: ");
        String fecha = sc.nextLine();
        System.out.print("Jornada: ");
        int jornada = sc.nextInt();
        sc.nextLine();
        
        // Despues de pedir los datos lo subimos al Array "Partidos" y le decimos al usuario que ya se registro el partido
        partidos.add(new PartidosLigas(local, visitante, fecha, jornada));
        System.out.println("Partido de liga registrado");
    }
    
    // Clase que registra los partidos PlayOffs
    private static void registrarPartidoPlayOffs() {
        System.out.print("Equipo local: ");
        String local = sc.nextLine();
        System.out.print("Equipo visitante: ");
        String visitante = sc.nextLine();
        System.out.print("Fecha: ");
        String fecha = sc.nextLine();
        System.out.print("Ronda: ");
        String ronda = sc.nextLine();
        
        // Despues de que el usuario ingrese los datos los agregamos al Array "Partidos" y le decimos que ya se ha resgistrado el partido
        partidos.add(new PartidoPlayOffs(local, visitante, fecha, ronda));
        System.out.println("Partido de PlayOffs registrado");
    }
    
    // Clase para finalizar los partidos mediante el ID del mismo partido
    private static void finalizarPartido() {
        System.out.print("Ingrese el indice del partido a finalizar: ");
        int index = sc.nextInt();
        sc.nextLine();
        
        // le pedimos el ID y verificamos que no sea mayor al numero de partidos que existen y le mandamos una respuesta
        if (index >= 0 && index < partidos.size()) {
            partidos.get(index).finalizarPartido();
            System.out.println("Partido finalizado");
        } else {
            System.out.println("Indice invalido");
        }
    }

    private static void mostrarPartidos() {
        if (partidos.isEmpty()) {
            System.out.println("No hay partidos registrados");
        } else {
            for (int i =0; i < partidos.size(); i++) {
                System.out.println(i + ". " + partidos.get(i).obtenerInformacion());
            }
        }
    }
    
    private static void agregarPuntos() {
    System.out.print("Indice del partido: ");
    int index = sc.nextInt();
    sc.nextLine();

    if (index >= 0 && index < partidos.size()) {
        System.out.print("Equipo local (L) o visitante (V)? ");
        char equipo = sc.nextLine().toUpperCase().charAt(0);
        System.out.print("Puntos a agregar: ");
        int puntos = sc.nextInt();

        if (equipo == 'L') partidos.get(index).registrarPuntosLocal(puntos);
        else if (equipo == 'V') partidos.get(index).registrarPuntosVisitante(puntos);
        } else {
            System.out.println("Opcion no valida");
        }

    }
}