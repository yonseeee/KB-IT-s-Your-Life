package ch14.prac_0424;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class EntryManager {
    private Stack<Fan> vipStack=new Stack<>();
    private Queue<Fan> normalQueue=new LinkedList<>();
    private int ticketCount;

    public EntryManager(int ticketCount){
        this.ticketCount=ticketCount;
    }
    public void registerFan(Fan fan){
        if(fan.isVIP()){
            vipStack.push(fan);
        }else{
            normalQueue.offer(fan);
        }
    }
    synchronized public boolean processEntry(Fan fan){
        if(fan.isVIP()){
            if(vipStack.peek()==fan){
                vipStack.pop();
                ticketCount--;
//                System.out.println("VIP "+fan.getName()+" 입장 완료!");
                return true;
            }else{
                return false;
            }
        }else if(!vipStack.isEmpty()&&!fan.isVIP()){
            return false;
        }else{
            if(normalQueue.peek()==fan){
                normalQueue.poll();
                ticketCount--;
//                System.out.println(fan.getName()+" 입장 완료!");
                return true;
            }else{
                return false;
            }
        }

    }
}
