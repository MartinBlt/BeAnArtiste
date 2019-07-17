package fr.eseo.i1.gpi.artiste.vue.formes;

import java.awt.Graphics2D;
import fr.eseo.i1.gpi.artiste.modele.formes.Forme;

public abstract class VueForme {
	
	protected final Forme forme;
	
	/**
	 * Contructeur de la classe VueForme
	 * 
	 * @param forme
	 */
	public VueForme(Forme forme) {
		this.forme = forme;
	}
	
	public Forme getForme() {
		return forme;
	}
	
	public abstract void affiche(Graphics2D g2D);
}
