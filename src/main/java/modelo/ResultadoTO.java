package modelo;

import lombok.Data;

@Data

public class ResultadoTO {
    
    public int id_resultado;
    public String nombre_partida;
    public String nombre_jugador1;
    public String nombre_jugador2;
    public String ganador;
    public int punto;
    public String estado;
    
}
