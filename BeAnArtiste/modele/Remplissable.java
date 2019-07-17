package fr.eseo.i1.gpi.artiste.modele;

public interface Remplissable {
	
	/**
	 * Savoir si une forme est rempli
	 * 
	 * @return True si la forme demande un remplissage, sinon False
	 */
	public boolean isRempli();
	
	/**
	 * Choisir le mode de remplissage de la forme
	 * 
	 * @param modeRemplissage True pour rempli False pour juste les contours
	 */
	public void setRempli(boolean modeRemplissage);
}
