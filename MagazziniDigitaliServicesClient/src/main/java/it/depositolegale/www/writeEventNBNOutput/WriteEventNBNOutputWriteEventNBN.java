/**
 * WriteEventNBNOutputWriteEventNBN.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.depositolegale.www.writeEventNBNOutput;

public class WriteEventNBNOutputWriteEventNBN  implements java.io.Serializable {
    private it.depositolegale.www.writeEventNBNOutput.WriteEventNBNOutputWriteEventNBNSoftware software;

    private java.lang.String codiceNBN;

    private java.lang.String urlOriginale;

    private java.util.Calendar dataInizioElab;

    public WriteEventNBNOutputWriteEventNBN() {
    }

    public WriteEventNBNOutputWriteEventNBN(
           it.depositolegale.www.writeEventNBNOutput.WriteEventNBNOutputWriteEventNBNSoftware software,
           java.lang.String codiceNBN,
           java.lang.String urlOriginale,
           java.util.Calendar dataInizioElab) {
           this.software = software;
           this.codiceNBN = codiceNBN;
           this.urlOriginale = urlOriginale;
           this.dataInizioElab = dataInizioElab;
    }


    /**
     * Gets the software value for this WriteEventNBNOutputWriteEventNBN.
     * 
     * @return software
     */
    public it.depositolegale.www.writeEventNBNOutput.WriteEventNBNOutputWriteEventNBNSoftware getSoftware() {
        return software;
    }


    /**
     * Sets the software value for this WriteEventNBNOutputWriteEventNBN.
     * 
     * @param software
     */
    public void setSoftware(it.depositolegale.www.writeEventNBNOutput.WriteEventNBNOutputWriteEventNBNSoftware software) {
        this.software = software;
    }


    /**
     * Gets the codiceNBN value for this WriteEventNBNOutputWriteEventNBN.
     * 
     * @return codiceNBN
     */
    public java.lang.String getCodiceNBN() {
        return codiceNBN;
    }


    /**
     * Sets the codiceNBN value for this WriteEventNBNOutputWriteEventNBN.
     * 
     * @param codiceNBN
     */
    public void setCodiceNBN(java.lang.String codiceNBN) {
        this.codiceNBN = codiceNBN;
    }


    /**
     * Gets the urlOriginale value for this WriteEventNBNOutputWriteEventNBN.
     * 
     * @return urlOriginale
     */
    public java.lang.String getUrlOriginale() {
        return urlOriginale;
    }


    /**
     * Sets the urlOriginale value for this WriteEventNBNOutputWriteEventNBN.
     * 
     * @param urlOriginale
     */
    public void setUrlOriginale(java.lang.String urlOriginale) {
        this.urlOriginale = urlOriginale;
    }


    /**
     * Gets the dataInizioElab value for this WriteEventNBNOutputWriteEventNBN.
     * 
     * @return dataInizioElab
     */
    public java.util.Calendar getDataInizioElab() {
        return dataInizioElab;
    }


    /**
     * Sets the dataInizioElab value for this WriteEventNBNOutputWriteEventNBN.
     * 
     * @param dataInizioElab
     */
    public void setDataInizioElab(java.util.Calendar dataInizioElab) {
        this.dataInizioElab = dataInizioElab;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WriteEventNBNOutputWriteEventNBN)) return false;
        WriteEventNBNOutputWriteEventNBN other = (WriteEventNBNOutputWriteEventNBN) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.software==null && other.getSoftware()==null) || 
             (this.software!=null &&
              this.software.equals(other.getSoftware()))) &&
            ((this.codiceNBN==null && other.getCodiceNBN()==null) || 
             (this.codiceNBN!=null &&
              this.codiceNBN.equals(other.getCodiceNBN()))) &&
            ((this.urlOriginale==null && other.getUrlOriginale()==null) || 
             (this.urlOriginale!=null &&
              this.urlOriginale.equals(other.getUrlOriginale()))) &&
            ((this.dataInizioElab==null && other.getDataInizioElab()==null) || 
             (this.dataInizioElab!=null &&
              this.dataInizioElab.equals(other.getDataInizioElab())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getSoftware() != null) {
            _hashCode += getSoftware().hashCode();
        }
        if (getCodiceNBN() != null) {
            _hashCode += getCodiceNBN().hashCode();
        }
        if (getUrlOriginale() != null) {
            _hashCode += getUrlOriginale().hashCode();
        }
        if (getDataInizioElab() != null) {
            _hashCode += getDataInizioElab().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WriteEventNBNOutputWriteEventNBN.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/writeEventNBNOutput", ">>writeEventNBNOutput>writeEventNBN"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("software");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/writeEventNBNOutput", "software"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/writeEventNBNOutput", ">>>writeEventNBNOutput>writeEventNBN>software"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceNBN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/writeEventNBNOutput", "codiceNBN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlOriginale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/writeEventNBNOutput", "urlOriginale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataInizioElab");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/writeEventNBNOutput", "dataInizioElab"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
