package it.db.test;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class JDBCConnection implements Constants {

	public JDBCConnection() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Connection
		// Statement
		// ResultSet
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String usr = "root";
		String pwd = "Tripolo.8691";
		
		
		// primo step: caricamento driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver caricato!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// secondo step: connessione al db
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://62.171.138.211:3306/TEST", usr, pwd
			);
			
			System.out.println("Database connesso!");
			// "jdbc:mysql://62.171.138.211:3306/TEST?user=root&password=Tripolo.8691";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Integer id = null;
		String nome = null;
		String cognome = null;
		String indirizzo = null;
		
		// terzo step: statement
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(STRSQL_UTENTI);

			// metodi di riferimento nello Statement:
			// stmt.execute
			// stmt.executeUpdate ->int 
			// stmt.executeQuery  -> ResultSet -> risultati della query

			List utenti = new <Utente>ArrayList();
			while(rs.next()) {
				id = rs.getInt(1); 
				nome = rs.getString(2); 
				cognome = rs.getString("cognome");
				indirizzo = rs.getString("indirizzo");
				System.out.println(id + " " + nome + " " + cognome + " " + indirizzo);
				// Utente u = new Utente(id, nome, cognome, indirizzo);
				// utenti.add(u);
			}
			
			// chiusura del ResultSet
			rs.close();

			// chiusura dello Statement
			stmt.close();
			
			// chiusura della Connection
			// conn.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String strsql = "insert into Utenti (nome, cognome, indirizzo)	values ( 'Albert', 'Einstein', 'Pavia')";
		// insert new record 
		try {
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(strsql);
			System.out.println("insert: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		strsql = "delete from Utenti where nome = 'Mario'";
		// insert new record 
		try {
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(strsql);
			System.out.println("delete: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		strsql = "update Utenti set nome = 'Massimo' where cognome = 'Plank'";
		// insert new record 
		try {
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(strsql);
			System.out.println("update: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// ****************************************************************
		// FORM WEB da cui arrivano i dati da inserire nel DB
		// ****************************************************************
		// regola 1: fare sempre una validazione dei campi.
		// ****************************************************************
		
		// 2 usare il prepared statement 
		strsql = "insert into Utenti (nome, cognome, indirizzo) values (?, ?, ?)";
		// ****************************************************************
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(strsql);
			pstmt.setString(1, "Enrico");
			pstmt.setString(2, "Fermi");
			pstmt.setString(3, "'--;");
			int row = pstmt.executeUpdate();
			System.out.println(row);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
