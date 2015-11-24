package controller.crayon;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import abstraction.Application;

public class JControllerSlider implements ChangeListener {
	private Application application;
	
	public JControllerSlider (Application application) {
		this.application = application;
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0) {
		JSlider source = (JSlider)arg0.getSource();
		int epaisseur = (int)source.getValue();
		if ((epaisseur<=10) && (epaisseur>0)) {
			this.application.getCrayon().setEpaisseur(epaisseur);
		}
	}
}
