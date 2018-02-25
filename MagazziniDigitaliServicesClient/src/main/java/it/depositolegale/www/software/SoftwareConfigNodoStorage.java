/**
 * SoftwareConfigNodoStorage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.depositolegale.www.software;

public class SoftwareConfigNodoStorage  implements java.io.Serializable {
    private java.lang.String fileSystem;

    private it.depositolegale.www.software.SoftwareConfigNodoStorageRsync rsync;

    private it.depositolegale.www.software.SoftwareConfigNodoStorageS3 s3;

    private it.depositolegale.www.software.SoftwareConfigNodoStorageTipo tipo;  // attribute

    public SoftwareConfigNodoStorage() {
    }

    public SoftwareConfigNodoStorage(
           java.lang.String fileSystem,
           it.depositolegale.www.software.SoftwareConfigNodoStorageRsync rsync,
           it.depositolegale.www.software.SoftwareConfigNodoStorageS3 s3,
           it.depositolegale.www.software.SoftwareConfigNodoStorageTipo tipo) {
           this.fileSystem = fileSystem;
           this.rsync = rsync;
           this.s3 = s3;
           this.tipo = tipo;
    }


    /**
     * Gets the fileSystem value for this SoftwareConfigNodoStorage.
     * 
     * @return fileSystem
     */
    public java.lang.String getFileSystem() {
        return fileSystem;
    }


    /**
     * Sets the fileSystem value for this SoftwareConfigNodoStorage.
     * 
     * @param fileSystem
     */
    public void setFileSystem(java.lang.String fileSystem) {
        this.fileSystem = fileSystem;
    }


    /**
     * Gets the rsync value for this SoftwareConfigNodoStorage.
     * 
     * @return rsync
     */
    public it.depositolegale.www.software.SoftwareConfigNodoStorageRsync getRsync() {
        return rsync;
    }


    /**
     * Sets the rsync value for this SoftwareConfigNodoStorage.
     * 
     * @param rsync
     */
    public void setRsync(it.depositolegale.www.software.SoftwareConfigNodoStorageRsync rsync) {
        this.rsync = rsync;
    }


    /**
     * Gets the s3 value for this SoftwareConfigNodoStorage.
     * 
     * @return s3
     */
    public it.depositolegale.www.software.SoftwareConfigNodoStorageS3 getS3() {
        return s3;
    }


    /**
     * Sets the s3 value for this SoftwareConfigNodoStorage.
     * 
     * @param s3
     */
    public void setS3(it.depositolegale.www.software.SoftwareConfigNodoStorageS3 s3) {
        this.s3 = s3;
    }


    /**
     * Gets the tipo value for this SoftwareConfigNodoStorage.
     * 
     * @return tipo
     */
    public it.depositolegale.www.software.SoftwareConfigNodoStorageTipo getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this SoftwareConfigNodoStorage.
     * 
     * @param tipo
     */
    public void setTipo(it.depositolegale.www.software.SoftwareConfigNodoStorageTipo tipo) {
        this.tipo = tipo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SoftwareConfigNodoStorage)) return false;
        SoftwareConfigNodoStorage other = (SoftwareConfigNodoStorage) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fileSystem==null && other.getFileSystem()==null) || 
             (this.fileSystem!=null &&
              this.fileSystem.equals(other.getFileSystem()))) &&
            ((this.rsync==null && other.getRsync()==null) || 
             (this.rsync!=null &&
              this.rsync.equals(other.getRsync()))) &&
            ((this.s3==null && other.getS3()==null) || 
             (this.s3!=null &&
              this.s3.equals(other.getS3()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo())));
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
        if (getFileSystem() != null) {
            _hashCode += getFileSystem().hashCode();
        }
        if (getRsync() != null) {
            _hashCode += getRsync().hashCode();
        }
        if (getS3() != null) {
            _hashCode += getS3().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoftwareConfigNodoStorage.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/software", ">>softwareConfig>nodo>storage"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("tipo");
        attrField.setXmlName(new javax.xml.namespace.QName("", "tipo"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/software", ">>>softwareConfig>nodo>storage>tipo"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileSystem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/software", "fileSystem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rsync");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/software", "rsync"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/software", ">>>softwareConfig>nodo>storage>rsync"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/software", "s3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/software", ">>>softwareConfig>nodo>storage>s3"));
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
