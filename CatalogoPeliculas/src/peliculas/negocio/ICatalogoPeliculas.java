
package peliculas.negocio;

public interface ICatalogoPeliculas {
    String NOMBRE_ARCHIVO = "Peliculas.txt";
    
    void agregarPelicula(String nombrePelicula);
    
    void listarPeliculas();
    
    void buscarPelicula(String buscar);
    
    void iniciarArchivo();
    
}
