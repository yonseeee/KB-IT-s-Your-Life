package strategy;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue=0;//이전에 낸 손의 인덱스(0:바위, 1:가위,2:보)
    private int currentHandValue=0;//이번에 낼 손의 인덱스
    private int[][]history={
            {1,1,1}, //내가 바위를 낸 후 상대가 바위/가위/보를 낼 확률
            {1,1,1},//내가 가위를 낸 후 상대가 바위/가위/보를 낼 확률
            {1,1,1},//내가 보를 낸 후 상대가 바위/가위/보를 낼 확률
    };

    public ProbStrategy(int seed) {
        random=new Random(seed);
    }

    @Override
    public Hand nextHand() {
        int bet=random.nextInt(getSum(currentHandValue));
        int handValue=0;
        if(bet<history[currentHandValue][0]){
            handValue=0;
        }else if(bet<history[currentHandValue][0]+history[currentHandValue][1]){
            handValue=1;
        }else{
            handValue=2;
        }

        prevHandValue=currentHandValue;
        currentHandValue=handValue;
        return Hand.getHand(handValue);
    }

    //현재 손에서 가능한 다음 손들의 가중치 총합 계산
    private int getSum(int handValue){
        int sum=0;
        for(int i=0;i<3;i++){
            sum+=history[handValue][i];
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
         if(win){//이겼다면 해당 손 조합의 가중치 증가
             history[prevHandValue][currentHandValue]++;
         }else{//졌다면 해당 손 이외의 나머지 두 조합 가중치 증가
             history[prevHandValue][(currentHandValue+1)%3]++;
             history[prevHandValue][(currentHandValue+2)%3]++;
         }
    }
}
