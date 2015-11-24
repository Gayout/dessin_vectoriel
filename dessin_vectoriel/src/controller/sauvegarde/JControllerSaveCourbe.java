package controller.sauvegarde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import abstraction.Application;
import controller.listes.JControllerListCercle;
import implementation.CourbeBezier;
import implementation.Crayon;
import implementation.Position;
import view.figures.CourbeView;
import view.figures.CourbeView2;

public class JControllerSaveCourbe implements ActionListener {
	private Application application;
	private CourbeView fenetre;
	private CourbeView2 parent;
	private boolean rempli;
	private boolean edition;

	public JControllerSaveCourbe (Application application, CourbeView fenetre, CourbeView2 parent, boolean rempli, boolean edition) {
		this.application = application;
		this.fenetre = fenetre;
		this.parent = parent;
		this.rempli = rempli;
		this.edition = edition;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Integer x, y;
		ArrayList<Position> points = new ArrayList<Position>();
		int taille = parent.getListX().size();
		for(int i=0; i<taille-1; i++) {
			try {
				x = Integer.parseInt(parent.getListX().get(i).getText());
				try {
					y = Integer.parseInt(parent.getListY().get(i).getText());
					points.add(new Position(x, y));
				}
				catch (NumberFormatException error) {
					JOptionPane.showMessageDialog(parent, i+" : La valeur "+parent.getListY().get(i).getText()+" n'est pas entière.", "Erreur!", 0);
				}
			}
			catch (NumberFormatException error) {
				JOptionPane.showMessageDialog(parent, i+" : La valeur "+parent.getListX().get(i).getText()+" n'est pas entière.", "Erreur!", 0);
			}
		}
		try {
			x = Integer.parseInt(parent.getListX().get(taille-1).getText());
			try {
				y = Integer.parseInt(parent.getListY().get(taille-1).getText());
				points.add(new Position(x, y));
				CourbeBezier c = new CourbeBezier(points, !fenetre.getFerme().isSelected(), this.rempli);
				Crayon crayon = new Crayon(this.application.getCrayon().getEpaisseur(), this.application.getCrayon().getCouleur());
				c.setCrayon(crayon);
				if (!edition) {
					this.application.addCourbe(c);
					this.application.addDessin(c);
				}
				else {
					int i = JControllerListCercle.branchToIndice(this.application.getCercles(), this.application.getCercleSelected());
					this.application.replaceCourbe(i-1, c);
				}
				this.application.setCourbeSelected(c);
				this.parent.setVisible(false);
			}
			catch (NumberFormatException error) {
				JOptionPane.showMessageDialog(parent, (taille-1)+" : La valeur "+parent.getListY().get(taille-1).getText()+" n'est pas entière.", "Erreur!", 0);
			}
		}
		catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(parent, (taille-1)+" : La valeur "+parent.getListX().get(taille-1).getText()+" n'est pas entière.", "Erreur!", 0);
		}
	} 
}