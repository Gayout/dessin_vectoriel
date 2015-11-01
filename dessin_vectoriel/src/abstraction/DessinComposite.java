package abstraction;

import java.util.List;

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

}
