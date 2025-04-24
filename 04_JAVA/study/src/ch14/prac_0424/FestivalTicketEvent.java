package ch14.prac_0424;

public class FestivalTicketEvent extends AbstractTicketEvent{

    public FestivalTicketEvent(int ticketCount) {
        super(ticketCount);
    }

    @Override
    protected void fanEntry() {
        int num=ticketCount;
        Thread[]fans=new Thread[num];
        for(int i=0;i<num;i++){
            fans[i]=new Thread(){
                public void run(){
                    System.out.println(Thread.currentThread().getName()+" 티켓 구매 시도 중!");
                }
            };
            fans[i].setName("팬"+(i+1));
            fans[i].start();
        }

        for(int i=0;i<num;i++){
            try{
                fans[i].join();
            }catch (InterruptedException e){}
        }
    }
}
