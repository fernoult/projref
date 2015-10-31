package org.tref.common.resources;

import java.text.MessageFormat;


public enum PEnumLogs {

	ERREUR ("ERREUR"),
	SUCCESS ("SUCCES"),
	WARNING ("WARNING"),
	INFO ("INFO"),
	ACTION ("ACTION");
	
	private String _log;
	private String _type;
	private Ressources _ressources = Ressources.getInstance();
	
	/** Tableau d'objets pour le formatteur de messages. */
	private Object[] _logTab = new Object[3];
	
	/**
	 * Constructeur.
	 * @param type_
	 */
	PEnumLogs(String type_){
		_type = type_;
	}
	
	/**
	 * <b>Methode:  org.se.common.resources.getLogMessage()</b><br/>
	 *
	 *<b>Description: </b> Retourne le log.<br/>
	 *<br/>
	 * @param message_
	 * @return String
	 */
	public String getLogMessage(String message_){
		return _log = formatLog(message_);
	}
	
	@SuppressWarnings("static-access")
	/**
	 * <b>Methode:  org.se.common.resources.formatLog()</b><br/>
	 *
	 *<b>Description: </b> Retourne un message de log formate.<br/>
	 *<br/>
	 * @param message_
	 * @return String
	 */
	private String formatLog(String message_){
		String log = null;
		
		_logTab[0] = _type;
		_logTab[1] = _ressources.getDateMillis();
		_logTab[2] = message_;
		
		log = MessageFormat.format(_ressources.getCommonLabel("log.message.format"), _logTab);

		return log;
	}
	
}
