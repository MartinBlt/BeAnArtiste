package fr.eseo.i1.gpi.artiste.modele.formes;

import java.text.DecimalFormat;

import fr.eseo.i1.gpi.artiste.modele.Coordonnees;

public class Carre extends Rectangle {
	
	private static final String type = "hauteur=largeur";
	
	/**
	 * Constructeur de la classe Carre
	 * POSITION, TAILLE par défaut
	 */
	public Carre() {
		super();
		super.setType(type);
	}
	
	/**
	 * Constructeur de la classe Carre
	 * POSITION par défaut
	 * 
	 * @param taille taille du Carre
	 */
	public Carre(double taille) {
		super(taille, taille);
		super.setType(type);
	}
	
	/**
	 * Constructeur de la classe Carre
	 * TAILLE par défaut
	 * 
	 * @param position coordonnnes de la position en haut à gauche de Carre
	 */
	public Carre(Coordonnees position) {
		super(position);
		super.setType(type);
	}
	
	/**
	 * Constructeur complet de la classe Carre
	 * 
	 * @param position coordonnees de la position en haut à gauche de Carre
	 * @param taille taille du cercle
	 */
	public Carre(Coordonnees position, double taille) {
		super(position, taille, taille);
		super.setType(type);
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#######0.0#");
		return 	(this.isRempli() ? "[Carré-Rempli]" : "[Carré]") 
				+ " : pos " + super.getPosition() + " dim " + df.format(super.getLargeur()) 
				+ " x " + df.format(super.getHauteur())
				+ " périmètre : " + df.format(this.perimetre()) + " aire : " + df.format(this.aire())
				+ " couleur : ";
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
}
