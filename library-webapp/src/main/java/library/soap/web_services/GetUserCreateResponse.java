//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.12.08 à 04:29:50 PM CET 
//


package library.soap.web_services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userWS" type="{http://library/soap/web-services}userWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "userWS"
})
@XmlRootElement(name = "getUserCreateResponse")
public class GetUserCreateResponse {

    @XmlElement(required = true, nillable = true)
    protected UserWS userWS;

    /**
     * Obtient la valeur de la propriété userWS.
     * 
     * @return
     *     possible object is
     *     {@link UserWS }
     *     
     */
    public UserWS getUserWS() {
        return userWS;
    }

    /**
     * Définit la valeur de la propriété userWS.
     * 
     * @param value
     *     allowed object is
     *     {@link UserWS }
     *     
     */
    public void setUserWS(UserWS value) {
        this.userWS = value;
    }

}
