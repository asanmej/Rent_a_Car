package usuario;

import gestorBD.conectorBD;

public class Empleado extends Usuario {

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

	public Empleado(int idUsuario, String nombre, String apellidos, String email, String usuario, String contraseña) {
		super(idUsuario, nombre, apellidos, email);
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	public boolean registrarCliente(Cliente cliente) {

		boolean result = false;
		conectorBD conexion = new conectorBD();

		conexion.abrirConexion();

		result = conexion.updateDB(cliente.sentenciaAñadirCliente());

		conexion.cerrarConexion();

		return result;
	}
	
//	TODO 
	public void crearAlquiler() {}
	
	public void modificarAlquiler() {}
	
	public void eliminarAlquiler() {}

	
}
