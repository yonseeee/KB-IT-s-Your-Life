package ch16.supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Predicate;

public class Main {
    private static List<Goods> giftPool =new ArrayList<>();
//

    public static void main(String[] args) {
        giftPool.add(new Goods("메타몽 쿠션", "분홍", false));
        giftPool.add(new Goods("메타몽 노트북 파우치", "보라", true));
        giftPool.add(new Goods("메타몽 인형", "분홍", false));
        giftPool.add(new Goods("메타몽 가방", "회색", true));
        giftPool.add(new Goods("메타몽 키링", "파랑", false));
        List<Goods> gifts=pickGifts(giftPool);
        Predicate<Goods> condition=goods -> goods.getColor().equals("분홍");
        printResult("이슬이", gifts,condition,"-> 성공! 분홍색 굿즈를 얻었어요! 🎉","-> 실패! 분홍색 굿즈가 없어요 😅");

        System.out.println();

        gifts=pickGifts(giftPool);
        condition=goods -> goods.isUseful();
        printResult("지우", gifts, condition, "-> 성공! 유용한 굿즈를 얻었어요! 🎉","-> 실패! 유용한 굿즈가 없어요 😅");

    }
    public static List<Goods> pickGifts(List<Goods> pool) {
        List<Goods> gifts = new ArrayList<>();
        for(int i=0;i<2;i++){
            IntSupplier intSupplier = () -> {
                int num=(int)(Math.random()*pool.size());
                return num;
            };
            int index=intSupplier.getAsInt();
//            System.out.println(index);
            gifts.add(pool.get(index));
            pool.remove(index);
        }
        return gifts;

    }
    public static void printResult(String user, List<Goods> picks, Predicate<Goods> condition,String successMsg,String failMsg){
        System.out.println("["+user+"의 뽑기 결과]");
        boolean isMatch=false;
        for(Goods g:picks){
            if(condition.test(g)){
                isMatch=true;
            }
            System.out.println("- "+g.getName()+" ("+g.getColor()+")");
        }
        if(isMatch){
            System.out.println(successMsg);
        }else{
            System.out.println(failMsg);
        }

    }
}
