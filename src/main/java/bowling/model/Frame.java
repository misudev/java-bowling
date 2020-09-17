package bowling.model;

import java.util.stream.Stream;

public interface Frame {

    //Frame firstRoll(int fallenPins);

    Frame roll(int fallenPins);

    boolean isEnd();

    Stream<Delivery> getDeliveries();

}
