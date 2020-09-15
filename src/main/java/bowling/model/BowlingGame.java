package bowling.model;

import java.util.List;

public class BowlingGame {
    public static final int TOTAL_GAME_COUNT = 10;

    private Frames frames;
    private int playFrameNo;

    public BowlingGame() {
        this.frames = new Frames();
        this.playFrameNo = 1;
    }

    public boolean isFinalFrame() {
        return playFrameNo == TOTAL_GAME_COUNT;
    }

    public void bowling(int countOfPins) {
        System.out.println(playFrameNo + " 번 프레임 : " + countOfPins);
        playFrameNo = frames.processFrame(playFrameNo, countOfPins);
        System.out.println();
    }

    public void bowlingFinalFrame(int countOfPins) {

    }

    public int getPlayFrameNo() {
        return playFrameNo;
    }


    public List<NormalFrame> getFrameList() {
        return frames.getNormalFrameList();
    }
}
