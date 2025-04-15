package ch03.sec04;

public class AccuracyExample {
    public static void main(String[] args) {
        int apple=1;
        double pieceUnit=0.1;
        int number=7;
        System.out.println(pieceUnit*number);

        double result=apple-number*pieceUnit;
        System.out.println("사과 1개에서 남은 양: "+result);//0.2999999999999999993으로 나옴
    }
}
