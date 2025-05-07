package ch16.prac5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;

public class Main {
    private static List<Goods> list1=new ArrayList<>();
    private static List<Goods> list2=new ArrayList<>();
    public static void main(String[] args) {
        list1.add(new Goods("메타몽 쿠션", 20000,0.1));
        list1.add(new Goods("메타몽 키링", 8000,0.05));
        list1.add(new Goods("메타몽 인형", 15000,0.2));
        list2.add(new Goods("메타몽 노트북 파우치", 30000,0.2));
        list2.add(new Goods("메타몽 가방", 40000,0.2));


        ToIntFunction<Goods> toIntFunction=goods-> (int) goods.getDiscountedPrice();
        printResult("이슬이", list1, toIntFunction);
        System.out.println();
        printResult("지우", list2, toIntFunction);



    }

    public static void printResult(String user, List<Goods> goodsList, ToIntFunction<Goods> toIntFunction) {
        System.out.println("["+user+"의 장바구니]");
        Map<String, Integer> prices=new HashMap();

        for(Goods goods:goodsList) {
            prices.put(goods.getName(), (int)goods.getDiscountedPrice());
            System.out.println("- " + goods.getName() + ": " + toIntFunction.applyAsInt(goods) + "원");
        }

        int totalSum=prices.values().stream().reduce(0, Integer::sum);
        System.out.println("총합: "+totalSum+"원");

    }

}
