import java.util.HashMap;

class RoomInventory {

    // HashMap to store room type and availability
    private HashMap<String, Integer> inventory;

    // Constructor initializes inventory
    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Method to get availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Method to update availability
    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Display inventory
    public void displayInventory() {
        System.out.println("===== Room Inventory =====");

        for (String roomType : inventory.keySet()) {
            System.out.println(roomType + " : " + inventory.get(roomType));
        }
    }
}

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App =====");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display current inventory
        inventory.displayInventory();

        System.out.println("\nChecking availability of Double Room:");
        System.out.println("Available: " + inventory.getAvailability("Double Room"));

        // Update availability
        inventory.updateAvailability("Double Room", 2);

        System.out.println("\nAfter booking one Double Room:");
        inventory.displayInventory();
    }
}