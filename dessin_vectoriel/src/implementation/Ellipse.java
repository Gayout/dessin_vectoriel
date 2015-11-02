package implementation;

import abstraction.Chemin;
import abstraction.Dessin;

public class Ellipse implements Chemin {
	private Position htGauche;
	private int gdAxe;
	private int petitAxe;
	private long angleAbsGdAxe;
	
	public Ellipse() {
		super();
	}
	
	public Ellipse(Position htGauche, int gdAxe, int petitAxe, long angleAbsGdAxe) {
		super();
		this.htGauche = htGauche;
		this.gdAxe = gdAxe;
		this.petitAxe = petitAxe;
		this.angleAbsGdAxe = angleAbsGdAxe;
	}
	
	public Position getHtGauche() {
		return htGauche;
	}

	public void setHtGauche(Position htGauche) {
		this.htGauche = htGauche;
	}

	public int getGdAxe() {
		return gdAxe;
	}

	public void setGdAxe(int gdAxe) {
		this.gdAxe = gdAxe;
	}

	public int getPetitAxe() {
		return petitAxe;
	}

	public void setPetitAxe(int petitAxe) {
		this.petitAxe = petitAxe;
	}

	public long getAngleAbsGdAxe() {
		return angleAbsGdAxe;
	}

	public void setAngleAbsGdAxe(long angleAbsGdAxe) {
		this.angleAbsGdAxe = angleAbsGdAxe;
	}

	@Override
	public void dessiner() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remplir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserer(Dessin d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void etiqueter(String m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPosition(Position p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isRempli() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRempli(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
