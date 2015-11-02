package abstraction;

import java.util.List;

import implementation.Position;

public class DessinVide implements Dessin {

	public static final DessinVide VIDE = new DessinVide();
	
	public DessinVide() {
	}

	@Override
	public void dessiner() {		
	}

	@Override
	public void remplir() {
	}

	@Override
	public void inserer(Dessin d) {
	}

	@Override
	public void etiqueter(String m) {
	}

	@Override
	public void accept(Visiteur visiteur) {
	}

}