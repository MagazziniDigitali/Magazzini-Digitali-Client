/**
 * UtentiDatiUtenteIstituzione.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.depositolegale.www.utenti;

public class UtentiDatiUtenteIstituzione  implements java.io.Serializable {
    private java.lang.String id;

    private java.lang.String nome;

    private java.lang.String indirizzo;

    private java.lang.String telefono;

    private java.lang.String nomeContatto;

    private java.math.BigInteger bibliotecaDepositaria;

    private java.math.BigInteger istitutoCentrale;

    private java.lang.String[] ipAccreditati;

    private it.depositolegale.www.utenti.UtentiDatiUtenteIstituzioneApiUtente apiUtente;

    private java.lang.String emailBagit;

    public UtentiDatiUtenteIstituzione() {
    }

    public UtentiDatiUtenteIstituzione(
           java.lang.String id,
           java.lang.String nome,
           java.lang.String indirizzo,
           java.lang.String telefono,
           java.lang.String nomeContatto,
           java.math.BigInteger bibliotecaDepositaria,
           java.math.BigInteger istitutoCentrale,
           java.lang.String[] ipAccreditati,
           it.depositolegale.www.utenti.UtentiDatiUtenteIstituzioneApiUtente apiUtente,
           java.lang.String emailBagit) {
           this.id = id;
           this.nome = nome;
           this.indirizzo = indirizzo;
           this.telefono = telefono;
           this.nomeContatto = nomeContatto;
           this.bibliotecaDepositaria = bibliotecaDepositaria;
           this.istitutoCentrale = istitutoCentrale;
           this.ipAccreditati = ipAccreditati;
           this.apiUtente = apiUtente;
           this.emailBagit = emailBagit;
    }


    /**
     * Gets the id value for this UtentiDatiUtenteIstituzione.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this UtentiDatiUtenteIstituzione.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the nome value for this UtentiDatiUtenteIstituzione.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this UtentiDatiUtenteIstituzione.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the indirizzo value for this UtentiDatiUtenteIstituzione.
     * 
     * @return indirizzo
     */
    public java.lang.String getIndirizzo() {
        return indirizzo;
    }


    /**
     * Sets the indirizzo value for this UtentiDatiUtenteIstituzione.
     * 
     * @param indirizzo
     */
    public void setIndirizzo(java.lang.String indirizzo) {
        this.indirizzo = indirizzo;
    }


    /**
     * Gets the telefono value for this UtentiDatiUtenteIstituzione.
     * 
     * @return telefono
     */
    public java.lang.String getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this UtentiDatiUtenteIstituzione.
     * 
     * @param telefono
     */
    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }


    /**
     * Gets the nomeContatto value for this UtentiDatiUtenteIstituzione.
     * 
     * @return nomeContatto
     */
    public java.lang.String getNomeContatto() {
        return nomeContatto;
    }


    /**
     * Sets the nomeContatto value for this UtentiDatiUtenteIstituzione.
     * 
     * @param nomeContatto
     */
    public void setNomeContatto(java.lang.String nomeContatto) {
        this.nomeContatto = nomeContatto;
    }


    /**
     * Gets the bibliotecaDepositaria value for this UtentiDatiUtenteIstituzione.
     * 
     * @return bibliotecaDepositaria
     */
    public java.math.BigInteger getBibliotecaDepositaria() {
        return bibliotecaDepositaria;
    }


    /**
     * Sets the bibliotecaDepositaria value for this UtentiDatiUtenteIstituzione.
     * 
     * @param bibliotecaDepositaria
     */
    public void setBibliotecaDepositaria(java.math.BigInteger bibliotecaDepositaria) {
        this.bibliotecaDepositaria = bibliotecaDepositaria;
    }


    /**
     * Gets the istitutoCentrale value for this UtentiDatiUtenteIstituzione.
     * 
     * @return istitutoCentrale
     */
    public java.math.BigInteger getIstitutoCentrale() {
        return istitutoCentrale;
    }


    /**
     * Sets the istitutoCentrale value for this UtentiDatiUtenteIstituzione.
     * 
     * @param istitutoCentrale
     */
    public void setIstitutoCentrale(java.math.BigInteger istitutoCentrale) {
        this.istitutoCentrale = istitutoCentrale;
    }


    /**
     * Gets the ipAccreditati value for this UtentiDatiUtenteIstituzione.
     * 
     * @return ipAccreditati
     */
    public java.lang.String[] getIpAccreditati() {
        return ipAccreditati;
    }


    /**
     * Sets the ipAccreditati value for this UtentiDatiUtenteIstituzione.
     * 
     * @param ipAccreditati
     */
    public void setIpAccreditati(java.lang.String[] ipAccreditati) {
        this.ipAccreditati = ipAccreditati;
    }

    public java.lang.String getIpAccreditati(int i) {
        return this.ipAccreditati[i];
    }

    public void setIpAccreditati(int i, java.lang.String _value) {
        this.ipAccreditati[i] = _value;
    }


    /**
     * Gets the apiUtente value for this UtentiDatiUtenteIstituzione.
     * 
     * @return apiUtente
     */
    public it.depositolegale.www.utenti.UtentiDatiUtenteIstituzioneApiUtente getApiUtente() {
        return apiUtente;
    }


    /**
     * Sets the apiUtente value for this UtentiDatiUtenteIstituzione.
     * 
     * @param apiUtente
     */
    public void setApiUtente(it.depositolegale.www.utenti.UtentiDatiUtenteIstituzioneApiUtente apiUtente) {
        this.apiUtente = apiUtente;
    }


    /**
     * Gets the emailBagit value for this UtentiDatiUtenteIstituzione.
     * 
     * @return emailBagit
     */
    public java.lang.String getEmailBagit() {
        return emailBagit;
    }


    /**
     * Sets the emailBagit value for this UtentiDatiUtenteIstituzione.
     * 
     * @param emailBagit
     */
    public void setEmailBagit(java.lang.String emailBagit) {
        this.emailBagit = emailBagit;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UtentiDatiUtenteIstituzione)) return false;
        UtentiDatiUtenteIstituzione other = (UtentiDatiUtenteIstituzione) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.indirizzo==null && other.getIndirizzo()==null) || 
             (this.indirizzo!=null &&
              this.indirizzo.equals(other.getIndirizzo()))) &&
            ((this.telefono==null && other.getTelefono()==null) || 
             (this.telefono!=null &&
              this.telefono.equals(other.getTelefono()))) &&
            ((this.nomeContatto==null && other.getNomeContatto()==null) || 
             (this.nomeContatto!=null &&
              this.nomeContatto.equals(other.getNomeContatto()))) &&
            ((this.bibliotecaDepositaria==null && other.getBibliotecaDepositaria()==null) || 
             (this.bibliotecaDepositaria!=null &&
              this.bibliotecaDepositaria.equals(other.getBibliotecaDepositaria()))) &&
            ((this.istitutoCentrale==null && other.getIstitutoCentrale()==null) || 
             (this.istitutoCentrale!=null &&
              this.istitutoCentrale.equals(other.getIstitutoCentrale()))) &&
            ((this.ipAccreditati==null && other.getIpAccreditati()==null) || 
             (this.ipAccreditati!=null &&
              java.util.Arrays.equals(this.ipAccreditati, other.getIpAccreditati()))) &&
            ((this.apiUtente==null && other.getApiUtente()==null) || 
             (this.apiUtente!=null &&
              this.apiUtente.equals(other.getApiUtente()))) &&
            ((this.emailBagit==null && other.getEmailBagit()==null) || 
             (this.emailBagit!=null &&
              this.emailBagit.equals(other.getEmailBagit())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getIndirizzo() != null) {
            _hashCode += getIndirizzo().hashCode();
        }
        if (getTelefono() != null) {
            _hashCode += getTelefono().hashCode();
        }
        if (getNomeContatto() != null) {
            _hashCode += getNomeContatto().hashCode();
        }
        if (getBibliotecaDepositaria() != null) {
            _hashCode += getBibliotecaDepositaria().hashCode();
        }
        if (getIstitutoCentrale() != null) {
            _hashCode += getIstitutoCentrale().hashCode();
        }
        if (getIpAccreditati() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIpAccreditati());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIpAccreditati(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getApiUtente() != null) {
            _hashCode += getApiUtente().hashCode();
        }
        if (getEmailBagit() != null) {
            _hashCode += getEmailBagit().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UtentiDatiUtenteIstituzione.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", ">>>utenti>datiUtente>istituzione"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", "indirizzo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefono");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", "telefono"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeContatto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", "nomeContatto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bibliotecaDepositaria");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", "bibliotecaDepositaria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("istitutoCentrale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", "istitutoCentrale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ipAccreditati");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", "ipAccreditati"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiUtente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", "apiUtente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", ">>>>utenti>datiUtente>istituzione>apiUtente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailBagit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.depositolegale.it/utenti", "emailBagit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
