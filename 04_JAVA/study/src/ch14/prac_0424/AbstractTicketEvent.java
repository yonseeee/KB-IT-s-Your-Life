package ch14.prac_0424;

public abstract class AbstractTicketEvent {
    protected int ticketCount;

    public AbstractTicketEvent(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    private void openAnnouncement(){
        System.out.println("이벤트 시작! 남은 티켓: "+ticketCount+"장");
    }
    protected abstract void fanEntry();

    private void closingAnnouncement(){
        System.out.println("이벤트 종료! 모두 수고하셨습니다 💗");
    }

    public final void startEvent(){
        openAnnouncement();
        fanEntry();
        closingAnnouncement();
    }

}
