package ch14.prac_0424;

public class TicketingRound1 {
    Thread thread;
    public TicketingRound1(){
        thread = new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName()+" 티켓 구매 시동 중!");
            }
        });
    }

    public Thread getThread() {
        return thread;
    }
}
