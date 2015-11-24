package controller.sauvegarde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import abstraction.Application;
import controller.listes.JControllerListEllipse;
import implementation.Crayon;
import implementation.Ellipse;
import implementation.Position;
import view.figures.EllipseView;

public class JControllerSaveEllipse  implements ActionListener {
	private Application application;
	private EllipseView parent;
	private boolean rempli;
	private boolean edition;

	public JControllerSaveEllipse (Application application, EllipseView parent, boolean rempli, boolean edition) {
		this.application = application;
		this.parent = parent;
		this.rempli = rempli;
		this.edition = edition;
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
								if ((xC>0) && (xC<this.application.largeur)
										&& (yC>0) && (yC<this.application.hauteur)) {
									if (angle>0) {
										Position centre = new Position(xC,yC);
										Ellipse ep = new Ellipse(centre, gdAxe, ptiAxe, angle, this.rempli);
										Crayon crayon = new Crayon(this.application.getCrayon().getEpaisseur(), this.application.getCrayon().getCouleur());
										ep.setCrayon(crayon);
										if (!edition) {
											this.application.addEllipse(ep);
											this.application.addDessin(ep);
										}
										else {
											int i = JControllerListEllipse.branchToIndice(this.application.getEllipses(), this.application.getEllipseSelected());
											this.application.replaceEllipse(i-1, ep);
										}
										this.application.setEllipseSelected(ep);
										this.parent.setVisible(false);
									}
									else {
										JOptionPane.showMessageDialog(parent, "La valeur choisie pour l'angle doit être positive.", "Erreur!", 0);
									}
								}
								else {
									JOptionPane.showMessageDialog(parent, "Vérifiez que les coordonnées du centre sont comprises entre 0 et "+this.application.largeur+" pour l'abscisse , entre 0 et "+this.application.hauteur+" pour l'ordonnée.", "Erreur!", 0);
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