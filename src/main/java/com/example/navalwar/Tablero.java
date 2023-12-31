package com.example.navalwar;

public class Tablero {
    private int filas;
    private int columnas;
    private int[][] tableroAtaque;
    private int[][] tableroDefensa;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.tableroAtaque = new int[filas][columnas];
        this.tableroDefensa = new int[filas][columnas];
    }

    public int[][] getTableroAtaque() {
        return tableroAtaque;
    }

    public void setTableroAtaque(int[][] tableroAtaque) {
        this.tableroAtaque = tableroAtaque;
    }

    public int[][] getTableroDefensa() {
        return tableroDefensa;
    }

    public void setTableroDefensa(int[][] tableroDefensa) {
        this.tableroDefensa = tableroDefensa;
    }


    public void mostrarTableroDefensaConBarcos() {
        System.out.println("Tablero de Defensa:");
        System.out.print("   ");
        for (int i = 0; i < columnas; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i = 0; i < filas; i++) {
            System.out.print((char)('A' + i) + "|");
            for (int j = 0; j < columnas; j++) {
                if (tableroDefensa[i][j] != 0) {
                    System.out.print(" " + tableroDefensa[i][j] + " ");
                } else {
                    System.out.print(" 0 ");
                }
            }
            System.out.println();
        }
    }
    public void mostrarTablerosJugador(Jugador atacante) {
        System.out.println("            Defensa                                  Tablero de Ataque");
        System.out.println("    0  1  2  3  4  5  6  7  8  9            " + "    0  1  2  3  4  5  6  7  8  9");
        for (int i = 0; i < atacante.getTablero().getFilas(); i++) {
            System.out.print((char) ('A' + i) + "| ");
            for (int j = 0; j < atacante.getTablero().getColumnas(); j++) {
                if (atacante.getTablero().getTableroDefensa()[i][j] != 0) {
                    System.out.print(" " + atacante.getTablero().getTableroDefensa()[i][j] + " ");
                } else {
                    System.out.print(" 0 ");
                }
            }
            System.out.print("           ");
            System.out.print((char) ('A' + i) + "| ");
            for (int j = 0; j < atacante.getTablero().getColumnas(); j++) {
                if (atacante.getTablero().getTableroAtaque()[i][j] != 0) {
                    System.out.print(" " + atacante.getTablero().getTableroAtaque()[i][j] + " ");
                } else {
                    System.out.print(" 0 ");
                }
            }
            System.out.println();
        }
    }


    public void setValor(int fila, int columna, int valor) {
        tableroDefensa[fila][columna] = valor;
    }

    public boolean estaOcupada(int fila, int columna) {
        return tableroDefensa[fila][columna] == 1;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
}