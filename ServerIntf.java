import java.rmi.Remote;
import java.rmi.RemoteException;
 
public interface ServerIntf extends Remote {
    public String getMessage() throws RemoteException;
    public String reverseString(String s) throws RemoteException;
	public void setLogserver() throws RemoteException;
	public OurClass getOurClass() throws RemoteException;
}
