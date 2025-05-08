package ch17.prac1.step3;

import ch17.prac1.data.GiftRepository;
import ch17.prac1.model.GiftItem;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class MostValuableGift {
    private static boolean momMode;
    public static void run(){
        momMode=true;
//        momMode=false;
        List<GiftItem> giftItemList= GiftRepository.getGifts();

        List<GiftItem> forMomList=null;
        if(momMode){
            forMomList=giftItemList.stream().filter(gift->gift.isForMom()).toList();

        }else{
            forMomList=giftItemList.stream().filter(gift->gift.isForDad()&&gift.getPreferenceScore()>=90).toList();
        }

        OptionalInt maxPrice=forMomList.stream().mapToInt(gift->gift.getPrice()).max();
        Optional<GiftItem> item=forMomList.stream().filter(gift->gift.getPrice()==maxPrice.getAsInt()).findFirst();

//        item=null;
        System.out.println("💎 부모님께 드릴 수 있는 최고의 프리미엄 선물");
//        item.ifPresent(gift-> System.out.println("💝 ["+gift.getName()+"] - "+gift.getCategory()+" (₩"+gift.getPrice()+") / 선호도: "+gift.getPreferenceScore()+"점"));
        if(item==null){
            System.out.println("😂 조건에 맞는 고가의 선물을 찾지 못했어요.");
        }else{
            System.out.println("💝 ["+item.get().getName()+"] - "+item.get().getCategory()+" (₩"+item.get().getPrice()+") / 선호도: "+item.get().getPreferenceScore()+"점");
        }

    }
}
