package controlador.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import controlador.Controller;

public class AddProductoListener implements ActionListener {

	private JPanel panelProductos, panel, panelUsers;

	public AddProductoListener(JPanel panel, JPanel panelProductos, JPanel panelUsers) {

		this.panelProductos = panelProductos;
		this.panel = panel;
		this.panelUsers = panelUsers;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton)e.getSource();
		Controller controller = Controller.getInstance();
		controller.verPanel(panelProductos, panel, panelUsers,boton);
	}

}
