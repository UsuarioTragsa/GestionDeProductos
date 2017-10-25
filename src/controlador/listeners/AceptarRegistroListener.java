package controlador.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePickerImpl;

import controlador.Controller;
import modelo.Usuario;

public class AceptarRegistroListener implements ActionListener{

	private JFrame registroFrame;
	private JTextField nombre;
	private JTextField dni;
	private JTextField domicilio;
	private JTextField email;
	private JTextField password;
	private JTextField repitePassword;
	private JDatePickerImpl fechaNacimiento;
	private Controller controller;
	
	
	public AceptarRegistroListener(JFrame registroFrame, JTextField nombre, JTextField dni, JTextField domicilio, JTextField email,
			JTextField password, JTextField repitePassword, JDatePickerImpl fechaNacimiento) {
		this.registroFrame = registroFrame;
		this.nombre = nombre;
		this.dni = dni;
		this.domicilio = domicilio;
		this.email = email;
		this.password = password;
		this.repitePassword = repitePassword;
		this.fechaNacimiento = fechaNacimiento;
	}//constructor


	@Override
	public void actionPerformed(ActionEvent e) {
		controller = controller.getInstance();
		//se llama a validarRegistro 
		String mensaje = controller.validarRegistro(nombre, dni, domicilio, email, password, repitePassword, fechaNacimiento);
		if(mensaje.equals("ok")) {
			Date selectedDate = (Date) fechaNacimiento.getModel().getValue();
			Usuario user= new Usuario(nombre.getText(),dni.getText(),domicilio.getText(),selectedDate,email.getText());
			
			// si la validación es correcta se muestra un mensaje de confirmación y se accede a la ventana clienteMain 
			controller.registroOk(registroFrame);
			controller.cerrarVentana(registroFrame);
			controller.abrirVentana("clienteMain",user);
		}else {
			controller.registroFail(registroFrame, mensaje);
		}//if-else
	}//actionPerformed
	
}
