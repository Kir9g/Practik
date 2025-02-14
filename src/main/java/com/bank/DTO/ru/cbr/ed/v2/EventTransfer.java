//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.07.08 at 10:17:21 AM AMT 
//


package com.bank.DTO.ru.cbr.ed.v2;

import java.math.BigInteger;

import com.bank.DTO.ru.cbr.ed.leaftypes.v2.EventCodeType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Event of Balance Sweeping.
 * 
 * <p>Java class for EventTransfer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EventTransfer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="EventCode" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}EventCodeType" /&gt;
 *       &lt;attribute name="EventNumber" type="{urn:cbr-ru:ed:leaftypes:v2.0}Max3NumberType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventTransfer")
public class EventTransfer {

    @XmlAttribute(name = "EventCode", required = true)
    protected EventCodeType eventCode;
    @XmlAttribute(name = "EventNumber")
    protected BigInteger eventNumber;

    /**
     * Gets the value of the eventCode property.
     * 
     * @return
     *     possible object is
     *     {@link EventCodeType }
     *     
     */
    public EventCodeType getEventCode() {
        return eventCode;
    }

    /**
     * Sets the value of the eventCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventCodeType }
     *     
     */
    public void setEventCode(EventCodeType value) {
        this.eventCode = value;
    }

    /**
     * Gets the value of the eventNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEventNumber() {
        return eventNumber;
    }

    /**
     * Sets the value of the eventNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEventNumber(BigInteger value) {
        this.eventNumber = value;
    }

}
