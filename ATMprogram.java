import java.rmi.*; 
import java.rmi.server.*;

interface ATMProgram extends Remote{

	boolean doRegister(String userName, String password) throws RemoteException;
	boolean doLogin(String userName, String password) throws RemoteException;
	boolean withdrawMoney(String userName,int withdrawnMoney) throws RemoteException;
	int depositMoney(String userName,int depositMoney) throws RemoteException;
	int requestBalance(String userName) throws RemoteException;

}