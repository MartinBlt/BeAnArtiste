package fr.eseo.i1.gpi.artiste.vue.formes;

import java.awt.Graphics2D;
import java.awt.Polygon;
import fr.eseo.i1.gpi.artiste.modele.formes.Etoile;

public class VueEtoile extends VueForme {

	public VueEtoile(Etoile etoile) {
		super(etoile);
	}

	@Override
	public void affiche(Graphics2D g2D) {
		g2D.setColor(this.getForme().getCouleur());
		
		Etoile etoile = ((Etoile) this.getForme());
		int[] ensemblePointsXPolygone = new int[etoile.getNombreBranches()*2];
		int[] ensemblePointsYPolygone = new int[etoile.getNombreBranches()*2];
		
		for(int i = 0 ; i < etoile.getCoordonnees().size() ; i++) {
			ensemblePointsXPolygone[i] = (int) Math.round(etoile.getCoordonnees().get(i).getAbscisse());
			ensemblePointsYPolygone[i] = (int) Math.round(etoile.getCoordonnees().get(i).getOrdonnee());
		}
		
		//RECUP LE REMPLISSAGE DE LA FORME
		if(etoile.isRempli()) {
			g2D.fillPolygon(new Polygon(ensemblePointsXPolygone, ensemblePointsYPolygone, etoile.getNombreBranches()*2));
		}
		
		g2D.drawPolygon(new Polygon(ensemblePointsXPolygone, ensemblePointsYPolygone, etoile.getNombreBranches()*2));
	}
}