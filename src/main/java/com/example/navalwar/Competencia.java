package com.example.navalwar;

import java.util.ArrayList;

public class Competencia {
    private ArrayList<Jugador> jugadores;

    public Competencia() {
        this.jugadores = new ArrayList<>();
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void agregarJugador(Jugador jugador) {
        // Implementar lógica para agregar un jugador a la competencia
    }

    public void jugar() {
        // Implementar lógica para realizar la competencia
    }
}