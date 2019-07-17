package fr.eseo.i1.gpi.artiste.modele.formes;


import java.text.DecimalFormat;
import fr.eseo.i1.gpi.artiste.modele.Coordonnees;

public class Ligne extends Forme {
	
	private static final String type = "ligne";
	
	/**
	 * Variable pour admettre ou non qu'une coordonnee fait partie d'une ligne
	 * plus EPSILON bas plus la coordonnee doit etre proche de la ligne
	 * pour en faire parti
	 */
	public static final double EPSILON = 1;
	
	/**
	 * Constructeur de la classe Ligne vide
	 * POSITION, LARGEUR et HAUTEUR par defaut
	 */
	public Ligne() {
		super(type);
	}
	
	/**
	 * Constructeur de la classe Ligne
	 * POSITION par defaut
	 * 
	 * @param largeur largeur du rectangle encadrant la ligne
	 * @param hauteur hateur du rectangle encadrant la ligne
	 */
	public Ligne(double largeur, double hauteur) {
		super(largeur, hauteur, type);
	}
	
	/**
	 * Constructeur de la classe Ligne
	 * LARGEUR et HAUTEUR par defaut
	 * 
	 * @param position coordonnees du premier point de la ligne
	 */
	public Ligne(Coordonnees position) {
		super(position, type);
	}
	
	/**
	 * Conctructeur de la classe Ligne
	 * 
	 * @param position coordonnees du premier point de la ligne
	 * @param largeur largeur du rectangle encadrant la ligne
	 * @param hauteur hauteur du rectangle encadrant la ligne
	 */
	public Ligne(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur, type);
	}
	
	/**
	 * Accesseur du point C1 de la ligne
	 * 
	 * @return la coordonnees du point C1 de la ligne
	 */
	public Coordonnees getC1() {
		return super.getPosition();
	}
	
	/**
	 * Accesseur du point C2 de la ligne
	 * 
	 * @return la coordonnees du point C2 de la ligne
	 */
	public Coordonnees getC2() {
		return new Coordonnees(	super.getPosition().getAbscisse() + super.getLargeur(), 
								super.getPosition().getOrdonnee() + super.getHauteur());
	}
	
	/**
	 * Mutateur du point C1 de la ligne
	 * 
	 * @param coordonnees nouvelle coordonnees du point C1
	 */
	public void setC1(Coordonnees coordonnees) {
		super.setLargeur(super.getLargeur() - (coordonnees.getAbscisse() - super.getPosition().getAbscisse()));
		super.setHauteur(super.getHauteur() - (coordonnees.getOrdonnee() - super.getPosition().getOrdonnee()));
		super.setPosition(coordonnees);
	}
	
	/**
	 * Mutateur du point C2 de la ligne
	 * 
	 * @param coordonnees nouvelle coordonnees du point C2
	 */
	public void setC2(Coordonnees coordonnees) {
		super.setLargeur(coordonnees.getAbscisse() - super.getPosition().getAbscisse());
		super.setHauteur(coordonnees.getOrdonnee() - super.getPosition().getOrdonnee());
	}

	@Override
	public double aire() {
		return 0;
	}

	@Override
	public double perimetre() {
		return this.getC1().distanceVers(this.getC2());
	}
	
	/**
	 * Méthode toString renvoyant une chaine de caratére concernant la ligne
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#######0.0#");
		double angle = Math.toDegrees(this.getC1().angleVers(getC2()));		
		return "[Ligne] c1 : " + this.getC1() + " c2 : " + this.getC2() + " longueur : "
				+ df.format(this.perimetre()) + " angle : " + df.format((angle >= 0 ? angle : 360+angle)) + "° "
				+ " couleur : ";
	}

	@Override
	public boolean contient(Coordonnees coordonnees) {
		return 	((this.getC1().distanceVers(coordonnees) + this.getC2().distanceVers(coordonnees))-
				this.getC1().distanceVers(this.getC2())) <= EPSILON;
	}
	
	@Override
	public boolean isRempli() {
		return false;
	}

	@Override
	public void setRempli(boolean remplissage) {
		//null
	}
	
	public double getLongueur() {
		return this.getC1().distanceVers(getC2());
	}
	
	public void setLongueur(double longueur) {
		//TODO setLongueur Ligne
	}
}
