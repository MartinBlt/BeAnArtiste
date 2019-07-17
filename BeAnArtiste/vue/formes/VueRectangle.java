package fr.eseo.i1.gpi.artiste.vue.formes;

import java.awt.Graphics2D;
import fr.eseo.i1.gpi.artiste.modele.formes.Rectangle;

public class VueRectangle extends VueForme {

	public VueRectangle(Rectangle rectangle) {
		super(rectangle);
	}

	@Override
	public void affiche(Graphics2D g2D) {
		g2D.setColor(this.getForme().getCouleur());
		
		if(((Rectangle) this.getForme()).isRempli()) {
			g2D.fillRect(	(int) this.getForme().getPosition().getAbscisse(), 
							(int) this.getForme().getPosition().getOrdonnee(),
							(int) this.getForme().getLargeur(), 
							(int) this.getForme().getHauteur());
		}
		
		g2D.drawRect(	(int) this.getForme().getPosition().getAbscisse(), 
						(int) this.getForme().getPosition().getOrdonnee(),
						(int) this.getForme().getLargeur(), 
						(int) this.getForme().getHauteur());
		
	}

}
