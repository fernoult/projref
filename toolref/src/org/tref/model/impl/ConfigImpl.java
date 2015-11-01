package org.tref.model.impl;

import java.io.Serializable;

import org.tref.model.IConfig;

@SuppressWarnings("serial")
public class ConfigImpl implements Serializable, IConfig {

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
	public ConfigImpl() {
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
	public ConfigImpl(String _appliRacine, String _confRacine, String _dbRacine,
			String _installed) {
		super();
		this._appliRacine = _appliRacine;
		this._confRacine = _confRacine;
		this._dbRacine = _dbRacine;
		this._installed = _installed;
	}
	
	/* (non-Javadoc)
	 * @see org.tref.model.impl.IConfig#get_appliRacine()
	 */
	@Override
	public String get_appliRacine() {
		return _appliRacine;
	}
	
	/* (non-Javadoc)
	 * @see org.tref.model.impl.IConfig#set_appliRacine(java.lang.String)
	 */
	@Override
	public void set_appliRacine(String _appliRacine) {
		this._appliRacine = _appliRacine;
	}
	
	/* (non-Javadoc)
	 * @see org.tref.model.impl.IConfig#get_confRacine()
	 */
	@Override
	public String get_confRacine() {
		return _confRacine;
	}
	
	/* (non-Javadoc)
	 * @see org.tref.model.impl.IConfig#set_confRacine(java.lang.String)
	 */
	@Override
	public void set_confRacine(String _confRacine) {
		this._confRacine = _confRacine;
	}
	
	/* (non-Javadoc)
	 * @see org.tref.model.impl.IConfig#get_dbRacine()
	 */
	@Override
	public String get_dbRacine() {
		return _dbRacine;
	}
	
	/* (non-Javadoc)
	 * @see org.tref.model.impl.IConfig#set_dbRacine(java.lang.String)
	 */
	@Override
	public void set_dbRacine(String _dbRacine) {
		this._dbRacine = _dbRacine;
	}
	
	/* (non-Javadoc)
	 * @see org.tref.model.impl.IConfig#get_installed()
	 */
	@Override
	public String get_installed() {
		return _installed;
	}
	
	/* (non-Javadoc)
	 * @see org.tref.model.impl.IConfig#set_installed(java.lang.String)
	 */
	@Override
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
		ConfigImpl other = (ConfigImpl) obj;
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
		return "ConfigImpl [_appliRacine=" + _appliRacine + ", _confRacine="
				+ _confRacine + ", _dbRacine=" + _dbRacine + ", _installed="
				+ _installed + "]";
	}
	
	
}
