package prototype_prac;

import prototype_prac.CardTemplate;
import prototype_prac.Manager;
import prototype_prac.Product;
import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        CardTemplate insta=new CardTemplate("Instagram Story", '*');
        CardTemplate twit=new CardTemplate("Tweet Style", '-');
        CardTemplate shorts=new CardTemplate("YouTube Shorts", '#');

        manager.register("insta",insta);
        manager.register("twit", twit);
        manager.register("short",shorts);

        List<Product> products=new ArrayList<>();
//        Product p1= manager.create("insta");
//        Product p2=manager.create("youtube");
//        Product p3=manager.create("shorts");

//        p1.use("오늘 점심은 연남동 김밥 🍙");
//        System.out.println();
//        p2.use("🔥자바로 구현한 내 인생 첫 프로그램!");


        while(true){
            System.out.println("[등록된 스타일 목록]");
            System.out.println("- insta : Instagram Story");
            System.out.println("- twit : Tweet Style");
            System.out.println("- short : YouTube Shorts");
            System.out.println();
            System.out.print("사용할 스타일 이름 입력 (종료: exit): ");
            Scanner sc=new Scanner(System.in);
            String str=sc.nextLine();
            if(str.equals("exit")){break;}
            System.out.print("출력할 문구 입력: ");
            String str2=sc.nextLine();
            Product p=manager.create(str);
            if(p!=null){
                p.use(str2);
                products.add(p);
            }else{
                System.out.println("[Error] 등록되지 않은 스타일입니다: "+str);
            }
            System.out.println();
        }
        manager.printRegisteredStyles(products);
    }
}

