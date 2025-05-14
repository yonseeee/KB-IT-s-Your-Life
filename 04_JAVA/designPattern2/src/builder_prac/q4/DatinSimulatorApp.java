package builder_prac.q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DatinSimulatorApp {
    public static void main(String[] args) {
        List<DatingCharacter>list=null;
        DatingCharacter c1=new DatingCharacter.Builder()
                .name("지민")
                .personality("다정하고 감성적임")
                .hobby("춤")
                .favoriteFood("떡볶이")
                .talkStyle("부드럽고 공손함")
                .typeCode("S")
                .build();
        DatingCharacter c2=new DatingCharacter.Builder()
                .name("제니")
                .personality("도도하지만 배려심 있음")
                .hobby("여행")
                .favoriteFood("파스타")
                .talkStyle("털털한 반말")
                .typeCode("C")
                .build();
        DatingCharacter c3= new DatingCharacter.Builder()
                .name("태연")
                .personality("조용하지만 리더십 있음")
                .hobby("독서")
                .favoriteFood("마라탕")
                .talkStyle("단호하지만 상냥함")
                .typeCode("T")
                .build();
        list= Arrays.asList(c1,c2,c3);


        System.out.println("💘 대화하고 싶은 캐릭터를 선택하세요:");
        for(int i=0;i<list.size();i++){
            System.out.println((i+1)+". "+list.get(i));
        }
        System.out.print("번호입력: ");
        Scanner sc = new Scanner(System.in);
        String choice=sc.nextLine();
        System.out.println();
        Command command=new TalkCommand();
        if(choice.equals("1")){
            command.execute(c1);
        }else if(choice.equals("2")){
            command.execute(c2);
        }else if(choice.equals("3")){
            command.execute(c3);
        }




//        System.out.println("👉 어떤 성격의 캐릭터를 선호하시나요?");
//        System.out.println("→ 다정함 / 도도함 / 조용함 중 하나를 입력해주세요.");
//        System.out.print("입력: ");
//
//        Scanner sc = new Scanner(System.in);
//        String str=sc.nextLine();
//
//        CharacterRecommender recommender=new CharacterRecommender();
//        recommender.printResult(str);
    }
}
