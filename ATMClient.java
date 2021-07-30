import java.rmi.*;
class ATMClient {

public static void main(String []args) throws RemoteException,NotBoundException,
	java.net.MalformedURLException{
	ATMProgram obj = (ATMProgram)Naming.lookup("ATMObject");
	ATMUser atmObj = new ATMUser();
	atmObj.showLoginRegisterMenu(obj);
	
	
	}

}