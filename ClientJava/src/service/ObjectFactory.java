
package src.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AjouterEtudiantResponse_QNAME = new QName("http://service/", "ajouterEtudiantResponse");
    private final static QName _AjouterEtudiant_QNAME = new QName("http://service/", "ajouterEtudiant");
    private final static QName _Lister_QNAME = new QName("http://service/", "lister");
    private final static QName _Etudiant_QNAME = new QName("http://service/", "etudiant");
    private final static QName _ListerResponse_QNAME = new QName("http://service/", "listerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Lister }
     * 
     */
    public Lister createLister() {
        return new Lister();
    }

    /**
     * Create an instance of {@link AjouterEtudiant }
     * 
     */
    public AjouterEtudiant createAjouterEtudiant() {
        return new AjouterEtudiant();
    }

    /**
     * Create an instance of {@link AjouterEtudiantResponse }
     * 
     */
    public AjouterEtudiantResponse createAjouterEtudiantResponse() {
        return new AjouterEtudiantResponse();
    }

    /**
     * Create an instance of {@link ListerResponse }
     * 
     */
    public ListerResponse createListerResponse() {
        return new ListerResponse();
    }

    /**
     * Create an instance of {@link Etudiant }
     * 
     */
    public Etudiant createEtudiant() {
        return new Etudiant();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjouterEtudiantResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "ajouterEtudiantResponse")
    public JAXBElement<AjouterEtudiantResponse> createAjouterEtudiantResponse(AjouterEtudiantResponse value) {
        return new JAXBElement<AjouterEtudiantResponse>(_AjouterEtudiantResponse_QNAME, AjouterEtudiantResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjouterEtudiant }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "ajouterEtudiant")
    public JAXBElement<AjouterEtudiant> createAjouterEtudiant(AjouterEtudiant value) {
        return new JAXBElement<AjouterEtudiant>(_AjouterEtudiant_QNAME, AjouterEtudiant.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Lister }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "lister")
    public JAXBElement<Lister> createLister(Lister value) {
        return new JAXBElement<Lister>(_Lister_QNAME, Lister.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Etudiant }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "etudiant")
    public JAXBElement<Etudiant> createEtudiant(Etudiant value) {
        return new JAXBElement<Etudiant>(_Etudiant_QNAME, Etudiant.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "listerResponse")
    public JAXBElement<ListerResponse> createListerResponse(ListerResponse value) {
        return new JAXBElement<ListerResponse>(_ListerResponse_QNAME, ListerResponse.class, null, value);
    }

}
