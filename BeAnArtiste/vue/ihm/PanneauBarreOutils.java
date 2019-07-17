package fr.eseo.i1.gpi.artiste.vue.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import fr.eseo.i1.gpi.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.i1.gpi.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.i1.gpi.artiste.controleur.actions.ActionChoisirRemplissage;
import fr.eseo.i1.gpi.artiste.controleur.actions.ActionEffacer;
import fr.eseo.i1.gpi.artiste.controleur.actions.ActionExporter;
import fr.eseo.i1.gpi.artiste.controleur.actions.ActionRedo;
import fr.eseo.i1.gpi.artiste.controleur.actions.ActionUndo;
import fr.eseo.i1.gpi.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.i1.gpi.artiste.modele.formes.Etoile;

/**
 * Classe JPanel qui gère les outils de conception d'un dessin
 * @author Martin Blot
 * @version 1.0
 */
public class PanneauBarreOutils extends JPanel {
	
	public static final String BRANCHE_SPINNER_NOM = "Nombre de branche";
	public static final String LONGUEUR_SPINNER_NOM = "Longueur des branches";
	public static final String TAILLE_SPINNER_NOM = "Taille du texte :";
	public static final String FONT_COMBOBOX_NOM = "Police :";
	public static final int LARGEUR_BOUTON_PAR_DEFAUT = 200;
	public static final int TAILLE_TEXTE_1_PAR_DEFAUT = 16;
	public static final int TAILLE_TEXTE_2_PAR_DEFAUT = 12;
	
	private PanneauDessin panneauDessin = null;
	public static SpinnerNumberModel spinnerNombreBranche;
	public static SpinnerNumberModel spinnerLongueurBranche;
	public static SpinnerNumberModel spinnerTailleTexte;
	public static JPanel panelCouleurCourante;
	public static JComboBox<String> jcombobox;
	
	public PanneauBarreOutils(PanneauDessin panneau) {
	    this.panneauDessin = panneau;
	    this.setPreferredSize(new Dimension(220, this.panneauDessin.getHeight()));
	    initComponents();
	}

	private void initComponents() {
		
		//Création du groupe de boutton pour les formes
        ButtonGroup boutonsFormes = new ButtonGroup();
        
        
//-----------------------------------GESTION DES FORMES----------------------------------------------------------------------------------
		
        JPanel panneauForme = new JPanel();
        panneauForme.setBorder(BorderFactory.createTitledBorder("Outil Forme"));
        panneauForme.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT + 15, 180));
        
        //BOUTON LIGNE
        JToggleButton boutonLigne = new JToggleButton(new ActionChoisirForme(panneauDessin, this, "Ligne"));
        boutonLigne.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT, 25));
        boutonLigne.setAlignmentX(Component.CENTER_ALIGNMENT);
        boutonsFormes.add(boutonLigne);
        panneauForme.add(boutonLigne);
        
        //BOUTON RECTANGLE
        JToggleButton boutonRectangle = new JToggleButton(new ActionChoisirForme(panneauDessin, this, "Rectangle"));
        boutonRectangle.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT, 25));
        boutonRectangle.setAlignmentX(Component.CENTER_ALIGNMENT);
        boutonsFormes.add(boutonRectangle);
        panneauForme.add(boutonRectangle);
        
        //BOUTON CARRE
        JToggleButton boutonCarre = new JToggleButton(new ActionChoisirForme(panneauDessin, this, "Carré"));
        boutonCarre.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT, 25));
        boutonCarre.setAlignmentX(Component.CENTER_ALIGNMENT);
        boutonsFormes.add(boutonCarre);
        panneauForme.add(boutonCarre);
        
        //BOUTON ELLIPSE
	    JToggleButton boutonEllipse = new JToggleButton(new ActionChoisirForme(panneauDessin, this, "Ellipse"));
	    boutonEllipse.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT, 25));
	    boutonEllipse.setAlignmentX(Component.CENTER_ALIGNMENT);
	    boutonsFormes.add(boutonEllipse);
	    panneauForme.add(boutonEllipse);
        
	    //BOUTON CERCLE
        JToggleButton boutonCercle = new JToggleButton(new ActionChoisirForme(panneauDessin, this, "Cercle"));
        boutonCercle.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT, 25));
        boutonCercle.setAlignmentX(Component.CENTER_ALIGNMENT);
        boutonsFormes.add(boutonCercle);
        panneauForme.add(boutonCercle);
        
        this.add(panneauForme);
        
        
