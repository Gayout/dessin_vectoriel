package implementation;

import abstraction.Chemin;

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

}
