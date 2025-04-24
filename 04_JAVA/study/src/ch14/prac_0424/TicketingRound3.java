package ch14.prac_0424;

public class TicketingRound3 {
    public static void main(String[] args) {
        EntryManager entryManager=new EntryManager(5);
        TicketBuyer ticketBuyer1=new VIPBuyer();
        TicketBuyer ticketBuyer2=new RegularBuyer();
        TicketBuyer ticketBuyer3=new SlowBuyer();
        Fan[] fans = {
                new Fan("팬1", false, entryManager, ticketBuyer2),
                new Fan("팬2", true, entryManager, ticketBuyer1),
                new Fan("팬3", false, entryManager, ticketBuyer3),
                new Fan("팬4", true, entryManager, ticketBuyer1),
                new Fan("팬5", false, entryManager,  ticketBuyer2),
        };

        System.out.println("이벤트 시작! 남은 티켓: 5장");
        Thread[] threads = new  Thread[fans.length];
        for(int i=0;i<fans.length;i++){
            threads[i]=new Thread(fans[i]);
            threads[i].start();
            
        }
        for(int i=0;i<fans.length;i++){
            try{
                threads[i].join();
            }catch (InterruptedException e){}
        }

        int count=3;
        Thread notice=new Thread(){
            @Override
            public void run() {
                try{
                    System.out.println("[공지] 남은 티켓: "+count+"장");
                    sleep(3000);
                }catch (InterruptedException e){}

            }
        };
        notice.setDaemon(true);


        System.out.println("이벤트 종료! 모두 수고하셨습니다 💗");
    }
}
