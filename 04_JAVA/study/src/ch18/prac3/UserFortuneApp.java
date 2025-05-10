package ch18.prac3;

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

        try(Writer writer=new FileWriter("C:\\fullstack\\04_JAVA\\study\\src\\ch18\\prac1\\user_input.txt");){

            writer.write("이름: "+name+"\n");
            writer.write("생년월일: "+birthday);

            writer.flush();
            System.out.println("✅ 운명 파일 (user_input.txt)에 정보가 기록되었습니다.");

            System.out.println("\n[운명 정보 불러오는 중...]");
            UserInfo loadedUser = UserFileService.loadUserInfo();
            System.out.println("\n[입력 정보 확인]");
            System.out.println(loadedUser);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
