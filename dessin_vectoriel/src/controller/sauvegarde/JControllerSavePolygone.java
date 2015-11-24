package controller.sauvegarde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import abstraction.Application;
import implementation.Polygone;
import implementation.Position;
import view.figures.PolygoneView;
import view.figures.PolygoneView2;

public class JControllerSavePolygone implements ActionListener {
	private Application application;
	private PolygoneView fenetre;
	private PolygoneView2 parent;
	private boolean rempli;

	public JControllerSavePolygone (Application application, PolygoneView fenetre, PolygoneView2 parent, boolean rempli) {
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
				Polygone p = new Polygone(points, !fenetre.getFerme().isSelected(), this.rempli);
				p.setCrayon(this.application.getCrayon());
				this.application.addPolygone(p);
				this.application.setPolygoneSelected(p);
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