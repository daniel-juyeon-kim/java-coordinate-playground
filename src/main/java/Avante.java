public class Avante implements Car {
    private final int literPerKM = 15;
    private int distance;

    public Avante(int distance) {
        this.distance = distance;
    }

    @Override
    public int calculateOilForMoving() {
        return distance / literPerKM;
    }

    @Override
    public String generateReport() {
        return getClass().getName() +" : " + calculateOilForMoving() + "리터";
    }
}
