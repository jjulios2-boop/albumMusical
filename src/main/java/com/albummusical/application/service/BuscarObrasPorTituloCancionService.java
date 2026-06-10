/**
 *
 * 
 */
package com.albummusical.application.service;

import com.albummusical.application.port.in.BuscarObrasPorTituloCancionUseCase;
import com.albummusical.application.port.out.ObraRepository;
import com.albummusical.domain.model.CdIndividual;
import com.albummusical.domain.model.Coleccion;
import com.albummusical.domain.model.Obra;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author jjulios2-boop
 */

public class BuscarObrasPorTituloCancionService implements BuscarObrasPorTituloCancionUseCase {
    private final ObraRepository obraRepository;

    public BuscarObrasPorTituloCancionService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    @Override
    public List<Obra> ejecutar(String tituloCancion) {
        return obraRepository.findAll().stream()
                .filter(obra -> contieneCancion(obra, tituloCancion))
                .collect(Collectors.toList());
    }

    private boolean contieneCancion(Obra obra, String tituloCancion) {
        if (obra instanceof CdIndividual cd) {
            return cd.contieneCancion(tituloCancion);
        }

        if (obra instanceof Coleccion coleccion) {
            return coleccion.getCds().stream()
                    .anyMatch(cd -> cd.contieneCancion(tituloCancion));
        }

        return false;
    }
}
