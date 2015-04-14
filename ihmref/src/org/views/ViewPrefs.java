package org.views;

import java.util.Locale;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import org.IHMAccess;
import org.views.comp.panes.ThemesPane;

public class ViewPrefs {

	private static ViewPrefs PREFS_INSTANCE;
	
	private Locale _locale;
	
	private String _laf;
	
	private Preferences prefs = Preferences.userNodeForPackage(IHMAccess.class);
	
	private static final String THEMES = "THEME";
	
	private static final String LANGUE = "LANGUE";
	
	private ViewPrefs() {
		
	}
	
	public static ViewPrefs getInstance(){
		
		// Le singleton qui va bien.
		if (PREFS_INSTANCE == null) {
			PREFS_INSTANCE = new ViewPrefs();
		}
		
		return PREFS_INSTANCE;
	}

	
	public void initPrefs(){
		
		String langue = prefs.get(LANGUE, "fr");
		String country = langue.toUpperCase();
		
		_locale = new Locale(langue, country);
		_laf = prefs.get(THEMES, "com.jtattoo.plaf.fast.FastLookAndFeel");
		
		System.out.println("LAF DANS LES PREFS : " + _laf);
		System.out.println("LOCALE DANS LES PREFS : " + langue + " " + country);

		Ressources.getInstance().setLocale(_locale);
		Ressources.getInstance().setLookAndFeel(_laf);
	
	}
	
	public void updateLOC(Locale locale_){
		
		try {
			prefs.put(LANGUE, locale_.getLanguage());
			prefs.flush();
			
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
		
		_locale = new Locale(locale_.getLanguage(), locale_.getCountry());
		Ressources.getInstance().setLocale(_locale);
	}
	
	public void updateLAF(String laf_){
		
		try {
			prefs.put(THEMES, laf_);
			prefs.flush();
			
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
		
		_laf = laf_;
		Ressources.getInstance().setLookAndFeel(_laf);
	}
	
	public String getLAF(){
		return _laf;
	}
	
	public Locale getLocale(){
		return _locale;
	}
}
