package implementation;

import abstraction.Chemin;

public class Ellipse extends Chemin {
	private Position centre;
	private int gdAxe;
	private int petitAxe;
	private long angleAbsGdAxe;
	private boolean rempli;
	
	public Ellipse() {
		super();
	}
	
	public Ellipse(Position centre, int gdAxe, int petitAxe, long angleAbsGdAxe, boolean isRempli) {
		super();
		this.centre = centre;
		this.gdAxe = gdAxe;
		this.petitAxe = petitAxe;
		this.angleAbsGdAxe = angleAbsGdAxe;
		this.rempli = isRempli;
	}
	
	public Position getCentre() {
		return centre;
	}

	public void setCentre(Position centre) {
		this.centre = centre;
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

	public boolean isRempli() {
		return rempli;
	}

	public void setRempli(boolean isRempli) {
		this.rempli = isRempli;
	}
}
