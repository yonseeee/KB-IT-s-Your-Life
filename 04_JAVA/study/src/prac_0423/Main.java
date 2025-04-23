package prac_0423;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws InvalidNameException {
        Scanner sc = new Scanner(System.in);
        System.out.print("참가자 이름을 입력하세요: ");
        String name = sc.nextLine();

        try{
            if (!Pattern.matches("^[가-힣]{2,10}$", name)) {
                throw new InvalidNameException("이름은 한글 2~10자여야 합니다!");
            }
            System.out.println("(다음 단계로 진행합니다!)");
        }catch(InvalidNameException e){

            System.out.println("😈 탈락! 잘못된 이름입니다: "+e.getMessage());
        }



    }
}
