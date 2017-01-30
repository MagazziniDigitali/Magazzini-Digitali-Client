/**
 * UserInputRights.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.depositolegale.www.authenticationUserInput;

public class UserInputRights  implements java.io.Serializable {
    private it.depositolegale.www.authenticationUserInput.UserInputRightsRightsIdentifier rightsIdentifier;

    private it.depositolegale.www.authenticationUserInput.UserInputRightsRightsDisseminate rightsDisseminate;

    public UserInputRights() {
    }

    public UserInputRights(
           it.depositolegale.www.authenticationUserInput.UserInputRightsRightsIdentifier rightsIdentifier,
           it.depositolegale.www.authenticationUserInput.UserInputRightsRightsDisseminate rightsDisseminate) {
           this.rightsIdentifier = rightsIdentifier;
           this.rightsDisseminate = rightsDisseminate;
    }


    /**
     * Gets the rightsIdentifier value for this UserInputRights.
     * 
     * @return rightsIdentifier
     */
    public it.depositolegale.www.authenticationUserInput.UserInputRightsRightsIdentifier getRightsIdentifier() {
        return rightsIdentifier;
    }


    /**
     * Sets the rightsIdentifier value for this UserInputRights.
     * 
     * @param rightsIdentifier
     */
    public void setRightsIdentifier(it.depositolegale.www.authenticationUserInput.UserInputRightsRightsIdentifier rightsIdentifier) {
        this.rightsIdentifier = rightsIdentifier;
    }


    /**
     * Gets the rightsDisseminate value for this UserInputRights.
     * 
     * @return rightsDisseminate
     */
    public it.depositolegale.www.authenticationUserInput.UserInputRightsRightsDisseminate getRightsDisseminate() {
        return rightsDisseminate;
    }


    /**
     * Sets the rightsDisseminate value for this UserInputRights.
     * 
     * @param rightsDisseminate
     */
    public void setRightsDisseminate(it.depositolegale.www.authenticationUserInput.UserInputRightsRightsDisseminate rightsDisseminate) {
        this.rightsDisseminate = rightsDisseminate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserInputRights)) return false;
        UserInputRights other = (UserInputRights) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.rightsIdentifier==null && other.getRightsIdentifier()==null) || 
             (this.rightsIdentifier!=null &&
              this.rightsIdentifier.equals(other.getRightsIdentifier()))) &&
            ((this.rightsDisseminate==null && other.getRightsDisseminate()==null) || 
             (this.rightsDisseminate!=null &&
              this.rightsDisseminate.equals(other.getRightsDisseminate())));
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
        if (getRightsIdentifier() != null) {
            _hashCode += getRightsIdentifier().hashCode();
        }
        if (getRightsDisseminate() != null) {
            _hashCode += getRightsDisseminate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserInputRights.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">userInput>rights"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rightsIdentifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", "rightsIdentifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">>userInput>rights>rightsIdentifier"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rightsDisseminate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", "rightsDisseminate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">>userInput>rights>rightsDisseminate"));
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
