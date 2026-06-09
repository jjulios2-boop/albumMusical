/**
 *
 * @author jjulios2-boop
 */
package com.albummusical.application.service;

import com.albummusical.application.port.in.ListarCdIndividualesDisponiblesUseCase;
import com.albummusical.application.port.out.ObraRepository;
import com.albummusical.domain.model.CdIndividual;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author jjulios2-boop
 */

public class ListarCdIndividualesDisponiblesService implements ListarCdIndividualesDisponiblesUseCase {
    private final ObraRepository obraRepository;

    public ListarCdIndividualesDisponiblesService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    @Override
    public List<CdIndividual> ejecutar() {
        return obraRepository.findAll().stream()
                .filter(obra -> obra instanceof CdIndividual)
                .map(obra -> (CdIndividual) obra)
                .collect(Collectors.toList());
    }
}
