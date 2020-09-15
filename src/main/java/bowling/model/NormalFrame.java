package bowling.model;

import java.util.List;

public class NormalFrame {

    private NormalDeliveryEntry normalDeliveryEntry;
    private State state;

    private NormalFrame(NormalDeliveryEntry normalDeliveryEntry) {
        this.normalDeliveryEntry = normalDeliveryEntry;
        if (normalDeliveryEntry.isStrike()) {
            state = State.STRIKE;
        }
    }

    public static NormalFrame of(int firstPins) {
        NormalDeliveryEntry normalDeliveryEntry = NormalDeliveryEntry.of(firstPins);
        return new NormalFrame(normalDeliveryEntry);
    }

    public void secondDelivery(int secondPins) {
        normalDeliveryEntry.playSecondDelivery(secondPins);
        if (normalDeliveryEntry.isSpare()) {
            state = State.SPARE;
            return;
        }

        state = State.MISS;
    }

    public boolean isStrike() {
        return state == State.STRIKE;
    }

    public List<Delivery> getDeliveries() {
        return normalDeliveryEntry.getDeliveries();
    }

}
