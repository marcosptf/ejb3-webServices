
package actionbazaar.buslogic;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the actionbazaar.buslogic package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BidException_QNAME = new QName("http://actionbazaar.com/xml", "BidException");
    private final static QName _AddBidResponse_QNAME = new QName("http://actionbazaar.com/xml", "addBidResponse");
    private final static QName _AddBid_QNAME = new QName("http://actionbazaar.com/xml", "addBid");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: actionbazaar.buslogic
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddBidResponse }
     * 
     */
    public AddBidResponse createAddBidResponse() {
        return new AddBidResponse();
    }

    /**
     * Create an instance of {@link AddBid }
     * 
     */
    public AddBid createAddBid() {
        return new AddBid();
    }

    /**
     * Create an instance of {@link BidException }
     * 
     */
    public BidException createBidException() {
        return new BidException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BidException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://actionbazaar.com/xml", name = "BidException")
    public JAXBElement<BidException> createBidException(BidException value) {
        return new JAXBElement<BidException>(_BidException_QNAME, BidException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddBidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://actionbazaar.com/xml", name = "addBidResponse")
    public JAXBElement<AddBidResponse> createAddBidResponse(AddBidResponse value) {
        return new JAXBElement<AddBidResponse>(_AddBidResponse_QNAME, AddBidResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddBid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://actionbazaar.com/xml", name = "addBid")
    public JAXBElement<AddBid> createAddBid(AddBid value) {
        return new JAXBElement<AddBid>(_AddBid_QNAME, AddBid.class, null, value);
    }

}
