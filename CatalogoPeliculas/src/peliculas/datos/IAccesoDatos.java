package peliculas.datos;

import java.util.List;
import peliculas.domain.Pelicula;
import peliculas.excepciones.EscrituraDatosEx;
import peliculas.excepciones.LecturaDatosEx;

public interface IAccesoDatos {

    boolean existe(String nombreArchivo);

    List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx;

    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    void crear(String nombreArchivo) throws EscrituraDatosEx;

    void borrar(String nombreArchivo);
}
