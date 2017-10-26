package controlador.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.Controller;
import vista.AdminMain;

public class AceptarNuevoProductoListener implements ActionListener{
	private JTextField nombreField, precioField;
	private JTextArea descripcionField;
	private JSpinner cantidadField;
	private JComboBox<String> categoriaField;
	private AdminMain frame;
	
 public AceptarNuevoProductoListener(AdminMain frame, JTextField nombre, JTextField precio, JTextArea descripcion, JSpinner cantidad, JComboBox<String>categoria) {
	this.nombreField=nombre;
	this.precioField=precio;
	this.descripcionField=descripcion;
	this.cantidadField=cantidad;
	this.categoriaField=categoria;
	this.frame=frame;
}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Controller controller = Controller.getInstance();
		boolean datosCorrectos = true;
		
		String nombre ="";
		double precio = 0;
		String descripcion = "";
		int cantidad = 0;
		String categoria = "";
		
		try {
			nombre = nombreField.getText();
			if (nombre.equals("")) datosCorrectos = false;
			precio = Double.parseDouble(precioField.getText());
			descripcion = descripcionField.getText();
			if (descripcion.equals("")) datosCorrectos = false;
			cantidad = (Integer)cantidadField.getValue();
			if (cantidad <= 0) datosCorrectos = false;
			categoria = categoriaField.getSelectedItem().toString();
			
		}catch(NumberFormatException nfe) {
			datosCorrectos = false;
		}
		
		if(datosCorrectos) {
			controller.addProducto(nombre, precio, descripcion, cantidad, categoria);
			controller.productoOK(frame);
		}else {
			controller.productoFail(frame);
		}
		
		
	}

}
