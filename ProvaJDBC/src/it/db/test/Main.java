/**
 * 
 */
package it.db.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author marco
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList utenti = null;
		
		UtenteDao ud = new UtenteDao();
		utenti = (ArrayList) ud.getAll();
		
		Iterator it = utenti.iterator();
		
		while (it.hasNext()) {
			Utente object = (Utente) it.next();
			System.out.println(object.getNome());
		}
		
	}
}
