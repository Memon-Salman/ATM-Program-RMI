import java.rmi.*;
import java.rmi.server.*;

class ATMServer{

	public static void main(String []args) throws RemoteException,java.net.MalformedURLException{
	ATMInterfaceImpl ob = new ATMInterfaceImpl();
	UnicastRemoteObject.exportObject(ob);
	Naming.rebind("ATMObject",ob);
	System.out.println("SERVER Ready....");
	}

}