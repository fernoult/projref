package org.tref.common.utils;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Config implements Serializable {

	/** Attribut du path principal. */
	private String _appliRacine;
	
	/** Attribut du path de la conf */
	private String _confRacine;
	
	/** Attribut du path des datas. */
	private String _dbRacine;
	
	/** Attribut eja installee. */
	private String _installed = "false";
	
	/**
	 * Constructeur.
	 */
	public Config() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructeur.
	 * @param _appliRacine
	 * @param _confRacine
	 * @param _dbRacine
	 * @param _installed
	 */
	public Config(String _appliRacine, String _confRacine, String _dbRacine,
			String _installed) {
		super();
		this._appliRacine = _appliRacine;
		this._confRacine = _confRacine;
		this._dbRacine = _dbRacine;
		this._installed = _installed;
	}
	
	/**
	 * <b>Methode:  org.se.common.utils.get_appliRacine()</b><br/>
	 *
	 *<b>Description: </b> Retourne le path principal.<br/>
	 *<br/>
	 * @return String
	 */
	public String get_appliRacine() {
		return _appliRacine;
	}
	
	/**
	 * <b>Methode:  org.se.common.utils.set_appliRacine()</b><br/>
	 *
	 *<b>Description: </b> Initialise le path principal.<br/>
	 *<br/>
	 * @param _appliRacine void
	 */
	public void set_appliRacine(String _appliRacine) {
		this._appliRacine = _appliRacine;
	}
	
	/**
	 * <b>Methode:  org.se.common.utils.get_confRacine()</b><br/>
	 *
	 *<b>Description: </b> Retourne le path de la conf.<br/>
	 *<br/>
	 * @return String
	 */
	public String get_confRacine() {
		return _confRacine;
	}
	
	/**
	 * <b>Methode:  org.se.common.utils.set_confRacine()</b><br/>
	 *
	 *<b>Description: </b> Initialise le path de la conf.<br/>
	 *<br/>
	 * @param _confRacine void
	 */
	public void set_confRacine(String _confRacine) {
		this._confRacine = _confRacine;
	}
	
	/**
	 * <b>Methode:  org.se.common.utils.get_dbRacine()</b><br/>
	 *
	 *<b>Description: </b> Retourne le path des datas.<br/>
	 *<br/>
	 * @return String
	 */
	public String get_dbRacine() {
		return _dbRacine;
	}
	
	/**
	 * <b>Methode:  org.se.common.utils.set_dbRacine()</b><br/>
	 *
	 *<b>Description: </b> Initialise le path des datas.<br/>
	 *<br/>
	 * @param _dbRacine void
	 */
	public void set_dbRacine(String _dbRacine) {
		this._dbRacine = _dbRacine;
	}
	
	/**
	 * <b>Methode:  org.se.common.utils.get_installed()</b><br/>
	 *
	 *<b>Description: </b> Retourne l'informatio deja installee.<br/>
	 *<br/>
	 * @return String
	 */
	public String get_installed() {
		return _installed;
	}
	
	/**
	 * <b>Methode:  org.se.common.utils.set_installed()</b><br/>
	 *
	 *<b>Description: </b> Positionne l'information deja installee.<br/>
	 *<br/>
	 * @param _installed void
	 */
	public void set_installed(String _installed) {
		this._installed = _installed;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_appliRacine == null) ? 0 : _appliRacine.hashCode());
		result = prime * result
				+ ((_confRacine == null) ? 0 : _confRacine.hashCode());
		result = prime * result
				+ ((_dbRacine == null) ? 0 : _dbRacine.hashCode());
		result = prime * result
				+ ((_installed == null) ? 0 : _installed.hashCode());
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Config other = (Config) obj;
		if (_appliRacine == null) {
			if (other._appliRacine != null)
				return false;
		} else if (!_appliRacine.equals(other._appliRacine))
			return false;
		if (_confRacine == null) {
			if (other._confRacine != null)
				return false;
		} else if (!_confRacine.equals(other._confRacine))
			return false;
		if (_dbRacine == null) {
			if (other._dbRacine != null)
				return false;
		} else if (!_dbRacine.equals(other._dbRacine))
			return false;
		if (_installed == null) {
			if (other._installed != null)
				return false;
		} else if (!_installed.equals(other._installed))
			return false;
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Config [_appliRacine=" + _appliRacine + ", _confRacine="
				+ _confRacine + ", _dbRacine=" + _dbRacine + ", _installed="
				+ _installed + "]";
	}
	
	
}
