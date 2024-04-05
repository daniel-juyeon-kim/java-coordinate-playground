package study;

public class K5 implements Car{
    private final int literPerKM = 13;
    private int distance;

    public K5(int distance) {
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
