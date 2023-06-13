package dao;

import conexion.ConnS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;

import modelo.ResultadoTO;

public class ResultadoDao implements ResultadoDaoI {

    ConnS intance = ConnS.getInstance();
    Connection conexion = intance.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    Connection connect;

    @Override
    public List listarResultados() {
        List<ResultadoTO> lista = new ArrayList<>();
        String sql = "select * from resultados";
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ResultadoTO to = new ResultadoTO();
                to.setId_resultado(rs.getInt("id_resultado"));
                to.setNombre_partida(rs.getString("nombre_partida"));
                to.setNombre_jugador1(rs.getString("nombre_jugador1"));
                to.setNombre_jugador2(rs.getString("nombre_jugador2"));
                to.setGanador(rs.getString("ganador"));
                to.setPunto(rs.getInt("punto"));
                to.setEstado(rs.getString("estado"));
                lista.add(to);
                System.out.println("sefsefse" + to.getNombre_partida());
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        return lista;
    }

    
    @Override
    public int crearResultados(ResultadoTO re) {
        int exec = 0;
        int i = 0;
        String sql = "INSERT INTO resultados(nombre_partida,nombre_jugador1, nombre_jugador2, ganador, punto, estado)VALUES(?,?,?,?,?,?)";
        
        try {
            ps = conexion.prepareStatement(sql);
            
            ps.setString(1, re.getNombre_partida());
            ps.setString(2, re.getNombre_jugador1());
            ps.setString(3, re.getNombre_jugador2());
            ps.setString(4, "");
            ps.setString(5, "");
            ps.setString(6, "Jugando");
            
            exec = ps.executeUpdate();
        } catch (Exception e) {
        }
        return exec;
    }

    @Override
    public int actualizarResultados(ResultadoTO reup) {
        
       int exec = 0;
        int i = 0;
        
        String sql = " update resultados set ganador=?, punto=?, estado=? where nombre_partida=?";
        
        try {
            ps = conexion.prepareStatement(sql);
            
            
            ps.setString(1, reup.getGanador());
            ps.setInt(2, reup.getPunto());
            ps.setString(3, reup.getEstado());
            ps.setString(4, reup.getNombre_partida());
            
            
            
            
            
            
            exec = ps.executeUpdate();
        } catch (Exception e) {
        }
        return exec;
       
    }

    @Override
    public int eliminarResultados(ResultadoTO rede) {
        
        int exec = 0;
        int i=0;  
        
       String sql = "delete from resultados where nombre_partida=?";
        try {
           ps = conexion.prepareStatement(sql);
                  
                        
            ps.setString(1, rede.getNombre_partida());
            
            
            
            exec = ps.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }
        
        return exec;
        
    }

}
