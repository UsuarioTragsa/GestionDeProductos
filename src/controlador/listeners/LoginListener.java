package controlador.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controlador.Controller;
import modelo.Admin;
import modelo.Usuario;

public class LoginListener implements ActionListener{

	private JFrame loginFrame;
	private JTextField userField,passField;
	private Controller controller;
	
	public LoginListener(JFrame loginFrame,JTextField userField, JTextField passField) {
		this.loginFrame = loginFrame;
		this.userField = userField;
		this.passField = passField;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controller = controller.getInstance();
		
		Usuario user = controller.validarUsuario(userField,passField);
		
		if(user != null) {
			controller.abrirVentana("clienteMain", user);
			controller.cerrarVentana(loginFrame);
		}else {
			Admin admin = controller.validarAdmin(userField, passField);
			if(admin != null){
				controller.abrirVentana("admin");
				controller.cerrarVentana(loginFrame);
			}else{
				controller.logFail(loginFrame);
			}
		}
		
	}
}
