package vehiculo;

public class Furgoneta extends Vehiculo {

	private String tipo;
	private final String categoria = "furgoneta";

	public String getCategoria() {
		return categoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Constructor de la clase Furgoneta
	 * 
	 * @param nombre
	 * @param marca
	 * @param matricula
	 * @param fechaMantenimiento
	 * @param fechaAlta
	 * @param kilometers
	 * @param precioDia
	 * @param tipo
	 */

	public Furgoneta(String nombre, String marca, String matricula, String fechaMantenimiento, String fechaAlta,
			double kilometers, double precioDia, String tipo) {
		super(nombre, marca, matricula, fechaMantenimiento, fechaAlta, kilometers, precioDia);
		this.tipo = tipo;
	}
	
	/**
	 * Crea una sentencia SQL para introducir una furgoneta en la tabla de vehículos
	 * 
	 * @return String con la sentencia SQL para introducir los datos en la base de datos
	 */
	public String crearVehiculoDB() {
		
		String result= super.crearVehiculoBD();
		
		result = result + ",'" + this.categoria + "','" + this.tipo + "')";
		
		return result;
	}

}
