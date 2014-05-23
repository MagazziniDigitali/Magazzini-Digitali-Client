/**
 * EndSendReadInfoOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.depositolegale.www.endSend;

public class EndSendReadInfoOutput  implements java.io.Serializable {
    private it.depositolegale.www.endSend.EndSendReadInfoOutputIstituto istituto;

    private it.depositolegale.www.endSend.EndSendReadInfoOutputOggettoDigitale oggettoDigitale;

    private it.depositolegale.www.readInfoOutput.Errori[] errori;

    private it.depositolegale.www.readInfoOutput.Warning[] warning;

    private it.depositolegale.www.readInfoOutput.Info[] info;

    public EndSendReadInfoOutput() {
    }

    public EndSendReadInfoOutput(
           it.depositolegale.www.endSend.EndSendReadInfoOutputIstituto istituto,
           it.depositolegale.www.endSend.EndSendReadInfoOutputOggettoDigitale oggettoDigitale,
           it.depositolegale.www.readInfoOutput.Errori[] errori,
           it.depositolegale.www.readInfoOutput.Warning[] warning,
           it.depositolegale.www.readInfoOutput.Info[] info) {
           this.istituto = istituto;
           this.oggettoDigitale = oggettoDigitale;
           this.errori = errori;
           this.warning = warning;
           this.info = info;
    }


    /**
     * Gets the istituto value for this EndSendReadInfoOutput.
     * 
     * @return istituto
     */
    public it.depositolegale.www.endSend.EndSendReadInfoOutputIstituto getIstituto() {
        return istituto;
    }


    /**
     * Sets the istituto value for this EndSendReadInfoOutput.
     * 
     * @param istituto
     */
    public void setIstituto(it.depositolegale.www.endSend.EndSendReadInfoOutputIstituto istituto) {
        this.istituto = istituto;
    }


    /**
     * Gets the oggettoDigitale value for this EndSendReadInfoOutput.
     * 
     * @return oggettoDigitale
     */
    public it.depositolegale.www.endSend.EndSendReadInfoOutputOggettoDigitale getOggettoDigitale() {
        return oggettoDigitale;
    }


    /**
     * Sets the oggettoDigitale value for this EndSendReadInfoOutput.
     * 
     * @param oggettoDigitale
     */
    public void setOggettoDigitale(it.depositolegale.www.endSend.EndSendReadInfoOutputOggettoDigitale oggettoDigitale) {
        this.oggettoDigitale = oggettoDigitale;
    }


    /**
     * Gets the errori value for this EndSendReadInfoOutput.
     * 
     * @return errori
     */
    public it.depositolegale.www.readInfoOutput.Errori[] getErrori() {
        return errori;
    }


    /**
     * Sets the errori value for this EndSendReadInfoOutput.
     * 
     * @param errori
     */
    public void setErrori(it.depositolegale.www.readInfoOutput.Errori[] errori) {
        this.errori = errori;
    }

    public it.depositolegale.www.readInfoOutput.Errori getErrori(int i) {
        return this.errori[i];
    }

    public void setErrori(int i, it.depositolegale.www.readInfoOutput.Errori _value) {
        this.errori[i] = _value;
    }


    /**
     * Gets the warning value for this EndSendReadInfoOutput.
     * 
     * @return warning
     */
    public it.depositolegale.www.readInfoOutput.Warning[] getWarning() {
        return warning;
    }


    /**
     * Sets the warning value for this EndSendReadInfoOutput.
     * 
     * @param warning
     */
    public void setWarning(it.depositolegale.www.readInfoOutput.Warning[] warning) {
        this.warning = warning;
    }

    public it.depositolegale.www.readInfoOutput.Warning getWarning(int i) {
        return this.warning[i];
    }

    public void setWarning(int i, it.depositolegale.www.readInfoOutput.Warning _value) {
        this.warning[i] = _value;
    }


    /**
     * Gets the info value for this EndSendReadInfoOutput.
     * 
     * @return info
     */
    public it.depositolegale.www.readInfoOutput.Info[] getInfo() {
        return info;
    }


    /**
     * Sets the info value for this EndSendReadInfoOutput.
     * 
     * @param info
     */
    public void setInfo(it.depositolegale.www.readInfoOutput.Info[] info) {
        this.info = info;
    }

    public it.depositolegale.www.readInfoOutput.Info getInfo(int i) {
        return this.info[i];
    }

    public void setInfo(int i, it.depositolegale.www.readInfoOutput.Info _value) {
        this.info[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EndSendReadInfoOutput)) return false;
        EndSendReadInfoOutput other = (EndSendReadInfoOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.istituto==null && other.getIstituto()==null) || 
             (this.istituto!=null &&
              this.istituto.equals(other.getIstituto()))) &&
            ((this.oggettoDigitale==null && other.getOggettoDigitale()==null) || 
             (this.oggettoDigitale!=null &&
              this.oggettoDigitale.equals(other.getOggettoDigitale()))) &&
            ((this.errori==null && other.getErrori()==null) || 
             (this.errori!=null &&
              java.util.Arrays.equals(this.errori, other.getErrori()))) &&
            ((this.warning==null && other.getWarning()==null) || 
             (this.warning!=null &&
              java.util.Arrays.equals(this.warning, other.getWarning()))) &&
            ((this.info==null && other.getInfo()==null) || 
             (this.info!=null &&
              java.util.Arrays.equals(this.info, other.getInfo())));
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
        if (getIstituto() != null) {
            _hashCode += getIstituto().hashCode();
        }
        if (getOggettoDigitale() != null) {
            _hashCode += getOggettoDigitale().hashCode();
        }
        if (getErrori() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getErrori());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getErrori(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getWarning() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWarning());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWarning(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInfo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EndSendReadInfoOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/endSend", ">>endSend>readInfoOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("istituto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/endSend", "istituto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/endSend", ">>>endSend>readInfoOutput>istituto"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oggettoDigitale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/endSend", "oggettoDigitale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/endSend", ">>>endSend>readInfoOutput>oggettoDigitale"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errori");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/endSend", "errori"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/readInfoOutput", "errori"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("warning");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/endSend", "warning"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/readInfoOutput", "warning"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("info");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/endSend", "info"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/readInfoOutput", "info"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
