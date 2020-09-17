package bowling.model;

import java.util.stream.Stream;

public class BowlingGame {

    private Frames frames;
    private int playFrameNo;

    public BowlingGame() {
        this.frames = new Frames();
        this.playFrameNo = 1;
    }

    public void bowling(int countOfPins) {
        playFrameNo = frames.playBowling(playFrameNo, countOfPins);
    }

    public boolean isEnd() {
        return frames.isEnd();
    }

    public int getPlayFrameNo() {
        return playFrameNo;
    }

    public Stream<Frame> getFrames() {
        return frames.getFrames();
    }
}
