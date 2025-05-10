package ch18.prac3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserFileService {
    public static UserInfo loadUserInfo(){
        Map<String, String> map=new HashMap<>();
        try(BufferedReader br=new BufferedReader(new FileReader("src/ch18/prac1/user_input.txt"));){
            while(true){
                String str=br.readLine();
                if(str==null){break;}
                String[]arr=str.split(":");
                map.put(arr[0].trim(),arr[1].trim());
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return new UserInfo(map.get("이름"),map.get("생년월일"));
    }
    public static void saveSajuToFile(String birth){
        String result= SajuCalculator.formatSaju(birth);

        try{
            File sajuFile=new File("src/ch18/prac3/fortune_saju.txt");
            if(sajuFile.exists()){
                System.out.println(sajuFile.getAbsolutePath());
                System.out.println(
                        sajuFile.length()
                );
                System.out.println(sajuFile.lastModified());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
