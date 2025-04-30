package ch15.prac.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DollQueueManager {
    private static Queue<String> queue=new LinkedList<>();

    public void registerCustomer(String name){
        queue.offer(name);
        System.out.println("👉 "+name+" 님이 대기열에 등록되었습니다.");
    }
    public void processNextCustomer(){
        String name= queue.poll();
        System.out.println("🎉 "+name+" 님! 인형 뽑기 하러 오세요!");
    }
    public void showWaitingList(){
        Iterator<String> itr=queue.iterator();
        System.out.print("📃 현재 대기열: [");
        while(itr.hasNext()){
            System.out.print(itr.next());
            if(itr.hasNext()){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public String getNextCustomer(){
        if(queue.isEmpty()){
            return null;
        }
        return queue.poll();
    }
}
