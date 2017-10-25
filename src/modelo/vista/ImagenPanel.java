package modelo.vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagenPanel extends JPanel {

	private BufferedImage imagen;

	public ImagenPanel(String path) {
		try {
			imagen = ImageIO.read(new File(path));

		} catch (IOException ex) {
			
		}
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

		setOpaque(false);
		super.paint(g);
	}
}
