package OptimizationProcesses.L6;

class ParkingSpot {
    private final int spotNumber;
    private boolean occupied;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.occupied = false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return occupied;
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
                '}';
    }
}