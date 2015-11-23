package implementation;
/**
 * <b>Position remprésente l'emplacement d'un pixel sur un écran</b>
 * @author Aurore Claude/Quentin Gayout
 *
 */
public class Position {
	/**
	 * la position en x du pixel
	 * @see Position#getX()
	 * @see Position#setX(int)
	 */
	private int x;
	
	/**
	 * la position en y du pixel
	 * @see Position#getY()
	 * @see Position#setY(int)
	 */
	private int y;

	/**
	 * Constructeur complet
	 * @param x
	 * 	x
	 * @param y
	 * 	y
	 */
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * @see Position#x
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Change x
	 * @see Position#x
	 * @param x
	 * 	x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @see Position#y
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Change y
	 * @see Position#y
	 * @param y
	 * 	y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * La fabrique d'une position
	 * @param x
	 * 	x
	 * @param y
	 * 	y
	 * @return une position
	 */
	public Position creerPosition(int x, int y){
		return new Position(x, y);
	}
}
