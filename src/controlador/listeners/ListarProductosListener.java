package controlador.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controlador.Controller;
import modelo.Producto;

public class ListarProductosListener implements ActionListener {
	private ArrayList<Producto> productos = new ArrayList<>();
	private JTable table;
	private JPanel panelProductos,panel,panelUsers;
	private JButton boton;
	
	public ListarProductosListener(JTable table, JPanel panel, JPanel panelProductos, JPanel panelUsers, JButton boton) {
		this.table = table;
		this.panelProductos = panelProductos;
		this.panel = panel;
		this.panelUsers = panelUsers;
		this.boton = boton;
	}
	@Override
	public void actionPerformed(ActionEvent e) {		
		Controller controller = Controller.getInstance();
		productos = controller.obtenerProductos();
		llenarProductos();
		personalizarTabla();
		
		controller.verPanel(panelProductos, panel, panelUsers,boton);
	}

	private void llenarProductos() {
		String matriz[][] = new String[productos.size()][4];
		for (int i = 0; i < productos.size(); i++) {
			matriz[i][0] = productos.get(i).getNombre();
			matriz[i][1] = String.valueOf(productos.get(i).getPrecio());
			matriz[i][2] = String.valueOf(productos.get(i).getCantidad());
			matriz[i][3] = productos.get(i).getCategoria();
		} // for
			// Creo un array que contenga las cabeceras de la tabla
		String cabecera[] = { "Nombre", "Precio", "Cantidad", "Categoría" };
		// Añado la matriz y la cabecera al modelo
		DefaultTableModel dtm = new DefaultTableModel(matriz, cabecera) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(dtm);
	}
	public void personalizarTabla() {		
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(93);
		table.getColumnModel().getColumn(2).setPreferredWidth(93);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);

		
		// Centro el texto de cada columna
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(tcr);
		}//for
	}//personalizarTabla

}
