package it.depositolegale.www.webservice_checkTicket;

public class CheckTicketPortTypeProxy implements it.depositolegale.www.webservice_checkTicket.CheckTicketPortType {
  private String _endpoint = null;
  private it.depositolegale.www.webservice_checkTicket.CheckTicketPortType checkTicketPortType = null;
  
  public CheckTicketPortTypeProxy() {
    _initCheckTicketPortTypeProxy();
  }
  
  public CheckTicketPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initCheckTicketPortTypeProxy();
  }
  
  private void _initCheckTicketPortTypeProxy() {
    try {
      checkTicketPortType = (new it.depositolegale.www.webservice_checkTicket.CheckTicketServiceLocator()).getCheckTicketPort();
      if (checkTicketPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)checkTicketPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)checkTicketPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (checkTicketPortType != null)
      ((javax.xml.rpc.Stub)checkTicketPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.depositolegale.www.webservice_checkTicket.CheckTicketPortType getCheckTicketPortType() {
    if (checkTicketPortType == null)
      _initCheckTicketPortTypeProxy();
    return checkTicketPortType;
  }
  
  public it.depositolegale.www.checkTicketOutput.CheckTicketOutput checkTicketOperation(it.depositolegale.www.checkTicket.CheckTicket checkTicket) throws java.rmi.RemoteException{
    if (checkTicketPortType == null)
      _initCheckTicketPortTypeProxy();
    return checkTicketPortType.checkTicketOperation(checkTicket);
  }
  
  
}