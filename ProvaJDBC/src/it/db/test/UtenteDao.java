package it.db.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UtenteDao implements Dao<Utente>, Constants {
	private List<Utente> utenti = new ArrayList<>();
	private Connection conn;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public UtenteDao() {
		String usr = "root";
		String pwd = "Tripolo.8691";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver caricato!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			this.conn = DriverManager.getConnection("jdbc:mysql://62.171.138.211:3306/TEST", usr, pwd);
			System.out.println("Database connesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Optional<Utente> get(long pk) {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String str_pk = Long.toString(pk);
		String str_pk_2 = (pk + "");
		
		Integer id = null;
		String nome = null;
		String cognome = null;
		String indirizzo = null;
		String utente = null;
		String password = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(STRSQL_UTENTI_WHERE_ID);
			pstmt.setString(1, str_pk);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				id = rs.getInt(1); 
				nome = rs.getString(2); 
				cognome = rs.getString("cognome");
				indirizzo = rs.getString("indirizzo");
				utente = rs.getString("utente");
				password = rs.getString("password");
				Utente u = new Utente(id, nome, cognome, indirizzo, utente, password);
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// return this.utenti;
		return Optional.empty();
	}

	public List<Utente> getAll(String order) {
		String strsql = "";
		if (order.equals(STR_OB_NOME)) {
			strsql = STRSQL_UTENTI_ORDER_BY_NOME;
		} else if (order.equals(STR_OB_COGNOME)) {
			strsql = STRSQL_UTENTI_ORDER_BY_COGNOME;
		} else if (order.equals(STR_OB_INDIRIZZO)) {
			strsql = STRSQL_UTENTI_ORDER_BY_INDIRIZZO;
		}
		
		Statement stmt = null;
		ResultSet rs = null;
		
		Integer id = null;
		String nome = null;
		String cognome = null;
		String indirizzo = null;
		String utente = null;
		String password = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(strsql);

			while(rs.next()) {
				id = rs.getInt(1); 
				nome = rs.getString(2); 
				cognome = rs.getString("cognome");
				indirizzo = rs.getString("indirizzo");
				utente = rs.getString("utente");
				password = rs.getString("password");
				Utente u = new Utente(id, nome, cognome, indirizzo, utente, password);
				this.utenti.add(u);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.utenti;
	}
	
	@Override
	public List<Utente> getAll() {
		
		Statement stmt = null;
		ResultSet rs = null;
		
		Integer id = null;
		String nome = null;
		String cognome = null;
		String indirizzo = null;
		String utente = null;
		String password = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(STRSQL_UTENTI);

			while(rs.next()) {
				id = rs.getInt(1); 
				nome = rs.getString(2); 
				cognome = rs.getString("cognome");
				indirizzo = rs.getString("indirizzo");
				utente = rs.getString("utente");
				password = rs.getString("password");
				Utente u = new Utente(id, nome, cognome, indirizzo, utente, password);
				this.utenti.add(u);
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.utenti;
	}

	@Override
	public void update(Utente t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Utente t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Utente t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void finalize() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
