package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName, lastName, password, department, email, alternateEmail;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String companySuffix = "company.com";
	
//	Constructor to receive first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
//		Call a method asking for the department
		this.department = setDepartment();
		
//		Call a method that generates a random password
		this.password = randomPassword(defaultPasswordLength);
		
//		Combine elements to generate email
		if(department != "") {
			email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + department + "." + companySuffix;
		} else {
			email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + companySuffix;
		}
	}
	
//	Ask for the department
	private String setDepartment() {
		System.out.print("NEW EMPLOYEE: " + firstName + " " + lastName + "\nDEPARTMENT CODES: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department: ");
		Scanner in = new Scanner(System.in);
		int departmentChoice = in.nextInt();
		
		if(departmentChoice == 1) {
			return "sales";
		} else if (departmentChoice == 2) {
			return "dev";
		} else if (departmentChoice == 3) {
			return "acct";
		} else {
			return "";
		}
	}
	
//	Generate password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		
		for(int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		
		return new String(password);
		
	}
		
//	Set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
//	Get mailbox capacity
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
//	Set alternate email
	public void setAltEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
//	Get alternate email
	public String getAltEmail() {
		return alternateEmail;
	}
	
//	Change password
	public void changePassword(String password) {
		this.password = password;
	}
	
//	Get password
	public String getPassword() {
		return password;
	}
	
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + 
				"\nCOMPANY EMAIL: " + email + 
				" \nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
}
