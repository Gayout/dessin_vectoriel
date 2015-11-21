package implementation;

import abstraction.Chemin;
import abstraction.Dessin;
import abstraction.Visiteur;
import interpreteur.awt.RectangleAWT;
import interpreteur.svg.RectangleSVG;

public class Rectangle extends Chemin{

	private Position hautGauche;
	private int width;
	private int height;
	private boolean rempli;
	
	public Rectangle(Position hautGauche, int width, int height, boolean isRempli) {
		this.hautGauche = hautGauche;
		this.width = width;
		this.height = height;
		this.rempli = isRempli;
	}

	public Rectangle() {
		super();
	}

	public boolean isRempli() {
		return rempli;
	}

	public void setRempli(boolean isRempli) {
		this.rempli = isRempli;
	}
	
	public Position getHautGauche() {
		return hautGauche;
	}

	public void setHautGauche(Position hautGauche) {
		this.hautGauche = hautGauche;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public Dessin creerRectangle(Position hautGauche, int width, int height, boolean isRempli) {
		return new Rectangle(hautGauche, width, height, isRempli);
	}

	public RectangleSVG creerRectangleSVG(){
		return new RectangleSVG(this);
	}
	
	@Override
	public void accept(Visiteur visiteur) {
		visiteur.visit(this);
	}

	public RectangleAWT creerRectangleAWT() {
		return new RectangleAWT(this);
	}
	
}
