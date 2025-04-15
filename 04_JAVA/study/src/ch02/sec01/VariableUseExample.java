package ch02.sec01;

public class VariableUseExample {
    public static void main(String[] args) {
//        int hour=3;
////        int minute=5;
////        System.out.println(hour+"시간 "+minute+"분");
////        int totalMinute=hour*60+minute;
////
////        System.out.printf("총 %d분", totalMinute);

        int x=3;
        int y=5;
        System.out.printf("x:%d, y:%d", x,y);
        System.out.println();
        int tmp=x;
        x=y;
        y=tmp;
        System.out.printf("x:%d, y:%d", x,y);
    }
}
