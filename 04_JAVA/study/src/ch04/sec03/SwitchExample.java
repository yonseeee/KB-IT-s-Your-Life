package ch04.sec03;

public class SwitchExample {
    public static void main(String[] args) {

        int num = (int)(Math.random()*6+1);

        switch (num){
            case 1:
                System.out.println("1번이 나왔습니다.");
                break;// 케이스를 끝내려면 break 필수
            case 2:
                System.out.println("2번이 나왔습니다.");
                break;// 케이스를 끝내려면 break 필수
            case 3:
                System.out.println("3번이 나왔습니다.");
                break;// 케이스를 끝내려면 break 필수
            case 4:
                System.out.println("4번이 나왔습니다.");
                break;// 케이스를 끝내려면 break 필수
            case 5:
                System.out.println("5번이 나왔습니다.");
                break;// 케이스를 끝내려면 break 필수
            default://switch문에서 나머지는 default로 처리한다
                System.out.println("6번이 나왔습니다.");

        }

    }
}
