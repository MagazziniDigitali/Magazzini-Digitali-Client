/**
 * AuthenticationUserLibraryPortSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.depositolegale.www.webservice_authenticationUserLibrary;

public class AuthenticationUserLibraryPortSoapBindingStub extends org.apache.axis.client.Stub implements it.depositolegale.www.webservice_authenticationUserLibrary.AuthenticationUserLibraryPortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[1];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AuthenticationUserLibraryOperation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", "authenticationUserInput"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">authenticationUserInput"), it.depositolegale.www.authenticationUserInput.AuthenticationUserInput.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserOutput", ">authenticationUserOutput"));
        oper.setReturnClass(it.depositolegale.www.authenticationUserOutput.AuthenticationUserOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserOutput", "authenticationUserOutput"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

    }

    public AuthenticationUserLibraryPortSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public AuthenticationUserLibraryPortSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public AuthenticationUserLibraryPortSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">>>userInput>rights>rightsDisseminate>rightsDisseminateType");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserInput.UserInputRightsRightsDisseminateRightsDisseminateType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">>>userInput>software>istituzione>apiUtente");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserInput.UserInputSoftwareIstituzioneApiUtente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">>userInput>rights>rightsDisseminate");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserInput.UserInputRightsRightsDisseminate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">>userInput>rights>rightsIdentifier");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserInput.UserInputRightsRightsIdentifier.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">>userInput>software>authentication");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserInput.UserInputSoftwareAuthentication.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">>userInput>software>istituzione");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserInput.UserInputSoftwareIstituzione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">>userInput>software>rigth");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserInput.UserInputSoftwareRigth.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">authenticationUserInput");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserInput.AuthenticationUserInput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">userInput>agent");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserInput.UserInputAgent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">userInput>authentication");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserInput.UserInputAuthentication.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">userInput>objectIdentifier");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserInput.UserInputObjectIdentifier.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">userInput>rights");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserInput.UserInputRights.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", ">userInput>software");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserInput.UserInputSoftware.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", "agent");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserInput.Agent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserInput", "userInput");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserInput.UserInput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserOutput", ">>>>authenticationUserOutput>rights>rightsDisseminate>rightsDisseminateType");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserOutput.AuthenticationUserOutputRightsRightsDisseminateRightsDisseminateType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserOutput", ">>>authenticationUserOutput>rights>rightsDisseminate");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserOutput.AuthenticationUserOutputRightsRightsDisseminate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserOutput", ">>>authenticationUserOutput>rights>rightsIdentifier");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserOutput.AuthenticationUserOutputRightsRightsIdentifier.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserOutput", ">>authenticationUserOutput>rights");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserOutput.AuthenticationUserOutputRights.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/authenticationUserOutput", ">authenticationUserOutput");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.authenticationUserOutput.AuthenticationUserOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/errorMsg", "errorMsg");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.errorMsg.ErrorMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/errorMsg", "errorType_type");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.errorMsg.ErrorType_type.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/rigths", "rightType_type");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.rigths.RightType_type.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/software", ">>softwareConfig>nodo>rsync");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.software.SoftwareConfigNodoRsync.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/software", ">softwareConfig>nodo");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.software.SoftwareConfigNodo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.depositolegale.it/software", "softwareConfig");
            cachedSerQNames.add(qName);
            cls = it.depositolegale.www.software.SoftwareConfig.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public it.depositolegale.www.authenticationUserOutput.AuthenticationUserOutput authenticationUserLibraryOperation(it.depositolegale.www.authenticationUserInput.AuthenticationUserInput authenticationUserInput) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AuthenticationUserLibraryOperation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {authenticationUserInput});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.depositolegale.www.authenticationUserOutput.AuthenticationUserOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.depositolegale.www.authenticationUserOutput.AuthenticationUserOutput) org.apache.axis.utils.JavaUtils.convert(_resp, it.depositolegale.www.authenticationUserOutput.AuthenticationUserOutput.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
