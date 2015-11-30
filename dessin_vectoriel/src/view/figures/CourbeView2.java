package view.figures;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import abstraction.Application;
import controller.sauvegarde.JControllerSaveCourbe;

public class CourbeView2 extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int TITLE_SIZE = 25;
	public static final int CATEGORY_SIZE = 15;
	public static final int TEXT_SIZE = 20;

	private Application application;
	private ArrayList<JTextField> x;
	private ArrayList<JTextField> y;
	private boolean rempli;
	private boolean ferme;
	
	
	public CourbeView2 (Application application, CourbeView parent, boolean edition, int nb) {
		super(parent, "Créer une courbe", true);
		
		this.application = application;
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

		this.x = new ArrayList<JTextField>();
		this.y = new ArrayList<JTextField>();
		
		for(int i = 0; i<nb; i++) {
			JPanel panelPoint = new JPanel(new BorderLayout());
			JPanel panelCoordonnees = new JPanel();
			panelCoordonnees.setLayout(new BoxLayout(panelCoordonnees,BoxLayout.X_AXIS));
			JPanel panelX = new JPanel(new BorderLayout());
			JLabel x = new JLabel("Abscisse ");
			x.setFont(new Font(x.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
			panelX.add(x, BorderLayout.WEST);
			JTextField textX = new JTextField(4);
			textX.setFont(new Font(textX.getFont().getName(), Font.PLAIN, TEXT_SIZE));
			this.x.add(textX);
			JPanel panelValeurX = new JPanel();
			panelValeurX.add(this.x.get(i));
			panelValeurX.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
			panelX.add(panelValeurX, BorderLayout.CENTER);
			panelX.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

			JPanel panelY = new JPanel(new BorderLayout());
			JLabel y = new JLabel("Ordonnée ");
			y.setFont(new Font(y.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
			panelY.add(y, BorderLayout.WEST);
			JTextField textY = new JTextField(4);
			textY.setFont(new Font(textY.getFont().getName(), Font.PLAIN, TEXT_SIZE));
			this.y.add(textY);
			JPanel panelValeurY = new JPanel();
			panelValeurY.add(this.y.get(i));
			panelValeurY.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
			panelY.add(panelValeurY, BorderLayout.CENTER);
			panelY.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
			
			panelCoordonnees.add(panelX);
			panelCoordonnees.add(panelY);
			panelCoordonnees.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

			JLabel title = new JLabel("Coordonnées du point n°"+i);
			title.setFont(new Font(title.getFont().getName(), Font.BOLD, TITLE_SIZE));
			panelPoint.add(title, BorderLayout.NORTH);
			panelPoint.add(panelCoordonnees, BorderLayout.CENTER);
			panelPoint.setBorder(BorderFactory.createEmptyBorder(5, 5, 15, 5));

			panel.add(panelPoint);
		}

		JPanel panelSave = new JPanel();
		JButton save = new JButton("Enregistrer");
		this.getRootPane().setDefaultButton(save);
		JControllerSaveCourbe saveCourbe = new JControllerSaveCourbe(this.application, parent, this, edition);
		save.addActionListener(saveCourbe);
		panelSave.add(save);
		panelSave.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
		panel.add(panelSave);

		this.getContentPane().add(panel);
		this.pack();
		super.setLocationRelativeTo(parent);
	}

	public ArrayList<JTextField> getListX() {
		return this.x;
	}

	public void setListX(ArrayList<JTextField> x) {
		this.x = x;
	}

	public ArrayList<JTextField> getListY() {
		return this.y;
	}

	public void setListY(ArrayList<JTextField> y) {
		this.y = y;
	}

	public boolean isRempli() {
		return rempli;
	}

	public void setRempli(boolean rempli) {
		this.rempli = rempli;
	}

	public boolean isFerme() {
		return ferme;
	}

	public void setFerme(boolean ferme) {
		this.ferme = ferme;
	}
}