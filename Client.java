import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
 
public class Client { 
    public static void main(String args[]) {
	System.setProperty("java.security.policy", "client.policy");
	
        if (System.getSecurityManager() == null) 
            System.setSecurityManager(new RMISecurityManager());
	
	try {
	    ServerIntf obj = (ServerIntf) Naming.lookup("//localhost/some_name");
	    System.out.println(obj.getMessage());
	} catch (Exception e) {
	    System.out.println(e.getMessage());	    
	}
    }
}
