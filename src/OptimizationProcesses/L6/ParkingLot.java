package OptimizationProcesses.L6;

import java.util.ArrayList;

class ParkingLot {
    private ArrayList<ParkingSpot> spots;

    public ParkingLot(int capacity) {
        spots = new ArrayList<>(capacity);
        int handicappedSpotSize = capacity / 5;
        if (handicappedSpotSize < 1) {
            for (int i = 1; i <= capacity; i++)
                spots.add(new ParkingSpot(i, ParkingSpotType.ANY));
        } else {
            for (int i = 1; i <= capacity - handicappedSpotSize; i++)
                spots.add(new ParkingSpot(i, ParkingSpotType.REGULAR));
            for (int i = capacity - handicappedSpotSize + 1; i <= capacity; i++)
                spots.add(new ParkingSpot(i, ParkingSpotType.HANDICAPPED));
        }
    }

    public ArrayList<ParkingSpot> getAvailableSpots() {
        ArrayList<ParkingSpot> availableSpots = new ArrayList<>();
        for (ParkingSpot spot : spots)
            if (!spot.isOccupied())
                availableSpots.add(spot);
        return availableSpots;
    }

    public boolean parkCar(Car car) {
        ArrayList<ParkingSpot> availableSpots = getAvailableSpots();
        for (ParkingSpot spot : availableSpots) {
            if (car.getSpotType() == ParkingSpotType.HANDICAPPED ||
                    (car.getSpotType() == ParkingSpotType.REGULAR && spot.getSpotType() != ParkingSpotType.HANDICAPPED)) {
                spot.occupy();
                System.out.println("Car " + car.getLicensePlate() + " parked at spot " + spot.getSpotNumber());
                return true;
            } else {
                System.out.println("Car " + car.getLicensePlate() + " spot type mismatch ");
                return false;
            }
        }
        System.out.println("No available parking spots for car " + car.getLicensePlate());
        return false;
    }

    public void vacateSpot(int spotNumber) {
        for (ParkingSpot spot : spots) {
            if (spot.getSpotNumber() == spotNumber) {
                spot.vacate();
                System.out.println("Spot " + spotNumber + " vacated");
                return;
            }
        }
        System.out.println("Invalid spot number: " + spotNumber);
    }


    public void printParkingStatus() {
        System.out.println("Parking Lot Status:");
        for (ParkingSpot spot : spots) {
            System.out.println(spot);
        }
    }
}
