package abstraction;

import implementation.Position;
import implementation.Crayon;

public interface Chemin extends Dessin{
	Crayon crayon= new Crayon(0, null);
	
	public Position getPosition();
	public void setPosition(Position p);
	public boolean isRempli();
	public void setRempli(boolean b);
}