package it.depositolegale.www.webservice_checkMD;

public class CheckMDPortTypeProxy implements it.depositolegale.www.webservice_checkMD.CheckMDPortType {
  private String _endpoint = null;
  private it.depositolegale.www.webservice_checkMD.CheckMDPortType checkMDPortType = null;
  
  public CheckMDPortTypeProxy() {
    _initCheckMDPortTypeProxy();
  }
  
  public CheckMDPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initCheckMDPortTypeProxy();
  }
  
  private void _initCheckMDPortTypeProxy() {
    try {
      checkMDPortType = (new it.depositolegale.www.webservice_checkMD.CheckMDServiceLocator()).getCheckMDPort();
      if (checkMDPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)checkMDPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)checkMDPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (checkMDPortType != null)
      ((javax.xml.rpc.Stub)checkMDPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.depositolegale.www.webservice_checkMD.CheckMDPortType getCheckMDPortType() {
    if (checkMDPortType == null)
      _initCheckMDPortTypeProxy();
    return checkMDPortType;
  }
  
  public it.depositolegale.www.readInfoOutput.ReadInfoOutput checkMDOperation(it.depositolegale.www.readInfoInput.ReadInfoInput readInfoInput) throws java.rmi.RemoteException{
    if (checkMDPortType == null)
      _initCheckMDPortTypeProxy();
    return checkMDPortType.checkMDOperation(readInfoInput);
  }
  
  
}