	package fr.eseo.i1.gpi.artiste.modele.formes;

import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.UIManager;
import fr.eseo.i1.gpi.artiste.modele.Coloriable;
import fr.eseo.i1.gpi.artiste.modele.Coordonnees;

/**
 * Classe Forme
 * Elle permet de créer des formes, de connaitre sa position, sa largeur et sa hauteur
 * 
 * @author Martin Blot
 */
public abstract class Forme implements Coloriable {
	
	/**
	 * Valeur de la largeur et de la hauteur par defaut d'une forme
	 */
	public static final double LARGEUR_PAR_DEFAUT = 100;
	public static final double HAUTEUR_PAR_DEFAUT = 100;
	public static final Color COULEUR_PAR_DEFAUT = UIManager.getColor("Panel.foreground");
	
	private double largeur;
	private double hauteur;
	private Coordonnees position;
	private Color couleur;
	private String type;
	
	/**
	 * Constructeur de la classe abstraite Forme basique
	 * POSITION, LARGEUR et HAUTEUR par defaut
	 */
	public Forme(String type) {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT, type);
	}
	
	/**
	 * Constructeur classe abstraite Forme sans la position
	 * 
	 * @param largeur largeur de la forme
	 * @param hauteur hauteur de la forme
	 */
	public Forme(double largeur, double hauteur, String type) {
		this(new Coordonnees(), largeur, hauteur, type);
	}
	
	/**
	 * Constructeur de la classe abstraite Forme sans hauteur et largeur
	 * 
	 * @param position coordonnees de la position de la forme
	 */
	public Forme(Coordonnees position, String type) {
		this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT, type);
	}
	
	/**
	 * Constructeur complet de la classe abstraite Forme
	 *
	 * @param position Coordonnees de la forme
	 * @param largeur largeur de la forme
	 * @param hauteur hauteur de la forme
	 */
	public Forme(Coordonnees position, double largeur, double hauteur, String type) {
		this.position = position;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.couleur = COULEUR_PAR_DEFAUT;
		this.type = type;
	}
	
	/**
	 * Accesseur de la hauteur de la forme
	 * 
	 * @return hauteur de la forme
	 */
	public double getHauteur() {
		return hauteur;
	}
	
	/**
	 * Accesseur de la largeur de la forme
	 * 
	 * @return la largeur de la forme
	 */
	public double getLargeur() {
		return largeur;
	}
	
	/**
	 * Accesseur de la position de la forme
	 * 
	 * @return la position de la forme
	 */
	public Coordonnees getPosition() {
		return position;
	}
	
	/**
	 * Return le type de la forme (ligne, hauteur=largeur, etoile, texte, autre)
	 * @return
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Accesseur de l'abscisse de la coordonnee en haut à gauche de la forme
	 * 
	 * @return abscisse de la coordonnee en haut à gauche de la forme
	 */
	public double getCadreMinX() {
		return Math.min(this.getPosition().getAbscisse(), this.getPosition().getAbscisse() + this.getLargeur());
	}
	
	/**
	 * Accesseur de l'ordonne de la coordonnee en haut à gauche de la forme
	 * 
	 * @return ordonne de la coordonnee en haut à gauche de la forme
	 */
	public double getCadreMinY() {
		return Math.min(this.getPosition().getOrdonnee(), this.getPosition().getOrdonnee() + this.getHauteur());
	}
	
	/**
	 * Accesseur de l'abscisse de la coordonnee en bas à droite de la forme
	 * 
	 * @return abscisse de la coordonnee en bas à droite de la forme
	 */
	public double getCadreMaxX() {
		return Math.max(this.getPosition().getAbscisse(), this.getPosition().getAbscisse() + this.getLargeur());
	}
	
	/**
	 * Accesseur de l'ordonne de la coordonnee en bas à droite de la forme
	 *
	 * @return ordonne de la coordonnee en bas à droite de la forme
	 */
	public double getCadreMaxY() {
		return Math.max(this.getPosition().getOrdonnee(), this.getPosition().getOrdonnee() + this.getHauteur());
	}
	
	/**
	 * Mutateur de la hauteur de la forme
	 * 
	 * @param hauteur nouvelle hauteur de la forme
	 */
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	
	/**
	 * Mutation de la largeur de la forme
	 * 
	 * @param largeur nouvelle largeur de la forme
	 */
	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}
	
	/**
	 * Mutateur de la position de la forme
	 * 
	 * @param position nouvelle position de la forme
	 */
	public void setPosition(Coordonnees position) {
		this.position = position;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Deplacer la forme d'une certaine valeur en X et d'une certaine valeur en Y
	 * 
	 * @param deltaX Valeur du deplacement sur l'axe des abscisses
	 * @param deltaY Valeur du deplacement sur l'axe des ordonnes
	 */
	public void deplacerDe(double deltaX, double deltaY){
		this.setPosition(new Coordonnees(this.getPosition().getAbscisse() + deltaX, this.getPosition().getOrdonnee() + deltaY));
	}
	
	/**
	 * Deplacer la forme à une nouvelle coordonnee
	 * 
	 * @param  la nouvelle position de la coordonnee en x
	 * @param y la nouvelle position de la coordonnee en y
	 */
	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee){
		this.setPosition(new Coordonnees(nouvelleAbscisse, nouvelleOrdonnee));
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("#######0.0#");
		return "[Forme] largeur : " + df.format(this.getLargeur()) + " hauteur : "
				+ df.format(this.getHauteur());
	}
	
	/**
	 * IMPLEMENTATION
	 */
	public Color getCouleur() {
		return this.couleur;
	}

	/**
	 * IMPLEMENTATION
	 */
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	public abstract boolean isRempli();
	
	/**
	 * Méthode qui renvoie l'aire de la forme
	 * 
	 * @return aire de la forme
	 */
	public abstract double aire();
	
	/**
	 * Méthode qui renvoie le périmètre de la forme
	 * 
	 * @return périmètre de la forme
	 */
	public abstract double perimetre();
	
	/**
	 * Savoir si une forme contient la coordonnees mit en paramétre
	 * 
	 * @return true si la coordonnes est dans la forme, false sinon
	 */
	public abstract boolean contient(Coordonnees coordonnees);

	public abstract void setRempli(boolean remplissage);
}
