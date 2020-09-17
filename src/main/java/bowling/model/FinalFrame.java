package bowling.model;


import java.util.stream.Stream;

public class FinalFrame implements Frame {

    private FinalDeliveryEntry finalDeliveryEntry;

    private FinalFrame(FinalDeliveryEntry finalfinalDeliveryEntry) {
        this.finalDeliveryEntry = finalfinalDeliveryEntry;
    }

   // @Override
    public static Frame firstRoll(int fallenPins) {
        FinalDeliveryEntry finalDeliveryEntry = new FinalDeliveryEntry(fallenPins);
        return new FinalFrame(finalDeliveryEntry);

    }

    @Override
    public Frame roll(int fallenPins) {
        finalDeliveryEntry.playDelivery(fallenPins);
        return new FinalFrame(finalDeliveryEntry);
    }

    @Override
    public boolean isEnd() {
        return finalDeliveryEntry.isEnd();
    }

    @Override
    public Stream<Delivery> getDeliveries() {
        return finalDeliveryEntry.getDeliveries();
    }

}
