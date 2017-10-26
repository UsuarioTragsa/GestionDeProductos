package controlador.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import controlador.Controller;

public class RegistroToHomeListener implements ActionListener{

	private JFrame frame;
	
	public RegistroToHomeListener(JFrame frame) {
		this.frame=frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Controller controller = Controller.getInstance();
		controller.cerrarVentana(frame);
		controller.abrirVentana("login");
		
	}

}
