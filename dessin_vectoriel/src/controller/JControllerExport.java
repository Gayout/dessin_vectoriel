package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import abstraction.Application;
import abstraction.DessinComposite;
import visitor.VisiteurSVGDessiner;

public class JControllerExport implements ActionListener {
	private Application application;
	private JMenuItem item;
	
	public JControllerExport(Application application, JMenuItem item) {
		this.application = application;
		this.item = item;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String chemin;
		JFileChooser name = new JFileChooser();
		int value = name.showDialog(this.item,"Save");
		if (value == JFileChooser.APPROVE_OPTION) {
			chemin = ""+name.getSelectedFile();
			VisiteurSVGDessiner visiteur = new VisiteurSVGDessiner(this.application.largeur, this.application.hauteur);
			
			DessinComposite dessin = new DessinComposite();
			for(int i=0; i<this.application.getDessins().size(); i++) {
				dessin.addDessin(this.application.getDessins().get(i));
			}
			dessin.accept(visiteur);

			try {

				File file = new File(chemin+".svg");
				JOptionPane.showMessageDialog(name,"Le fichier a bien été sauvegardé (chemin : "+chemin+".svg).");
				if (!file.createNewFile()){
					file.delete();
					file = new File(chemin+".svg");
				}
				FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(visiteur.getCode());
				bw.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}