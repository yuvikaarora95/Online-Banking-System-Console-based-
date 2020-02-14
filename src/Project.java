import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.*;
public class Project {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ArrayList<User> users = new ArrayList<User>();
		Scanner sc = new Scanner(System.in);
		float balance = 0f;
		int number;
		int choice;
		int selection;
		do {
			choice = showMainMenu();
			switch(choice){
			case 0 : System.out.println("Exit");
						System.exit(0);
						break;
			case 1 : //createAccount();
						do {
							selection = admin();
							switch(selection) {
							case 0 : System.out.println("Exit");
									 System.exit(0);
							         break; 
							case 1 : createAccount();
									break;
							case 2 : viewAccounts();
									break;
							case 3 : editAccount();
									break;
							case 4 : showMainMenu();
									break;
							default: System.out.println("Wrong choice! Try again");
							}
						}while(selection!=0);			
						break;
			case 2 : do {
						number = userAction();
						switch(number) {
						case 0: System.out.println("Exit");
								System.exit(0);
								break;
						case 1: displayBalance(balance);
								break;
						case 2: depositMoney(balance);
								break;
						case 3: drawMoney();
								break;
						case 4: transfer();
								break;
						case 5: payBills();
								break;
					
						default: System.out.println("Wrong choice! Try again");
						}
					}while(number!=0);
			}
	}while(choice!=0);
	}
	private static void editAccount() {
		// TODO Auto-generated method stub
		 //String filename = null;
	//	boolean fileRead = readFile();
		
	//	if(fileRead) {
			StringBuffer stringBufferOfData = new StringBuffer();
			stringBufferOfData = readFile();
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter the content you would like to edit");
			String lineToEdit = sc.nextLine();
			
			System.out.println("Please enter the replacement text");
			String replacementText = sc.nextLine();
			
			System.out.println(stringBufferOfData);
			System.out.println(lineToEdit);
			int startIndex = stringBufferOfData.indexOf(lineToEdit);
			System.out.println(startIndex);
			int endIndex = startIndex + lineToEdit.length();
			
			stringBufferOfData.replace(startIndex, endIndex, replacementText);
			
			System.out.println("Here is the new edited text:\n" + stringBufferOfData);
			
			writeToFile();
		
		System.exit(0);
	    
	}
	private static void writeToFile() {
		// TODO Auto-generated method stub
		StringBuffer stringBufferOfData = new StringBuffer();
	// String filename ="data.txt";


		try {
            BufferedWriter bufwriter = new BufferedWriter(new FileWriter("data.txt"));
            bufwriter.write(stringBufferOfData.toString());//writes the edited string buffer to the new file
            bufwriter.close();//closes the file
        } catch (Exception e) {//if an exception occurs
            System.out.println("Error occured while attempting to write to file: " + e.getMessage());
        }
	}
	private static StringBuffer readFile() {
		// TODO Auto-generated method stub
		//System.out.println("Please enter your files name and path i.e ")
	    StringBuffer stringBufferOfData = new StringBuffer();
	    String filename = null;

		Scanner fileToRead = null;
		try {
			fileToRead = new Scanner(new File("data.txt"));
			for(String line; fileToRead.hasNextLine() && (line = fileToRead.nextLine()) != null;) {
				System.out.println(line);
				
				stringBufferOfData.append(line).append("\r\n");
			}
			fileToRead.close();
			return stringBufferOfData;
		} catch(FileNotFoundException ex) {
			System.out.println("The file" + filename + "could not be found" + ex.getMessage());
			return stringBufferOfData;
		}finally {
			fileToRead.close();
			return stringBufferOfData;
		}
	}

	private static void viewAccounts() {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader("data.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String str;
			while ((str = br.readLine()) != null) {
				System.out.println(str + "\n");
			}
			br.close();
		}catch (IOException e) {
			System.out.println("File not found");
		}
	}


	private static void payBills() {
		// TODO Auto-generated method stub
		
	}

	private static void transfer() {
		// TODO Auto-generated method stub
		
	}

	private static void drawMoney() {
		// TODO Auto-generated method stub
		double amount;
		System.out.println("~~~~~~~~WITHDRAW MONEY~~~~~~~~");
	      float balance = 0f;
	      //ArrayList<User> us;
	      Scanner sc = new Scanner(System.in);
	      System.out.println("Enter your account no");
	      String accnoin = sc.next();
	      boolean ans = User.contains(accnoin);
	      if(ans = true) {
	    	  System.out.print("Amount to withdraw: ");
	          amount = sc.nextFloat();
			if (amount <= 0 || amount > balance)
				System.out.println("$" + amount + " has been withdrawn.");
	          else {
	        	  
	               balance -= amount;
	               System.out.println("Withdrawal can't be completed.");
	               
	          }

	      }else 
	    	  System.out.println("Incorrect Account no.");							

	}

	private static void depositMoney(double balance) {
		
		double amount;
		System.out.println("~~~~~~~~DEPOSIT MONEY~~~~~~~~");
	      
	      //ArrayList<User> us;
	      Scanner sc = new Scanner(System.in);
	      System.out.println("Enter your account no");
	      String accnoin = sc.next();
	      boolean ans = User.contains(accnoin);
	      if(ans = true) {
	    	  System.out.print("Amount to deposit: ");
	          amount = sc.nextFloat();
			if (amount <= 0)
	               System.out.println("Can't deposit nonpositive amount.");
	          else {
	        	  
	               balance += amount;

	               System.out.println("$" + amount + " has been deposited.");
	               System.out.println("~~~~~~~~~~~~~~Available balance~~~~~~~~~~~~~~");
	               //displayBalance(balalnce);
	          }

	      }else 
	    	  System.out.println("Incorrect Account no.");							
	}

	private static void displayBalance(double balance) {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader("data.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String str;
			while ((str = br.readLine()) != null) {
				System.out.println(str + "\n");
			}
			br.close();
		}catch (IOException e) {
			System.out.println("File not found");
		}
	}

	private static void createAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Start creating User Account\n");
		int select; 
		do{
			 select = chooseAccount();
			 switch(select) {
			 	case 0: System.out.println("Exit");
			 			System.exit(0);
			 			break;
			 	case 1: System.out.println("~~~~~~~~~~~~SAVINGS ACCOUNT~~~~~~~~~~~~");
			 			adminAction();
			 			break;
			 	case 2: System.out.println("~~~~~~~~~~~~CHEQUING ACCOUNT~~~~~~~~~~~~");
	 					adminAction();
	 					break;
			 	//case 3: admin();
			 	//		break;
			 	//case 4: showMainMenu();
			 }
		}while(select!=0);
		//System.out.println("Enter the Account type of the user");
		//String AccountType = sc.next();
	}
	private static void adminAction() {
	
		Scanner sc = new Scanner(System.in);
		
			System.out.println("Enter the id of the user");
			String id = sc.next();
			System.out.println("Enter the name of the user");
			String name = sc.next();
			float accno = (float) Math.random();
			System.out.println("Enter the address of the user");
			String address = sc.next();
			System.out.println("Enter the phone of the user");
			String phone = sc.next();
			System.out.println("Enter your date of birth in the format (dd-mm-yyyy)");
			String date = sc.next();
			System.out.println("Enter the initial balance");
			int bal = sc.nextInt();
			try{
				BufferedWriter file = new BufferedWriter(new FileWriter("data.txt", true));
				/*StringBuffer inputBuffer = new StringBuffer();
				String line;
				
				while((line = file.readLine()) != null) {
					 //line = ... // replace the line here
					            inputBuffer.append(line);
					            inputBuffer.append('\n');
				}*/
				file.write("Details of the clients\n");
				file.write("======================\n");
				file.write("ID : " + id + "\n");
				file.write("NAME : " + name + "\n");
				file.write("ACCOUNT NUMBER : " + accno + "\n");
				file.write("ADDRESS : " + address + "\n");
				file.write("PHONE : " + phone + "\n");
				file.write("DATE : " + date + "\n");
				file.write("BALANCE : " + bal + "\n");
				file.close();
		        //String inputStr = inputBuffer.toString();
		        //System.out.println(inputStr);
		        
				// write the new string with the replaced line OVER the same file
		       // FileOutputStream fileOut = new FileOutputStream("notes.txt");
		        //fileOut.write(inputBuffer.toString().getBytes());
		        //fileOut.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			 viewAccounts();
	}
	private static int chooseAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose Type of Account");
		System.out.println("1. Savings Account");
		System.out.println("2. Chequing Account");
	//	System.out.println("3. Back to the previous menu");
		//System.out.println("4. Back to the main menu");
		//System.out.println("Or press 0 to stop");
		int select = sc.nextInt();
		return select;
	}
	private static int userAction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Display current balance");
		System.out.println("2. Deposit Money");
		System.out.println("3. Draw money");
		System.out.println("4. Transfer money to other accounts within the bank");
		System.out.println("5. Pay utility bills");
		//System.out.println("6. Other transactions you would like to add");
		int number = sc.nextInt();
		return number;
	}
	private static int admin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Create client account");
		System.out.println("2. View client accounts");
		System.out.println("3. Edit client accounts");
		//System.out.println("4. Back to the main menu");
		int selection = sc.nextInt();
		return selection;
	}

	private static int showMainMenu() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Are you:");
		System.out.println("1. An Admin");
		System.out.println("2. A User");
		System.out.println("Or press 0 to stop");
		int choice = sc.nextInt();
		return choice;
	}
}
