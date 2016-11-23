package it.depositolegale.www.webservice_authenticationSoftware;

public class AuthenticationSoftwarePortTypeProxy implements it.depositolegale.www.webservice_authenticationSoftware.AuthenticationSoftwarePortType {
  private String _endpoint = null;
  private it.depositolegale.www.webservice_authenticationSoftware.AuthenticationSoftwarePortType authenticationSoftwarePortType = null;
  
  public AuthenticationSoftwarePortTypeProxy() {
    _initAuthenticationSoftwarePortTypeProxy();
  }
  
  public AuthenticationSoftwarePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAuthenticationSoftwarePortTypeProxy();
  }
  
  private void _initAuthenticationSoftwarePortTypeProxy() {
    try {
      authenticationSoftwarePortType = (new it.depositolegale.www.webservice_authenticationSoftware.AuthenticationSoftwareServiceLocator()).getAuthenticationSoftwarePort();
      if (authenticationSoftwarePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)authenticationSoftwarePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)authenticationSoftwarePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (authenticationSoftwarePortType != null)
      ((javax.xml.rpc.Stub)authenticationSoftwarePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.depositolegale.www.webservice_authenticationSoftware.AuthenticationSoftwarePortType getAuthenticationSoftwarePortType() {
    if (authenticationSoftwarePortType == null)
      _initAuthenticationSoftwarePortTypeProxy();
    return authenticationSoftwarePortType;
  }
  
  public it.depositolegale.www.software.Software authenticationSoftwareOperation(it.depositolegale.www.login.Authentication authentication) throws java.rmi.RemoteException{
    if (authenticationSoftwarePortType == null)
      _initAuthenticationSoftwarePortTypeProxy();
    return authenticationSoftwarePortType.authenticationSoftwareOperation(authentication);
  }
  
  
}