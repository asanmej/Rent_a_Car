package usuario;

import gestorBD.conectorBD;
import vehiculo.*;

public class Administrador extends Usuario implements Administrar, Autentificar {

	private String usuario;
	private String contraseña;

	public String getUsuario() {
		return usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Administrador(int idUsuario, String nombre, String apellidos, String email, String usuario, String contraseña) {
		super(idUsuario, nombre, apellidos, email);
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	@Override
	public boolean autenticarse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean darAltaVehiculo(Vehiculo vehiculo) {
		
		boolean result = false;
		
		conectorBD conexion = new conectorBD();
		
		conexion.abrirConexion();
		
		result = conexion.updateDB(vehiculo.crearVehiculoBD());
		
		conexion.cerrarConexion();
		
		return result;
	}
	
//	TODO Implementar check de existencia de matricula e id en la base de datos
	@Override
	public boolean eliminarVehiculo(int idVehiculo) {
		boolean result = false;
		
		conectorBD conexion = new conectorBD();
		
		conexion.abrirConexion();
		
		result = conexion.updateDB(Vehiculo.eliminarVehiculo(idVehiculo));
		
		conexion.cerrarConexion();
		
		return result;
	}
	
	@Override
	public boolean eliminarVehiculo(String matricula) {
		boolean result = false;
		
		conectorBD conexion = new conectorBD();
		
		conexion.abrirConexion();
		
		result = conexion.updateDB(Vehiculo.eliminarVehiculo(matricula));
		
		conexion.cerrarConexion();
		
		return result;
	}

	@Override
	public boolean modificarDatosVehiculo(String parametro, String nuevoValor, String idVehiculo) {
		boolean result = false;
		
		conectorBD conexion = new conectorBD();
		
		conexion.abrirConexion();
		
		result = conexion.updateDB(Vehiculo.modificarVehiculoPorId(parametro, nuevoValor, idVehiculo));
		
		conexion.cerrarConexion();
		
		return result;
	}

	@Override
	public boolean insertarNuevaFechaMantenimiento(String nuevaFecha, String idVehiculo) {
		boolean result = false;
		
		conectorBD conexion = new conectorBD();
		
		conexion.abrirConexion();
		
		result = conexion.updateDB(Vehiculo.insertarFechaMantenimiento(nuevaFecha, idVehiculo));
		
		conexion.cerrarConexion();
		
		return result;
	}

	@Override
	public boolean cambiarPrecioDia(String tipo, String categoria, int nuevoPrecioDia) {
		boolean result = false;
		
		conectorBD conexion = new conectorBD();
		
		conexion.abrirConexion();
		
		try {
			result = conexion.updateDB(Vehiculo.modificarPreciDia(tipo, categoria, nuevoPrecioDia));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
		
		return result;
	}
	
	

	
	
}
