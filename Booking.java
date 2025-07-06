public class Booking {
    public String bookingId;
    public String userName;
    public String roomNumber;

    public Booking(String bookingId, String userName, String roomNumber) {
        this.bookingId = bookingId;
        this.userName = userName;
        this.roomNumber = roomNumber;
    }

    public String toString() {
        return bookingId + "," + userName + "," + roomNumber;
    }
}