package com.example.navalwar;

import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {
    private String nombre;
    private String documento;
    private String alias;
    private Tablero tablero;
    private ArrayList<Barco> flota;

    private static Scanner scanner = new Scanner(System.in);

    public Jugador(String nombre, String documento, String alias, Tablero tablero, ArrayList<Barco> flota) {
        this.nombre = nombre;
        this.documento = documento;
        this.alias = alias;
        this.tablero = tablero;
        this.flota = flota;
    }

    public Tablero getTablero() {
        return tablero;
    }
    public ArrayList<Barco> getFlota() {
        return flota;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void ubicarFlota(ArrayList<Barco> barcos) {
        for (Barco barco : barcos) {
            System.out.println("Ubicación del barco " + barco.getTipo() + " (" + barco.getTamano() + " casillas):");
            int filaInicio, columnaInicio, direccion;

            do {

                System.out.print("Ingrese la coordenada para el inicio del barco (A-J0-9): ");
                String coordenadaInput = scanner.next();
                filaInicio = convertirLetraANumero(coordenadaInput.substring(0, 1));
                columnaInicio = Integer.parseInt(coordenadaInput.substring(1));

                System.out.print("Seleccione la dirección del barco (1: Derecha, 2: Abajo, 3: Izquierda, 4: Arriba): ");
                direccion = scanner.nextInt();

                if (!esCoordenadaValida(filaInicio, columnaInicio)) {
                    System.out.println("Error: Coordenadas fuera del tablero. Intente nuevamente.");
                } else if (tablero.estaOcupada(filaInicio, columnaInicio)) {
                    System.out.println("Error: La posición está ocupada por otro barco. Intente nuevamente.");
                } else if (!sonCoordenadasValidasParaBarco(filaInicio, columnaInicio, direccion, barco)) {
                    System.out.println("Error: El barco no cabe en esa posición o dirección. Intente nuevamente.");
                }
            } while (!esCoordenadaValida(filaInicio, columnaInicio)
                    || tablero.estaOcupada(filaInicio, columnaInicio)
                    || !sonCoordenadasValidasParaBarco(filaInicio, columnaInicio, direccion, barco));

            for (int i = 0; i < barco.getTamano(); i++) {
                int fila = filaInicio;
                int columna = columnaInicio;

                switch (direccion) {
                    case 1:
                        columna += i;
                        break;
                    case 2:
                        fila += i;
                        break;
                    case 3:
                        columna -= i;
                        break;
                    case 4:
                        fila -= i;
                        break;
                }

                tablero.setValor(fila, columna, 1);
                barco.agregarCoordenada(new Coordenada(fila, columna));
            }

            tablero.mostrarTableroDefensaConBarcos();
        }
    }
    private int convertirLetraANumero(String letra) {
        return letra.toUpperCase().charAt(0) - 'A';
    }

    private boolean sonCoordenadasValidasParaBarco(int fila, int columna, int direccion, Barco barco) {
        switch (direccion) {
            case 1:
                return columna + barco.getTamano() <= tablero.getColumnas();
            case 2:
                return fila + barco.getTamano() <= tablero.getFilas();
            case 3:
                return columna - barco.getTamano() + 1 >= 0;
            case 4:
                return fila - barco.getTamano() + 1 >= 0;
            default:
                return false;
        }
    }
    public boolean esCoordenadaValida(int fila, int columna) {
        return fila >= 0 && fila < tablero.getFilas() && columna >= 0 && columna < tablero.getColumnas();
    }
    public void realizarAtaque(int fila, int columna, Jugador oponente) {
        Tablero tableroOponente = oponente.getTablero();
        int[][] tableroAtaque = tableroOponente.getTableroAtaque();
        int[][] tableroDefensa = tableroOponente.getTableroDefensa();
        int[][] tableroAtaquePropio = this.getTablero().getTableroAtaque();


        if (tableroDefensa[fila][columna] == 1) {

            System.out.println("¡Impacto!");

            Barco barcoImpactado = null;
            for (Barco barco : oponente.getFlota()) {
                for (Coordenada coordenada : barco.getCoordenadas()) {
                    if (coordenada.getFila() == fila && coordenada.getColumna() == columna) {
                        barcoImpactado = barco;
                        break;
                    }
                }
            }

            tableroDefensa[fila][columna] = 9;
            tableroAtaquePropio[fila][columna] = 9;

            if (barcoImpactado != null) {
                barcoImpactado.quitarVida();
                if (barcoImpactado.estaHundido()) {
                    System.out.println("¡Barco hundido!");
                }
            }
        } else {
            System.out.println("¡Agua!");

            tableroDefensa[fila][columna] = 8;
            tableroAtaquePropio[fila][columna] = 8;
        }
    }
}