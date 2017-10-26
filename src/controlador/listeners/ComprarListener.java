package controlador.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.Controller;
import modelo.Producto;

public class ComprarListener implements ActionListener{

	private JTable table;
	private JDialog dialog;
	private Producto p;
	
	public ComprarListener(JDialog dialog, Producto p, JTable table ) {
		this.dialog = dialog;
		this.p = p;
		this.table = table;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Controller controller = Controller.getInstance();
		controller.comprarProducto(p);
		controller.compraOk(dialog);
		p.setCantidad(p.getCantidad() - 1);
		
		DefaultTableModel tm = (DefaultTableModel) table.getModel();
		String dato=String.valueOf(tm.getValueAt(table.getSelectedRow(),2));
		int nuevaCantidad = Integer.parseInt(dato) - 1;
		tm.setValueAt(nuevaCantidad, table.getSelectedRow(), 2);
		
		controller.cerrarVentana(dialog);
		
	}

}
