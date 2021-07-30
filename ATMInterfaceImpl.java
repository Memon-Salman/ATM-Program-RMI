import java.rmi.*;

class ATMInterfaceImpl implements ATMProgram{

public String u_name;
public String pswd;
public int currentBlc= 0;

public boolean doRegister(String u_name, String password) throws RemoteException{
	if(!(u_name.equals(u_name) && password.equals(pswd))){
		u_name = u_name;
		pswd = password;
		System.out.println("Registered:"+u_name+" "+pswd);
		return true;
}
	else
		return false;
}

public boolean doLogin(String u_name, String password) throws RemoteException{
		if(u_name.equals(u_name) && password.equals(pswd)){
			System.out.println("Loged in:"+u_name+" "+pswd);
			return true;
		}
		else
			return false;

}

public boolean withdrawMoney(String u_name,int withdrawnMoney) {
	if(withdrawnMoney < currentBlc){
		currentBlc-= withdrawnMoney;
		System.out.println(u_name+" Withdrawn "+withdrawnMoney);
		return true;
	}	
	else
		return false;
}
public int depositMoney(String u_name,int depositMoney) {
	currentBlc+= depositMoney;
	System.out.println(u_name+" Deposited "+depositMoney);
	return currentBlc;
}
public int requestBalance(String u_name){
		return currentBlc;
}

}