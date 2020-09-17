package bowling.model;

import java.util.List;
import java.util.stream.Stream;

public class NormalFrame implements Frame {

    private NormalDeliveryEntry normalDeliveryEntry;
    private State state;

    public NormalFrame() {
    }

    private NormalFrame(NormalDeliveryEntry normalDeliveryEntry) {
        this.normalDeliveryEntry = normalDeliveryEntry;
        setStateAfterDelivery();
    }

//    @Override
    public static Frame firstRoll(int fallenPins) {
        NormalDeliveryEntry normalDeliveryEntry = NormalDeliveryEntry.of(fallenPins);
        return new NormalFrame(normalDeliveryEntry);
    }

    @Override
    public Frame roll(int fallenPins) {
        normalDeliveryEntry.playDelivery(fallenPins);
        return new NormalFrame(normalDeliveryEntry);
    }

    @Override
    public boolean isEnd() {
        return normalDeliveryEntry.isEnd();
    }


    private void setStateAfterDelivery() {
        state = normalDeliveryEntry.getState();
    }

    public boolean isStrike() {
        return state == State.STRIKE;
    }

    @Override
    public Stream<Delivery> getDeliveries() {
        return normalDeliveryEntry.getDeliveries();
    }

}
