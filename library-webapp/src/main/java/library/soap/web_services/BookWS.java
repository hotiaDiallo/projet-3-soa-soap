//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.12.25 à 02:33:03 PM CET 
//


package library.soap.web_services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour bookWS complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="bookWS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="esbn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bookStatus" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="work" type="{http://library/soap/web-services}workWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookWS", propOrder = {
    "id",
    "esbn",
    "bookStatus",
    "work"
})
public class BookWS {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer id;
    @XmlElement(required = true)
    protected String esbn;
    protected boolean bookStatus;
    @XmlElement(required = true)
    protected WorkWS work;

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
     * Obtient la valeur de la propriété esbn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsbn() {
        return esbn;
    }

    /**
     * Définit la valeur de la propriété esbn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsbn(String value) {
        this.esbn = value;
    }

    /**
     * Obtient la valeur de la propriété bookStatus.
     * 
     */
    public boolean isBookStatus() {
        return bookStatus;
    }

    /**
     * Définit la valeur de la propriété bookStatus.
     * 
     */
    public void setBookStatus(boolean value) {
        this.bookStatus = value;
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

}
