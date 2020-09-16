package bowling.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Frames {

    private List<NormalFrame> normalFrameList;
    private FinalFrame finalFrame;

    public Frames() {
        normalFrameList = new ArrayList<>();
    }

    public int processFrame(int frameNo, int pins) {
        if (isSecondDeliveryOf(frameNo)) {
            NormalFrame targetFrame = normalFrameList.get(frameNo);
            targetFrame.secondDelivery(pins);

            return frameNo + 1;
        }

        NormalFrame newFrame = playFirstDelivery(pins);
        normalFrameList.add(newFrame);
        return newFrame.isStrike() ? frameNo + 1: frameNo;

    }

    private boolean isSecondDeliveryOf(int frameNo) {
        return normalFrameList.size() == frameNo;
    }

    private NormalFrame playFirstDelivery(int pins) {
        return NormalFrame.of(pins);
    }

    public List<NormalFrame> getNormalFrameList() {
        return Collections.unmodifiableList(normalFrameList);
    }

}
