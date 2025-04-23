package prac_0423;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        MaleCelebrity[] maleCelebs = {
                new MaleCelebrity("서강준"),
                new MaleCelebrity("차은우"),
                new MaleCelebrity("송강")
        };

        FemaleCelebrity[] femaleCelebs = {
                new FemaleCelebrity("카리나"),
                new FemaleCelebrity("안유진")
        };

        System.out.println("===이상형 월드컵");
        System.out.println("1. 남자 연예인 월드컵");
        System.out.println("2. 여자 연예인 월드컵");
        System.out.print("경기를 선택하세요: ");

        Scanner sc = new Scanner(System.in);
        try{
            String choice=sc.nextLine();
                     if(!(choice.charAt(0)>='0'&&choice.charAt(0)<='9')){
                throw new InvalidGenderException(">> 숫자만 입력하세요! (1 또는 2)");
            }
           else if(Integer.parseInt(choice)<1||Integer.parseInt(choice)>2){
                throw new InvalidGenderException(">> 잘못된 선택입니다! 1 또는 2만 입력하세요.");
            }


            if(choice.charAt(0)=='1'){
                MaleMatchGame maleGame = new MaleMatchGame(maleCelebs);
                maleGame.printCandidates();
            }
            else if(choice.charAt(0)=='2'){
                FemaleMatchGame femaleGame = new FemaleMatchGame(femaleCelebs);
                femaleGame.printCandidates();
            }
        }catch (InvalidGenderException e){
            System.out.println(e.getMessage());
        }




    }
}
