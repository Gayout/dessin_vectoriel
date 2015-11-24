package visitor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.JPanel;

import abstraction.Dessin;
import abstraction.Visiteur;
import implementation.*;
import interpreteur.awt.*;
import view.MainView;

/**
 * <b>VisiteurAWTDessiner visite les dessins, les interpréte en AWT et les dessine dans une Frame</b>
 * Cette classe est quasiment identique à VisiteurAWTDessiner, elle est utilisée par notre IHM.
 * @author Aurore Claude/Quentin Gayout
 * @see Frame
 * @see Visiteur
 */
public class VisiteurAWTDessiner2 extends JPanel implements Visiteur{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * VisiteurAWT possède un Graphics initialisé à la création dans lequel seront dessinés les Shape interprétés par l'interpreteur AWT lors des visites
	 */
	MainView container;
	Graphics g;

	/**
	 * Constructeur
	 * @see Visiteur#VisiteurAWTDessiner2(int, int)
	 */
	public VisiteurAWTDessiner2(int largeur, int hauteur, MainView container) {
		super();
		this.setVisible(true);
		this.setSize(largeur,hauteur);
		g = container.getGraphics();
		System.out.println(g);
	}

	/**
	 * Pour la visite d'un DessinVide, il ne se passe rien
	 * @see Visiteur#visit(Dessin)
	 */
	@Override
	public void visit(Dessin dessin) {
	}

	/**
	 * Pour la visite d'un cercle
	 * @see Visiteur#visit(Cercle)
	 */
	@Override
	public void visit(Cercle cercle) {
		if(cercle!=null){
			CercleAWT cercleAWT = cercle.creerCercleAWT();


			Color color = cercle.getCrayon().getCouleur();
			int epaisseur = cercle.getCrayon().getEpaisseur();

			Shape r1 = cercleAWT.shape();

			Graphics2D ga = (Graphics2D)g;
			ga.setPaint(color);
			ga.setStroke(new BasicStroke((epaisseur)));

			//si on ne dessine pas 3 fois la figure, elle n'apparait pas en entier
			ga.draw(r1);
			ga.draw(r1);
			ga.draw(r1);

			if(cercle.isRempli()){
				//si on ne dessine pas 3 fois la figure, elle n'apparait pas en entier
				ga.fill(r1);
				ga.fill(r1);
				ga.fill(r1);		
			}
		}

	}

	/**
	 * Pour la visite d'une courbeBezier
	 * @see Visiteur#visit(CourbeBezier)
	 */
	@Override
	public void visit(CourbeBezier courbeBezier) {
		if(courbeBezier!=null){
			CourbeBezierAWT courbeBezierAWT = courbeBezier.creerCourbeBezierAWT();

			Color color = courbeBezier.getCrayon().getCouleur();
			int epaisseur = courbeBezier.getCrayon().getEpaisseur();

			Shape r1 = courbeBezierAWT.shape().get(0);

			Graphics2D ga = (Graphics2D)g;

			ga.setPaint(color);
			ga.setStroke(new BasicStroke((epaisseur)));

			//si on ne dessine pas 3 fois la figure, elle n'apparait pas en entier
			ga.draw(r1);
			ga.draw(r1);
			ga.draw(r1);
			if(courbeBezier.isRempli()){

				//si on ne dessine pas 3 fois la figure, elle n'apparait pas en entier
				ga.fill(r1);
				ga.fill(r1);
				ga.fill(r1);
			}
			if(!courbeBezier.isOuvert()){
				Shape r2= courbeBezierAWT.shape().get(1);

				//si on ne dessine pas 3 fois la figure, elle n'apparait pas en entier
				ga.draw(r2);
				ga.draw(r2);
				ga.draw(r2);
			}
		}
	}

