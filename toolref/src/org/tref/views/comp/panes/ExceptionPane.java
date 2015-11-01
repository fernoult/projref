/* HISTORIQUE:
 *
 * Version 1.0 - 16/10/2014 - Cr�ation de la classe.
 * 
 * FIN HISTORIQUE.
 */

package org.tref.views.comp.panes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.tref.common.resources.Ressources;
import org.tref.common.resources.enums.EnumLogs;
import org.tref.views.ViewsRessources;
import org.tref.views.frames.erreurs.ErrorFrame;

/**Infos:</br>
 * Classe PRSExceptionPane.java</br>
 * Description:</br>
 *	-
 * @author fernoult
 * @since  16/10/2014
 */
public abstract class ExceptionPane extends JPanel implements ActionListener, KeyListener, MouseListener{

    
    protected JScrollPane _scrollPane;
    
    protected JPanel _messagePanel;
    protected JPanel _extendPane;
    protected JPanel _causePane;
    protected JPanel _rapportPane;
    protected JTextPane _stackPane;
    
    protected JButton _btnCollapseExtend;
    protected JButton _btnRapport;
    
    protected JLabel _cause;
    protected JLabel _rapportLibelle;
    protected JLabel _icone;
    protected JLabel _messageLibelle;
    
    private ImageIcon _iconeCollapse;
    private ImageIcon _iconeExtend;
    
    
    protected ErrorFrame _errorFrame;
    protected ViewsRessources _vresources = ViewsRessources.getInstance();
    protected Ressources _ressources = Ressources.getInstance();
    
    
    /**<h3>prs.views.composants.panneaux.PRSExceptionPane();</h3>
     * {@code }</br>
     *<p>Constructeur 
     *</p>
     *<b>Note: </b>Neant
     */
    public ExceptionPane(ErrorFrame errorFrame_) {
	super();
	_errorFrame = errorFrame_;
	initPRSExceptionPane();
    }
    
    /**<h3>prs.views.composants.panneaux.PRSExceptionPane();</h3>
     * {@code }</br>
     *<p>Constructeur 
     *</p>
     *<b>Note: </b>Neant
     */
    public ExceptionPane() {
	super();
	initPRSExceptionPane();
    }

    private void initPRSExceptionPane() {
	setLayout(new BorderLayout());
	
	initComposants();
	initPanels();
	
	add(_messagePanel, BorderLayout.NORTH);
	add(_extendPane, BorderLayout.CENTER);
	
	setSize(500, 100);
	setVisible(true);
    }
    
    private void initPanels() {
	_messagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	_messagePanel.add(_icone);
	_messagePanel.add(_messageLibelle);
	_messagePanel.add(_btnCollapseExtend);

	Font font = new Font("Tahoma", Font.BOLD, 12);
	Border CLine = BorderFactory.createLineBorder(Color.decode(_vresources.getErrorValue("ErreurLabel.ZoneBorder.Color.Value")));
	
	_causePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
	TitledBorder causeBorder = BorderFactory.createTitledBorder(CLine, " " + _vresources.getErrorValue("ErreurLabel.Cause.Title.Text.Value") + " ", 
			TitledBorder.LEFT, TitledBorder.TOP, font, 
			Color.decode(_vresources.getErrorValue("ErreurLabel.ZoneBorder.Color.Value")));
	_causePane.setBorder(causeBorder);
	_causePane.add(_cause);

	_stackPane = new JTextPane();
	_stackPane.setFont(new Font("Courier New", Font.PLAIN, 11));
	_scrollPane = new JScrollPane(_stackPane);
	JPanel paneDef = new JPanel();
	TitledBorder stackTraceBorder = BorderFactory.createTitledBorder(CLine, " " + _vresources.getErrorValue("ErreurLabel.StackTrace.Title.Text.Value") + " ", 
			TitledBorder.LEFT, TitledBorder.TOP, font, 
			Color.decode(_vresources.getErrorValue("ErreurLabel.ZoneBorder.Color.Value")));
	_scrollPane.setBorder(stackTraceBorder);
	_scrollPane.setVisible(false);
	
	_rapportPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	TitledBorder rapportBorder = BorderFactory.createTitledBorder(CLine, " " + _vresources.getErrorValue("ErreurLabel.RapportErreur.Title.Text.Value") + " ", 
			TitledBorder.LEFT, TitledBorder.TOP, font, 
			Color.decode(_vresources.getErrorValue("ErreurLabel.ZoneBorder.Color.Value")));
	_rapportPane.setBorder(rapportBorder);
	_rapportPane.add(_rapportLibelle);
	_rapportPane.add(_btnRapport);
	
	_extendPane = new JPanel(new BorderLayout());
	_extendPane.setBorder(BorderFactory.createLoweredBevelBorder());
	_extendPane.add(_causePane, BorderLayout.NORTH);
	_extendPane.add(_scrollPane, BorderLayout.CENTER);
	_extendPane.add(_rapportPane, BorderLayout.SOUTH);
	
    }

