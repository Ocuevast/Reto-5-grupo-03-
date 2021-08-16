package util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    private static final String UBICACION_BD = "ProyectosConstruccion.db";
    
    String url = "jdbc:sqlite:" + UBICACION_BD;

    StringConnection conn = null;

    public Conexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = (StringConnection) DriverManager.getConnection(url);
            
            System.out.println("Conexion Establecida");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    

    public ResultSet consultarRegistros(String url) {
        try {

            PreparedStatement pstm = conn.prepareStatement(url);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

}
