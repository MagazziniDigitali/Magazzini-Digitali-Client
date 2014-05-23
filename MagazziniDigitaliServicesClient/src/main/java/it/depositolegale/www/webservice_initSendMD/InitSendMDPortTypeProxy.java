package it.depositolegale.www.webservice_initSendMD;

public class InitSendMDPortTypeProxy implements it.depositolegale.www.webservice_initSendMD.InitSendMDPortType {
  private String _endpoint = null;
  private it.depositolegale.www.webservice_initSendMD.InitSendMDPortType initSendMDPortType = null;
  
  public InitSendMDPortTypeProxy() {
    _initInitSendMDPortTypeProxy();
  }
  
  public InitSendMDPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initInitSendMDPortTypeProxy();
  }
  
  private void _initInitSendMDPortTypeProxy() {
    try {
      initSendMDPortType = (new it.depositolegale.www.webservice_initSendMD.InitSendMDServiceLocator()).getInitSendMDPort();
      if (initSendMDPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)initSendMDPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)initSendMDPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (initSendMDPortType != null)
      ((javax.xml.rpc.Stub)initSendMDPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.depositolegale.www.webservice_initSendMD.InitSendMDPortType getInitSendMDPortType() {
    if (initSendMDPortType == null)
      _initInitSendMDPortTypeProxy();
    return initSendMDPortType;
  }
  
  public it.depositolegale.www.readInfoOutput.ReadInfoOutput initSendMDOperation(it.depositolegale.www.readInfoInput.ReadInfoInput readInfoInput) throws java.rmi.RemoteException{
    if (initSendMDPortType == null)
      _initInitSendMDPortTypeProxy();
    return initSendMDPortType.initSendMDOperation(readInfoInput);
  }
  
  
}