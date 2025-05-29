package composite_prac;

public class Member extends BandComponent{
    private String name;
    private String mbti;
    private String position;
    private int energyLevel;

    public Member(String name, String mbti, String position, int energyLevel)
    {
        this.name = name;
        this.mbti = mbti;
        this.position = position;
        this.energyLevel = energyLevel;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void perform() {
        if(energyLevel<30){
            System.out.println("😵 [ISFP] "+name+": 너무 지쳐서 공연을 못 하겠어요...");
            return;
        }

        if(mbti.equals("ENFP")){
            System.out.println("🔥 [ENFP] "+name+": 여러분 안녕!! 불태워볼까요?");
        }else if(mbti.equals("ISTJ")){
            System.out.println("🧊 [ISTJ] "+name+": 공연 시작합니다.");
        }else if(mbti.equals("ISFP")){
            System.out.println("🌙 [ISFP] "+name+": 조용히 시작해볼게요.");
        }else if(mbti.equals("INTP")){
            System.out.println("🧠 [INTP] "+name+": 이 곡은 구조적으로 매우 완벽합니다.");
        }else if(mbti.equals("ESFJ")){
            System.out.println("💕 [ESFJ] "+name+": 다들 잘 지냈죠? 오늘도 힘내요!");
        }else{
            System.out.println("🎶 [기타] "+name+": 준비됐어요!");
        }
    }

    @Override
    public void printStructure(String prefix) {
        System.out.println(prefix+"🎸 "+position+" - "+name+" ("+mbti+")");
    }
}
