package ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
    public static void main(String[] args) {
        try(InputStream is=new FileInputStream("C:/temp/test2.db");){
//            최대 100바이트 담을 수 있는 배열 생성
            byte[] data =new byte[100];

            while(true){
//                data 배열의 바이트 데이터 읽고 읽은 바이트 수 반환
                int num=is.read(data);//최대 100바이트 읽기
//                파일 끝에 도달했으면 종료
                if(num==-1)break;
//                  읽은 바이트 값 출력
                for(int i=0;i<num;i++){
                    System.out.println(data[i]);
                }
            }
        }catch (FileNotFoundException e){
//            파일이 존재하지 않을 경우 예외 처리
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
