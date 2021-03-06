/**
 * Utenti.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.depositolegale.www.utenti;

public class Utenti  implements java.io.Serializable {
    private it.depositolegale.www.utenti.UtentiAuthenticationUtenti authenticationUtenti;

    private it.depositolegale.www.errorMsg.ErrorMsg[] errorMsg;

    private it.depositolegale.www.utenti.UtentiDatiUtente datiUtente;

    public Utenti() {
    }

    public Utenti(
           it.depositolegale.www.utenti.UtentiAuthenticationUtenti authenticationUtenti,
           it.depositolegale.www.errorMsg.ErrorMsg[] errorMsg,
           it.depositolegale.www.utenti.UtentiDatiUtente datiUtente) {
           this.authenticationUtenti = authenticationUtenti;
           this.errorMsg = errorMsg;
           this.datiUtente = datiUtente;
    }


    /**
     * Gets the authenticationUtenti value for this Utenti.
     * 
     * @return authenticationUtenti
     */
    public it.depositolegale.www.utenti.UtentiAuthenticationUtenti getAuthenticationUtenti() {
        return authenticationUtenti;
    }


    /**
     * Sets the authenticationUtenti value for this Utenti.
     * 
     * @param authenticationUtenti
     */
    public void setAuthenticationUtenti(it.depositolegale.www.utenti.UtentiAuthenticationUtenti authenticationUtenti) {
        this.authenticationUtenti = authenticationUtenti;
    }


    /**
     * Gets the errorMsg value for this Utenti.
     * 
     * @return errorMsg
     */
    public it.depositolegale.www.errorMsg.ErrorMsg[] getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this Utenti.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(it.depositolegale.www.errorMsg.ErrorMsg[] errorMsg) {
        this.errorMsg = errorMsg;
    }

    public it.depositolegale.www.errorMsg.ErrorMsg getErrorMsg(int i) {
        return this.errorMsg[i];
    }

    public void setErrorMsg(int i, it.depositolegale.www.errorMsg.ErrorMsg _value) {
        this.errorMsg[i] = _value;
    }


    /**
     * Gets the datiUtente value for this Utenti.
     * 
     * @return datiUtente
     */
    public it.depositolegale.www.utenti.UtentiDatiUtente getDatiUtente() {
        return datiUtente;
    }


    /**
     * Sets the datiUtente value for this Utenti.
     * 
     * @param datiUtente
     */
    public void setDatiUtente(it.depositolegale.www.utenti.UtentiDatiUtente datiUtente) {
        this.datiUtente = datiUtente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Utenti)) return false;
        Utenti other = (Utenti) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.authenticationUtenti==null && other.getAuthenticationUtenti()==null) || 
             (this.authenticationUtenti!=null &&
              this.authenticationUtenti.equals(other.getAuthenticationUtenti()))) &&
            ((this.errorMsg==null && other.getErrorMsg()==null) || 
             (this.errorMsg!=null &&
              java.util.Arrays.equals(this.errorMsg, other.getErrorMsg()))) &&
            ((this.datiUtente==null && other.getDatiUtente()==null) || 
             (this.datiUtente!=null &&
              this.datiUtente.equals(other.getDatiUtente())));
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
        if (getAuthenticationUtenti() != null) {
            _hashCode += getAuthenticationUtenti().hashCode();
        }
        if (getErrorMsg() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getErrorMsg());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getErrorMsg(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDatiUtente() != null) {
            _hashCode += getDatiUtente().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Utenti.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", ">utenti"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authenticationUtenti");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", "authenticationUtenti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", ">>utenti>authenticationUtenti"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", "errorMsg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/errorMsg", "errorMsg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datiUtente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", "datiUtente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", ">>utenti>datiUtente"));
        elemField.setMinOccurs(0);
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
