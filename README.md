# albumMusical
Sistema para administrar las existencias de CD (discos compactos) en una tienda de música.

El proyecto esta organizado con arquitectura hexagonal:

- `domain`: modelos principales del negocio.
- `application.port.in`: puertos de entrada para cada caso de uso.
- `application.port.out`: puertos de salida, como el repositorio de obras.
- `application.service`: servicios de aplicacion, uno por caso de uso.
- `infrastructure.persistence`: adaptador de persistencia en memoria.
- `infrastructure.console`: adaptador de entrada por consola.

## Casos de uso implementados

- Listar CD individuales disponibles.
- Mostrar detalle de una coleccion.
- Buscar obras por artista.
- Listar colecciones ordenadas por precio.
- Buscar obras por titulo de cancion.

## Ejecucion

Desde NetBeans, ejecutar la clase principal:

```text
com.albummusical.Main
```

Desde terminal con Maven:

```bash
mvn -Dexec.mainClass=com.albummusical.Main process-classes org.codehaus.mojo:exec-maven-plugin:3.5.1:exec
```
