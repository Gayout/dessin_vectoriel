package abstraction;

import implementation.Crayon;
import implementation.Position;

public abstract class Chemin implements Dessin{
	private Crayon crayon= Crayon.CRAYON_DEFAUT;
	
	public Crayon getCrayon() {
		return crayon;
	}
	public void setCrayon(Crayon crayon) {
		this.crayon = crayon;
	}
	public abstract boolean isRempli();
	public abstract void setRempli(boolean b);
}