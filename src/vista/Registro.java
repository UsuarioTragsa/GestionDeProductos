package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controlador.DateLabelFormatter;
import controlador.listeners.AceptarRegistroListener;

import javax.swing.SpringLayout;

public class Registro extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private SpringLayout springLayout;

	//private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro window = new Registro();
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
	public Registro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 584, 472);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(106, 79, 93, 14);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(126, 117, 73, 14);
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		this.getContentPane().add(lblDni);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDomicilio.setBounds(106, 157, 93, 18);
		this.getContentPane().add(lblDomicilio);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(119, 197, 80, 14);
		this.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(116, 240, 85, 14);
		this.getContentPane().add(lblPassword);
		
		JLabel lblRepetirPassword = new JLabel("Repetir Password:");
		lblRepetirPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepetirPassword.setBounds(70, 274, 129, 14);
		this.getContentPane().add(lblRepetirPassword);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeNacimiento.setBounds(57, 301, 142, 22);
		this.getContentPane().add(lblFechaDeNacimiento);
		
		JLabel lblRellenaTusDatos = new JLabel("Rellena tus datos:");
		lblRellenaTusDatos.setFont(new Font("Systematic J", Font.ITALIC, 15));
		lblRellenaTusDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblRellenaTusDatos.setBounds(190, 30, 204, 14);
		getContentPane().add(lblRellenaTusDatos);
		
		textField = new JTextField();
		textField.setBounds(215, 76, 249, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(215, 114, 93, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(215, 156, 249, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(215, 194, 249, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(215, 237, 174, 20);
		getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(215, 271, 174, 20);
		getContentPane().add(passwordField_1);
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.setBounds(106, 356, 106, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ATR\u00C1S");
		btnNewButton_1.setBounds(298, 356, 106, 23);
		getContentPane().add(btnNewButton_1);
		
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Hoy");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		//datePicker.getJFormattedTextField().setBounds(0, 0, 84, 23);
		 
		datePicker.setBounds(214, 301, 150, 30);
		this.getContentPane().add(datePicker);
		
//		datePicker.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				Date selectedDate = (Date) datePicker.getModel().getValue();
//				DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
//				String fechaFormateada = df.format(selectedDate.getTime());
//				System.out.println(selectedDate);
//				
//			}
//		});
		AceptarRegistroListener arl = new AceptarRegistroListener(this, textField, textField_1, textField_2, 
				textField_3, passwordField, passwordField_1, datePicker);
		btnNewButton.addActionListener(arl);
	}
}
