package fr.eseo.i1.gpi.artiste.modele;

import java.awt.Color;

public interface Coloriable {
	
	/**
	 * Accesseur de la couleur d'une forme
	 * 
	 * @return la couleur d'une forme
	 */
	public Color getCouleur();
	
	/**
	 * Mutateur de la couleur d'une forme
	 * 	 * 
	 * @param nouvelle couleur d'une forme
	 */
	public void setCouleur(Color couleur);
	
}
