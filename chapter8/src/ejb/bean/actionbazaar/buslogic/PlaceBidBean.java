package actionbazaar.buslogic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import actionbazaar.persistence.Bid;
import actionbazaar.persistence.Bidder;
import actionbazaar.persistence.Item;

@Stateless(name = "PlaceBid")
public class PlaceBidBean implements PlaceBid {
    @PersistenceContext(unitName = "actionBazaar")
    private EntityManager em;


    public PlaceBidBean() {
    }


    public Bid addBid(String bidderId, Long itemId, Double bidPrice) {
        // Find Bidder
        Bidder bidder = (Bidder) em.find(Bidder.class, bidderId);

        // Find Item
        Item item = (Item) em.find(Item.class, itemId);

        // Create new instance of Bid
        Bid newBid = new Bid();

        newBid.setBidPrice(bidPrice);

        // Set RelationShip
        newBid.setBidder(bidder);
        newBid.setItem(item);

        // Persist Bid
        em.persist(newBid);
        return newBid;
    }
}
