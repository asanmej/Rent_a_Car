package vehiculo;

public class Motocicleta extends Vehiculo {

	private final String categoria = "motocicleta";
	private final String tipo = "NULL";
	

	public String getCategoria() {
		return categoria;
	}

	public Motocicleta(String nombre, String marca, String matricula, String fechaMantenimiento, String fechaAlta,
			double kilometers, double precioDia) {
		super(nombre, marca, matricula, fechaMantenimiento, fechaAlta, kilometers, precioDia);
	}
	
	/**
	 * Crea una sentencia SQL para introducir este vehículo en la tabla de vehículos
	 * 
	 * @return String con la sentencia SQL para introducir los datos en la base de datos
	 */
	public String crearVehiculoDB() {
		
		String result= super.crearVehiculoBD();
		
		result = result + ",'" + this.categoria + "','" + this.tipo + "')";
		
		return result;
	}
	
}
