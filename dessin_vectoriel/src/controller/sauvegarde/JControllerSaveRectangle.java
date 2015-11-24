package controller.sauvegarde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import abstraction.Application;
import implementation.Position;
import implementation.Rectangle;
import view.figures.RectangleView;

public class JControllerSaveRectangle implements ActionListener {
	private Application application;
	private RectangleView parent;
	private boolean rempli;

	public JControllerSaveRectangle (Application application, RectangleView parent, boolean rempli) {
		this.application = application;
		this.parent = parent;
		this.rempli = rempli;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int xG, yG, largeur, hauteur;
		try {
			xG = Integer.parseInt(parent.getxG().getText());
			try {
				yG = Integer.parseInt(parent.getyG().getText());
				try {
					largeur = Integer.parseInt(parent.getLargeur().getText());
					try {
						hauteur = Integer.parseInt(parent.getHauteur().getText());
						if ((largeur>0) && (hauteur>0)) {	
							if ((xG>0) && (xG<this.application.largeur)
									&& (yG>0) && (yG<this.application.hauteur)) {
								Position gauche = new Position(xG,yG);
								Rectangle r = new Rectangle(gauche, largeur, hauteur, this.rempli);
								r.setCrayon(this.application.getCrayon());
								this.application.addRectangle(r);
								this.application.setRectangleSelected(r);
								this.parent.setVisible(false);
							}
							else {
								JOptionPane.showMessageDialog(parent, "Vérifiez que les coordonnées du sommet sont comprises entre 0 et "+this.application.largeur+" pour l'abscisse , entre 0 et "+this.application.hauteur+" pour l'ordonnée.", "Erreur!", 0);
							}
						}
						else {
							JOptionPane.showMessageDialog(parent, "La valeur du coté n'est pas positive.", "Erreur!", 0);
						} 
					}
					catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(parent, "La valeur "+parent.getHauteur().getText()+" n'est pas entière.", "Erreur!", 0);
					}
				}
				catch (NumberFormatException error) {
					JOptionPane.showMessageDialog(parent, "La valeur "+parent.getLargeur().getText()+" n'est pas entière.", "Erreur!", 0);
				}
			} 
			catch (NumberFormatException error) {
				JOptionPane.showMessageDialog(parent, "La valeur "+parent.getyG().getText()+" n'est pas entière.", "Erreur!", 0);
			}
		} 
		catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(parent, "La valeur "+parent.getxG().getText()+" n'est pas entière.", "Erreur!", 0);
		}
	} 
}