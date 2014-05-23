package it.depositolegale.www.webservice_endSendMD;

public class EndSendMDPortTypeProxy implements it.depositolegale.www.webservice_endSendMD.EndSendMDPortType {
  private String _endpoint = null;
  private it.depositolegale.www.webservice_endSendMD.EndSendMDPortType endSendMDPortType = null;
  
  public EndSendMDPortTypeProxy() {
    _initEndSendMDPortTypeProxy();
  }
  
  public EndSendMDPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initEndSendMDPortTypeProxy();
  }
  
  private void _initEndSendMDPortTypeProxy() {
    try {
      endSendMDPortType = (new it.depositolegale.www.webservice_endSendMD.EndSendMDServiceLocator()).getEndSendMDPort();
      if (endSendMDPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)endSendMDPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)endSendMDPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (endSendMDPortType != null)
      ((javax.xml.rpc.Stub)endSendMDPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.depositolegale.www.webservice_endSendMD.EndSendMDPortType getEndSendMDPortType() {
    if (endSendMDPortType == null)
      _initEndSendMDPortTypeProxy();
    return endSendMDPortType;
  }
  
  public void endSendMDOperation(it.depositolegale.www.endSend.EndSend endSend) throws java.rmi.RemoteException{
    if (endSendMDPortType == null)
      _initEndSendMDPortTypeProxy();
    endSendMDPortType.endSendMDOperation(endSend);
  }
  
  
}