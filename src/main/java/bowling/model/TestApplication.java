package bowling.model;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class TestApplication {

    public static void main(String[] args) {
        BowlingGame bowlingGame = new BowlingGame();
        Scanner scanner = new Scanner(System.in);

        while (!bowlingGame.isEnd()) {
            System.out.println(bowlingGame.getPlayFrameNo() + "번 프래임 투구 : ");
            int pins = Integer.valueOf(scanner.nextLine());

            bowlingGame.bowling(pins);

//            AtomicInteger i = new AtomicInteger(1);
//            bowlingGame.getFrames().forEach(frame -> {
//                System.out.println("frame : " + i.getAndIncrement());
//                frame.getDeliveries().forEach(
//                        delivery -> {
//                            System.out.printf("state : %s, score : %s \n", delivery.getState(), delivery.getFallenPins());
//                        });
//            });

        }

        int i =  1;
        bowlingGame.getFrames().forEach(frame -> {
            System.out.println("frame : " + i);
            frame.getDeliveries().forEach(
                    delivery -> {
                        System.out.printf("state : %s, score : %s \n", delivery.getState(), delivery.getFallenPins());
                    });
            i++;
        });

    }
}
