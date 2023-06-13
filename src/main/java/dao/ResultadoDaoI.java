
package dao;

import java.util.ArrayList;
import java.util.List;
import modelo.ResultadoTO;


public interface ResultadoDaoI {
    
    
    
    public List listarResultados();
    public int crearResultados(ResultadoTO re);
    public int actualizarResultados(ResultadoTO reup);
    public int eliminarResultados(ResultadoTO rede);
    
    
    
}
