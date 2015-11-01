/* ihmref-LafTableModel.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 9 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.tref.views.comp.tables.models;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.AbstractTableModel;

import org.tref.model.ILAndF;
import org.tref.model.impl.LAndFImpl;

public class LafTableModel extends AbstractTableModel{

	private ArrayList<LAndFImpl> _lalList;
	
	private final String[] _entetes = {"Liste des Look And Feel \"JTattoo\" disponibles"};
	
	
	
	public LafTableModel() {
		super();
		_lalList = new ArrayList<>();
	}
	
	public LafTableModel(ArrayList<LAndFImpl> lafList_){
		set_lalList(lafList_);
	}

	@Override
	public int getRowCount() {
		return _lalList.size();
	}

	@Override
	public int getColumnCount() {
		return _entetes.length;
	}

	@Override
	public Object getValueAt(int rowIndex_, int columnIndex_) {
		return _lalList.get(rowIndex_).getLafName();
	}
	
	public ILAndF getLAFObject(int rowIndex_){
		return _lalList.get(rowIndex_);
	}
	
	public void addLAFObject(LAndFImpl lafObj_){
		_lalList.add(lafObj_);
		fireTableRowsInserted(_lalList.size(), _lalList.size());
	}

	public void addLAFObjects(ArrayList<LAndFImpl> lafList_){
		
		for (Iterator iterator = lafList_.iterator(); iterator.hasNext();) {
			LAndFImpl lAndFImpl = (LAndFImpl) iterator.next();
			_lalList.add(lAndFImpl);
			fireTableRowsInserted(_lalList.size(), _lalList.size());
		}
	}
	
	/**
	 * @return the _lalList
	 */
	
	public ArrayList<LAndFImpl> get_lalList() {
		return _lalList;
	}

	/**
	 * @param _lalList the _lalList to set
	 */
	public void set_lalList(ArrayList<LAndFImpl> _lalList) {
		this._lalList = _lalList;
	}

	/**
	 * @return the _entetes
	 */
	
	public String[] get_entetes() {
		return _entetes;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return super.getColumnClass(columnIndex);
	}
	
	

}
