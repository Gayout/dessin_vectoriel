package abstraction;

public interface Dessin extends FabriqueDessin<Dessin>{
	
	public void dessiner();
	public void remplir();
	public void inserer(Dessin d);
	public void etiqueter(String m);
	public default void accept(Visiteur visiteur){
		visiteur.visit(this);
	}
}