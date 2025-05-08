package ch17.prac1.step4;

import ch17.prac1.data.GiftRepository;
import ch17.prac1.model.GiftItem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class MomGiftAveragePrice {
    public static void run() {
        List<GiftItem> giftItemList = GiftRepository.getGifts();
        List<GiftItem> forMomList=giftItemList.stream().filter(gift -> gift.isForMom()).toList();
      forMomList=new ArrayList<>();

        if(forMomList.size()==0){
            System.out.println("😂 조건에 맞는 엄마 전용 선물이 아직 없습니다.");
            return;
        }

        System.out.println("👩 엄마 전용 선물들의 평균 가격 리포트");
        System.out.println("📦 포함된 선물:");
        forMomList.forEach(s -> System.out.println("- " + s.getName()));

        OptionalDouble avg = giftItemList.stream().filter(gift -> gift.isForMom()).mapToInt(gift -> gift.getPrice()).average();
        DecimalFormat df = new DecimalFormat("#,###");

        if (avg.isPresent()) {
            System.out.println("📊 평균 가격:  ₩" + df.format(avg.getAsDouble()) + "원");
        }
    }


}
