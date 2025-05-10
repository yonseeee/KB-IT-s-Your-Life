package ch18.prac1;

import java.io.BufferedReader;
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


}
