package strategy;

public enum Hand {
    ROCK("바위",0),
    SCISSORS("가위",1),
    PAPER("보",2);

    private String name;
    private int handValue;

    private Hand(String name, int handValue) {
        this.name = name;
        this.handValue = handValue;
    }

    //static메서드
    private static Hand[]hands={
            ROCK, SCISSORS, PAPER
    };
    public static Hand getHand(int handValue){
        return hands[handValue];
    }


    //인스턴스 메서드
    private int fight(Hand h){
        if(this==h){return 0;}//무승부
        else if((this.handValue+1)%3==h.handValue){return 1;}//this가 이기는 경우
        else return -1;//상대가 이기는 경우
    }

    //this가 상대방보다 강한지 여부
    public boolean isStrongerThan(Hand h){
        return fight(h)==1;
    }
//     this가 상대방보다 약한지 여부
    public boolean isWeakerThan(Hand h){
        return fight(h)==-1;
    }
    @Override//기존에 ROCK으로 출력되던 것을 바위로 출력될 수 있게 함
    public String toString() {
        return name;
    }
}
