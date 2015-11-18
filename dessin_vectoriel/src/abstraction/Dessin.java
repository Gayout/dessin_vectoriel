package abstraction;

public interface Dessin extends FabriqueDessin<Dessin>{
	
	public void accept(Visiteur visiteur);
	
}