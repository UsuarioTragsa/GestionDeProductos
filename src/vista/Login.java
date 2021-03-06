package vista;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.listeners.HomeToRegistroListener;
import controlador.listeners.LoginListener;
import modelo.vista.ImagenPanel;

public class Login extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		this.setBounds(100, 100, 584, 472);
		this.setTitle("Log in");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(315, 27, 99, 21);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(315, 59, 84, 21);
		this.getContentPane().add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(402, 29, 145, 20);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(402, 59, 145, 20);
		this.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(315, 104, 99, 23);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.setBounds(432, 104, 115, 23);
		this.getContentPane().add(btnNewButton_1);
		
		ImagenPanel imagenPanel = new ImagenPanel("./resources/imgs/muebles-1.jpg");
		imagenPanel.setBounds(27, 182, 520, 229);
		this.getContentPane().add(imagenPanel);
		
		ImagenPanel logoPanel = new ImagenPanel("./resources/imgs/logo.jpg");
		logoPanel.setBounds(27, 11, 199, 140);
		this.getContentPane().add(logoPanel);
		
		HomeToRegistroListener hr = new HomeToRegistroListener(this);
		btnNewButton_1.addActionListener(hr);
		LoginListener ll = new LoginListener(this, textField, passwordField);
		btnNewButton.addActionListener(ll);
		
	}

}
