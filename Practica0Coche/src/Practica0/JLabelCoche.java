package Practica0;

import java.awt.Image;
import java.net.URL;

import javax.swing.*;

public class JLabelCoche extends JLabel{
	
	
	
	public JLabelCoche() {
		super();
		URL cocheURL = getClass().getResource("coche.png");
		ImageIcon icono = new ImageIcon(cocheURL);
		Image imagenCoche = icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		icono = new ImageIcon(imagenCoche);
		setIcon(icono);
		setSize(100, 100);
		
	}
	
	
	


	



}
