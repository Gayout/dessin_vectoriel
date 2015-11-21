package implementation;

import java.awt.Color;

import abstraction.Chemin;
import abstraction.Dessin;
import abstraction.Visiteur;
import interpreteur.awt.CercleAWT;
import interpreteur.svg.CercleSVG;

public class Cercle extends Chemin{

	private Position centre;
	private int gdAxe;
	private boolean rempli;

	
	public Cercle(Position centre, int rayon, boolean isRempli) {
		this.centre = centre;
		this.gdAxe = rayon;
		this.rempli = isRempli;
	

	}

	public Cercle() {
		super();
	}

	public Position getCentre() {
		return centre;
	}

	public void setCentre(Position centre) {
		this.centre = centre;
	}

	public int getRayon() {
		return this.gdAxe;
	}

	public void setRayon(int rayon) {
		this.gdAxe= rayon;
	}

	public boolean isRempli() {
		return rempli;
	}

	public void setRempli(boolean isRempli) {
		this.rempli = isRempli;
	}
	@Override
	public Dessin creerCercle(Position centre, int rayon, boolean rempli) {
		return new Cercle(centre, rayon, rempli);
	}
	
	public CercleSVG creerCercleSVG() {
		return new CercleSVG(this);
	}
	
	public CercleAWT creerCercleAWT(){
		return new CercleAWT(this);
	}
	
	public void accept(Visiteur visiteur){
		visiteur.visit(this);
	}
	
}
