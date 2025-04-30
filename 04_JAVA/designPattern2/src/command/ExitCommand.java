package command;

import java.util.Scanner;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("종료할까요?(Y/n) ");   //엔터 쳤을 때 디폴트를 Y로 가정
        String answer=scanner.nextLine();

        scanner.close();
        if(answer.isEmpty()||answer.equalsIgnoreCase("Y")){
            System.exit(0);
        }
    }

}
