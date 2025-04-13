package alquileres;

import java.util.ArrayList;

public class Alquiler {

	private String idAlquiler;
	private int idVehiculo;
	private int idCliente;
	private String fechaInicio, fechaFin;
	private int idEmpleado;

	public String getIdAlquiler() {
		return idAlquiler;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdAlquiler(String idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Alquiler(String idAlquiler, int idVehiculo, int idCliente, String fechaInicio, String fechaFin,
			int idEmpleado) {
		super();
		this.idAlquiler = idAlquiler;
		this.idVehiculo = idVehiculo;
		this.idCliente = idCliente;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.idEmpleado = idEmpleado;
	}
	
	
	/**
	 * Crea la sentencia SQL para insertar un alquiler en la tabla de alquilers 
	 * @param idVehiculo int identificador numerico del vehículo
	 * @param idCliente int identificador numerico del cliente
	 * @param fechaInicio String fecha con formato "dd-mm-YYYY"
	 * @param fechaFin String fecha formato "dd-mm-YYYY"
	 * @param idEmpleado int identificador numerico del empleado
	 * @return
	 */
	static public String sentenciaCrearAlquiler( int idVehiculo, int idCliente, String fechaInicio,
			String fechaFin, int idEmpleado) {

		return "INSERT INTO alquiler VALUES( NULL," + idVehiculo + "," + idCliente + ",'" + fechaInicio
				+ "','" + fechaFin + "'";
	}

	/**
	 * 
	 * @param parametro  String con la columna que se quiere modificar de la tabla de Alquileres
	 * @param nuevoValor String con el nuevo valor
	 * @param idAlquiler String con el identificador de dicho alquiler
	 * @return
	 */
	static public String setenciaModificarAlquiler(String parametro, String nuevoValor, String idAlquiler) {

		String result = "";
		parametro = parametro.toLowerCase();
		ArrayList<String> listaNumeros = new ArrayList<String>();
		listaNumeros.add("idVehiculo");
		listaNumeros.add("idCliente");
		listaNumeros.add("idEmpleado");

		if (listaNumeros.contains(listaNumeros)) {
			result = result + "UPDATE vehiculo SET " + parametro + " = " + nuevoValor + " WHERE idVehiculo = "
					+ idAlquiler;

		} else {
			result = result + "UPDATE vehiculo SET " + parametro + " = '" + nuevoValor + "' WHERE idVehiculo = "
					+ idAlquiler;
		}
		return result;

	}

	static public String senteciaListarAlquiler() {

		return "SELECT * FROM alquiler";
	}

	static public String senteciaListarAlquiler(int idVehiculo) {

		return "SELECT * FROM alquiler WHERE idVehiculo = " + idVehiculo;
	}

	static public String senteciaListarAlquiler(String fecha, boolean fechaInicio) {
		
		String result = "";
		String columna = (fechaInicio)? "fechaInicio" : "fechaFin";
		
		result = result + "SELECT * FROM alquiler WHERE " + columna + " = '" + fecha + "'";
		
		return result;
	}
	
	
	// TODO todo lo relacionado a la gestion de alquileres

}
