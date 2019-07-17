package fr.eseo.i1.gpi.artiste.vue.formes;

import java.awt.Font;
import java.awt.Graphics2D;
import fr.eseo.i1.gpi.artiste.modele.formes.Texte;

public class VueTexte extends VueForme {
	
	public VueTexte(Texte texte) {
		super(texte);
	}
	
	@Override
	public void affiche(Graphics2D g2D) {
		g2D.setColor(this.getForme().getCouleur());
		g2D.setFont(new Font( ((Texte) this.getForme()).getFont(), Font.BOLD, ((Texte) this.getForme()).getTaille() ));
		g2D.drawString(	((Texte) this.getForme()).getTexte(), 
						(int) this.getForme().getPosition().getAbscisse(), 
						(int) this.getForme().getPosition().getOrdonnee());
	}
}
