/* HISTORIQUE:
 *
 * Version 1.0 - 16 oct. 2014 - Cr�ation de la classe.
 * FIN HISTORIQUE.
 */

package org.tref.common.exceptions;

import org.tref.views.ViewsRessources;

/**Infos:</br>
 * Classe PRSInternalException.java</br>
 * Description:</br>
 *	-
 * @author fernoult
 * @since  16 oct. 2014
 */
public class InternalException extends Exception {

    private String _message;
    
    private StackTraceElement[] _stackTrace;
    
    private ViewsRessources _vresource = ViewsRessources.getInstance();
    
    /**<h3>prs.beans.PRSInternalException();</h3>
     * {@code }</br>
     *<p>Constructeur 
     *</p>
     *<b>Note: </b>Neant
     */
    public InternalException(String message_) {
	_message = _vresource.getErrorValue("ErreurLabel.Message.Text.Value");
	
    }

    /**<h3>prs.beans.PRSInternalException();</h3>
     * {@code }</br>
     *<p>Constructeur 
     *</p>
     *<b>Note: </b>Neant
     * @param message_
     */
    public InternalException(String message_, StackTraceElement[] stackTrace_) {
	_message = _vresource.getErrorValue("ErreurLabel.Message.Text.Value");
	_stackTrace = stackTrace_;
	
    }

    /**<h3>prs.beans.PRSInternalException();</h3>
     * {@code }</br>
     *<p>Constructeur 
     *</p>
     *<b>Note: </b>Neant
     * @param cause_
     */
    public InternalException(Throwable cause_) {
	super(cause_);
    }

    /**<h3>prs.beans.PRSInternalException();</h3>
     * {@code }</br>
     *<p>Constructeur 
     *</p>
     *<b>Note: </b>Neant
     * @param message_
     * @param cause_
     */
    public InternalException(String message_, Throwable cause_) {
	super(message_, cause_);
    }

    /**<h3>prs.beans.PRSInternalException();</h3>
     * {@code }</br>
     *<p>Constructeur 
     *</p>
     *<b>Note: </b>Neant
     * @param message_
     * @param cause_
     * @param enableSuppression_
     * @param writableStackTrace_
     */
    public InternalException(String message_, Throwable cause_,
	    boolean enableSuppression_, boolean writableStackTrace_) {
	super(message_, cause_, enableSuppression_, writableStackTrace_);
    }

    /* M�thode Overrid�e des classes parentes.
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
	return _message;
    }

    /* M�thode Overrid�e des classes parentes.
     * @see java.lang.Throwable#getStackTrace()
     */
    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
        // TODO Implementer la methode getStackTrace
    }
}
