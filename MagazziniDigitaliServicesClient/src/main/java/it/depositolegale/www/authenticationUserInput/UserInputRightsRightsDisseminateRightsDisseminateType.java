/**
 * UserInputRightsRightsDisseminateRightsDisseminateType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.depositolegale.www.authenticationUserInput;

public class UserInputRightsRightsDisseminateRightsDisseminateType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected UserInputRightsRightsDisseminateRightsDisseminateType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _A = "A";
    public static final java.lang.String _B = "B";
    public static final java.lang.String _C = "C";
    public static final java.lang.String _C1 = "C1";
    public static final java.lang.String _C2 = "C2";
    public static final UserInputRightsRightsDisseminateRightsDisseminateType A = new UserInputRightsRightsDisseminateRightsDisseminateType(_A);
    public static final UserInputRightsRightsDisseminateRightsDisseminateType B = new UserInputRightsRightsDisseminateRightsDisseminateType(_B);
    public static final UserInputRightsRightsDisseminateRightsDisseminateType C = new UserInputRightsRightsDisseminateRightsDisseminateType(_C);
    public static final UserInputRightsRightsDisseminateRightsDisseminateType C1 = new UserInputRightsRightsDisseminateRightsDisseminateType(_C1);
    public static final UserInputRightsRightsDisseminateRightsDisseminateType C2 = new UserInputRightsRightsDisseminateRightsDisseminateType(_C2);
    public java.lang.String getValue() { return _value_;}
    public static UserInputRightsRightsDisseminateRightsDisseminateType fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        UserInputRightsRightsDisseminateRightsDisseminateType enumeration = (UserInputRightsRightsDisseminateRightsDisseminateType)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static UserInputRightsRightsDisseminateRightsDisseminateType fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserInputRightsRightsDisseminateRightsDisseminateType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">>>userInput>rights>rightsDisseminate>rightsDisseminateType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
