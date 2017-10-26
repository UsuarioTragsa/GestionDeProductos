package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePickerImpl;

import controlador.bbdd.AccesoDatos;
import modelo.Admin;
import modelo.Producto;
import modelo.Usuario;
import modelo.bbdd.Conexionconbasededatos;
import vista.AdminMain;
import vista.ClienteMain;
import vista.DetallesProducto;
import vista.Login;
import vista.Registro;

public class Controller {
	private static Controller instance = null;

	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;
	}

	public void cerrarVentana(JFrame frame) {
		frame.dispose();
	}
	public void cerrarVentana(JDialog dialog) {
		dialog.dispose();
	}

	public void abrirVentana(String ventana) {
		switch (ventana) {
		case "registro":
			Registro registro = new Registro();
			registro.setVisible(true);
			break;
		case "admin":
			AdminMain am = new AdminMain();
			am.setVisible(true);
			break;	
		case "login":
			Login l = new Login();
			l.setVisible(true);
			break;
		}
	}
	
	public void abrirVentana(String ventana, Usuario user) {
		switch (ventana) {
		case "clienteMain":
			ClienteMain cm2 = new ClienteMain(user);
			cm2.setVisible(true);
			break;
		}
	}

	public void abrirVentana(String ventana, Producto producto, JTable table) {
		switch (ventana) {
		case "DetallesProducto":
			DetallesProducto dp = new DetallesProducto(producto, table);
			dp.setVisible(true);
			break;
		}
	}
		
	public Usuario validarUsuario(JTextField userField, JTextField passField) {
		Usuario usuario = null;

		String user = userField.getText();
		String pass = passField.getText();

		Conexionconbasededatos connection = new Conexionconbasededatos();
		try {
			connection.conexionBBDD("sql11199867");

			AccesoDatos ad = new AccesoDatos();
			ResultSet rs = ad.buscarUsuario(connection, user, pass);

			while (rs.next()) {
				usuario = new Usuario(rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getString(6));
			}
		} catch (NullPointerException npe) {
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			connection.cerrarConexion();
		}

		return usuario;
	}

	public Admin validarAdmin(JTextField userField, JTextField passField) {
		Admin admin = null;

		String user = userField.getText();
		String pass = passField.getText();

		Conexionconbasededatos connection = new Conexionconbasededatos();
		try {
			connection.conexionBBDD("sql11199867");

			AccesoDatos ad = new AccesoDatos();
			ResultSet rs = ad.buscarAdmin(connection, user, pass);

			while (rs.next()) {
				admin = new Admin(rs.getString("nombre"), rs.getInt("id"));
			}
		} catch (NullPointerException npe) {
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			connection.cerrarConexion();
		}

		return admin;
	}

	public String validarRegistro(JTextField nombre, JTextField dni, JTextField domicilio, JTextField email,
			JTextField password, JTextField repitePassword, JDatePickerImpl fechaNacimiento) {

		// comprobar que el campo nombre no esté vacío
		String nm = nombre.getText();
		if (nm.equals(""))
			return "El campo nombre no puede estar vacío";

		// comprobar que el campo dni no esté vacío
		String nif = dni.getText();
		if (nif.equals("")) {
			return "El campo dni no puede estar vacío";
		} else {
			String regexp = "\\d{8}[A-Z]";
			if (!Pattern.matches(regexp, nif))
				return "El dni debe contener 8 dígitos y una letra mayúscula";
		} // if-else

		// comprobar que el campo domicilio no esté vacío
		String dom = domicilio.getText();
		if (dom.equals(""))
			return "El campo domicilio no puede estar vacío";

		// comprobar que el campo email no esté vacío
		String mail = email.getText();
		if (mail.equals("")) {
			return "El campo email no puede estar vacío";
		} else {
			// comprobar que tenga un formato válido.
			String regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			if (!Pattern.matches(regexp, mail))
				return "El formato del email no es válido";

			// comprobar que el email no exista en la bbdd
			Conexionconbasededatos connection = new Conexionconbasededatos();
			try {
				connection.conexionBBDD("sql11199867");

				AccesoDatos ad = new AccesoDatos();
				ResultSet rs = ad.buscarEmail(connection, mail);

				if (rs.next())
					return "El email ya existe";
			} catch (NullPointerException npe) {
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				connection.cerrarConexion();
			} // try-catch-finally
		} // if-else

		// comprobar que los passwords no estén vacíos
		String pass = password.getText();
		String rpass = repitePassword.getText();
		if (pass.equals("") || rpass.equals("")) {
			return "El campo password no puede estar vacío";
		} else {
			if (!pass.equals(rpass))
				return "Las claves no coinciden";
		} // if-else

		// comprobar que la fecha de nacimiento no esté vacía
		Date selectedDate = (Date) fechaNacimiento.getModel().getValue();
		if (selectedDate == null)
			return "La fecha de nacimiento no puede estar vacía";

		// si la validación es correcta se insertan los campos en la bbdd
		Conexionconbasededatos connection = new Conexionconbasededatos();
		try {
			Date dateToday = new Date();
			if(selectedDate.before(dateToday)) {
				connection.conexionBBDD("sql11199867");
				// convierto la fecha de nacimiento a sql.date
				java.sql.Date date = new java.sql.Date(selectedDate.getTime());

				AccesoDatos ad = new AccesoDatos();
				ad.insertarUsuario(connection, nm, nif, dom, date, mail, pass);
			}else {
				return "La fecha de nacimiento es posterior a hoy";
			}
			
			/*connection.conexionBBDD("sql11199867");
			// convierto la fecha de nacimiento a sql.date
			java.sql.Date date = new java.sql.Date(selectedDate.getTime());

			AccesoDatos ad = new AccesoDatos();
			ad.insertarUsuario(connection, nm, nif, dom, date, mail, pass);*/
		} catch (NullPointerException npe) {
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			connection.cerrarConexion();
		} // try-catch-finally

		return "ok";
	}// validarRegistro

	public void logFail(JFrame frame) {
		JOptionPane.showMessageDialog(frame, "Combinacion user-password no valido", "Log fail",
				JOptionPane.ERROR_MESSAGE);
	}

	public void registroFail(JFrame frame, String mensaje) {
		JOptionPane.showMessageDialog(frame, mensaje, "Registro Fail", JOptionPane.ERROR_MESSAGE);
	}
	
	public void productoFail(JFrame frame) {
		JOptionPane.showMessageDialog(frame, "Datos no válidos", "Producto Fail", JOptionPane.ERROR_MESSAGE);
	}

	public void registroOk(JFrame frame) {
		JOptionPane.showMessageDialog(frame, "Los datos han sido registrados correctamente", "Registro Ok",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public ArrayList<Producto> obtenerProductos(){
		Conexionconbasededatos connection = new Conexionconbasededatos();
		AccesoDatos ad = new AccesoDatos();
		ResultSet rs = null;
		ArrayList<Producto> productos = new ArrayList<>();
		
		try {
			connection.conexionBBDD("sql11199867");
			
			rs = ad.obtenerProducto(connection);
			
			while(rs.next()) {
				productos.add(new Producto(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),
						rs.getInt(5),rs.getString(6),rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.cerrarConexion();
		}
		
		return productos;
	}
	
	public ArrayList<Usuario> obtenerUsuarios(){
		Conexionconbasededatos connection = new Conexionconbasededatos();
		AccesoDatos ad = new AccesoDatos();
		ResultSet rs = null;
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Date fechaNacimiento = null;
		
		try {
			connection.conexionBBDD("sql11199867");
			
			rs = ad.obtenerUsuario(connection);
			
			while(rs.next()) {
				usuarios.add(new Usuario(rs.getString("nombre"),rs.getString("dni"),
						rs.getString("domicilio"),rs.getDate("fechaNacimiento"),rs.getString("mail")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.cerrarConexion();
		}
		
		return usuarios;
	}
	
	public void verPanel(JPanel panelProductos,JPanel panel,JPanel panelUsers,JButton boton) {
		String nombre = boton.getName();
		
		switch(nombre) {
		case "add":
			panelProductos.setVisible(false);
			panel.setVisible(true);
			panelUsers.setVisible(false);
			break;
		case "productos":
			panelProductos.setVisible(true);
			panel.setVisible(false);
			panelUsers.setVisible(false);
			break;
		case "usuarios":
			panelProductos.setVisible(false);
			panel.setVisible(false);
			panelUsers.setVisible(true);
			break;
		}
	}
	
	public void comprarProducto(Producto p) {
		Conexionconbasededatos connection = new Conexionconbasededatos();
		AccesoDatos ad = new AccesoDatos();
		try {
			connection.conexionBBDD("sql11199867");
			
			ad.comprarProducto(connection, p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.cerrarConexion();
		}
	}
	
	public void compraOk(JDialog dialog) {
		JOptionPane.showMessageDialog(dialog, "Compra realizada", "Compra",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void addProducto(String nombre, double precio, String descripcion, int cantidad, String categoria) {
		Conexionconbasededatos connection = new Conexionconbasededatos();
		AccesoDatos ad = new AccesoDatos();
		try {
			connection.conexionBBDD("sql11199867");
			
			ad.addProducto(connection, nombre, precio, descripcion, cantidad, categoria);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.cerrarConexion();
		}
		
	}

	public void productoOK(AdminMain frame) {
		JOptionPane.showMessageDialog(frame, "Producto insertado", "Producto ok",
				JOptionPane.INFORMATION_MESSAGE);
		
	}
}
