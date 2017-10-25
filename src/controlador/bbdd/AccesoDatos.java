package controlador.bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.bbdd.Conexionconbasededatos;

public class AccesoDatos {

	public ResultSet buscarUsuario(Conexionconbasededatos connection, String user, String pass) throws SQLException {
		ResultSet rs = null;

		rs = connection.ejecutaQuery("select * from usuarios where mail='" + user + "' and password='" + pass + "'");

		return rs;
	}

	public ResultSet buscarAdmin(Conexionconbasededatos connection, String user, String pass) throws SQLException {
		ResultSet rs = null;

		rs = connection.ejecutaQuery("select * from admin where nombre='" + user + "' and password='" + pass + "'");

		return rs;
	}

	public ResultSet buscarEmail(Conexionconbasededatos connection, String email) throws SQLException {

		ResultSet rs = null;

		rs = connection.ejecutaQuery("SELECT mail FROM usuarios WHERE mail = '" + email + "'");

		return rs;
	}// buscarEmail

	public void insertarUsuario(Conexionconbasededatos connection, String nombre, String dni, String domicilio,
			Date fechaNacimiento, String email, String password) throws SQLException {
		connection.ejecutaInsert("INSERT INTO usuarios VALUES (0,'" + nombre + "','" + dni + "','" + domicilio + "','"
				+ fechaNacimiento + "'" + ",'" + email + "','" + password + "')");
	}// insertarUsuario
	
	
	public ResultSet obtenerProducto(Conexionconbasededatos connection) throws SQLException {
		return connection.ejecutaQuery("select * from producto");
	}
}
