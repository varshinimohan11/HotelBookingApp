public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App");

        // Shared inventory
        RoomInventory inventory = new RoomInventory();

        // Shared queue
        ThreadSafeBookingQueue queue = new ThreadSafeBookingQueue();

        // Add multiple booking requests
        queue.addRequest(new BookingRequest("Arun", "Single Room"));
        queue.addRequest(new BookingRequest("Priya", "Single Room"));
        queue.addRequest(new BookingRequest("Kiran", "Single Room"));
        queue.addRequest(new BookingRequest("Divya", "Single Room"));
        queue.addRequest(new BookingRequest("Rahul", "Single Room"));

        // Create multiple threads
        Thread t1 = new ConcurrentBookingProcessor(queue, inventory);
        Thread t2 = new ConcurrentBookingProcessor(queue, inventory);
        Thread t3 = new ConcurrentBookingProcessor(queue, inventory);

        // Start threads
        t1.start();
        t2.start();
        t3.start();

        // Wait for completion
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal Inventory:");
        inventory.displayInventory();

        System.out.println("\nAll bookings processed safely.");
    }
}