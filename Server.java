import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*; 
 
public class Server implements ServerIntf {

    //public Server() throws RemoteException {
	//super(2000);
    //}
    
//    public String getMessage() {
//        try {
//		return 	getClientHost();
//		} catch (Exception e) {
//			return "Error! Exception: "+e; 
//		}
//   }

//	public void setLogserver() {
//		setLog(System.out);
//	}

	public String reverseString(String s) {
		String reverse = new StringBuffer(s).reverse().toString();
		return reverse;
	}    


    public static void main(String args[]) throws RemoteException {
	//System.setProperty("java.security.policy", "server.policy");
	
        //if (System.getSecurityManager() == null) 
	    //System.setSecurityManager(new RMISecurityManager());
	
	//LocateRegistry.createRegistry(1099);
	
        try {
	    Server obj = new Server();
		UnicastRemoteObject.exportObject(obj, 2000);
	    //Naming.rebind("//localhost/some_name", obj);
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }
}
