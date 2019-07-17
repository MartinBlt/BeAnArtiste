package fr.eseo.i1.gpi.artiste.modele;

import java.text.DecimalFormat;

/**
 * Classer Coordonnees
 * Elle permet de connaitre abscisse et ordonnes d'une coordonnees, de connaitre la distance
 * entre deux coordonnes et de connaitre l'angle entre deux coordonnes et l'axe des abscisses
 * 
 * @author Martin Blot
 */
public class Coordonnees{
	
	public static final double ABSCISSE_PAR_DEFAUT = 0;
	public static final double ORDONNEE_PAR_DEFAUT = 0;
	double abscisse,ordonnee;
	
	//CONSTRUCTEURS
	
	/**
	 * Constructeur Vide
	 */
	public Coordonnees(){
		this.abscisse = Coordonnees.ABSCISSE_PAR_DEFAUT;
		this.ordonnee = Coordonnees.ORDONNEE_PAR_DEFAUT;
	}
	
	/**
	 * Constructeur de Coordonnees
	 * 
	 * @param x coordonnee x
	 * @param y coordonnee y
	 */
	public Coordonnees(double x,double y){
		this.abscisse= x;
		this.ordonnee= y;
	}

	//METHODES
	
	/**
	 * Accesseur de l'abscisse de la coordonnee (x)
	 * 
	 * @return x
	 */
	public double getAbscisse(){
		return this.abscisse;
	}
	
	/**
	 * Mutateur de l'abscisse de la coordonnee (x)
	 * 
	 * @param x la nouvelle position de la coordonnee en x
	 */
	public void setAbscisse(double x){
		this.abscisse = x;
	}
	
	/**
	 * Accesseur de l'ordonnee de la coordonnee (y)
	 * 
	 * @return y
	 */
	public double getOrdonnee(){
		return this.ordonnee;
	}
	
	/**
	 * Mutateur de l'ordonnee de la coordonnee (y)
	 * 
	 * @param y la nouvelle position de la coordonnee en y
	 */
	public void setOrdonnee(double y){
		this.ordonnee = y;
	}
	
	/**
	 * Deplacer la coordonnee au nouveau point x.y
	 * 
	 * @param x la nouvelle position de la coordonnee en x
	 * @param y la nouvelle position de la coordonnee en y
	 */
	public void deplacerVers(double x, double y){
		this.abscisse = x;
		this.ordonnee = y;
	}
	
	/**
	 * Deplacer la coordonnee gr�ce � des detlas
	 * 
	 * @param deltaX deplacer la coordonnee de deltaX sur l'axe x (abscisse)
	 * @param deltaY deplacer la coordonnee de deltaY sur l'axe y (ordonnee)
	 */
	public void deplacerDe(double deltaX, double deltaY){
		this.abscisse = abscisse + deltaX;
		this.ordonnee = ordonnee + deltaY;
	}
	
	/**
	 * Connaitre la distance entre deux coordonnees
	 * 
	 * @param coord la deuxi�me coordonnee dans le calcule de distance
	 * @return la distance entre les deux coordonnees
	 */
	public double distanceVers(Coordonnees coord){
		return( Math.sqrt(
					(coord.getAbscisse()-this.abscisse)*(coord.getAbscisse()-this.abscisse)+
					(coord.getOrdonnee()-this.ordonnee)*(coord.getOrdonnee()-this.ordonnee)));
	}
	
	/**
	 * Calculer l'angle entre l'axe de abscisses et le segment d�fini par 
	 * la coordonnee de la classe et celle en parametre
	 * 
	 * @param coord deuxiéme coordonnee pour cr�er un segment
	 * @return l'angle en radian
	 */
	public double angleVers(Coordonnees coord){
		return Math.atan2(coord.getOrdonnee() - this.getOrdonnee(), coord.getAbscisse() - this.getAbscisse());
	}
	
	/**
	 * ToString de la classe Coordoonne
	 * Si machine EN => (1.00 , 1.00)
	 * Si machine FR => (1,00 , 1,00)
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#######0.0#");
		if(System.getProperty("user.country").equals("EN")) {
			return("(" + this.getAbscisse() + " , " + this.getOrdonnee() + ")");
		}
		return("(" + df.format(this.getAbscisse()) + " , " + df.format(this.getOrdonnee()) + ")");
	}
}


