package vehiculo;

import java.util.ArrayList;

public abstract class Vehiculo {
	private String idVehiculo = null;
	private String nombre, marca, matricula;
	private String fechaMantenimiento;
	private String fechaAlta;
	private double kilometers, precioDia;

	// Setters and getters
	public String getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(String idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getFechaMantenimiento() {
		return fechaMantenimiento;
	}

	public void setFechaMantenimiento(String fechaMantenimiento) {
		this.fechaMantenimiento = fechaMantenimiento;
	}

	public double getKilometers() {
		return kilometers;
	}

	public void setKilometers(double kilometers) {
		this.kilometers = kilometers;
	}

	public double getPrecioDia() {
		return precioDia;
	}

	public void setPrecioDia(double precioDia) {
		this.precioDia = precioDia;
	}

	/**
	 * Constructor explicito de vehículo
	 * 
	 * @param nombre
	 * @param marca
	 * @param matricula
	 * @param fechaMantenimiento
	 * @param fechaAlta
	 * @param kilometers
	 * @param precioDia
	 */
	public Vehiculo(String nombre, String marca, String matricula, String fechaMantenimiento, String fechaAlta,
			double kilometers, double precioDia) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.matricula = matricula;
		this.fechaMantenimiento = fechaMantenimiento;
		this.fechaAlta = fechaAlta;
		this.kilometers = kilometers;
		this.precioDia = precioDia;
	}

	/**
	 * Función para crear la orden de crear vehículos en la base de datos
	 * 
	 * @return String con la sentencia SQL para crear un registro en la base de datos de vehiculo
	 */
	public String crearVehiculoBD() {

		String sentencia = "INSERT INTO vehiculo VALUES (" + this.idVehiculo + ",'" + this.nombre + "','" + this.marca
				+ "'," + this.kilometers + ",'" + this.matricula + "','" + this.fechaMantenimiento + "','"
				+ this.fechaAlta + "'," + this.precioDia;

		return sentencia;
	}

	/**
	 * Módifica la fecha de mantenimiento de un vehículo concreto en la base de datos.
	 * 
	 * @return String sentencia para modificar la fecha de Mantenimiento de un vehículo concreto en la
	 *         BD
	 */
	static public String insertarFechaMantenimiento(String nuevaFecha, String idVehiculo) {

		String result = "UPDATE vehiculo SET fechaMantenimineto = " + nuevaFecha + " WHERE idVehiculo = " + idVehiculo;

		return result;
	}

	/**
	 * Elimina un vehículo de la tabla de vehículos según el idVehiculo.
	 * 
	 * @param idVehiculo int correspondiente al vehículo.
	 *                   TODO lanzar error si vehiculo no encontrado
	 */
	static public String eliminarVehiculo(int idVehiculo) {

		return "DELETE FROM vehiculo WHERE idVehiculo = " + idVehiculo;

	}

	/**
	 * Elimina un vehículo de la tabla de vehículos según la matrícula seleccionada.
	 * 
	 * @param matricula String con la matrícula a eliminar.
	 * @return
	 */
	static public String eliminarVehiculo(String matricula) {

		return "DELETE FROM vehiculo WHERE matricula = '" + matricula + "'";
	}

	/**
	 * Módifica el parametro del vehículo suministrado
	 * 
	 * @param parametro String de la columna a modificar
	 * @param nuevoValor String con el nuevo valor
	 * @param idVehiculo String con el id del vehículo
	 * @return
	 */
	@SuppressWarnings("unlikely-arg-type")
	static public String modificarVehiculoPorId(String parametro, String nuevoValor, String idVehiculo) {

		String result = "";
		parametro = parametro.toLowerCase();
		ArrayList<String> listaNumeros = new ArrayList<String>();
		listaNumeros.add("idVehiculo");
		listaNumeros.add("km");
		listaNumeros.add("precioDia");

		if (listaNumeros.contains(listaNumeros)) {
			result = result + "UPDATE vehiculo SET " + parametro + " = " + nuevoValor + " WHERE idVehiculo = "
					+ idVehiculo;

		} else {
			result = result + "UPDATE vehiculo SET " + parametro + " = '" + nuevoValor + "' WHERE idVehiculo = "
					+ idVehiculo;
		}
		return result;

	}
	
	static public String modificarPreciDia(String tipo, String categoria, int nuevoPrecioDia) throws Exception {
		
		String result = "";
		
		if(nuevoPrecioDia >= 0) {
			
			result = result + "UPDATE vehiculo SET precioDia = " + nuevoPrecioDia + " WHERE tipoVehiculo = '" + tipo + "' AND categoriaVehiculo = '" + categoria + "'";
			
		}else {
			throw new Exception("El nuevo precio por día no puede ser menor a 0 €");
		}
		
		
		return result;
	}
	
}
