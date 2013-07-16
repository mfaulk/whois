//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: stripped
//


package net.ripe.db.whois.api.whois.rdap.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;


/**
 * <p>Java class for event complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="event">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="eventAction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="eventActor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "event", propOrder = {
    "eventAction",
    "eventDate",
    "eventActor"
})
public class Event
    implements Serializable
{

    protected String eventAction;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar eventDate;
    protected String eventActor;

    /**
     * Gets the value of the eventAction property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEventAction() {
        return eventAction;
    }

    /**
     * Sets the value of the eventAction property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEventAction(String value) {
        this.eventAction = value;
    }

    /**
     * Gets the value of the eventDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getEventDate() {
        return eventDate;
    }

    /**
     * Sets the value of the eventDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setEventDate(XMLGregorianCalendar value) {
        this.eventDate = value;
    }

    /**
     * Gets the value of the eventActor property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEventActor() {
        return eventActor;
    }

    /**
     * Sets the value of the eventActor property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEventActor(String value) {
        this.eventActor = value;
    }

}
