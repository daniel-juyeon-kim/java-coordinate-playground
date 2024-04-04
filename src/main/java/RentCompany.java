public class RentCompany {

    private Cars cars = new Cars();

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public String generateReport() {
        return cars.generateReport();
    }
}
