import java.util.HashMap;
import java.util.Map;

// Vehicle class
class Vehicle {
    private String plateNumber;
    
    public Vehicle(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    
    public String getPlateNumber() {
        return plateNumber;
    }
}

// ParkingSpot class
class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private Vehicle vehicle;
    
    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isOccupied = false;
    }
    
    public boolean parkVehicle(Vehicle vehicle) {
        if (!isOccupied) {
            this.vehicle = vehicle;
            this.isOccupied = true;
            return true;
        }
        return false;
    }
    
    public boolean removeVehicle() {
        if (isOccupied) {
            this.vehicle = null;
            this.isOccupied = false;
            return true;
        }
        return false;
    }
    
    public boolean isOccupied() {
        return isOccupied;
    }
    
    public int getSpotNumber() {
        return spotNumber;
    }
}

// ParkingLot class
class ParkingLot {
    private Map<Integer, ParkingSpot> spots;
    
    public ParkingLot(int capacity) {
        spots = new HashMap<>();
        for (int i = 1; i <= capacity; i++) {
            spots.put(i, new ParkingSpot(i));
        }
    }
    
    public boolean parkVehicle(int spotNumber, Vehicle vehicle) {
        ParkingSpot spot = spots.get(spotNumber);
        if (spot != null) {
            return spot.parkVehicle(vehicle);
        }
        return false;
    }
    
    public boolean removeVehicle(int spotNumber) {
        ParkingSpot spot = spots.get(spotNumber);
        if (spot != null) {
            return spot.removeVehicle();
        }
        return false;
    }
    
    public void displayAvailableSpots() {
        System.out.println("Available parking spots:");
        for (ParkingSpot spot : spots.values()) {
            if (!spot.isOccupied()) {
                System.out.print(spot.getSpotNumber() + " ");
            }
        }
        System.out.println();
    }
}

// Main class
public class ParkingLotManagement {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5);
        
        Vehicle car1 = new Vehicle("ABC123");
        Vehicle car2 = new Vehicle("XYZ789");
        
        parkingLot.parkVehicle(1, car1);
        parkingLot.parkVehicle(3, car2);
        
        parkingLot.displayAvailableSpots();
        
        parkingLot.removeVehicle(1);
        parkingLot.displayAvailableSpots();
    }
}
