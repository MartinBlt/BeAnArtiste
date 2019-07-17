package fr.eseo.i1.gpi.artiste.vue.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import fr.eseo.i1.gpi.artiste.controleur.outils.Outil;
import fr.eseo.i1.gpi.artiste.controleur.outils.OutilCarre;
import fr.eseo.i1.gpi.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.i1.gpi.artiste.modele.formes.Forme;
import fr.eseo.i1.gpi.artiste.vue.formes.VueForme;

/**
 * Classe de la gestion du JPanel Dessin qui permet l'affichage des formes
 * et de la création de forme
 * 
 * @author Martin Blot
 * @version 1.0
 */
public class PanneauDessin extends JPanel {
	
	//Final Taille et couleur du panel Dessin
	public static final int LARGEUR_PAR_DEFAUT = 1200;
	public static final int HAUTEUR_PAR_DEFAUT = 800;
	public static final Color COULEUR_FOND_PAR_DEFAUT = Color.WHITE;
	
	//Variable de Classe
	private final List<VueForme> vueFormes = new ArrayList<VueForme>();
	private final List<VueForme> vueFormesSupprimee = new ArrayList<VueForme>();
	private Outil outilCourant = new OutilCarre();
	private Color couleurCourante = Forme.COULEUR_PAR_DEFAUT;
	private boolean modeRemplissage;
	private int largeur, hauteur;
	private PanneauInformation panneauInformation;

	/**
	 * Constructeur vide
	 */
	public PanneauDessin() {
		this(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT, COULEUR_FOND_PAR_DEFAUT);
	}
	
	/**
	 * Constructeur JPanel du panneau Dessin
	 * 
	 * @param largeur largeur du panneau
	 * @param hauteur hauteur du panneau
	 * @param fond couleur du fond
	 */
	public PanneauDessin(int largeur, int hauteur, Color fond) {
		panneauInformation = new PanneauInformation();
		this.add(panneauInformation, BorderLayout.NORTH);
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.setPreferredSize(new Dimension(largeur, hauteur));
		this.setBackground(fond);
		this.couleurCourante = Forme.COULEUR_PAR_DEFAUT;
	}
	
	/**
	 * Accesseur Liste qui contient l'ensemble des formes qui seront affiché sur le JPanel
	 * @return
	 */
	public List<VueForme> getVueFormes() {
		return vueFormes;
	}
	
	/**
	 * Ajout d'une forme dans la liste
	 * @param vueForme
	 */
	public void ajouterVueForme(VueForme vueForme) {
		vueFormes.add(vueForme);
	}
	
	/**
	 * Supprimer une forme dans le dessin
	 * 
	 * @param formeSelectionnee forme a suprrimer
	 */
	public void supprimerVueForme(Forme formeSelectionnee) {
		int nbFormes = this.getVueFormes().size();
		int position = -1;
		for(int i = 0 ; i < nbFormes ; i++) {
			if(this.getVueFormes().get(i).getForme().equals(formeSelectionnee)) {
				position = i;
			}
		}
		if(position != -1 )this.getVueFormes().remove(position);
	}
	
	/**
	 * Gestion d'affichage de chaque vueForme sur le JPanel
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//On convertit le param�tre g de Graphics � Graphics2D
		Graphics2D g2D = (Graphics2D) g.create();
		
		//On ajoute les formes dans le param�tre g
		for(int i = 0 ; i < vueFormes.size() ; i++) {
			this.vueFormes.get(i).affiche(g2D);
		}
		
		//On libère la mémoire
		g2D.dispose();
	}
	
	/**
	 * Association d'un outil au JPanel, ce qui aura comme
	 * changement la création d'une forme différente
	 * @param outil outils de création de vue
	 */
	public void associerOutil(Outil outil) {
		//Dissociation de l'outil précedent
		this.dissocierOutil();
		
		//Association du nouvelle outil au panneau, et du panneau dans l'outil
		this.setOutilCourant(outil);
		outil.setPanneauDessin(this);
		outil.setPanneauInformation(this.getPanneauInformation());
		
		//Abonnement de l'outil aux event mouse et keyboard
		this.addMouseListener(outil);
		this.addMouseMotionListener(outil);
	}
	
	/**
	 * Dissocier l'outil en cours d'utilisation
	 */
	private void dissocierOutil() {
		if(this.getOutilCourant().getNom().equals("Selectionnee")) {
			((OutilSelectionner) this.getOutilCourant()).reset();
		}
		removeMouseListener(this.getOutilCourant());
		removeMouseMotionListener(this.getOutilCourant());
	}
	
	/**
	 * Accesseur de l'outil courant
	 * 
	 * @return
	 */
	public Outil getOutilCourant() {
		return outilCourant;
	}
	
	/**
	 * Mutateur de l'outil courant
	 * @param outilCourant
	 */
	private void setOutilCourant(Outil outilCourant) {
		this.outilCourant = outilCourant;
	}
	
	/**
	 * Accesseur de la couleur selectionnée dans le panneauBarreOutils
	 * @return
	 */
	public Color getCouleurCourante() {
		return this.couleurCourante;
	}
	
	/**
	 * Mutateur de la couleur demandé pour l'affichage d'une vueForme
	 * 
	 * @param couleurCourante
	 */
	public void setCouleurCourante(Color couleurCourante) {
		PanneauBarreOutils.changementCouleurPanel(couleurCourante);
		this.couleurCourante = couleurCourante;
	}
	
	/**
	 * Accesseur sur le mode de remplissage demandé par le panneauOutils
	 * 
	 * @return
	 */
	public boolean getModeRemplissage() {
		return modeRemplissage;
	}
	
	/**
	 * Mutateur du monde de remplissage
	 * @param modeRemplissage
	 */
	public void setModeRemplissage(boolean modeRemplissage) {
		this.modeRemplissage = modeRemplissage;
	}
	
	/**
	 * Accesseur de la liste de forme supprimé, permet la gestion des UNDO/REDO
	 * @return
	 */
	public List<VueForme> getVueFormesSupprimee() {
		return vueFormesSupprimee;
	}
	
	/**
	 * Accesseur de la hauteur du JPanel
	 * @return
	 */
	public int getHauteur() {
		return hauteur;
	}
	
	/**
	 * Accesseur de la largeur du JPanel
	 * @return
	 */
	public int getLargeur() {
		return largeur;
	}
	
	/**
	 * Accesseur du panneauInformation utilisé pour afficher les infos d'une
	 * forme lors de sa selection
	 * @return
	 */
	public PanneauInformation getPanneauInformation() {
		return panneauInformation;
	}
}
