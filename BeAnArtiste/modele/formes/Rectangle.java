package fr.eseo.i1.gpi.artiste.modele.formes;

import java.text.DecimalFormat;

import fr.eseo.i1.gpi.artiste.modele.Coordonnees;
import fr.eseo.i1.gpi.artiste.modele.Remplissable;

public class Rectangle extends Forme implements Remplissable {
	
	private static final String type = "autre";
	boolean modeRemplissage = false;
	
	/**
	 * Constructeur de la classe Rectangle
	 * POSITION, LARGEUR et HAUTEUR par défaut
	 */
	public Rectangle() {
		super(type);
		this.setRempli(false);
	}
	
	/**
	 * Constructeur de la classe Rectangle
	 * POSITION par dfaut
	 * 
	 * @param largeur largeur de Rectangle
	 * @param hauteur hauteur de Rectangle
	 */
	public Rectangle(double largeur, double hauteur) {
		super(new Coordonnees(), largeur, hauteur, type);
	}
	
	/**
	 * Constructeur de la classe Rectangle
	 * LARGEUR et HAUTEUR par défaut
	 * 
	 * @param position coordonnnes de la position en haut à gauche de Rectangle
	 */
	public Rectangle(Coordonnees position) {
		super(position, type);
		this.setRempli(false);
	}
	
	/**
	 * Constructeur complet de la classe Rectangle
	 * 
	 * @param position coordonnees de la position en haut à gauche de Rectangle
	 * @param largeur largeur de Rectangle
	 * @param hauteur hauteur de Rectangle
	 */
	public Rectangle(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur, type);
	}
	
	@Override
	public void setLargeur(double largeur) {
		if(largeur < 0) {
			throw new IllegalArgumentException("Une des valeurs est négatif");
		} else {
			super.setLargeur(largeur);
		}
	}
	
	@Override
	public void setHauteur(double hauteur) {
		if(hauteur < 0) {
			throw new IllegalArgumentException("Une des valeurs est négatif");
		} else {
			super.setHauteur(hauteur);
		}
	}

	@Override
	public double aire() {
		return super.getHauteur()*super.getHauteur();
	}

	@Override
	public double perimetre() {
		return (super.getHauteur()*2)+(super.getHauteur()*2);
	}

	@Override
	public boolean contient(Coordonnees coordonnees) {
		if(	coordonnees.getAbscisse() >= this.getPosition().getAbscisse() &&
			coordonnees.getAbscisse() <= this.getPosition().getAbscisse() + this.getLargeur() &&
			coordonnees.getOrdonnee() >= this.getPosition().getOrdonnee() &&
			coordonnees.getOrdonnee() <= this.getPosition().getOrdonnee() + this.getHauteur()) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#######0.0#");
		return 	(this.isRempli() ? "[Rectangle-Rempli]" : "[Rectangle]") 
				+ " : pos " + super.getPosition() + " dim " + df.format(super.getLargeur()) 
				+ " x " + df.format(super.getHauteur())
				+ " périmètre : " + df.format(this.perimetre()) + " aire : " + df.format(this.aire())
				+ " couleur : ";
	}

	@Override
	public boolean isRempli() {
		return this.modeRemplissage;
	}
	
	@Override
	public void setRempli(boolean valeur) {
		this.modeRemplissage = valeur;
	}
}
