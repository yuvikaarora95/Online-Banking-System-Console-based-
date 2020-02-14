import java.util.*;
public abstract class User {
		protected static String id;
		protected String name;
		protected static float accno;
		protected String address;
		protected String phone;
		//protected String AccountType;
		protected String  date;
		protected int bal;
		private double balance;
	
	//constructor
	public User(String id, String name, String address, String phone, String AccountType, String date) {
		 this.id = id;
		 this.name = name;
		 this.accno = accno;
		 this.address = address;
		 this.phone = phone;
		 //this.AccountType = AccountType;
		 this.date = date;
		 this.bal = bal;
	}
	//getter
	public static float getAccount() {
		return accno;
	}
	public  void setId(float accno) {
		 this.accno = accno;
	}
	public static boolean contains(String accnoin) {
		// TODO Auto-generated method stub
		return false;
	}
	public double getBalance()
	{
		return balance;	
	}
}
