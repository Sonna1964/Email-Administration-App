package emaliapp;

import java.security.SecureRandom;
import java.util.Scanner;

class Email {
    private String firstName;
    private String secondName;
    private String department;
    private int passwordLength = 8;
    private String email;
    private String companySuffix = "virtusa.com";
    private int mailBoxCapacity = 500;
    private String alternateEmail;
    private String password;


    //Constructor to receive the firstName and lastName

    public Email(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        System.out.println("Email Created Successfully : " + this.firstName + " " + this.secondName);

        //Call asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Department is : " + this.department);

        //Call a method that returns a random password
        String randomPassword = generateRandomPassword(passwordLength);
        System.out.println("Generated Password: " + randomPassword + "\n" + "\n");

        //Combine to generate Email
        if (department == null) {
            email = firstName.toLowerCase() + "." + secondName.toLowerCase() + "@" + department + "" + companySuffix;
            System.out.println("*****WELCOME TO VIRTUSA*****\n>>YOUR EMAIL ADDRESS IS : " + email + "\n" + "\n");
        }else {
            email = firstName.toLowerCase() + "." + secondName.toLowerCase() + "@" + department + "." + companySuffix;
            System.out.println("*****WELCOME TO VIRTUSA*****\n>>YOUR EMAIL ADDRESS IS : " + email + "\n" + "\n");
        }

    }

    //Ask for the department

    private String setDepartment() {
        System.out.print("Enter the department\n0 for Sales\n1 for Development\n2 for Accounting\n3 for None\n\nEnter the department code : ");
        Scanner in = new Scanner(System.in);
        int depChoice = 0;
        boolean validInput = false;
        // Loop until a valid integer is entered
        while (!validInput) {
            System.out.print("Please enter an valid integer: ");
            if (in.hasNextInt()) {  // Check if the next token is an integer
                depChoice = in.nextInt();// Read the integer
                if (depChoice <= 3) {
                    validInput = true;// Exit the loop since input is valid
                }
                else{
                    System.out.println("Invalid integer..!!! \n*****PLEASE ENTER AGAIN******");
                }

            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                in.next();  // Discard the invalid input
            }
        }
        if (depChoice == 0) {
            return "dev";
        } else if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "accnt";
        } else {
            return "";
        }
    }

    //Generate a random password
    private String generateRandomPassword(int length) {
        final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%.";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }



    public void setMailBoxCapacity(int mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getPassword() {
        return password;
    }

    public String showInfo(){
        return  "DISPLAY NAME      : " + firstName + " " + secondName + "\n" +
                "COMPANY EMAIL     : " + email + "\n" +
                "MAIL BOX CAPACITY : " + mailBoxCapacity;
    }
}