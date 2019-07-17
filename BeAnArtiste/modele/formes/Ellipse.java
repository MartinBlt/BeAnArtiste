
package fr.eseo.i1.gpi.artiste.modele.formes;

import java.text.DecimalFormat;
import fr.eseo.i1.gpi.artiste.modele.Coordonnees;
import fr.eseo.i1.gpi.artiste.modele.Remplissable;

/**
 * Classe Ellipse
 * Elle permet la création d'une Ellipse, de connaitre son aire et son périmètre
 * 
 * @author Martin Blot
 */
public class Ellipse extends Forme implements Remplissable {
	
	private static final String type = "autre";
	boolean modeRemplissage = false;

	/**
	 * Constructeur de la classe Ellipse
	 * POSITION, LARGEUR et HAUTEUR par défaut
	 */
	public Ellipse() {
		super(type);
		this.setRempli(false);
	}
	
	/**
	 * Constructeur de la classe Ellipse
	 * POSITION par dfaut
	 * 
	 * @param largeur largeur de l'ellipse
	 * @param hauteur hauteur de l'ellipse
	 */
	public Ellipse(double largeur, double hauteur) {
		super(new Coordonnees(), largeur, hauteur, type);
	}
	
	/**
	 * Constructeur de la classe Ellipse
	 * LARGEUR et HAUTEUR par défaut
	 * 
	 * @param position coordonnnes de la position en haut à gauche de l'ellipse
	 */
	public Ellipse(Coordonnees position) {
		super(position, type);
		this.setRempli(false);
	}
	
	/**
	 * Constructeur complet de la classe Ellipse
	 * 
	 * @param position coordonnees de la position en haut à gauche de l'ellipse
	 * @param largeur largeur de l'ellispe
	 * @param hauteur hauteur de l'ellipse
	 */
	public Ellipse(Coordonnees position, double largeur, double hauteur) {
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
		return Math.PI * (super.getHauteur()/2) * (super.getLargeur()/2);
	}

	@Override
	public double perimetre() {
		double h = Math.pow(((super.getHauteur()/2) - (super.getLargeur()/2)) / ((super.getHauteur()/2) + (super.getLargeur()/2)), 2);
		return Math.PI * ((super.getHauteur()/2) + (super.getLargeur()/2)) * (1+((3*h)/(10+Math.sqrt(4-3*h))));
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#######0.0#");
		return 	(this.isRempli() ? "[Ellipse-Rempli]" : "[Ellipse]") 
				+ " : pos " + super.getPosition() + " dim " + df.format(super.getLargeur()) 
				+ " x " + df.format(super.getHauteur())
				+ " périmètre : " + df.format(this.perimetre()) + " aire : " + df.format(this.aire())
				+ " couleur : ";
	}

	@Override
	public boolean contient(Coordonnees coordonnees) {
		/** (x.coordonnes - x.centreEllipse)/demiLargeur)² + ((y.coordonnes - y.centreEllipse)/demiHauteur)² < 1
		 * 
		 * Si le resultat est inférieur à 1 c'est en dehors de l'ellipse 
		 * égale à 1 c'est sur le contour
		 */
		double x = (coordonnees.getAbscisse() - (super.getPosition().getAbscisse() + (super.getLargeur()/2)))/(super.getLargeur()/2);
		double y = (coordonnees.getOrdonnee() - (super.getPosition().getOrdonnee() + (super.getHauteur()/2)))/(super.getHauteur()/2);
		
		return (x*x+y*y < 1);
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
