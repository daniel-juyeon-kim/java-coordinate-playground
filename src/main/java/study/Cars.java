package study;

import java.util.LinkedList;
import java.util.List;

public class Cars {

    private List<Car> cars = new LinkedList<>();
    public void add(Car car) {
        this.cars.add(car);
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();

        for (Car car : this.cars) {
            report.append(car.generateReport() + "\n");
            report.append("------------------------------" + "\n");
        }

        return report.toString();
    }
}
