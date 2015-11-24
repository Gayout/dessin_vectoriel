package controller.sauvegarde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import abstraction.Application;
import controller.listes.JControllerListSegment;
import implementation.Crayon;
import implementation.Position;
import implementation.Segment;
import view.figures.SegmentView;

public class JControllerSaveSegment implements ActionListener  {
	private SegmentView parent;
	private Application application;
	private boolean edition;

	public JControllerSaveSegment (SegmentView parent, Application application, boolean edition) {
		this.parent = parent;
		this.application = application;
		this.edition = edition;
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
						if ((xA>=0) && (xA<=this.application.largeur)
								&& (yA>=0) && (yA<=this.application.hauteur)
								&& (xD>=0) && (xD<=this.application.largeur)
								&& (yD>=0) && (yD<=this.application.hauteur)) {
							Position depart = new Position(xD, yD);
							Position arrivee = new Position(xA, yA);
							Segment s = new Segment(depart, arrivee);
							Crayon crayon = new Crayon(this.application.getCrayon().getEpaisseur(), this.application.getCrayon().getCouleur());
							s.setCrayon(crayon);
							if (!edition) {
								this.application.addSegment(s);
								this.application.addDessin(s);
							}
							else {
								int i = JControllerListSegment.branchToIndice(this.application.getSegments(), this.application.getSegmentSelected());
								this.application.replaceSegment(i-1, s);
							}
							this.application.setSegmentSelected(s);
							
							this.parent.setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(parent, "Vérifiez que les coordonnées des sommets sont comprises entre 0 et "+this.application.largeur+" pour les abscisses , entre 0 et "+this.application.hauteur+" pour les ordonnées.", "Erreur!", 0);
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