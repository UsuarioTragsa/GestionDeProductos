package modelo.bbdd;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class Conexionconbasededatos {

	// Miembros de la clase (atributos)

	private static Connection conexion;
	private static String conector, servidorBBDD, BBDD;
	private static String usuario, clave;
	private static String cadenaConexion;
	private static ResultSet resultado;

	/**
	 *
	 * @param bbdd
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void conexionBBDD(String bbdd) throws SQLException, ClassNotFoundException {
		// Cargamos el driver
		Class.forName("com.mysql.jdbc.Driver");
		// Usamos el metodo estatico getConnection
		BBDD = bbdd;
		conector = "jdbc:mysql:";
		servidorBBDD = "//localhost/";
		usuario = "root";
		clave = "";

		cadenaConexion = conector + servidorBBDD + BBDD;
		conexion = DriverManager.getConnection(cadenaConexion, usuario, clave);

	}

	/**
	 *
	 * @param consulta
	 * @return resultado, devuelve el resultado de la consulta en un ResultSet
	 * @throws SQLException
	 */
	public ResultSet ejecutaQuery(String consulta) throws SQLException {
		Statement ejecutar = conexion.createStatement();
		resultado = ejecutar.executeQuery(consulta);

		return resultado;
	}

	/**
	 *
	 * @param consulta
	 * @throws SQLException
	 *             Inserta datos en la base de datos
	 */
	public void ejecutaInsert(String consulta) throws SQLException {
		Statement ejecutar = conexion.createStatement();
		ejecutar.executeUpdate(consulta);

	}

	public void cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
