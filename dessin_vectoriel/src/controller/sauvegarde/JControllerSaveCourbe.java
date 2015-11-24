package controller.sauvegarde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import abstraction.Application;
import implementation.CourbeBezier;
import implementation.Position;
import view.figures.CourbeView;
import view.figures.CourbeView2;

public class JControllerSaveCourbe implements ActionListener {
	private Application application;
	private CourbeView fenetre;
	private CourbeView2 parent;
	private boolean rempli;

	public JControllerSaveCourbe (Application application, CourbeView fenetre, CourbeView2 parent, boolean rempli) {
		this.application = application;
		this.fenetre = fenetre;
		this.parent = parent;
		this.rempli = rempli;
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
				c.setCrayon(this.application.getCrayon());
				this.application.addCourbe(c);
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