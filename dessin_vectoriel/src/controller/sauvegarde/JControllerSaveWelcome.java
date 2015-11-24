package controller.sauvegarde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import abstraction.Application;
import view.MainView;
import view.WelcomeView;

public class JControllerSaveWelcome implements ActionListener {
	private WelcomeView parent;

	public JControllerSaveWelcome (WelcomeView parent) {
		this.parent = parent;
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		int largeur, hauteur;
		try {
			hauteur = Integer.parseInt(parent.getHauteur().getText());
			try {
				largeur = Integer.parseInt(parent.getLargeur().getText());
				if (hauteur > 0) {
					if (largeur > 0) {
						Application application = new Application(largeur, hauteur);
						MainView mv = new MainView(application);
						parent.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(parent, "La valeur "+parent.getLargeur().getText()+" n'est pas supérieure à 0.", "Erreur!", 0);
					}
				}
				else {
					JOptionPane.showMessageDialog(parent, "La valeur "+parent.getHauteur().getText()+" n'est pas supérieure à 0.", "Erreur!", 0);
				}
			} 
			catch (NumberFormatException error) {
				JOptionPane.showMessageDialog(parent, "La valeur "+parent.getLargeur().getText()+" n'est pas entière.", "Erreur!", 0);
			}
		} 
		catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(parent, "La valeur "+parent.getHauteur().getText()+" n'est pas entière.", "Erreur!", 0);
		}
	}
}