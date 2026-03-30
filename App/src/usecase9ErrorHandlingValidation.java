public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Validator
        BookingValidator validator = new BookingValidator(inventory);

        // Test cases
        String[] testInputs = {
                "Single Room",     // valid
                "Luxury Room",     // invalid type
                "",                // empty
                "Suite Room"       // valid
        };

        for (String roomType : testInputs) {

            try {
                System.out.println("\nProcessing booking for: " + roomType);

                validator.validateBooking(roomType);

                System.out.println("Booking validation successful for " + roomType);

            } catch (InvalidBookingException e) {

                System.out.println("Booking Failed: " + e.getMessage());
            }
        }

        System.out.println("\nSystem running safely after handling errors.");
    }
}