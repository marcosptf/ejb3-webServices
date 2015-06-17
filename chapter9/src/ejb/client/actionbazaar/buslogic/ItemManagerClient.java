package actionbazaar.buslogic;

import javax.naming.Context;
import javax.naming.InitialContext;

import actionbazaar.persistence.Item;

public class ItemManagerClient {
    


    public static void main(String[] args) {

       try {
            Context context = new InitialContext();
            ItemManager itemManager = (ItemManager)context.lookup("ItemManager#actionbazaar.buslogic.ItemManager");

        Item item = itemManager.addItem("Vintage Car from Junk Yard",
                "description goes here", new Double(120.00), "idiot");

        System.out.println("Item created with Item Id:" + item.getItemId());
        item.setTitle("New Title: Cars those met accident");
        itemManager.updateItem(item);
        System.out.println("Title for item Id " + item.getItemId()
                + " updated successfully");
        } 
          catch (Exception ex) {
            			ex.printStackTrace();
          			}
    }
}