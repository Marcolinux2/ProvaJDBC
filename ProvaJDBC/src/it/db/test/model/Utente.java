/**
 * 
 */
package it.db.test.model;

/**
 * @author marco
 *
 */
public class Utente implements java.io.Serializable {
	private static final long serialVersionUID = 2958432758623369585L;
	private Long id;
	private String nome;
	private String cognome;
	private String indirizzo;
	private Boolean utenteAttivo;
	private boolean utenteSposato;
	private String telefono;
	
	// classe che segue le specifiche JavaBean
	// ********************************************************
	// 1) Costrutture senza argomenti SEMPRE PRESENTE!
	// 2) Proprietà accessibili con get/set/is 
	// 3) Classe dovrebbe essere serializzabile
	// 4) Non ci dovrebbero essere metodi di gestione eventi 
	// ********************************************************
	
	
	
	public Utente() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Boolean isUtenteAttivo() {
		return utenteAttivo;
	}

	public void setUtenteAttivo(Boolean utenteAttivo) {
		this.utenteAttivo = utenteAttivo;
	}

	public boolean isUtenteSposato() {
		return utenteSposato;
	}

	public void setUtenteSposato(boolean utenteSposato) {
		this.utenteSposato = utenteSposato;
	}

}
