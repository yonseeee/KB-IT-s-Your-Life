package ch17.sec06.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MapExample {
    public static void main(String[] args) {
        int[]intArray={1,2,3,4,5};

        Arrays.stream(intArray).asDoubleStream().forEach(s-> System.out.println(s));
        System.out.println();

        IntStream intStream=Arrays.stream(intArray);
        intStream.boxed()
//                래퍼 객체에서 .intValue()로 다시 int 추출 가능
                .forEach(obj-> System.out.println(obj.intValue()));
//        Arrays.stream(intArray).forEach(s-> System.out.println(s));
    }
}
