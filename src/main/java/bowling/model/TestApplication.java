package bowling.model;

public class TestApplication {

    public static void main(String[] args) {
        BowlingGame bowlingGame = new BowlingGame();

        bowlingGame.bowling(10);
        bowlingGame.bowling(9);
        bowlingGame.bowling(1);
        bowlingGame.bowling(0);

        int i = 1;
        for (NormalFrame frame : bowlingGame.getFrameList()) {
            System.out.println("frame : " + i++);
            frame.getDeliveries().forEach(
                    delivery -> {
                        System.out.printf("state : %s, score : %s \n", delivery.getState(), delivery.getFallenPins());
                    }
            );
        }
    }
}
