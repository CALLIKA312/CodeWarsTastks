package OptimizationProcesses.L6;

class ParkingSpot {
    private int spotNumber;
    private boolean occupied;
    private ParkingSpotType spotType;

    public ParkingSpot(int spotNumber, ParkingSpotType spotType) {
        this.spotNumber = spotNumber;
        this.occupied = false;
        this.spotType = spotType;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public ParkingSpotType getSpotType() {
        return spotType;
    }

    public void occupy() {
        occupied = true;
    }

    public void vacate() {
        occupied = false;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotNumber=" + spotNumber +
                ", occupied=" + occupied +
                ", spotType=" + spotType +
                '}';
    }
}