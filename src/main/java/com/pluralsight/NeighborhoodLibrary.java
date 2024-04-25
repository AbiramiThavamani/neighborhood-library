package com.pluralsight;


import java.util.Scanner;

public class NeighborhoodLibrary {

    //main method
    public static void main(String[] args) {
        //books inventory
        Book[] books = new Book[5];
        books[0] = new Book(1, "978-0-13-601970-1", "Trust", "");
        books[1] = new Book(2, "978-0-13-601971-2", "The Coming", "");
        books[2] = new Book(3, "978-0-13-601972-4", "Bitter Sweet", "");
        books[3] = new Book(4, "978-0-13-601973-3", "Caste", "");
        books[4] = new Book(5, "978-0-13-601974-9", "IRON FLAME", "");

        NeighborhoodLibrary library = new NeighborhoodLibrary();
        library.homeScreen(books);
    }

    //home screen is display a list of options
    public void homeScreen(Book[] books){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value 1 to Show Available Books");
        System.out.println("Enter the value 2 to Show Checked Out Books");
        System.out.println("Enter the value 3 to Exit Application");

        int homeMenu = scanner.nextInt();
        NeighborhoodLibrary library = new NeighborhoodLibrary();

        if (homeMenu == 1) {
            System.out.println("selected menu show available books");
            library.showAvailableBooks(books);
        } else if (homeMenu == 2) {
            System.out.println("selected menu show Checked Out Books");
            library.showCheckedBooks(books);
        } else if (homeMenu == 3) {
            System.out.println("Exit Application");
        } else {
            System.out.println("invalid number");
        }
    }

    // display showAvailable Books
   public void showAvailableBooks(Book[] books) {
       System.out.println("Available books are:");
        for (int i = 0; i<books.length; i++) {
            if (!books[i].isCheckedOut()){
                System.out.println(books[i].getId() + "   " + books[i].getIsbn() + "   " + books[i].getTitle());
            }
        }
        Scanner scanner = new Scanner(System.in);
       System.out.println("Select below options");
       System.out.println("C for check out");
       System.out.println("X for home screen");
       String options = scanner.next();

       NeighborhoodLibrary neighborhoodlibrary = new NeighborhoodLibrary();
       if(options.equals("C")) {
           System.out.println("Enter Book Details:");
           System.out.println("Enter Book ID:");
           int id = scanner.nextInt();
           System.out.println("Enter Your Name:");
           String name = scanner.next();
           neighborhoodlibrary.checkOut(id, name, books);
           neighborhoodlibrary.homeScreen(books);
       } else if (options.equals("X")){
           neighborhoodlibrary.homeScreen(books);
       } else {
           System.out.println("Invalid Option");
       }
   }

   // display showCheckedBooks
    public void showCheckedBooks(Book[] books) {
        System.out.println("Checked out books are:");
        for (int i = 0; i < books.length; i++) {
            if (books[i].isCheckedOut()) {
                System.out.println(books[i].getId() + "   " + books[i].getIsbn() + "   " + books[i].getTitle());
            }
        }
        System.out.println("Check in options");
        System.out.println("C for check in");
        System.out.println("X for home screen");
        Scanner scanner = new Scanner(System.in);
        String options = scanner.next();
        NeighborhoodLibrary neighborhoodlibrary = new NeighborhoodLibrary();;
        if (options.equals("C")) {
            System.out.println("Enter book id:");
            int id = scanner.nextInt();
            neighborhoodlibrary.checkIn(id, books);
            neighborhoodlibrary.homeScreen(books);
        } else if (options.equals("X")) {
            neighborhoodlibrary.homeScreen(books);
        } else {
            System.out.println("Invalid Option");
        }
    }

    // method checkIn
    public void checkIn(int id, Book[] books){
        for (int i = 0; i<books.length; i++){
            if (books[i].getId()==id){
                books[i].setCheckedOut(false);
                books[i].setCheckedOutTo("");
            }
        }
        System.out.println("Checked in successfully");
    }

    // method checkOut
    public void checkOut(int id, String name, Book[] books){
        for (int i = 0; i<books.length; i++){
            if (books[i].getId()==id){
                books[i].setCheckedOut(true);
                books[i].setCheckedOutTo(name);
            }
        }
        System.out.println("checked out successfully");
    }

}