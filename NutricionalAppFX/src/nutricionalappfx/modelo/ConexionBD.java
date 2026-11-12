package nutricionalappfx.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author mar
 */
public class ConexionBD {
    
    private static final Properties propiedades = new Properties();
    
    static {
        try {
            InputStream input = ConexionBD.class.getResourceAsStream("database.properties");
            if(input==null) {
                throw new RuntimeException("Error: no se encontro el archivo databese.properties");
            } else {
                propiedades.load(input);
            }
        } catch (IOException exception) {
           exception.printStackTrace();
        }
    }
    
    public static Connection obtenerConecion () throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(propiedades.getProperty("db.url"), propiedades.getProperty("db.user"), 
                                               propiedades.getProperty("db.password"));
        } catch (ClassNotFoundException exception) {
            throw new SQLException("No se encontro el driver de MySQL: " + exception.getMessage());
        }
        
    }
}
