package OptimizationProcesses.L6;

public class Main {
    public static void main(String[] args) {
        // Создаем автостоянку на 10 мест
        ParkingLot parkingLot = new ParkingLot(10);

        // Создаем несколько автомобилей
        Car car1 = new Car("ABC123");
        Car car2 = new Car("XYZ789");

        // Паркуем автомобили
        parkingLot.parkCar(car1);
        parkingLot.parkCar(car2);

        // Выводим статус парковки
        parkingLot.printParkingStatus();

        // Освобождаем место
        parkingLot.vacateSpot(1);

        // Выводим обновленный статус парковки
        parkingLot.printParkingStatus();
    }
}