package ch18.prac3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SajuCalculator {
    static String[] heavenlyStems = {"갑", "을", "병", "정", "무", "기", "경", "신", "임", "계"};
    static String[] earthlyBranches = {"자", "축", "인", "묘", "진", "사", "오", "미", "신", "유", "술", "해"};
    public static String[] calculateSaju(String birth){
        int year = 0,month=0,day=0;
        try(BufferedReader br=new BufferedReader(new FileReader("src/ch18/prac3/user_input.txt"));){

            while(true){
                String str=br.readLine();
                if(str==null)break;
                String[]arr=str.split(":");
                if(arr[0].trim().equals("생년월일")){
                    String[] parts=arr[1].split("-");
                    year=Integer.parseInt(parts[0]);
                    month=Integer.parseInt(parts[1]);
                    day=Integer.parseInt(parts[2]);
                }
            }
            String stem1 = heavenlyStems[year % 10];
            String branch1 = earthlyBranches[year % 12];
            String stem2 = heavenlyStems[month % 10];    // 7 % 10 → 7 → "신"
            String branch2 = earthlyBranches[month % 12]; // 7 % 12 → 7 → "미"
            int total = year + month + day;     // 1994 + 7 + 21 = 2022
            String stem3 = heavenlyStems[total % 10];     // 2022 % 10 → 2 → "병"
            String branch3 = earthlyBranches[total % 12]; // 2022 % 12 → 6 → "오"

            String[] saju = {
                    stem1 + branch1,   // 예: "무인" ← 연도 기준
                    stem2 + branch2,   // 예: "신미" ← 월 기준
                    stem3 + branch3    // 예: "병오" ← 연+월+일 합 기준
            };
            return saju;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public static String formatSaju(String birth){
        String[]saju=calculateSaju(birth);
        return "연: "+saju[0]+"\n월: "+saju[1]+"\n일: "+saju[2];
    }
}