	/**
	 * Pour la visite d'une Ellipse
	 * @see Visiteur#visit(Ellipse)
	 */
	@Override
	public void visit(Ellipse ellipse) {
		if(ellipse!=null){
			EllipseAWT ellipseAWT = ellipse.creerEllipseAWT();
			Position c = ellipse.getCentre();
			int x = c.getX();
			int y = c.getY();
			int width = ellipse.getGdAxe();
			int height = ellipse.getPetitAxe();
			long angle =ellipse.getAngleAbsGdAxe();
			Color color = ellipse.getCrayon().getCouleur();
			int epaisseur = ellipse.getCrayon().getEpaisseur();

			Shape r1 = ellipseAWT.shape();

			Graphics2D ga = (Graphics2D)g;
			ga.rotate(Math.toRadians(angle),x+ width / 2, y+ height / 2);
			ga.setPaint(color);
			ga.setStroke(new BasicStroke((epaisseur)));

			//si on ne dessine pas 3 fois la figure, elle n'apparait pas en entier
			ga.draw(r1);
			ga.draw(r1);
			ga.draw(r1);

			if(ellipse.isRempli()){
				//si on ne dessine pas 3 fois la figure, elle n'apparait pas en entier
				ga.fill(r1);
				ga.fill(r1);
				ga.fill(r1);
			}

			ga.rotate(-Math.toRadians(angle),x,y);
		}
	}

	/**
	 * Pour la visite d'un Polygone
	 * @see Visiteur#visit(Polygone)
	 */
	@Override
	public void visit(Polygone polygone) {
		if(polygone!=null){
			PolygoneAWT polygoneAWT = polygone.creerPolygoneAWT();

			Color color = polygone.getCrayon().getCouleur();
			int epaisseur = polygone.getCrayon().getEpaisseur();
			Shape r1 = polygoneAWT.shape();

			Graphics2D ga = (Graphics2D)g;
			ga.setPaint(color);
			ga.setStroke(new BasicStroke((epaisseur)));

			//si on ne dessine pas 3 fois la figure, elle n'apparait pas en entier
			ga.draw(r1);
			ga.draw(r1);
			ga.draw(r1);

			if(polygone.isRempli()){

				//si on ne dessine pas 3 fois la figure, elle n'apparait pas en entier
				ga.fill(r1);
				ga.fill(r1);
				ga.fill(r1);
			}
		}
	}

	/**
	 * Pour la visite d'un rectangle
	 * @see Visiteur#visit(Rectangle)
	 */
	@Override
	public void visit(Rectangle rectangle) {
		if(rectangle != null){
			RectangleAWT rectangleAWT = rectangle.creerRectangleAWT();

			Color color = rectangle.getCrayon().getCouleur();
			int epaisseur = rectangle.getCrayon().getEpaisseur();

			Shape r1 = rectangleAWT.shape();

			Graphics2D ga = (Graphics2D)g;
			ga.setPaint(color);
			ga.setStroke(new BasicStroke((epaisseur)));

			//si on ne dessine pas 3 fois la figure, elle n'apparait pas en entier
			ga.draw(r1);
			ga.draw(r1);
			ga.draw(r1);

			if(rectangle.isRempli()){

				//si on ne dessine pas 3 fois la figure, elle n'apparait pas en entier
				ga.fill(r1);
				ga.fill(r1);
				ga.fill(r1);
			}
		}
	}

	/**
	 * Pour la visite d'un segment
	 * @see Visiteur#visit(Segment)
	 */
	@Override
	public void visit(Segment segment) {
		if(segment != null){
			SegmentAWT segmentAWT = segment.creerSegmentAWT();

			Color color = segment.getCrayon().getCouleur();
			System.out.println("Couleur "+color);
			int epaisseur = segment.getCrayon().getEpaisseur();

			Shape r1 = segmentAWT.shape();

			Graphics2D ga = (Graphics2D)g;
			ga.setPaint(color);
			ga.setStroke(new BasicStroke((epaisseur)));

			//si on ne dessine pas 3 fois la figure, elle n'apparait pas en entier
			ga.draw(r1);
			ga.draw(r1);
			ga.draw(r1);
		}
	}

	/**
	 * Pour la visite d'un texte
	 * @see Visiteur#visit(Texte)
	 */
	@Override
	public void visit(Texte texte) {

		if(texte != null){
			String font = ""+texte.getPolice()+"-"+texte.getTaillePolice();

			Graphics2D ga = (Graphics2D)g;

			ga.setColor(texte.getCrayon().getCouleur());
			ga.setFont(Font.decode(font));

			ga.drawString(texte.getTexte(), texte.getHtGauche().getX(), texte.getHtGauche().getY());
		}
	}

}
