package actionbazaar.buslogic;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.net.URL;

public class PlaceBidClient {

// Modify wsdlLocation for your environment

//@WebServiceRef(wsdlLocation="http://localhost:3734/PlaceBidService/PlaceBidBean?WSDL") 
private static PlaceBid placeBid = null;
  //private String[] defaultArgs = {"http://localhost:7001/PlaceBidBean/PlaceBidBeanService?WSDL", "weblogic", "weblogic"};



    public static void main(String [] args) {
        try {
            URL url = new URL("http://localhost:7001/PlaceBidBean/PlaceBidBeanService?wsdl");
            System.out.println("invoke service described at " + "http://localhost:7001/PlaceBidBean/PlaceBidBeanService?WSDL");
            QName serviceName = new QName("http://actionbazaar.com/xml", "PlaceBidService");
            PlaceBidService service = new PlaceBidService(url, serviceName);
            placeBid = service.getPlaceBidPort();
            
            System.out.println("Got Port " );
            ((BindingProvider) placeBid).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "weblogic");
           ((BindingProvider) placeBid).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "weblogic");
            System.out.println("Bid Price Sent to the bean is:"+200000.5);
            System.out.println("Bid Successful, BidId Received is:" +placeBid.addBid("idiot",  Long.valueOf(1),  2000005.50 ));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

   }
