
package src.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "GestionEtudiantWs", targetNamespace = "http://service/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GestionEtudiantWs {


    /**
     * 
     * @param password
     * @param login
     * @param nom
     * @param prenom
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ajouterEtudiant", targetNamespace = "http://service/", className = "service.AjouterEtudiant")
    @ResponseWrapper(localName = "ajouterEtudiantResponse", targetNamespace = "http://service/", className = "service.AjouterEtudiantResponse")
    @Action(input = "http://service/GestionEtudiantWs/ajouterEtudiantRequest", output = "http://service/GestionEtudiantWs/ajouterEtudiantResponse")
    public String ajouterEtudiant(
        @WebParam(name = "nom", targetNamespace = "")
        String nom,
        @WebParam(name = "prenom", targetNamespace = "")
        String prenom,
        @WebParam(name = "login", targetNamespace = "")
        String login,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @return
     *     returns java.util.List<service.Etudiant>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "lister", targetNamespace = "http://service/", className = "service.Lister")
    @ResponseWrapper(localName = "listerResponse", targetNamespace = "http://service/", className = "service.ListerResponse")
    @Action(input = "http://service/GestionEtudiantWs/listerRequest", output = "http://service/GestionEtudiantWs/listerResponse")
    public List<Etudiant> lister();

}