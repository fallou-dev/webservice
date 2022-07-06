package service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import domaine.Etudiant;
@WebService
public class GestionEtudiantWs {
    
	private static ArrayList<Etudiant> etudiants=new ArrayList<Etudiant>();
	
	public String ajouterEtudiant(@WebParam(name="nom")String nom,
			@WebParam(name="prenom")String prenom, 
			@WebParam(name="login")String login,
			@WebParam(name="password")String password)
	{
		Etudiant e=new Etudiant(nom,prenom,login,password);
		ConnBD bd=new ConnBD();
		bd.add(e);
		return "Etudiant ajouté";
	}
	
	public String modifierEtudiant(@WebParam(name="id")int id,
			@WebParam(name="nom")String nom,
			@WebParam(name="prenom")String prenom, 
			@WebParam(name="login")String login,
			@WebParam(name="password")String password
			)
	{
		String mess;
		Etudiant e=new Etudiant(id,nom,prenom,login,password);
		ConnBD bd = new ConnBD();
		bd.modifier(e);
        	  mess="Etudiant modifier";
          
		return mess;
	}
	
	public String supprimerEtudiant(@WebParam(name="id")int id)
	{
		String mess;
		
         
        	  ConnBD bd=new ConnBD();
        	  bd.supprimer(id);
        	  mess="Etudiant supprimer";
        	
          
		
		return mess;
	}
	
	public  List<Etudiant> lister()
	{
		ConnBD bd=new ConnBD();
		List<Etudiant> liste= bd.lister();
		
		
		return liste;
		
		
	}
	
}
