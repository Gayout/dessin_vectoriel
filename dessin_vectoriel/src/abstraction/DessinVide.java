package abstraction;

public class DessinVide implements Dessin {

	public static final DessinVide VIDE = new DessinVide();
	
	public DessinVide() {
	}

	@Override
	public void accept(Visiteur visiteur) {
	}

}