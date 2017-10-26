package controlador.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;

import controlador.Controller;
import modelo.Producto;

public class TablaListener implements MouseListener{
	
	private ArrayList<Producto> productos;
	private JTable table;
	
	public TablaListener(JTable table,ArrayList<Producto> productos) {
		this.table = table;
		this.productos = productos;
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Controller controller = Controller.getInstance();
		controller.abrirVentana("DetallesProducto", productos.get(table.getSelectedRow()), table);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