//-----------------------------------GESTION DES TEXTES----------------------------------------------------------------------------------
        
        
        JPanel panneauTexte = new JPanel();
        panneauTexte.setBorder(BorderFactory.createTitledBorder("Outil Texte"));
        panneauTexte.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT + 15, 115));
        
        //BOUTON TEXTE
        JToggleButton boutonTexte = new JToggleButton(new ActionChoisirForme(panneauDessin, this, "Texte"));
        boutonTexte.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT, 25));
        boutonTexte.setAlignmentX(Component.CENTER_ALIGNMENT);
        boutonsFormes.add(boutonTexte);
        panneauTexte.add(boutonTexte);
        
        //Création d'un label PARAMETRE TAILLE TEXTE
        JLabel texteTailleTexte = new JLabel(TAILLE_SPINNER_NOM);
        texteTailleTexte.setFont(new Font("Verdana",Font.BOLD,TAILLE_TEXTE_2_PAR_DEFAUT));
        texteTailleTexte.setAlignmentX(Component.LEFT_ALIGNMENT);
        panneauTexte.add(texteTailleTexte);
        
        //LISTE TAILLE TEXTE
        int valueTailleTexte = 30;
        int minTailleTexte = 10;
        int maxTailleTexte = 120;
        int stepTailleTexte = 10;
        spinnerTailleTexte = new SpinnerNumberModel(valueTailleTexte, minTailleTexte, maxTailleTexte, stepTailleTexte);
        JSpinner jspinnerTailleTexte = new JSpinner(spinnerTailleTexte);
        jspinnerTailleTexte.setAlignmentX(Component.RIGHT_ALIGNMENT);
        jspinnerTailleTexte.setName(TAILLE_SPINNER_NOM);
        panneauTexte.add(jspinnerTailleTexte);
        
        //Création d'un label PARAMETRE FONT TEXTE
        JLabel texteFontTexte = new JLabel(FONT_COMBOBOX_NOM);
        texteFontTexte.setFont(new Font("Verdana",Font.BOLD,TAILLE_TEXTE_2_PAR_DEFAUT));
        texteFontTexte.setAlignmentX(Component.LEFT_ALIGNMENT);
        panneauTexte.add(texteFontTexte, BorderLayout.SOUTH);
        
        //LISTE FONT TEXTE
        String[] listeFonts = {"Arial", "Century", "Comic Sans MS", "Helvetica", "SansSerif", "Serif", "Times New Roman", "Verdana"};
        jcombobox = new JComboBox<String>(listeFonts);
        jcombobox.setAlignmentX(Component.RIGHT_ALIGNMENT);
        jcombobox.setPreferredSize(new Dimension(120, 25));
        jcombobox.setName(FONT_COMBOBOX_NOM);
        panneauTexte.add(jcombobox);
        
        this.add(panneauTexte);
        
        
//-----------------------------------GESTION DES ETOILES----------------------------------------------------------------------------------
        
        JPanel panneauEtoile = new JPanel();
        panneauEtoile.setBorder(BorderFactory.createTitledBorder("Outil Etoile"));
        panneauEtoile.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT + 15, 115));
        
        
        //BOUTON ETOILE
        JToggleButton boutonEtoile = new JToggleButton(new ActionChoisirForme(panneauDessin, this, "Etoile"));
        boutonEtoile.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT, 25));
        boutonEtoile.setAlignmentX(Component.CENTER_ALIGNMENT);
        boutonsFormes.add(boutonEtoile);
        panneauEtoile.add(boutonEtoile);
        
        //Création d'un label PARAMETRE NOMBRE DE BRANCHE ETOILE
        JLabel texteParametreNombre = new JLabel(BRANCHE_SPINNER_NOM);
        texteParametreNombre.setFont(new Font("Verdana",Font.BOLD,TAILLE_TEXTE_2_PAR_DEFAUT));
        texteParametreNombre.setAlignmentX(Component.LEFT_ALIGNMENT);
        panneauEtoile.add(texteParametreNombre);
        
        //LISTE NOMBRE BRANCHE ETOILE
        int valueNombreBranche = Etoile.NOMBRE_BRANCHES_PAR_DEFAUT;
        int minNombreBranche = 3;
        int maxNombreBranche = 15;
        int stepNombreBranche = 1;
        spinnerNombreBranche = new SpinnerNumberModel(valueNombreBranche, minNombreBranche, maxNombreBranche, stepNombreBranche);
        JSpinner jspinnerNombreBranche = new JSpinner(spinnerNombreBranche);
        jspinnerNombreBranche.setAlignmentX(Component.RIGHT_ALIGNMENT);
        jspinnerNombreBranche.setName(BRANCHE_SPINNER_NOM);
        panneauEtoile.add(jspinnerNombreBranche);
        
        //Création d'un label PARAMETRE LONGUEUR BRANCHE ETOILE
        JLabel texteParametreLongueur = new JLabel(LONGUEUR_SPINNER_NOM);
        texteParametreLongueur.setFont(new Font("Verdana",Font.BOLD,TAILLE_TEXTE_2_PAR_DEFAUT));
        texteParametreLongueur.setAlignmentX(Component.LEFT_ALIGNMENT);
        panneauEtoile.add(texteParametreLongueur);
        
        //LISTE LONGUEUR BRANCHE ETOILE
        double valueLongueurBranche = Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT;
        double minLongueurBranche = 0;
        double maxLongueurBranche = 1;
        double stepLongueurBranche = 0.01;
        spinnerLongueurBranche = new SpinnerNumberModel(valueLongueurBranche, minLongueurBranche, maxLongueurBranche, stepLongueurBranche);
        JSpinner jspinnerLongueurBranche = new JSpinner(spinnerLongueurBranche);
        jspinnerLongueurBranche.setAlignmentX(Component.RIGHT_ALIGNMENT);
        jspinnerLongueurBranche.setPreferredSize(new Dimension(40, 25));
        jspinnerLongueurBranche.setName(LONGUEUR_SPINNER_NOM);
        panneauEtoile.add(jspinnerLongueurBranche);
        
        this.add(panneauEtoile);
        
        
