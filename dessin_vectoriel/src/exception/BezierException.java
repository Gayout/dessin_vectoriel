package exception;

import implementation.CourbeBezier;
import interpreteur.awt.CourbeBezierAWT;

/**
 * <b>BezierException indique � une CourbeBezierAWT qu'elle poss�de un nombre irregulier de points de contr�le.</b>
 * <p>
 * Ce nombre �tant minor� par 5, toutes les Courbes de B�zier poss�dant plus de 4 points de contr�le ne peuvent �tre dessin�es en AWT
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
