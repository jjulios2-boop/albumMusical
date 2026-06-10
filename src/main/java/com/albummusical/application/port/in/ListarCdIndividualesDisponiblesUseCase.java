/**
 *
 * 
 */
package com.albummusical.application.port.in;

import com.albummusical.domain.model.CdIndividual;
import java.util.List;

/**
 *
 * @author jjulios2-boop
 */

public interface ListarCdIndividualesDisponiblesUseCase {
    List<CdIndividual> ejecutar();
}
