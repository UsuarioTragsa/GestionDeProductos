package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import controlador.listeners.ComprarListener;
import modelo.Producto;
import modelo.vista.ImagenPanel;

public class DetallesProducto extends JDialog{

	private JTable table;
	private Producto producto;
	private JLabel nombreLabel;
	private JLabel precioField;
	private JLabel euroField;
	private JLabel descripcionField;
	private JLabel stockField;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DetallesProducto window = new DetallesProducto();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public DetallesProducto(Producto producto, JTable table) {
		this.table = table;
		this.producto = producto;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setBounds(190, 190, 584, 472);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setModal(true);
		
		
		ImagenPanel imgPanel = new ImagenPanel(producto.getUrl());
		imgPanel.setBounds(26, 140, 274, 219);
		this.getContentPane().add(imgPanel);
		
		nombreLabel = new JLabel();
		nombreLabel.setText(producto.getNombre());
		nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nombreLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		nombreLabel.setBounds(39, 53, 488, 46);
		getContentPane().add(nombreLabel);
		
		precioField = new JLabel();
		precioField.setText(String.valueOf(producto.getPrecio()));
		precioField.setHorizontalAlignment(SwingConstants.RIGHT);
		precioField.setFont(new Font("Tahoma", Font.BOLD, 21));
		precioField.setBounds(310, 140, 61, 36);
		getContentPane().add(precioField);
		
		euroField = new JLabel();
		euroField.setFont(new Font("Tahoma", Font.BOLD, 21));
		euroField.setText("\u20AC");
		euroField.setHorizontalAlignment(SwingConstants.LEFT);
		euroField.setBounds(382, 140, 53, 36);
		getContentPane().add(euroField);
		
		descripcionField = new JLabel();
		descripcionField.setFont(new Font("Tahoma", Font.BOLD, 14));
		descripcionField.setText("Descripci\u00F3n:");
		descripcionField.setBounds(310, 242, 174, 20);
		getContentPane().add(descripcionField);
		
		JTextArea descripcionArea = new JTextArea();
		descripcionArea.setWrapStyleWord(true);
		descripcionArea.setText(producto.getDescripcionProducto());
		descripcionArea.setBackground(UIManager.getColor("Button.background"));
		descripcionArea.setEditable(false);
		descripcionArea.setLineWrap(true);
		descripcionArea.setBounds(310, 273, 217, 86);
		getContentPane().add(descripcionArea);
		
		stockField = new JLabel();
		stockField.setForeground(Color.BLACK);
		stockField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		stockField.setBounds(310, 196, 174, 27);
		getContentPane().add(stockField);
		
		JButton comprarButton = new JButton("COMPRAR");
		comprarButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		comprarButton.setToolTipText("COMPRAR");
		comprarButton.setBounds(220, 382, 151, 27);
		getContentPane().add(comprarButton);
		
		if(producto.getCantidad() > 0) {
			stockField.setText("EN STOCK");
			stockField.setForeground(Color.green);
			comprarButton.setEnabled(true);
		}else {
			stockField.setText("NO DISPONIBLE");
			stockField.setForeground(Color.red);
			comprarButton.setEnabled(false);
		}//if-else
		
		ComprarListener cl = new ComprarListener(this, producto, table);
		comprarButton.addActionListener(cl);
		
	}
}
