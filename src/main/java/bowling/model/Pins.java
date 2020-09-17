package bowling.model;

public class Pins {
    public static final int MIN_PINS = 0;
    public static final int MAX_PINS = 10;

    private int countOfPins;

    public Pins() {
        countOfPins = MAX_PINS;
    }

    public Pins(int countOfPins) {
        this.countOfPins = countOfPins;
    }

    public static Pins remainPins(int fallenPins) {
        return new Pins(MAX_PINS - fallenPins);
    }

    public void fallingPins(int fallenPins) {
        validatePins(fallenPins);
        validateLastPins(fallenPins);

        this.countOfPins -= fallenPins;
    }

    public boolean areAllPinsFallen() {
        return this.countOfPins == MIN_PINS;
    }

    private void validatePins(int pins) {
        if (pins < MIN_PINS) {
            throw new IllegalArgumentException("최소 핀의 갯수는 0개 입니다.");
        }

        if (pins > MAX_PINS) {
            throw new IllegalArgumentException("최대 핀의 갯수는 10개 입니다.");
        }
    }

    private void validateLastPins(int fallenPins) {
        if (countOfPins - fallenPins < MIN_PINS) {
            throw new IllegalArgumentException("넘어뜨린 최대 핀의 갯수는 10개 입니다.");
        }
    }

}
