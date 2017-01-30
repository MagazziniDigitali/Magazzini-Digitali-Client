package it.depositolegale.www.webservice_writeEventNBN;

public class WriteEventNBNPortTypeProxy implements it.depositolegale.www.webservice_writeEventNBN.WriteEventNBNPortType {
  private String _endpoint = null;
  private it.depositolegale.www.webservice_writeEventNBN.WriteEventNBNPortType writeEventNBNPortType = null;
  
  public WriteEventNBNPortTypeProxy() {
    _initWriteEventNBNPortTypeProxy();
  }
  
  public WriteEventNBNPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initWriteEventNBNPortTypeProxy();
  }
  
  private void _initWriteEventNBNPortTypeProxy() {
    try {
      writeEventNBNPortType = (new it.depositolegale.www.webservice_writeEventNBN.WriteEventNBNServiceLocator()).getWriteEventNBNPort();
      if (writeEventNBNPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)writeEventNBNPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)writeEventNBNPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (writeEventNBNPortType != null)
      ((javax.xml.rpc.Stub)writeEventNBNPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.depositolegale.www.webservice_writeEventNBN.WriteEventNBNPortType getWriteEventNBNPortType() {
    if (writeEventNBNPortType == null)
      _initWriteEventNBNPortTypeProxy();
    return writeEventNBNPortType;
  }
  
  public it.depositolegale.www.writeEventNBN.WriteEventNBN1 writeEventNBNOperation(it.depositolegale.www.writeEventNBN.WriteEventNBN writeEventNBN) throws java.rmi.RemoteException{
    if (writeEventNBNPortType == null)
      _initWriteEventNBNPortTypeProxy();
    return writeEventNBNPortType.writeEventNBNOperation(writeEventNBN);
  }
  
  
}