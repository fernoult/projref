package org.tref.tests;

import org.tref.views.frames.erreurs.ErrorFrame;

public class ErrorTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String testError = null;
		
		try {
			testError.length();
		} catch (NullPointerException e) {
			new ErrorFrame(e.getClass().toString(), e.getStackTrace());
		}
	}

}
