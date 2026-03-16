 abstract class Room {
        String type;
        int beds;
        double price;

        Room(String type, int beds, double price) {
            this.type = type;
            this.beds = beds;
            this.price = price;
        }

        void displayRoom() {
            System.out.println("Room Type: " + type);
            System.out.println("Beds: " + beds);
            System.out.println("Price: Rs." + price);
        }
    }

    // Room Types
    class SingleRoom extends Room {
        SingleRoom() {
            super("Single Room", 1, 1500);
        }
    }

    class DoubleRoom extends Room {
        DoubleRoom() {
            super("Double Room", 2, 2500);
        }
    }

    class SuiteRoom extends Room {
        SuiteRoom() {
            super("Suite Room", 3, 5000);
        }
    }

    // Inventory Class
    class RoomInventory {

        private HashMap<String, Integer> inventory;

        RoomInventory() {
            inventory = new HashMap<>();
            inventory.put("Single Room", 5);
            inventory.put("Double Room", 0); // unavailable example
            inventory.put("Suite Room", 2);
        }

        int getAvailability(String roomType) {
            return inventory.getOrDefault(roomType, 0);
        }
    }

    // Search Service
    class RoomSearchService {

        RoomInventory inventory;

        RoomSearchService(RoomInventory inventory) {
            this.inventory = inventory;
        }

        void searchRooms(Room[] rooms) {

            System.out.println("Available Rooms:\n");

            for (Room room : rooms) {

                int available = inventory.getAvailability(room.type);

                if (available > 0) {
                    room.displayRoom();
                    System.out.println("Available: " + available);
                    System.out.println("--------------------");
                }
            }
        }
    }

    // Main Class
    public class UseCase4RoomSearch {

        public static void main(String[] args) {

            System.out.println("===== Book My Stay App =====\n");

            RoomInventory inventory = new RoomInventory();

            Room[] rooms = {
                    new SingleRoom(),
                    new DoubleRoom(),
                    new SuiteRoom()
            };

            RoomSearchService search = new RoomSearchService(inventory);

            search.searchRooms(rooms);
        }
    }