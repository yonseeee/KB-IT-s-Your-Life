package ch14.prac_0424;

public class Main {
    public static void main(String[] args) {


        TicketingRound1 fan1 = new TicketingRound1();
        TicketingRound1 fan2 = new TicketingRound1();

        fan1.getThread().setName("팬1");
        fan2.getThread().setName("팬2");

        Thread thread=new Thread(){
        @Override
            public void run() {
            System.out.println(Thread.currentThread().getName()+" 티켓 구매 시도 중!");}
        };
        thread.setName("main");


    System.out.println("=== run() 직접 호출 테스트 ===");
    fan1.getThread().start();
    fan2.getThread().start();
    thread.start();


    }

}
