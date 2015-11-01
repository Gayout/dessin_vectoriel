package abstraction;

public interface Dessin {
	
	public void dessiner();
	public void remplir();
	public void inserer(Dessin d);
	public void etiqueter(String m);
	void accept(Visiteur visiteur);
}