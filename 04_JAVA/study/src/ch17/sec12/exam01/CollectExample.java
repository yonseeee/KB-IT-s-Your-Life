package ch17.sec12.exam01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {
        List<Student> totalList=new ArrayList<>();
        totalList.add(new Student("홍길동","남",92));
        totalList.add(new Student("김수영","여",87));
        totalList.add(new Student("감자바", "남",95));
        totalList.add(new Student("오해영", "여",93));

//        Stream 안 쓰고 하기
        List<Student> maleList=new ArrayList<>();
        for(Student student:totalList){
            if(student.getSex().equals("남")){
                maleList.add(student);
            }
        }
        for(Student student:maleList){
            System.out.println(student.getName());
        }

//        Stream 사용
        List<Student> manList=totalList.stream()
                .filter(s->s.getSex().equals("남"))
                .toList();
        manList.forEach(s-> System.out.println(s.getName()));

        manList.stream().map(Student::getName).forEach(System.out::println);


        System.out.println("=========");
//        성적 내림차순, 상위 2명 추출
        totalList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(s-> System.out.println(s.getName()));

        List<Student> topList= totalList.stream()
                .sorted((a,b)->Integer.compare(b.getScore(),a.getScore()))
                .limit(2)
                .toList();
        Map<String,Integer>map=topList.stream()
                .collect(
                        Collectors.toMap(
                                s->s.getName(),
                                s->s.getScore()
                        )
                );
    }
}
