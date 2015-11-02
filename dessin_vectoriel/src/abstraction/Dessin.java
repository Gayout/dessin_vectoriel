package abstraction;

public interface Dessin extends FabriqueDessin<Dessin>{
	
	public default void accept(Visiteur visiteur){
		visiteur.visit(this);
	}
}