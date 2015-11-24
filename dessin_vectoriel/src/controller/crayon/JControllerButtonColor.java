package controller.crayon;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import abstraction.Application;

public class JControllerButtonColor implements ActionListener {
	private JButton bouton;
	private Application application;
	
	public JControllerButtonColor (JButton bouton, Application application) {
		this.bouton = bouton;
		this.application = application;
		bouton.setEnabled(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JColorChooser choixCouleur = new JColorChooser();
		@SuppressWarnings("static-access")
		Color couleur = choixCouleur.showDialog(this.bouton, "Choix de la couleur du crayon", this.application.getCrayon().getCouleur());
		if (couleur != null) {
			this.application.getCrayon().setCouleur(couleur);
			this.bouton.setBackground(couleur);
		}
	}
}