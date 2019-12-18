//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.12.18 à 09:25:19 PM CET 
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
 *         &lt;element name="loans" type="{http://library/soap/web-services}loanWS"/>
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
    "loans"
})
@XmlRootElement(name = "getLoansResponse")
public class GetLoansResponse {

    @XmlElement(required = true)
    protected LoanWS loans;

    /**
     * Obtient la valeur de la propriété loans.
     * 
     * @return
     *     possible object is
     *     {@link LoanWS }
     *     
     */
    public LoanWS getLoans() {
        return loans;
    }

    /**
     * Définit la valeur de la propriété loans.
     * 
     * @param value
     *     allowed object is
     *     {@link LoanWS }
     *     
     */
    public void setLoans(LoanWS value) {
        this.loans = value;
    }

}
