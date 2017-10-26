package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controlador.Controller;
import controlador.listeners.TablaListener;
import modelo.Producto;
import modelo.Usuario;
import modelo.vista.ImagenPanel;

public class ClienteMain extends JFrame{
	
	private Usuario user;
	private JTable table;
	private ArrayList<Producto> productos = new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteMain window = new ClienteMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public ClienteMain(Usuario user) {
		this.user = user;
		cargaProductos();
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		
		this.setBounds(100, 100, 584, 472);
		this.setTitle("Panel de compras");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido, "+user.getNombre());
		lblBienvenido.setHorizontalAlignment(SwingConstants.LEFT);
		lblBienvenido.setBounds(385, 28, 173, 14);
		getContentPane().add(lblBienvenido);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(39, 131, 489, 274);
		getContentPane().add(panel);
		
		table = new JTable();
		
		JScrollPane js = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js.setPreferredSize(new Dimension(489, 270));
		js.setVisible(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panel.add(js);
		
		table.setFillsViewportHeight(true);
		
		
		//getContentPane().add(table);
		String matriz [][] = new String[productos.size()][4];
		for(int i = 0; i < productos.size(); i++) {
			matriz[i][0] = productos.get(i).getNombre();
			matriz[i][1] = String.valueOf(productos.get(i).getPrecio());
			matriz[i][2] = String.valueOf(productos.get(i).getCantidad());
			matriz[i][3] = productos.get(i).getCategoria();
		}//for
		// Creo un array que contenga las cabeceras de la tabla
		String cabecera [] = {"Nombre","Precio","Cantidad","Categoría"};
		// Añado la matriz y la cabecera al modelo
		DefaultTableModel dtm = new DefaultTableModel(matriz, cabecera) {
			@Override
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		};
		table.setModel(dtm);
		
		JLabel lblListaDeProductos = new JLabel("LISTA DE PRODUCTOS");
		lblListaDeProductos.setFont(new Font("Verdana", Font.BOLD, 13));
		lblListaDeProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeProductos.setBounds(184, 85, 181, 35);
		getContentPane().add(lblListaDeProductos);
		
		ImagenPanel panel_1 = new ImagenPanel("./resources/imgs/logo.jpg");
		panel_1.setBounds(39, 28, 85, 78);
		getContentPane().add(panel_1);
		
		personalizarTabla();
		
		TablaListener tl = new TablaListener(table,productos);
		table.addMouseListener(tl);

	}
	
	public void cargaProductos() {
		Controller controller = Controller.getInstance();
		productos = controller.obtenerProductos();
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
