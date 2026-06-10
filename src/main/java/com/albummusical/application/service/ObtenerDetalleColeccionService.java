/**
 *
 * 
 */
package com.albummusical.application.service;

import com.albummusical.application.port.in.ObtenerDetalleColeccionUseCase;
import com.albummusical.application.port.out.ObraRepository;
import com.albummusical.domain.model.Coleccion;

/**
 *
 * @author jjulios2-boop
 */

public class ObtenerDetalleColeccionService implements ObtenerDetalleColeccionUseCase {
    private final ObraRepository obraRepository;

    public ObtenerDetalleColeccionService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    @Override
    public Coleccion ejecutar(String claveColeccion) {
        return obraRepository.findByClave(claveColeccion)
                .filter(obra -> obra instanceof Coleccion)
                .map(obra -> (Coleccion) obra)
                .orElse(null);
    }
}
