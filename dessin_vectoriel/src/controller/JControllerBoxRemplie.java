package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

public class JControllerBoxRemplie implements ActionListener {
	private JCheckBox rempli;
	private JCheckBox ferme;

	public JControllerBoxRemplie (JCheckBox rempli, JCheckBox ferme) {
		this.rempli = rempli;
		this.ferme = ferme;
		if (!ferme.isSelected()) {
			this.rempli.setEnabled(false);
		}
		else {
			this.rempli.setEnabled(true);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!ferme.isSelected()) {
			this.rempli.setEnabled(false);
		}
		else {
			this.rempli.setEnabled(true);
		}
	}
}
