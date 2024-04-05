package study;

public class Sonata implements Car{

    private final int literPerKM = 10;
    private int distance;

    public Sonata(int distance) {
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
