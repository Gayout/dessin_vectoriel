package controller;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import abstraction.Application;
import abstraction.Chemin;
import abstraction.DessinComposite;
import implementation.Cercle;
import implementation.CourbeBezier;
import implementation.Ellipse;
import implementation.Polygone;
import implementation.Rectangle;
import implementation.Segment;
import interpreteur.awt.CercleAWT;
import visitor.VisiteurAWTDessiner2;

public class JControllerDessins implements Observer{
	private Application application;
	private VisiteurAWTDessiner2 panel;
	
	public JControllerDessins (VisiteurAWTDessiner2 panel, Application application) {
		this.panel = panel;
		this.application = application;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		Integer iMessage = (Integer)arg1;
		System.out.println(iMessage);
		if(iMessage == Application.MODIFY_DESSINS) {
			DessinComposite dessin = new DessinComposite();
			Vector<Chemin> dessins = this.application.getDessins();
			for(int i=0; i<dessins.size(); i++) {
				dessin.addDessin(dessins.get(i));
			}
			dessin.accept(this.panel);
			this.panel.setVisible(true);
		}
	}
}
