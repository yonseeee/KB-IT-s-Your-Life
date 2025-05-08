package ch17.sec06.exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMappingExample {
    public static void main(String[] args) {
//        문장 스트림을 단어 스트림으로 변환
        List<String> list1=new ArrayList<>();
        list1.add("this is java");
        list1.add("i am a best developer");
        list1.stream()
//                flatMap: 1차원 단일 스트림으로 변환
                .flatMap(data-> Arrays.stream(data.split(" ")))
                .forEach(words-> System.out.println(words));

        List<String> list2=Arrays.asList(
                "10, 20, 30","40, 50"
        );
        list2.stream().flatMapToInt(data->{
            String[]strArr=data.split(",");
            int[]intArr=new int[strArr.length];
            for(int i=0;i<strArr.length;i++){
                intArr[i]=Integer.parseInt(strArr[i].trim());
            }
            return Arrays.stream(intArr);
        }).forEach(n-> System.out.println(n));
    }
}
