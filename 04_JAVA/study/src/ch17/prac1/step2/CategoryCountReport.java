package ch17.prac1.step2;

import ch17.prac1.data.GiftRepository;
import ch17.prac1.model.GiftItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryCountReport {
    public static void run(){
        List<GiftItem> giftItemList= GiftRepository.getGifts();
        Map<String,Long> categoryCount=new HashMap<>();

        giftItemList.stream().forEach(gift->{
            if(!categoryCount.containsKey(gift.getCategory())){
                categoryCount.put(gift.getCategory(),1L);
            }else{
                categoryCount.put(gift.getCategory(),categoryCount.get(gift.getCategory())+1);
            }
        });
        System.out.println("📦 카테고리별 선물 개수 요약");
        categoryCount.forEach((k,v)-> System.out.println(k+": "+v+"개"));
    }
}
