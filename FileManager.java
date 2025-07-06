import java.io.*;
import java.util.*;

public class FileManager {

    public static List<Room> loadRooms(String filename) {
        List<Room> rooms = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                rooms.add(new Room(p[0], p[1], Double.parseDouble(p[2]), Boolean.parseBoolean(p[3])));
            }
        } catch (IOException e) {
            System.out.println("Error loading rooms: " + e.getMessage());
        }
        return rooms;
    }

    public static void saveRooms(String filename, List<Room> rooms) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Room r : rooms) {
                pw.println(r.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving rooms: " + e.getMessage());
        }
    }

    public static List<Booking> loadBookings(String filename) {
        List<Booking> bookings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                bookings.add(new Booking(p[0], p[1], p[2]));
            }
        } catch (IOException e) {
            System.out.println("Error loading bookings: " + e.getMessage());
        }
        return bookings;
    }

    public static void saveBookings(String filename, List<Booking> bookings) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Booking b : bookings) {
                pw.println(b.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving bookings: " + e.getMessage());
        }
    }
}