package serveur;



import javax.xml.ws.Endpoint;

import service.GestionEtudiantWs;



public class ServeurJws {
	public static void main(String[] args) {
		String url="http://localhost:8585/";

		
		Endpoint.publish(url,new GestionEtudiantWs());
		System.out.println(url);
			}
		} 

