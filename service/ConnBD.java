package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domaine.Etudiant;

public class ConnBD {
	
	static final String DB_URL = "jdbc:mysql://localhost/Gestion";
	   static final String USER = "root";
	   static final String PASS = "";

	public void add(Etudiant e) {
	
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO Etudiant(nom,prenom,login,password) Values(?,?,?,?)");
     ){
		
			stmt.setString(1, e.getNom());
			stmt.setString(2, e.getPrenom());
			stmt.setString(3, e.getLogin());
			stmt.setString(4, e.getPassword());
		
		
		
		stmt.executeUpdate();
		
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	    }
	
	
	public ArrayList<Etudiant> lister() {
		ArrayList<Etudiant> etudiants=new ArrayList<Etudiant>();
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement("select * from Etudiant");
     ){
		
			ResultSet resultat =stmt.executeQuery();
		
		   while(resultat.next()) {
			   Etudiant e= new Etudiant(resultat.getString("nom"),resultat.getString("prenom"),resultat.getString("login"),resultat.getString("password"));
			   etudiants.add(e);
		   }
		
		
		
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return etudiants;

	    }
	
	public void supprimer(int id) {
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement("delete from Etudiant where id =?");
     ){
		
			stmt.setInt(1, id);
			
		
		
		
		stmt.executeUpdate();
		
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	    }
	
	public void modifier(Etudiant e) {
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement("update Etudiant set nom=?,prenom=?,login=?,password=? where id=?");
     ){
		
			stmt.setString(1, e.getNom());
			stmt.setString(2, e.getPrenom());
			stmt.setString(3, e.getLogin());
			stmt.setString(4, e.getPassword());
			stmt.setInt(5, e.getId());
		
		
		
		stmt.executeUpdate();
		
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	    }
	
	  }


