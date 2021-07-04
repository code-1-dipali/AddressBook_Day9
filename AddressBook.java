package com.bridgelabz.program.AddressBookManagementProject;
import java.io.File;
import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Utility utility = new Utility();
        File file = new File("F://addressBook.json");
        int count = 1;
        do {
            System.out.println("Welcome to address book problem");
            System.out.println("1.Add contact details to address book");
            System.out.println("2.Edit contact details to address book");
            System.out.println("3.Delete contact details from address book");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Adding the contact in address book");
                    utility.addContactDetails(file);
                    break;
                case 2:
                    System.out.println("Editing the contact in address book");
                    utility.editContactDetails(file);
                    break;
                case 3:
                    System.out.println("Deleting the contact from address book");
                    utility.deleteContactDetails(file);
                    break;
            }
            System.out.println("Press 0 to exit or 1 to access menu again");
            Scanner scanner1 = new Scanner(System.in);
            count = scanner1.nextInt();
        }while(count == 1);
    }
}
