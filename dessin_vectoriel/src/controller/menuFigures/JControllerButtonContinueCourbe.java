package controller.menuFigures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.MainView;
import view.figures.CourbeView;
import view.figures.CourbeView2;

public class JControllerButtonContinueCourbe implements ActionListener {
	private MainView main;
	private CourbeView fenetre;
	private boolean edition;
	private boolean rempli;

	public JControllerButtonContinueCourbe (MainView main, CourbeView fenetre, boolean edition, boolean rempli) {
		this.main = main;
		this.fenetre = fenetre;
		this.rempli = rempli;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int nb;
		try {
			nb = Integer.parseInt(this.fenetre.getNombrePoints().getText());
			if ((nb > 4) || (nb <= 0)) {
				JOptionPane.showMessageDialog(this.fenetre, "Entrez un nombre de points compris entre 0 et 4 inclus svp.", "Erreur!", 0);
			}
			else {
				CourbeView2 cv = new CourbeView2(this.main, this.fenetre, this.edition, nb, rempli);
				cv.setVisible(true);
				fenetre.setVisible(false);
			}
		}
		catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(this.fenetre, "La valeur "+this.fenetre.getNombrePoints().getText()+" n'est pas entière.", "Erreur!", 0);
		}
	}
}