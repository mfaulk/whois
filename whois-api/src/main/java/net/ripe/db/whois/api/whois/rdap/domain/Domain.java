//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: stripped
//


package net.ripe.db.whois.api.whois.rdap.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}rdapObject">
 *       &lt;sequence>
 *         &lt;element name="handle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ldhName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="unicodeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nameservers" type="{}nameserver" maxOccurs="unbounded"/>
 *         &lt;element name="secureDNS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="zoneSigned" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="delegationSigned" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="maxSigLife" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="dsData" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="keyTag" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                             &lt;element name="algorithm" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                             &lt;element name="digest" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="digestType" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                             &lt;element name="events" type="{}event" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="keyData" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="flags" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="protocol" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="publicKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="algorithm" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                             &lt;element name="events" type="{}event" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="publicIds" type="{}hashMapType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "handle",
    "ldhName",
    "unicodeName",
    "nameservers",
    "secureDNS",
    "publicIds"
})
@XmlRootElement(name = "domain")
public class Domain
    extends RdapObject
    implements Serializable
{

    @XmlElement(required = true)
    protected String handle;
    @XmlElement(required = true)
    protected String ldhName;
    @XmlElement(required = true)
    protected String unicodeName;
    @XmlElement(required = true)
    protected List<Nameserver> nameservers;
    protected Domain.SecureDNS secureDNS;
    protected HashMap publicIds;

    /**
     * Gets the value of the handle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHandle() {
        return handle;
    }

    /**
     * Sets the value of the handle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHandle(String value) {
        this.handle = value;
    }

    /**
     * Gets the value of the ldhName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLdhName() {
        return ldhName;
    }

    /**
     * Sets the value of the ldhName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLdhName(String value) {
        this.ldhName = value;
    }

    /**
     * Gets the value of the unicodeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnicodeName() {
        return unicodeName;
    }

    /**
     * Sets the value of the unicodeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnicodeName(String value) {
        this.unicodeName = value;
    }

    /**
     * Gets the value of the nameservers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nameservers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNameservers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Nameserver }
     * 
     * 
     */
    public List<Nameserver> getNameservers() {
        if (nameservers == null) {
            nameservers = new ArrayList<Nameserver>();
        }
        return this.nameservers;
    }

    /**
     * Gets the value of the secureDNS property.
     * 
     * @return
     *     possible object is
     *     {@link Domain.SecureDNS }
     *     
     */
    public Domain.SecureDNS getSecureDNS() {
        return secureDNS;
    }

    /**
     * Sets the value of the secureDNS property.
     * 
     * @param value
     *     allowed object is
     *     {@link Domain.SecureDNS }
     *     
     */
    public void setSecureDNS(Domain.SecureDNS value) {
        this.secureDNS = value;
    }

    /**
     * Gets the value of the publicIds property.
     * 
     * @return
     *     possible object is
     *     {@link HashMap }
     *     
     */
    public HashMap getPublicIds() {
        return publicIds;
    }

    /**
     * Sets the value of the publicIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link HashMap }
     *     
     */
    public void setPublicIds(HashMap value) {
        this.publicIds = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="zoneSigned" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="delegationSigned" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="maxSigLife" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="dsData" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="keyTag" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *                   &lt;element name="algorithm" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *                   &lt;element name="digest" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="digestType" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *                   &lt;element name="events" type="{}event" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="keyData" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="flags" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="protocol" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="publicKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="algorithm" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *                   &lt;element name="events" type="{}event" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "zoneSigned",
        "delegationSigned",
        "maxSigLife",
        "dsData",
        "keyData"
    })
    public static class SecureDNS
        implements Serializable
    {

        protected Boolean zoneSigned;
        protected Boolean delegationSigned;
        protected Long maxSigLife;
        protected List<Domain.SecureDNS.DsData> dsData;
        protected List<Domain.SecureDNS.KeyData> keyData;

        /**
         * Gets the value of the zoneSigned property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isZoneSigned() {
            return zoneSigned;
        }

        /**
         * Sets the value of the zoneSigned property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setZoneSigned(Boolean value) {
            this.zoneSigned = value;
        }

        /**
         * Gets the value of the delegationSigned property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDelegationSigned() {
            return delegationSigned;
        }

        /**
         * Sets the value of the delegationSigned property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDelegationSigned(Boolean value) {
            this.delegationSigned = value;
        }

        /**
         * Gets the value of the maxSigLife property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getMaxSigLife() {
            return maxSigLife;
        }

        /**
         * Sets the value of the maxSigLife property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setMaxSigLife(Long value) {
            this.maxSigLife = value;
        }

        /**
         * Gets the value of the dsData property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dsData property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDsData().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Domain.SecureDNS.DsData }
         * 
         * 
         */
        public List<Domain.SecureDNS.DsData> getDsData() {
            if (dsData == null) {
                dsData = new ArrayList<Domain.SecureDNS.DsData>();
            }
            return this.dsData;
        }

        /**
         * Gets the value of the keyData property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the keyData property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getKeyData().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Domain.SecureDNS.KeyData }
         * 
         * 
         */
        public List<Domain.SecureDNS.KeyData> getKeyData() {
            if (keyData == null) {
                keyData = new ArrayList<Domain.SecureDNS.KeyData>();
            }
            return this.keyData;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="keyTag" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
         *         &lt;element name="algorithm" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
         *         &lt;element name="digest" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="digestType" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
         *         &lt;element name="events" type="{}event" maxOccurs="unbounded" minOccurs="0"/>
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
            "keyTag",
            "algorithm",
            "digest",
            "digestType",
            "events"
        })
        public static class DsData
            implements Serializable
        {

            @XmlSchemaType(name = "unsignedInt")
            protected long keyTag;
            @XmlSchemaType(name = "unsignedByte")
            protected short algorithm;
            @XmlElement(required = true)
            protected String digest;
            @XmlSchemaType(name = "unsignedInt")
            protected long digestType;
            protected List<Event> events;

            /**
             * Gets the value of the keyTag property.
             * 
             */
            public long getKeyTag() {
                return keyTag;
            }

            /**
             * Sets the value of the keyTag property.
             * 
             */
            public void setKeyTag(long value) {
                this.keyTag = value;
            }

            /**
             * Gets the value of the algorithm property.
             * 
             */
            public short getAlgorithm() {
                return algorithm;
            }

            /**
             * Sets the value of the algorithm property.
             * 
             */
            public void setAlgorithm(short value) {
                this.algorithm = value;
            }

            /**
             * Gets the value of the digest property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDigest() {
                return digest;
            }

            /**
             * Sets the value of the digest property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDigest(String value) {
                this.digest = value;
            }

            /**
             * Gets the value of the digestType property.
             * 
             */
            public long getDigestType() {
                return digestType;
            }

            /**
             * Sets the value of the digestType property.
             * 
             */
            public void setDigestType(long value) {
                this.digestType = value;
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

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="flags" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="protocol" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="publicKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="algorithm" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
         *         &lt;element name="events" type="{}event" maxOccurs="unbounded" minOccurs="0"/>
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
            "flags",
            "protocol",
            "publicKey",
            "algorithm",
            "events"
        })
        public static class KeyData
            implements Serializable
        {

            @XmlElement(required = true)
            protected String flags;
            @XmlElement(required = true)
            protected String protocol;
            @XmlElement(required = true)
            protected String publicKey;
            @XmlSchemaType(name = "unsignedInt")
            protected long algorithm;
            protected List<Event> events;

            /**
             * Gets the value of the flags property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFlags() {
                return flags;
            }

            /**
             * Sets the value of the flags property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFlags(String value) {
                this.flags = value;
            }

            /**
             * Gets the value of the protocol property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProtocol() {
                return protocol;
            }

            /**
             * Sets the value of the protocol property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProtocol(String value) {
                this.protocol = value;
            }

            /**
             * Gets the value of the publicKey property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPublicKey() {
                return publicKey;
            }

            /**
             * Sets the value of the publicKey property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPublicKey(String value) {
                this.publicKey = value;
            }

            /**
             * Gets the value of the algorithm property.
             * 
             */
            public long getAlgorithm() {
                return algorithm;
            }

            /**
             * Sets the value of the algorithm property.
             * 
             */
            public void setAlgorithm(long value) {
                this.algorithm = value;
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

        }

    }

}
