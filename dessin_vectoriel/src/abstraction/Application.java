package abstraction;

import java.awt.Color;
import java.util.Observable;
import java.util.Vector;

import javax.swing.ImageIcon;

import implementation.Cercle;
import implementation.CourbeBezier;
import implementation.Crayon;
import implementation.Ellipse;
import implementation.Polygone;
import implementation.Rectangle;
import implementation.Segment;

public class Application extends Observable {
	//Constantes
	//== MODIFICATION  ==\\
	public static final Integer MODIFY_TRAIT_SELECTED = new Integer(0);
	public static final Integer MODIFY_COURBE_SELECTED = new Integer(1);
	public static final Integer MODIFY_CERCLE_SELECTED = new Integer(2);
	public static final Integer MODIFY_ELLIPSE_SELECTED = new Integer(3);
	public static final Integer MODIFY_CARRE_SELECTED = new Integer(4);
	public static final Integer MODIFY_RECTANGLE_SELECTED = new Integer(5);
	public static final Integer MODIFY_POLYGONE_SELECTED = new Integer(6);
	public static final Integer MODIFY_IMAGE_SELECTED = new Integer(7);

	public static final Integer MODIFY_CRAYON = new Integer(8);

	public static final Integer MODIFY_TRAITS = new Integer(9);
	public static final Integer MODIFY_COURBES = new Integer(10);
	public static final Integer MODIFY_CERCLES = new Integer(11);
	public static final Integer MODIFY_ELLIPSES = new Integer(12);
	public static final Integer MODIFY_CARRES = new Integer(13);
	public static final Integer MODIFY_RECTANGLES = new Integer(14);
	public static final Integer MODIFY_POLYGONES = new Integer(15);
	public static final Integer MODIFY_IMAGES = new Integer(16);
	
	
	//Variables d'Instance
	protected Crayon crayon;

	protected Vector<Segment> segments;
	protected Vector<CourbeBezier> courbes;
	protected Vector<Cercle> cercles;
	protected Vector<Ellipse> ellipses;
	protected Vector<Rectangle> carres;
	protected Vector<Rectangle> rectangles;
	protected Vector<Polygone> polygones;
	protected Vector<ImageIcon> images;

	protected Segment segmentSelected;
	protected CourbeBezier courbeSelected;
	protected Cercle cercleSelected;
	protected Ellipse ellipseSelected;
	protected Rectangle carreSelected;
	protected Rectangle rectangleSelected;
	protected Polygone polygoneSelected;
	protected ImageIcon imageSelected;

	public int largeur, hauteur;

	//== GETTERS & SETTERS ==\\
	public Crayon getCrayon() {
		return crayon;
	}

	public Segment getSegmentSelected() {
		return segmentSelected;
	}

	public void setSegmentSelected(Segment segmentSelected) {
		this.segmentSelected = segmentSelected;
		this.setChanged();
		this.notifyObservers(MODIFY_TRAIT_SELECTED);	
	}

	public CourbeBezier getCourbeSelected() {
		return courbeSelected;
	}

	public void setCourbeSelected(CourbeBezier courbeSelected) {
		this.courbeSelected = courbeSelected;
		this.setChanged();
		this.notifyObservers(MODIFY_COURBE_SELECTED);
	}

	public Cercle getCercleSelected() {
		return cercleSelected;
	}

	public void setCercleSelected(Cercle cercleSelected) {
		this.cercleSelected = cercleSelected;
		this.setChanged();
		this.notifyObservers(MODIFY_CERCLE_SELECTED);
	}

	public Ellipse getEllipseSelected() {
		return ellipseSelected;
	}

	public void setEllipseSelected(Ellipse ellipseSelected) {
		this.ellipseSelected = ellipseSelected;
		this.setChanged();
		this.notifyObservers(MODIFY_ELLIPSE_SELECTED);
	}

	public Rectangle getCarreSelected() {
		return carreSelected;
	}

	public void setCarreSelected(Rectangle carreSelected) {
		this.carreSelected = carreSelected;
		this.setChanged();
		this.notifyObservers(MODIFY_CARRE_SELECTED);
	}

	public Rectangle getRectangleSelected() {
		return rectangleSelected;
	}

	public void setRectangleSelected(Rectangle rectangleSelected) {
		this.rectangleSelected = rectangleSelected;
		this.setChanged();
		this.notifyObservers(MODIFY_RECTANGLE_SELECTED);
	}

	public Polygone getPolygoneSelected() {
		return polygoneSelected;
	}

	public void setPolygoneSelected(Polygone polygoneSelected) {
		this.polygoneSelected = polygoneSelected;
		this.setChanged();
		this.notifyObservers(MODIFY_POLYGONE_SELECTED);
	}

