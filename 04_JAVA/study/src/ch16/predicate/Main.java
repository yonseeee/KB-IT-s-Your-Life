package ch16.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    private static List<Goods> list = new ArrayList<>();
    public static void main(String[] args) {

        list.add(new Goods("메타몽 쿠션", "분홍", false));
        list.add(new Goods("메타몽 노트북 파우치", "보라", true));
        list.add(new Goods("메타몽 인형", "분홍", false));
        list.add(new Goods("메타몽 가방", "회색", true));
        list.add(new Goods("메타몽 키링", "파랑", false));

        Predicate<Goods> filter=t->t.getColor().equals("분홍");
        System.out.println("[이슬이의 선택]");
        printSelectedGoods("이슬이", filter);

        System.out.println();
        filter=t->t.isUseful();
        System.out.println("[지우의 선택]");
        printSelectedGoods("지우", filter);


    }
    public static void printSelectedGoods(String user, Predicate<Goods> filter){

        for(Goods goods:list){
            if(filter.test(goods)){
                System.out.println("- "+goods.getName());
            }
        }
    }
}
