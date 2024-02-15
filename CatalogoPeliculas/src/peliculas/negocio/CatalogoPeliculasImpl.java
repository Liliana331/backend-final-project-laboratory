package peliculas.negocio;

import java.util.ArrayList;
import java.util.List;
import peliculas.datos.*;
import peliculas.domain.Pelicula;
import peliculas.excepciones.EscrituraDatosEx;
import peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    IAccesoDatos datos = new AccesoDatosImpl();

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);

        try {
            boolean anexar = datos.existe(NOMBRE_ARCHIVO);
            datos.escribir(pelicula, ICatalogoPeliculas.NOMBRE_ARCHIVO, anexar);
        } catch (EscrituraDatosEx ex) {
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void listarPeliculas() {
        List<Pelicula> peliculas = new ArrayList();
        try {
            peliculas = datos.listar(NOMBRE_ARCHIVO);
            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
            }
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al listar peliculas " + ex.getMessage());
        }

    }

    @Override
    public void buscarPelicula(String buscar) {
        try {
            String resultado = datos.buscar(NOMBRE_ARCHIVO, buscar);
            System.out.println(resultado);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error al buscar peliculas " + ex.getMessage());
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void iniciarArchivo() {
        try {
            datos.crear(NOMBRE_ARCHIVO);
        } catch (EscrituraDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

}
