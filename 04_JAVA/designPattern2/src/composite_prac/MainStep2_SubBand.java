package composite_prac;

public class MainStep2_SubBand {
    public static void main(String[] args) {
        Band mainBand=new Band("DreamStage");
        Band subBand=new Band("스윗즈");

        Member zero = new Member("제로비트", "ENFP", "Vocal", 85);
        Member mint = new Member("민트초코", "ISTJ", "Guitar", 90);
        Member ai = new Member("아이시스", "ISFP", "Keyboard", 25);
        Member honey = new Member("허니콩", "ESFJ", "Bass", 95);

        mainBand.add(zero);

        subBand.add(mint);
        subBand.add(ai);
        subBand.add(honey);

        mainBand.add(subBand);

        System.out.println("[전체 밴드 구성 출력]");
        mainBand.printStructure("|- ");
    }
}
