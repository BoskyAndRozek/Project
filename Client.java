import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.io.*;
 
public class Client { 

	public static String readLine()
	{
		String s = "";
		try {
			InputStreamReader converter = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(converter);
			s = in.readLine();
		} catch (Exception e) {
			System.out.println("Error! Exception: "+e); 
		}
		return s;
	}

    public static void main(String args[]) {
	System.setProperty("java.security.policy", "client.policy");
	
        if (System.getSecurityManager() == null) 
            System.setSecurityManager(new RMISecurityManager());
	
	try {
	    ServerIntf obj = (ServerIntf) Naming.lookup("//localhost/some_name");
		System.out.print ("Podaj tekst do odwrocenia: ");
		String s = readLine();
		System.out.print ("Tekst po odwroceniu: ");
		System.out.println(obj.reverseString(s));
	} catch (Exception e) {
	    System.out.println(e.getMessage());	    
	}
    }
}
