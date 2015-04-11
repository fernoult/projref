package org.views.frames;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.Ressources;

public class AppFrame extends PFrame {
	
	public AppFrame() {
		super();
		
        // Ajout de l'interdiction sur la croix.
        addWindowListener(new WindowAdapter() {
        	
        	@SuppressWarnings("static-access")
			@Override
        	public void windowClosing(WindowEvent e) {
        		
        		// Si le traitement n'est pas encore termin�, on interdit de fermer la fen�tre avec la croix.
        		// et on affiche une fen�tre d'avertissement avec message + possibilit� d'annuler proprement la requ�te.
        		int rep = JOptionPane.showConfirmDialog(null, "La fermeture de cette fenetre entrainera\n la fermeture de ses fenetres associees.", "CONFIRM", JOptionPane.WARNING_MESSAGE);
        		if ( rep == 0) {
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}else {
        			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}

        	}
		});
	}
	
	
	protected void addFrame(PFrame frame_){
		get_frames().add(frame_);
	}
	
	protected boolean removeFrame(PFrame frame_){
		return true;
	}
	
	protected boolean removeFrames(){
		return true;
	}
	
	protected boolean notufyFrame(PFrame frame_){
		return true;
	}
	
	protected void notifyFrames(){
		
		for (Iterator<?> iterator = get_frames().iterator(); iterator.hasNext();) {
			PFrame frame = (PFrame) iterator.next();
			try {
				Thread.sleep(20);
				frame.dispose();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void dispose() {
		super.dispose();
		// ferme ses fenetre filles
		System.out.println("Fermeture des fenetres filles.");
		if (get_frames() != null) {
			notifyFrames();
		}
	}
}
