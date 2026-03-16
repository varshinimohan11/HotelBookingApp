abstract class Room {
    String roomType;
    int beds;
    int size;
    double price;

    Room(String roomType, int beds, int size, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    void displayRoom() {
        System.out.println("Room Type : " + roomType);
        System.out.println("Beds      : " + beds);
        System.out.println("Size      : " + size + " sq.ft");
        System.out.println("Price     : Rs." + price);
    }
}

class SingleRoom extends Room {
    SingleRoom() {
        super("Single Room", 1, 200, 1500);
    }
}

class DoubleRoom extends Room {
    DoubleRoom() {
        super("Double Room", 2, 350, 2500);
    }
}

class SuiteRoom extends Room {
    SuiteRoom() {
        super("Suite Room", 3, 500, 5000);
    }
}

public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        // Static availability variables
        int singleAvailability = 5;
        int doubleAvailability = 3;
        int suiteAvailability = 2;

        // Polymorphism
        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        System.out.println("===== Book My Stay App =====");
        System.out.println("Room Types and Availability\n");

        r1.displayRoom();
        System.out.println("Available : " + singleAvailability);
        System.out.println("-----------------------------");

        r2.displayRoom();
        System.out.println("Available : " + doubleAvailability);
        System.out.println("-----------------------------");

        r3.displayRoom();
        System.out.println("Available : " + suiteAvailability);
    }
}