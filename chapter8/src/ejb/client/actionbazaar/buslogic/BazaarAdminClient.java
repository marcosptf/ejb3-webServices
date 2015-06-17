package actionbazaar.buslogic;

import javax.naming.Context;
import javax.naming.InitialContext;

import actionbazaar.persistence.Bidder;

public class BazaarAdminClient {
    


    public static void main(String[] args) {
     try {
            
         Context context = new InitialContext();
         BazaarAdmin bazaarAdmin = (BazaarAdmin)context.lookup("BazaarAdmin#actionbazaar.buslogic.BazaarAdmin");
            

        Bidder bidder = new Bidder();
        bidder.setUserId("idiot2");
        bidder.setFirstName("Serious");
        bidder.setLastName("Bidder");
        bidder.setCreditRating(new Long(65));
        bidder = bazaarAdmin.createBidder(bidder);
        System.out.println("Bidder :" + bidder.getUserId() + " BidderStatus:"
                + bidder.getBidderStatus());
       } 
          catch (Exception ex) {
              ex.printStackTrace();
          }

    }
}