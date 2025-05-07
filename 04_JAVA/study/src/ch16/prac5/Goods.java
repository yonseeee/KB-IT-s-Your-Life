package ch16.prac5;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Goods {
    private String name;
    private int price;         // 정가
    private double discount;

    public double getDiscountedPrice(){
        return price*(1-discount);
    }
}
