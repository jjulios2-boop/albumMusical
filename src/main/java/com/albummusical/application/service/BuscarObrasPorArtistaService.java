/**
 *
 * 
 */
package com.albummusical.application.service;

import com.albummusical.application.port.in.BuscarObrasPorArtistaUseCase;
import com.albummusical.application.port.out.ObraRepository;
import com.albummusical.domain.model.Obra;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author jjulios2-boop
 */

public class BuscarObrasPorArtistaService implements BuscarObrasPorArtistaUseCase {
    private final ObraRepository obraRepository;

    public BuscarObrasPorArtistaService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    @Override
    public List<Obra> ejecutar(String nombreArtista) {
        return obraRepository.findAll().stream()
                .filter(obra -> obra.tieneArtista(nombreArtista))
                .collect(Collectors.toList());
    }
}
