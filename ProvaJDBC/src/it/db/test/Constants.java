package it.db.test;

public interface Constants {
	public final String STR_OB_NOME = "NOME";
	public final String STR_OB_COGNOME = "COGNOME";
	public final String STR_OB_INDIRIZZO = "INDIRIZZO";
	public final String STRSQL_UTENTI = "select id, nome, cognome, indirizzo, utente, password from Utenti";
	public final String STRSQL_UTENTI_ORDER_BY_INDIRIZZO = "select id, nome, cognome, indirizzo, utente, password from Utenti ORDER BY INDIRIZZO";
	public final String STRSQL_UTENTI_ORDER_BY_NOME = "select id, nome, cognome, indirizzo, utente, password from Utenti ORDER BY NOME";
	public final String STRSQL_UTENTI_ORDER_BY_COGNOME = "select id, nome, cognome, indirizzo, utente, password from Utenti ORDER BY COGNOME";

	public final String STRSQL_UTENTI_WHERE_ID = "select id, nome, cognome, indirizzo, utente, password from Utenti where id = ? ";

}
