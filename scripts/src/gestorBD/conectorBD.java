package gestorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Conexión de Datos JDBL Oracle Database
 * 
 * Crea conexion a una base de datos Oracle Database
 */

public class conectorBD {

	private String user; // Usuario que realiza la conexión
	private String password; // Contraseña del usuario
	private String urlOracle; // Servidor donde se encuentra la base de datos
	private Connection conexion;

	/**
     * Constructor de Gestor de BD
     * @param db
     * @param login
     * @param password
     * @param urlOracle
     */
    public conectorBD(String user, String password, String urlOracle) {
        this.user = user;
        this.password = password;
        this.urlOracle = urlOracle;
        this.conexion = null;
    }

	/**
	 * Abre la Conexióna la BD
	 * 
	 * @return boolean True si conexión ok
	 */
	public boolean abrirConexion() {
		try {

			// Crear la conexión
			conexion = DriverManager.getConnection(urlOracle, user, password);
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
			System.out.println(ex + "\n --> Problema al cerrar la conexión. " + "Comprueba la integridad de los datos");
		}
	}

	/**
	 * Realiza modificaciones de datos en la Base de Datos.
	 * 
	 * @param sentencia String con la información a módificar (añadir, actualizar, eliminar) en cada tabla.
	 * @return true cuando se ha realizado con exito.
	 */
	public boolean updateDB(String sentencia) {

		Statement st = null;
		try {
			st = conexion.createStatement();
			st.executeUpdate(sentencia);
			return true;
		} catch (SQLException ex) {
			System.out.println(ex + "\n  --> Error al ejecutar Update()");
		}
		return false;
	}

	/**
	 * Realiza consultas a la Base de Datos según la sentencia suministrada.
	 * 
	 * @param sentencia String con la información que se quiere consultar
	 * @return ResultSet tabla con la información que coincide con la consulta
	 */
	public ResultSet queryDB(String sentencia) {

		Statement st = null;
		ResultSet result = null;
		try {
			st = conexion.createStatement();
			result = st.executeQuery(sentencia);

		} catch (SQLException ex) {
			System.out.println(ex + "\n  --> Error al ejecutar Query()");
		}
		return result;
	}
	
//	TODO incluir excepciones especificas de SQL para manejarlas mejor

}
