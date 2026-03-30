public class usecase8BookingHistoryReport {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App");

        // Initialize booking history
        BookingHistory history = new BookingHistory();

        // Add confirmed bookings
        history.addReservation(new Reservation("SI101", "Arun", "Single Room"));
        history.addReservation(new Reservation("DO202", "Priya", "Double Room"));
        history.addReservation(new Reservation("SU303", "Kiran", "Suite Room"));
        history.addReservation(new Reservation("SI104", "Divya", "Single Room"));

        // Display booking history
        history.displayHistory();

        // Generate report
        BookingReportService reportService = new BookingReportService(history);
        reportService.generateReport();

        System.out.println("\nThank you for using Book My Stay App");
    }
}

