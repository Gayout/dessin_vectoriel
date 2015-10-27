package abstraction;

import implementation.Position;

public interface Chemin {
	public Position getPosition();
	public void setPosition(Position p);
	public boolean isRempli();
	public void setRempli(boolean b);
}