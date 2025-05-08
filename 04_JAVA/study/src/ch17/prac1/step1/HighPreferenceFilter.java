package ch17.prac1.step1;

import ch17.prac1.data.GiftRepository;
import ch17.prac1.model.GiftItem;

import java.util.List;

public class HighPreferenceFilter {
    public static void run(){
        List<GiftItem> giftItemList= GiftRepository.getGifts();
        System.out.println("🎁 부모님이 진짜 좋아하시는 선물 리스트");
        giftItemList.stream().filter(gift->gift.getPreferenceScore()>=70).forEach(gift-> System.out.println(gift.getName()));
    }
}
