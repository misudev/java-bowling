package bowling.model;

public enum State {
    //스트라이크(strike) : 프레임의 첫번째 투구에서 모든 핀(10개)을 쓰러트린 상태
    //스페어(spare) : 프레임의 두번재 투구에서 모든 핀(10개)을 쓰러트린 상태
    //미스(miss) : 프레임의 두번재 투구에서도 모든 핀이 쓰러지지 않은 상태
    //거터(gutter) : 핀을 하나도 쓰러트리지 못한 상태. 거터는 "-"로 표시
    STRIKE, SPARE, MISS, GUTTER;

    public static State getStateByPins(int pins) {
        if (pins == Pins.MAX_PINS) {
            return STRIKE;
        }

        if (pins == Pins.MIN_PINS) {
            return GUTTER;
        }

        return MISS;
    }

}
