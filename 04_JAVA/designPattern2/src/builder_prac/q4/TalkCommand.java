package builder_prac.q4;


import java.util.Scanner;

public class TalkCommand implements Command{
    @Override
    public void execute(DatingCharacter character) {
        if(character.getTalkStyle().contains("반말"))
            System.out.println("["+character.getName()+"] 뭐야~ 왜 이제 왔어?");
        else if(character.getTalkStyle().contains("공손"))
            System.out.println("["+character.getName()+"] 오셨군요. 기다리고 있었어요.");
        else if(character.getTalkStyle().contains("시크"))
            System.out.println("["+character.getName()+"] 왔네.");
        else{
            System.out.println("["+character.getName()+"] 안녕.");
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("\n👉 무엇을 말할까요?");
        System.out.println("1. 오늘 좀 바빴어");
        System.out.println("2. 보고 싶었어");
        System.out.println("3. 아무 말도 하지 않는다");
        System.out.print("선택: ");
        int choice = sc.nextInt();

        String[]answers={"흐응~ 바빴구나. 알겠어.","진짜? 그 말 또 해줘 🤗","... (가만히 쳐다본다)","응? 무슨 말이야?"};

        if(choice<=3){
            System.out.println("\n["+character.getName()+"] "+answers[choice-1]);
        }else{
            System.out.println("\n["+character.getName()+"] "+answers[3]);
        }
    }

}
