package implementation;

import java.util.List;

import abstraction.Chemin;
import abstraction.Dessin;
import abstraction.Visiteur;

public class Segment implements Chemin{
	private Position depart;
	private Position arrivee;
	
	public Segment(Position p1, Position p2){
		this.depart=p1;
		this.arrivee=p2;
	}
	
	public Position getDepart() {
		return depart;
	}

	public Position getArrivee() {
		return arrivee;
	}
	
	@Override
	public Position getPosition() {
		return new Position((depart.getX()+arrivee.getX())/2, (depart.getY()+arrivee.getY())/2 );
	}

	@Override
	public void setPosition(Position p) {
		int dx = p.getX() -this.getPosition().getX();
		int dy = p.getY() -this.getPosition().getY();
		
		depart.setX(depart.getX()+dx);
		depart.setY(depart.getY()+dy);
		
		arrivee.setX(arrivee.getX()+dx);
		arrivee.setY(arrivee.getY()+dy);
	}

	@Override
	public boolean isRempli() {
		return false;
	}

	@Override
	public void setRempli(boolean b) {
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
	public Dessin creerCercle(Position centre, int rayon, boolean rempli) {
		return null;
	}

	@Override
	public Dessin creerCourbeBezier(boolean rempli, List<Position> pointControle) {
		return null;
	}

	@Override
	public Dessin creerDessinComposite(List<Dessin> dessins) {
		return null;
	}

	@Override
	public Dessin creerPolygone(boolean rempli, List<Position> sommets) {
		return null;
	}

	@Override
	public Dessin creerSegment(Position p1, Position p2) {
		return new Segment(p1, p2);
	}

}
