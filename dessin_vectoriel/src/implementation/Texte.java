package implementation;

import java.awt.Font;

import abstraction.Dessin;

public class Texte implements Dessin {
	private int taillePolice;
	private String police;
	private Font effet;
	private Position htGauche;

	public Texte() {
		super();
	}
	
	public Texte(int taillePolice, String police, Font effet, Position htGauche) {
		super();
		this.taillePolice = taillePolice;
		this.police = police;
		this.effet = effet;
		this.htGauche = htGauche;
	}

	public int getTaillePolice() {
		return taillePolice;
	}

	public void setTaillePolice(int taillePolice) {
		this.taillePolice = taillePolice;
	}

	public String getPolice() {
		return police;
	}

	public void setPolice(String police) {
		this.police = police;
	}

	public Font getEffet() {
		return effet;
	}

	public void setEffet(Font effet) {
		this.effet = effet;
	}

	public Position getHtGauche() {
		return htGauche;
	}

	public void setHtGauche(Position htGauche) {
		this.htGauche = htGauche;
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
}