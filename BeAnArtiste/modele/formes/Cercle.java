package fr.eseo.i1.gpi.artiste.modele.formes;

import java.text.DecimalFormat;

import fr.eseo.i1.gpi.artiste.modele.Coordonnees;

/**
 * Classe Cercle
 * Elle permet la création d'un cercle, de connaitre son aire et son périmètre
 * 
 * @author Martin Blot
 */
public class Cercle extends Ellipse {
	
	private static final String type = "hauteur=largeur";
	
	/**
	 * Constructeur de la classe Cercle
	 * POSITION, TAILLE par d�faut
	 */
	public Cercle() {
		super();
		super.setType(type);
	}
	
	/**
	 * Constructeur de la classe Cercle
	 * POSITION par défaut
	 * 
	 * @param taille taille du cercle
	 */
	public Cercle(double taille) {
		super(taille, taille);
		super.setType(type);
	}
	
	/**
	 * Constructeur de la classe Cercle
	 * TAILLE par défaut
	 * 
	 * @param position coordonnnes de la position en haut à gauche de l'Cercle
	 */
	public Cercle(Coordonnees position) {
		super(position);
		super.setType(type);
	}
	
	/**
	 * Constructeur complet de la classe Cercle
	 * 
	 * @param position coordonnees de la position en haut à gauche de l'Cercle
	 * @param taille taille du cercle
	 */
	public Cercle(Coordonnees position, double taille) {
		super(position, taille, taille);
		super.setType(type);
	}
	
	@Override
	public void setLargeur(double largeur) {
		super.setLargeur(largeur);
		super.setHauteur(largeur);
	}
	
	@Override
	public void setHauteur(double hauteur) {
		super.setLargeur(hauteur);
		super.setHauteur(hauteur);
	}
	
	@Override
	public double perimetre() {
		return 2 * Math.PI * (super.getHauteur()/2);
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#######0.0#");
		return 	(this.isRempli() ? "[Cerlce-Rempli]" : "[Cercle]")
				+ " : pos " + super.getPosition() + " dim " + df.format(super.getLargeur()) + " x " + df.format(super.getHauteur())
				+ " périmètre : " + df.format(this.perimetre()) + " aire : " + df.format(this.aire())
				+ " couleur : ";
	}
}
