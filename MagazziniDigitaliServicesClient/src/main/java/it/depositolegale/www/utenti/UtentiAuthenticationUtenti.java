/**
 * UtentiAuthenticationUtenti.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.depositolegale.www.utenti;

public class UtentiAuthenticationUtenti  implements java.io.Serializable {
    private it.depositolegale.www.utenti.UtentiAuthenticationUtentiAuthentication authentication;

    private java.lang.String ipClient;

    private it.depositolegale.www.utenti.UtentiAuthenticationUtentiSoftware software;

    public UtentiAuthenticationUtenti() {
    }

    public UtentiAuthenticationUtenti(
           it.depositolegale.www.utenti.UtentiAuthenticationUtentiAuthentication authentication,
           java.lang.String ipClient,
           it.depositolegale.www.utenti.UtentiAuthenticationUtentiSoftware software) {
           this.authentication = authentication;
           this.ipClient = ipClient;
           this.software = software;
    }


    /**
     * Gets the authentication value for this UtentiAuthenticationUtenti.
     * 
     * @return authentication
     */
    public it.depositolegale.www.utenti.UtentiAuthenticationUtentiAuthentication getAuthentication() {
        return authentication;
    }


    /**
     * Sets the authentication value for this UtentiAuthenticationUtenti.
     * 
     * @param authentication
     */
    public void setAuthentication(it.depositolegale.www.utenti.UtentiAuthenticationUtentiAuthentication authentication) {
        this.authentication = authentication;
    }


    /**
     * Gets the ipClient value for this UtentiAuthenticationUtenti.
     * 
     * @return ipClient
     */
    public java.lang.String getIpClient() {
        return ipClient;
    }


    /**
     * Sets the ipClient value for this UtentiAuthenticationUtenti.
     * 
     * @param ipClient
     */
    public void setIpClient(java.lang.String ipClient) {
        this.ipClient = ipClient;
    }


    /**
     * Gets the software value for this UtentiAuthenticationUtenti.
     * 
     * @return software
     */
    public it.depositolegale.www.utenti.UtentiAuthenticationUtentiSoftware getSoftware() {
        return software;
    }


    /**
     * Sets the software value for this UtentiAuthenticationUtenti.
     * 
     * @param software
     */
    public void setSoftware(it.depositolegale.www.utenti.UtentiAuthenticationUtentiSoftware software) {
        this.software = software;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UtentiAuthenticationUtenti)) return false;
        UtentiAuthenticationUtenti other = (UtentiAuthenticationUtenti) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.authentication==null && other.getAuthentication()==null) || 
             (this.authentication!=null &&
              this.authentication.equals(other.getAuthentication()))) &&
            ((this.ipClient==null && other.getIpClient()==null) || 
             (this.ipClient!=null &&
              this.ipClient.equals(other.getIpClient()))) &&
            ((this.software==null && other.getSoftware()==null) || 
             (this.software!=null &&
              this.software.equals(other.getSoftware())));
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
        if (getAuthentication() != null) {
            _hashCode += getAuthentication().hashCode();
        }
        if (getIpClient() != null) {
            _hashCode += getIpClient().hashCode();
        }
        if (getSoftware() != null) {
            _hashCode += getSoftware().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UtentiAuthenticationUtenti.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", ">>utenti>authenticationUtenti"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authentication");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", "authentication"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", ">>>utenti>authenticationUtenti>authentication"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ipClient");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", "ipClient"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("software");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", "software"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", ">>>utenti>authenticationUtenti>software"));
        elemField.setNillable(true);
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
