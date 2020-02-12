package designPatterns.produceConsume.oneOneCountDownLatch;

public class Baozi {
    String skin;
    String stuffing;

    public Baozi(String stuffing) {
        this.stuffing = stuffing;
    }

    @Override
    public String toString() {
        return "Baozi{" +
                "stuffing='" + stuffing + '\'' +
                '}';
    }
}
