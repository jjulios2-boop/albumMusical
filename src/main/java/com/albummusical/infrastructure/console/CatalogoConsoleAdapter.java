/**
 *
 * @author jjulios2-boop
 */
package com.albummusical.infrastructure.console;

import com.albummusical.application.port.in.BuscarObrasPorArtistaUseCase;
import com.albummusical.application.port.in.BuscarObrasPorTituloCancionUseCase;
import com.albummusical.application.port.in.ListarCdIndividualesDisponiblesUseCase;
import com.albummusical.application.port.in.ListarColeccionesOrdenadasPorPrecioUseCase;
import com.albummusical.application.port.in.ObtenerDetalleColeccionUseCase;
import com.albummusical.domain.model.CdIndividual;
import com.albummusical.domain.model.Coleccion;
import com.albummusical.domain.model.Obra;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jjulios2-boop
 */

public class CatalogoConsoleAdapter {
    private final ListarCdIndividualesDisponiblesUseCase listarCdIndividuales;
    private final ObtenerDetalleColeccionUseCase obtenerDetalleColeccion;
    private final BuscarObrasPorArtistaUseCase buscarObrasPorArtista;
    private final ListarColeccionesOrdenadasPorPrecioUseCase listarColeccionesPorPrecio;
    private final BuscarObrasPorTituloCancionUseCase buscarObrasPorTituloCancion;
    private final Scanner scanner;

    public CatalogoConsoleAdapter(
            ListarCdIndividualesDisponiblesUseCase listarCdIndividuales,
            ObtenerDetalleColeccionUseCase obtenerDetalleColeccion,
            BuscarObrasPorArtistaUseCase buscarObrasPorArtista,
            ListarColeccionesOrdenadasPorPrecioUseCase listarColeccionesPorPrecio,
            BuscarObrasPorTituloCancionUseCase buscarObrasPorTituloCancion,
            Scanner scanner) {
        this.listarCdIndividuales = listarCdIndividuales;
        this.obtenerDetalleColeccion = obtenerDetalleColeccion;
        this.buscarObrasPorArtista = buscarObrasPorArtista;
        this.listarColeccionesPorPrecio = listarColeccionesPorPrecio;
        this.buscarObrasPorTituloCancion = buscarObrasPorTituloCancion;
        this.scanner = scanner;
    }

    public void iniciar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");
            ejecutarOpcion(opcion);
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n=== Sistema Album Musical ===");
        System.out.println("1. Listar CD individuales disponibles");
        System.out.println("2. Mostrar detalle de una coleccion");
        System.out.println("3. Buscar obras por artista");
        System.out.println("4. Listar colecciones ordenadas por precio");
        System.out.println("5. Buscar obras por titulo de cancion");
        System.out.println("0. Salir");
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> mostrarCdIndividuales();
            case 2 -> mostrarDetalleColeccion();
            case 3 -> mostrarObrasPorArtista();
            case 4 -> mostrarColeccionesOrdenadasPorPrecio();
            case 5 -> mostrarObrasPorTituloCancion();
            case 0 -> System.out.println("Saliendo del sistema...");
            default -> System.out.println("Opcion no valida.");
        }
    }

    private void mostrarCdIndividuales() {
        List<CdIndividual> cds = listarCdIndividuales.ejecutar();

        System.out.println("\nCD individuales disponibles:");
        if (cds.isEmpty()) {
            System.out.println("No hay CD individuales disponibles.");
            return;
        }

        cds.forEach(this::imprimirCdIndividual);
    }

    private void mostrarDetalleColeccion() {
        String clave = leerTexto("Ingrese la clave de la coleccion: ");
        Coleccion coleccion = obtenerDetalleColeccion.ejecutar(clave);

        if (coleccion == null) {
            System.out.println("No se encontro una coleccion con la clave indicada.");
            return;
        }

        System.out.println("\nDetalle de la coleccion:");
        imprimirColeccion(coleccion);
        System.out.println("CD incluidos:");
        coleccion.getCds().forEach(cd -> System.out.println("  - "
                + cd.getClave() + " | " + cd.getNombre()
                + " | PVP: " + cd.getPvp()));
    }

    private void mostrarObrasPorArtista() {
        String artista = leerTexto("Ingrese el nombre del artista: ");
        List<Obra> obras = buscarObrasPorArtista.ejecutar(artista);

        System.out.println("\nObras del artista " + artista + ":");
        imprimirObras(obras);
    }

    private void mostrarColeccionesOrdenadasPorPrecio() {
        List<Coleccion> colecciones = listarColeccionesPorPrecio.ejecutar();

        System.out.println("\nColecciones ordenadas por precio:");
        if (colecciones.isEmpty()) {
            System.out.println("No hay colecciones disponibles.");
            return;
        }

        colecciones.forEach(this::imprimirColeccion);
    }

    private void mostrarObrasPorTituloCancion() {
        String titulo = leerTexto("Ingrese el titulo de la cancion: ");
        List<Obra> obras = buscarObrasPorTituloCancion.ejecutar(titulo);

        System.out.println("\nObras que contienen la cancion " + titulo + ":");
        imprimirObras(obras);
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String valor = scanner.nextLine().trim();

            try {
                return Integer.parseInt(valor);
            } catch (NumberFormatException ex) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
    }

    private String leerTexto(String mensaje) {
        String valor;

        do {
            System.out.print(mensaje);
            valor = scanner.nextLine().trim();
            if (valor.isEmpty()) {
                System.out.println("El valor no puede estar vacio.");
            }
        } while (valor.isEmpty());

        return valor;
    }

    private void imprimirObras(List<Obra> obras) {
        if (obras.isEmpty()) {
            System.out.println("No se encontraron obras.");
            return;
        }

        obras.forEach(this::imprimirObra);
    }

    private void imprimirObra(Obra obra) {
        System.out.println(obra.getClave() + " | " + obra.getNombre()
                + " | Genero: " + obra.getGenero()
                + " | PVP: " + obra.getPvp());
    }

    private void imprimirCdIndividual(CdIndividual cd) {
        imprimirObra(cd);
        System.out.println("  Numero CD: " + cd.getNumeroCd()
                + " | Pistas: " + cd.getNumeroTotalPistas());
    }

    private void imprimirColeccion(Coleccion coleccion) {
        imprimirObra(coleccion);
        System.out.println("  Promotor: " + coleccion.getPromotor()
                + " | CD incluidos: " + coleccion.getNumeroCds()
                + " | Total pistas: " + coleccion.getNumeroTotalPistas());
    }
}
