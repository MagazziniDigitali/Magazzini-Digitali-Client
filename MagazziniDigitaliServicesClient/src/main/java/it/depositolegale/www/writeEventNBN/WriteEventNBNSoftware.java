/**
 * WriteEventNBNSoftware.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.depositolegale.www.writeEventNBN;

public class WriteEventNBNSoftware  implements java.io.Serializable {
    private it.depositolegale.www.writeEventNBN.WriteEventNBNSoftwareAuthentication authentication;

    private it.depositolegale.www.errorMsg.ErrorMsg[] errorMsg;

    private java.lang.String id;

    private java.lang.String nome;

    private it.depositolegale.www.writeEventNBN.WriteEventNBNSoftwareIstituzione istituzione;

    private it.depositolegale.www.writeEventNBN.WriteEventNBNSoftwareRigth rigth;

    private it.depositolegale.www.software.SoftwareConfig[] softwareConfig;

    public WriteEventNBNSoftware() {
    }

    public WriteEventNBNSoftware(
           it.depositolegale.www.writeEventNBN.WriteEventNBNSoftwareAuthentication authentication,
           it.depositolegale.www.errorMsg.ErrorMsg[] errorMsg,
           java.lang.String id,
           java.lang.String nome,
           it.depositolegale.www.writeEventNBN.WriteEventNBNSoftwareIstituzione istituzione,
           it.depositolegale.www.writeEventNBN.WriteEventNBNSoftwareRigth rigth,
           it.depositolegale.www.software.SoftwareConfig[] softwareConfig) {
           this.authentication = authentication;
           this.errorMsg = errorMsg;
           this.id = id;
           this.nome = nome;
           this.istituzione = istituzione;
           this.rigth = rigth;
           this.softwareConfig = softwareConfig;
    }


    /**
     * Gets the authentication value for this WriteEventNBNSoftware.
     * 
     * @return authentication
     */
    public it.depositolegale.www.writeEventNBN.WriteEventNBNSoftwareAuthentication getAuthentication() {
        return authentication;
    }


    /**
     * Sets the authentication value for this WriteEventNBNSoftware.
     * 
     * @param authentication
     */
    public void setAuthentication(it.depositolegale.www.writeEventNBN.WriteEventNBNSoftwareAuthentication authentication) {
        this.authentication = authentication;
    }


    /**
     * Gets the errorMsg value for this WriteEventNBNSoftware.
     * 
     * @return errorMsg
     */
    public it.depositolegale.www.errorMsg.ErrorMsg[] getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this WriteEventNBNSoftware.
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
     * Gets the id value for this WriteEventNBNSoftware.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this WriteEventNBNSoftware.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the nome value for this WriteEventNBNSoftware.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this WriteEventNBNSoftware.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the istituzione value for this WriteEventNBNSoftware.
     * 
     * @return istituzione
     */
    public it.depositolegale.www.writeEventNBN.WriteEventNBNSoftwareIstituzione getIstituzione() {
        return istituzione;
    }


    /**
     * Sets the istituzione value for this WriteEventNBNSoftware.
     * 
     * @param istituzione
     */
    public void setIstituzione(it.depositolegale.www.writeEventNBN.WriteEventNBNSoftwareIstituzione istituzione) {
        this.istituzione = istituzione;
    }


    /**
     * Gets the rigth value for this WriteEventNBNSoftware.
     * 
     * @return rigth
     */
    public it.depositolegale.www.writeEventNBN.WriteEventNBNSoftwareRigth getRigth() {
        return rigth;
    }


    /**
     * Sets the rigth value for this WriteEventNBNSoftware.
     * 
     * @param rigth
     */
    public void setRigth(it.depositolegale.www.writeEventNBN.WriteEventNBNSoftwareRigth rigth) {
        this.rigth = rigth;
    }


    /**
     * Gets the softwareConfig value for this WriteEventNBNSoftware.
     * 
     * @return softwareConfig
     */
    public it.depositolegale.www.software.SoftwareConfig[] getSoftwareConfig() {
        return softwareConfig;
    }


    /**
     * Sets the softwareConfig value for this WriteEventNBNSoftware.
     * 
     * @param softwareConfig
     */
    public void setSoftwareConfig(it.depositolegale.www.software.SoftwareConfig[] softwareConfig) {
        this.softwareConfig = softwareConfig;
    }

    public it.depositolegale.www.software.SoftwareConfig getSoftwareConfig(int i) {
        return this.softwareConfig[i];
    }

    public void setSoftwareConfig(int i, it.depositolegale.www.software.SoftwareConfig _value) {
        this.softwareConfig[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WriteEventNBNSoftware)) return false;
        WriteEventNBNSoftware other = (WriteEventNBNSoftware) obj;
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
            ((this.errorMsg==null && other.getErrorMsg()==null) || 
             (this.errorMsg!=null &&
              java.util.Arrays.equals(this.errorMsg, other.getErrorMsg()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.istituzione==null && other.getIstituzione()==null) || 
             (this.istituzione!=null &&
              this.istituzione.equals(other.getIstituzione()))) &&
            ((this.rigth==null && other.getRigth()==null) || 
             (this.rigth!=null &&
              this.rigth.equals(other.getRigth()))) &&
            ((this.softwareConfig==null && other.getSoftwareConfig()==null) || 
             (this.softwareConfig!=null &&
              java.util.Arrays.equals(this.softwareConfig, other.getSoftwareConfig())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getIstituzione() != null) {
            _hashCode += getIstituzione().hashCode();
        }
        if (getRigth() != null) {
            _hashCode += getRigth().hashCode();
        }
        if (getSoftwareConfig() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSoftwareConfig());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSoftwareConfig(), i);
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
        new org.apache.axis.description.TypeDesc(WriteEventNBNSoftware.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/writeEventNBN", ">>writeEventNBN>software"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authentication");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/writeEventNBN", "authentication"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/writeEventNBN", ">>>writeEventNBN>software>authentication"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/writeEventNBN", "errorMsg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/errorMsg", "errorMsg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/writeEventNBN", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/writeEventNBN", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("istituzione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/writeEventNBN", "istituzione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/writeEventNBN", ">>>writeEventNBN>software>istituzione"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rigth");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/writeEventNBN", "rigth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/writeEventNBN", ">>>writeEventNBN>software>rigth"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softwareConfig");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/writeEventNBN", "softwareConfig"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/software", "softwareConfig"));
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
