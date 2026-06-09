/*
 * 
 * 
 */
package com.albummusical.domain.model;

/**
 *
 * @author jjulios2-boop
 */
public class Artista {
    
    private String nombre;
    private String paisOrigen;
    private String estiloMusical;
    private boolean grupo;
    private int numeroIntegrantes;

    public Artista(String nombre, String paisOrigen, String estiloMusical,
                   boolean grupo, int numeroIntegrantes) {
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.estiloMusical = estiloMusical;
        this.grupo = grupo;
        this.numeroIntegrantes = numeroIntegrantes;
    }

    public String getNombre() { return nombre; }
    public String getPaisOrigen() { return paisOrigen; }
    public String getEstiloMusical() { return estiloMusical; }
    public boolean isGrupo() { return grupo; }
    public int getNumeroIntegrantes() { return numeroIntegrantes; }
}
