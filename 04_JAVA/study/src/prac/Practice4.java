package prac;

import java.util.Scanner;

public class Practice4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int [] student=null;
        int total=0;
        while (true){
            System.out.println("------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("------------------------------------------------");
            System.out.print("선택> ");
            int n=sc.nextInt();
            switch (n){
                case 1:
                    System.out.print("학생수>");
                    int num=sc.nextInt();
                    student=new int[3];
                    break;
                case 2:
                    for(int i=0;i<3;i++){
                        System.out.print("scores["+i+"]> ");
                        student[i]=sc.nextInt();
                    }
                    break;
                case 3:
                    for(int i=0;i<3;i++){
                        System.out.println("scores["+i+"]: "+student[i]);
                    }
                    break;
                case 4:
                    int max=0;
                    int sum=0;
                    for(int i=0;i<3;i++){
                        sum+=student[i];
                        if(student[i]>max){
                            max=student[i];
                        }
                    }
                    System.out.println("최고 점수: "+max);
                    System.out.printf("평균 점수: %.1f", sum/ (double)student.length);
                    System.out.println();
                    break;
                default:
                    System.out.println("프로그램 종료");
                    break;
            }
            if(n==5){
                break;
            }
        }
    }
}
