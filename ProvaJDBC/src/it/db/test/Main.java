/**
 * 
 */
package it.db.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


/**
 * @author marco
 *
 */
public class Main implements Constants {

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

		utenti = (ArrayList) ud.getAll(STR_OB_NOME);
		
		it = utenti.iterator();
		
		while (it.hasNext()) {
			Utente object = (Utente) it.next();
			System.out.println(object.getNome());
		}

		utenti = (ArrayList) ud.getAll(STR_OB_COGNOME);
		
		it = utenti.iterator();
		
		while (it.hasNext()) {
			Utente object = (Utente) it.next();
			System.out.println(object.getNome());
		}

		utenti = (ArrayList) ud.getAll(STR_OB_INDIRIZZO);
		
		it = utenti.iterator();
		
		while (it.hasNext()) {
			Utente object = (Utente) it.next();
			System.out.println(object.getNome());
		}
		
		Sigleton s = Sigleton.getInstance();
		Sigleton s1 = Sigleton.getInstance();
		Sigleton s2 = Sigleton.getInstance();
		Sigleton s3 = Sigleton.getInstance();
		
		Optional<Utente> user = ud.get(13);
		
		System.out.println(user);
		
	}
}
