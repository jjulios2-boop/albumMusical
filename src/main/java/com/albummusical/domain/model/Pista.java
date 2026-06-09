/*
 * 
 * 
 */
package com.albummusical.domain.model;

/**
 *
 * @author jjulios2-boop
 */

public class Pista {
    private int numero;
    private String titulo;
    private int duracionSegundos;

    public Pista(int numero, String titulo, int duracionSegundos) {
        this.numero = numero;
        this.titulo = titulo;
        this.duracionSegundos = duracionSegundos;
    }

    public int getNumero() { return numero; }
    public String getTitulo() { return titulo; }
    public int getDuracionSegundos() { return duracionSegundos; }
}