//-----------------------------------GESTION DES COULEUR----------------------------------------------------------------------------------
        
        JPanel panneauCouleur = new JPanel();
        panneauCouleur.setBorder(BorderFactory.createTitledBorder("Couleur"));
        panneauCouleur.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT + 15, 115));
        
		//BOUTON CHOISIR COULEUR
		JButton boutonChoisirCouleur = new JButton(new ActionChoisirCouleur(panneauDessin));
		boutonChoisirCouleur.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT, 25));
		boutonChoisirCouleur.setAlignmentX(Component.CENTER_ALIGNMENT);
		panneauCouleur.add(boutonChoisirCouleur);
        
        //Création d'un Panel pour voir la couleur courante
  		panelCouleurCourante = new JPanel(true);
  		panelCouleurCourante.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT, 25));
  		panelCouleurCourante.setAlignmentX(Component.CENTER_ALIGNMENT);
  		panelCouleurCourante.setBackground(panneauDessin.getCouleurCourante());
  		panneauCouleur.add(panelCouleurCourante);
        
		//BOUTON CHOISIR REMPLISSAGE
        JCheckBox boutonRemplissage = new JCheckBox(new ActionChoisirRemplissage(panneauDessin));
		boutonRemplissage.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT, 25));
		boutonRemplissage.setAlignmentX(Component.CENTER_ALIGNMENT);
		panneauCouleur.add(boutonRemplissage);
		
		this.add(panneauCouleur);
        
        
//-----------------------------------GESTION SELECTION----------------------------------------------------------------------------------
        
        
		JPanel panneauSelection = new JPanel();
		panneauSelection.setBorder(BorderFactory.createTitledBorder("Outil de Selection"));
		panneauSelection.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT + 15, 60));
        
        //BOUTON SELECTIONNER
        JToggleButton boutonSelectionner = new JToggleButton(new ActionSelectionner(panneauDessin));
        boutonSelectionner.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT, 25));
        boutonSelectionner.setAlignmentX(Component.CENTER_ALIGNMENT);
        boutonsFormes.add(boutonSelectionner);
        panneauSelection.add(boutonSelectionner);
        
        this.add(panneauSelection);
        
        
//-----------------------------------GESTION EFFACEMENT----------------------------------------------------------------------------------
   
        
        JPanel panneauEffacer = new JPanel();
        panneauEffacer.setBorder(BorderFactory.createTitledBorder("Outil d'Effacement"));
        panneauEffacer.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT + 15, 120));
        
        //BOUTON UNDO
  		JButton boutonUndo = new JButton(new ActionUndo(panneauDessin));
  		boutonUndo.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT, 25));
  		boutonUndo.setAlignmentX(Component.CENTER_ALIGNMENT);
  		panneauEffacer.add(boutonUndo);
  		
  		//BOUTON REDO
  		JButton boutonRedo = new JButton(new ActionRedo(panneauDessin));
  		boutonRedo.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT, 25));
  		boutonRedo.setAlignmentX(Component.CENTER_ALIGNMENT);
  		panneauEffacer.add(boutonRedo);
        
		//BOUTON EFFACER
		JButton boutonEffacerTout = new JButton(new ActionEffacer(panneauDessin));
		boutonEffacerTout.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT, 25));
		boutonEffacerTout.setAlignmentX(Component.CENTER_ALIGNMENT);
		panneauEffacer.add(boutonEffacerTout);
		
		this.add(panneauEffacer);
        
        
//-----------------------------------GESTION EXPORTATION----------------------------------------------------------------------------------
		
		JPanel panneauExporter = new JPanel();
		panneauExporter.setBorder(BorderFactory.createTitledBorder("Outil Exportation"));
		panneauExporter.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT + 15, 60));
        
        //BOUTON EXPORTER
  		JButton boutonExporter = new JButton(new ActionExporter(panneauDessin));
  		boutonExporter.setPreferredSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT, 25));
  		boutonExporter.setAlignmentX(Component.CENTER_ALIGNMENT);
  		panneauExporter.add(boutonExporter);
  		
  		this.add(panneauExporter);
	}
	
	public int getNbBranches() {
		return (int) spinnerNombreBranche.getValue();
	}
	
	public double getLongueurBranche() {
		return (double) spinnerLongueurBranche.getValue();
	}
	
	public int getTailleTexte() {
		return (int) spinnerTailleTexte.getValue();
	}
	
	public String getFontTexte() {
		return (String) jcombobox.getSelectedItem();
	}
	
	public static void changementCouleurPanel(Color nouvelleCouleur) {
		panelCouleurCourante.setBackground(nouvelleCouleur);
		panelCouleurCourante.repaint();
	}
}
