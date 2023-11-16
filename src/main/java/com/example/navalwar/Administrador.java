package com.example.navalwar;

import java.util.ArrayList;

public class Administrador {
    private ArrayList<Competencia> competencias;

    public Administrador() {
        this.competencias = new ArrayList<>();
    }

    public ArrayList<Competencia> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(ArrayList<Competencia> competencias) {
        this.competencias = competencias;
    }

    public void crearCompetencia(ArrayList<Jugador> participantes) {
        // Implementar lógica para crear una competencia con los jugadores dados
    }

    public void mostrarResultados() {
        // Implementar lógica para mostrar los resultados de las competencias
    }
}