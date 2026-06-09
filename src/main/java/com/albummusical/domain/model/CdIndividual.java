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
public class CdIndividual extends Obra {
    private int numeroCd;
    private List<Pista> pistas;

    public CdIndividual(String clave, String nombre, String genero,
                        double pvp, List<Artista> artistas,
                        int numeroCd, List<Pista> pistas) {
        super(clave, nombre, genero, pvp, artistas);
        this.numeroCd = numeroCd;
        this.pistas = pistas;
    }

    public int getNumeroCd() { return numeroCd; }
    public List<Pista> getPistas() { return pistas; }

    public boolean contieneCancion(String titulo) {
        return pistas.stream()
                .anyMatch(p -> p.getTitulo().equalsIgnoreCase(titulo));
    }

    public int getNumeroTotalPistas() {
        return pistas.size();
    }
}

