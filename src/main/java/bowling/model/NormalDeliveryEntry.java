package bowling.model;

import java.util.LinkedList;
import java.util.stream.Stream;

public class NormalDeliveryEntry {
    private final static int TOTAL_COUNT = 2;

    private LinkedList<Delivery> deliveries;

    private NormalDeliveryEntry(Delivery firstDelivery) {
        deliveries = new LinkedList<>();
        deliveries.add(firstDelivery);
    }

    public static NormalDeliveryEntry of(int firstFallenPins) {
        Delivery firstDelivery = Delivery.of(new Pins(), firstFallenPins);
        return new NormalDeliveryEntry(firstDelivery);
    }

    public void playDelivery(int secondFallenPins) {
        verifyCanSecondDelivery();
        Delivery before = deliveries.getLast();
        deliveries.add(before.next(secondFallenPins));
    }

    private void verifyCanSecondDelivery() {
        if (isEnd()) {
            throw new IllegalStateException("더이상 투구를 할 수 없습니다.");
        }
    }

    public Stream<Delivery> getDeliveries() {
        return deliveries.stream();
    }

    public boolean isEnd() {
        return getState() == State.STRIKE || deliveries.size() == TOTAL_COUNT;
    }

    public State getState() {
        Delivery lastDelivery = deliveries.getLast();
        return lastDelivery.getState();
    }

}
