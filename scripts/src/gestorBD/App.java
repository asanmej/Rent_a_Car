package gestorBD;

/**
 * Conexión a Base de Datos JDBL MySQL a traves de una clase gestora de la conexión
 * 
 * Descomenta una de las sentencias para ejecutarla (Create Table, Drop Table o Insert)
 */

public class App {

    public static void main(String[] args) {
        String sentencia;
        int regAfectados;
    	
    	
        //Crea un objeto tipo GestorBD con los datos de nuestra conexion
    	GestorBD miConn = new GestorBD(
                "RentACar"
                , "c##rentacar"
                , "rentacar" 
                , "jdbc:oracle:thin:@localhost:1521:xe");
        
        // Conecta a la BD
        if (miConn.abrirConexion()) {
        	
            System.out.println("CONECTADOS !!!!!    ");

            
            /*
            // Sentencia --- Create Table  ---------------------------
            sentencia = "CREATE TABLE alumnos ("
                    + "id       INT AUTO_INCREMENT, "
                    + "PRIMARY KEY(id),"
                    + "nombre   VARCHAR(20),"
                    + "telefono VARCHAR(20)"
                    + ");";
            */
            
			// Sentencia --- Drop Table ------------------------------
			//sentencia = "DROP TABLE alumnos;";
             
            
            
            // Sentencia --- Insert ----------------------------------
//            String nombre = "cinco";
//            String telefono = "5555555";
//            sentencia = "INSERT "
//                    + "INTO alumnos "
//                    + "VALUES (NULL, '" + nombre  + "', '" + telefono +"');";
//			
//            
            // Ejecuta sentencia 
//            regAfectados = miConn.ejecutaUpdate(sentencia);
//            System.out.println("Total registros afectados por Update: " + regAfectados);
//            
            // Cierra conexion
            miConn.cerrarConexion();
            System.out.println("Conexión Cerrada");

            
        } else {
            System.out.println("  --> Lo siento mucho :(");
        }
    }
    
}
