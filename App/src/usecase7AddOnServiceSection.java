public class usecase7AddOnServiceSection {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App");

        // Example reservation ID (from Use Case 6)
        String reservationId = "SI101";

        // Create service manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Create services
        AddOnService wifi = new AddOnService("WiFi", 500);
        AddOnService breakfast = new AddOnService("Breakfast", 800);
        AddOnService pickup = new AddOnService("Airport Pickup", 1200);

        // Guest selects services
        manager.addService(reservationId, wifi);
        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, pickup);

        // Display selected services
        manager.displayServices(reservationId);

        // Calculate total cost
        double totalCost = manager.calculateTotalCost(reservationId);

        System.out.println("\nTotal Add-On Cost: ₹" + totalCost);

        System.out.println("\nThank you for using Book My Stay App");
    }
}

