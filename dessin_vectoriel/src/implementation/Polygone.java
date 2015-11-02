package implementation;

import java.util.ArrayList;
import java.util.List;

import abstraction.Chemin;
import abstraction.Dessin;
import abstraction.Visiteur;
import exception.PolygoneVideException;

public class Polygone implements Chemin {

	private boolean rempli;
	private List<Droite> cotes;

	public Polygone(boolean rempli, List<Droite> cotes) {
		super();
		this.rempli = rempli;
		this.cotes = cotes;
	}

	@Override
	public Position getPosition() {
		//on récupère les positions de toutes les droites qui compose le polygône
		ArrayList<Position> pos = new ArrayList<Position>();
		for(Droite d: cotes){
			pos.add(d.getPosition());
		}

		//on somme les coordonnees de ces positions 
		int x=0;
		int y=0;
		for(Position p : pos){
			x += p.getX();
			y += p.getY();
		}

		//si on a pas de positions (donc pas de côtés) on throw une exception, sinon on pondère la somme par le nombre de côtés
		try {
			if(pos.size()==0)
				throw new PolygoneVideException();
		} catch (PolygoneVideException e) {
			e.printStackTrace();
		} 

		x/=pos.size();
		y/=pos.size();
		return new Position(x, y);
	} 

	@Override
	public void setPosition(Position p) {
		for(Droite d : cotes){
			d.setPosition(p);
		}
	}

	public List<Droite> getCotes() {
		return cotes;
	}

	public void setCotes(List<Droite> cotes) {
		this.cotes = cotes;
	}

	@Override
	public boolean isRempli() {
		return rempli;
	}

	@Override
	public void setRempli(boolean b) {
		rempli = b;
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
