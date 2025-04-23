package prac_0423;

import java.util.Random;
import java.util.Scanner;

public abstract class MatchGame implements VsSelectable {
    protected Celebrity[] candidates;
    public abstract void initializeCandidates(Celebrity[] celebrities);
    public abstract Celebrity playGame();
    public void printCandidates(){
        for(int i=0;i<candidates.length;i++){
            System.out.println(candidates[i].toString());
        }
    }
    public void shuffle(){
        for(int i=candidates.length-1;i>=0;i--){
            Celebrity temp = candidates[i];
            Random rand = new Random();
            int j = rand.nextInt(i+1);
            candidates[i] = candidates[j];
            candidates[j] = temp;
        }
    }

    @Override
    public Celebrity selectWinner(Celebrity c1, Celebrity c2) {
        while(true){
            System.out.println("누가 더 이상형인가요?");
            System.out.println("1. "+c1.toString());
            System.out.println("2. "+c2.toString());
            Scanner sc = new Scanner(System.in);
            System.out.print("선택: ");
            int choice = sc.nextInt();
            if(choice==1){
                System.out.println(c1.toString()+" 승리!");
                return c1;
            } else if (choice==2) {
                System.out.println(c2.toString()+" 승리!");
                return c2;
            }else{
                System.out.println("잘못된 입력입니다! 1 또는 2만 입력하세요.");
            }
        }

    }
}
