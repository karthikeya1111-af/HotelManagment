import java.util.*;

public class Hotel {
    private List<Room> rooms;
    private List<Booking> bookings;

    public Hotel() {
        rooms = FileManager.loadRooms("rooms.txt");
        bookings = FileManager.loadBookings("bookings.txt");
    }

    public void showAvailableRooms(String category) {
        boolean found = false;
        System.out.println("Available Rooms:");
        for (Room r : rooms) {
            if (r.isAvailable && (category == null || r.category.equalsIgnoreCase(category))) {
                System.out.println("Room " + r.roomNumber + " - " + r.category + " - ₹" + r.price);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available rooms.");
        }
    }

    public void bookRoom(String userName, String category) {
        for (Room r : rooms) {
            if (r.isAvailable && r.category.equalsIgnoreCase(category)) {
                r.isAvailable = false;
                String bookingId = UUID.randomUUID().toString();
                Booking b = new Booking(bookingId, userName, r.roomNumber);
                bookings.add(b);
                System.out.println("Booking successful. ID: " + bookingId);
                FileManager.saveRooms("rooms.txt", rooms);
                FileManager.saveBookings("bookings.txt", bookings);
                return;
            }
        }
        System.out.println("No available rooms in this category.");
    }

    public void cancelBooking(String bookingId) {
        Booking toRemove = null;
        for (Booking b : bookings) {
            if (b.bookingId.equals(bookingId)) {
                toRemove = b;
                break;
            }
        }
        if (toRemove != null) {
            bookings.remove(toRemove);
            for (Room r : rooms) {
                if (r.roomNumber.equals(toRemove.roomNumber)) {
                    r.isAvailable = true;
                }
            }
            System.out.println("Booking cancelled.");
            FileManager.saveRooms("rooms.txt", rooms);
            FileManager.saveBookings("bookings.txt", bookings);
        } else {
            System.out.println("Booking ID not found.");
        }
    }

    public void viewBooking(String bookingId) {
        for (Booking b : bookings) {
            if (b.bookingId.equals(bookingId)) {
                System.out.println("Booking ID: " + b.bookingId);
                System.out.println("Name: " + b.userName);
                System.out.println("Room: " + b.roomNumber);
                return;
            }
        }
        System.out.println("Booking ID not found.");
    }
}