package controller.sauvegarde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import abstraction.Application;
import implementation.Position;
import implementation.Rectangle;
import view.figures.CarreView;

public class JControllerSaveCarre implements ActionListener {
	private CarreView parent;
	private boolean rempli;
	private Application application;

	public JControllerSaveCarre (Application application, CarreView parent, boolean rempli) {
		this.application = application;
		this.parent = parent;
		this.rempli = rempli;
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
						if ((xG>0) && (xG<this.application.largeur)
								&& (yG>0) && (yG<this.application.hauteur)) {
							Position gauche = new Position(xG,yG);
							Rectangle c = new Rectangle(gauche, cote, cote, this.rempli);
							c.setCrayon(this.application.getCrayon());
							this.application.addCarre(c);
							this.application.setCarreSelected(c);
							this.parent.setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(parent, "V�rifiez que les coordonn�es du sommet sont compris entre 0 et "+this.application.largeur+" pour l'abscisse , entre 0 et "+this.application.hauteur+" pour l'ordonn�e.", "Erreur!", 0);
						}
					}
					else {
						JOptionPane.showMessageDialog(parent, "La valeur du cot� n'est pas positive.", "Erreur!", 0);
					} 
				}
				catch (NumberFormatException error) {
					JOptionPane.showMessageDialog(parent, "La valeur "+parent.getCote().getText()+" n'est pas enti�re.", "Erreur!", 0);
				}
			} 
			catch (NumberFormatException error) {
				JOptionPane.showMessageDialog(parent, "La valeur "+parent.getyG().getText()+" n'est pas enti�re.", "Erreur!", 0);
			}
		} 
		catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(parent, "La valeur "+parent.getxG().getText()+" n'est pas enti�re.", "Erreur!", 0);
		}
	} 
}