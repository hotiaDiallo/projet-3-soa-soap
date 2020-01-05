//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.01.05 à 06:33:16 PM CET 
//


package library.soap.web_services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour loanWS complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="loanWS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="user" type="{http://library/soap/web-services}userWS"/>
 *         &lt;element name="work" type="{http://library/soap/web-services}workWS"/>
 *         &lt;element name="borrowingDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="returnDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
@XmlType(name = "loanWS", propOrder = {
    "id",
    "user",
    "work",
    "borrowingDate",
    "returnDate",
    "loanExtended"
})
public class LoanWS {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer id;
    @XmlElement(required = true)
    protected UserWS user;
    @XmlElement(required = true)
    protected WorkWS work;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar borrowingDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar returnDate;
    protected boolean loanExtended;

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

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
     * Obtient la valeur de la propriété borrowingDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBorrowingDate() {
        return borrowingDate;
    }

    /**
     * Définit la valeur de la propriété borrowingDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBorrowingDate(XMLGregorianCalendar value) {
        this.borrowingDate = value;
    }

    /**
     * Obtient la valeur de la propriété returnDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReturnDate() {
        return returnDate;
    }

    /**
     * Définit la valeur de la propriété returnDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReturnDate(XMLGregorianCalendar value) {
        this.returnDate = value;
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
