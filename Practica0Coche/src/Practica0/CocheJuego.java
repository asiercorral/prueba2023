package Practica0;

public class CocheJuego extends Coche{
	
	protected JLabelCoche jLblCoche;

	public JLabelCoche getCoche() {
		return jLblCoche;
	}

	public void setCoche(JLabelCoche jLblCoche) {
		this.jLblCoche = jLblCoche;
	}

	public CocheJuego(JLabelCoche jLblCoche) {
		super();
		this.jLblCoche = jLblCoche;
	}
	
	public CocheJuego() {
		super();
		this.jLblCoche = new JLabelCoche();
	}
	
	@Override
	public void mueve(double tiempoDeMovimiento) {
		// TODO Auto-generated method stub
		super.mueve(tiempoDeMovimiento);
		jLblCoche.setBounds((int)posX, (int) posY, 100, 100);
	}
	
	

}
