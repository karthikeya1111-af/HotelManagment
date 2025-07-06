import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Hotel Reservation Menu ---");
            System.out.println("1. Show Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booking");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // flush newline

            switch (ch) {
                case 1:
                    System.out.print("Enter category (Standard/Deluxe/Suite) or blank for all: ");
                    String cat = sc.nextLine();
                    hotel.showAvailableRooms(cat.isEmpty() ? null : cat);
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter room category: ");
                    String category = sc.nextLine();
                    hotel.bookRoom(name, category);
                    break;
                case 3:
                    System.out.print("Enter booking ID: ");
                    String cancelId = sc.nextLine();
                    hotel.cancelBooking(cancelId);
                    break;
                case 4:
                    System.out.print("Enter booking ID: ");
                    String viewId = sc.nextLine();
                    hotel.viewBooking(viewId);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }
}