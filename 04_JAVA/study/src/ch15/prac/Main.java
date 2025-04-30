package ch15.prac;

import ch15.prac.queue.DollQueueManager;
import ch15.prac.util.RandomCustomerProvider;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 유라의 인형뽑기 가게 ===");
        System.out.println("[1] 고객 등록");
        System.out.println("[2] 뽑기 진행");
        System.out.println("[3] 현재 대기열 보기");
        System.out.println("[0] 종료");

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("선택 >> ");
            int choice = sc.nextInt();
            DollQueueManager dqm=new DollQueueManager();
            if(choice == 1){
                String name=RandomCustomerProvider.getRandomCustomerName();

                dqm.registerCustomer(name);
            }else if(choice == 2){
                dqm.processNextCustomer();
            }else if(choice == 3){
                dqm.showWaitingList();
            }else{
                System.out.println("✋ 프로그램을 종료합니다.");
                break;
            }
        }
    }

    public static class Main3 {
        public static void main(String[] args) {

        }
    }
}
