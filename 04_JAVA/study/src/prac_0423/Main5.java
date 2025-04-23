package prac_0423;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        MaleCelebrity[] maleCelebs = {
                new MaleCelebrity("박서준"),
                new MaleCelebrity("차은우"),
                new MaleCelebrity("정해인"),
                new MaleCelebrity("이도현"),
                new MaleCelebrity("송강"),
                new MaleCelebrity("김선호"),
                new MaleCelebrity("안효섭"),
                new MaleCelebrity("도경수"),
                new MaleCelebrity("임시완"),
                new MaleCelebrity("이준호")
        };

        FemaleCelebrity[] femaleCelebs = {
                new FemaleCelebrity("아이유"),
                new FemaleCelebrity("장원영"),
                new FemaleCelebrity("카리나"),
                new FemaleCelebrity("윈터"),
                new FemaleCelebrity("한소희"),
                new FemaleCelebrity("김세정"),
                new FemaleCelebrity("윤아"),
                new FemaleCelebrity("설현"),
                new FemaleCelebrity("제니"),
                new FemaleCelebrity("지수")
        };



        Scanner sc = new Scanner(System.in);

        for(int i=0;i<2;i++){
            System.out.println("===이상형 월드컵===");
            System.out.println("1. 남자 연예인 월드컵");
            System.out.println("2. 여자 연예인 월드컵");
            System.out.print("경기를 선택하세요: ");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("[셔플 전 참가자 명단]");
                MaleMatchGame maleMatchGame = new MaleMatchGame(maleCelebs);
                maleMatchGame.printCandidates();
                System.out.println();
                maleMatchGame.shuffle();
                System.out.println("[셔플 후 참가자 명단]");
                maleMatchGame.printCandidates();
            }else if(choice == 2) {
                System.out.println("[셔플 전 참가자 명단]");
                FemaleMatchGame femaleMatchGame = new FemaleMatchGame(femaleCelebs);
                femaleMatchGame.printCandidates();

                System.out.println();
                femaleMatchGame.shuffle();
                System.out.println("[셔플 후 참가자 명단]");
                femaleMatchGame.printCandidates();
            }
        }


    }
}
