/* ihmref-LAndFImpl.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 9 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.tref.model.impl;

import org.tref.model.ILAndF;

import com.jtattoo.plaf.AbstractLookAndFeel;

public class LAndFImpl implements ILAndF {

	private String _lafName;
	private String _lafPath;
	private AbstractLookAndFeel _lafObject;
	
	/** LAndFImpl
	 * Constructeur
	 */
	public LAndFImpl() {
		super();
	}
	
	/** LAndFImpl
	 * Constructeur
	 */
	public LAndFImpl(String lafName_, String lafPath_, AbstractLookAndFeel lafObject_) {
		super();
		_lafName = lafName_;
		_lafPath = lafPath_;
		_lafObject = lafObject_;
	}

	/* (non-Javadoc)
	 * @see org.tref.model.impl.ILAndF#getLafName()
	 */
	@Override
	public String getLafName() {
		return _lafName;
	}

	/* (non-Javadoc)
	 * @see org.tref.model.impl.ILAndF#setLafName(java.lang.String)
	 */
	@Override
	public void setLafName(String lafName_) {
		_lafName = lafName_;
	}

	/* (non-Javadoc)
	 * @see org.tref.model.impl.ILAndF#getLafPath()
	 */
	@Override
	public String getLafPath() {
		return _lafPath;
	}

	/* (non-Javadoc)
	 * @see org.tref.model.impl.ILAndF#setLafPath(java.lang.String)
	 */
	@Override
	public void setLafPath(String lafPath_) {
		_lafPath = lafPath_;
	}

	/* (non-Javadoc)
	 * @see org.tref.model.impl.ILAndF#getLafObject()
	 */
	@Override
	public AbstractLookAndFeel getLafObject() {
		return _lafObject;
	}

	/* (non-Javadoc)
	 * @see org.tref.model.impl.ILAndF#setLafObject(com.jtattoo.plaf.AbstractLookAndFeel)
	 */
	@Override
	public void setLafObject(AbstractLookAndFeel lafObject_) {
		_lafObject = lafObject_;
	}

	/* Methodes overridee de sa classe mere.
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	/* (non-Javadoc)
	 * @see org.tref.model.impl.ILAndF#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_lafName == null) ? 0 : _lafName.hashCode());
		result = prime * result
				+ ((_lafObject == null) ? 0 : _lafObject.hashCode());
		result = prime * result
				+ ((_lafPath == null) ? 0 : _lafPath.hashCode());
		return result;
	}

	/* Methodes overridee de sa classe mere.
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
		LAndFImpl other = (LAndFImpl) obj;
		if (_lafName == null) {
			if (other._lafName != null)
				return false;
		} else if (!_lafName.equals(other._lafName))
			return false;
		if (_lafObject == null) {
			if (other._lafObject != null)
				return false;
		} else if (!_lafObject.equals(other._lafObject))
			return false;
		if (_lafPath == null) {
			if (other._lafPath != null)
				return false;
		} else if (!_lafPath.equals(other._lafPath))
			return false;
		return true;
	}

	/* Methodes overridee de sa classe mere.
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LAndFImpl [_lafName=" + _lafName + ", _lafPath=" + _lafPath
				+ ", _lafObject=" + _lafObject + "]";
	}
	
	
	
	
	
}
