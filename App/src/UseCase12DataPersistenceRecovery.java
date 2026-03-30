public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App");

        PersistenceService persistence = new PersistenceService();

        // Try to load previous state
        SystemState state = persistence.load();

        RoomInventory inventory = new RoomInventory();
        BookingHistory history = new BookingHistory();

        if (state != null) {
            inventory.setInventory(state.getInventoryData());

            for (Reservation r : state.getBookingHistory()) {
                history.addReservation(r);
            }

            System.out.println("\nRecovered Previous State:");
            inventory.displayInventory();
            history.displayHistory();

        } else {
            // Fresh state
            history.addReservation(new Reservation("SI101", "Arun", "Single Room"));
            history.addReservation(new Reservation("DO202", "Priya", "Double Room"));

            System.out.println("\nNew Data Created:");
            history.displayHistory();
        }

        // Save current state before exit
        SystemState newState = new SystemState(
                inventory.getAllInventory(),
                history.getAllReservations()
        );

        persistence.save(newState);

        System.out.println("\nSystem ready for next restart.");
    }
}