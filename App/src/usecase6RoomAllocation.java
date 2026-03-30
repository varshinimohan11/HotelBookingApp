public class RoomSearchService {

    private RoomInventory inventory;

    public RoomSearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void searchAvailableRooms() {

        System.out.println("\nAvailable Rooms:\n");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        checkAndDisplay(single);
        checkAndDisplay(doubleRoom);
        checkAndDisplay(suite);
    }

    private void checkAndDisplay(Room room) {

        int available = inventory.getAvailability(room.getRoomType());

        if (available > 0) {
            room.displayRoomDetails();
            System.out.println("Available Rooms: " + available);
            System.out.println();
        }
    }
}