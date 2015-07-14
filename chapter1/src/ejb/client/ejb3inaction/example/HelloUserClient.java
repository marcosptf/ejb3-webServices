
package ejb3inaction.example;

import javax.ejb.EJB;
import javax.naming.*;

/* its a client class that is using a bean to print a message */
public class HelloUserClient{
      
      /* start a property from the interface to use */
      private static HelloUser helloUser;

    	public static void main(String[] args) {
          System.out.println("Invoking EJB");     
          try {
              Context ctx = new InitialContext();
              /* syntax:NameOfInterface#Package.name.Interface  */
              helloUser = (HelloUser) ctx.lookup("HelloUser#ejb3inaction.example.HelloUser");
              /* calling method implemented for HelloUserBean */
              helloUser.sayHello("Curious George");
              System.out.println("Invoked EJB successfully .. see server console for output");     
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
}
