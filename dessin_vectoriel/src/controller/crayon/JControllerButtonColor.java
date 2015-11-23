package controller.crayon;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import view.MainView;

public class JControllerButtonColor implements ActionListener {
	private MainView fenetre;
	private JButton bouton;
	
	public JControllerButtonColor (MainView fenetre, JButton bouton) {
		this.fenetre = fenetre;
		this.bouton = bouton;
		bouton.setEnabled(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JColorChooser choixCouleur = new JColorChooser();
		@SuppressWarnings("static-access")
		Color couleur = choixCouleur.showDialog(this.bouton, "Choix de la couleur du crayon", this.fenetre.getCrayon().getCouleur());
		if (couleur != null) {
			this.fenetre.getCrayon().setCouleur(couleur);
			this.bouton.setBackground(couleur);
		}
	}

}