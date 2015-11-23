package controller.sauvegarde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import implementation.Ellipse;
import implementation.Position;
import view.MainView;
import view.figures.EllipseView;

public class JControllerSaveEllipse  implements ActionListener {
	private MainView fenetre;
	private EllipseView parent;
	private boolean rempli;

	public JControllerSaveEllipse (MainView fenetre, EllipseView parent, boolean rempli) {
		this.fenetre = fenetre;
		this.parent = parent;
		this.rempli = rempli;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int xC, yC, gdAxe, ptiAxe, angle;
		try {
			xC = Integer.parseInt(parent.getxC().getText());
			try {
				yC = Integer.parseInt(parent.getyC().getText());
				try {
					gdAxe = Integer.parseInt(parent.getGdAxe().getText());
					try {
						ptiAxe = Integer.parseInt(parent.getPtiAxe().getText());
						try {
							angle = Integer.parseInt(parent.getAngle().getText());
							if ((gdAxe>0) && (ptiAxe>0)) {	
								if ((xC>0) && (xC<this.fenetre.largeur)
										&& (yC>0) && (yC<this.fenetre.hauteur)) {
									if (angle>0) {
										Position centre = new Position(xC,yC);
										Ellipse ep = new Ellipse(centre, gdAxe, ptiAxe, angle, this.rempli);
										this.fenetre.getEllipses().add(ep);
										this.fenetre.setEllipseSelected(ep);
									}
									else {
										JOptionPane.showMessageDialog(parent, "La valeur choisie pour l'angle doit être positive.", "Erreur!", 0);
									}
								}
								else {
									JOptionPane.showMessageDialog(parent, "Vérifiez que les coordonnées du centre sont comprises entre 0 et "+this.fenetre.largeur+" pour l'abscisse , entre 0 et "+this.fenetre.hauteur+" pour l'ordonnée.", "Erreur!", 0);
								}
							}
							else {
								JOptionPane.showMessageDialog(parent, "La valeur pour le grand et/ou petit axe n'est pas positive.", "Erreur!", 0);
							} 
						}
						catch (NumberFormatException error) {
							JOptionPane.showMessageDialog(parent, "La valeur "+parent.getAngle().getText()+" n'est pas entière.", "Erreur!", 0);
						}
					}
					catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(parent, "La valeur "+parent.getPtiAxe().getText()+" n'est pas entière.", "Erreur!", 0);
					}
				}
				catch (NumberFormatException error) {
					JOptionPane.showMessageDialog(parent, "La valeur "+parent.getGdAxe().getText()+" n'est pas entière.", "Erreur!", 0);
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