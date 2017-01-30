/**
 * UserInput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.depositolegale.www.authenticationUserInput;

public class UserInput  implements java.io.Serializable {
    private it.depositolegale.www.authenticationUserInput.UserInputObjectIdentifier objectIdentifier;

    private it.depositolegale.www.authenticationUserInput.UserInputSoftware software;

    private java.lang.String ipClient;

    private java.lang.String identifier;

    private java.lang.String actualFileName;

    private java.lang.String originalFileName;

    private it.depositolegale.www.authenticationUserInput.UserInputAgent agent;

    private it.depositolegale.www.authenticationUserInput.UserInputRights rights;

    private it.depositolegale.www.authenticationUserInput.UserInputAuthentication authentication;

    public UserInput() {
    }

    public UserInput(
           it.depositolegale.www.authenticationUserInput.UserInputObjectIdentifier objectIdentifier,
           it.depositolegale.www.authenticationUserInput.UserInputSoftware software,
           java.lang.String ipClient,
           java.lang.String identifier,
           java.lang.String actualFileName,
           java.lang.String originalFileName,
           it.depositolegale.www.authenticationUserInput.UserInputAgent agent,
           it.depositolegale.www.authenticationUserInput.UserInputRights rights,
           it.depositolegale.www.authenticationUserInput.UserInputAuthentication authentication) {
           this.objectIdentifier = objectIdentifier;
           this.software = software;
           this.ipClient = ipClient;
           this.identifier = identifier;
           this.actualFileName = actualFileName;
           this.originalFileName = originalFileName;
           this.agent = agent;
           this.rights = rights;
           this.authentication = authentication;
    }


    /**
     * Gets the objectIdentifier value for this UserInput.
     * 
     * @return objectIdentifier
     */
    public it.depositolegale.www.authenticationUserInput.UserInputObjectIdentifier getObjectIdentifier() {
        return objectIdentifier;
    }


    /**
     * Sets the objectIdentifier value for this UserInput.
     * 
     * @param objectIdentifier
     */
    public void setObjectIdentifier(it.depositolegale.www.authenticationUserInput.UserInputObjectIdentifier objectIdentifier) {
        this.objectIdentifier = objectIdentifier;
    }


    /**
     * Gets the software value for this UserInput.
     * 
     * @return software
     */
    public it.depositolegale.www.authenticationUserInput.UserInputSoftware getSoftware() {
        return software;
    }


    /**
     * Sets the software value for this UserInput.
     * 
     * @param software
     */
    public void setSoftware(it.depositolegale.www.authenticationUserInput.UserInputSoftware software) {
        this.software = software;
    }


    /**
     * Gets the ipClient value for this UserInput.
     * 
     * @return ipClient
     */
    public java.lang.String getIpClient() {
        return ipClient;
    }


    /**
     * Sets the ipClient value for this UserInput.
     * 
     * @param ipClient
     */
    public void setIpClient(java.lang.String ipClient) {
        this.ipClient = ipClient;
    }


    /**
     * Gets the identifier value for this UserInput.
     * 
     * @return identifier
     */
    public java.lang.String getIdentifier() {
        return identifier;
    }


    /**
     * Sets the identifier value for this UserInput.
     * 
     * @param identifier
     */
    public void setIdentifier(java.lang.String identifier) {
        this.identifier = identifier;
    }


    /**
     * Gets the actualFileName value for this UserInput.
     * 
     * @return actualFileName
     */
    public java.lang.String getActualFileName() {
        return actualFileName;
    }


    /**
     * Sets the actualFileName value for this UserInput.
     * 
     * @param actualFileName
     */
    public void setActualFileName(java.lang.String actualFileName) {
        this.actualFileName = actualFileName;
    }


    /**
     * Gets the originalFileName value for this UserInput.
     * 
     * @return originalFileName
     */
    public java.lang.String getOriginalFileName() {
        return originalFileName;
    }


    /**
     * Sets the originalFileName value for this UserInput.
     * 
     * @param originalFileName
     */
    public void setOriginalFileName(java.lang.String originalFileName) {
        this.originalFileName = originalFileName;
    }


    /**
     * Gets the agent value for this UserInput.
     * 
     * @return agent
     */
    public it.depositolegale.www.authenticationUserInput.UserInputAgent getAgent() {
        return agent;
    }


    /**
     * Sets the agent value for this UserInput.
     * 
     * @param agent
     */
    public void setAgent(it.depositolegale.www.authenticationUserInput.UserInputAgent agent) {
        this.agent = agent;
    }


    /**
     * Gets the rights value for this UserInput.
     * 
     * @return rights
     */
    public it.depositolegale.www.authenticationUserInput.UserInputRights getRights() {
        return rights;
    }


    /**
     * Sets the rights value for this UserInput.
     * 
     * @param rights
     */
    public void setRights(it.depositolegale.www.authenticationUserInput.UserInputRights rights) {
        this.rights = rights;
    }


    /**
     * Gets the authentication value for this UserInput.
     * 
     * @return authentication
     */
    public it.depositolegale.www.authenticationUserInput.UserInputAuthentication getAuthentication() {
        return authentication;
    }


    /**
     * Sets the authentication value for this UserInput.
     * 
     * @param authentication
     */
    public void setAuthentication(it.depositolegale.www.authenticationUserInput.UserInputAuthentication authentication) {
        this.authentication = authentication;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserInput)) return false;
        UserInput other = (UserInput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.objectIdentifier==null && other.getObjectIdentifier()==null) || 
             (this.objectIdentifier!=null &&
              this.objectIdentifier.equals(other.getObjectIdentifier()))) &&
            ((this.software==null && other.getSoftware()==null) || 
             (this.software!=null &&
              this.software.equals(other.getSoftware()))) &&
            ((this.ipClient==null && other.getIpClient()==null) || 
             (this.ipClient!=null &&
              this.ipClient.equals(other.getIpClient()))) &&
            ((this.identifier==null && other.getIdentifier()==null) || 
             (this.identifier!=null &&
              this.identifier.equals(other.getIdentifier()))) &&
            ((this.actualFileName==null && other.getActualFileName()==null) || 
             (this.actualFileName!=null &&
              this.actualFileName.equals(other.getActualFileName()))) &&
            ((this.originalFileName==null && other.getOriginalFileName()==null) || 
             (this.originalFileName!=null &&
              this.originalFileName.equals(other.getOriginalFileName()))) &&
            ((this.agent==null && other.getAgent()==null) || 
             (this.agent!=null &&
              this.agent.equals(other.getAgent()))) &&
            ((this.rights==null && other.getRights()==null) || 
             (this.rights!=null &&
              this.rights.equals(other.getRights()))) &&
            ((this.authentication==null && other.getAuthentication()==null) || 
             (this.authentication!=null &&
              this.authentication.equals(other.getAuthentication())));
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
        if (getObjectIdentifier() != null) {
            _hashCode += getObjectIdentifier().hashCode();
        }
        if (getSoftware() != null) {
            _hashCode += getSoftware().hashCode();
        }
        if (getIpClient() != null) {
            _hashCode += getIpClient().hashCode();
        }
        if (getIdentifier() != null) {
            _hashCode += getIdentifier().hashCode();
        }
        if (getActualFileName() != null) {
            _hashCode += getActualFileName().hashCode();
        }
        if (getOriginalFileName() != null) {
            _hashCode += getOriginalFileName().hashCode();
        }
        if (getAgent() != null) {
            _hashCode += getAgent().hashCode();
        }
        if (getRights() != null) {
            _hashCode += getRights().hashCode();
        }
        if (getAuthentication() != null) {
            _hashCode += getAuthentication().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserInput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", "userInput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectIdentifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", "objectIdentifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">userInput>objectIdentifier"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("software");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", "software"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">userInput>software"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ipClient");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", "ipClient"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", "identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actualFileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", "actualFileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalFileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", "originalFileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", "agent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">userInput>agent"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rights");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", "rights"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">userInput>rights"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authentication");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", "authentication"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">userInput>authentication"));
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
