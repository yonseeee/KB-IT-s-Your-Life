package ch04.sec02;

public class IfNestedExample {
    public static void main(String[] args) {
        int score=(int)(Math.random()*20)+81;
        System.out.println("점수: "+score);

        String grade;
        if(score>=90){
            if(score>=95){//95점 이상
                grade="A+";
            }else{//90~94
                grade="A";
            }
        }else{
            if(score>=85){//85~89
                grade="B+";
            }
            else{//81~84
                grade="B";
            }
        }
        System.out.println("학점: "+grade);
    }
}
