package implementation;

import abstraction.Chemin;
import abstraction.Dessin;

public class Segment extends Chemin{
	private Position depart;
	private Position arrivee;
	
	public Segment(Position p1, Position p2){
		this.depart=p1;
		this.arrivee=p2;
	}
	
	public Segment(){
		super();
	}
	
	public Position getDepart() {
		return depart;
	}

	public Position getArrivee() {
		return arrivee;
	}
	
	@Override
	public boolean isRempli() {
		return false;
	}

	@Override
	public void setRempli(boolean b) {
	}

	@Override
	public Dessin creerSegment(Position p1, Position p2) {
		return new Segment(p1, p2);
	}

}
