//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: stripped
//


package net.ripe.db.whois.api.whois.rdap.domain;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for rdapObject complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="rdapObject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="entities" type="{}entity" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="remarks" type="{}remark" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="links" type="{}link" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="events" type="{}event" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rdapConformance" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="notices" type="{}notice" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="port43" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rdapObject", propOrder = {
        "status",
        "entities",
        "remarks",
        "links",
        "events",
        "lang",
        "rdapConformance",
        "notices",
        "port43"
})
@XmlSeeAlso({
        Entity.class,
        Nameserver.class,
        Ip.class,
        Autnum.class,
        Domain.class
})
public class RdapObject
        implements Serializable
{

    protected List<Object> status;
    protected List<Entity> entities;
    protected List<Remark> remarks;
    protected List<Link> links;
    protected List<Event> events;
    protected String lang;
    @XmlElement(required = true)
    protected List<String> rdapConformance;
    protected List<Notice> notices;
    protected String port43;

    /**
     * Gets the value of the status property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the status property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatus().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     *
     *
     */
    public List<Object> getStatus() {
        if (status == null) {
            status = new ArrayList<Object>();
        }
        return this.status;
    }

    /**
     * Gets the value of the entities property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entities property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntities().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Entity }
     *
     *
     */
    public List<Entity> getEntities() {
        if (entities == null) {
            entities = new ArrayList<Entity>();
        }
        return this.entities;
    }

    /**
     * Gets the value of the remarks property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the remarks property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemarks().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Remark }
     *
     *
     */
    public List<Remark> getRemarks() {
        if (remarks == null) {
            remarks = new ArrayList<Remark>();
        }
        return this.remarks;
    }

    /**
     * Gets the value of the links property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the links property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinks().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Link }
     *
     *
     */
    public List<Link> getLinks() {
        if (links == null) {
            links = new ArrayList<Link>();
        }
        return this.links;
    }

    /**
     * Gets the value of the events property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the events property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvents().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Event }
     *
     *
     */
    public List<Event> getEvents() {
        if (events == null) {
            events = new ArrayList<Event>();
        }
        return this.events;
    }

    /**
     * Gets the value of the lang property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Gets the value of the rdapConformance property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rdapConformance property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRdapConformance().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getRdapConformance() {
        if (rdapConformance == null) {
            rdapConformance = new ArrayList<String>();
        }
        return this.rdapConformance;
    }

    /**
     * Gets the value of the notices property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notices property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotices().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Notice }
     *
     *
     */
    public List<Notice> getNotices() {
        if (notices == null) {
            notices = new ArrayList<Notice>();
        }
        return this.notices;
    }

    /**
     * Gets the value of the port43 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPort43() {
        return port43;
    }

    /**
     * Sets the value of the port43 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPort43(String value) {
        this.port43 = value;
    }

}
