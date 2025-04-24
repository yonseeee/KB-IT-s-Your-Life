package ch14.sec03.exam02;

import java.awt.*;

public class BeepPrintExample {
    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {//Runnable 객체 생성 시 오버라이딩 해야 하는 메소드
                Toolkit toolkit=Toolkit.getDefaultToolkit();
//              //작업 스레드
                for(int i=0;i<5;i++){
                    toolkit.beep();
                    try{Thread.sleep(500);}//0.5초간 일시정지
                    catch(Exception e){}
                }
            }
        });
        thread.start();//스레드 시작(실행 대기 상태로 변경)

        // 메인 스레드
        for(int i=0;i<5;i++){
            System.out.println("띵");
            try{Thread.sleep(500);}catch(Exception e){}
        }
    }
}
