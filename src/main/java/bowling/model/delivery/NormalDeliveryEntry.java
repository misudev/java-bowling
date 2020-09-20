package bowling.model.delivery;

import bowling.exception.NoLeftDeliveryException;
import bowling.model.State;

import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Stream;

public class NormalDeliveryEntry implements DeliveryEntry {
    private final static int TOTAL_COUNT = 2;

    private LinkedList<Delivery> deliveries;

    private NormalDeliveryEntry(Delivery firstDelivery) {
        deliveries = new LinkedList<>();
        deliveries.add(firstDelivery);
    }

    public static NormalDeliveryEntry of(int firstFallenPins) {
        Delivery firstDelivery = Delivery.of(firstFallenPins);
        return new NormalDeliveryEntry(firstDelivery);
    }

    @Override
    public void roll(int secondFallenPins) {
        verifyCanSecondDelivery();
        Delivery before = deliveries.getLast();
        deliveries.add(before.next(secondFallenPins));
    }

    private void verifyCanSecondDelivery() {
        if (isEnd()) {
            throw new NoLeftDeliveryException();
        }
    }

    @Override
    public Stream<Delivery> getDeliveries() {
        return deliveries.stream();
    }

    @Override
    public boolean isEnd() {
        return getState() == State.STRIKE || deliveries.size() == TOTAL_COUNT;
    }

    @Override
    public State getState() {
        Delivery lastDelivery = deliveries.getLast();
        return lastDelivery.getState();
    }

    @Override
    public int getTotalFallenPins() {
        return deliveries.stream()
                .map(Delivery::getFallenPins)
                .reduce(0, Integer::sum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NormalDeliveryEntry that = (NormalDeliveryEntry) o;
        return Objects.equals(deliveries, that.deliveries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveries);
    }

}
