/*
 * 
 * 
 */
package com.albummusical.infrastructure.persistence;

import com.albummusical.domain.model.CdIndividual;
import com.albummusical.domain.model.Obra;
import com.albummusical.domain.model.Artista;
import com.albummusical.domain.model.Pista;
import com.albummusical.domain.model.Coleccion;
import com.albummusical.application.port.out.ObraRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jjulios2-boop
 */

public class EnMemoriaObraRepository implements ObraRepository {
    private final List<Obra> obras = new ArrayList<>();

    public EnMemoriaObraRepository() {
        Artista queen = new Artista("Queen", "Reino Unido", "Rock", true, 4);
        Artista shakira = new Artista("Shakira", "Colombia", "Pop", false, 1);

        CdIndividual cd1 = new CdIndividual(
                "CD-001",
                "A Night at the Opera",
                "Rock",
                18.50,
                List.of(queen),
                1,
                List.of(
                        new Pista(1, "Death on Two Legs", 223),
                        new Pista(2, "Bohemian Rhapsody", 354)
                )
        );

        CdIndividual cd2 = new CdIndividual(
                "CD-002",
                "Laundry Service",
                "Pop",
                16.00,
                List.of(shakira),
                2,
                List.of(
                        new Pista(1, "Whenever Wherever", 196),
                        new Pista(2, "Underneath Your Clothes", 224)
                )
        );

        Coleccion coleccion = new Coleccion(
                "COL-001",
                "Grandes Exitos Internacionales",
                "Variado",
                29.99,
                List.of(queen, shakira),
                "Universal Music",
                List.of(cd1, cd2)
        );

        obras.add(cd1);
        obras.add(cd2);
        obras.add(coleccion);
    }

    @Override
    public List<Obra> findAll() {
        return obras;
    }

    @Override
    public Optional<Obra> findByClave(String clave) {
        return obras.stream()
                .filter(o -> o.getClave().equalsIgnoreCase(clave))
                .findFirst();
    }
}

