/*
 * 
 * 
 */

package com.albummusical;

import com.albummusical.application.port.out.ObraRepository;
import com.albummusical.application.service.BuscarObrasPorArtistaService;
import com.albummusical.application.service.BuscarObrasPorTituloCancionService;
import com.albummusical.application.service.ListarCdIndividualesDisponiblesService;
import com.albummusical.application.service.ListarColeccionesOrdenadasPorPrecioService;
import com.albummusical.application.service.ObtenerDetalleColeccionService;
import com.albummusical.infrastructure.console.CatalogoConsoleAdapter;
import com.albummusical.infrastructure.persistence.EnMemoriaObraRepository;
import java.util.Scanner;

/**
 *
 * @author jjulios2-boop
 */

public class Main {

    /**
     * @param args the command line arguments
     */
 
    public static void main(String[] args) {
        ObraRepository obraRepository = new EnMemoriaObraRepository();

        CatalogoConsoleAdapter consoleAdapter = new CatalogoConsoleAdapter(
                new ListarCdIndividualesDisponiblesService(obraRepository),
                new ObtenerDetalleColeccionService(obraRepository),
                new BuscarObrasPorArtistaService(obraRepository),
                new ListarColeccionesOrdenadasPorPrecioService(obraRepository),
                new BuscarObrasPorTituloCancionService(obraRepository),
                new Scanner(System.in)
        );

        consoleAdapter.iniciar();
    }
}

