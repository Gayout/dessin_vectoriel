package controller.menuFigures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import abstraction.Application;
import view.figures.PolygoneView;
import view.figures.PolygoneView2;

public class JControllerButtonContinuePolygone implements ActionListener {
	private Application application;
	private PolygoneView fenetre;
	private boolean edition;
	private boolean rempli;

	public JControllerButtonContinuePolygone (Application application, PolygoneView fenetre, boolean edition, boolean rempli) {
		this.application = application;
		this.fenetre = fenetre;
		this.edition = edition;
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
				PolygoneView2 pv = new PolygoneView2(this.application, this.fenetre, this.edition, nb, this.rempli);
				pv.setVisible(true);
				fenetre.setVisible(false);
			}
		}
		catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(this.fenetre, "La valeur "+this.fenetre.getNombrePoints().getText()+" n'est pas entière.", "Erreur!", 0);
		}
	}
}