package exception;

import implementation.CourbeBezier;
import interpreteur.awt.CourbeBezierAWT;

/**
 * <b>BezierException indique à une CourbeBezierAWT qu'elle possède un nombre irregulier de points de contrôle.</b>
 * <p>
 * Ce nombre étant minoré par 5, toutes les Courbes de Bézier possédant plus de 4 points de contrôle ne peuvent être dessinées en AWT
 * </p>
 * @see CourbeBezier
 * @see CourbeBezierAWT
 * @author Aurore Claude/Quentin Gayout
 *
 */
public class BezierException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
