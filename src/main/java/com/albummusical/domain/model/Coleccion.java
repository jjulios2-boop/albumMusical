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

public class Coleccion extends Obra {
    private String promotor;
    private List<CdIndividual> cds;

    public Coleccion(String clave, String nombre, String genero,
                     double pvp, List<Artista> artistas,
                     String promotor, List<CdIndividual> cds) {
        super(clave, nombre, genero, pvp, artistas);
        this.promotor = promotor;
        this.cds = cds;
    }

    public String getPromotor() { return promotor; }
    public List<CdIndividual> getCds() { return cds; }

    public int getNumeroCds() {
        return cds.size();
    }

    public int getNumeroTotalPistas() {
        return cds.stream()
                .mapToInt(CdIndividual::getNumeroTotalPistas)
                .sum();
    }
}

