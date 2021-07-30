import java.rmi.*;
import java.util.*; 

class ATMUser{
	static Scanner sc = new Scanner(System.in);
	public static String u_name;
	public static String pswd;
	public static int amount;
	public static int choice;
	
public static void showLoginRegisterMenu(ATMProgram obj) throws RemoteException{
	stars();
	System.out.println("*** WELCOME TO ATM Program by Salman/106 ***");
	stars();
	System.out.println("Select Choice...");
	System.out.println("1. Login");
	System.out.println("2. Create Account");
	System.out.println("3. Quit");
	choice = Integer.parseInt(sc.nextLine());
	stars();
switch(choice){
	case 1:
		System.out.print("Enter User u_name:");
		u_name = sc.nextLine();
		System.out.print("Enter pswd code:");
		pswd = sc.nextLine();
		boolean loged = obj.doLogin(u_name,pswd);
		if(loged){
			System.out.println("Successfull doLog in");
			stars();
			showATMMenu(obj);
		}
		else{
			System.out.println("Incorrect Useru_name or password");
			showLoginRegisterMenu(obj);
		}

		break;
	case 2:
		System.out.print("Enter User u_name:");
		u_name = sc.nextLine();
		System.out.print("Enter pswd:");
		pswd = sc.nextLine();
		boolean regstd = obj.doRegister(u_name,pswd);
		if(regstd){
			System.out.println("Successful created new account");
			showLoginRegisterMenu(obj);
		}
		else{
			System.out.println("Already created account");
			showLoginRegisterMenu(obj);
		}
		break;
	case 3:
		System.exit(0);
		break;
	default:
		System.out.println("invalid entry");
		break;
	}
}

public static void showATMMenu(ATMProgram obj) throws RemoteException{
	do{
	stars();
	System.out.println("Select Choice...");
	System.out.println("1.Withdraw");
	System.out.println("2.Deposit");
	System.out.println("3.Request balance");
	System.out.println("4.Quit program");
	choice = Integer.parseInt(sc.nextLine());
	stars();
	switch(choice){
	case 1:
		System.out.print("Withdraw amount:");
		amount = Integer.parseInt(sc.nextLine());
		boolean withdraw = obj.withdrawMoney(u_name,amount);
		if(withdraw){
		System.out.println("Operation Successful ");
		}
		else
			System.out.println("Insufficient Balance");
		break;
	case 2:
		System.out.print("Deposit amount:");
		amount = Integer.parseInt(sc.nextLine());
		obj.depositMoney(u_name,amount);
		break;
	case 3:
		int blc = obj.requestBalance(u_name);
		System.out.println("Your Balance :"+blc);
		break;
	case 4:
		showLoginRegisterMenu(obj);
		break;
	default:
		System.out.println("invalid entry");
		break;
	}
	
	}while(choice != 4);
}

public static void stars(){
	System.out.println("*******************************");

}

}