package actionbazaar.buslogic;
import javax.naming.Context;
import javax.naming.InitialContext;

import javax.ejb.EJB;

public class PlaceBidClient {
    //@EJB
    //private static PlaceBid placeBid;


    public static void main(String[] args) {
        try {
            Context context = new InitialContext();
            PlaceBid placeBid = (PlaceBid)context.lookup("PlaceBid#actionbazaar.buslogic.PlaceBid");
            System.out.println("Bid Price Sent to the bean is:" + 20000.5);
            System.out.println("Bid Successful, BidId Received is:"
                    + placeBid.addBid("dpanda", Long.valueOf(403), 20000.50));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}