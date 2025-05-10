package ch18.prac;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class UserFortuneApp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String name, birthday;
        System.out.println("[사주 운세 뽑기 머신]");
        System.out.print("이름을 입력하세요: ");
        name=sc.nextLine();
        System.out.print("생년월일을 입력하세요 (예: 2025-05-10): ");
        birthday=sc.nextLine();

        try(Writer writer=new FileWriter("C:\\fullstack\\04_JAVA\\study\\src\\ch18\\prac\\user_input.txt");){

            writer.write("이름: "+name+"\n");
            writer.write("생년월일: "+birthday);

            writer.flush();
            System.out.println("입력 정보가 user_input.txt 파일에 저장되었습니다.");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
