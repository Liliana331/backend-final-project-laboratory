package finallab;

import java.util.Scanner;
import peliculas.negocio.CatalogoPeliculasImpl;
import peliculas.negocio.ICatalogoPeliculas;

/**
 *
 * @author liliana
 */
public class FinalLab {

    public static void main(String[] args) {

        ICatalogoPeliculas objeto = new CatalogoPeliculasImpl();
        Scanner scanner = new Scanner(System.in);

        int opcion = -1;

        do {
            System.out.println("");
            System.out.println("Elige una opción: ");
            System.out.println(
                    "1.- Iniciar catalogo películas\n"
                    + "2.- Agregar película\n"
                    + "3.- Listar Películas\n"
                    + "4.- Buscar Película\n"
                    + "0.- Salir");
            System.out.println("");
            
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    objeto.iniciarArchivo();
                    break;
                case 2:
                    System.out.println("Ingrese nombre de pelicula a adicionar");
                    String nombrePelicula = scanner.nextLine();
                    objeto.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    objeto.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Ingrese nombre de pelicula a buscar");
                    String nombrePeli = scanner.nextLine();
                    objeto.buscarPelicula(nombrePeli);
                    break;
                case 0:
                    System.out.println("Gracias por su visita, hasta pronto!!");
                    break;
                default:
                    System.out.println("Opción no vállida");
            }
        } while (opcion != 0);

    }

}
