package bowling.model;

import java.util.LinkedList;
import java.util.stream.Stream;

public class Frames {
    public static final int TOTAL_FRAME_COUNT = 10;

    private LinkedList<Frame> frames;

    public Frames() {
         frames = new LinkedList<>();
    }

    public int playBowling(int frameNo, int pins) {
        if (remainDelivery(frameNo)) {
            Frame now = frames.pollLast();
            frames.add(now.roll(pins));

            return frames.getLast().isEnd() ? frameNo + 1 : frameNo;
        }

        Frame newFrame = isFinalFrame(frameNo) ? firstRollWithFinalFrame(pins) : firstRollWithNormalFrame(pins);
        frames.add(newFrame);
        return newFrame.isEnd() ? frameNo + 1 : frameNo;

    }

    private boolean remainDelivery(int frameNo) {
        return frames.size() == frameNo;
    }

    private Frame firstRollWithFinalFrame(int pins) {
        return FinalFrame.firstRoll(pins);
    }

    private Frame firstRollWithNormalFrame(int pins) {
        return NormalFrame.firstRoll(pins);
    }

    private boolean isFinalFrame(int frameNo) {
        return frameNo == TOTAL_FRAME_COUNT;
    }

    public boolean isEnd() {
        return frames.size() == TOTAL_FRAME_COUNT && frames.getLast().isEnd();
    }

    public Stream<Frame> getFrames() {
        return frames.stream();
    }

}
