package abstraction;

import java.util.List;

import implementation.Position;

public class DessinComposite implements Dessin {
	
	private List<Dessin> dessins;
	
	public DessinComposite(List<Dessin> dessins) {
		super();
		this.dessins = dessins;
	}

	public List<Dessin> getDessins() {
		return dessins;
	}

	public void setDessins(List<Dessin> dessins) {
		this.dessins = dessins;
	}

	@Override
	public void dessiner() {
		for (Dessin d : dessins){
			d.dessiner();
		}
	}

	@Override
	public void remplir() {
		for (Dessin d : dessins){
			d.remplir();
		}		
	}

	@Override
	public void inserer(Dessin d) {
		dessins.add(d);
	}

	@Override
	public void etiqueter(String m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visiteur visiteur) {
		for (Dessin d : dessins){
			d.accept(visiteur);
		}		
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
	public Dessin creerDessinVide() {
		return DessinVide.VIDE;
	}

	@Override
	public Dessin creerDessinComposite(List<Dessin> dessins) {
		return new DessinComposite(dessins);
	}

	@Override
	public Dessin creerPolygone(boolean rempli, List<Position> sommets) {
		return null;
	}

	@Override
	public Dessin creerSegment(Position p1, Position p2) {
		return null;
	}

}