    private void initComposants() {
	// composants du MessagePane
	_iconeCollapse = new ImageIcon(getClass().getResource(_vresources.getImgsPath() + Ressources.getInstance().getSepProj() 
			+ _vresources.getErrorValue("ErreurLabel.Message.BTN.Collapse.Icone.Value")));
	_iconeExtend = new ImageIcon(getClass().getResource(_vresources.getImgsPath() + Ressources.getInstance().getSepProj() 
			+ _vresources.getErrorValue("ErreurLabel.Message.BTN.Extend.Icone.Value")));
	_icone = new JLabel();
	
	_messageLibelle = new JLabel();
	_messageLibelle.setFont(new Font("Arial", Font.PLAIN, 14));
	_messageLibelle.setPreferredSize(new Dimension(350, 50));
	_messageLibelle.setHorizontalAlignment(SwingConstants.LEFT);
	
	_cause = new JLabel();
	_cause.setFont(new Font("Arial", Font.BOLD, 13));
	_cause.setVerticalAlignment(SwingConstants.CENTER);
//	_cause.setForeground(Color.decode(_labelsBundle.getString("Exception.frame.cause.color")));
	_cause.setForeground(Color.RED);
	
	_rapportLibelle = new JLabel(_vresources.getErrorValue("ErreurLabel.RapportErreur.Message.Text.Value"));
	_rapportLibelle.setFont(new Font("Arial", Font.PLAIN, 12));
	
	_btnCollapseExtend = new JButton(_vresources.getErrorValue("ErreurLabel.Message.BTN.Extend.Text.Value"), _iconeExtend);
	_btnCollapseExtend.addActionListener(this);
	_btnRapport = new JButton(_vresources.getErrorValue("ErreurLabel.RapportErreur.BTN.Text.Value"),
		new ImageIcon(getClass().getResource(_vresources.getImgsPath() + Ressources.getInstance().getSepProj() 
				+ _vresources.getErrorValue("ErreurLabel.RapportErreur.BTN.Icone.Value"))));
	_btnRapport.setToolTipText(_vresources.getErrorValue("ErreurLabel.RapportErreur.BTN.ToolType.Value"));
	_btnRapport.addActionListener(this);
    }
    
    /* M�thode Overrid�e des classes parentes.
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e_) {
	
	if (e_.getSource().equals(_btnCollapseExtend)) {
	    if (e_.getActionCommand().equals(_vresources.getErrorValue("ErreurLabel.Message.BTN.Extend.Text.Value"))) {
		    _stackPane.setVisible(true);
		    _scrollPane.setVisible(true);
		    _btnCollapseExtend.setIcon(_iconeCollapse);
		    _btnCollapseExtend.setSelected(false);
		    _btnCollapseExtend.setText(_vresources.getErrorValue("ErreurLabel.Message.BTN.Collpase.Text.Value"));
		    _errorFrame.extendFrame();
	    }else if (e_.getActionCommand().equals(_vresources.getErrorValue("ErreurLabel.Message.BTN.Collpase.Text.Value"))) {
		    _stackPane.setVisible(false);
		    _scrollPane.setVisible(false);
		    _btnCollapseExtend.setIcon(_iconeExtend);
		    _btnCollapseExtend.setSelected(false);
		    _btnCollapseExtend.setText(_vresources.getErrorValue("ErreurLabel.Message.BTN.Extend.Text.Value"));
		    _errorFrame.collapseFrame();
	    }

	}else if (e_.getSource().equals(_btnRapport)) {

        String mailTo = "";
        URI uriMailTo = null;
 
        //Assembler l'url
        mailTo = _vresources.getErrorValue("ErreurLabel.RapportErreur.TO.Text.Value");
        mailTo += "?subject=Rapport Erreur";
        mailTo += "&body=Veuillez trouver ci-joint le rapport d'erreur suivant:\n\n";
        mailTo += _errorFrame.getStackTrace().toString();
		
		if (Desktop.isDesktopSupported()) {
			
			if (Desktop.getDesktop().isSupported(Desktop.Action.MAIL)) {
				
                try {
                    uriMailTo = new URI("mailto", mailTo, null);
                    Desktop.getDesktop().mail(uriMailTo);
                } catch (IOException e) {
        			System.err.println(EnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
                } catch (URISyntaxException e) {
        			System.err.println(EnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
                }
			}
		}
	}
    }

    /* M�thode Overrid�e des classes parentes.
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped(KeyEvent e_) {
    }

    /* M�thode Overrid�e des classes parentes.
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    @Override
    public void keyPressed(KeyEvent e_) {
    }

    /* M�thode Overrid�e des classes parentes.
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased(KeyEvent e_) {
    }

    /* M�thode Overrid�e des classes parentes.
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseClicked(MouseEvent e_) {
    }

    /* M�thode Overrid�e des classes parentes.
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    @Override
    public void mousePressed(MouseEvent e_) {
    }

    /* M�thode Overrid�e des classes parentes.
     * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseReleased(MouseEvent e_) {
    }

    /* M�thode Overrid�e des classes parentes.
     * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseEntered(MouseEvent e_) {
    }

    /* M�thode Overrid�e des classes parentes.
     * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseExited(MouseEvent e_) {
    }

}
