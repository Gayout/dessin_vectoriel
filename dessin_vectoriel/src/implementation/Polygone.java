package implementation;

import java.util.ArrayList;
import java.util.List;

import abstraction.Chemin;
import abstraction.Dessin;
import abstraction.DessinVide;
import abstraction.FabriqueDessin;
import abstraction.Visiteur;
import exception.PolygoneVideException;

public class Polygone implements Chemin {

	private boolean rempli;
	private List<Segment> cotes;

	// un polygone est d�fini par ses cotes, mais on le construit en lui donnant tous ses sommets
	public Polygone(boolean rempli, List<Position> sommets) {
		super();
		this.rempli = rempli;
		
		//on regarde si la liste de points a moins de 2 points, si elle en a moins on envoie une erreur
		try{
			if(sommets.size()<2){
				throw new PolygoneVideException();
			}
		}
		catch(PolygoneVideException e){
			e.printStackTrace();
		}

		//on creer une fabrique de segment pour d�finir les cot�s du polygone � partir des sommets en param�tre
		FabriqueDessin<Dessin> fab = new Segment(null,null);
		int size = sommets.size();
		for(int i=0; i<size; i++){
			this.cotes.add(
					(Segment) fab.creerSegment(
							sommets.get(i), sommets.get((i+1)%size) //i+1 % size vaut toujours i+1 sauf quand i vaut size-1 auquel cas i+1 vaut 0 et on ferme le polygone
							)
					);
		}
		
	}

	@Override
	public Position getPosition() {
		//on r�cup�re les positions de toutes les droites qui compose le polyg�ne
		ArrayList<Position> pos = new ArrayList<Position>();
		for(Segment d: cotes){
			pos.add(d.getPosition());
		}

		//on somme les coordonnees de ces positions 
		int x=0;
		int y=0;
		for(Position p : pos){
			x += p.getX();
			y += p.getY();
		}

		//sinon on pond�re la somme par le nombre de c�t�s
		x/=pos.size();
		y/=pos.size();
		return new Position(x, y);
	} 

	@Override
	public void setPosition(Position p) {
		for(Segment d : cotes){
			d.setPosition(p);
		}
	}

	public List<Segment> getCotes() {
		return cotes;
	}

	public void setCotes(List<Segment> cotes) {
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
		return new Polygone(rempli, sommets);
	}

	@Override
	public Dessin creerSegment(Position p1, Position p2) {
		return null;
	}

}
