package fr.eseo.i1.gpi.artiste.modele.formes;

import fr.eseo.i1.gpi.artiste.modele.Coordonnees;

public class Texte extends Forme {
	
	private static final String type = "texte";
	private String texte;
	private String font;
	private int taille;
	
	public Texte() {
		this(new Coordonnees(), "", "", 0);
	}
	
	/**
	 * Constructeur complet de la classe Texte
	 * 
	 * @param position coordonnees de la position en haut à gauche de Texte
	 * @param texte texte qui sera dans le texte affiché à l'écran
	 */
	public Texte(Coordonnees position, String texte, String font, int taille) {
		super(position, 0, 0, type);
		this.texte = texte;
		this.font = font;
		this.taille = taille;
	}
	
	public String getTexte() {
		return texte;
	}
	
	public String getFont() {
		return font;
	}
	
	public int getTaille() {
		return taille;
	}

	@Override
	public double aire() {
		return 0;
	}

	@Override
	public double perimetre() {
		return 0;
	}

	@Override
	public boolean contient(Coordonnees coordonnees) {
		//TODO faire contient texte
		return false;
	}
	
	@Override
	public boolean isRempli() {
		return false;
	}

	@Override
	public void setRempli(boolean remplissage) {
		//null
	}
}
