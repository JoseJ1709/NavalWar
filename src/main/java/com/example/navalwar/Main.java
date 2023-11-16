package com.example.navalwar;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Tablero tableroGrandeJugador1 = new Tablero(10, 10);
        Tablero tableroGrandeJugador2 = new Tablero(10, 10);

        System.out.println("¡Bienvenido a Batalla Naval!");
        System.out.println("===================================");

        /*
        System.out.print("Ingrese el nombre del Jugador 1: ");
        String nombreJugador1 = scanner.nextLine();

        System.out.print("Ingrese el nombre del Jugador 2: ");
        String nombreJugador2 = scanner.nextLine();
        */

        ArrayList<Barco> barcosPredeterminados = new ArrayList<>();
        barcosPredeterminados.add(new Barco("Portaviones", 5));
        barcosPredeterminados.add(new Barco("Acorazado1", 4));
        barcosPredeterminados.add(new Barco("Acorazado2", 4));
        barcosPredeterminados.add(new Barco("Crucero", 3));
        barcosPredeterminados.add(new Barco("Submarino1", 3));

        Jugador jugador1 = new Jugador("Jugador1", "Documento1", "Alias1", tableroGrandeJugador1,barcosPredeterminados);
        Jugador jugador2 = new Jugador("Jugador2", "Documento2", "Alias2", tableroGrandeJugador2, barcosPredeterminados);



        System.out.println("\nComienza el juego...");
        System.out.println("===================================");
        System.out.println("Turno de " + jugador1.getNombre());
        System.out.println("===================================");
        jugador1.getTablero().mostrarTableroDefensaConBarcos();
        jugador1.ubicarFlota(barcosPredeterminados);
        System.out.println("===================================");
        System.out.println("Turno de " + jugador2.getNombre());
        System.out.println("===================================");
        jugador2.getTablero().mostrarTableroDefensaConBarcos();
        jugador2.ubicarFlota(barcosPredeterminados);
        System.out.println("===================================");
        System.out.println("\nFase de Ataque...");
        System.out.println("===================================");
        while (!juegoFinalizado(jugador1, jugador2)) {
            // Turno del Jugador 1
            realizarAtaque(jugador1, jugador2);

            if (juegoFinalizado(jugador1, jugador2)) {
                break;
            }

            realizarAtaque(jugador2, jugador1);
        }

        // Mostrar el resultado final del juego
        System.out.println("\n¡Juego finalizado!");
        if (jugador1.getFlota().isEmpty()) {
            System.out.println(jugador1.getNombre() + " ha ganado.");
        } else {
            System.out.println(jugador2.getNombre() + " ha ganado.");
        }
    }

    private static void realizarAtaque(Jugador atacante, Jugador oponente) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("Tableros de " + atacante.getNombre());
        System.out.println("===================================");
        atacante.getTablero().mostrarTableroDefensaConBarcos();
        System.out.println("-----------------------------------");
        atacante.getTablero().mostrarTableroAtaque();


        System.out.println("Turno de " + atacante.getNombre());
        System.out.print("Ingrese la fila para el ataque: ");
        int filaAtaque = scanner.nextInt();
        System.out.print("Ingrese la columna para el ataque: ");
        int columnaAtaque = scanner.nextInt();

        atacante.realizarAtaque(filaAtaque, columnaAtaque, oponente);
    }

    private static boolean juegoFinalizado(Jugador jugador1, Jugador jugador2) {

        return jugador1.getFlota().isEmpty() || jugador2.getFlota().isEmpty();
    }

}