public class Room {
    public String roomNumber;
    public String category;
    public double price;
    public boolean isAvailable;

    public Room(String roomNumber, String category, double price, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public String toString() {
        return roomNumber + "," + category + "," + price + "," + isAvailable;
    }
}