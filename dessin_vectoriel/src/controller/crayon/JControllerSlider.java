package controller.crayon;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.MainView;

public class JControllerSlider implements ChangeListener {
	private MainView fenetre;
	
	public JControllerSlider (MainView fenetre) {
		this.fenetre = fenetre;
	}
	@Override
	public void stateChanged(ChangeEvent arg0) {
		JSlider source = (JSlider)arg0.getSource();
		int epaisseur = (int)source.getValue();
		if ((epaisseur<=10) && (epaisseur>0)) {
			this.fenetre.getCrayon().setEpaisseur(epaisseur);
		}
	}
}
