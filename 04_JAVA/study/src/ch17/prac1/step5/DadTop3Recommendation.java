package ch17.prac1.step5;

import ch17.prac1.data.GiftRepository;
import ch17.prac1.model.GiftItem;

import java.text.DecimalFormat;
import java.util.List;

public class DadTop3Recommendation {
    public static void run(){
        List<GiftItem> giftItemList = GiftRepository.getGifts();
        List<GiftItem> forDadList=giftItemList.stream().filter(gift->gift.isForDad()).toList();

//        forDadList=new ArrayList<>();
        if(forDadList.size()==0){
            System.out.println("😂 아빠를 위한 추천 선물이 없습니다.");
            return;
        }
        List<GiftItem> top3List=forDadList.stream().sorted((a,b)->Integer.compare(b.getPreferenceScore(),a.getPreferenceScore())).limit(3).toList();

        int maxPrice=top3List.stream().mapToInt(GiftItem::getPrice).max().getAsInt();
        int minPrice=top3List.stream().mapToInt(GiftItem::getPrice).min().getAsInt();

        System.out.println("🎁 아빠가 좋아하실 감동 추천 Top 3");
        DecimalFormat df=new DecimalFormat("#,###");
        for(int i=0;i<top3List.size();i++){
            GiftItem item=top3List.get(i);

            System.out.print((i+1)+". ["+item.getName()+"] - "+item.getCategory()+" / ₩"+df.format(item.getPrice())+"원 / 선호도: "+ item.getPreferenceScore()+"점 (");
            int starScore=item.getPreferenceScore()/20;

            String s="★";
            String repeat=s.repeat(starScore);
            System.out.print(repeat);

            String s2="☆";
            String repeat2=s2.repeat(5-starScore);
            System.out.print(repeat2);

            System.out.print(") ");

            if(item.getPrice()==maxPrice){
                System.out.println("💎");
            }else if(item.getPrice()==minPrice){
                System.out.println("💸");
            }else{
                System.out.println();
            }
        }

        double avgPref=top3List.stream().mapToInt(gift->gift.getPreferenceScore()).average().getAsDouble();
        double avg=top3List.stream().mapToInt(gift->gift.getPrice()).average().getAsDouble();

        System.out.println();
        System.out.println("📊 평균 선호도: "+ avgPref+"점");
        System.out.println("📊 평균 가격:  ₩"+ df.format(avg)+"원");
    }
}
