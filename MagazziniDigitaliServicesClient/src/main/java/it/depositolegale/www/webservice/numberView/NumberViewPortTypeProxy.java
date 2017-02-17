package it.depositolegale.www.webservice.numberView;

public class NumberViewPortTypeProxy implements it.depositolegale.www.webservice.numberView.NumberViewPortType {
  private String _endpoint = null;
  private it.depositolegale.www.webservice.numberView.NumberViewPortType numberViewPortType = null;
  
  public NumberViewPortTypeProxy() {
    _initNumberViewPortTypeProxy();
  }
  
  public NumberViewPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initNumberViewPortTypeProxy();
  }
  
  private void _initNumberViewPortTypeProxy() {
    try {
      numberViewPortType = (new it.depositolegale.www.webservice.numberView.NumberViewServiceLocator()).getNumberViewPort();
      if (numberViewPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)numberViewPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)numberViewPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (numberViewPortType != null)
      ((javax.xml.rpc.Stub)numberViewPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.depositolegale.www.webservice.numberView.NumberViewPortType getNumberViewPortType() {
    if (numberViewPortType == null)
      _initNumberViewPortTypeProxy();
    return numberViewPortType;
  }
  
  public java.math.BigInteger numberViewOperation(it.depositolegale.www.numberView.NumberView numberView) throws java.rmi.RemoteException{
    if (numberViewPortType == null)
      _initNumberViewPortTypeProxy();
    return numberViewPortType.numberViewOperation(numberView);
  }
  
  
}