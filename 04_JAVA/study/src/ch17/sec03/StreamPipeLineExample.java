package ch17.sec03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineExample {
    public static void main(String[] args) {
        List<Student> list= Arrays.asList(
                new Student("홍길동",10),
                new Student("신용권", 20),
                new Student("유미선",30)
        );

//         방법1:Stream 변수 분리
        Stream<Student> studentStream=list.stream();
//        중간 처리: 점수만 추출
        IntStream scoreStream=studentStream.mapToInt(student->student.getScore());
        double avg=scoreStream.average().getAsDouble();
        System.out.println("평균 점수: "+avg);
//        방법2: 파이프라인 메소드 체이닝
        double avg2=list.stream().mapToInt(student->student.getScore())
                .average()//최종처리
                .getAsDouble();//결과반환
        System.out.println("평균 점수: "+avg2);
    }
}
