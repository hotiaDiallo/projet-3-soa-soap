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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="user" type="{http://library/soap/web-services}userWS"/>
 *         &lt;element name="work" type="{http://library/soap/web-services}workWS"/>
 *         &lt;element name="borronwingDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="returningDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="loanExtended" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "user",
    "work",
    "borronwingDate",
    "returningDate",
    "loanExtended"
})
@XmlRootElement(name = "getLoanCreateRequest")
public class GetLoanCreateRequest {

    @XmlElement(required = true)
    protected UserWS user;
    @XmlElement(required = true)
    protected WorkWS work;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar borronwingDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar returningDate;
    protected boolean loanExtended;

    /**
     * Obtient la valeur de la propriété user.
     * 
     * @return
     *     possible object is
     *     {@link UserWS }
     *     
     */
    public UserWS getUser() {
        return user;
    }

    /**
     * Définit la valeur de la propriété user.
     * 
     * @param value
     *     allowed object is
     *     {@link UserWS }
     *     
     */
    public void setUser(UserWS value) {
        this.user = value;
    }

    /**
     * Obtient la valeur de la propriété work.
     * 
     * @return
     *     possible object is
     *     {@link WorkWS }
     *     
     */
    public WorkWS getWork() {
        return work;
    }

    /**
     * Définit la valeur de la propriété work.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkWS }
     *     
     */
    public void setWork(WorkWS value) {
        this.work = value;
    }

    /**
     * Obtient la valeur de la propriété borronwingDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBorronwingDate() {
        return borronwingDate;
    }

    /**
     * Définit la valeur de la propriété borronwingDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBorronwingDate(XMLGregorianCalendar value) {
        this.borronwingDate = value;
    }

    /**
     * Obtient la valeur de la propriété returningDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReturningDate() {
        return returningDate;
    }

    /**
     * Définit la valeur de la propriété returningDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReturningDate(XMLGregorianCalendar value) {
        this.returningDate = value;
    }

    /**
     * Obtient la valeur de la propriété loanExtended.
     * 
     */
    public boolean isLoanExtended() {
        return loanExtended;
    }

    /**
     * Définit la valeur de la propriété loanExtended.
     * 
     */
    public void setLoanExtended(boolean value) {
        this.loanExtended = value;
    }

}
