package fr.eseo.i1.gpi.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import fr.eseo.i1.gpi.artiste.modele.Coordonnees;
import fr.eseo.i1.gpi.artiste.modele.Remplissable;

public class Etoile extends Forme implements Remplissable {
	
	private static final String type = "etoile";
	
	public static final int NOMBRE_BRANCHES_PAR_DEFAUT = 5;
	public static final double ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT = 0.0;
	public static final double LONGUEUR_BRANCHE_PAR_DEFAUT = 0.5;
	
	boolean modeRemplissage = false;
	private int nombreBranche;
	private double anglePremiereBranche;
	private double longueurBranche;
	private List<Coordonnees> coordonnees = new ArrayList<Coordonnees>();
	private Coordonnees centreEtoile;

	/**
	 * Constructeur de la classe Etoile
	 * POSITION, LARGEUR et HAUTEUR par défaut
	 */
	public Etoile() {
		this(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT);
	}
	
	/**
	 * Constructeur de la classe Etoile
	 * POSITION par défaut
	 * 
	 * @param largeur largeur de l'Etoile
	 * @param hauteur hauteur de l'Etoile
	 */
	public Etoile(double taille) {
		this(new Coordonnees(), taille);
	}
	
	/**
	 * Constructeur de la classe Etoile
	 * LARGEUR et HAUTEUR par défaut
	 * 
	 * @param position coordonnnes de la position en haut à gauche de l'Etoile
	 */
	public Etoile(Coordonnees position) {
		this(position, Forme.LARGEUR_PAR_DEFAUT);
	}
	
	/**
	 * Constructeur complet de la classe Etoile
	 * 
	 * @param position coordonnees de la position en haut à gauche de l'Etoile
	 * @param largeur largeur de l'Etoile
	 * @param hauteur hauteur de l'Etoile
	 */
	public Etoile(Coordonnees position, double taille) {
		this(	position, taille, NOMBRE_BRANCHES_PAR_DEFAUT, 
				ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 
				LONGUEUR_BRANCHE_PAR_DEFAUT);
	}
	
	/**
	 * Constructeur complet de la classe Etoile
	 * 
	 * @param position
	 * @param taille
	 * @param nombreBranche
	 * @param anglePremiereBranche
	 * @param longueurBranche
	 */
	public Etoile(	Coordonnees position, double taille, int nombreBranche,
					double anglePremiereBranche, double longueurBranche) {
		super(position, taille, taille, type);
		this.nombreBranche = nombreBranche;
		this.anglePremiereBranche = anglePremiereBranche;
		this.longueurBranche = longueurBranche;
		this.setRempli(false);
		this.setCentreEtoile(new Coordonnees(	
				position.getAbscisse()+(taille/2), 
				position.getOrdonnee()+(taille/2)));
		
		//Créer Angle entre les branches
		double angleEntreBranches = (Math.PI*2)/nombreBranche;
		
		//Ajouter les coordonnees suivante suivant le nombre de branche			
		double angleCourant = anglePremiereBranche;
		for(int i = 0 ; i < this.getNombreBranches() ; i++) {
			coordonnees.add(new Coordonnees(
					this.getCentreEtoile().getAbscisse() +
					taille/2*Math.cos(angleCourant), 
					this.getCentreEtoile().getOrdonnee() + 
					taille/2*Math.sin(angleCourant)));
			
			coordonnees.add(new Coordonnees(
					this.getCentreEtoile().getAbscisse() + 
					taille/2*(1-longueurBranche)*Math.cos(
							angleCourant + angleEntreBranches/2), 
					this.getCentreEtoile().getOrdonnee() + 
					taille/2*(1-longueurBranche)*Math.sin(
							angleCourant + angleEntreBranches/2)));
			
			angleCourant = angleCourant + angleEntreBranches;
		}
	}
	
	/**
	 * Accesseur du premier angle de la branche 
	 * avec l'axe des Abscisse de l'étoile en radian
	 * 
	 * @return le premier angle de la branche avec 
	 * l'axe des Abscisse de l'étoile en radian
	 */
	public double getAnglePremiereBranche() {
		return anglePremiereBranche;
	}
	
