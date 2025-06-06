package ch17.sec10;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();


        OptionalDouble optional=list.stream()
                .mapToInt(Integer::intValue)
                .average();
        if(optional.isPresent()){
            System.out.println(optional.getAsDouble());
        }else{
            System.out.println("방법1_평균: 0.0");
        }

//        방법2:orElse()로 기본값 지정
        double avg=list.stream().mapToInt(Integer::intValue).average()
                .orElse(0.0);//값이 없을 때는 기본값 0.0
        System.out.println("평균: "+avg);

        list.stream().mapToInt(Integer::intValue).average().ifPresent(a-> System.out.println("방법3_평균: "+a));
    }
}
