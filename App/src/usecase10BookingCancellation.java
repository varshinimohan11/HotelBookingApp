import java.util.HashMap;

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Create reservations
        HashMap<String, Reservation> reservationMap = new HashMap<>();

        Reservation r1 = new Reservation("SI101", "Arun", "Single Room");
        Reservation r2 = new Reservation("DO202", "Priya", "Double Room");

        reservationMap.put(r1.getReservationId(), r1);
        reservationMap.put(r2.getReservationId(), r2);

        // Cancellation service
        CancellationService service = new CancellationService(inventory, reservationMap);

        // Perform cancellations
        service.cancelBooking("SI101");   // valid
        service.cancelBooking("SI101");   // duplicate
        service.cancelBooking("XX999");   // invalid

        // Show rollback stack
        service.displayRollbackStack();

        // Display reservation states
        System.out.println("\nReservation Status:");
        r1.display();
        r2.display();

        System.out.println("\nThank you for using Book My Stay App");
    }
}