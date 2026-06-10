/**
 *
 * 
 */
package com.albummusical.application.service;

import com.albummusical.application.port.in.ListarColeccionesOrdenadasPorPrecioUseCase;
import com.albummusical.application.port.out.ObraRepository;
import com.albummusical.domain.model.Coleccion;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author jjulios2-boop
 */

public class ListarColeccionesOrdenadasPorPrecioService implements ListarColeccionesOrdenadasPorPrecioUseCase {
    private final ObraRepository obraRepository;

    public ListarColeccionesOrdenadasPorPrecioService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    @Override
    public List<Coleccion> ejecutar() {
        return obraRepository.findAll().stream()
                .filter(obra -> obra instanceof Coleccion)
                .map(obra -> (Coleccion) obra)
                .sorted(Comparator.comparingDouble(Coleccion::getPvp))
                .collect(Collectors.toList());
    }
}
