import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*; 
import java.rmi.server.Unreferenced;
 
public class Server extends UnicastRemoteObject implements ServerIntf, Unreferenced {
	private String name;

    public Server(String nazwa) throws RemoteException {
	super(1099);
	name=nazwa;
    }

	// jest wykonywana kiedy nie ma zdalnej referencji do tego obiektu.
	// nie można korzystać z RMI
	public void unreferenced() {


	}
	// java.rmi.dgc.checkInterval;
	// java.rmi.dgc.checkinterval;    

    public String getMessage() {
        try {
		return 	getClientHost();
		} catch (Exception e) {
			return "Error! Exception: "+e; 
		}
	}

	public void setLogserver() {
		setLog(System.out);
	}

	public String reverseString(String s) {
		String reverse = new StringBuffer(s).reverse().toString();
		return reverse;
	}    


    public static void main(String args[]) throws RemoteException {
//	System.setProperty("java.security.policy", "server.policy");
	
//        if (System.getSecurityManager() == null) 
//	    System.setSecurityManager(new RMISecurityManager());
	
	LocateRegistry.createRegistry(1099);
	
        try {
	    Server obj = new Server("Obj");
		Server obj2 = new Server("Obj2");
	    //Naming.rebind("//localhost/some_name", obj);
	    Naming.rebind("Obj", obj);
	    Naming.rebind("Obj2", obj2);
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }
}