	/**
	 * Accesseur de la longueur de branche, entre 0 et 1
	 * 
	 * @return longueur des branches par rapport à la taille
	 */
	public double getLongueurBranche() {
		return longueurBranche;
	}
	
	/**
	 * Accesseur du nombre de branche sur l'étoile
	 * 
	 * @return nombre de branche sur l'étoile
	 */
	public int getNombreBranches() {
		return nombreBranche;
	}
	
	/**
	 * Accesseur de la liste de coordonnées des pointes de l'étoile
	 * 
	 * @return liste coordonnées point de l'étoile
	 */
	public List<Coordonnees> getCoordonnees() {
		return coordonnees;
	}
	
	private Coordonnees getCentreEtoile() {
		return this.centreEtoile;
	}
	
	/**
	 * Mutateur de l'angle de rotation de l'étoile
	 * 
	 * @param anglePremiereBranche
	 */
	public void setAnglePremiereBranche(double anglePremiereBranche) {
		if(anglePremiereBranche < 0 || anglePremiereBranche > 360) {
			throw new IllegalArgumentException("Angle de "
					+ "la première branche mauvaise");
		} else {
			this.anglePremiereBranche = anglePremiereBranche;
			
			Etoile nouvelleEtoile = new Etoile(	this.getPosition(), 
												this.getLargeur(), 
												this.getNombreBranches(), 
												anglePremiereBranche, 
												this.getLongueurBranche());
			
			this.setCoordonnees(nouvelleEtoile.getCoordonnees());
		}
	}
	
	/**
	 * Mutateur de la longueur des branche par 
	 * rapport à au rayon (entre 0 et 1)
	 * 
	 * @param longueurBranche
	 */
	public void setLongueurBranche(double longueurBranche) {
		if(longueurBranche < 0 || longueurBranche > 1) {
			throw new IllegalArgumentException("Longueur"
					+ " de branche mauvaise");
		} else {
			this.longueurBranche = longueurBranche;
			
			Etoile nouvelleEtoile = new Etoile(	this.getPosition(), 
					this.getLargeur(), 
					this.getNombreBranches(), 
					this.getAnglePremiereBranche(),
					longueurBranche);

			this.setCoordonnees(nouvelleEtoile.getCoordonnees());
			this.setPosition(nouvelleEtoile.getPosition());
		}
	}
	
	/**
	 * Mutateur du nombre de branche sur l'étoile
	 * 
	 * @param nombreBranche
	 */
	public void setNombreBranches(int nombreBrancheLocal) {
		if(nombreBrancheLocal < 0  || nombreBrancheLocal > 15) {
			throw new IllegalArgumentException("Nombre "
					+ "de branche mauvaise");
		} else {
			this.nombreBranche = nombreBrancheLocal;
			
			Etoile nouvelleEtoile = new Etoile(	this.getPosition(), 
										this.getLargeur(), 
										nombreBranche, 
										this.getAnglePremiereBranche(),
										this.getLongueurBranche());

			this.setCoordonnees(nouvelleEtoile.getCoordonnees());
		}
	}
	
	/**
	 * Mutateur de la liste de coordonnées des pointes de l'étoile
	 * 
	 * @param listeCoordonnees
	 */
	public void setCoordonnees(List<Coordonnees> listeCoordonnees) {
		this.coordonnees = listeCoordonnees;
	}
	
	@Override
	public void setPosition(Coordonnees position) {
		super.setPosition(position);
		
		Etoile nouvelleEtoile = new Etoile(	position, 
											this.getLargeur(), 
											this.getNombreBranches(), 
											this.getAnglePremiereBranche(), 
											this.getLongueurBranche());

		this.setCoordonnees(nouvelleEtoile.getCoordonnees());
	}
	
	@Override
	public void setLargeur(double largeur) {
		if(largeur < 0) {
			throw new IllegalArgumentException("Taille négative");
		} else {
			super.setLargeur(largeur);
			super.setHauteur(largeur);
			
			Etoile nouvelleEtoile = new Etoile(	this.getPosition(), 
										largeur, 
										this.getNombreBranches(), 
										this.getAnglePremiereBranche(), 
										this.getLongueurBranche());
			
			this.setCoordonnees(nouvelleEtoile.getCoordonnees());
		}
	}
	
