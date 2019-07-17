package fr.eseo.i1.gpi.artiste.controleur.actions;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.i1.gpi.artiste.vue.ihm.PanneauDessin;

public class ActionExporter extends AbstractAction {
	
	public static final String NOM_ACTION = "Exporter en jpeg";
	public PanneauDessin panneauDessin = null;
	
	public ActionExporter(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(JOptionPane.showConfirmDialog(	this.panneauDessin, 
											"Exporter ?", 
											NOM_ACTION, 
											JOptionPane.YES_NO_OPTION,
											JOptionPane.WARNING_MESSAGE) == 0) {
			BufferedImage imageExporter = new BufferedImage(panneauDessin.getLargeur(), panneauDessin.getHauteur(), BufferedImage.TYPE_INT_RGB);
	        Graphics2D formesExporter = imageExporter.createGraphics();
	        panneauDessin.printAll(formesExporter);
	        formesExporter.dispose();
	        try {
	            ImageIO.write(imageExporter, "jpg", new File("Exportation.jpg"));
	        } catch (IOException exp) {
	            exp.printStackTrace();
	        }
		}
	}
}
