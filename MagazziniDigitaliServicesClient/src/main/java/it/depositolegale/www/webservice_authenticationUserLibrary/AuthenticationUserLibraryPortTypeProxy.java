package it.depositolegale.www.webservice_authenticationUserLibrary;

public class AuthenticationUserLibraryPortTypeProxy implements it.depositolegale.www.webservice_authenticationUserLibrary.AuthenticationUserLibraryPortType {
  private String _endpoint = null;
  private it.depositolegale.www.webservice_authenticationUserLibrary.AuthenticationUserLibraryPortType authenticationUserLibraryPortType = null;
  
  public AuthenticationUserLibraryPortTypeProxy() {
    _initAuthenticationUserLibraryPortTypeProxy();
  }
  
  public AuthenticationUserLibraryPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAuthenticationUserLibraryPortTypeProxy();
  }
  
  private void _initAuthenticationUserLibraryPortTypeProxy() {
    try {
      authenticationUserLibraryPortType = (new it.depositolegale.www.webservice_authenticationUserLibrary.AuthenticationUserLibraryServiceLocator()).getAuthenticationUserLibraryPort();
      if (authenticationUserLibraryPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)authenticationUserLibraryPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)authenticationUserLibraryPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (authenticationUserLibraryPortType != null)
      ((javax.xml.rpc.Stub)authenticationUserLibraryPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.depositolegale.www.webservice_authenticationUserLibrary.AuthenticationUserLibraryPortType getAuthenticationUserLibraryPortType() {
    if (authenticationUserLibraryPortType == null)
      _initAuthenticationUserLibraryPortTypeProxy();
    return authenticationUserLibraryPortType;
  }
  
  public it.depositolegale.www.authenticationUserOutput.AuthenticationUserOutput authenticationUserLibraryOperation(it.depositolegale.www.authenticationUserInput.AuthenticationUserInput authenticationUserInput) throws java.rmi.RemoteException{
    if (authenticationUserLibraryPortType == null)
      _initAuthenticationUserLibraryPortTypeProxy();
    return authenticationUserLibraryPortType.authenticationUserLibraryOperation(authenticationUserInput);
  }
  
  
}