package ch17.sec07.exam01;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student implements Comparable<Student>{
    private String name;
    private int score;

    @Override
    public int compareTo(Student o){
//        점수를 기준으로 오름차순 정렬
        return Integer.compare(this.score, o.score);
    }

}
