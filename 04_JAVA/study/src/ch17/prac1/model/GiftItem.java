package ch17.prac1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GiftItem {
    private String name;
    private String category;
    private int price;
    private int preferenceScore; // 1~100
    private boolean forMom;
    private boolean forDad;
}
