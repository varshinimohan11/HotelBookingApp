public class UseCase5BookingRequestQueue {
    // Reservation class
    class Reservation {

        String guestName;
        String roomType;

        Reservation(String guestName, String roomType) {
            this.guestName = guestName;
            this.roomType = roomType;
        }

        void displayReservation() {
            System.out.println("Guest: " + guestName + " | Room Type: " + roomType);
        }
    }

    // Booking Request Queue
    class BookingRequestQueue {

        private Queue<Reservation> queue;

        BookingRequestQueue() {
            queue = new LinkedList<>();
        }

        // Add request to queue
        void addRequest(Reservation reservation) {
            queue.add(reservation);
            System.out.println("Request added for " + reservation.guestName);
        }

        // Display all requests
        void showRequests() {

            System.out.println("\nBooking Requests in Queue:");

            for (Reservation r : queue) {
                r.displayReservation();
            }
        }
    }

    // Main Class
    public class UseCase5BookingRequestQueue {

        public static void main(String[] args) {

            System.out.println("===== Book My Stay App =====");

            BookingRequestQueue requestQueue = new BookingRequestQueue();

            // Guest booking requests
            Reservation r1 = new Reservation("Alice", "Single Room");
            Reservation r2 = new Reservation("Bob", "Double Room");
            Reservation r3 = new Reservation("Charlie", "Suite Room");

            // Add requests to queue
            requestQueue.addRequest(r1);
            requestQueue.addRequest(r2);
            requestQueue.addRequest(r3);

            // Show queue
            requestQueue.showRequests();
        }
    }
}