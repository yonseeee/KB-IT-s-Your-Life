package ch14.sec04;

public class ThreadNameExample {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName()+" 실행");

//        작업 스레드 3개 생성 및 실행
        for(int i=0;i<3;i++){
            Thread threadA=new Thread(){
                @Override
                public void run(){
                    System.out.println(getName()+" 실행");//자동 할당된 스레드명

                }
            };
            threadA.start();
        }
        Thread chatThread=new Thread(){
            @Override
            public void run(){
                System.out.println(getName()+" 실행");

            }
        };
        chatThread.setName("chat-thread");
        chatThread.start();
    }
}
