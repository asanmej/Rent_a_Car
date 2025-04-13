package usuario;

import vehiculo.*;

public interface Administrar {
	
	public boolean darAltaVehiculo(Vehiculo vehiculo);
	
	public boolean eliminarVehiculo(int idVehiculo);
	
	public boolean eliminarVehiculo(String matricula);
	
	public boolean modificarDatosVehiculo(String parametro, String nuevoValor, String idVehiculo);
	
	public boolean insertarNuevaFechaMantenimiento(String nuevaFecha, String idVehiculo);
	
	public boolean cambiarPrecioDia(String tipo, String categoria, int nuevoPrecioDia);

}
