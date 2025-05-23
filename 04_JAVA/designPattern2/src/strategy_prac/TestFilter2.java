package strategy_prac;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestFilter2 {
    public static void main(String[] args) {
        Map<String, FilterStrategy> map=new HashMap<>();
        map.put("smooth", new SmoothSkinFilter());
        map.put("cute", new CuteEyesFilter());
        map.put("kawaii", new KawaiiFilter());

        System.out.println("AI 필터 엔진에 오신 걸 환영합니다!");
        System.out.println("사용할 필터를 선택해주세요 (smooth, cute, kawaii, exit)");
        System.out.println();
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.print(">> 적용할 필터 입력: ");
            String choice=sc.nextLine();
            choice=choice.toLowerCase();
            String photo="";

            if(choice.equals("exit")){
                System.out.println("필터 부스를 종료합니다. 안녕히 가세요!");
                break;
            }
            if(!map.containsKey(choice)){
                System.out.println("존재하지 않는 필터입니다. 다시 입력해주세요.");
                System.out.println();
                continue;
            }

            System.out.print(">> 사진 입력: ");
            photo=sc.nextLine();
            System.out.print("[사용 필터: "+choice+"] => ");
            FilterStrategy strategy=map.get(choice);
            System.out.println(strategy.apply(photo));
            System.out.println();

        }
    }



}
