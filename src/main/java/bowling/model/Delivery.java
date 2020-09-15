package bowling.model;

public class Delivery {
    private final int fallenPins;
    private final State state;

    private Delivery(int fallenPins, State state) {
        this.fallenPins = fallenPins;
        this.state = state;
    }

    public static Delivery of(Pins pins, int fallenPins) {
        pins.fallingPins(fallenPins);
        return new Delivery(fallenPins, State.getStateByPins(fallenPins));
    }

    public Delivery next(int nextFallenPins) {
        Pins remainPins = Pins.remainPins(fallenPins);
        remainPins.fallingPins(nextFallenPins);

        if (remainPins.areAllPinsFallen()) {
            return new Delivery(nextFallenPins, State.SPARE);
        }

        return new Delivery(nextFallenPins, State.getStateByPins(nextFallenPins));
    }

    public State getState() {
        return state;
    }

    public int getFallenPins() {
        return fallenPins;
    }
}