	@Override
	public void setHauteur(double hauteur) {
		if(hauteur < 0) {
			throw new IllegalArgumentException("Taille négative");
		} else {
			super.setLargeur(hauteur);
			super.setHauteur(hauteur);
			
			Etoile nouvelleEtoile = new Etoile(	this.getPosition(), 
									hauteur, 
									this.getNombreBranches(), 
									this.getAnglePremiereBranche(), 
									this.getLongueurBranche());

			this.setCoordonnees(nouvelleEtoile.getCoordonnees());
		}
	}
	
	private void setCentreEtoile(Coordonnees centreEtoile) {
		this.centreEtoile = centreEtoile;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#######0.0#");
		return 	(this.isRempli() ? "[Etoile-Rempli]" : "[Etoile]") 
				+ " : pos " + super.getPosition()
				+ " dim "
				+ df.format(super.getLargeur()) 
				+ " x "
				+ df.format(super.getHauteur())
				+ " périmètre : "
				+ df.format(this.perimetre())
				+ " aire : "
				+ df.format(this.aire())
				+ " couleur : ";
	}
	
	@Override
	public double aire() {
		double coteTriangle=this.getCoordonnees().get(0).
				distanceVers(this.getCoordonnees().get(1));
		double baseTriange=this.getCoordonnees().get(1).
				distanceVers(this.getCoordonnees().get(3));
		double coteTriangleCentre=this.getCoordonnees().get(1).
				distanceVers(this.getCentreEtoile());
		
		double aireTrianglesCentre = 	0.5*
						baseTriange*
						Math.sqrt(Math.pow(coteTriangleCentre, 2)-
							(Math.pow(baseTriange, 2)/4))*
						this.getNombreBranches();
		double aireTriangles = 	0.5*
						baseTriange*
						Math.sqrt(Math.pow(coteTriangle, 2)-
								(Math.pow(baseTriange, 2)/4))*
						this.getNombreBranches();
		
		return aireTrianglesCentre + aireTriangles;
	}

	@Override
	public double perimetre() {
		return (coordonnees.get(0).distanceVers(coordonnees.get(1))) * 
				this.getNombreBranches() * 2;
	}

	@Override
	public boolean contient(Coordonnees coordonneesLocal) {
		boolean contient = false;
		for(int i = 0 ; i < this.getNombreBranches() ; i++) {
			//IF pour les branches de l'étoile
			if(contientTriangle(	this.getCoordonnees().get(
									(i == 0 ? this.getNombreBranches()*2-1
										: 2*i-1)),
									this.getCoordonnees().get(2*i),
									this.getCoordonnees().get(2*i+1),
									coordonneesLocal)) {
				contient = true;
			}
			
			//IF pour l'intérieur du polygone
			if(contientTriangle(	this.getCentreEtoile(), 
									this.getCoordonnees().get(
									(i == 0 ? this.getNombreBranches()*2-1
										: 2*i-1)),
									this.getCoordonnees().get(2*i+1), 
									coordonneesLocal)) {
				contient = true;
			}
		}
		return contient;
	}
	
	private boolean contientTriangle(Coordonnees p1, Coordonnees p2, 
			Coordonnees p3, Coordonnees pContient) {
		//Savoir si une coordonnees fait parti du triangle p1, p1, p2
		//On passe par les demi-plans pour connaitre si le
		//point est dans le trianle
		double delta1, delta2, delta3;
	    boolean estNegatif, estPositif;

	    delta1 = signe(pContient, p1, p2);
	    delta2 = signe(pContient, p2, p3);
	    delta3 = signe(pContient, p3, p1);

	    estNegatif = (delta1 < 0) || (delta2 < 0) || (delta3 < 0);
	    estPositif = (delta1 > 0) || (delta2 > 0) || (delta3 > 0);

	    return !(estNegatif && estPositif);
	}
	
	private double signe(Coordonnees pointContient, 
			Coordonnees droiteP1, Coordonnees droiteP2) {
	    return 	(pointContient.getAbscisse()-droiteP2.getAbscisse())*
	    		(droiteP1.getOrdonnee()-droiteP2.getOrdonnee())-
	    		(droiteP1.getAbscisse()-droiteP2.getAbscisse())*
	    		(pointContient.getOrdonnee()-droiteP2.getOrdonnee());
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
