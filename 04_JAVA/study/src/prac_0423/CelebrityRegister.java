package prac_0423;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CelebrityRegister {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("남자 연예인 몇 명 등록할까요? ");
        int male = sc.nextInt();
        MaleCelebrity[] arr = new MaleCelebrity[male];
        int index=0;
        while(true){
//            System.out.println("index:"+index);
            System.out.print("이름 입력: ");
            String name = sc.next();
            try{
                if (!Pattern.matches("^[가-힣]{2,10}$", name)) {
                    throw new InvalidNameException("이름은 한글 2~10자여야 합니다!");
                }
//                System.out.println("(다음 단계로 진행합니다!)");
            }catch(InvalidNameException e){
                System.out.println("😈 탈락! 잘못된 이름입니다: "+e.getMessage());
            }
            boolean flag=true;
            for (int i = 0; i < index; i++) {
                if(arr[i].getName().equals(name)){
                    flag=false;
                    System.out.println(">> 중복 된 이름입니다. 등록하지 않습니다.");
                }
            }
            if(flag){
                arr[index++]=new MaleCelebrity(name);
            }
            if(index==male){
                break;
            }

        }
        System.out.print("여자 연예인 몇 명 등록할까요? ");
        int female = sc.nextInt();
        FemaleCelebrity[] arr2 = new FemaleCelebrity[male];
        index=0;
        while(true){
//            System.out.println("index:"+index);
            System.out.print("이름 입력: ");
            String name = sc.next();
            try{
                if (!Pattern.matches("^[가-힣]{2,10}$", name)) {
                    throw new InvalidNameException("이름은 한글 2~10자여야 합니다!");
                }
//                System.out.println("(다음 단계로 진행합니다!)");
            }catch(InvalidNameException e){
                System.out.println("😈 탈락! 잘못된 이름입니다: "+e.getMessage());
            }
            boolean flag=true;
            for (int i = 0; i < index; i++) {
                if(arr[i].getName().equals(name)){
                    flag=false;
                    System.out.println(">> 중복 된 이름입니다. 등록하지 않습니다.");
                }
            }
            if(flag){
                arr2[index++]=new FemaleCelebrity(name);
            }
            if(index==female){
                break;
            }

        }


        System.out.println("[남자 연예인 리스트]");
        for(int i=0;i<male;i++){
            System.out.println(arr[i].toString());
        }
        System.out.println();
        System.out.println("[여자 연예인 리스트]");
        for(int i=0;i<female;i++){
            System.out.println(arr2[i].toString());
        }
    }
}
