/* HISTORIQUE:
 *
 * Version 1.0 - 16 oct. 2014 - Cr�ation de la classe.
 * FIN HISTORIQUE.
 */

package org.tref.views.frames.erreurs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.tref.views.comp.panes.InternalExceptionPane;
import org.tref.views.frames.AppFrame;

/**Infos:</br>
 * Classe PRSErrorFrame.java</br>
 * Description:</br>
 *	-
 * @author fernoult
 * @since  16 oct. 2014
 */
public class ErrorFrame extends JFrame{

	/** Bouton de sortie de la fenetre d'erreur. */
	protected JButton _exit;

	/** Panneau sud de la fenetre. */
	private JPanel _south;

	private String _excepMessage;

	private StackTraceElement[] _excepStackTrace;

	public ErrorFrame(String message_, StackTraceElement[] stackTrace_) {
		super();
		_excepMessage = message_;
		_excepStackTrace = stackTrace_;
		initErrorFrame();
	}

	/**<h3>prs.views.frames.err.PRSErrorFrame();</h3>
	 * {@code }</br>
	 *<p>Constructeur 
	 *</p>
	 *<b>Note: </b>Neant
	 * @throws HeadlessException
	 */
	public ErrorFrame() throws HeadlessException {
		super();
		initErrorFrame();
	}


	private void initErrorFrame(){

		setLayout(new BorderLayout());
		_south = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		add(new InternalExceptionPane(this, _excepMessage, _excepStackTrace), BorderLayout.CENTER);
		add(_south, BorderLayout.SOUTH);

		setSize(500, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	public StringBuffer getStackTrace(){

		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < _excepStackTrace.length; i++) {
			buf.append(_excepStackTrace[i].toString() + "\n");
		}

		return buf;
	}
	public void extendFrame() {
		setSize(500, 550);
		revalidate();
	}

	public void collapseFrame() {
		setSize(500, 100);
		revalidate();
	}

}
