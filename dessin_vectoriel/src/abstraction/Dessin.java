package abstraction;

public interface Dessin extends FabriqueDessin<Dessin>{
	
	public static final boolean OUVERT = true;
	public static final boolean FERME = false;
	public static final boolean REMPLI = true;
	public static final boolean VIDE = false;
	
	public void accept(Visiteur visiteur);
	
}