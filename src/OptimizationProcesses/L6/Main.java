package OptimizationProcesses.L6;

public class Main {
    public static void main(String[] args) {
        // Создаем автостоянку на 10 мест
        ParkingLot parkingLot = new ParkingLot(5);

        // Создаем несколько автомобилей разных размеров
        Car car1 = new Car("ABC123",  ParkingSpotType.REGULAR);
        Car car2 = new Car("XYZ789",  ParkingSpotType.REGULAR);
        Car car3 = new Car("DEF456",  ParkingSpotType.HANDICAPPED);

        // Паркуем автомобили
        parkingLot.parkCar(car1);
        parkingLot.parkCar(car1);
        parkingLot.parkCar(car1);
        parkingLot.parkCar(car1);
        parkingLot.parkCar(car2);
        parkingLot.parkCar(car3);

        // Выводим статус парковки
        parkingLot.printParkingStatus();

        // Освобождаем место
        parkingLot.vacateSpot(1);

        // Выводим статус парковки после освобождения места
        parkingLot.printParkingStatus();
    }
}