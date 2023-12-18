package OptimizationProcesses.L6;

class Car {
    private String licensePlate;

    private ParkingSpotType spotType;

    public Car(String licensePlate,  ParkingSpotType spotType) {
        this.licensePlate = licensePlate;
        this.spotType = spotType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public ParkingSpotType getSpotType() {
        return spotType;
    }


    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                ", spotType=" + spotType +
                '}';
    }
}