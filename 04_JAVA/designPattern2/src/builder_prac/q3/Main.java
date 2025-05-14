package builder_prac.q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println("💘 어떤 유형의 캐릭터를 보고 싶나요?");
        System.out.println("→ S (순수형), T (츤데레형), C (차도남/차도녀형)");
        System.out.print("입력: ");

        Scanner sc = new Scanner(System.in);
        String choice=sc.nextLine();

        List<DatingCharacter>list=new ArrayList<>();
        DatingCharacter c1=new DatingCharacter.Builder().name("지민").personality("다정하고 감성적임").typeCode("S").build();
        DatingCharacter c2=new DatingCharacter.Builder().name("수지").personality("순수한 첫사랑 느낌").typeCode("S").build();
        DatingCharacter c3=new DatingCharacter.Builder().name("민호").personality("무뚝뚝한 츤데레").typeCode("T").build();
        DatingCharacter c4=new DatingCharacter.Builder().name("태연").personality("조용하지만 리더십 있음").typeCode("T").build();
        DatingCharacter c5=new DatingCharacter.Builder().name("제니").personality("도도하지만 배려심 있음").typeCode("C").build();
        list= Arrays.asList(c1,c2,c3,c4,c5);


        System.out.println("\n[해당 유형 캐릭터 목록]");
        List<DatingCharacter> newList= list.stream().filter(ch->ch.getTypeCode().equals(choice)).toList();
        for(int j=0;j<newList.size();j++){
            System.out.println((j+1)+". "+newList.get(j));
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
