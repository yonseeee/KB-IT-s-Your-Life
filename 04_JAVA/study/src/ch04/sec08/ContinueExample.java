package ch04.sec08;

public class ContinueExample {
    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            if(i%2!=0){//i가 홀수인 경우 다음 반복문 실행
                continue;
            }
            System.out.println(i+" ");//짝수인 경우에만 출력
        }
    }
}
