package view.figures;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import abstraction.Application;
import controller.sauvegarde.JControllerSaveRectangle;
import view.MainView;

public class RectangleView extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int TITLE_SIZE = 25;
	public static final int CATEGORY_SIZE = 15;
	public static final int TEXT_SIZE = 20;
	
	private Application application;
	private JTextField xG;
	private JTextField yG;
	private JTextField largeur;
	private JTextField hauteur;
	private JCheckBox rempli;
	
	public RectangleView (MainView parent, boolean edition, Application application) {
		super(parent, "Créer un rectangle", true);
		
		this.application = application;
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		JPanel panelRectangle = new JPanel();
		panelRectangle.setLayout(new BoxLayout(panelRectangle,BoxLayout.Y_AXIS));
		
		JPanel panelDim = new JPanel(new BorderLayout());
		JPanel panelCoordonneesD = new JPanel();
		panelCoordonneesD.setLayout(new BoxLayout(panelCoordonneesD,BoxLayout.X_AXIS));
		JPanel largeur = new JPanel(new BorderLayout());
		JLabel dx = new JLabel("Largeur (dx)");
		dx.setFont(new Font(dx.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
		largeur.add(dx, BorderLayout.WEST);
		this.largeur = new JTextField(4);
		this.largeur.setFont(new Font(this.largeur.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		JPanel panelValeurLarg = new JPanel();
		panelValeurLarg.add(this.largeur);
		panelValeurLarg.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		largeur.add(panelValeurLarg, BorderLayout.CENTER);
		largeur.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		
		JPanel hauteur = new JPanel(new BorderLayout());
		JLabel dy = new JLabel("Hauteur (dy)");
		dy.setFont(new Font(dy.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
		hauteur.add(dy, BorderLayout.WEST);
		this.hauteur = new JTextField(4);
		this.hauteur.setFont(new Font(this.hauteur.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		JPanel panelValeurHaut = new JPanel();
		panelValeurHaut.add(this.hauteur);
		panelValeurHaut.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		hauteur.add(panelValeurHaut, BorderLayout.CENTER);
		hauteur.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		panelCoordonneesD.add(largeur);
		panelCoordonneesD.add(hauteur);
		panelCoordonneesD.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		
		JLabel titleD = new JLabel("Dimensions ");
		titleD.setFont(new Font(titleD.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelDim.add(titleD, BorderLayout.NORTH);
		panelDim.add(panelCoordonneesD, BorderLayout.CENTER);
		panelDim.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JPanel panelGauche = new JPanel(new BorderLayout());
		JPanel panelCoordonnees = new JPanel();
		panelCoordonnees.setLayout(new BoxLayout(panelCoordonnees,BoxLayout.X_AXIS));
		JPanel panelX = new JPanel(new BorderLayout());
		JLabel x = new JLabel("Abscisse ");
		x.setFont(new Font(x.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
		panelX.add(x, BorderLayout.WEST);
		this.xG = new JTextField(4);
		this.xG.setFont(new Font(this.xG.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		JPanel panelValeurX = new JPanel();
		panelValeurX.add(this.xG);
		panelValeurX.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		panelX.add(panelValeurX, BorderLayout.CENTER);
		panelX.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		
		JPanel panelY = new JPanel(new BorderLayout());
		JLabel y = new JLabel("Ordonnée ");
		y.setFont(new Font(y.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
		panelY.add(y, BorderLayout.WEST);
		this.yG = new JTextField(4);
		this.yG.setFont(new Font(this.yG.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		JPanel panelValeurY = new JPanel();
		panelValeurY.add(this.yG);
		panelValeurY.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		panelY.add(panelValeurY, BorderLayout.CENTER);
		panelY.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		panelCoordonnees.add(panelX);
		panelCoordonnees.add(panelY);
		panelCoordonnees.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		
		JLabel titleC = new JLabel("Coordonnées haut gauche");
		titleC.setFont(new Font(titleC.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelGauche.add(titleC, BorderLayout.NORTH);
		panelGauche.add(panelCoordonnees, BorderLayout.CENTER);
		panelGauche.setBorder(BorderFactory.createEmptyBorder(5, 5, 20, 5));
		
		JPanel panelRempli = new JPanel(new BorderLayout());
		JLabel titleR = new JLabel("Figure ");
		titleR.setFont(new Font(titleR.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelRempli.add(titleR, BorderLayout.WEST);
		this.rempli = new JCheckBox("remplie");
		this.rempli.setFont(new Font(this.rempli.getFont().getName(), Font.ITALIC, TEXT_SIZE));
		JPanel panelValeurR = new JPanel();
		panelValeurR.add(this.rempli);
		panelValeurR.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		panelRempli.add(panelValeurR, BorderLayout.CENTER);
		panelRempli.setBorder(BorderFactory.createEmptyBorder(15, 5, 15, 5));
		
		panel.add(panelDim);
		panel.add(panelGauche);
		panel.add(panelRempli);
		
		JPanel panelSave = new JPanel();
		JButton save = new JButton("Enregistrer");
		JControllerSaveRectangle controlRectangle = new JControllerSaveRectangle(this.application, this, this.rempli.isSelected());
		save.addActionListener(controlRectangle);
		this.getRootPane().setDefaultButton(save);
		panelSave.add(save);
		panelSave.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
		panel.add(panelSave);
		
		this.getContentPane().add(panel);
		this.pack();
		super.setLocationRelativeTo(parent);
	}

	public JTextField getxG() {
		return xG;
	}

	public void setxG(JTextField xG) {
		this.xG = xG;
	}

	public JTextField getyG() {
		return yG;
	}

	public void setyG(JTextField yG) {
		this.yG = yG;
	}

	public JTextField getLargeur() {
		return largeur;
	}

	public void setLargeur(JTextField largeur) {
		this.largeur = largeur;
	}

	public JTextField getHauteur() {
		return hauteur;
	}

	public void setHauteur(JTextField hauteur) {
		this.hauteur = hauteur;
	}
}