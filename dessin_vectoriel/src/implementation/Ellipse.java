package implementation;

import abstraction.Visiteur;
import interpreteur.awt.CercleAWT;
import interpreteur.awt.EllipseAWT;
import interpreteur.svg.CercleSVG;
import interpreteur.svg.EllipseSVG;

public class Ellipse extends Cercle {
	
	private int petitAxe;
	private long angleAbsGdAxe;
	
	public Ellipse() {
		super();
	}
	
	public Ellipse(Position centre, int gdAxe, int petitAxe, long angleAbsGdAxe, boolean isRempli) {
		super(centre, gdAxe, isRempli);
		this.petitAxe = petitAxe;
		this.angleAbsGdAxe = angleAbsGdAxe;
	}

	public int getGdAxe() {
		return super.getRayon();
	}

	public void setGdAxe(int gdAxe) {
		super.setRayon(gdAxe);
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
	public void accept(Visiteur visiteur) {
		visiteur.visit(this);
	}
	
	@Override
	public Ellipse creerEllipse(Position centre, int gdAxe, int petitAxe, long angleAbsGdAxe, boolean rempli){
		return new Ellipse(centre, gdAxe, petitAxe, angleAbsGdAxe,rempli);
	}
	
	@Override
	public Cercle creerCercle(Position centre, int rayon, boolean rempli){
		return null;
	}
	@Override
	public CercleSVG creerCercleSVG() {
		return null;
	}

	@Override
	public CercleAWT creerCercleAWT() {
		return null;
	}
	
	public EllipseSVG creerEllipseSVG() {
		return new EllipseSVG(this);
	}

	public EllipseAWT creerEllipseAWT() {
		return new EllipseAWT(this);
	}
}
