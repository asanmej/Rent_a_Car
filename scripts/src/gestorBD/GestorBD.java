package gestorBD;

import java.sql.*;

/**
 * Conexión a Base de Datos JDBL MySQL
 * 
 * Se encarga de la conexión a BD y metodos relacionados con gestión de BD
 */

public class GestorBD {
    private String db; 				// BD a conectar
    private String login; 			// Usuario que realiza la conexión
    private String password; 		// Contraseña del usuario
    private String servidorMysql; 	// Servidor donde se encuentra la base de datos
    private Connection conexion;

    /**
     * Constructor de Gestor de BD
     * @param db
     * @param login
     * @param password
     * @param servidorMysql
     */
    public GestorBD(String db, String login, String password, String servidorMysql) {
        this.db = db;
        this.login = login;
        this.password = password;
        this.servidorMysql = servidorMysql;
        this.conexion = null;
    }
    
	/**
	 * Abre la Conexióna la BD
	 * 
	 * @return boolean True si conexión ok
	 */
    public boolean abrirConexion() {
        try {

            //Crear la conexión
            conexion = DriverManager.getConnection(servidorMysql + db , 
                    login, password);
            return true;

        } catch (SQLException ex) {
            System.out.println(ex + "\n  --> Usuario, o base de datos, o pass incorrectos");
        }
        return false;
    }
    
    
    /**
     * Cierra la conexión
     */
    public void cerrarConexion() {
        try {
            if (conexion != null) {
                conexion.close();
            } 
        } catch (SQLException ex) {
            System.out.println(ex + "\n --> Problema al cerrar la conexión. "
                    + "Comprueba la integridad de los datos");
        }
    }
    
    
    /**
     * Ejectua una sentencia UPDATE en la BD
     * 
     * @param sentencia String con la sentencia a ejecutar en BD
     * @return número de filas afectadas en la BD
     */
    public int ejecutaUpdate(String sentencia) {
        System.out.println("Ejecutamos: " + sentencia);
        int n = 0;
        Statement st = null;
        try {
            st = conexion.createStatement();
            n = st.executeUpdate(sentencia);
        } catch (SQLException ex) {
            System.out.println(ex + "\n  --> Error al ejecutar Update()");
        }
        return n;
    }

}
