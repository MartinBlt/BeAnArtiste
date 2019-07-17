package fr.eseo.i1.gpi.artiste.vue.formes;

import java.awt.Graphics2D;
import fr.eseo.i1.gpi.artiste.modele.formes.Ellipse;

public class VueEllipse extends VueForme {
	
	/**
	 * Constructeur de la classe VueEllipse
	 * 
	 * @param ellipse ellipse qui sera convertit pour l'affichage
	 */
	public VueEllipse(Ellipse ellipse) {
		super(ellipse);
	}
	
	@Override
	public void affiche(Graphics2D g2D) {
		g2D.setColor(this.getForme().getCouleur());
	
		//RECUP LE REMPLISSAGE DE LA FORME
		if(((Ellipse) this.getForme()).isRempli()) {
			g2D.fillOval(	(int) this.getForme().getPosition().getAbscisse(), 
					(int) this.getForme().getPosition().getOrdonnee(),
					(int) this.getForme().getLargeur(), 
					(int) this.getForme().getHauteur());
		}
		
		g2D.drawOval(	(int) this.getForme().getPosition().getAbscisse(), 
						(int) this.getForme().getPosition().getOrdonnee(),
						(int) this.getForme().getLargeur(), 
						(int) this.getForme().getHauteur());
	}
}
