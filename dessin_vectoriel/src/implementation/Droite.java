package implementation;

import abstraction.Chemin;
import abstraction.Dessin;
import abstraction.Visiteur;

public class Droite implements Chemin{
	private Position depart;
	private Position arrivee;
	
	public Droite(Position p1, Position p2){
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
	public void accept(Visiteur visiteur) {
		// TODO Auto-generated method stub
		
	}

}
