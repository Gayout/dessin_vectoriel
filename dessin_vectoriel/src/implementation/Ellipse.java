package implementation;

import java.util.List;

import abstraction.Chemin;
import abstraction.Dessin;

public class Ellipse implements Chemin {
	private Position htGauche;
	private int gdAxe;
	private int petitAxe;
	private long angleAbsGdAxe;
	private boolean isRempli;
	
	public Ellipse() {
		super();
	}
	
	public Ellipse(Position htGauche, int gdAxe, int petitAxe, long angleAbsGdAxe, boolean isRempli) {
		super();
		this.htGauche = htGauche;
		this.gdAxe = gdAxe;
		this.petitAxe = petitAxe;
		this.angleAbsGdAxe = angleAbsGdAxe;
		this.isRempli = isRempli;
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

	public boolean getIsRempli() {
		return isRempli;
	}

	public void setIsRempli(boolean isRempli) {
		this.isRempli = isRempli;
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

	@Override
	public Dessin creerCercle(Position centre, int rayon, boolean rempli) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dessin creerCourbeBezier(boolean rempli, List<Position> pointControle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dessin creerDessinComposite(List<Dessin> dessins) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dessin creerPolygone(boolean rempli, List<Position> sommets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dessin creerSegment(Position p1, Position p2) {
		// TODO Auto-generated method stub
		return null;
	}
}
