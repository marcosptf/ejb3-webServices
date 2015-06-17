package actionbazaar.buslogic;
import javax.naming.Context;
import javax.naming.InitialContext;
import actionbazaar.persistence.*;
import javax.ejb.EJB;


public class BazaarAdminClient {


    public static void main(String [] args) {
                                       
           try {
            Context context = new InitialContext();
            BazaarAdmin bazaarAdmin = (BazaarAdmin)context.lookup("BazaarAdmin#actionbazaar.buslogic.BazaarAdmin");
            
            Category category = bazaarAdmin.createCategory("test category","idiot2");
            
            
            
            System.out.println("Category created with Id:"+category.getCategoryId());
		} 
          catch (Exception ex) {
            			ex.printStackTrace();
          			}

    	}
   }
