package ch17.sec12.exam01;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student implements Comparable<Student>{
    private String name;
    private String sex;
    private int score;

    @Override
    public int compareTo(Student o) {
        if(this.score < o.score){
            return -1;
        }else if(this.score > o.score){
            return 1;
        }
        else {
            return 0;
        }

    }
}
