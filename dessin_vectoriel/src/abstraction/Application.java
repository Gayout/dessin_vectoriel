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
	
	public static final Integer MODIFY_DESSINS = new Integer(17);
	
	//Variables d'Instance
	protected Crayon crayon;

	protected Vector<Chemin> dessins;
	
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

	public Vector<Chemin> getDessins() {
		return this.dessins;
	}
	
	public void addDessin(Chemin c) {
		this.getDessins().add(c);
		this.setChanged();
		this.notifyObservers(MODIFY_DESSINS);
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
		this.notifyObservers(MODIFY_TRAIT_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}

	public Vector<CourbeBezier> getCourbes() {
		return courbes;
	}

	public void setCourbes(Vector<CourbeBezier> courbes) {
		this.courbes = courbes;
		this.setChanged();

		this.notifyObservers(MODIFY_COURBES);
		this.notifyObservers(MODIFY_COURBE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}

	public Vector<Cercle> getCercles() {
		return cercles;
	}

	public void setCercles(Vector<Cercle> cercles) {
		this.cercles = cercles;
		this.setChanged();

		this.notifyObservers(MODIFY_CERCLES);
		this.notifyObservers(MODIFY_CERCLE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}

	public Vector<Ellipse> getEllipses() {
		return ellipses;
	}

	public void setEllipses(Vector<Ellipse> ellipses) {
		this.ellipses = ellipses;
		this.setChanged();

		this.notifyObservers(MODIFY_ELLIPSES);
		this.notifyObservers(MODIFY_ELLIPSE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}

	public Vector<Rectangle> getCarres() {
		return carres;
	}

	public void setCarres(Vector<Rectangle> carres) {
		this.carres = carres;
		this.setChanged();

		this.notifyObservers(MODIFY_CARRES);
		this.notifyObservers(MODIFY_CARRE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}

	public Vector<Rectangle> getRectangles() {
		return rectangles;
	}

	public void setRectangles(Vector<Rectangle> rectangles) {
		this.rectangles = rectangles;
		this.setChanged();

		this.notifyObservers(MODIFY_RECTANGLES);
		this.notifyObservers(MODIFY_RECTANGLE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}

	public Vector<Polygone> getPolygones() {
		return polygones;
	}

	public void setPolygones(Vector<Polygone> polygones) {
		this.polygones = polygones;
		this.setChanged();

		this.notifyObservers(MODIFY_POLYGONES);
		this.notifyObservers(MODIFY_POLYGONE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}

	public Vector<ImageIcon> getImages() {
		return images;
	}

	public void setImages(Vector<ImageIcon> images) {
		this.images = images;
		this.setChanged();

		this.notifyObservers(MODIFY_IMAGES);
		this.notifyObservers(MODIFY_IMAGE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void addSegment(Segment s) {
		this.getSegments().add(s);
		this.setChanged();

		this.notifyObservers(MODIFY_TRAITS);
		this.notifyObservers(MODIFY_TRAIT_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void addCarre(Rectangle c) {
		this.getCarres().add(c);
		this.setChanged();

		this.notifyObservers(MODIFY_CARRES);
		this.notifyObservers(MODIFY_CARRE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void addCercle(Cercle c) {
		this.getCercles().add(c);
		this.setChanged();

		this.notifyObservers(MODIFY_CERCLES);
		this.notifyObservers(MODIFY_CERCLE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}

	public void addCourbe(CourbeBezier c) {
		this.getCourbes().add(c);
		this.setChanged();

		this.notifyObservers(MODIFY_COURBES);
		this.notifyObservers(MODIFY_COURBE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void addEllipse(Ellipse e) {
		this.getEllipses().add(e);
		this.setChanged();

		this.notifyObservers(MODIFY_ELLIPSES);
		this.notifyObservers(MODIFY_ELLIPSE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void addImage(ImageIcon i) {
		this.getImages().add(i);
		this.setChanged();

		this.notifyObservers(MODIFY_IMAGES);
		this.notifyObservers(MODIFY_IMAGE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void addPolygone(Polygone p) {
		this.getPolygones().add(p);
		this.setChanged();

		this.notifyObservers(MODIFY_POLYGONES);
		this.notifyObservers(MODIFY_POLYGONE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void addRectangle(Rectangle r) {
		this.getRectangles().add(r);
		this.setChanged();

		this.notifyObservers(MODIFY_RECTANGLES);
		this.notifyObservers(MODIFY_RECTANGLE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void removeDessin(Chemin c) {
		boolean aret = false;
		int j = 0;
		for(int i=0; i<this.getDessins().size() && !aret;i++) {
			aret = this.getDessins().get(i).equals(c);
			j++;
		}
		if (aret) {
			this.getDessins().remove(j-1);
		}
		this.setChanged();
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void removeSegment(int i) {
		this.getSegments().remove(i);
		this.setChanged();

		this.notifyObservers(MODIFY_TRAITS);
		this.notifyObservers(MODIFY_TRAIT_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void removeCarre(int i) {
		this.getCarres().remove(i);
		this.setChanged();

		this.notifyObservers(MODIFY_CARRES);
		this.notifyObservers(MODIFY_CARRE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void removeCercle(int i) {
		this.getCercles().remove(i);
		this.setChanged();

		this.notifyObservers(MODIFY_CERCLES);
		this.notifyObservers(MODIFY_CERCLE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}

	public void removeCourbe(int i) {
		this.getCourbes().remove(i);
		this.setChanged();

		this.notifyObservers(MODIFY_COURBES);
		this.notifyObservers(MODIFY_COURBE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void removeEllipse(int i) {
		this.getEllipses().remove(i);
		this.setChanged();

		this.notifyObservers(MODIFY_ELLIPSES);
		this.notifyObservers(MODIFY_ELLIPSE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void removeImage(int i) {
		this.getImages().remove(i);
		this.setChanged();

		this.notifyObservers(MODIFY_IMAGES);
		this.notifyObservers(MODIFY_IMAGE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void removePolygone(int i) {
		this.getPolygones().remove(i);
		this.setChanged();

		this.notifyObservers(MODIFY_POLYGONES);
		this.notifyObservers(MODIFY_POLYGONE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void removeRectangle(int i) {
		this.getRectangles().remove(i);
		this.setChanged();

		this.notifyObservers(MODIFY_RECTANGLES);
		this.notifyObservers(MODIFY_RECTANGLE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void replaceDessin(Chemin cAncien, Chemin cNew) {
		boolean aret = false;
		int j = 0;
		for(int i=0; i<this.getDessins().size() && !aret;i++) {
			aret = this.getDessins().get(i).equals(cAncien);
			j++;
		}
		if (aret) {
			this.getDessins().set(j-1, cNew);
		}
		this.setChanged();
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void replaceSegment(int i, Segment newS) {
		this.getSegments().set(i, newS);
		this.setChanged();

		this.notifyObservers(MODIFY_TRAITS);
		this.notifyObservers(MODIFY_TRAIT_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void replaceCarre(int i, Rectangle newC) {
		this.getCarres().set(i, newC);
		this.setChanged();

		this.notifyObservers(MODIFY_CARRES);
		this.notifyObservers(MODIFY_CARRE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void replaceCercle(int i, Cercle newC) {
		this.getCercles().set(i, newC);
		this.setChanged();

		this.notifyObservers(MODIFY_CERCLES);
		this.notifyObservers(MODIFY_CERCLE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}

	public void replaceCourbe(int i, CourbeBezier newC) {
		this.getCourbes().set(i, newC);
		this.setChanged();

		this.notifyObservers(MODIFY_COURBES);
		this.notifyObservers(MODIFY_COURBE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void replaceEllipse(int i, Ellipse newE) {
		this.getEllipses().set(i, newE);
		this.setChanged();

		this.notifyObservers(MODIFY_ELLIPSES);
		this.notifyObservers(MODIFY_ELLIPSE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void replaceImage(int i, ImageIcon newI) {
		this.getImages().set(i, newI);
		this.setChanged();

		this.notifyObservers(MODIFY_IMAGES);
		this.notifyObservers(MODIFY_IMAGE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void replacePolygone(int i, Polygone newP) {
		this.getPolygones().set(i, newP);
		this.setChanged();

		this.notifyObservers(MODIFY_POLYGONES);
		this.notifyObservers(MODIFY_POLYGONE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public void replaceRectangle(int i, Rectangle newR) {
		this.getRectangles().set(i, newR);
		this.setChanged();

		this.notifyObservers(MODIFY_RECTANGLES);
		this.notifyObservers(MODIFY_RECTANGLE_SELECTED);
		this.notifyObservers(MODIFY_DESSINS);
	}
	
	public Application(int largeur, int hauteur) {
		//Initialisation des variables d'instance
		this.largeur = largeur;
		this.hauteur = hauteur;

		this.crayon = new Crayon(5, Color.BLACK);
		
		this.dessins = new Vector<Chemin>();
		
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
