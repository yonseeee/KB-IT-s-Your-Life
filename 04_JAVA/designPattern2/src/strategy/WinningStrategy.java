package strategy;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random;
    private boolean won=false;
    private Hand prevHand;

    public WinningStrategy(int seed){
        random=new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if(!won){//직전 게임에서 졌다면
            prevHand=Hand.getHand(random.nextInt(3));//0,1,2 중 하나 나오도록
        }
        return prevHand;//직전 게임에서 이겼다면 기존 손 그대로 사용
    }

    @Override
    public void study(boolean win) {
        won=win;//승패 결과 저장
    }
}
