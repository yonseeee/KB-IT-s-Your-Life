package ch17.prac1.step6;

import ch17.prac1.data.GiftRepository;
import ch17.prac1.model.GiftItem;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CategorySummaryReport {
    public static void run(){
        List<GiftItem> giftItemList= GiftRepository.getGifts();

        Map<String, List<GiftItem>> map=giftItemList.stream()
                .collect(
                        Collectors.groupingBy(g->g.getCategory())
                );

        DecimalFormat df = new DecimalFormat("₩#,###.##");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📦 카테고리별 선물 요약 리포트");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println();
        map.forEach((k,v)->{
            System.out.println("["+k+"]");
            System.out.println("- 총 개수    : "+v.size()+"개");
            System.out.println("- 평균 가격   : "+df.format(v.stream().mapToInt(gift->gift.getPrice()).average().getAsDouble())+"원");
            System.out.println("- 최고가     :  "+df.format(v.stream().mapToInt(gift->gift.getPrice()).max().getAsInt())+"원");
            System.out.println("- 최고가     :  "+df.format(v.stream().mapToInt(gift->gift.getPrice()).min().getAsInt())+"원");
            System.out.println();
        });

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("리포트 생성 완료 ✅");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println();
    }
}
