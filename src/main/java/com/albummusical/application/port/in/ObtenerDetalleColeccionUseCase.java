/**
 *
 * 
 */
package com.albummusical.application.port.in;

import com.albummusical.domain.model.Coleccion;
/**
 *
 * @author jjulios2-boop
 */

public interface ObtenerDetalleColeccionUseCase {
    Coleccion ejecutar(String claveColeccion);
}
