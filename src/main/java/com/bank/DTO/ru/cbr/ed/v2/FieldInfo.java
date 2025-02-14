//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.07.08 at 10:17:21 AM AMT 
//


package com.bank.DTO.ru.cbr.ed.v2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Information about requesting (requested) Attrubute.
 * 
 * <p>Java class for FieldInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FieldInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FieldNo" type="{urn:cbr-ru:ed:leaftypes:v2.0}Max70TextType"/&gt;
 *         &lt;element name="FieldValue" type="{urn:cbr-ru:ed:leaftypes:v2.0}Max210TextType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FieldInfo", propOrder = {
    "fieldNo",
    "fieldValue"
})
public class FieldInfo {

    @XmlElement(name = "FieldNo", required = true)
    protected String fieldNo;
    @XmlElement(name = "FieldValue")
    protected String fieldValue;

    /**
     * Gets the value of the fieldNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldNo() {
        return fieldNo;
    }

    /**
     * Sets the value of the fieldNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldNo(String value) {
        this.fieldNo = value;
    }

    /**
     * Gets the value of the fieldValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldValue() {
        return fieldValue;
    }

    /**
     * Sets the value of the fieldValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldValue(String value) {
        this.fieldValue = value;
    }

}
