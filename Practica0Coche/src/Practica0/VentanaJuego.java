package Practica0;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;



public class VentanaJuego extends JFrame{
	
	
	
	protected JPanel pnlCentral;
	protected JPanel pnlBotones;
	protected JButton acelerar;
	protected JButton frenar;
	protected JButton izquierda;
	protected JButton derecha;
	
	public VentanaJuego() {
		this.setLayout(new BorderLayout());
		
		
		
		pnlCentral = new JPanel();
		
		this.add(pnlCentral, BorderLayout.CENTER);
		
		pnlBotones = new JPanel();
		
		this.add(pnlBotones, BorderLayout.SOUTH);
		
		acelerar = new JButton("Acelerar");
		pnlBotones.add(acelerar);
		
		frenar = new JButton("Frenar");
		pnlBotones.add(frenar);
		
		izquierda = new JButton("Izquierda");
		pnlBotones.add(izquierda);
		
		derecha = new JButton("Derecha");
		pnlBotones.add(derecha);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("JUEGO");
		this.setSize(800, 600);
		this.setVisible(true);
	}
	
	
	
	
	public static void main(String[] args) {
		
		VentanaJuego ventana = new VentanaJuego();
		
		
		CocheJuego coche = new CocheJuego();
		ventana.pnlCentral.add(coche.jLblCoche);
		ventana.repaint();
		
			
		Thread hilo = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				while (ventana.isVisible()){
					
					double altura = ventana.getHeight();
					double anchura = ventana.getWidth();
					
					if (coche.posX<0 || coche.posX + 100>anchura) {
						if (coche.miDireccionActual<=0) {
							coche.miDireccionActual = -180-coche.miDireccionActual;
						} else {
							coche.miDireccionActual = +180-coche.miDireccionActual;
						}
						
					}
					
					if (coche.posY<0 || coche.posY + 100>altura) {
							coche.miDireccionActual = -coche.miDireccionActual;
						}
					
					
					coche.mueve(0.04);
					ventana.repaint();
					
					try {
						Thread.sleep(40);
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				
			
			}
			
		});
		hilo.start();
		
		ventana.acelerar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(5);
			}
		});
		
		ventana.frenar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(-5);	
				
			}
		});
		
		ventana.izquierda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				coche.gira(-10);
				System.out.println(coche.miDireccionActual);
				
			}
		});
		
		ventana.derecha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				coche.gira(10);
				System.out.println(coche.miDireccionActual);
			}
		});
		
		
		
		

	}

}