package controller.sauvegarde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import implementation.Position;
import implementation.Segment;
import view.MainView;
import view.figures.SegmentView;

public class JControllerSaveSegment implements ActionListener {
	private MainView fenetre;
	private SegmentView parent;

	public JControllerSaveSegment (MainView fenetre, SegmentView parent) {
		this.fenetre = fenetre;
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int xA, xD, yA, yD;
		try {
			xD = Integer.parseInt(parent.getxD().getText());
			try {
				yD = Integer.parseInt(parent.getyD().getText());
				try {
					xA = Integer.parseInt(parent.getxA().getText());
					try {
						yA = Integer.parseInt(parent.getyA().getText());
						if ((xA>0) && (xA<this.fenetre.largeur)
								&& (yA>0) && (yA<this.fenetre.hauteur)
								&& (xD>0) && (xD<this.fenetre.largeur)
								&& (yD>0) && (yD<this.fenetre.hauteur)) {
							Position depart = new Position(xD, yD);
							Position arrivee = new Position(xA, yA);
							Segment s = new Segment(depart, arrivee);
							this.fenetre.getSegments().add(s);
							this.fenetre.setSegmentSelected(s);
						}
						else {
							JOptionPane.showMessageDialog(parent, "Vérifiez que les coordonnées des sommets sont comprises entre 0 et "+this.fenetre.largeur+" pour les abscisses , entre 0 et "+this.fenetre.hauteur+" pour les ordonnées.", "Erreur!", 0);
						}
					} 
					catch (NumberFormatException error) {
						JOptionPane.showMessageDialog(parent, "La valeur "+parent.getyA().getText()+" n'est pas entière.", "Erreur!", 0);
					}
				} 
				catch (NumberFormatException error) {
					JOptionPane.showMessageDialog(parent, "La valeur "+parent.getxA().getText()+" n'est pas entière.", "Erreur!", 0);
				}
			} 
			catch (NumberFormatException error) {
				JOptionPane.showMessageDialog(parent, "La valeur "+parent.getyD().getText()+" n'est pas entière.", "Erreur!", 0);
			}
		} 
		catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(parent, "La valeur "+parent.getxD().getText()+" n'est pas entière.", "Erreur!", 0);
		}
	}
}