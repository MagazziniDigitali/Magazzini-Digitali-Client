package it.depositolegale.www.webservice_authenticationIstituzione;

public class AuthenticationIstituzionePortTypeProxy implements it.depositolegale.www.webservice_authenticationIstituzione.AuthenticationIstituzionePortType {
  private String _endpoint = null;
  private it.depositolegale.www.webservice_authenticationIstituzione.AuthenticationIstituzionePortType authenticationIstituzionePortType = null;
  
  public AuthenticationIstituzionePortTypeProxy() {
    _initAuthenticationIstituzionePortTypeProxy();
  }
  
  public AuthenticationIstituzionePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAuthenticationIstituzionePortTypeProxy();
  }
  
  private void _initAuthenticationIstituzionePortTypeProxy() {
    try {
      authenticationIstituzionePortType = (new it.depositolegale.www.webservice_authenticationIstituzione.AuthenticationIstituzioneServiceLocator()).getAuthenticationIstituzionePort();
      if (authenticationIstituzionePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)authenticationIstituzionePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)authenticationIstituzionePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (authenticationIstituzionePortType != null)
      ((javax.xml.rpc.Stub)authenticationIstituzionePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.depositolegale.www.webservice_authenticationIstituzione.AuthenticationIstituzionePortType getAuthenticationIstituzionePortType() {
    if (authenticationIstituzionePortType == null)
      _initAuthenticationIstituzionePortTypeProxy();
    return authenticationIstituzionePortType;
  }
  
  public it.depositolegale.www.istituzione.MdIstituzione authenticationIstituzioneOperation(it.depositolegale.www.loginUtenti.AuthenticationUtenti authenticationUtenti) throws java.rmi.RemoteException{
    if (authenticationIstituzionePortType == null)
      _initAuthenticationIstituzionePortTypeProxy();
    return authenticationIstituzionePortType.authenticationIstituzioneOperation(authenticationUtenti);
  }
  
  
}