	public ImageIcon getImageSelected() {
		return imageSelected;
	}

	public void setImageSelected(ImageIcon imageSelected) {
		this.imageSelected = imageSelected;
		this.setChanged();
		this.notifyObservers(MODIFY_IMAGE_SELECTED);
	}

	public void setCrayon(Crayon crayon) {
		this.crayon = crayon;
	}

	public Vector<Segment> getSegments() {
		return segments;
	}

	public void setSegments(Vector<Segment> segments) {
		this.segments = segments;
		this.setChanged();
		this.notifyObservers(MODIFY_TRAITS);
	}

	public Vector<CourbeBezier> getCourbes() {
		return courbes;
	}

	public void setCourbes(Vector<CourbeBezier> courbes) {
		this.courbes = courbes;
		this.setChanged();
		this.notifyObservers(MODIFY_COURBES);
	}

	public Vector<Cercle> getCercles() {
		return cercles;
	}

	public void setCercles(Vector<Cercle> cercles) {
		this.cercles = cercles;
		this.setChanged();
		this.notifyObservers(MODIFY_CERCLES);
	}

	public Vector<Ellipse> getEllipses() {
		return ellipses;
	}

	public void setEllipses(Vector<Ellipse> ellipses) {
		this.ellipses = ellipses;
		this.setChanged();
		this.notifyObservers(MODIFY_ELLIPSES);
	}

	public Vector<Rectangle> getCarres() {
		return carres;
	}

	public void setCarres(Vector<Rectangle> carres) {
		this.carres = carres;
		this.setChanged();
		this.notifyObservers(MODIFY_CARRES);
	}

	public Vector<Rectangle> getRectangles() {
		return rectangles;
	}

	public void setRectangles(Vector<Rectangle> rectangles) {
		this.rectangles = rectangles;
		this.setChanged();
		this.notifyObservers(MODIFY_RECTANGLES);
	}

	public Vector<Polygone> getPolygones() {
		return polygones;
	}

	public void setPolygones(Vector<Polygone> polygones) {
		this.polygones = polygones;
		this.setChanged();
		this.notifyObservers(MODIFY_POLYGONES);
	}

	public Vector<ImageIcon> getImages() {
		return images;
	}

	public void setImages(Vector<ImageIcon> images) {
		this.images = images;
		this.setChanged();
		this.notifyObservers(MODIFY_IMAGES);
	}
	
	public void addSegment(Segment s) {
		this.getSegments().add(s);
		System.out.println("Segments : "+this.getSegments().size());
		this.setChanged();
		this.notifyObservers(MODIFY_TRAITS);
	}
	
	public void addCarre(Rectangle c) {
		this.getCarres().add(c);
		System.out.println("Carres : "+this.getCarres().size());
		this.setChanged();
		this.notifyObservers(MODIFY_CARRES);
	}
	
	public void addCercle(Cercle c) {
		this.getCercles().add(c);
		System.out.println("Cercles : "+this.getCercles().size());
		this.setChanged();
		this.notifyObservers(MODIFY_CERCLES);
	}

	public void addCourbe(CourbeBezier c) {
		this.getCourbes().add(c);
		System.out.println("Courbes : "+this.getCourbes().size());
		this.setChanged();
		this.notifyObservers(MODIFY_COURBES);
	}
	
	public void addEllipse(Ellipse e) {
		this.getEllipses().add(e);
		System.out.println("Ellipse : "+this.getEllipses().size());
		this.setChanged();
		this.notifyObservers(MODIFY_ELLIPSES);
	}
	
	public void addImage(ImageIcon i) {
		this.getImages().add(i);
		this.setChanged();
		this.notifyObservers(MODIFY_IMAGES);
	}
	
	public void addPolygone(Polygone p) {
		this.getPolygones().add(p);
		System.out.println("Polygone : "+this.getPolygones().size());
		this.setChanged();
		this.notifyObservers(MODIFY_POLYGONES);
	}
	
	public void addRectangle(Rectangle r) {
		this.getRectangles().add(r);
		System.out.println("Rectangles : "+this.getRectangles().size());
		this.setChanged();
		this.notifyObservers(MODIFY_RECTANGLES);
	}
	
	public Application(int largeur, int hauteur) {
		//Initialisation des variables d'instance
		this.largeur = largeur;
		this.hauteur = hauteur;

		this.crayon = new Crayon(5, Color.BLACK);
		this.segments = new Vector<Segment>();
		this.courbes = new Vector<CourbeBezier>();
		this.cercles = new Vector<Cercle>();
		this.ellipses = new Vector<Ellipse>();
		this.carres = new Vector<Rectangle>();
		this.rectangles = new Vector<Rectangle>();
		this.polygones = new Vector<Polygone>();
		this.images = new Vector<ImageIcon>();
	}
}
