package ch14.prac_0424;

public class Fan implements Runnable{
    private String name;
    private boolean isVIP;
    private EntryManager entryManager;
    private TicketBuyer buyer;

    public Fan(String name, boolean isVIP,EntryManager entryManager, TicketBuyer buyer){
        this.name = name;
        this.isVIP = isVIP;
        this.entryManager = entryManager;

        this.buyer = buyer;
    }
    public String getName(){
        return name;
    }
    public boolean isVIP(){
        return isVIP;
    }

    @Override
    public void run() {
        entryManager.registerFan(this);
//        System.out.println("run");
        while(!entryManager.processEntry(this)){
            buyer.waitTurn();
        }
        buyer.entranceMessage(name);

    }
}
