//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.07.08 at 10:17:21 AM AMT 
//


package com.bank.DTO.ru.cbr.ed.v2;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Arrests/Limitations Info.
 * 
 * <p>Java class for ArrestsInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrestsInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ArrestDetailedInfo" type="{urn:cbr-ru:ed:v2.0}ArrestDetailedInfo" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrestsInfo", propOrder = {
    "arrestDetailedInfo"
})
public class ArrestsInfo {

    @XmlElement(name = "ArrestDetailedInfo", required = true)
    protected List<ArrestDetailedInfo> arrestDetailedInfo;

    /**
     * Gets the value of the arrestDetailedInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the arrestDetailedInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArrestDetailedInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrestDetailedInfo }
     * 
     * 
     */
    public List<ArrestDetailedInfo> getArrestDetailedInfo() {
        if (arrestDetailedInfo == null) {
            arrestDetailedInfo = new ArrayList<ArrestDetailedInfo>();
        }
        return this.arrestDetailedInfo;
    }

}
