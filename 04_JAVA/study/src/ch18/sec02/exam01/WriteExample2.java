package ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample2 {
    public static void main(String[] args) {
//        try-with-resources 구문: os는 try 블록이 끝나면 자동으로 close됨
        try( OutputStream os=new FileOutputStream("C:/temp/test1.db");){

//            저장할 바이트 데이터
            byte a=10;
            byte b=20;
            byte c=30;

//            바이트 단위로 파일에 쓰기
            os.write(a);
            os.write(b);
            os.write(c);

//            출력 버퍼 비우기
//            버퍼가 지워지면서 실제로 파일에 써진다
            os.flush();


        }catch (IOException e){
//            예외처리(파일 사용시 IOException 필수 처리)
            e.printStackTrace();
        }
    }
}
