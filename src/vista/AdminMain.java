package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.listeners.AceptarNuevoProductoListener;
import controlador.listeners.AddProductoListener;
import controlador.listeners.ListarProductosListener;
import controlador.listeners.ListarUsuariosListener;
import modelo.Usuario;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AdminMain extends JFrame {

	private JTable tableProductos,tableUsers;
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	private JTextField nombreField;
	private JTextField precioField;

	/**
	 * Create the application.
	 */
	public AdminMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// frame = new JFrame();
		this.setBounds(100, 100, 584, 472);
		this.setTitle("Panel Administrador");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("A\u00D1ADIR PRODUCTOS");
		btnNewButton.setBounds(21, 42, 169, 36);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("LISTAR PRODUCTOS");
		btnNewButton_1.setBounds(200, 42, 179, 36);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("CONSULTAR USUARIOS");
		btnNewButton_2.setBounds(389, 42, 169, 36);
		getContentPane().add(btnNewButton_2);

		JPanel panel = new JPanel();
		panel.setBounds(32, 121, 507, 279);
		getContentPane().add(panel);

		JPanel panel2 = new JPanel();
		panel2.setBounds(32, 121, 507, 279);
		getContentPane().add(panel2);

		JPanel panel3 = new JPanel();
		panel3.setBounds(32, 121, 507, 279);
		getContentPane().add(panel3);

		panel.setVisible(false);
		panel2.setVisible(false);
		panel3.setVisible(false);
		
		btnNewButton.setName("add");
		btnNewButton_1.setName("productos");
		btnNewButton_2.setName("usuarios");
		
		// Panel Listar Productos
		tableProductos = new JTable();
		JScrollPane js = new JScrollPane(tableProductos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js.setPreferredSize(new Dimension(489, 270));
		js.setVisible(true);
		tableProductos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panel2.add(js);
		tableProductos.setFillsViewportHeight(true);

		ListarProductosListener lpl = new ListarProductosListener(tableProductos, panel,panel2,panel3,btnNewButton_1);
		btnNewButton_1.addActionListener(lpl);
		panel.setLayout(null);
		
		// Panel añadir productos
		JLabel jlabel = new JLabel("Nuevo producto");
		jlabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		jlabel.setHorizontalAlignment(SwingConstants.CENTER);
		jlabel.setBounds(189, 11, 120, 25);
		panel.add(jlabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(137, 64, 89, 14);
		panel.add(lblNombre);
		
		nombreField = new JTextField();
		nombreField.setBounds(236, 61, 120, 20);
		panel.add(nombreField);
		nombreField.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setBounds(137, 89, 89, 23);
		panel.add(lblPrecio);
		
		precioField = new JTextField();
		precioField.setBounds(236, 92, 120, 20);
		panel.add(precioField);
		precioField.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcin.setBounds(137, 123, 89, 14);
		panel.add(lblDescripcin);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(236, 123, 220, 59);
		panel.add(textArea);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setBounds(137, 195, 89, 14);
		panel.add(lblCantidad);
		
		JSpinner cantidadSpinner = new JSpinner();
		cantidadSpinner.setBounds(236, 193, 29, 20);
		panel.add(cantidadSpinner);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa: ");
		lblCategora.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategora.setBounds(137, 230, 89, 14);
		panel.add(lblCategora);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cama", "Armarios", "Televisores", "Mesas"}));
		comboBox.setBounds(236, 227, 95, 20);
		panel.add(comboBox);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(408, 245, 89, 23);
		panel.add(btnAceptar);
		
		AceptarNuevoProductoListener anpl = new AceptarNuevoProductoListener(this, nombreField, precioField,
				textArea, cantidadSpinner, comboBox);
		btnAceptar.addActionListener(anpl);
		
		AddProductoListener apl = new AddProductoListener(panel,panel2,panel3);
		btnNewButton.addActionListener(apl);
		
		// Panel Listar Usuarios
		tableUsers = new JTable();
		js = new JScrollPane(tableUsers, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js.setPreferredSize(new Dimension(489, 270));
		js.setVisible(true);
		tableUsers.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panel3.add(js);
		tableUsers.setFillsViewportHeight(true);

		ListarUsuariosListener lul = new ListarUsuariosListener(tableUsers, panel,panel2,panel3,btnNewButton_2);
		btnNewButton_2.addActionListener(lul);
		
	}
}
