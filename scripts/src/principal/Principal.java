package principal;

import vehiculo.*;
import gestorBD.conectorBD;

public class Principal {

	public static void main(String[] args) {

		Furgoneta furgoneta = new Furgoneta("aaaa", "aaaa", "aaaa", "11-04-2025","11-04-2025", 10, 10, "estandar");
//		Furgoneta furgoneta = new Furgoneta(null, null, null, null, null, 0, 0, null);
		System.out.print(furgoneta.modificarVehiculoPorId("marca", "aaaa", "14"));


		
		conectorBD conexion = new conectorBD();
//		String sentencia = "INSERT INTO vehiculo VALUES (NULL, '6', 'BMW', 100000, 'KAK00', '02022018','05062019', 5.4, 'motocicleta', NULL)";
//		String sentencia = "SELECT * FROM vehiculo";
//		ResultSet resultado;

		System.out.println(conexion.abrirConexion());

//		System.out.println(conexion.updateDB(furgoneta.crearVehiculoDB()));
		System.out.println(conexion.updateDB(furgoneta.eliminarVehiculo(2)));
//		System.out.println(conexion.updateDB(furgoneta.modificarVehiculoPorId("marca", "bbbb", "14")));

//		resultado = queryVehiculo(sentencia);

//		System.out.println("\nRecorrido 1 del resultado del Query");
//		try {
//			while (resultado.next()) {
//				System.out.println(resultado.getInt("idvehiculo") + " - " + resultado.getString("nombre") + " - "
//						+ resultado.getString("marca") + " - " + resultado.getString("matricula"));
//			}
//		} catch (SQLException e) {
//			System.out.println("Error en la Conexión");
//			e.printStackTrace();
//		}

		conexion.cerrarConexion();
	}

}
