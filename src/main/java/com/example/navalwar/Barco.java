package com.example.navalwar;

import java.util.ArrayList;

public class Barco {
    private String tipo;
    private int tamano;
    private ArrayList<Coordenada> coordenadas;

    public Barco(String tipo, int tamano) {
        this.tipo = tipo;
        this.tamano = tamano;
        this.coordenadas = new ArrayList<>();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public ArrayList<Coordenada> getCoordenadas() {
        return coordenadas;
    }

    public void agregarCoordenada(Coordenada coordenada) {
        coordenadas.add(coordenada);
    }
    public void quitarVida() {
        // Reducir la vida del barco
        tamano--;
    }
    public boolean estaHundido() {
        return tamano == 0;
    }
}