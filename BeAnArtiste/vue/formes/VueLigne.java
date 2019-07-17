package fr.eseo.i1.gpi.artiste.vue.formes;

import java.awt.Graphics2D;

import fr.eseo.i1.gpi.artiste.modele.formes.Ligne;

public class VueLigne extends VueForme {
	
	/**
	 * Constructeur de la classe VueLigne
	 * 
	 * @param ligne ligne qui sera convertit en vue pour l'affichage
	 */
	public VueLigne(Ligne ligne) {
		super(ligne);
	}
	

	@Override
	public void affiche(Graphics2D g2D) {
		g2D.setColor(this.getForme().getCouleur());
		g2D.drawLine(	(int) this.getForme().getPosition().getAbscisse(), 
						(int) this.getForme().getPosition().getOrdonnee(),
						(int) (this.getForme().getPosition().getAbscisse() + this.getForme().getLargeur()), 
						(int) (this.getForme().getPosition().getOrdonnee() + this.getForme().getHauteur()));
	}
}
