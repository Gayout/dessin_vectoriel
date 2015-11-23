package controller.sauvegarde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import implementation.Position;
import implementation.Rectangle;
import view.MainView;
import view.figures.CarreView;

public class JControllerSaveCarre implements ActionListener {
	private MainView fenetre;
	private CarreView parent;
	private boolean rempli;

	public JControllerSaveCarre (MainView fenetre, CarreView parent, boolean rempli) {
		this.fenetre = fenetre;
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
						if ((xG>0) && (xG<this.fenetre.largeur)
								&& (yG>0) && (yG<this.fenetre.hauteur)) {
							Position gauche = new Position(xG,yG);
							Rectangle c = new Rectangle(gauche, cote, cote, this.rempli);
							this.fenetre.getCarres().add(c);
							this.fenetre.setCarreSelected(c);
						}
						else {
							JOptionPane.showMessageDialog(parent, "Vérifiez que les coordonnées du sommet sont compris entre 0 et "+this.fenetre.largeur+" pour l'abscisse , entre 0 et "+this.fenetre.hauteur+" pour l'ordonnée.", "Erreur!", 0);
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