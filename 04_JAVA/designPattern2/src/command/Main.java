package command;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileService fs=new FileService();

        Command[]commands = {
//                new AddCommand(),
//                new Command() {
//                    @Override
//                    public void execute() {
//                        System.out.println("Add command");
//                    }
//                },
                ()-> System.out.println("Add Command"),
//                new OpenCommand(),
                fs::open,//()->fs.open()
                fs::print,//()->fs.print()
                new PrintCommand(),
//                new ExitCommand()
                Main::exit//()->exit()
        };

        while(true){
            Scanner scanner=new Scanner(System.in);
            System.out.println("1: Add, 2:Open, 3: Print, 4: Exit");
            System.out.println("선택: ");
            int sel=scanner.nextInt();

            commands[sel-1].execute(); //Command 패턴의 핵심! 다중 if문 필요X
        }
    }

    public static void exit(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("종료할까요?(Y/n) ");   //엔터 쳤을 때 디폴트를 Y로 가정
        String answer=scanner.nextLine();

        scanner.close();
        if(answer.isEmpty()||answer.equalsIgnoreCase("Y")){
            System.exit(0);
        }
    }
}
