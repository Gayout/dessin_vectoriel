package controller.sauvegarde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import abstraction.Application;
import controller.listes.JControllerListCarre;
import implementation.Crayon;
import implementation.Position;
import implementation.Rectangle;
import view.figures.CarreView;

public class JControllerSaveCarre implements ActionListener {
	private CarreView parent;
	private boolean edition;
	private Application application;

	public JControllerSaveCarre (Application application, CarreView parent,  boolean edition) {
		this.application = application;
		this.parent = parent;
		this.edition = edition;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int xG, yG, cote;
		try {
			xG = Integer.parseInt(parent.getxG().getText());
			try {
				yG = Integer.parseInt(parent.getyG().getText());
				try {
					cote = Integer.parseInt(parent.getCote().getText());
					if (cote > 0) {	
						if ((xG>=0) && (xG<=this.application.largeur)
								&& (yG>=0) && (yG<=this.application.hauteur)) {
							Position gauche = new Position(xG,yG);
							Rectangle c = new Rectangle(gauche, cote, cote, this.parent.getRempli().isSelected());
							Crayon crayon = new Crayon(this.application.getCrayon().getEpaisseur(), this.application.getCrayon().getCouleur());
							c.setCrayon(crayon);
							if (!edition) {
								this.application.addCarre(c);
								this.application.addDessin(c);
							}
							else {
								int i = JControllerListCarre.branchToIndice(this.application.getCarres(), this.application.getCarreSelected());
								this.application.replaceDessin(this.application.getCarres().get(i-1), c);
								this.application.replaceCarre(i-1, c);
							}
							this.application.setCarreSelected(c);
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
					JOptionPane.showMessageDialog(parent, "La valeur "+parent.getCote().getText()+" n'est pas entière.", "Erreur!", 0);
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