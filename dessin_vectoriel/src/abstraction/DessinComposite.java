package abstraction;

import java.util.List;

public class DessinComposite implements Dessin {
	
	private List<Dessin> dessins;
	
	public DessinComposite(List<Dessin> dessins) {
		super();
		this.dessins = dessins;
	}

	public DessinComposite() {
		super();
	}

	public List<Dessin> getDessins() {
		return dessins;
	}

	public void setDessins(List<Dessin> dessins) {
		this.dessins = dessins;
	}

	@Override
	public void accept(Visiteur visiteur) {
		for (Dessin d : dessins){
			d.accept(visiteur);
		}		
	}

	@Override
	public Dessin creerDessinComposite(List<Dessin> dessins) {
		return new DessinComposite(dessins);
	}

}
