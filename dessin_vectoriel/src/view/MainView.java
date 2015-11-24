package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.*;

import abstraction.Application;
import controller.crayon.JControllerButtonColor;
import controller.crayon.JControllerSlider;
import controller.listes.JControllerListCarre;
import controller.listes.JControllerListCercle;
import controller.listes.JControllerListCourbe;
import controller.listes.JControllerListEllipse;
import controller.listes.JControllerListPolygone;
import controller.listes.JControllerListRectangle;
import controller.listes.JControllerListSegment;
import controller.menuFigures.JControllerButtonFiguresCarre;
import controller.menuFigures.JControllerButtonFiguresCercle;
import controller.menuFigures.JControllerButtonFiguresCourbe;
import controller.menuFigures.JControllerButtonFiguresEllipse;
import controller.menuFigures.JControllerButtonFiguresImage;
import controller.menuFigures.JControllerButtonFiguresPolygone;
import controller.menuFigures.JControllerButtonFiguresRectangle;
import controller.menuFigures.JControllerButtonFiguresSegment;

public class MainView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Constantes
	//== TAILLE POLICE ==\\
	public static final int MENU_SIZE = 25;
	public static final int ITEM_MENU_SIZE = 15;
	public static final int CRAYON_SIZE = 20;
	public static final int ITEM_CRAYON_SIZE = 15;
	public static final int ITEM_MODIFICATION_SIZE = 30;
	public static final int TITLE_MODIFICATION_SIZE = 30;
	public static final int ITEM_LIST_MODIFICATION_SIZE = 20;

	//== COULEUR DES POLICES ==\\
	public static final Color CRAYON_COLOR_POLICE = Color.BLACK;
	public static final Color ITEM_CRAYON_COLOR_POLICE = Color.WHITE;
	public static final Color ITEM_MODIFICATION_COLOR_POLICE = Color.WHITE;

	//== COULEUR DE FOND ==\\
	public static final Color CRAYON_COLOR_BACKGROUND = Color.WHITE;
	public static final Color ITEM_CRAYON_COLOR_BACKGROUND = Color.BLACK;
	public static final Color ITEM_DESSIN_COLOR_BACKGROUND = Color.BLACK;
	public static final Color ITEM_MODIFICATION_COLOR_BACKGROUND = Color.BLACK;


	//Variables d'instance
	private Application application;

	protected JList<String> listSegments;
	protected JList<String> listCourbes;
	protected JList<String> listCercles;
	protected JList<String> listEllipses;
	protected JList<String> listCarres;
	protected JList<String> listRectangles;
	protected JList<String> listPolygones;
	protected JList<String> listImages;


	//== GETTERS & SETTERS ==\\

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public JList<String> getListSegments() {
		return listSegments;
	}

	public void setListSegments(JList<String> listSegments) {
		this.listSegments = listSegments;
	}

	public JList<String> getListCourbes() {
		return listCourbes;
	}

	public void setListCourbes(JList<String> listCourbes) {
		this.listCourbes = listCourbes;
	}

	public JList<String> getListCercles() {
		return listCercles;
	}

	public void setListCercles(JList<String> listCercles) {
		this.listCercles = listCercles;
	}

	public JList<String> getListEllipses() {
		return listEllipses;
	}

	public void setListEllipses(JList<String> listEllipses) {
		this.listEllipses = listEllipses;
	}

	public JList<String> getListCarres() {
		return listCarres;
	}

	public void setListCarres(JList<String> listCarres) {
		this.listCarres = listCarres;
	}

	public JList<String> getListRectangles() {
		return listRectangles;
	}

	public void setListRectangles(JList<String> listRectangles) {
		this.listRectangles = listRectangles;
	}

	public JList<String> getListPolygones() {
		return listPolygones;
	}

	public void setListPolygones(JList<String> listPolygones) {
		this.listPolygones = listPolygones;
	}

	public JList<String> getListImages() {
		return listImages;
	}

	public void setListImages(JList<String> listImages) {
		this.listImages = listImages;
	}

	//== CONSTRUCTEUR ==\\
	public MainView(Application application) {
		super("Mini Projet - Dessin Vectoriel");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.getContentPane().setLayout(new BorderLayout());

		this.application = application;

		this.listSegments = new JList<String>();
		this.listCourbes = new JList<String>();
		this.listCercles = new JList<String>();
		this.listEllipses = new JList<String>();
		this.listCarres = new JList<String>();
		this.listRectangles = new JList<String>();
		this.listPolygones = new JList<String>();
		this.listImages = new JList<String>();

		//Barre Menu
		this.createBarreMenu();

		//Choix Crayon
		this.createCrayon();

		//Creation Figures
		this.createFigureMenu();

		//Modification Figures Créées
		this.createModificationMenu();

		//Ajout Preview AWT
		this.createPreview();
		
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);		
	}

	//== ELEMENTS DE L'INTERFACE GRAPHIQUE==\\
	public void createBarreMenu() {
		JMenuBar barreMenu = new JMenuBar();
		JMenu fichier = new JMenu("Fichier");
		fichier.setFont(new Font(fichier.getFont().getName(), Font.BOLD, MENU_SIZE));
		JMenuItem nouveau = new JMenuItem("Nouveau");
		nouveau.setFont(new Font(nouveau.getFont().getName(), Font.BOLD, ITEM_MENU_SIZE));
		nouveau.setMnemonic('n');
		fichier.add(nouveau);
		JMenuItem enregistrer = new JMenuItem("Enregistrer sous");
		enregistrer.setFont(new Font(enregistrer.getFont().getName(), Font.BOLD, ITEM_MENU_SIZE));
		enregistrer.setMnemonic('s');
		fichier.add(enregistrer);
		barreMenu.add(fichier);
		this.setJMenuBar(barreMenu);
	}

	public void createCrayon() {
		JPanel crayonPanel = new JPanel();
		crayonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		crayonPanel.setBackground(ITEM_CRAYON_COLOR_BACKGROUND);
		crayonPanel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		crayonPanel.setLayout(new BoxLayout(crayonPanel, BoxLayout.X_AXIS));

		//Titre
		JPanel titrePanel = new JPanel();
		titrePanel.setLayout(new BoxLayout(titrePanel, BoxLayout.X_AXIS));
		titrePanel.setBackground(CRAYON_COLOR_BACKGROUND);

		JLabel dessin = new JLabel(new ImageIcon(getClass().getResource("/view/images/Crayon.png")));
		titrePanel.add(dessin);
		JLabel titre = new JLabel("CRAYON : ");
		titre.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		titre.setFont(new Font(titre.getFont().getName(), Font.BOLD, CRAYON_SIZE));
		titre.setForeground(CRAYON_COLOR_POLICE);
		titrePanel.add(titre);
		titrePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 40));

		crayonPanel.add(titrePanel);

		//Epaisseur
		JPanel epaisseurPanel = new JPanel();
		epaisseurPanel.setBackground(ITEM_CRAYON_COLOR_BACKGROUND);
		epaisseurPanel.setLayout(new BoxLayout(epaisseurPanel, BoxLayout.X_AXIS));

		JLabel eTitre = new JLabel("épaisseur");
		eTitre.setForeground(ITEM_CRAYON_COLOR_POLICE);
		eTitre.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		eTitre.setFont(new Font(eTitre.getFont().getName(), Font.ITALIC, ITEM_CRAYON_SIZE));
		epaisseurPanel.add(eTitre);
		JSlider eSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
		JControllerSlider controlESlider = new JControllerSlider(this.getApplication());
		eSlider.addChangeListener(controlESlider);
		Hashtable<Integer, JLabel> etiquettes = new Hashtable<Integer, JLabel>();
		JLabel t0 = new JLabel("0");
		t0.setForeground(ITEM_CRAYON_COLOR_POLICE);
		t0.setFont(new Font(t0.getFont().getName(), Font.BOLD, 10));
		etiquettes.put(new Integer(0),  t0);
		JLabel t5 = new JLabel("5");
		t5.setForeground(ITEM_CRAYON_COLOR_POLICE);
		t5.setFont(new Font(t5.getFont().getName(), Font.BOLD, 8));
		etiquettes.put(new Integer(5),  t5);
		JLabel t10 = new JLabel("10");
		t10.setForeground(ITEM_CRAYON_COLOR_POLICE);
		t10.setFont(new Font(t10.getFont().getName(), Font.BOLD, 10));
		etiquettes.put(new Integer(10),  t10);
		eSlider.setLabelTable(etiquettes);
		eSlider.setPaintLabels(true);
		eSlider.setBackground(ITEM_CRAYON_COLOR_BACKGROUND);
		eSlider.setMajorTickSpacing(5);
		eSlider.setMinorTickSpacing(1);
		eSlider.setPaintTicks(true);
		epaisseurPanel.add(eSlider);
		epaisseurPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 20));

		crayonPanel.add(epaisseurPanel);

		//Couleur
		JPanel couleurPanel = new JPanel();
		couleurPanel.setBackground(ITEM_CRAYON_COLOR_BACKGROUND);
		couleurPanel.setLayout(new BoxLayout(couleurPanel, BoxLayout.X_AXIS));

		JLabel cTitre = new JLabel("couleur");
		cTitre.setForeground(ITEM_CRAYON_COLOR_POLICE);
		cTitre.setFont(new Font(cTitre.getFont().getName(), Font.ITALIC, ITEM_CRAYON_SIZE));
		cTitre.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		couleurPanel.add(cTitre);
		JButton choixCouleur = new JButton();
		JControllerButtonColor controlChoixCouleur = new JControllerButtonColor(choixCouleur, this.getApplication());
		choixCouleur.addActionListener(controlChoixCouleur);
		choixCouleur.setToolTipText("Sélectionner une nouvelle couleur");
		choixCouleur.setBackground(this.application.getCrayon().getCouleur());
		choixCouleur.setForeground(this.application.getCrayon().getCouleur());
		couleurPanel.add(choixCouleur);
		couleurPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 900));

		crayonPanel.add(couleurPanel);

		this.getContentPane().add(crayonPanel, BorderLayout.NORTH);
		this.pack();
	}

	public void createFigureMenu() {
		JPanel figuresPanel = new JPanel();
		figuresPanel.setLayout(new GridLayout(8,1));
		figuresPanel.setBackground(ITEM_DESSIN_COLOR_BACKGROUND);

		JPanel traitPanel = new JPanel();
		traitPanel.setBackground(ITEM_DESSIN_COLOR_BACKGROUND);
		JButton bTrait = new JButton(new ImageIcon(getClass().getResource("/view/images/Segment.png")));
		JControllerButtonFiguresSegment controllerSegment = new JControllerButtonFiguresSegment(this, false, this.getApplication());
		bTrait.addActionListener(controllerSegment);
		bTrait.setToolTipText("Tracer un trait");
		traitPanel.add(bTrait);
		traitPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 15));
		figuresPanel.add(traitPanel);

		JPanel courbePanel = new JPanel();
		courbePanel.setBackground(ITEM_DESSIN_COLOR_BACKGROUND);
		JButton bCourbe = new JButton(new ImageIcon(getClass().getResource("/view/images/Courbe.png")));
		JControllerButtonFiguresCourbe controllerCourbe = new JControllerButtonFiguresCourbe(this, false, this.getApplication());
		bCourbe.addActionListener(controllerCourbe);
		bCourbe.setToolTipText("Tracer une courbe");
		courbePanel.add(bCourbe);
		courbePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 15));
		figuresPanel.add(courbePanel);

		JPanel cerclePanel = new JPanel();
		cerclePanel.setBackground(ITEM_DESSIN_COLOR_BACKGROUND);
		JButton bCercle = new JButton(new ImageIcon(getClass().getResource("/view/images/Cercle.png")));
		JControllerButtonFiguresCercle controllerCercle = new JControllerButtonFiguresCercle(this, false, this.getApplication());
		bCercle.addActionListener(controllerCercle);
		bCercle.setToolTipText("Tracer un cercle");
		cerclePanel.add(bCercle);
		cerclePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 15));
		figuresPanel.add(cerclePanel);

		JPanel ellipsePanel = new JPanel();
		ellipsePanel.setBackground(ITEM_DESSIN_COLOR_BACKGROUND);
		JButton bEllipse = new JButton(new ImageIcon(getClass().getResource("/view/images/Ellipse.png")));
		JControllerButtonFiguresEllipse controllerEllipse = new JControllerButtonFiguresEllipse(this, false, this.getApplication());
		bEllipse.addActionListener(controllerEllipse);
		bEllipse.setToolTipText("Tracer une ellipse");
		ellipsePanel.add(bEllipse);
		ellipsePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 15));
		figuresPanel.add(ellipsePanel);

		JPanel carrePanel = new JPanel();
		carrePanel.setBackground(ITEM_DESSIN_COLOR_BACKGROUND);
		JButton bCarre = new JButton(new ImageIcon(getClass().getResource("/view/images/Carré.png")));
		JControllerButtonFiguresCarre controllerCarre = new JControllerButtonFiguresCarre(this, false, this.getApplication());
		bCarre.addActionListener(controllerCarre);
		bCarre.setToolTipText("Tracer un carré");
		carrePanel.add(bCarre);
		carrePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 15));
		figuresPanel.add(carrePanel);

		JPanel rectanglePanel = new JPanel();
		rectanglePanel.setBackground(ITEM_DESSIN_COLOR_BACKGROUND);
		JButton bRectangle = new JButton(new ImageIcon(getClass().getResource("/view/images/Rectangle.png")));
		JControllerButtonFiguresRectangle controllerRectangle = new JControllerButtonFiguresRectangle(this, false,this.getApplication());
		bRectangle.addActionListener(controllerRectangle);
		bRectangle.setToolTipText("Tracer un rectangle");
		rectanglePanel.add(bRectangle);
		rectanglePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 15));
		figuresPanel.add(rectanglePanel);

		JPanel polygonePanel = new JPanel();
		polygonePanel.setBackground(ITEM_DESSIN_COLOR_BACKGROUND);
		JButton bPolygone = new JButton(new ImageIcon(getClass().getResource("/view/images/Polygone.png")));
		JControllerButtonFiguresPolygone controllerPolygone = new JControllerButtonFiguresPolygone(this, false, this.getApplication());
		bPolygone.addActionListener(controllerPolygone);
		bPolygone.setToolTipText("Tracer un polygone");
		polygonePanel.add(bPolygone);
		polygonePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 15));
		figuresPanel.add(polygonePanel);

		JPanel imagePanel = new JPanel();
		imagePanel.setBackground(ITEM_DESSIN_COLOR_BACKGROUND);
		JButton bImage = new JButton(new ImageIcon(getClass().getResource("/view/images/Image.png")));
		JControllerButtonFiguresImage controllerImage = new JControllerButtonFiguresImage(this, false);
		bImage.addActionListener(controllerImage);
		bImage.setToolTipText("Insérer une image");
		imagePanel.add(bImage);
		imagePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 15));
		figuresPanel.add(imagePanel);
		
		this.getContentPane().add(figuresPanel, BorderLayout.WEST);
		this.pack();
	}

	private void createModificationMenu() {
		JTabbedPane menu = new JTabbedPane();

		menu.setFont(new Font(menu.getFont().getName(), Font.BOLD, ITEM_MODIFICATION_SIZE));
		menu.setBackground(ITEM_MODIFICATION_COLOR_BACKGROUND);
		menu.setForeground(ITEM_MODIFICATION_COLOR_POLICE);

		PanelModification traits = new PanelModification("Trait", this.getListSegments());
		JControllerListSegment controlSegments = new JControllerListSegment(this, this.getListSegments(), this.getApplication());
		this.getApplication().addObserver(controlSegments);
		this.getListSegments().addListSelectionListener(controlSegments);
		menu.addTab("Trait", traits);
		menu.setMnemonicAt(0, '0');
		
		PanelModification courbes = new PanelModification("Courbe", this.getListCourbes());
		JControllerListCourbe controlCourbes = new JControllerListCourbe(this, this.getListCourbes(), this.getApplication());
		this.getApplication().addObserver(controlCourbes);
		this.getListCourbes().addListSelectionListener(controlCourbes);
		menu.addTab("Courbe", courbes);
		menu.setMnemonicAt(1, '1');
		
		PanelModification cercles = new PanelModification("Cercle", this.getListCercles());
		JControllerListCercle controlCercles = new JControllerListCercle(this, this.getListCercles(), this.getApplication());
		this.getApplication().addObserver(controlCercles);
		this.getListCercles().addListSelectionListener(controlCercles);
		menu.addTab("Cercle", cercles);
		menu.setMnemonicAt(2, '2');
		
		PanelModification ellipses = new PanelModification("Ellipse", this.getListEllipses());
		JControllerListEllipse controlEllipses = new JControllerListEllipse(this, this.getListEllipses(), this.getApplication());
		this.getApplication().addObserver(controlEllipses);
		this.getListEllipses().addListSelectionListener(controlEllipses);
		menu.addTab("Ellipse", ellipses);
		menu.setMnemonicAt(3, '3');
		
		PanelModification carres = new PanelModification("Carré", this.getListCarres());
		JControllerListCarre controlCarres = new JControllerListCarre(this, this.getListCarres(), this.getApplication());
		this.getApplication().addObserver(controlCarres);
		this.getListCarres().addListSelectionListener(controlCarres);
		menu.addTab("Carré", carres);
		menu.setMnemonicAt(4, '4');
		
		PanelModification rectangles = new PanelModification("Rectangle", this.getListRectangles());
		JControllerListRectangle controlRectangles = new JControllerListRectangle(this, this.getListRectangles(), this.getApplication());
		this.getApplication().addObserver(controlRectangles);
		this.getListRectangles().addListSelectionListener(controlRectangles);
		menu.addTab("Rectangle", rectangles);
		menu.setMnemonicAt(5, '5');
		
		PanelModification polygones = new PanelModification("Polygone", this.getListPolygones());
		JControllerListPolygone controlPolygones = new JControllerListPolygone(this, this.getListPolygones(), this.getApplication());
		this.getApplication().addObserver(controlPolygones);
		this.getListPolygones().addListSelectionListener(controlPolygones);
		menu.addTab("Polygone", polygones);
		menu.setMnemonicAt(6, '6');
		
		/*PanelModification images = new PanelModification("Image", this.getListImages());
		JControllerListImage controlImages = new JControllerListImage(this, this.getListImages(), this.getApplication());
		this.getApplication().addObserver(controlImages);
		this.getListImages().addListSelectionListener(controlImages);
		menu.addTab("Image", images);
		menu.setMnemonicAt(7, '7');*/
		
		menu.setTabPlacement(JTabbedPane.RIGHT);

		this.getContentPane().add(menu, BorderLayout.EAST);
		this.pack();
	}



	private void createPreview() {
		JTabbedPane menu = new JTabbedPane();

		menu.setFont(new Font(menu.getFont().getName(), Font.BOLD, ITEM_MODIFICATION_SIZE));
		menu.setBackground(ITEM_MODIFICATION_COLOR_BACKGROUND);
		menu.setForeground(ITEM_MODIFICATION_COLOR_POLICE);
		
		JPanel panelAWT = new JPanel();
		
		menu.addTab("AWT", panelAWT);
		menu.setMnemonicAt(5, '5');
		
		this.getContentPane().add(menu, BorderLayout.EAST);
		this.pack();
	}
	
	class PanelModification extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public PanelModification (String s, JList<String> liste) {
			this.setLayout(new BorderLayout());
			JLabel title = new JLabel(s);
			title.setFont(new Font(title.getFont().getName(), Font.BOLD, TITLE_MODIFICATION_SIZE));
			this.add(title, BorderLayout.NORTH);
			liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			liste.setFont(new Font(liste.getFont().getName(), Font.PLAIN, ITEM_LIST_MODIFICATION_SIZE));
			this.add(liste, BorderLayout.CENTER);
		}
	}
}