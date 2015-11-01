/* HISTORIQUE
 *
 * [Modif]  - V.01 - 00/00/0000 - Ajout de l'historique.
 * [Create] - V.00 - 00/00/0000 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.tref.model;

/**
 * Classe de ...
 */
public interface IConfig {

	/**
	 * <b>Methode:  org.se.common.utils.get_appliRacine()</b><br/>
	 *
	 *<b>Description: </b> Retourne le path principal.<br/>
	 *<br/>
	 * @return String
	 */
	public abstract String get_appliRacine();

	/**
	 * <b>Methode:  org.se.common.utils.set_appliRacine()</b><br/>
	 *
	 *<b>Description: </b> Initialise le path principal.<br/>
	 *<br/>
	 * @param _appliRacine void
	 */
	public abstract void set_appliRacine(String _appliRacine);

	/**
	 * <b>Methode:  org.se.common.utils.get_confRacine()</b><br/>
	 *
	 *<b>Description: </b> Retourne le path de la conf.<br/>
	 *<br/>
	 * @return String
	 */
	public abstract String get_confRacine();

	/**
	 * <b>Methode:  org.se.common.utils.set_confRacine()</b><br/>
	 *
	 *<b>Description: </b> Initialise le path de la conf.<br/>
	 *<br/>
	 * @param _confRacine void
	 */
	public abstract void set_confRacine(String _confRacine);

	/**
	 * <b>Methode:  org.se.common.utils.get_dbRacine()</b><br/>
	 *
	 *<b>Description: </b> Retourne le path des datas.<br/>
	 *<br/>
	 * @return String
	 */
	public abstract String get_dbRacine();

	/**
	 * <b>Methode:  org.se.common.utils.set_dbRacine()</b><br/>
	 *
	 *<b>Description: </b> Initialise le path des datas.<br/>
	 *<br/>
	 * @param _dbRacine void
	 */
	public abstract void set_dbRacine(String _dbRacine);

	/**
	 * <b>Methode:  org.se.common.utils.get_installed()</b><br/>
	 *
	 *<b>Description: </b> Retourne l'informatio deja installee.<br/>
	 *<br/>
	 * @return String
	 */
	public abstract String get_installed();

	/**
	 * <b>Methode:  org.se.common.utils.set_installed()</b><br/>
	 *
	 *<b>Description: </b> Positionne l'information deja installee.<br/>
	 *<br/>
	 * @param _installed void
	 */
	public abstract void set_installed(String _installed);

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public abstract int hashCode();

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public abstract boolean equals(Object obj);

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public abstract String toString();

}