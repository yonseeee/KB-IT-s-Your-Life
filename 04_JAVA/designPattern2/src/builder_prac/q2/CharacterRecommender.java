package builder_prac.q2;

import java.util.HashMap;
import java.util.Map;

public class CharacterRecommender {
    private Map<String,DatingCharacter> map = new HashMap<>();

    public CharacterRecommender() {
        DatingCharacter character1= new DatingCharacter.Builder()
                .name("지민").personality("다정하고 감성적임").hobby("춤").favoriteFood("떡볶이").talkStyle("부드럽고 공손함").build();
        DatingCharacter character2=new DatingCharacter.Builder()
                .name("제니").personality("도도하지만 배려심 있음").hobby("여행").favoriteFood("파스타").talkStyle("털털한 반말").build();
        DatingCharacter character3= new DatingCharacter.Builder()
                .name("태연").personality("조용하지만 리더십 있음").hobby("독서").favoriteFood("마라탕").talkStyle("단호하지만 상냥함").build();

        map.put("다정함", character1);
        map.put("도도함", character2);
        map.put("조용함", character3);
    }
    public void printResult(String str){
        DatingCharacter cr= map.get(str);
        if(cr==null){
            System.out.println("해당 스타일의 캐릭터는 준비 중입니다.");
            return;
        }
        System.out.println("\n[✨ 추천 결과 ✨]");
        System.out.println(cr);
    }
}
