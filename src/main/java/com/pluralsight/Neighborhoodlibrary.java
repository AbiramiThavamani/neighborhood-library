package com.pluralsight;


import java.time.LocalDate;
import java.util.Scanner;

public class Neighborhoodlibrary {
    public static void main(String[] args) {
        //books inventory
        Book[] books = new Book[5];
        books[0] = new Book(116148870, "978-0-13-601970-1", "Trust", "");
        books[1] = new Book(116148871, "978-0-13-601971-2", "The Coming", "");
        books[2] = new Book(116148870, "978-0-13-601972-4", "Bitter Sweet", "");
        books[3] = new Book(116148870, "978-0-13-601973-3", "Caste", "");
        books[4] = new Book(116148870, "978-0-13-601974-9", "IRON FLAME", "");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value 1 to Show Available Books");
        System.out.println("Enter the value 2 to Show Checked Out Books");
        System.out.println("Enter the value 3 to Exit Application");

        int homeMenu = scanner.nextInt();
//        System.out.println(homeMenu);

        if (homeMenu == 1) {
            System.out.println("available books");
        } else if (homeMenu == 2) {
            System.out.println("show Checked Out Books");
        } else if (homeMenu == 3) {
            System.out.println("Exit Application");
        } else {
            System.out.println("invalid number");
        }

        Neighborhoodlibrary library = new Neighborhoodlibrary();
        library.showAvailableBooks(books);
    }

   public void showAvailableBooks(Book[] books) {
        for (int i = 0; i<books.length; i++) {
           if (!books[i].isCheckedOut()){
               System.out.println(books[i].getId() + "   " + books[i].getIsbn() + "   " + books[i].getTitle());
           }

        }
   }





//        // Method for checking out;
//        public void checkOut(String name) {
//            if (!isCheckedOut) {
//                isCheckedOut = true;
//                CheckedOutTo = name;
//                System.out.println(title + "has been checked out to " + name);
//            } else {
//                System.out.println(title + " is already checked out ");
//            }
//        }
//            // Method for checkIn;
//            public void checkIn () {
//                if (isCheckedOut) {
//                    isCheckedOut = false;
//                    System.out.println(title + " has been checked in ");
//                } else {
//                    System.out.println(title + " is not checked out ");
//                }
//            }
//        }

}