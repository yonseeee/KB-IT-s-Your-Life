package org.scoula.lib;

public class InputExample {
    public static void main(String[] args) {
        Input input = new Input();
        while(true) {
            String result=input.read("이름");
            System.out.println("입력값: "+result);

            result=input.read("이름","홍길동");
            System.out.println("입력값: "+result);

            int result2=input.readInt("나이");
            System.out.println("입력값: "+result2);

            boolean result3=input.confirm("종료할까요?");
            System.out.println("입력값: "+result3);
            if(result3==true) {
                break;
            }

            result3=input.confirm("종료할까요?");
            System.out.println("입력값: "+result3);
            if(result3==true) {
                break;
            }
        }

    }
}
