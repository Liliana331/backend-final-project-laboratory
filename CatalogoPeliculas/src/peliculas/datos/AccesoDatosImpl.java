package peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import peliculas.domain.Pelicula;
import peliculas.excepciones.EscrituraDatosEx;
import peliculas.excepciones.LecturaDatosEx;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList<>();

        try {
            BufferedReader lectura = new BufferedReader(new FileReader(archivo));
            String nombrePelicula = null;
            nombrePelicula = lectura.readLine();
            while (nombrePelicula != null) {
                Pelicula pelicula = new Pelicula(nombrePelicula);
                peliculas.add(pelicula);
                nombrePelicula = lectura.readLine();
            }
            lectura.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al intentar listar peliculas " + ex.getMessage());
        } catch (IOException ex) {
            throw new LecturaDatosEx("Excepcion al intentar listar peliculas");
        }

        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter escribir = new PrintWriter(new FileWriter(archivo, anexar));
            String nombrePelicula = pelicula.getNombre();
            escribir.println(nombrePelicula);
            escribir.close();
            System.out.println("Se ha escrito informacion en el Archivo " + pelicula);
        } catch (FileNotFoundException ex) {
            throw new EscrituraDatosEx("Excepcion al intentar escribir pelicula");
        } catch (IOException ex) {
            throw new EscrituraDatosEx("Excepcion al intentar escribir pelicula");
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            BufferedReader lectura = new BufferedReader(new FileReader(archivo));
            String peliculaArchivo = null;
            peliculaArchivo = lectura.readLine();
            int contador = 1;
            while (peliculaArchivo != null) {
                if (buscar.equalsIgnoreCase(peliculaArchivo) && buscar != null) {
                    return "La pelicula: " + buscar + ", fue encontrada en la posicion: " + contador;
                }
                contador++;
                peliculaArchivo = lectura.readLine();
            }
            lectura.close();
        } catch (FileNotFoundException ex) {
            throw new LecturaDatosEx("Excepcion al buscar archivo");
        } catch (IOException ex) {
            throw new LecturaDatosEx("Excepcion al buscar archivo");
        }
        return "La pelicula: " + buscar + ", no fue encontrada";
    }

    @Override
    public void crear(String nombreArchivo) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter escribir = new PrintWriter(new FileWriter(archivo));
            escribir.close();
            System.out.println("Se ha creado el Archivo");
        } catch (FileNotFoundException ex) {
            throw new EscrituraDatosEx("Excepcion al crear archivo");
        } catch (IOException ex) {
            throw new EscrituraDatosEx("Excepcion al crear archivo");
        }

    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("Se ha eliminado el Archivo");
    }
}
