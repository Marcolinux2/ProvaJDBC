package it.db.test;

import java.sql.Connection;
import java.util.*;

public class Sigleton {
    private static Sigleton istanza = null;
    private ArrayList connList = new ArrayList();
    // Il costruttore private impedisce l'istanza di oggetti da parte di classi esterne
    // impedisco di usare new dall'esterno della classe.
    private Sigleton() {}

    public Connection getConnection() {
		// creo la connection e
		// la infilo nella list
    	// e restituisco la connection.
    	return null;
    }
    
    // Metodo della classe impiegato per accedere al singleton
    public static synchronized Sigleton getInstance() {
        if (istanza == null) {
            istanza = new Sigleton();
        }
        return istanza;
    }
}
