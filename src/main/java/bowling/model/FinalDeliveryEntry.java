package bowling.model;

import java.util.ArrayList;
import java.util.List;

public class FinalDeliveryEntry {
    private final static int DEFAULT_COUNT = 2;
    private List<Delivery> deliveries;
    private boolean canBonusDelivery;

    public FinalDeliveryEntry() {
        deliveries = new ArrayList<>();
        canBonusDelivery = false;
    }

    public void playDelivery(int fallenPins) {
        if (deliveries.isEmpty()) {
            deliveries.add(playFirstDelivery(fallenPins));
            return;
        }

        Delivery delivery = delivery(fallenPins);
        if (!canBonusDelivery) {
            verifyCanBonusDelivery(delivery);
        }

        deliveries.add(delivery);

    }

    private Delivery playFirstDelivery(int fallenPins) {
        Delivery firstDelivery = Delivery.of(new Pins(), fallenPins);
        if (firstDelivery.getState() == State.STRIKE) {
            canBonusDelivery = true;
        }

        return firstDelivery;
    }

    private Delivery delivery(int fallenPins) {
        Delivery before = deliveries.get(deliveries.size() - 1);
        if (before.getState() == State.STRIKE || before.getState() == State.SPARE) {
            return Delivery.of(new Pins(), fallenPins);
        }

        return before.next(fallenPins);
    }

    private void verifyCanBonusDelivery(Delivery secondDelivery) {
        State state = secondDelivery.getState();
        if (state == State.STRIKE || state == State.SPARE) {
            canBonusDelivery = true;
        }
    }

    public boolean isEnd() {
        return canBonusDelivery ? isEndBonusDelivery() : isEndNotBonusDelivery();
    }

    private boolean isEndNotBonusDelivery() {
        return deliveries.size() == DEFAULT_COUNT;
    }

    private boolean isEndBonusDelivery() {
        return deliveries.size() == DEFAULT_COUNT + 1;
    }

}
