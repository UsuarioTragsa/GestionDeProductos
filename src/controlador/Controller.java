package controlador;

import javax.swing.JFrame;

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
	
	public void abrirVentana(String ventana) {
		switch(ventana) {
		case "registro":
			Registro registro = new Registro();
			registro.setVisible(true);
			break;
		}
		
	}
}
