package controller.sauvegarde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import abstraction.Application;
import implementation.Cercle;
import implementation.Position;
import view.figures.CercleView;

public class JControllerSaveCercle implements ActionListener {
	CercleView parent;
	private boolean rempli;
	private Application application;

	public JControllerSaveCercle (Application application, CercleView parent, boolean rempli) {
		this.parent = parent;
		this.rempli = rempli;
		this.application = application;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int xC, yC, rayon;
		try {
			xC = Integer.parseInt(parent.getxC().getText());
			try {
				yC = Integer.parseInt(parent.getyC().getText());
				try {
					rayon = Integer.parseInt(parent.getR().getText());
					if (rayon > 0) {	
						if ((xC>0) && (xC<this.application.largeur)
								&& (yC>0) && (yC<this.application.hauteur)) {
							Position centre = new Position(xC,yC);
							Cercle c = new Cercle(centre, rayon, rempli);
							c.setCrayon(this.application.getCrayon());
							this.application.addCercle(c);
							this.application.setCercleSelected(c);
							this.parent.setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(parent, "Vérifiez que les coordonnées du sommet sont compris entre 0 et "+this.application.largeur+" pour l'abscisse , entre 0 et "+this.application.hauteur+" pour l'ordonnée.", "Erreur!", 0);
						}
					}
					else {
						JOptionPane.showMessageDialog(parent, "La valeur du coté n'est pas positive.", "Erreur!", 0);
					} 
				}
				catch (NumberFormatException error) {
					JOptionPane.showMessageDialog(parent, "La valeur "+parent.getR().getText()+" n'est pas entière.", "Erreur!", 0);
				}
			} 
			catch (NumberFormatException error) {
				JOptionPane.showMessageDialog(parent, "La valeur "+parent.getyC().getText()+" n'est pas entière.", "Erreur!", 0);
			}
		} 
		catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(parent, "La valeur "+parent.getxC().getText()+" n'est pas entière.", "Erreur!", 0);
		}
	} 
}