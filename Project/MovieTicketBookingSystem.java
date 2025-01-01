//Array-Based Movie Ticket Booking System

import java.util.Scanner;

public class MovieTicketBookingSystem {
    static final int ROWS = 10;  
    static final int COLUMNS = 10;  
    static final int TICKET_PRICE = 100;  
    static int[][] seats = new int[ROWS][COLUMNS];  

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int choice;

       
        do {
            System.out.println("\n--- Movie Ticket Booking System ---");
            System.out.println("1. Display Seats");
            System.out.println("2. Book a Seat");
            System.out.println("3. Cancel a Booking");
            System.out.println("4. Calculate Revenue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displaySeats();
                    break;
                case 2:
                    bookSeat(scanner);
                    break;
                case 3:
                    cancelBooking(scanner);
                    break;
                case 4:
                    calculateRevenue();
                    break;
                case 5:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    
    public static void displaySeats() {
        System.out.println("\n--- Seating Chart ---");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bookSeat(Scanner scanner) {
        System.out.print("Enter row (1-5): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter column (1-5): ");
        int col = scanner.nextInt() - 1;

        if (isValidSeat(row, col)) {
            if (seats[row][col] == 0) {
                seats[row][col] = 1;
                System.out.println("Seat booked successfully!");
            } else {
                System.out.println("Seat is already booked!");
            }
        } else {
            System.out.println("Invalid seat number! Please try again.");
        }
    }

    public static void cancelBooking(Scanner scanner) {
        System.out.print("Enter row (1-5): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter column (1-5): ");
        int col = scanner.nextInt() - 1;

        if (isValidSeat(row, col)) {
            if (seats[row][col] == 1) {
                seats[row][col] = 0;
                System.out.println("Booking cancelled successfully!");
            } else {
                System.out.println("Seat is already available!");
            }
        } else {
            System.out.println("Invalid seat number! Please try again.");
        }
    }

public static void calculateRevenue() {
    int bookedSeats = 0;

    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLUMNS; j++) {
            if (seats[i][j] == 1) {
                bookedSeats++;
            }
        }
    }

    int revenue = bookedSeats * TICKET_PRICE;
    System.out.println("Total revenue generated: Rs" +". "+ revenue);
}


    public static boolean isValidSeat(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLUMNS;
    }
}
