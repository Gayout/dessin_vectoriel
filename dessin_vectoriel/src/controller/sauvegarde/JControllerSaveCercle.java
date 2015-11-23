package controller.sauvegarde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import implementation.Cercle;
import implementation.Position;
import view.MainView;
import view.figures.CercleView;

public class JControllerSaveCercle implements ActionListener {
	private MainView fenetre;
	private CercleView parent;
	private boolean rempli;

	public JControllerSaveCercle (MainView fenetre, CercleView parent, boolean rempli) {
		this.fenetre = fenetre;
		this.parent = parent;
		this.rempli = rempli;
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
						if ((xC>0) && (xC<this.fenetre.largeur)
								&& (yC>0) && (yC<this.fenetre.hauteur)) {
							Position centre = new Position(xC,yC);
							Cercle c = new Cercle(centre, rayon, rempli);
							this.fenetre.getCercles().add(c);
							this.fenetre.setCercleSelected(c);
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