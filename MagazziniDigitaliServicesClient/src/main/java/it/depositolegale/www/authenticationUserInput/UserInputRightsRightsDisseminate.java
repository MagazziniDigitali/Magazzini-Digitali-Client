/**
 * UserInputRightsRightsDisseminate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.depositolegale.www.authenticationUserInput;

public class UserInputRightsRightsDisseminate  implements java.io.Serializable {
    private it.depositolegale.www.authenticationUserInput.UserInputRightsRightsDisseminateRightsDisseminateType rightsDisseminateType;

    public UserInputRightsRightsDisseminate() {
    }

    public UserInputRightsRightsDisseminate(
           it.depositolegale.www.authenticationUserInput.UserInputRightsRightsDisseminateRightsDisseminateType rightsDisseminateType) {
           this.rightsDisseminateType = rightsDisseminateType;
    }


    /**
     * Gets the rightsDisseminateType value for this UserInputRightsRightsDisseminate.
     * 
     * @return rightsDisseminateType
     */
    public it.depositolegale.www.authenticationUserInput.UserInputRightsRightsDisseminateRightsDisseminateType getRightsDisseminateType() {
        return rightsDisseminateType;
    }


    /**
     * Sets the rightsDisseminateType value for this UserInputRightsRightsDisseminate.
     * 
     * @param rightsDisseminateType
     */
    public void setRightsDisseminateType(it.depositolegale.www.authenticationUserInput.UserInputRightsRightsDisseminateRightsDisseminateType rightsDisseminateType) {
        this.rightsDisseminateType = rightsDisseminateType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserInputRightsRightsDisseminate)) return false;
        UserInputRightsRightsDisseminate other = (UserInputRightsRightsDisseminate) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.rightsDisseminateType==null && other.getRightsDisseminateType()==null) || 
             (this.rightsDisseminateType!=null &&
              this.rightsDisseminateType.equals(other.getRightsDisseminateType())));
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
        if (getRightsDisseminateType() != null) {
            _hashCode += getRightsDisseminateType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserInputRightsRightsDisseminate.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">>userInput>rights>rightsDisseminate"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rightsDisseminateType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", "rightsDisseminateType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">>>userInput>rights>rightsDisseminate>rightsDisseminateType"));
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
