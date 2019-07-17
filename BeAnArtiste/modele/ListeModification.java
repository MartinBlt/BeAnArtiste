package fr.eseo.i1.gpi.artiste.modele;

import java.awt.Color;

public class ListeModification {
	
	int nombreBranche;
	double hauteur, largeur, longueurBranche;
	boolean remplissage, changement, supprimer;
	Color couleur;
	
	public ListeModification(double hauteur, double largeur, boolean remplissage, Color couleur) {
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.remplissage = remplissage;
		this.couleur = couleur;
		this.changement = true;
		this.supprimer = false;
	}
	
	public ListeModification(double taille, boolean remplissage, Color nouvelleCouleur, int nombreBranche, double longueurBranche) {
		this(taille, taille, remplissage, nouvelleCouleur);
		this.nombreBranche = nombreBranche;
		this.longueurBranche = longueurBranche;
	}
	
	public ListeModification() {
		this.changement = false;
	}

	public ListeModification(boolean supprimer) {
		this.supprimer = supprimer;
	}

	public double getHauteur() {
		return hauteur;
	}
	
	public double getLargeur() {
		return largeur;
	}
	
	public double getLongueurBranche() {
		return longueurBranche;
	}
	
	public int getNombreBranche() {
		return nombreBranche;
	}
	
	public boolean isRemplissage() {
		return remplissage;
	}
	
	public Color getCouleur() {
		return couleur;
	}

	public boolean changement() {
		return changement;
	}
	
	public boolean supprimer() {
		return supprimer;
	}
}
