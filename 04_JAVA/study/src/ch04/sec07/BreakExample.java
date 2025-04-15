package ch04.sec07;

public class BreakExample {
    public static void main(String[] args) {
        while(true){
            int num=(int)(Math.random()*6)+1;
            System.out.println(num);
            if(num==6){
                break;//랜덤값이 6인 경우 반복문 종료
            }
        }
        System.out.println("프로그램 종료");
    }
}
