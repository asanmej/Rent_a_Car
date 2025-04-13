package usuario;

public class Cliente extends Usuario {

	private String numeroTelefono;

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public Cliente(int idUsuario, String nombre, String apellidos, String email, String numeroTelefono) {
		super(idUsuario, nombre, apellidos, email);
		this.numeroTelefono = numeroTelefono;
	}

	/**
	 * Devuelve la sentencia SQL a ejecutar para introducir un cliente en la base de datos.
	 * @param nombre String con el nombre del cliente
	 * @param apellidos String con los apellidos del cliente
	 * @param email String con el email del cliente
	 * @param numeroTelefono String con el numero de telefono del cliente
	 * @return String con la sentencia final
	 */
	public String sentenciaAñadirCliente() {

		return "INSERT INTO clientes VALUES (NULL,'" + getNombre() + "','" + getApellidos() + "','" + getEmail() + "','"
				+ numeroTelefono + "'";

	}

}
