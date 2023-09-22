package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
	private int defaultPasswordLength = 8;
	private int mailboxCapacity = 500;
	private String alternateEmail;
    private String companySuffix= "ABCDcompany.com";
	public Email(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email Created: " + this.firstName+ " "+this.lastName);
		//
		this.department = setDepartment();
		System.out.println("Department:"+ this.department);
		
		//
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your Pwd is: "+ this.password);
		
		//Combine elements to generate email
		email = firstName.toLowerCase()+lastName.toLowerCase()+"@"+department+"."+ companySuffix;
		System.out.println("your email is: " + email);
	}
	private String setDepartment(){
		System.out.println("Department Codes\n1 For Sales\n2 For Development\n3 For Accountig\n0 None\n Enter the Department: " );
        Scanner sc = new Scanner(System.in);
	    int depChoices = sc.nextInt();
		if(depChoices==1){ return "sales"; }
		else if(depChoices==2){ return "dev"; }
		else if(depChoices==3) { return "accnt" ;}
		else{ return "" ;}
		
	}
	// Generate the Random Password
	private String randomPassword(int length){
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#!$%";
		char[] password = new char[length];
		for(int i=0; i<length; i++){
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		
		}
		return new String(password);
	}
	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity){
		this.mailboxCapacity = capacity;
	}
	
	// set the alternate email
	public void setAlternateEmail(String altEmail){
		this.alternateEmail = altEmail;
	}
	
	//change the password
	
	public void changePassword(String password){
		this.password = password;
	}
	
	public int getMailboxCapacity()  { return mailboxCapacity; }
	public String getAlternateEmail() { return alternateEmail; }
	public String getPassword() { return password; }
	
	public String showInfo() {
		return "DISPLAY NAME: " +firstName+" " + lastName +
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
	
	
}
