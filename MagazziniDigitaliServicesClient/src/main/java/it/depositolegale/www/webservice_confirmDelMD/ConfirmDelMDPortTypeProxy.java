package it.depositolegale.www.webservice_confirmDelMD;

public class ConfirmDelMDPortTypeProxy implements it.depositolegale.www.webservice_confirmDelMD.ConfirmDelMDPortType {
  private String _endpoint = null;
  private it.depositolegale.www.webservice_confirmDelMD.ConfirmDelMDPortType confirmDelMDPortType = null;
  
  public ConfirmDelMDPortTypeProxy() {
    _initConfirmDelMDPortTypeProxy();
  }
  
  public ConfirmDelMDPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initConfirmDelMDPortTypeProxy();
  }
  
  private void _initConfirmDelMDPortTypeProxy() {
    try {
      confirmDelMDPortType = (new it.depositolegale.www.webservice_confirmDelMD.ConfirmDelMDServiceLocator()).getConfirmDelMDPort();
      if (confirmDelMDPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)confirmDelMDPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)confirmDelMDPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (confirmDelMDPortType != null)
      ((javax.xml.rpc.Stub)confirmDelMDPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.depositolegale.www.webservice_confirmDelMD.ConfirmDelMDPortType getConfirmDelMDPortType() {
    if (confirmDelMDPortType == null)
      _initConfirmDelMDPortTypeProxy();
    return confirmDelMDPortType;
  }
  
  public void confirmDelMDOperation(it.depositolegale.www.readInfoInput.ReadInfoInput readInfoInput) throws java.rmi.RemoteException{
    if (confirmDelMDPortType == null)
      _initConfirmDelMDPortTypeProxy();
    confirmDelMDPortType.confirmDelMDOperation(readInfoInput);
  }
  
  
}