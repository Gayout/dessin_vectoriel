package implementation;

import java.util.List;

import abstraction.Chemin;
import abstraction.Dessin;
import abstraction.Visiteur;
import exception.PolygoneVideException;
import interpreteur.awt.PolygoneAWT;
import interpreteur.svg.PolygoneSVG;

public class Polygone extends Chemin {

	private boolean rempli;
	private boolean ouvert;
	private List<Position> sommets;
	
	// un polygone est défini par ses cotes, mais on le construit en lui donnant tous ses sommets
	public Polygone(List<Position> sommets, boolean ouvert, boolean rempli) {
		super();
		this.rempli = rempli;
		this.sommets = sommets;
		this.ouvert = ouvert;

		//on regarde si la liste de points a moins de 2 points, si elle en a moins on envoie une erreur
		try{
			if(sommets.size()<2){
				throw new PolygoneVideException();
			}
		}
		catch(PolygoneVideException e){
			e.printStackTrace();
		}
	}

	public Polygone() {
		super();
	}

	public List<Position> getSommets() {
		return sommets;
	}

	public void setSommets(List<Position> sommets) {
		this.sommets = sommets;
	}

	public boolean isOuvert() {
		return ouvert;
	}

	public void setOuvert(boolean ouvert) {
		this.ouvert = ouvert;
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
	public Dessin creerPolygone(List<Position> sommets, boolean ouvert, boolean rempli) {
		return new Polygone(sommets, ouvert, rempli);
	}

	@Override
	public void accept(Visiteur visiteur) {
		visiteur.visit(this);
	}

	public PolygoneSVG creerPolygoneSVG() {
		return new PolygoneSVG(this);
	}

	public PolygoneAWT creerPolygoneAWT() {
		return new PolygoneAWT(this);
	}

}
