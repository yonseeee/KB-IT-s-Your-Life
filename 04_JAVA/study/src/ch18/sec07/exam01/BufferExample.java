package ch18.sec07.exam01;

import java.io.*;

public class BufferExample {
    public static void main(String[] args) throws Exception {
//        1. 버퍼 미사용: 일반 스트림
        String originalFilePath1=BufferExample.class.getResource("/ch18/sec07/exam01/test.txt").getPath();
        String targetFilePath1="src/ch18/sec07/exam01/test2.txt";
        FileInputStream fis=new FileInputStream(originalFilePath1);
        FileOutputStream fos=new FileOutputStream(targetFilePath1);

//        2. 버퍼 사용: Buffered 스트림 추가
        String originalFilePath2=BufferExample.class.getResource("/ch18/sec07/exam01/test.txt").getPath();
        String targetFilePath2="src/ch18/sec07/exam01/test2.txt";
        FileInputStream fis2=new FileInputStream(originalFilePath2);
        FileOutputStream fos2=new FileOutputStream(targetFilePath2);
        BufferedInputStream bis=new BufferedInputStream(fis2);
        BufferedOutputStream bos=new BufferedOutputStream(fos2);

//        3. 복사 시간 측정
        long nonBufferTime=copy(fis,fos);
        System.out.println("버퍼 미사용:\t"+nonBufferTime+" ns");
        long bufferTime=copy(bis,bos);
        System.out.println("버퍼 사용:\t"+bufferTime+" ns");

//        4. 자원 해제
        fis.close();
        fos.close();

        bis.close();
        bos.close();
    }


//    복사 메소드: 스트림을 받아 바이트 단위로 복사하고 시간 측정
    public static long copy(InputStream is, OutputStream os) throws Exception{
        long start=System.nanoTime();

        while(true){
            int data=is.read();
            if(data==-1){break;}
            os.write(data);
        }
        os.flush();

        long end=System.nanoTime();

        return end-start;
    }
}
