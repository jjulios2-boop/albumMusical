/*
 * 
 * 
 */
package com.albummusical.application.port.out;

import java.util.List;
import java.util.Optional;
import com.albummusical.domain.model.Obra;

/**
 *
 * @author jjulios2-boop
 */

public interface ObraRepository {
    List<Obra> findAll();
    Optional<Obra> findByClave(String clave);
}

