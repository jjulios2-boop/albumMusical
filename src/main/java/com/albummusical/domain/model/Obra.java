/*
 * 
 * 
 */
package com.albummusical.domain.model;

import java.util.List;

/**
 *
 * @author jjulios2-boop
 */

public abstract class Obra {
    protected String clave;
    protected String nombre;
    protected String genero;
    protected double pvp;
    protected List<Artista> artistas;

    public Obra(String clave, String nombre, String genero,
                double pvp, List<Artista> artistas) {
        this.clave = clave;
        this.nombre = nombre;
        this.genero = genero;
        this.pvp = pvp;
        this.artistas = artistas;
    }

    public String getClave() { return clave; }
    public String getNombre() { return nombre; }
    public String getGenero() { return genero; }
    public double getPvp() { return pvp; }
    public List<Artista> getArtistas() { return artistas; }

    public boolean tieneArtista(String nombreArtista) {
        return artistas.stream()
                .anyMatch(a -> a.getNombre().equalsIgnoreCase(nombreArtista));
    }
}
