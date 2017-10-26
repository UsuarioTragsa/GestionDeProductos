package controlador.bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Producto;
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
	
	public ResultSet obtenerUsuario(Conexionconbasededatos connection) throws SQLException {
		return connection.ejecutaQuery("select * from usuarios");
	}
	
	public void comprarProducto(Conexionconbasededatos connection, Producto p) throws SQLException{
		connection.ejecutaInsert("UPDATE producto SET cantidad = "+ (p.getCantidad()-1) + " WHERE id = " + p.getId());
	}

	public void addProducto(Conexionconbasededatos connection, String nombre, double precio, String descripcion,
			int cantidad, String categoria) throws SQLException {
		String url="./resources/imgs/";
		switch(categoria.toLowerCase()) {
			case "cama":
				url += "cama.jpg";
				break;
			case "armarios":
				url += "armario2.jpg";
				break;
			case "televisores":
				url += "televisor2.jpg";
				break;
			case "mesas":
				url += "mesacristal.jpg";
				break;
				
		}
		
		
		connection.ejecutaInsert("INSERT INTO producto VALUES (0,'" + nombre + "','" + precio + "','" + descripcion + "','"
				+ cantidad + "'" + ",'" + categoria + "','" + url + "')");
		
	}
}
