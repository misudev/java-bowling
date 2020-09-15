package bowling.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class NormalDeliveryEntry {

    private Delivery firstDelivery;
    private Delivery secondDelivery;

    private NormalDeliveryEntry(Delivery firstDelivery) {
        this.firstDelivery = firstDelivery;
    }

    public static NormalDeliveryEntry of(int firstFallenPins) {
        Delivery firstDelivery = Delivery.of(new Pins(), firstFallenPins);
        return new NormalDeliveryEntry(firstDelivery);
    }

    public void playSecondDelivery(int secondFallenPins) {
        verifyCanSecondDelivery();
        this.secondDelivery = firstDelivery.next(secondFallenPins);
    }

    private void verifyCanSecondDelivery() {
        if (isStrike()) {
            throw new IllegalStateException("스트라이크인 경우 두번째 투구를 할 수 없습니다.");
        }
    }

    public boolean isStrike() {
        return State.STRIKE == firstDelivery.getState();
    }

    public boolean isSpare() {
        return State.SPARE == secondDelivery.getState();
    }

    public List<Delivery> getDeliveries() {
        List<Delivery> deliveries = new ArrayList<>();
        deliveries.add(firstDelivery);

        if (isStrike() || Objects.isNull(secondDelivery)) {
            return Collections.unmodifiableList(deliveries);
        }

        deliveries.add(secondDelivery);
        return Collections.unmodifiableList(deliveries);
    }
}
