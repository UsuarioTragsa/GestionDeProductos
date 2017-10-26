package controlador.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controlador.Controller;
import modelo.Usuario;

public class ListarUsuariosListener implements ActionListener{
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	private JTable table;
	private JPanel panelProductos,panel,panelUsers;
	private JButton boton;
	
	public ListarUsuariosListener(JTable table, JPanel panel, JPanel panelProductos, JPanel panelUsers, JButton boton) {
		this.table = table;
		this.panelProductos = panelProductos;
		this.panel = panel;
		this.panelUsers = panelUsers;
		this.boton = boton;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		Controller controller = Controller.getInstance();
		usuarios = controller.obtenerUsuarios();
		
		llenarUsuarios();
		personalizarTabla();
		
		controller.verPanel(panelProductos, panel, panelUsers,boton);
	}
	private void llenarUsuarios() {
		String matriz[][] = new String[usuarios.size()][5];
		for (int i = 0; i < usuarios.size(); i++) {	
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			
			matriz[i][0] = usuarios.get(i).getNombre();
			matriz[i][1] = usuarios.get(i).getDni();
			matriz[i][2] = usuarios.get(i).getDomicilio();
			matriz[i][3] = df.format(usuarios.get(i).getFechaNacimiento());
			matriz[i][4] = usuarios.get(i).getMail();
		} // for
			// Creo un array que contenga las cabeceras de la tabla
		String cabecera[] = { "Nombre", "DNI", "Domicilio", "Fecha de nacimiento", "email" };
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
		table.getColumnModel().getColumn(0).setPreferredWidth(75);
		table.getColumnModel().getColumn(1).setPreferredWidth(75);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(75);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);

		
		// Centro el texto de cada columna
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(tcr);
		}//for
	}//personalizarTabla
}
