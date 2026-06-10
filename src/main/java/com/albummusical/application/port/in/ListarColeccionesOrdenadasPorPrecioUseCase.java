/**
 *
 * 
 */

package com.albummusical.application.port.in;

import com.albummusical.domain.model.Coleccion;
import java.util.List;

/**
 *
 * @author jjulios2-boop
 */

public interface ListarColeccionesOrdenadasPorPrecioUseCase {
    List<Coleccion> ejecutar();
}
