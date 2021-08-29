package com.greatlearning.models;
import java.util.Scanner;

public class Employee {
	 private String fName;
     private String lName;
     private String pass;
     private String dept;
     private String email;
     private int defaultPasswordLength=10;
     private String alternateEmail;
     private String companySuffix="company.com";

  
     public Employee(String fName,String lName) {
         this.fName = fName;
         this.lName = lName;
 

         
         this.dept=setDepartment();

         this.pass=randomPassword(defaultPasswordLength);
         
         email=fName.toLowerCase()+"."+lName.toLowerCase()+"@" +dept+"."+companySuffix;
         System.out.println("Dear, "+fName+" your generated credentials are as follows\n");
         System.out.println("Email-->"+this.email+"\n");
         System.out.println("Password -->"+this.pass+"\n\n");

     }

     private String setDepartment() {
         System.out.print("Please enter the DEPARTMENT from the following :\n1. Technical \n2. Admin\n3. Human Resource \n4. Legal \nEnter the department code: ");
         Scanner in=new Scanner(System.in);
         int depchoice=in.nextInt();
         if(depchoice==1) {
             return "technical";
         }
         else if(depchoice==2) {
             return "admin";
         }
         else if(depchoice==3) {
             return "human_resource";
         }
         else if(depchoice==4) {
             return "legal";
         }
         else {
             return "";
         }
     }
     
     private String randomPassword(int length) {
         String passwordSet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
         char[] password=new char[length];
         for(int i=0;i<length;i++) {
             int rand=(int) (Math.random()*passwordSet.length());
             password[i]=passwordSet.charAt(rand);
         }
         return new String(password);
     }

  
     public void setAlternateEmail(String altEmail) {
         this.alternateEmail=altEmail;
     }

     
     public void changePassword(String password) {
         this.pass=password;
     }

     public String getAlternateEmail() { return alternateEmail; }
     public String getPassword() { return pass; }

     public String showinfo() {
         return "DISPLAY NAME: "+fName+" "+lName+
                 "\nCOMPANY EMAIL: "+email+"\n";
     }
}
