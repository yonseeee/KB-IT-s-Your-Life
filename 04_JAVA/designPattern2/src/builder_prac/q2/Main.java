package builder_prac.q2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("👉 어떤 성격의 캐릭터를 선호하시나요?");
        System.out.println("→ 다정함 / 도도함 / 조용함 중 하나를 입력해주세요.");
        System.out.print("입력: ");

        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();

        CharacterRecommender recommender=new CharacterRecommender();
        recommender.printResult(str);
    }
}
