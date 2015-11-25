package controller;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import abstraction.Application;
import abstraction.Chemin;
import abstraction.DessinComposite;
import visitor.VisiteurAWTDessiner;

public class JControllerDessins implements Observer{
	private Application application;
	private VisiteurAWTDessiner fenetre;
	
	public JControllerDessins (VisiteurAWTDessiner fenetre, Application application) {
		this.fenetre = fenetre;
		this.application = application;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		Integer iMessage = (Integer)arg1;
		if(iMessage == Application.MODIFY_DESSINS) {
			this.fenetre.getG().clearRect(0, 0, this.application.largeur, this.application.hauteur);
			DessinComposite dessin = new DessinComposite();
			Vector<Chemin> dessins = this.application.getDessins();
			for(int i=0; i<dessins.size(); i++) {
				dessin.addDessin(dessins.get(i));
			}
			dessin.accept(this.fenetre);
			this.fenetre.setVisible(true);
		}
	}
}
