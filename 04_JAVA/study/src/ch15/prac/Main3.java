package ch15.prac;

import ch15.prac.history.DollHistoryManager;
import ch15.prac.queue.DollQueueManager;
import ch15.prac.stack.DollStackManager;
import ch15.prac.util.RandomCustomerProvider;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("=== 유라의 인형뽑기 가게 ===");
        System.out.println("[1] 고객 등록");
        System.out.println("[2] 뽑기 진행 (인형 보관)");
        System.out.println("[3] 현재 대기열 보기");
        System.out.println("[4] 보관함 보기");
        System.out.println("[5] 고객별 인형 기록 보기");
        System.out.println("[0] 종료");

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("선택 >> ");
            int choice = sc.nextInt();
            DollQueueManager dqm=new DollQueueManager();
            DollStackManager dsm=new DollStackManager();
            DollHistoryManager  dhm=new DollHistoryManager();
            if(choice == 1){
                String name= RandomCustomerProvider.getRandomCustomerName();
                dqm.registerCustomer(name);
            }else if(choice == 2){
                String customerName= dqm.getNextCustomer();
                if(customerName==null){
                    System.out.println("⛔ 대기 중인 고객이 없습니다.");
                }
                else{
                    System.out.println("🎉 "+customerName+" 님! 인형 뽑기 하러 오세요!");
                    dsm.storeRandomDoll();
                    dhm.addHistory(customerName, dqm.getNextCustomer());
                }
            }else if(choice == 3){
                dqm.showWaitingList();
            }else if(choice == 4){
                dsm.showStack();
            }
            else{
                System.out.println("✋ 프로그램을 종료합니다.");
                break;
            }
        }
    }
}
