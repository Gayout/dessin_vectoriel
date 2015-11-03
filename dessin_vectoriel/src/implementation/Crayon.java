package implementation;

import java.awt.Color;

public class Crayon {
	private int epaisseur;
	private String couleur;
	
	public Crayon(int epaisseur, String couleur) {
		super();
		this.epaisseur = epaisseur;
		this.couleur = couleur;
	}

	public int getEpaisseur() {
		return epaisseur;
	}

	public void setEpaisseur(int epaisseur) {
		this.epaisseur = epaisseur;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
}