/**
 *
 * 
 */
package com.albummusical.application.port.in;

import com.albummusical.domain.model.Obra;
import java.util.List;

/**
 *
 * @author jjulios2-boop
 */

public interface BuscarObrasPorTituloCancionUseCase {
    List<Obra> ejecutar(String tituloCancion);
}
