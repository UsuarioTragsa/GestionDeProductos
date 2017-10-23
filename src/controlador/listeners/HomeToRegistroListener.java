package controlador.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import controlador.Controller;

public class HomeToRegistroListener implements ActionListener{

	private JFrame homeFrame;
	private Controller controller;
	
	public HomeToRegistroListener(JFrame homeFrame) {
		this.homeFrame = homeFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controller = controller.getInstance();
		
		controller.cerrarVentana(homeFrame); // Cerramos la ventana de home
		
		controller.abrirVentana("registro");
	}

}
