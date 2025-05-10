package ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {
    public static void main(String[] args) {

        try(Writer writer=new FileWriter("C:/temp/test.txt")){
//            한 문자씩 출력
            char a='A';
            char b='B';

//            char배열 출력
            char[]arr={'C', 'D', 'E'};
            writer.write(a);
            writer.write(b);
            writer.write(arr);

//            문자열 출렭
            writer.write("FGH");

//            버퍼에 남아있는 문자열 출력하고 비우기
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
